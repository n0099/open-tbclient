package org.msgpack.template.builder;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.h;
import org.msgpack.template.AbstractTemplate;
/* loaded from: classes.dex */
public class JavassistTemplateBuilder extends AbstractTemplateBuilder {
    private static Logger e = Logger.getLogger(JavassistTemplateBuilder.class.getName());
    protected javassist.c b;
    protected int c;
    protected ClassLoader d;

    /* loaded from: classes.dex */
    public abstract class JavassistTemplate<T> extends AbstractTemplate<T> {
    }

    @Override // org.msgpack.template.builder.f
    public boolean b(Type type, boolean z) {
        Class cls = (Class) type;
        boolean a2 = a((Class<?>) cls, z);
        if (a2 && e.isLoggable(Level.FINE)) {
            e.fine("matched type: " + cls.getName());
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(String str) {
        return this.b.g(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h b(String str) {
        return this.b.c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        int i = this.c;
        this.c = i + 1;
        return i;
    }

    protected b a() {
        return new DefaultBuildContext(this);
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder
    public <T> org.msgpack.template.d<T> a(Class<T> cls, c[] cVarArr) {
        return a().b(cls, cVarArr, a(cVarArr));
    }

    private org.msgpack.template.d<?>[] a(c[] cVarArr) {
        org.msgpack.template.d<?>[] dVarArr = new org.msgpack.template.d[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            c cVar = cVarArr[i];
            if (!cVar.g()) {
                dVarArr[i] = null;
            } else {
                dVarArr[i] = this.f2919a.a(cVar.f());
            }
        }
        return dVarArr;
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder, org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> b(Type type) {
        Class<?> cls = (Class) type;
        try {
            String str = String.valueOf(cls.getName()) + "_$$_Template";
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                classLoader.loadClass(str);
                c[] a2 = a(cls, b(cls));
                return a().a(cls, a2, a(a2));
            }
            return null;
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader c() {
        return this.d;
    }
}
