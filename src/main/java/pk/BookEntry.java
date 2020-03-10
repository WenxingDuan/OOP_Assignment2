package pk;

import java.text.DecimalFormat;

/**
 * Immutable class encapsulating data for a single book entry.
 */
public class BookEntry {
    private String title;
    private String[] authors;
    private float rating;
    private String ISBN;
    private int pages;

    public BookEntry(String title, String[] authors, float rating, String ISBN, int pages) {
        this.title = title;
        this.authors = authors;
        this.rating = rating;
        this.ISBN = ISBN;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public float getRating() {
        return rating;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPages() {
        return pages;
    }

    public boolean equals(BookEntry a) {
        if (a == null) {
            return false;
        }
        boolean flag = a.getISBN().equals(this.ISBN) && a.getAuthors().equals(this.authors)
                && a.getPages() == this.pages && a.getRating() == this.rating && a.getTitle().equals(this.title);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hash = 1;
        hash = hash * title.hashCode() * pages * (int) rating * ISBN.hashCode() * authors.hashCode();
        return hash;
    }

    public String toString() {
        String returnString;
        returnString = title;
        String authorName = "";
        for (int i = 0; i < authors.length - 1; i++) {
            authorName = authorName + authors[i] + ", ";
        }
        authorName = authorName + authors[authors.length - 1];

        returnString = returnString + "\nby " + authorName;
        DecimalFormat df = new DecimalFormat(".00");
        returnString = returnString + "\nRating: " + df.format(rating);
        returnString = returnString + "\nISBN: " + ISBN;
        returnString = returnString + "\n" + pages + " pages";
        return returnString;
    }

}
