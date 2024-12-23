package lab1;
import java.util.Arrays;
import java.util.Comparator;
public class Main
{
    public static Food[] breakfast = new Food[20];
    public static boolean sort_needed;
    public static boolean count_needed;
    public static boolean calories_needed;
    public static Food counted_food;
    static public boolean check_calories (String arg)
    {
        return (arg.equals("-calories"));
    }
    static public boolean check_sort (String arg)
    {
        return (arg.equals("-sort"));
    }
    static public boolean check_count (String arg)
    {
        return (arg.equals("-count"));
    }
    static public void process_string(String arg,  int itemsSoFar)
    {
        sort_needed=check_sort(arg);
        calories_needed=check_calories(arg);
        if(!sort_needed&&!calories_needed)
        {
            String[] parts = arg.split("/");
            count_needed=check_count(parts[0]);
            //System.out.println("1");
            if(!count_needed)
            {
                breakfast[itemsSoFar]=Food.create_item(parts,0);
            }
            else
            {
                counted_food=Food.create_item(parts,1);
                count_needed = false;
            }
        }
    }
    static public void output_data()
    {
        int calories=0, counter=0;
        for (Food item: breakfast)
        {
            if (item!=null  && item.equals(counted_food))
            {
                counter++;
            }
            if (item != null)
            {
                if (calories_needed)
                    calories += item.calculateCalories();
                item.consume();
            }
            else break;
        }
        if(counted_food!=null)
        {
            System.out.println("Найдено " + counter + " продуктов с заданными параметрами.");
        }
        if(calories_needed)
            System.out.println("Суммарная калорийность: " + calories + " ккал.");
        System.out.println("Всего хорошего!");
    }
    public static void sort_food()
    {
        Arrays.sort(breakfast, new Comparator()
        {
            public int compare(Object f1, Object f2)
            {
                if(f1==null) return 1;
                if(f2==null) return -1;
                if(((Food)f1).calculateCalories()==((Food)f2).calculateCalories()) return 0;
                if(((Food)f1).calculateCalories()>((Food)f2).calculateCalories()) return -1;
                return 1;
            }
        });
    }
    public static void main(String[] args) throws Exception
    {

        counted_food=null;
        calories_needed=false;
        sort_needed=false;
        int itemsSoFar = 0;
        count_needed=false;
        for (String arg: args)
        {
            process_string(arg, itemsSoFar);
            if(!count_needed&&
                    breakfast[itemsSoFar]!=null&&
                    !arg.equals("-calories")&&
                    !arg.equals("-sort"))
            {
                itemsSoFar++;
            }
        }
        if(sort_needed)
        {
            sort_food();
        }
        output_data();
    }
}

