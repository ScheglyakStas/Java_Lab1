package lab1;
public abstract class Food implements Consumable, Nutritious {

    String name = null;

    public Food(String name) {
        this.name = name;
    }

    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name == null || ((Food) arg0).name == null) return false; // Шаг 2
        return name.equals(((Food) arg0).name); // Шаг 3
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Food create_item(String[] parts, int x) {
        try {
            Class myClass = Class.forName(parts[x]);
            String[] param = new String[parts.length - 1 - x];
            for (int i = 0; i < parts.length - 1 - x; i++) {
                param[i] = parts[i + 1 + x];
            }
            Food result;
            result = (Food) myClass.getConstructor(myClass.getConstructors()[0].getParameterTypes()).newInstance(param);
            return result;

        } catch (ClassNotFoundException ex) {
            System.out.println("Введён несуществующий класс!");
            return null;
        } catch (NoSuchMethodException ex) {
            System.out.println("Введены неправильные параметры класса!");
            return null;
        } catch (InstantiationException ex) {
            return null;
        } catch (IllegalAccessException ex) {
            return null;
        } catch (java.lang.reflect.InvocationTargetException ex) {
            return null;
        }
    }
    // Реализация метода consume() удалена из базового класса Food
    // Это можно сделать, потому что сам Food - абстрактный

}