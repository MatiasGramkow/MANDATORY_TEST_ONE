import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest
{
    private Purchase purchase;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished tests");
    }

    @BeforeEach
    void setup()
    {
        this.purchase = new Purchase();
    }
    @AfterEach
    void afterEach() {
        System.out.println("Current Test Done");
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
    void testIncludeExcludeInternetConnectionFalseThenTrue() throws Exception
    {
        // Given
        boolean connectionFalse = false;
        purchase.setInternetConnection(true);
        purchase.setPrice(200);
        // When
        int value = purchase.includeExcludeInternetConnection(connectionFalse);
        // Then
        assertEquals(0, value);
    }

    @Test
    void testIncludeExcludeInternetConnectionFalseThenFalse()
    {
        // Given
        boolean connectionFalse = false;
        purchase.setInternetConnection(false);
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
    void testDecrementNumberOfPhoneLinesWithIncrementedPhoneLines()
    {
        // Given
        int number = 0;
        purchase.incrementNumberOfPhoneLines();
        // When
        int value = purchase.decrementNumberOfPhoneLines();
        // Then
        assertEquals(number, value);
    }

    @Test
    void testDecrementNumberOfPhoneLinesWithZeroPhoneLines()
    {
        // Given
        int number = 0;
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

        for (String modelName : modelNames)
        {
            // When
            int value = purchase.selectCellphone(modelName);
            // Then
            assertEquals(purchase.getPrice(), value);
        }
    }

    @Test
    void testUnselectCellphone()
    {
        // Given
        String[] modelNames = {"IPhone 99", "Motorola G99", "Samsung Galaxy 99", "Sony Xperia 99", "Huawei 99","No Phone"};

        for (String modelName : modelNames)
        {
            // When
            int value = purchase.unselectCellphone(modelName);

            // Then
            assertEquals(purchase.getPrice(), value);
        }
    }

    @Test
    void testUnselectCellphoneWithEmptyList()
    {
        // Given
        String modelNames = "IPhone 99";

        // When
        int value = purchase.unselectCellphone(modelNames);

        // Then
        assertEquals(purchase.getPrice(), value);

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
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void testLowerPriceBoundaryNegative(int Boundaries)
    {
        // Given
        int value = Boundaries;

        // When
        Executable executable = () -> purchase.setPrice(value);

        // Then
        assertThrows(Exception.class, executable);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testLowerPriceBoundaryPositive(int Boundaries) throws Exception
    {
        // Given
        int value = Boundaries;

        // When
        purchase.setPrice(value);

        // Then
        assertEquals(value, purchase.getPrice());
    }
}