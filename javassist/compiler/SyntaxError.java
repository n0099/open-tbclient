package javassist.compiler;
/* loaded from: classes.dex */
public class SyntaxError extends CompileError {
    public SyntaxError(Lex lex) {
        super("syntax error near \"" + lex.f() + "\"", lex);
    }
}
