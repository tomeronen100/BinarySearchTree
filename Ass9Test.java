package assignment9;

import org.junit.*;

import static org.junit.Assert.*;

public class Ass9Test {

    @Test(timeout = 2000)
    public void bstSize_1P() {
        Map<String, Integer> map = new Map<>();
        assertTrue("successful add returns true", map.add("hello", 2));
        assertTrue("successful add returns true", map.add("world", 3));
        assertFalse("failed add returns false", map.add("world", 3));
        assertEquals("size is not correct after adding", 2, map.size());
    }

    @Test(timeout = 2000)
    public void bstContains_1P() {
        Map<String, Integer> map = new Map<>();
        assertTrue("successful add returns true", map.add("hello", 2));
        assertTrue("successful add returns true", map.add("world", 3));
        assertTrue("contains(hello) should return true", map.contains("hello"));
        assertTrue("contains(world) should return true", map.contains("world"));
        assertFalse("contains(sumo) should return false", map.contains("sumo"));
    }

    @Test(timeout = 2000)
    public void bstGet_1P() {
        Map<String, Integer> map = new Map<>();
        assertTrue("successful add returns true", map.add("hello", 2));
        assertTrue("successful add returns true", map.add("world", 3));
        assertEquals("get(hello) should return 2", 2, (int) map.get("hello"));
        assertEquals("get(world) should return 3", 3, (int) map.get("world"));
        assertNull("get(sumo) should return null", map.get("sumo"));
    }

    // MINE
    @Test
    public void testEmptyMap(){
        Map<String, Integer> map = new Map<>();
        assertNull("empty map should return null", map.get("hello"));
        assertEquals(map.size(), 0);
        assertFalse(map.contains("Some"));
    }
    @Test
    public void testMap(){
        Map<String, Integer> map = new Map<>();
        // Adding 20 values to the map
        for (int i = 1; i <= 20; i++) {
            assertTrue("successful add returns true", map.add("key" + i, i));
        }

        // Verify the size of the map
        assertEquals("size should be 20 after adding 20 values", 20, map.size());

        // Verify the entries
        for (int i = 1; i <= 20; i++) {
            String key = "key" + i;
            Integer value = map.get(key);
            assertTrue(map.contains(key));
            assertNotNull("value should not be null for key: " + key, value);
            assertEquals("value should match the added value for key: " + key, Integer.valueOf(i), value);
        }

    }

    @Test(timeout = 2000)
    public void testMapSize() {
        Map<Integer, String> map = new Map<>();
        assertTrue("successful add returns true", map.add(2, "two"));
        assertTrue("successful add returns true", map.add(1, "one"));
        assertEquals("size is not correct after adding", 2, map.size());
    }

    @Test(timeout = 2000)
    public void testMapAddAndGet() {
        Map<Integer, String> map = new Map<>();
        assertTrue("successful add returns true", map.add(2, "two"));
        assertEquals("get should return correct value", "two", map.get(2));
        assertNull("get should return null for non-existent key", map.get(3));
    }

    @Test(timeout = 2000)
    public void testMapContains() {
        Map<Integer, String> map = new Map<>();
        map.add(2, "two");
        map.add(3, "three");
        assertTrue("contains should return true for existing key", map.contains(2));
        assertTrue("contains should return true for existing key", map.contains(3));
        assertFalse("contains should return false for non-existent key", map.contains(1));
    }

    @Test(timeout = 2000)
    public void testMapAddDuplicateKeys() {
        Map<Integer, String> map = new Map<>();
        assertTrue("successful add returns true", map.add(5, "five"));
        assertFalse("adding duplicate key should return false", map.add(5, "five"));
        assertEquals("size should be 1 after adding duplicate key", 1, map.size());
        assertTrue("contains should return true for existing key", map.contains(5));
        assertEquals("get should return correct value", "five", map.get(5));
    }

    @Test(timeout = 2000)
    public void testMapComplexStructure() {
        Map<Integer, String> map = new Map<>();
        for (int i : new int[]{15, 10, 20, 8, 12, 17, 25}) {
            assertTrue("successful add returns true", map.add(i, String.valueOf(i)));
        }
        assertEquals("get should return correct value", "15", map.get(15));
        assertEquals("get should return correct value", "10", map.get(10));
        assertEquals("get should return correct value", "20", map.get(20));
        assertEquals("get should return correct value", "8", map.get(8));
        assertEquals("get should return correct value", "12", map.get(12));
        assertEquals("get should return correct value", "17", map.get(17));
        assertEquals("get should return correct value", "25", map.get(25));
    }

