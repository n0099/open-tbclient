package javassist;
/* loaded from: classes.dex */
public class NotFoundException extends Exception {
    public NotFoundException(String str) {
        super(str);
    }

    public NotFoundException(String str, Exception exc) {
        super(str + " because of " + exc.toString());
    }
}
