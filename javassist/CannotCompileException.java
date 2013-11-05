package javassist;

import javassist.compiler.CompileError;
/* loaded from: classes.dex */
public class CannotCompileException extends Exception {
    private String message;
    private Throwable myCause;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        if (this.myCause == this) {
            return null;
        }
        return this.myCause;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable initCause(Throwable th) {
        this.myCause = th;
        return this;
    }

    public String getReason() {
        return this.message != null ? this.message : toString();
    }

    public CannotCompileException(String str) {
        super(str);
        this.message = str;
        initCause(null);
    }

    public CannotCompileException(Throwable th) {
        super("by " + th.toString());
        this.message = null;
        initCause(th);
    }

    public CannotCompileException(String str, Throwable th) {
        this(str);
        initCause(th);
    }

    public CannotCompileException(NotFoundException notFoundException) {
        this("cannot find " + notFoundException.getMessage(), notFoundException);
    }

    public CannotCompileException(CompileError compileError) {
        this("[source error] " + compileError.getMessage(), compileError);
    }

    public CannotCompileException(ClassNotFoundException classNotFoundException, String str) {
        this("cannot find " + str, classNotFoundException);
    }

    public CannotCompileException(ClassFormatError classFormatError, String str) {
        this("invalid class format: " + str, classFormatError);
    }
}
