package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
public final class y {
    public static final javassist.h e = null;

    /* renamed from: a  reason: collision with root package name */
    ak f2815a;
    int b;
    int c;
    HashMap d;

    public y(String str) {
        this.f2815a = new ak();
        this.d = null;
        this.b = 0;
        a((w) null);
        this.c = a(str);
    }

    public y(DataInputStream dataInputStream) {
        this.d = null;
        this.c = 0;
        a(dataInputStream);
    }

    public String a() {
        return d(this.c);
    }

    public int b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w b(int i) {
        return this.f2815a.a(i);
    }

    public int c(int i) {
        return b(i).a();
    }

    public String d(int i) {
        j jVar = (j) b(i);
        if (jVar == null) {
            return null;
        }
        return z.b(w(jVar.f2799a));
    }

    public String e(int i) {
        j jVar = (j) b(i);
        if (jVar == null) {
            return null;
        }
        String w = w(jVar.f2799a);
        return w.charAt(0) != '[' ? z.d(w) : w;
    }

    public int f(int i) {
        return ((ar) b(i)).f2777a;
    }

    public int g(int i) {
        return ((ar) b(i)).c;
    }

    public int h(int i) {
        return ((al) b(i)).c;
    }

    public String i(int i) {
        ae aeVar = (ae) b(i);
        if (aeVar == null) {
            return null;
        }
        return d(aeVar.f2746a);
    }

    public String j(int i) {
        ar arVar;
        ae aeVar = (ae) b(i);
        if (aeVar != null && (arVar = (ar) b(aeVar.c)) != null) {
            return w(arVar.f2777a);
        }
        return null;
    }

    public String k(int i) {
        ar arVar;
        ae aeVar = (ae) b(i);
        if (aeVar != null && (arVar = (ar) b(aeVar.c)) != null) {
            return w(arVar.c);
        }
        return null;
    }

    public String l(int i) {
        ap apVar = (ap) b(i);
        if (apVar == null) {
            return null;
        }
        return d(apVar.f2746a);
    }

    public int m(int i) {
        return ((ap) b(i)).c;
    }

    public String n(int i) {
        ar arVar;
        ap apVar = (ap) b(i);
        if (apVar != null && (arVar = (ar) b(apVar.c)) != null) {
            return w(arVar.f2777a);
        }
        return null;
    }

    public String o(int i) {
        ar arVar;
        ap apVar = (ap) b(i);
        if (apVar != null && (arVar = (ar) b(apVar.c)) != null) {
            return w(arVar.c);
        }
        return null;
    }

    public String p(int i) {
        return d(((ah) b(i)).f2746a);
    }

    public String q(int i) {
        ar arVar;
        ah ahVar = (ah) b(i);
        if (ahVar != null && (arVar = (ar) b(ahVar.c)) != null) {
            return w(arVar.c);
        }
        return null;
    }

    public int r(int i) {
        return ((ag) b(i)).f2742a;
    }

    public float s(int i) {
        return ((af) b(i)).f2741a;
    }

    public long t(int i) {
        return ((aj) b(i)).f2744a;
    }

    public double u(int i) {
        return ((aa) b(i)).f2737a;
    }

    public String v(int i) {
        return w(((bm) b(i)).f2792a);
    }

    public String w(int i) {
        return ((bn) b(i)).f2793a;
    }

    public String x(int i) {
        ar arVar;
        ai aiVar = (ai) b(i);
        if (aiVar != null && (arVar = (ar) b(aiVar.c)) != null) {
            return w(arVar.c);
        }
        return null;
    }

    public int a(String str, int i) {
        return a(str, MethodDecl.initName, i);
    }

    public int a(String str, String str2, int i) {
        al alVar = (al) b(i);
        if (d(alVar.f2746a).equals(str)) {
            ar arVar = (ar) b(alVar.c);
            if (w(arVar.f2777a).equals(str2)) {
                return arVar.c;
            }
        }
        return 0;
    }

    public String b(String str, String str2, int i) {
        al alVar = (al) b(i);
        ar arVar = (ar) b(alVar.c);
        if (w(arVar.f2777a).equals(str) && w(arVar.c).equals(str2)) {
            return d(alVar.f2746a);
        }
        return null;
    }

    private int a(w wVar) {
        this.f2815a.a(wVar);
        int i = this.b;
        this.b = i + 1;
        return i;
    }

