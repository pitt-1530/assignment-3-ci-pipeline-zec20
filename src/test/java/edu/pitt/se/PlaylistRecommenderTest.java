package edu.pitt.se;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    @Test
    void testClassifyEnergyHigh() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(Arrays.asList(150, 160)));
    }

    @Test
    void testClassifyEnergyMedium() {
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(Arrays.asList(100, 120)));
    }

    @Test
    void testClassifyEnergyLow() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(Arrays.asList(80, 90)));
    }

    @Test
    void testClassifyEnergyNullList() {
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    void testClassifyEnergyEmptyList() {
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(Collections.emptyList()));
    }

    @Test
    void testValidTrackTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Hello World"));
    }

    @Test
    void testInvalidTrackTitleNull() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }

    @Test
    void testInvalidTrackTitleTooLong() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDE"));
    }

    @Test
    void testInvalidTrackTitleSpecialChars() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Song#1"));
    }

    @Test
    void testNormalizeVolumeWithinRange() {
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }

    @Test
    void testNormalizeVolumeBelowZero() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
    }

    @Test
    void testNormalizeVolumeAboveHundred() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));
    }
}