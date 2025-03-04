package MyLibrary;

import java.util.Scanner;

class Main {

  static Scanner scan = new Scanner(System.in);
  static Library library = new Library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 1) {
        showBooks();
      } else if (selectedMenu == 2) {
        showMembers();
      } else if (selectedMenu == 3) {
        addMember();
      } else if (selectedMenu == 4) {
        borrowBook();
      } else if (selectedMenu == 5) {
        returnBook();
      } else if (selectedMenu == 6) {
        addBook();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue ? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add member");
    System.out.println("4. borrow book");
    System.out.println("5. return book");
    System.out.println("6. add book");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    Book book1 = new Book();
    book1.id = "1";
    book1.title = "Clean Code: A Handbook of Agile Software Craftsmanship";

    Book book2 = new Book();
    book2.id = "2";
    book2.title = "Design Patterns: Elements of Reusable Object-Oriented Software";

    Book book3 = new Book();
    book3.id = "3";
    book3.title = "Refactoring: Improving the Design of Existing Code";

    Member member1 = new Member();
    member1.id = "1";
    member1.name = "Ada Lovelace";

    Member member2 = new Member();
    member2.id = "2";
    member2.name = "Linus Torvalds";

    Member member3 = new Member();
    member3.id = "3";
    member3.name = "James Gosling";
    
    library.books.add(book1);
    library.books.add(book2);
    library.books.add(book3);

    library.members.add(member1);
    library.members.add(member2);
    library.members.add(member3);
  }

  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    return pilihan;
  }

  public static void showBooks() {
    for (Book book : library.books) {
      System.out.println(book.id + " " + book.title);
    }
  }

  public static void showMembers() {
    for (Member member : library.members) {
      System.out.println(member.id + " " + member.name);
    }
  }

  public static void addMember() {
    Member member = new Member();

    System.out.print("id : ");
    member.id = scan.next();

    System.out.print("name : ");
    member.name = scan.next();

    library.addMember(member);
  }

  public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook(memberId, bookId);
  }

  public static void returnBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.receiveBook(bookId, memberId);
  }

  public static void addBook() {
    Book book = new Book();

    System.out.print("id : ");
    book.id = scan.next();

    System.out.print("name : ");
    book.title = scan.next();

    library.addBook(book);
  }
}
