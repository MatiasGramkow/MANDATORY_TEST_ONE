import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest
{
    private Purchase purchase;

    @BeforeEach
    void setup()
    {
        this.purchase = new Purchase();
    }

    @Test
    void testIncludeExcludeInternetConnectionTrue()
    {
        // Given
        boolean connectionTrue = true;
        // When
        int value = purchase.includeExcludeInternetConnection(connectionTrue);
        // Then
        assertEquals(200, value);
    }

    @Test
    void testIncludeExcludeInternetConnectionFalse()
    {
        // Given
        boolean connectionFalse = false;
        // When
        int value = purchase.includeExcludeInternetConnection(connectionFalse);
        // Then
        assertEquals(0, value);
    }

    @Test
    void incrementNumberOfPhoneLines()
    {
        // Given
        // When
        // Then
    }

    @Test
    void decrementNumberOfPhoneLines()
    {
        // Given
        // When
        // Then
    }

    @Test
    void selectCellphone()
    {
        // Given
        // When
        // Then
    }

    @Test
    void unselectCellphone()
    {
        // Given
        // When
        // Then
    }

    @Test
    void buying()
    {
        // Given
        // When
        // Then
    }
}