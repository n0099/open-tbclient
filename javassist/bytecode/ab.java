package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class ab implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private y f2754a;
    private ArrayList b;

    public ab(y yVar) {
        this.f2754a = yVar;
        this.b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, DataInputStream dataInputStream) {
        this.f2754a = yVar;
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        ArrayList arrayList = new ArrayList(readUnsignedShort);
        for (int i = 0; i < readUnsignedShort; i++) {
            arrayList.add(new ac(dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort()));
        }
        this.b = arrayList;
    }

    public Object clone() {
        ab abVar = (ab) super.clone();
        abVar.b = new ArrayList(this.b);
        return abVar;
    }

    public int a() {
        return this.b.size();
    }

    public int a(int i) {
        return ((ac) this.b.get(i)).f2755a;
    }

    public int b(int i) {
        return ((ac) this.b.get(i)).b;
    }

    public int c(int i) {
        return ((ac) this.b.get(i)).c;
    }

    public int d(int i) {
        return ((ac) this.b.get(i)).d;
    }

    public void a(int i, ab abVar, int i2) {
        int a2 = abVar.a();
        while (true) {
            int i3 = a2 - 1;
            if (i3 >= 0) {
                ac acVar = (ac) abVar.b.get(i3);
                a(i, acVar.f2755a + i2, acVar.b + i2, acVar.c + i2, acVar.d);
                a2 = i3;
            } else {
                return;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i2 < i3) {
            this.b.add(i, new ac(i2, i3, i4, i5));
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i < i2) {
            this.b.add(new ac(i, i2, i3, i4));
        }
    }

    public ab a(y yVar, Map map) {
        ab abVar = new ab(yVar);
        y yVar2 = this.f2754a;
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            ac acVar = (ac) this.b.get(i);
            abVar.a(acVar.f2755a, acVar.b, acVar.c, yVar2.a(acVar.d, yVar, map));
        }
        return abVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        int a2 = a();
        for (int i3 = 0; i3 < a2; i3++) {
            ac acVar = (ac) this.b.get(i3);
            acVar.f2755a = a(acVar.f2755a, i, i2, z);
            acVar.b = a(acVar.b, i, i2, z);
            acVar.c = a(acVar.c, i, i2, z);
        }
    }

    private static int a(int i, int i2, int i3, boolean z) {
        if (i > i2 || (z && i == i2)) {
            return i + i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DataOutputStream dataOutputStream) {
        int a2 = a();
        dataOutputStream.writeShort(a2);
        for (int i = 0; i < a2; i++) {
            ac acVar = (ac) this.b.get(i);
            dataOutputStream.writeShort(acVar.f2755a);
            dataOutputStream.writeShort(acVar.b);
            dataOutputStream.writeShort(acVar.c);
            dataOutputStream.writeShort(acVar.d);
        }
    }
}
