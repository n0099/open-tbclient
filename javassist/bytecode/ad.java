package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class ad {

    /* renamed from: a  reason: collision with root package name */
    y f2740a;
    int b;
    int c;
    String d;
    int e;
    ArrayList f;

    private ad(y yVar) {
        this.f2740a = yVar;
        this.b = 0;
        this.f = null;
    }

    public ad(y yVar, String str, String str2) {
        this(yVar);
        this.c = yVar.c(str);
        this.d = str;
        this.e = yVar.c(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar, DataInputStream dataInputStream) {
        this(yVar);
        a(dataInputStream);
    }

    public String toString() {
        return b() + " " + d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.c = yVar.c(b());
        this.e = yVar.c(d());
        this.f = e.a(this.f, yVar);
        this.f2740a = yVar;
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
        e a4 = a("Signature");
        if (a4 != null) {
            arrayList.add(a4.a(yVar, (Map) null));
        }
        int e = e();
        if (e != 0) {
            arrayList.add(new ConstantAttribute(yVar, this.f2740a.a(e, yVar, (Map) null)));
        }
        this.f = arrayList;
        this.c = yVar.c(b());
        this.e = yVar.c(d());
        this.f2740a = yVar;
    }

    public y a() {
        return this.f2740a;
    }

    public String b() {
        if (this.d == null) {
            this.d = this.f2740a.w(this.c);
        }
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public String d() {
        return this.f2740a.w(this.e);
    }

    public int e() {
        ConstantAttribute constantAttribute;
        if ((this.b & 8) != 0 && (constantAttribute = (ConstantAttribute) a("ConstantValue")) != null) {
            return constantAttribute.a();
        }
        return 0;
    }

    public e a(String str) {
        return e.a(this.f, str);
    }

    private void a(DataInputStream dataInputStream) {
        this.b = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
        this.e = dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        this.f = new ArrayList();
        for (int i = 0; i < readUnsignedShort; i++) {
            this.f.add(e.a(this.f2740a, dataInputStream));
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
