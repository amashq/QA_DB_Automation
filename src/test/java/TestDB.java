import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.utils.BeforeUtils;
import ru.tinkoff.hibernate.test.db.DBClient;
import ru.tinkoff.hibernate.test.db.model.Animal;
import ru.tinkoff.hibernate.test.db.model.Places;
import ru.tinkoff.hibernate.test.db.model.Workman;
import ru.tinkoff.hibernate.test.db.model.Zoo;

import java.util.ArrayList;
import java.util.List;

public class TestDB {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @Test
    public void checkCountAnimalTest() {
        long expectedResult = DBClient.getCountObjectByClass("animal");
        long actualResult = 10;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void animalInsert1to10IndexTest() {
        Animal animal = new Animal();
        for (int i = 1; i <= 10; i++) {
            animal.setId(i);
            Assertions.assertFalse(DBClient.create(animal));
        }
    }

    @Test
    public void createWorkmanWithNullableNameTest() {
        Workman workman = new Workman();
        workman.setName(null);
        Assertions.assertFalse(DBClient.create(workman));
    }

    @Test
    public void checkCountPlacesAfterInsertTest() {
        Places places = new Places();
        places.setPlaceNum(8);
        places.setName("Загон 8");
        DBClient.create(places);
        long expectedResult = DBClient.getCountObjectByClass("places");
        long actualResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void zooNamesTest() {
        List<String> expectedNameList = new ArrayList<>();
        List<String> actualNameList = new ArrayList<>();
        expectedNameList.add("Центральный");
        expectedNameList.add("Северный");
        expectedNameList.add("Западный");
        List<Zoo> zooList = DBClient.getListZoo();
        if (zooList.size() != 3) {
            Assertions.fail();
        }
        zooList.stream().forEach(zoo -> actualNameList.add(zoo.getName()));
        Assertions.assertIterableEquals(expectedNameList, actualNameList);
    }
}
