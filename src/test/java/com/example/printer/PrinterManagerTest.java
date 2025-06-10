package com.example.printer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PrinterManager Singleton
 * These tests verify that the Singleton pattern is working correctly
 */
public class PrinterManagerTest {

    @Test
    @DisplayName("Should return the same instance when called multiple times")
    public void testSingletonBehavior() {
        // Arrange & Act
        PrinterManager manager1 = PrinterManager.getManager();
        PrinterManager manager2 = PrinterManager.getManager();
        PrinterManager manager3 = PrinterManager.getManager();

        // Assert
        assertSame(manager1, manager2, "manager1 and manager2 should be the same instance");
        assertSame(manager2, manager3, "manager2 and manager3 should be the same instance");
        assertSame(manager1, manager3, "manager1 and manager3 should be the same instance");
    }

    @Test
    @DisplayName("Should have same hash code for all instances")
    public void testHashCodeConsistency() {
        // Arrange & Act
        PrinterManager manager1 = PrinterManager.getManager();
        PrinterManager manager2 = PrinterManager.getManager();

        // Assert
        assertEquals(manager1.hashCode(), manager2.hashCode(),
                "Same singleton instance should have same hash code");
    }

    @Test
    @DisplayName("Should start with printer not busy")
    public void testInitialState() {
        // Arrange & Act
        PrinterManager manager = PrinterManager.getManager();

        // Assert
        assertFalse(manager.isPrinterBusy(), "Printer should not be busy initially");
        assertEquals("", manager.getCurrentJob(), "Current job should be empty initially");
    }
}