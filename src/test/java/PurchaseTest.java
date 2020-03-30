import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest
{
    private Purchase purchase;

    @BeforeEach
    void setup()
    {
        this.purchase = new Purchase();
    }

    @ParameterizedTest
    void includeExcludeInternetConnection(boolean connection)
    {
        // Given
        boolean c = connection;
        ArrayList<Integer> expected = new ArrayList();
        expected.add(0);
        // When
        int c2 = purchase.includeExcludeInternetConnection(c);
        // Then
        assertEquals(200,c2);
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