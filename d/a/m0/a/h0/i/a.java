package d.a.m0.a.h0.i;

import d.a.m0.a.v2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0725a> f45939a = new ArrayList();

    /* renamed from: d.a.m0.a.h0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0725a {

        /* renamed from: a  reason: collision with root package name */
        public String f45940a;

        /* renamed from: b  reason: collision with root package name */
        public String f45941b;

        /* renamed from: c  reason: collision with root package name */
        public String f45942c;

        public C0725a(String str, String str2, String str3) {
            this.f45940a = str;
            this.f45941b = str2;
            this.f45942c = str3;
        }

        public static C0725a a(String str, String str2, String str3) {
            return new C0725a(str, str2, str3);
        }

        public boolean b() {
            return "1".equals(this.f45940a);
        }

        public boolean c() {
            return "1".equals(this.f45942c);
        }

        public String toString() {
            return "JSErrorModel{mType='" + this.f45940a + "', mContent='" + this.f45941b + "', mSource='" + this.f45942c + "'}";
        }
    }

    public synchronized boolean a(C0725a c0725a) {
        if (c0725a != null) {
            return this.f45939a.add(c0725a);
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
        for (C0725a c0725a : this.f45939a) {
            if (c0725a.b()) {
                i2++;
                if (c0725a.c()) {
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
        Iterator<C0725a> it = this.f45939a.iterator();
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
        return this.f45939a.isEmpty();
    }

    public synchronized int e() {
        return this.f45939a.size();
    }
}
