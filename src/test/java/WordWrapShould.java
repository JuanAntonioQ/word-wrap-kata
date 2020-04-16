import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
    TO DO LIST
    "", 1 -> ""
    null, 1 -> "" or exception
    "hola", 7 -> "hola"
    "hola", 2 -> "ho\nla"
    "hola mundo", 7 -> "hola\n mundo"
 */
public class WordWrapShould {
    @Test
    public void wrap () {
        assertThat(wordWrap(null, 7)).isEqualTo("");
        assertThat(wordWrap("hola", 10)).isEqualTo("hola");
        assertThat(wordWrap("hola", "hola".length())).isEqualTo("hola");
        assertThat(wordWrap("hola", 2)).isEqualTo("ho\nla");
        assertThat(wordWrap("hola mundo", 7)).isEqualTo("hola\nmundo");
        assertThat(wordWrap("abc def ghi", 3)).isEqualTo("abc\ndef\nghi");
        assertThat(wordWrap("abc def ghixxxyyy", 3)).isEqualTo("abc\ndef\nghi\nxxx\nyyy");
        assertThat(wordWrap("ohlala", 2)).isEqualTo("oh\nla\nla");
        assertThat(wordWrap("ohlalala", 2)).isEqualTo("oh\nla\nla\nla");
    }
    public String wordWrap(String aText, int columnsWidth){
        if (aText == null || aText.equals("")){
            return "";
        }
        if (aText.length() > columnsWidth){
            String wrappedLine = aText.substring(0, wrapIndex(aText, columnsWidth)) + "\n";
            String remainder = aText.substring(lastLineIndex(aText, columnsWidth));
            return wrappedLine + wordWrap(remainder, columnsWidth);
        }
        return aText;
    }
    private int wrapIndex(String aText, int columnsWidth){
        int indexOfSpace = aText.indexOf(" ");
        if(indexOfSpace != -1){
            return indexOfSpace;
        }
        return columnsWidth;

    }
    private int lastLineIndex(String aText, int columnsWidth){
        int indexOfSpace = aText.indexOf(" ");
        if(indexOfSpace != -1){
            return indexOfSpace + 1;
        }
        return columnsWidth;
    }
}
