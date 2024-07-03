package Bai3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    private static final int MAX_THREADS = 6;

    public static void main(String[] args) {
        String folderPath = "D:\\IdeaProjects\\BaiTapPhan1\\input_3";
        List<File> files = listFiles(folderPath);

        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        for (File file : files) {
            Callable<Map<String, Integer>> task = new WordCountTask(file);
            futures.add(executor.submit(task));
        }

        executor.shutdown();

        List<Map<String, Integer>> results = new ArrayList<>();

        for (Future<Map<String, Integer>> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        Map<String, Integer> totalCounts = new HashMap<>();

        for (Map<String, Integer> result : results) {
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();
                totalCounts.put(word, totalCounts.getOrDefault(word, 0) + count);
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(totalCounts.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("Top 10 most frequent words:");

        for (int i = 0; i < 10 && i < sortedEntries.size(); i++) {
            System.out.println(sortedEntries.get(i).getKey() + ": " + sortedEntries.get(i).getValue());
        }

        sortedEntries.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));

        System.out.println("\nTop 10 least frequent words:");

        for (int i = 0; i < 10 && i < sortedEntries.size(); i++) {
            System.out.println(sortedEntries.get(i).getKey() + ": " + sortedEntries.get(i).getValue());
        }
    }

    private static List<File> listFiles(String folderPath) {
        File folder = new File(folderPath);
        List<File> files = new ArrayList<>();

        if (folder.isDirectory()) {
            File[] fileList = folder.listFiles();

            if (fileList != null) {
                for (File file : fileList) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        files.add(file);
                    }
                }
            }
        }

        return files;
    }

    static class WordCountTask implements Callable<Map<String, Integer>> {
        private final File file;

        WordCountTask(File file) {
            this.file = file;
        }

        @Override
        public Map<String, Integer> call() {
            Map<String, Integer> wordCountMap = new HashMap<>();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line," .,!=+-");

                    while (st.hasMoreTokens()){
                        String token = st.nextToken();

                        wordCountMap.put(token, wordCountMap.getOrDefault(token, 0) + 1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return wordCountMap;
        }
    }
}