    private int b(w wVar) {
        if (this.d == null) {
            this.d = a(this.f2815a);
        }
        w wVar2 = (w) this.d.get(wVar);
        if (wVar2 != null) {
            return wVar2.b;
        }
        this.f2815a.a(wVar);
        this.d.put(wVar, wVar);
        int i = this.b;
        this.b = i + 1;
        return i;
    }

    public int a(int i, y yVar, Map map) {
        if (i == 0) {
            return 0;
        }
        return b(i).a(this, yVar, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return a(new x(this.b));
    }

    public int a(javassist.h hVar) {
        if (hVar == e) {
            return this.c;
        }
        if (!hVar.b()) {
            return a(hVar.n());
        }
        return a(z.a(hVar));
    }

    public int a(String str) {
        return b(new j(c(z.a(str)), this.b));
    }

    public int a(String str, String str2) {
        return a(c(str), c(str2));
    }

    public int a(int i, int i2) {
        return b(new ar(i, i2, this.b));
    }

    public int a(int i, String str, String str2) {
        return b(i, a(str, str2));
    }

    public int b(int i, int i2) {
        return b(new ae(i, i2, this.b));
    }

    public int b(int i, String str, String str2) {
        return c(i, a(str, str2));
    }

    public int c(int i, int i2) {
        return b(new ap(i, i2, this.b));
    }

    public int c(int i, String str, String str2) {
        return d(i, a(str, str2));
    }

    public int d(int i, int i2) {
        return b(new ah(i, i2, this.b));
    }

    public int b(String str) {
        return b(new bm(c(str), this.b));
    }

    public int y(int i) {
        return b(new ag(i, this.b));
    }

    public int a(float f) {
        return b(new af(f, this.b));
    }

    public int a(long j) {
        int b = b(new aj(j, this.b));
        if (b == this.b - 1) {
            c();
        }
        return b;
    }

    public int a(double d) {
        int b = b(new aa(d, this.b));
        if (b == this.b - 1) {
            c();
        }
        return b;
    }

    public int c(String str) {
        return b(new bn(str, this.b));
    }

    public int e(int i, int i2) {
        return b(new am(i, i2, this.b));
    }

    public int z(int i) {
        return b(new ao(i, this.b));
    }

    public int f(int i, int i2) {
        return b(new ai(i, i2, this.b));
    }

    private void a(DataInputStream dataInputStream) {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        this.f2815a = new ak(readUnsignedShort);
        this.b = 0;
        a((w) null);
        while (true) {
            readUnsignedShort--;
            if (readUnsignedShort > 0) {
                int b = b(dataInputStream);
                if (b == 5 || b == 6) {
                    c();
                    readUnsignedShort--;
                }
            } else {
                return;
            }
        }
    }

    private static HashMap a(ak akVar) {
        HashMap hashMap = new HashMap();
        int i = 1;
        while (true) {
            int i2 = i + 1;
            w a2 = akVar.a(i);
            if (a2 != null) {
                hashMap.put(a2, a2);
                i = i2;
            } else {
                return hashMap;
            }
        }
    }

    private int b(DataInputStream dataInputStream) {
        w aiVar;
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        switch (readUnsignedByte) {
            case 1:
                aiVar = new bn(dataInputStream, this.b);
                break;
            case 2:
            case 13:
            case 14:
            case 17:
            default:
                throw new IOException("invalid constant type: " + readUnsignedByte + " at " + this.b);
            case 3:
                aiVar = new ag(dataInputStream, this.b);
                break;
            case 4:
                aiVar = new af(dataInputStream, this.b);
                break;
            case 5:
                aiVar = new aj(dataInputStream, this.b);
                break;
            case 6:
                aiVar = new aa(dataInputStream, this.b);
                break;
            case 7:
                aiVar = new j(dataInputStream, this.b);
                break;
            case 8:
                aiVar = new bm(dataInputStream, this.b);
                break;
            case 9:
                aiVar = new ae(dataInputStream, this.b);
                break;
            case 10:
                aiVar = new ap(dataInputStream, this.b);
                break;
            case 11:
                aiVar = new ah(dataInputStream, this.b);
                break;
            case 12:
                aiVar = new ar(dataInputStream, this.b);
                break;
            case 15:
                aiVar = new am(dataInputStream, this.b);
                break;
            case 16:
                aiVar = new ao(dataInputStream, this.b);
                break;
            case 18:
                aiVar = new ai(dataInputStream, this.b);
                break;
        }
        a(aiVar);
        return readUnsignedByte;
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.b);
        ak akVar = this.f2815a;
        int i = this.b;
        for (int i2 = 1; i2 < i; i2++) {
            akVar.a(i2).a(dataOutputStream);
        }
    }
}
