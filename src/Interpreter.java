import java.util.LinkedList;
import java.util.List;

public class Interpreter {
    String text;
    List<Token> tokens = new LinkedList<Token>();

    Interpreter(String init) {
        this.text = init;
    }

    String interpret() {
        int i = 0;
        while (i < text.length()) {
            if (Token.stringToSymbol(String.valueOf(text.charAt(i))) == Token.TokenType.NotEqual) {
                if (i < text.length() - 1 && Token.stringToSymbol(String.valueOf(text.charAt(i + 1))) == Token.TokenType.Whitespace) {
                    tokens.add(new Token(Token.TokenType.Variable, String.valueOf(text.charAt(i))));
                } else {
                    String tmp = String.valueOf(text.charAt(i));
                    i++;
                    while (Token.stringToSymbol(String.valueOf(text.charAt(i))) == Token.TokenType.NotEqual || Token.stringToSymbol(String.valueOf(text.charAt(i))) == Token.TokenType.Digital) {
                        tmp += String.valueOf(text.charAt(i));
                        i++;
                    }
                    i--;
                    if (Token.stringToSymbol(tmp).equals(Token.TokenType.NotEqual)) {
                        tokens.add(new Token(Token.TokenType.Variable, tmp));
                    } else {
                        tokens.add(new Token(Token.stringToSymbol(tmp), tmp));
                    }
                }
            } else if (tokens.isEmpty() && Token.stringToSymbol(String.valueOf(text.charAt(i))) != Token.TokenType.Whitespace) {
                tokens.add(new Token(Token.stringToSymbol(String.valueOf(text.charAt(i))), String.valueOf(text.charAt(i))));
            } else if (Token.stringToSymbol(String.valueOf(text.charAt(i))) != Token.TokenType.Whitespace) {
                if (tokens.get(tokens.size() - 1).type == Token.stringToSymbol(String.valueOf(text.charAt(i)))) {
                    tokens.get(tokens.size() - 1).add(String.valueOf(text.charAt(i)));
                } else {
                    tokens.add(new Token(Token.stringToSymbol(String.valueOf(text.charAt(i))), String.valueOf(text.charAt(i))));
                }
            }
            i++;
        }

        String html = "<html><body><div>";
        for (Token token : tokens) {
            html += "<font color=\"" + getColor(token.getType()) + "\">" + whitespaces(token.getType()) + (token.value) + " " + "</font>";
        }
        html += "</div></body></html>";

        return html;
    }

    private static String getColor(Token.TokenType type) {
        String stringType = type.toString();
        if (stringType.equals("For") || stringType.equals("While") || stringType.equals("Return")
                || stringType.equals("Cout") || stringType.equals("Cin")) {
            return "red";
        } else if (stringType.equals("Double") || stringType.equals("Integer") || stringType.equals("Char") ||
                stringType.equals("String") || stringType.equals("Float") || stringType.equals("Bool")) {
            return "orange";
        } else if (stringType.equals("Variable")) {
            return "#8d249e";
        } else if (stringType.equals("Equal") || stringType.equals("LowerGreater") || stringType.equals("LowerEqual")
                || stringType.equals("GreaterEqual") || stringType.equals("NotEqual") || stringType.equals("Plus")
                || stringType.equals("Minus") || stringType.equals("Power") || stringType.equals("Divide") || stringType.equals("Multiply")) {
            return "#green";
        } else {
            return "#5282ce";
        }
    }

    public static String whitespaces(Token.TokenType type) {
        switch (type) {
            case Tab:
                return "&nbsp;&nbsp;";
            case Whitespace:
                return "&nbsp;";
            case Enter:
                return "</br>";
        }
        return "";
    }
}
