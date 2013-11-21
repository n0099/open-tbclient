package javassist.tools.reflect;

import javassist.CodeConverter;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.an;
import javassist.bytecode.i;
import javassist.c;
import javassist.h;
import javassist.w;
/* loaded from: classes.dex */
public class Reflection implements w {

    /* renamed from: a  reason: collision with root package name */
    protected CtMethod f2847a;
    protected CtMethod b;
    protected CtMethod c;
    protected CtMethod d;
    protected h[] e;
    protected c f = null;
    protected CodeConverter g = new CodeConverter();

    @Override // javassist.w
    public void a(c cVar) {
        this.f = cVar;
        try {
            h c = this.f.c("javassist.tools.reflect.Sample");
            a(c.g());
            this.f2847a = c.b("trap");
            this.b = c.b("trapStatic");
            this.c = c.b("trapRead");
            this.d = c.b("trapWrite");
            this.e = new h[]{this.f.c("java.lang.Object")};
        } catch (NotFoundException e) {
            throw new RuntimeException("javassist.tools.reflect.Sample is not found or broken.");
        } catch (BadBytecode e2) {
            throw new RuntimeException("javassist.tools.reflect.Sample is not found or broken.");
        }
    }

    @Override // javassist.w
    public void a(c cVar, String str) {
        cVar.c(str).a(this.g);
    }

    public void a(i iVar) {
        if (i.n >= 50) {
            for (an anVar : iVar.k()) {
                anVar.a(this.f);
            }
        }
    }
}
