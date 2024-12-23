package lab1;
public class Cocktail extends Food
{

    // Новое внутреннее поле данных РАЗМЕР
    private String drink;
    private String fruit;

    public Cocktail(String drink, String fruit)
    {
        // Вызвать конструктор предка, передав ему имя класса
        super("Коктейль c ");
        // Инициализировать размер яблока
        this.drink = drink;
        this.fruit = fruit;
    }

    // Переопределить способ употребления яблока
    public void consume()
    {
        System.out.println(this + " выпит");
    }

    public int calculateCalories()
    {
        if(drink.equals("водка"))
            return 20;
        else
            return 40;
    }

    // Селектор для доступа к полю данных РАЗМЕР
    public String getDrink()
    {
        return drink;
    }

    // Модификатор для изменения поля данных РАЗМЕР
    public void setDrink(String drink)
    {
        this.drink = drink;
    }

    public String getFruit()
    {
        return fruit;
    }

    // Модификатор для изменения поля данных РАЗМЕР
    public void setFruit(String fruit)
    {
        this.fruit = fruit;
    }

    // Переопределѐнная версия метода equals(), которая при сравнении
    // учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3) 
    public boolean equals(Object arg0)
    {
        if (super.equals(arg0))
        { // Шаг 1
            if (!(arg0 instanceof Cocktail)){
                return false; // Шаг 2
            }
            return drink.equals(((Cocktail)arg0).drink) && fruit.equals(((Cocktail)arg0).fruit); // Шаг 3
        } else
            return false;
    }

    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер 
    public String toString() {
        return super.toString() + "напитком '" + drink.toUpperCase() + "' и фруктом '" + fruit.toUpperCase() + "'";
    }
}