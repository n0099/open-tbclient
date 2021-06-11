package d.a.l0.a.h0.i;

import d.a.l0.a.v2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0722a> f45831a = new ArrayList();

    /* renamed from: d.a.l0.a.h0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0722a {

        /* renamed from: a  reason: collision with root package name */
        public String f45832a;

        /* renamed from: b  reason: collision with root package name */
        public String f45833b;

        /* renamed from: c  reason: collision with root package name */
        public String f45834c;

        public C0722a(String str, String str2, String str3) {
            this.f45832a = str;
            this.f45833b = str2;
            this.f45834c = str3;
        }

        public static C0722a a(String str, String str2, String str3) {
            return new C0722a(str, str2, str3);
        }

        public boolean b() {
            return "1".equals(this.f45832a);
        }

        public boolean c() {
            return "1".equals(this.f45834c);
        }

        public String toString() {
            return "JSErrorModel{mType='" + this.f45832a + "', mContent='" + this.f45833b + "', mSource='" + this.f45834c + "'}";
        }
    }

    public synchronized boolean a(C0722a c0722a) {
        if (c0722a != null) {
            return this.f45831a.add(c0722a);
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
        for (C0722a c0722a : this.f45831a) {
            if (c0722a.b()) {
                i2++;
                if (c0722a.c()) {
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
        Iterator<C0722a> it = this.f45831a.iterator();
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
        return this.f45831a.isEmpty();
    }

    public synchronized int e() {
        return this.f45831a.size();
    }
}
