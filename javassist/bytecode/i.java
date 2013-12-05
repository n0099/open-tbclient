package javassist.bytecode;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javassist.CannotCompileException;
/* loaded from: classes.dex */
public final class i {
    public static int n;

    /* renamed from: a  reason: collision with root package name */
    int f2979a;
    int b;
    y c;
    int d;
    int e;
    int f;
    int[] g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    String k;
    String[] l;
    String m;

    static {
        n = 47;
        try {
            Class.forName("java.lang.StringBuilder");
            n = 49;
            Class.forName("java.util.zip.DeflaterInputStream");
            n = 50;
            Class.forName("java.lang.invoke.CallSite");
            n = 51;
        } catch (Throwable th) {
        }
    }

    public i(DataInputStream dataInputStream) {
        a(dataInputStream);
    }

    public i(boolean z, String str, String str2) {
        this.f2979a = n;
        this.b = 0;
        this.c = new y(str);
        this.d = this.c.b();
        if (z) {
            this.e = 1536;
        } else {
            this.e = 32;
        }
        e(str2);
        this.g = null;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = str;
        this.j = new ArrayList();
        this.j.add(new SourceFileAttribute(this.c, f(this.k)));
    }

    private void e(String str) {
        if (str != null) {
            this.f = this.c.a(str);
            this.m = str;
            return;
        }
        this.f = this.c.a("java.lang.Object");
        this.m = "java.lang.Object";
    }

    private static String f(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        return str + ".java";
    }

