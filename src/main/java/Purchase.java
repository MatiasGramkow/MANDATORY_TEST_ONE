import java.util.ArrayList;

public class Purchase
{
    boolean internetConnection;
    int phoneLines, price;

    private ArrayList<String> cellphones;

    public Purchase()
    {
        cellphones = new ArrayList<>();
    }

    public ArrayList<String> getCellphones()
    {
        return cellphones;
    }

    public void setInternetConnection(boolean internetConnection)
    {
        this.internetConnection = internetConnection;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price) throws Exception
    {
        if (price < 0)
        {
            throw new Exception("Value less than 0");
        }
        else
        {
            this.price = price;
        }
    }



    public int includeExcludeInternetConnection(boolean connection)
    {
        if (connection)
        {
            internetConnection = connection;
            return price += 200;
        }
        else
        {
            if (internetConnection && price >= 200)
            {
                internetConnection = connection;
                return price -= 200;
            }
            else
            {
                return price;
            }

        }
    }

    public int incrementNumberOfPhoneLines()
    {
        phoneLines++;
        return price += 150;
    }

    public int decrementNumberOfPhoneLines()
    {
        if (phoneLines == 0)
        {
            return price;
        }
        else
        {
            phoneLines--;
            return price -= 150;
        }
    }

    public int selectCellphone(String modelName)
    {
        switch (modelName)
        {
            case "IPhone 99":
                cellphones.add("IPhone 99");
                return price += 6000;
            case "Motorola G99":
                cellphones.add("Motorola G99");
                return price += 800;
            case "Samsung Galaxy 99":
                cellphones.add("Samsung Galaxy 99");
                return price += 1000;
            case "Sony Xperia 99":
                cellphones.add("Sony Xperia 99");
                return price += 900;
            case "Huawei 99":
                cellphones.add("Huawei 99");
                return price += 900;
            default:
                return price;
        }
    }

    public int unselectCellphone(String modelName)
    {
        if (cellphones.contains(modelName))
        {
            switch (modelName)
            {
                case "IPhone 99":
                    cellphones.remove("IPhone 99");
                    return price -= 6000;
                case "Motorola G99":
                    cellphones.remove("Motorola G99");
                    return price -= 800;
                case "Samsung Galaxy 99":
                    cellphones.remove("Samsung Galaxy 99");
                    return price -= 1000;
                case "Sony Xperia 99":
                    cellphones.remove("Sony Xperia 99");
                    return price -= 900;
                case "Huawei 99":
                    cellphones.remove("Huawei 99");
                    return price -= 900;
                default:
                    return price;
            }
        }
        return price;
    }

    public String buying()
    {
        if (cellphones.isEmpty())
        {
            return "Please select one or more phones to continue";
        }
        else
        {
            return "You have purchased " + cellphones;
        }
    }
}
