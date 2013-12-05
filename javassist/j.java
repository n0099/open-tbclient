package javassist;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.List;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.EnclosingMethodAttribute;
import javassist.bytecode.InnerClassesAttribute;
import javassist.bytecode.ad;
import javassist.bytecode.an;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends h {

    /* renamed from: a  reason: collision with root package name */
    c f3022a;
    boolean n;
    boolean o;
    boolean p;
    javassist.bytecode.i q;
    byte[] r;
    private boolean s;
    private WeakReference t;
    private javassist.compiler.a u;
    private t v;
    private Hashtable w;
    private int x;
    private boolean y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, c cVar) {
        super(str);
        this.y = c.b;
        this.f3022a = cVar;
        this.p = false;
        this.o = false;
        this.s = false;
        this.n = false;
        this.q = null;
        this.r = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0;
        this.z = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.h
    public void a(StringBuffer stringBuffer) {
        if (this.n) {
            stringBuffer.append("changed ");
        }
        if (this.s) {
            stringBuffer.append("frozen ");
        }
        if (this.o) {
            stringBuffer.append("pruned ");
        }
        stringBuffer.append(v.h(c()));
        stringBuffer.append(" class ");
        stringBuffer.append(n());
        try {
            h f = f();
            if (f != null && !f.n().equals("java.lang.Object")) {
                stringBuffer.append(" extends " + f.n());
            }
        } catch (NotFoundException e) {
            stringBuffer.append(" extends ??");
        }
        try {
            h[] d = d();
            if (d.length > 0) {
                stringBuffer.append(" implements ");
            }
            for (h hVar : d) {
                stringBuffer.append(hVar.n());
                stringBuffer.append(", ");
            }
        } catch (NotFoundException e2) {
            stringBuffer.append(" extends ??");
        }
        m z = z();
        a(stringBuffer, " fields=", z.h(), z.k());
        a(stringBuffer, " constructors=", z.f(), z.g());
        a(stringBuffer, " methods=", z.a(), z.d());
    }

    private void a(StringBuffer stringBuffer, String str, l lVar, l lVar2) {
        stringBuffer.append(str);
        while (lVar != lVar2) {
            lVar = lVar.j();
            stringBuffer.append(lVar);
            stringBuffer.append(", ");
        }
    }

    @Override // javassist.h
    public javassist.compiler.a i() {
        if (this.u == null) {
            this.u = new javassist.compiler.a(this);
        }
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4, 212=4] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // javassist.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public javassist.bytecode.i h() {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        javassist.bytecode.i iVar = this.q;
        if (iVar != null) {
            return iVar;
        }
        this.f3022a.b();
        try {
            if (this.r != null) {
                try {
                    this.q = new javassist.bytecode.i(new DataInputStream(new ByteArrayInputStream(this.r)));
                    this.r = null;
                    this.z = 2;
                    return this.q;
                } catch (IOException e) {
                    throw new RuntimeException(e.toString(), e);
                }
            }
            try {
                try {
                    InputStream f = this.f3022a.f(n());
                    try {
                        if (f == null) {
                            throw new NotFoundException(n());
                        }
                        BufferedInputStream bufferedInputStream3 = new BufferedInputStream(f);
                        try {
                            javassist.bytecode.i iVar2 = new javassist.bytecode.i(new DataInputStream(bufferedInputStream3));
                            if (iVar2.f().equals(this.b)) {
                                this.q = iVar2;
                                if (bufferedInputStream3 != null) {
                                    try {
                                        bufferedInputStream3.close();
                                        return iVar2;
                                    } catch (IOException e2) {
                                        return iVar2;
                                    }
                                }
                                return iVar2;
                            }
                            throw new RuntimeException("cannot find " + this.b + ": " + iVar2.f() + " found in " + this.b.replace('.', '/') + ".class");
                        } catch (IOException e3) {
                            e = e3;
                            throw new RuntimeException(e.toString(), e);
                        } catch (NotFoundException e4) {
                            e = e4;
                            bufferedInputStream2 = bufferedInputStream3;
                            try {
                                throw new RuntimeException(e.toString(), e);
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = f;
                        if (bufferedInputStream != null) {
                        }
                        throw th;
                    }
                } catch (NotFoundException e7) {
                    e = e7;
                }
            } catch (IOException e8) {
                e = e8;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.h
    public final void u() {
        this.z++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.h
    public void x() {
        if (this.z < 2) {
            if (!j() && c.c) {
                D();
            } else if (k() && !this.o) {
                C();
            }
        }
        this.z = 0;
    }

    private synchronized void C() {
        if (this.q != null && y() == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                this.q.a(new DataOutputStream(byteArrayOutputStream));
                byteArrayOutputStream.close();
                this.r = byteArrayOutputStream.toByteArray();
                this.q = null;
            } catch (IOException e) {
            }
        }
    }

    private synchronized void D() {
        if (this.q != null && !j() && y() == null) {
            this.q = null;
        }
    }

    @Override // javassist.h
    public c a() {
        return this.f3022a;
    }

    @Override // javassist.h
    public boolean j() {
        return this.n;
    }

    @Override // javassist.h
    public boolean k() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.h
    public void l() {
        if (k()) {
            String str = n() + " class is frozen";
            if (this.o) {
                str = str + " and pruned";
            }
            throw new RuntimeException(str);
        }
        this.n = true;
    }

    @Override // javassist.h
    public boolean a(h hVar) {
        String n = hVar.n();
        if (this == hVar || n().equals(n)) {
            return true;
        }
        javassist.bytecode.i h = h();
        String g = h.g();
        if (g == null || !g.equals(n)) {
            String[] i = h.i();
            for (String str : i) {
                if (str.equals(n)) {
                    return true;
                }
            }
            if (g == null || !this.f3022a.c(g).a(hVar)) {
                for (String str2 : i) {
                    if (this.f3022a.c(str2).a(hVar)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // javassist.h
    public boolean q() {
        return v.e(c());
    }

    @Override // javassist.h
    public int c() {
        javassist.bytecode.i h = h();
        int a2 = javassist.bytecode.a.a(h.d(), 32);
        int e = h.e();
        if (e != -1 && (e & 8) != 0) {
            a2 |= 8;
        }
        return javassist.bytecode.a.e(a2);
    }

    @Override // javassist.h
    public void a(int i) {
        javassist.bytecode.i h = h();
        if (v.d(i)) {
            int e = h.e();
            if (e != -1 && (e & 8) != 0) {
                i &= -9;
            } else {
                throw new RuntimeException("cannot change " + n() + " into a static class");
            }
        }
        l();
        h.a(javassist.bytecode.a.d(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [javassist.h] */
    /* JADX WARN: Type inference failed for: r3v3 */
    @Override // javassist.h
    public boolean b(h hVar) {
        if (hVar == null) {
            return false;
        }
        String n = hVar.n();
        for (?? r3 = this; r3 != 0; r3 = r3.f()) {
            try {
                if (r3.n().equals(n)) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override // javassist.h
    public h f() {
        String g = h().g();
        if (g == null) {
            return null;
        }
        return this.f3022a.c(g);
    }

    @Override // javassist.h
    public void c(h hVar) {
        l();
        if (q()) {
            d(hVar);
        } else {
            h().a(hVar.n());
        }
    }

    @Override // javassist.h
    public h[] d() {
        String[] i = h().i();
        int length = i.length;
        h[] hVarArr = new h[length];
        for (int i2 = 0; i2 < length; i2++) {
            hVarArr[i2] = this.f3022a.c(i[i2]);
        }
        return hVarArr;
    }

    @Override // javassist.h
    public void d(h hVar) {
        l();
        if (hVar != null) {
            h().b(hVar.n());
        }
    }

    @Override // javassist.h
    public h r() {
        javassist.bytecode.i h = h();
        InnerClassesAttribute innerClassesAttribute = (InnerClassesAttribute) h.d("InnerClasses");
        if (innerClassesAttribute == null) {
            return null;
        }
        String n = n();
        int a2 = innerClassesAttribute.a();
        for (int i = 0; i < a2; i++) {
            if (n.equals(innerClassesAttribute.b(i))) {
                String d = innerClassesAttribute.d(i);
                if (d != null) {
                    return this.f3022a.c(d);
                }
                EnclosingMethodAttribute enclosingMethodAttribute = (EnclosingMethodAttribute) h.d("EnclosingMethod");
                if (enclosingMethodAttribute != null) {
                    return this.f3022a.c(enclosingMethodAttribute.g());
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m y() {
        if (this.t != null) {
            return (m) this.t.get();
        }
        return null;
    }

    protected synchronized m z() {
        m mVar;
        if (this.t == null || (mVar = (m) this.t.get()) == null) {
            mVar = new m(this);
            a(mVar);
            b(mVar);
            this.t = new WeakReference(mVar);
        }
        return mVar;
    }

    private void a(m mVar) {
        List j = h().j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            mVar.c(new CtField((ad) j.get(i), this));
        }
    }

    private void b(m mVar) {
        List k = h().k();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            an anVar = (an) k.get(i);
            if (anVar.b()) {
                mVar.a(new CtMethod(anVar, this));
            } else {
                mVar.b(new CtConstructor(anVar, this));
            }
        }
    }

    @Override // javassist.h
    public CtField b(String str, String str2) {
        return a(c(str, str2), str, str2);
    }

    private CtField a(CtField ctField, String str, String str2) {
        if (ctField == null) {
            String str3 = "field: " + str;
            if (str2 != null) {
                str3 = str3 + " type " + str2;
            }
            throw new NotFoundException(str3 + " in " + n());
        }
        return ctField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.h
    public CtField c(String str, String str2) {
        CtField d = d(str, str2);
        if (d == null) {
            try {
                for (h hVar : d()) {
                    CtField c = hVar.c(str, str2);
                    if (c != null) {
                        return c;
                    }
                }
                h f = f();
                if (f != null) {
                    return f.c(str, str2);
                }
            } catch (NotFoundException e) {
            }
            return null;
        }
        return d;
    }

    private CtField d(String str, String str2) {
        m z = z();
        l h = z.h();
        l k = z.k();
        while (h != k) {
            h = h.j();
            if (h.i().equals(str) && (str2 == null || str2.equals(h.e()))) {
                return (CtField) h;
            }
        }
        return null;
    }

    @Override // javassist.h
    public CtConstructor[] s() {
        int i;
        int i2 = 0;
        m z = z();
        l f = z.f();
        l g = z.g();
        l lVar = f;
        int i3 = 0;
        while (lVar != g) {
            lVar = lVar.j();
            i3 = ((CtConstructor) lVar).g() ? i3 + 1 : i3;
        }
        CtConstructor[] ctConstructorArr = new CtConstructor[i3];
        l lVar2 = f;
        while (lVar2 != g) {
            lVar2 = lVar2.j();
            CtConstructor ctConstructor = (CtConstructor) lVar2;
            if (ctConstructor.g()) {
                ctConstructorArr[i2] = ctConstructor;
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        return ctConstructorArr;
    }

    @Override // javassist.h
    public CtMethod a(String str, String str2) {
        CtMethod a2 = a(this, str, str2);
        if (a2 != null) {
            return a2;
        }
        throw new NotFoundException(str + "(..) is not found in " + n());
    }

    private static CtMethod a(h hVar, String str, String str2) {
        if (hVar instanceof j) {
            m z = ((j) hVar).z();
            l a2 = z.a();
            l d = z.d();
            while (a2 != d) {
                a2 = a2.j();
                if (a2.i().equals(str) && ((CtMethod) a2).a().g().equals(str2)) {
                    return (CtMethod) a2;
                }
            }
        }
        try {
            h f = hVar.f();
            if (f != null) {
                CtMethod a3 = a(f, str, str2);
                if (a3 != null) {
                    return a3;
                }
            }
        } catch (NotFoundException e) {
        }
        try {
            for (h hVar2 : hVar.d()) {
                CtMethod a4 = a(hVar2, str, str2);
                if (a4 != null) {
                    return a4;
                }
            }
        } catch (NotFoundException e2) {
        }
        return null;
    }

    @Override // javassist.h
    public CtMethod b(String str) {
        m z = z();
        l a2 = z.a();
        l d = z.d();
        while (a2 != d) {
            a2 = a2.j();
            if (a2.i().equals(str)) {
                return (CtMethod) a2;
            }
        }
        throw new NotFoundException(str + "(..) is not found in " + n());
    }

    @Override // javassist.h
    public void a(CtConstructor ctConstructor) {
        l();
        if (ctConstructor.c() != this) {
            throw new CannotCompileException("cannot add");
        }
        z().b(ctConstructor);
        h().a(ctConstructor.a());
    }

    @Override // javassist.h
    public void a(CtMethod ctMethod) {
        l();
        if (ctMethod.c() != this) {
            throw new CannotCompileException("bad declaring class");
        }
        int b = ctMethod.b();
        if ((c() & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) != 0) {
            ctMethod.a(b | 1);
            if ((b & 1024) == 0) {
                throw new CannotCompileException("an interface method must be abstract: " + ctMethod.toString());
            }
        }
        z().a(ctMethod);
        h().a(ctMethod.a());
        if ((b & 1024) != 0) {
            a(c() | 1024);
        }
    }

    @Override // javassist.h
    public void a(CodeConverter codeConverter) {
        l();
        javassist.bytecode.i h = h();
        y c = h.c();
        List k = h.k();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            codeConverter.a(this, (an) k.get(i), c);
        }
    }

    @Override // javassist.h
    public void t() {
        if (!this.o) {
            this.s = true;
            this.o = true;
            h().b();
        }
    }

    @Override // javassist.h
    public void v() {
        this.p = true;
    }

    @Override // javassist.h
    public void a(DataOutputStream dataOutputStream) {
        try {
            if (j()) {
                d("toBytecode");
                javassist.bytecode.i h = h();
                if (this.p) {
                    h.a();
                    this.p = false;
                }
                b(h);
                c(h);
                if (c != null) {
                    a(h);
                }
                h.a(dataOutputStream);
                dataOutputStream.flush();
                this.v = null;
                if (this.y) {
                    h.b();
                    this.o = true;
                }
            } else {
                this.f3022a.a(n(), dataOutputStream);
            }
            this.z = 0;
            this.s = true;
        } catch (IOException e) {
            throw new CannotCompileException(e);
        } catch (NotFoundException e2) {
            throw new CannotCompileException(e2);
        }
    }

    private void a(javassist.bytecode.i iVar) {
        DataOutputStream c = c(c);
        try {
            iVar.a(c);
        } finally {
            c.close();
        }
    }

    private void d(String str) {
        if (this.o) {
            throw new RuntimeException(str + "(): " + n() + " was pruned.");
        }
    }

    private void b(javassist.bytecode.i iVar) {
        int i;
        if (this.v != null) {
            Bytecode bytecode = new Bytecode(iVar.c(), 0, 0);
            Javac javac = new Javac(bytecode, this);
            t tVar = this.v;
            int i2 = 0;
            boolean z = false;
            while (tVar != null) {
                CtField ctField = tVar.b;
                if (v.d(ctField.b())) {
                    z = true;
                    i = tVar.c.a(ctField.d(), ctField.i(), bytecode, javac);
                    if (i2 < i) {
                        tVar = tVar.f3027a;
                        i2 = i;
                    }
                }
                i = i2;
                tVar = tVar.f3027a;
                i2 = i;
            }
            if (z) {
                a(iVar, bytecode, i2, 0);
            }
        }
    }

    private void a(javassist.bytecode.i iVar, Bytecode bytecode, int i, int i2) {
        an l = iVar.l();
        if (l == null) {
            bytecode.a(177);
            bytecode.c(i);
            bytecode.d(i2);
            l = new an(iVar.c(), "<clinit>", "()V");
            l.a(8);
            l.a(bytecode.e());
            iVar.a(l);
            m y = y();
            if (y != null) {
                y.b(new CtConstructor(l, this));
            }
        } else {
            CodeAttribute i3 = l.i();
            if (i3 == null) {
                throw new CannotCompileException("empty <clinit>");
            }
            try {
                CodeIterator j = i3.j();
                j.a(bytecode.d(), j.b(bytecode.f()));
                if (i3.f() < i) {
                    i3.a(i);
                }
                if (i3.g() < i2) {
                    i3.b(i2);
                }
            } catch (BadBytecode e) {
                throw new CannotCompileException(e);
            }
        }
        try {
            l.a(this.f3022a, iVar);
        } catch (BadBytecode e2) {
            throw new CannotCompileException(e2);
        }
    }

    private void c(javassist.bytecode.i iVar) {
        CodeAttribute i;
        if (this.v != null) {
            y c = iVar.c();
            List k = iVar.k();
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                an anVar = (an) k.get(i2);
                if (anVar.d() && (i = anVar.i()) != null) {
                    try {
                        Bytecode bytecode = new Bytecode(c, 0, i.g());
                        a(i, bytecode, a(bytecode, z.a(anVar.g(), this.f3022a)));
                        anVar.a(this.f3022a, iVar);
                    } catch (BadBytecode e) {
                        throw new CannotCompileException(e);
                    }
                }
            }
        }
    }

    private static void a(CodeAttribute codeAttribute, Bytecode bytecode, int i) {
        CodeIterator j = codeAttribute.j();
        if (j.h() >= 0 || j.i() < 0) {
            j.a(bytecode.d(), j.b(bytecode.f()));
            if (codeAttribute.f() < i) {
                codeAttribute.a(i);
            }
        }
    }

    private int a(Bytecode bytecode, h[] hVarArr) {
        int i;
        int i2 = 0;
        Javac javac = new Javac(bytecode, this);
        try {
            javac.a(hVarArr, false);
            t tVar = this.v;
            while (tVar != null) {
                CtField ctField = tVar.b;
                if (v.d(ctField.b()) || i2 >= (i = tVar.c.a(ctField.d(), ctField.i(), bytecode, hVarArr, javac))) {
                    i = i2;
                }
                tVar = tVar.f3027a;
                i2 = i;
            }
            return i2;
        } catch (CompileError e) {
            throw new CannotCompileException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hashtable A() {
        if (this.w == null) {
            this.w = new Hashtable();
        }
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        int i = this.x;
        this.x = i + 1;
        return i;
    }
}
