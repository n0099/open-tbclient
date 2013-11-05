package javassist.bytecode;
/* loaded from: classes.dex */
public class BadBytecode extends Exception {
    public BadBytecode(int i) {
        super("bytecode " + i);
    }

    public BadBytecode(String str) {
        super(str);
    }

    public BadBytecode(String str, Throwable th) {
        super(str, th);
    }

    public BadBytecode(an anVar, Throwable th) {
        super(anVar.toString() + " in " + anVar.c().a() + ": " + th.getMessage(), th);
    }
}
