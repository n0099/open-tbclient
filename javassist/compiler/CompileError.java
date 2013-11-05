package javassist.compiler;

import javassist.CannotCompileException;
import javassist.NotFoundException;
/* loaded from: classes.dex */
public class CompileError extends Exception {
    private Lex lex;
    private String reason;

    public CompileError(String str, Lex lex) {
        this.reason = str;
        this.lex = lex;
    }

    public CompileError(String str) {
        this.reason = str;
        this.lex = null;
    }

    public CompileError(CannotCompileException cannotCompileException) {
        this(cannotCompileException.getReason());
    }

    public CompileError(NotFoundException notFoundException) {
        this("cannot find " + notFoundException.getMessage());
    }

    public Lex getLex() {
        return this.lex;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.reason;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "compile error: " + this.reason;
    }
}
