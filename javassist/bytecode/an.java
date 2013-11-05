package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Map;
import javassist.bytecode.stackmap.MapMaker;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
public class an {
    public static boolean g = false;

    /* renamed from: a  reason: collision with root package name */
    y f2716a;
    int b;
    int c;
    String d;
    int e;
    ArrayList f;

    private an(y yVar) {
        this.f2716a = yVar;
        this.f = null;
    }

    public an(y yVar, String str, String str2) {
        this(yVar);
        this.b = 0;
        this.c = yVar.c(str);
        this.d = str;
        this.e = this.f2716a.c(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(y yVar, DataInputStream dataInputStream) {
        this(yVar);
        a(dataInputStream);
    }

    public an(y yVar, String str, an anVar, Map map) {
        this(yVar);
        a(anVar, str, map);
    }

    public String toString() {
        return a() + " " + g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.c = yVar.c(a());
        this.e = yVar.c(g());
        this.f = e.a(this.f, yVar);
        this.f2716a = yVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(y yVar) {
        ArrayList arrayList = new ArrayList();
        e a2 = a("RuntimeInvisibleAnnotations");
        if (a2 != null) {
            arrayList.add(a2.a(yVar, (Map) null));
        }
        e a3 = a("RuntimeVisibleAnnotations");
        if (a3 != null) {
            arrayList.add(a3.a(yVar, (Map) null));
        }
        e a4 = a("RuntimeInvisibleParameterAnnotations");
        if (a4 != null) {
            arrayList.add(a4.a(yVar, (Map) null));
        }
        e a5 = a("RuntimeVisibleParameterAnnotations");
        if (a5 != null) {
            arrayList.add(a5.a(yVar, (Map) null));
        }
        AnnotationDefaultAttribute annotationDefaultAttribute = (AnnotationDefaultAttribute) a("AnnotationDefault");
        if (annotationDefaultAttribute != null) {
            arrayList.add(annotationDefaultAttribute);
        }
        ExceptionsAttribute h = h();
        if (h != null) {
            arrayList.add(h);
        }
        e a6 = a("Signature");
        if (a6 != null) {
            arrayList.add(a6.a(yVar, (Map) null));
        }
        this.f = arrayList;
        this.c = yVar.c(a());
        this.e = yVar.c(g());
        this.f2716a = yVar;
    }

    public String a() {
        if (this.d == null) {
            this.d = this.f2716a.w(this.c);
        }
        return this.d;
    }

    public boolean b() {
        String a2 = a();
        return (a2.equals(MethodDecl.initName) || a2.equals("<clinit>")) ? false : true;
    }

    public y c() {
        return this.f2716a;
    }

    public boolean d() {
        return a().equals(MethodDecl.initName);
    }

    public boolean e() {
        return a().equals("<clinit>");
    }

    public int f() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public String g() {
        return this.f2716a.w(this.e);
    }

    public e a(String str) {
        return e.a(this.f, str);
    }

    public void a(e eVar) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        e.b(this.f, eVar.b());
        this.f.add(eVar);
    }

    public ExceptionsAttribute h() {
        return (ExceptionsAttribute) e.a(this.f, "Exceptions");
    }

    public CodeAttribute i() {
        return (CodeAttribute) e.a(this.f, "Code");
    }

    public void j() {
        e.b(this.f, "Exceptions");
    }

    public void a(ExceptionsAttribute exceptionsAttribute) {
        j();
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(exceptionsAttribute);
    }

    public void k() {
        e.b(this.f, "Code");
    }

    public void a(CodeAttribute codeAttribute) {
        k();
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(codeAttribute);
    }

    public void a(javassist.c cVar, i iVar) {
        if (iVar.m() >= 50) {
            a(cVar);
        }
        if (g) {
            b(cVar);
        }
    }

    public void a(javassist.c cVar) {
        CodeAttribute i = i();
        if (i != null) {
            i.a(MapMaker.a(cVar, this));
        }
    }

    public void b(javassist.c cVar) {
        CodeAttribute i = i();
        if (i != null) {
            i.a(MapMaker.b(cVar, this));
        }
    }

    public void b(String str) {
        if (d()) {
            CodeAttribute i = i();
            byte[] i2 = i.i();
            int h = i.j().h();
            if (h >= 0) {
                y yVar = this.f2716a;
                g.a(yVar.c(yVar.a(str), yVar.m(g.a(i2, h + 1))), i2, h + 1);
            }
        }
    }

    private void a(an anVar, String str, Map map) {
        y yVar = this.f2716a;
        this.b = anVar.b;
        this.c = yVar.c(str);
        this.d = str;
        this.e = yVar.c(z.a(anVar.f2716a.w(anVar.e), map));
        this.f = new ArrayList();
        ExceptionsAttribute h = anVar.h();
        if (h != null) {
            this.f.add(h.a(yVar, map));
        }
        CodeAttribute i = anVar.i();
        if (i != null) {
            this.f.add(i.a(yVar, map));
        }
    }

    private void a(DataInputStream dataInputStream) {
        this.b = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
        this.e = dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        this.f = new ArrayList();
        for (int i = 0; i < readUnsignedShort; i++) {
            this.f.add(e.a(this.f2716a, dataInputStream));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.c);
        dataOutputStream.writeShort(this.e);
        if (this.f == null) {
            dataOutputStream.writeShort(0);
            return;
        }
        dataOutputStream.writeShort(this.f.size());
        e.a(this.f, dataOutputStream);
    }
}
