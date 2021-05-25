package d.a.l0.a.h0.i;

import d.a.l0.a.v2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0666a> f42155a = new ArrayList();

    /* renamed from: d.a.l0.a.h0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0666a {

        /* renamed from: a  reason: collision with root package name */
        public String f42156a;

        /* renamed from: b  reason: collision with root package name */
        public String f42157b;

        /* renamed from: c  reason: collision with root package name */
        public String f42158c;

        public C0666a(String str, String str2, String str3) {
            this.f42156a = str;
            this.f42157b = str2;
            this.f42158c = str3;
        }

        public static C0666a a(String str, String str2, String str3) {
            return new C0666a(str, str2, str3);
        }

        public boolean b() {
            return "1".equals(this.f42156a);
        }

        public boolean c() {
            return "1".equals(this.f42158c);
        }

        public String toString() {
            return "JSErrorModel{mType='" + this.f42156a + "', mContent='" + this.f42157b + "', mSource='" + this.f42158c + "'}";
        }
    }

    public synchronized boolean a(C0666a c0666a) {
        if (c0666a != null) {
            return this.f42155a.add(c0666a);
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
        for (C0666a c0666a : this.f42155a) {
            if (c0666a.b()) {
                i2++;
                if (c0666a.c()) {
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
        Iterator<C0666a> it = this.f42155a.iterator();
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
        return this.f42155a.isEmpty();
    }

    public synchronized int e() {
        return this.f42155a.size();
    }
}
