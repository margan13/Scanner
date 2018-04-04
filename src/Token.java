class Token {

    enum TokenType {
        Digital, Whitespace, Plus, Minus, Multiply, Divide, Power, Backslash, Colon, Semicolon, Comma,
        LBracket, RBracket, LSquareBracket, RSquareBracket, LCurlyBracket, RCurlyBracket, Hash, LowerGreater, LowerEqual,
        GreaterEqual, At, Umpersant, QuestionMark, ExclamationMark, Underscore, Percent, Dollar, Apostrophe, QuotationMark,
        Equal, NotEqual, Variable, Double, Float, Integer, String, Char, For, While, Enter, Tab, Export, Private,
        Using, True, Bool, False, Namespace, Protected, Public, If, Const, Return, Else, Void,
        Auto, Struct, Switch, Case, Enum, Typedef, Short, Unsigned, Continue, Signed, Default, Goto,
        Sizeof, Do, Static, Try, Catch, New, Throw, Class, Cin, Cout
    }

    static TokenType stringToSymbol(String input) {
        if (Character.isDigit(input.charAt(0)) && input.length() == 1) return TokenType.Digital;
        if (input.equals(" ") && input.length() == 1) return TokenType.Whitespace;
        if (input.equals("\t")) return TokenType.Tab;
        if (input.equals("\n")) return TokenType.Enter;
        if (input.equals("+")) return TokenType.Plus;
        if (input.equals("-")) return TokenType.Minus;
        if (input.equals("_")) return TokenType.Underscore;
        if (input.equals("*")) return TokenType.Multiply;
        if (input.equals("/")) return TokenType.Divide;
        if (input.equals("^")) return TokenType.Power;
        if (input.equals(":")) return TokenType.Colon;
        if (input.equals(";")) return TokenType.Semicolon;
        if (input.equals(",")) return TokenType.Comma;
        if (input.equals("(")) return TokenType.LBracket;
        if (input.equals(")")) return TokenType.RBracket;
        if (input.equals("[")) return TokenType.LSquareBracket;
        if (input.equals("]")) return TokenType.RSquareBracket;
        if (input.equals("{")) return TokenType.LCurlyBracket;
        if (input.equals("}")) return TokenType.RCurlyBracket;
        if (input.equals("#")) return TokenType.Hash;
        if (input.equals("@")) return TokenType.At;
        if (input.equals("$")) return TokenType.Dollar;
        if (input.equals("&")) return TokenType.Umpersant;
        if (input.equals("?")) return TokenType.QuestionMark;
        if (input.equals("!")) return TokenType.ExclamationMark;
        if (input.equals("%")) return TokenType.Percent;
        if (input.equals("`")) return TokenType.Apostrophe;
        if (input.equals("=")) return TokenType.Equal;
        if (input.equals("<>")) return TokenType.LowerGreater;
        if (input.equals("<=")) return TokenType.LowerEqual;
        if (input.equals(">=")) return TokenType.GreaterEqual;
        if (input.equals("double")) return TokenType.Double;
        if (input.equals("float")) return TokenType.Float;
        if (input.equals("int")) return TokenType.Integer;
        if (input.equals("String")) return TokenType.String;
        if (input.equals("char")) return TokenType.Char;
        if (input.equals("for")) return TokenType.For;
        if (input.equals("while")) return TokenType.While;
        if (input.equals("export")) return TokenType.Export;
        if (input.equals("private")) return TokenType.Private;
        if (input.equals("public")) return TokenType.Public;
        if (input.equals("protected")) return TokenType.Protected;
        if (input.equals("using")) return TokenType.Using;
        if (input.equals("namespace")) return TokenType.Namespace;
        if (input.equals("return")) return TokenType.Return;
        if (input.equals("const")) return TokenType.Const;
        if (input.equals("void")) return TokenType.Void;
        if (input.equals("bool")) return TokenType.Bool;
        if (input.equals("true")) return TokenType.True;
        if (input.equals("false")) return TokenType.False;
        if (input.equals("if")) return TokenType.If;
        if (input.equals("else")) return TokenType.Else;
        if (input.equals("auto")) return TokenType.Auto;
        if (input.equals("struct")) return TokenType.Struct;
        if (input.equals("switch")) return TokenType.Switch;
        if (input.equals("case")) return TokenType.Case;
        if (input.equals("enum")) return TokenType.Enum;
        if (input.equals("typedef")) return TokenType.Typedef;
        if (input.equals("short")) return TokenType.Short;
        if (input.equals("unsigned")) return TokenType.Unsigned;
        if (input.equals("continue")) return TokenType.Continue;
        if (input.equals("signed")) return TokenType.Signed;
        if (input.equals("default")) return TokenType.Default;
        if (input.equals("goto")) return TokenType.Goto;
        if (input.equals("sizeof")) return TokenType.Sizeof;
        if (input.equals("do")) return TokenType.Do;
        if (input.equals("static")) return TokenType.Static;
        if (input.equals("try")) return TokenType.Try;
        if (input.equals("catch")) return TokenType.Catch;
        if (input.equals("new")) return TokenType.New;
        if (input.equals("throw")) return TokenType.Throw;
        if (input.equals("class")) return TokenType.Class;
        if (input.equals("<<")) return TokenType.Cout;
        if (input.equals(">>")) return TokenType.Cin;
        else return TokenType.NotEqual;
    }

    TokenType type;
    String value;

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    void add(String newValue) {
        value += newValue;
    }

    public TokenType getType() {
        return type;
    }

}