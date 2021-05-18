package d.a.i0.a.h0.i;

import d.a.i0.a.v2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0655a> f41981a = new ArrayList();

    /* renamed from: d.a.i0.a.h0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0655a {

        /* renamed from: a  reason: collision with root package name */
        public String f41982a;

        /* renamed from: b  reason: collision with root package name */
        public String f41983b;

        /* renamed from: c  reason: collision with root package name */
        public String f41984c;

        public C0655a(String str, String str2, String str3) {
            this.f41982a = str;
            this.f41983b = str2;
            this.f41984c = str3;
        }

        public static C0655a a(String str, String str2, String str3) {
            return new C0655a(str, str2, str3);
        }

        public boolean b() {
            return "1".equals(this.f41982a);
        }

        public boolean c() {
            return "1".equals(this.f41984c);
        }

        public String toString() {
            return "JSErrorModel{mType='" + this.f41982a + "', mContent='" + this.f41983b + "', mSource='" + this.f41984c + "'}";
        }
    }

    public synchronized boolean a(C0655a c0655a) {
        if (c0655a != null) {
            return this.f41981a.add(c0655a);
        }
        return false;
    }

    public synchronized String b() {
        String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
        if (d()) {
            return String.format("\n%s jserror：共0个；", g2);
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (C0655a c0655a : this.f41981a) {
            if (c0655a.b()) {
                i2++;
                if (c0655a.c()) {
                    i4++;
                } else {
                    i3++;
                }
            }
        }
        return String.format("\n%s jserror：共%d个，影响渲染%d个（框架%d个，开发者%d个）；", g2, Integer.valueOf(e()), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
    }

    public synchronized boolean c() {
        boolean z;
        z = false;
        Iterator<C0655a> it = this.f41981a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().b()) {
                z = true;
                break;
            }
        }
        return z;
    }

    public synchronized boolean d() {
        return this.f41981a.isEmpty();
    }

    public synchronized int e() {
        return this.f41981a.size();
    }
}