    @Test(timeout = 2000)
    public void testMapAddNullKey() {
        Map<Integer, String> map = new Map<>();
        assertFalse("adding null key should return false", map.add(null, "null"));
        assertEquals("size should be 0 after adding null key", 0, map.size());
    }

    @Test(timeout = 2000)
    public void testMapAddNullValue() {
        Map<Integer, String> map = new Map<>();
        assertFalse("successful add returns true", map.add(1, null));
        assertEquals("size should be 1 after adding key with null value", 0, map.size());
        assertFalse("contains should return true for existing key", map.contains(1));
        assertNull("get should return null value for existing key", map.get(1));
    }

    @Test(timeout = 2000)
    public void testMapMultipleTypes() {
        Map<Integer, String> intMap = new Map<>();
        Map<Double, String> doubleMap = new Map<>();
        Map<String, String> stringMap = new Map<>();

        assertTrue("successful add returns true", intMap.add(1, "one"));
        assertTrue("successful add returns true", doubleMap.add(1.1, "one.one"));
        assertTrue("successful add returns true", stringMap.add("one", "one"));

        assertEquals("get should return correct value", "one", intMap.get(1));
        assertEquals("get should return correct value", "one.one", doubleMap.get(1.1));
        assertEquals("get should return correct value", "one", stringMap.get("one"));
    }

    @Test(timeout = 2000)
    public void testMapEmpty() {
        Map<Integer, String> map = new Map<>();
        assertEquals(map.size(), 0);
        assertFalse(map.contains(null));
        assertNull(map.get(null));
        assertFalse(map.contains(2));
        assertNull(map.get(1));
        assertFalse(map.add(null, "null"));
        assertFalse(map.add(2, null));
    }

    @Test(timeout = 2000)
    public void testMapAddAndGetComplexObjects() {
        Map<Student, String> map = new Map<>();
        Student s1 = new Student("Daniel", 10);
        Student s2 = new Student("Yarin", 120);
        assertTrue("successful add returns true", map.add(s1, "Student1"));
        assertTrue("successful add returns true", map.add(s2, "Student2"));

        assertEquals("get should return correct value", "Student1", map.get(s1));
        assertEquals("get should return correct value", "Student2", map.get(s2));
        assertNull("get should return null for non-existent key", map.get(new Student("ABC", 30)));
    }
    public class Student implements Comparable<Student> {
        private String name;
        private int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        @Override
        public int compareTo(Student o) {
            if (o == null) return 1;
            return this.age - o.age;
        }
    }

    @Test(timeout = 2000)
    public void testStudentAsKey() {
        Map<Student, String> map = new Map<>();

        // Adding 15 Students as keys
        for (int i = 1; i <= 15; i++) {
            Student student = new Student("Student" + i, i * 2);
            assertTrue("successful add returns true", map.add(student, "Student" + i));
        }

        // Verify the size of the map
        assertEquals("size should be 15 after adding 15 students", 15, map.size());

        // Verify the entries
        for (int i = 1; i <= 15; i++) {
            Student student = new Student("Student" + i, i * 2);
            assertEquals("get should return correct value", "Student" + i, map.get(student));
        }

        // Check contains
        for (int i = 1; i <= 15; i++) {
            Student student = new Student("Student" + i, i * 2);
            assertTrue("contains should return true for existing key", map.contains(student));
        }

        // Check non-existent key
        Student nonExistentStudent = new Student("NonExistent", 100);
        assertFalse("contains should return false for non-existent key", map.contains(nonExistentStudent));
        assertNull("get should return null for non-existent key", map.get(nonExistentStudent));
    }

    @Test(timeout = 2000)
    public void testStudentAsValue() {
        Map<String, Student> map = new Map<>();
        // Adding 15 Students as values
        for (int i = 1; i <= 15; i++) {
            Student student = new Student("Student" + i, i * 2);
            assertTrue("successful add returns true", map.add("key" + i, student));
        }
        // Verify the size of the ma
        assertEquals("size should be 15 after adding 15 students", 15, map.size());
        // Verify the entries
        for (int i = 1; i <= 15; i++) {
            Student expectedStudent = new Student("Student" + i, i * 2);
            assertTrue("get should return correct value", map.contains("key" + i));
        }
        // Check contains
        for (int i = 1; i <= 15; i++) {
            assertTrue("contains should return true for existing key", map.contains("key" + i));
        }
        // Check non-existent key
        assertFalse("contains should return false for non-existent key", map.contains("key16"));
        assertNull("get should return null for non-existent key", map.get("key16"));

        Student expectedStudent = new Student("Ron", 25);
        assertTrue(map.add("FDC", expectedStudent));
        assertEquals("get should return correct value", expectedStudent, map.get("FDC"));
    }
}
