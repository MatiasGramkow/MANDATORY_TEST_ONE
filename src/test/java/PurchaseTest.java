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
    void testIncrementNumberOfPhoneLines()
    {
        // Given
        int number = 150;
        // When
        int value = purchase.incrementNumberOfPhoneLines();
        // Then
        assertEquals(number, value);
    }

    @Test
    void testDecrementNumberOfPhoneLines()
    {
        // Given
        int number = -150;
        // When
        int value = purchase.decrementNumberOfPhoneLines();
        // Then
        assertEquals(number, value);
    }

    @Test
    void testSelectCellphone()
    {
        // Given
        String[] modelNames = {"IPhone 99", "Motorola G99", "Samsung Galaxy 99", "Sony Xperia 99", "Huawei 99","No Phone"};
        int[] prices = {6000,800,1000,900,900,0};

        for (int i = 0; i < prices.length; i++)
        {
            // When
            int value = purchase.selectCellphone(modelNames[i]);

            // Then
            assertEquals(prices[i],value);
        }
    }

    @Test
    void testUnselectCellphone()
    {
        // Given
        String[] modelNames = {"IPhone 99", "Motorola G99", "Samsung Galaxy 99", "Sony Xperia 99", "Huawei 99","No Phone"};
        int[] prices = {-6000,-800,-1000,-900,-900,0};

        for (int i = 0; i < prices.length; i++)
        {
            // When
            int value = purchase.unselectCellphone(modelNames[i]);

            // Then
            assertEquals(prices[i],value);
        }
    }

    @Test
    void testBuyingSomething()
    {
        // Given
        String[] modelNames = {"IPhone 99", "Motorola G99", "Samsung Galaxy 99", "Sony Xperia 99", "Huawei 99"};
        for (String modelName : modelNames)
        {
            purchase.selectCellphone(modelName);
        }

        // When
        String value = purchase.buying();

        // Then
        assertEquals("You have purchased " + purchase.getCellphones(), value);
    }
    @Test
    void testBuyingNothing()
    {
        // Given
        // Switch case go to default and return 0.
        purchase.selectCellphone("No Phone");

        // When
        String value = purchase.buying();

        // Then
        assertEquals("Please select one or more phones to continue", value);
    }
}