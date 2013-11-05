package javassist.tools.web;
/* loaded from: classes.dex */
public class BadHttpRequest extends Exception {
    private Exception e;

    public BadHttpRequest() {
        this.e = null;
    }

    public BadHttpRequest(Exception exc) {
        this.e = exc;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.e == null ? super.toString() : this.e.toString();
    }
}
