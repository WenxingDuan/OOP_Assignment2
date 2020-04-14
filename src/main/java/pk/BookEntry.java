package pk;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * class of a single book
 */

public class BookEntry {

    private String title;
    private String[] authors;
    private float rating;
    private String ISBN;
    private int pages;

    /**
     * @throws IllegalArgumentException if given page less than 0 or rating out of
     *                                  range
     * @throws NullPointerException     if the given argumentInput is null.
     */
    public BookEntry(String title, String[] authors, float rating, String ISBN, int pages) {

        Objects.requireNonNull(title, "Title connot be null");
        Objects.requireNonNull(authors, "authors connot be null");
        Objects.requireNonNull(rating, "rating connot be null");
        Objects.requireNonNull(ISBN, "ISBN connot be null");
        Objects.requireNonNull(pages, "pages connot be null");
        if (!(rating > 0 && rating < 5) || pages < 0) {
            throw new IllegalArgumentException();
        }
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

    /**
     * 
     * @param a inputed object
     * @return True is all data are equal
     */
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

    /**
     * @param hash hashcode
     * @return hashcode
     */

    public int hashCode() {
        int hash = 1;
        hash = hash * title.hashCode() * pages * (int) rating * ISBN.hashCode() * authors.hashCode();
        return hash;
    }

    /**
     * @return the String contain everything
     */
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
