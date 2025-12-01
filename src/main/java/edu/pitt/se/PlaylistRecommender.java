package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list must not be null or empty");
        }

        double sum = 0.0;
        int count = 0;

        for (Integer bpm : bpms) {
            if (bpm == null) {
                throw new IllegalArgumentException("BPM values must not be null");
            }
            sum += bpm;
            count++;
        }

        double avg = sum / count;

        if (avg >= 140.0) {
            return "HIGH";
        } else if (avg >= 100.0) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null) {
            return false;
        }

        int len = title.length();
        if (len < 1 || len > 30) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            char c = title.charAt(i);
            if (Character.isLetter(c)) {
                continue;
            }
            if (c == ' ') {
                continue;
            }
            return false;
        }

        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0) {
            return 0;
        }
        if (volumeDb > 100) {
            return 100;
        }
        return volumeDb;
    }
}