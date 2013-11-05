package javassist.tools.rmi;

import java.util.Hashtable;
import javassist.CtMethod;
import javassist.c;
import javassist.h;
import javassist.w;
/* loaded from: classes.dex */
public class StubGenerator implements w {

    /* renamed from: a  reason: collision with root package name */
    private c f2818a;
    private Hashtable b = new Hashtable();
    private CtMethod c;
    private CtMethod d;
    private h[] e;
    private h[] f;
    private h[] g;

    @Override // javassist.w
    public void a(c cVar) {
        this.f2818a = cVar;
        h c = cVar.c("javassist.tools.rmi.Sample");
        this.c = c.b("forward");
        this.d = c.b("forwardStatic");
        this.e = cVar.a(new String[]{"javassist.tools.rmi.ObjectImporter", "int"});
        this.f = cVar.a(new String[]{"java.io.Serializable", "javassist.tools.rmi.Proxy"});
        this.g = new h[]{cVar.c("javassist.tools.rmi.RemoteException")};
    }

    @Override // javassist.w
    public void a(c cVar, String str) {
    }
}
