package org.msgpack.template.builder;

import java.io.IOException;
import java.util.logging.Logger;
import javassist.h;
import javassist.q;
import org.msgpack.MessageTypeException;
import org.msgpack.template.builder.c;
import org.msgpack.unpacker.k;
/* loaded from: classes.dex */
public abstract class b<T extends c> {

    /* renamed from: a  reason: collision with root package name */
    private static Logger f2895a = Logger.getLogger(b.class.getName());
    protected JavassistTemplateBuilder e;
    protected h f;
    protected StringBuilder g = null;

    protected abstract org.msgpack.template.d a(Class<?> cls);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract org.msgpack.template.d a(Class<?> cls, T[] tArr, org.msgpack.template.d[] dVarArr);

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract org.msgpack.template.d b(Class<?> cls, T[] tArr, org.msgpack.template.d[] dVarArr);

    protected abstract void b();

    protected abstract String d();

    protected abstract String e();

    public b(JavassistTemplateBuilder javassistTemplateBuilder) {
        this.e = javassistTemplateBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public org.msgpack.template.d a(String str) {
        try {
            a(str, false);
            f2895a.fine(String.format("started generating template class %s for original class %s", this.f.n(), str));
            f();
            b();
            c();
            g();
            h();
            f2895a.fine(String.format("finished generating template class %s for original class %s", this.f.n(), str));
            return a(i());
        } catch (Exception e) {
            String k = k();
            if (k != null) {
                f2895a.severe("builder: " + k);
                throw new TemplateBuildException("Cannot compile: " + k, e);
            }
            throw new TemplateBuildException(e);
        }
    }

    protected void a(String str, boolean z) {
        String str2;
        if (!z) {
            str2 = String.valueOf(str) + "_$$_Template_" + this.e.hashCode() + "_" + this.e.b();
        } else {
            str2 = String.valueOf(str) + "_$$_Template";
        }
        this.f = this.e.a(str2);
    }

    protected void f() {
        a();
        this.f.d(this.e.b(org.msgpack.template.d.class.getName()));
    }

    protected void c() {
    }

    protected void g() {
        f2895a.fine(String.format("started generating write method in template class %s", this.f.n()));
        String d = d();
        h hVar = h.l;
        h[] hVarArr = {this.e.b(org.msgpack.packer.a.class.getName()), this.e.b(Object.class.getName()), h.d};
        h[] hVarArr2 = {this.e.b(IOException.class.getName())};
        f2895a.fine(String.format("compiling write method body: %s", d));
        this.f.a(q.a(1, hVar, "write", hVarArr, hVarArr2, d, this.f));
        f2895a.fine(String.format("finished generating write method in template class %s", this.f.n()));
    }

    protected void h() {
        f2895a.fine(String.format("started generating read method in template class %s", this.f.n()));
        String e = e();
        h b = this.e.b(Object.class.getName());
        h[] hVarArr = {this.e.b(k.class.getName()), this.e.b(Object.class.getName()), h.d};
        h[] hVarArr2 = {this.e.b(MessageTypeException.class.getName())};
        f2895a.fine(String.format("compiling read method body: %s", e));
        this.f.a(q.a(1, b, "read", hVarArr, hVarArr2, e, this.f));
        f2895a.fine(String.format("finished generating read method in template class %s", this.f.n()));
    }

    protected Class<?> i() {
        return this.f.a(this.e.c(), getClass().getProtectionDomain());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.g = new StringBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        this.g.append(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object... objArr) {
        this.g.append(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        if (this.g == null) {
            return null;
        }
        return this.g.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(Class<?> cls) {
        return "write";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return "readBoolean";
        }
        if (cls == Byte.TYPE) {
            return "readByte";
        }
        if (cls == Short.TYPE) {
            return "readShort";
        }
        if (cls == Integer.TYPE) {
            return "readInt";
        }
        if (cls == Long.TYPE) {
            return "readLong";
        }
        if (cls == Float.TYPE) {
            return "readFloat";
        }
        if (cls == Double.TYPE) {
            return "readDouble";
        }
        if (cls == Character.TYPE) {
            return "readInt";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public org.msgpack.template.d c(String str) {
        try {
            return a(getClass().getClassLoader().loadClass(String.valueOf(str) + "_$$_Template"));
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Exception e2) {
            String k = k();
            if (k != null) {
                f2895a.severe("builder: " + k);
                throw new TemplateBuildException("Cannot compile: " + k, e2);
            }
            throw new TemplateBuildException(e2);
        }
    }
}
