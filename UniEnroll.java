import java.util.Scanner;
import java.util.HashMap;

class CourseFullEx extends Exception {
    public CourseFullEx(String msg) {
        super(msg);
    }
}

class PrereqEx extends Exception {
    public PrereqEx(String msg) {
        super(msg);
    }
}

class UniEnroll {
    private static final int MAX_SEATS = 2;
    private static HashMap<String, Integer> seats = new HashMap<>();
    private static HashMap<String, String> prereq = new HashMap<>();

    static {
        seats.put("Advanced Java", MAX_SEATS);
        prereq.put("Advanced Java", "Core Java");
    }

    public static void enroll(String course, boolean hasPrereq) throws CourseFullEx, PrereqEx {
        if (prereq.containsKey(course) && !hasPrereq) {
            throw new PrereqEx("Error: Complete " + prereq.get(course) + " before enrolling in " + course + ".");
        }

        if (seats.getOrDefault(course, 0) == 0) {
            throw new CourseFullEx("Error: Course is full. No seats available.");
        }

        seats.put(course, seats.get(course) - 1);
        System.out.println("Enrollment successful! Seats left: " + seats.get(course));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String course = sc.nextLine();

            System.out.print("Prerequisite Completed? (yes/no): ");
            boolean hasPrereq = sc.nextLine().equalsIgnoreCase("yes");

            enroll(course, hasPrereq);

        } catch (CourseFullEx | PrereqEx e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
        } finally {
            sc.close();
        }
    }
}