    public void a() {
        y n2 = n();
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((an) arrayList.get(i)).a(n2);
        }
        ArrayList arrayList2 = this.h;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((ad) arrayList2.get(i2)).a(n2);
        }
        this.j = e.a(this.j, n2);
        this.c = n2;
    }

    private y n() {
        y yVar = new y(this.k);
        this.d = yVar.b();
        if (g() != null) {
            this.f = yVar.a(g());
        }
        if (this.g != null) {
            int length = this.g.length;
            for (int i = 0; i < length; i++) {
                this.g[i] = yVar.a(this.c.d(this.g[i]));
            }
        }
        return yVar;
    }

    public void b() {
        y n2 = n();
        ArrayList arrayList = new ArrayList();
        e d = d("RuntimeInvisibleAnnotations");
        if (d != null) {
            arrayList.add(d.a(n2, (Map) null));
        }
        e d2 = d("RuntimeVisibleAnnotations");
        if (d2 != null) {
            arrayList.add(d2.a(n2, (Map) null));
        }
        e d3 = d("Signature");
        if (d3 != null) {
            arrayList.add(d3.a(n2, (Map) null));
        }
        ArrayList arrayList2 = this.i;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            ((an) arrayList2.get(i)).b(n2);
        }
        ArrayList arrayList3 = this.h;
        int size2 = arrayList3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((ad) arrayList3.get(i2)).b(n2);
        }
        this.j = arrayList;
        this.c = n2;
    }

    public y c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public void a(int i) {
        if ((i & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 0) {
            i |= 32;
        }
        this.e = i;
    }

    public int e() {
        InnerClassesAttribute innerClassesAttribute = (InnerClassesAttribute) d("InnerClasses");
        if (innerClassesAttribute == null) {
            return -1;
        }
        String f = f();
        int a2 = innerClassesAttribute.a();
        for (int i = 0; i < a2; i++) {
            if (f.equals(innerClassesAttribute.b(i))) {
                return innerClassesAttribute.e(i);
            }
        }
        return -1;
    }

    public String f() {
        return this.k;
    }

    public String g() {
        if (this.m == null) {
            this.m = this.c.d(this.f);
        }
        return this.m;
    }

    public int h() {
        return this.f;
    }

    public void a(String str) {
        if (str == null) {
            str = "java.lang.Object";
        }
        try {
            this.f = this.c.a(str);
            ArrayList arrayList = this.i;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((an) arrayList.get(i)).b(str);
            }
            this.m = str;
        } catch (BadBytecode e) {
            throw new CannotCompileException(e);
        }
    }

    public String[] i() {
        String[] strArr;
        if (this.l != null) {
            return this.l;
        }
        if (this.g == null) {
            strArr = new String[0];
        } else {
            int length = this.g.length;
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = this.c.d(this.g[i]);
            }
        }
        this.l = strArr;
        return strArr;
    }

    public void a(String[] strArr) {
        this.l = null;
        if (strArr != null) {
            int length = strArr.length;
            this.g = new int[length];
            for (int i = 0; i < length; i++) {
                this.g[i] = this.c.a(strArr[i]);
            }
        }
    }

    public void b(String str) {
        this.l = null;
        int a2 = this.c.a(str);
        if (this.g == null) {
            this.g = new int[1];
            this.g[0] = a2;
            return;
        }
        int length = this.g.length;
        int[] iArr = new int[length + 1];
        System.arraycopy(this.g, 0, iArr, 0, length);
        iArr[length] = a2;
        this.g = iArr;
    }

    public List j() {
        return this.h;
    }

    public void a(ad adVar) {
        a(adVar.b(), adVar.d());
        this.h.add(adVar);
    }

    public final void b(ad adVar) {
        this.h.add(adVar);
    }

    private void a(String str, String str2) {
        ListIterator listIterator = this.h.listIterator(0);
        while (listIterator.hasNext()) {
            if (((ad) listIterator.next()).b().equals(str)) {
                throw new DuplicateMemberException("duplicate field: " + str);
            }
        }
    }

    public List k() {
        return this.i;
    }

    public an c(String str) {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            an anVar = (an) arrayList.get(i);
            if (anVar.a().equals(str)) {
                return anVar;
            }
        }
        return null;
    }

    public an l() {
        return c("<clinit>");
    }

    public void a(an anVar) {
        c(anVar);
        this.i.add(anVar);
    }

    public final void b(an anVar) {
        this.i.add(anVar);
    }

    private void c(an anVar) {
        String a2 = anVar.a();
        String g = anVar.g();
        ListIterator listIterator = this.i.listIterator(0);
        while (listIterator.hasNext()) {
            if (a(anVar, a2, g, (an) listIterator.next(), listIterator)) {
                throw new DuplicateMemberException("duplicate method: " + a2 + " in " + f());
            }
        }
    }

    private static boolean a(an anVar, String str, String str2, an anVar2, ListIterator listIterator) {
        if (anVar2.a().equals(str)) {
            String g = anVar2.g();
            if (z.d(g, str2) && g.equals(str2)) {
                if (d(anVar2)) {
                    return true;
                }
                listIterator.remove();
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean d(an anVar) {
        return (anVar.f() & 64) == 0;
    }

    public e d(String str) {
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            e eVar = (e) arrayList.get(i);
            if (eVar.b().equals(str)) {
                return eVar;
            }
        }
        return null;
    }

    public void a(e eVar) {
        e.b(this.j, eVar.b());
        this.j.add(eVar);
    }

    private void a(DataInputStream dataInputStream) {
        int readInt;
        if (dataInputStream.readInt() != -889275714) {
            throw new IOException("bad magic number: " + Integer.toHexString(readInt));
        }
        this.b = dataInputStream.readUnsignedShort();
        this.f2979a = dataInputStream.readUnsignedShort();
        this.c = new y(dataInputStream);
        this.e = dataInputStream.readUnsignedShort();
        this.d = dataInputStream.readUnsignedShort();
        this.c.a(this.d);
        this.f = dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        if (readUnsignedShort == 0) {
            this.g = null;
        } else {
            this.g = new int[readUnsignedShort];
            for (int i = 0; i < readUnsignedShort; i++) {
                this.g[i] = dataInputStream.readUnsignedShort();
            }
        }
        y yVar = this.c;
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        this.h = new ArrayList();
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            b(new ad(yVar, dataInputStream));
        }
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        this.i = new ArrayList();
        for (int i3 = 0; i3 < readUnsignedShort3; i3++) {
            b(new an(yVar, dataInputStream));
        }
        this.j = new ArrayList();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        for (int i4 = 0; i4 < readUnsignedShort4; i4++) {
            a(e.a(yVar, dataInputStream));
        }
        this.k = this.c.d(this.d);
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(-889275714);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.f2979a);
        this.c.a(dataOutputStream);
        dataOutputStream.writeShort(this.e);
        dataOutputStream.writeShort(this.d);
        dataOutputStream.writeShort(this.f);
        int length = this.g == null ? 0 : this.g.length;
        dataOutputStream.writeShort(length);
        for (int i = 0; i < length; i++) {
            dataOutputStream.writeShort(this.g[i]);
        }
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        dataOutputStream.writeShort(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((ad) arrayList.get(i2)).a(dataOutputStream);
        }
        ArrayList arrayList2 = this.i;
        int size2 = arrayList2.size();
        dataOutputStream.writeShort(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            ((an) arrayList2.get(i3)).a(dataOutputStream);
        }
        dataOutputStream.writeShort(this.j.size());
        e.a(this.j, dataOutputStream);
    }

    public int m() {
        return this.f2979a;
    }
}
