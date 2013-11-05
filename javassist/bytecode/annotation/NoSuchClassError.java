package javassist.bytecode.annotation;
/* loaded from: classes.dex */
public class NoSuchClassError extends Error {
    private String className;

    public NoSuchClassError(String str, Error error) {
        super(error.toString(), error);
        this.className = str;
    }

    public String getClassName() {
        return this.className;
    }
}
