package javassist.tools.reflect;

import javassist.c;
import javassist.u;
/* loaded from: classes.dex */
public class Loader extends u {
    protected Reflection b;

    public Loader() {
        a("javassist.tools.reflect.Loader");
        this.b = new Reflection();
        a(c.a(), this.b);
    }
}
