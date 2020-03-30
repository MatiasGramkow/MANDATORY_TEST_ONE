import java.util.ArrayList;

public class Purchase
{
    boolean internetConnection;
    int phoneLines, price;
    String message;

    private ArrayList<String> cellphones;

    public Purchase()
    {
        cellphones = new ArrayList<>();
    }

    public int includeExcludeInternetConnection(boolean connection)
    {
        if (connection)
        {
            return 200;
        }
        else
        {
            return 0;
        }
    }

    public int incrementNumberOfPhoneLines()
    {
        return 150;
    }

    public int decrementNumberOfPhoneLines()
    {
        return -150;
    }

    public int selectCellphone(String modelName)
    {
        switch (modelName)
        {
            case "IPhone 99":
                cellphones.add("IPhone 99");
                return 6000;
            case "Motorola G99":
                cellphones.add("Motorola G99");
                return 800;
            case "Samsung Galaxy 99":
                cellphones.add("Samsung Galaxy 99");
                return 1000;
            case "Sony Xperia 99":
                cellphones.add("Sony Xperia 99");
                return 900;
            case "Huawei 99":
                cellphones.add("Huawei 99");
                return 900;
            default:
                return 0;
        }
    }

    public int unselectCellphone(String modelName)
    {
        switch (modelName)
        {
            case "IPhone 99":
                cellphones.remove("IPhone 99");
                return -6000;
            case "Motorola G99":
                cellphones.remove("Motorola G99");
                return -800;
            case "Samsung Galaxy 99":
                cellphones.remove("Samsung Galaxy 99");
                return -1000;
            case "Sony Xperia 99":
                cellphones.remove("Sony Xperia 99");
                return -900;
            case "Huawei 99":
                cellphones.remove("Huawei 99");
                return -900;
            default:
                return 0;
        }
    }

    public String buying()
    {
        if (cellphones.isEmpty())
        {
            return  "Please select one or more phones to continue";
        }
        else
        {
            return "You have purchased " + cellphones;
        }
    }
}
