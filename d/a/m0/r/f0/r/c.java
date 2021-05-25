package d.a.m0.r.f0.r;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f49810a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f49811b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49812c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49813d;

    /* renamed from: f  reason: collision with root package name */
    public int f49815f;

    /* renamed from: e  reason: collision with root package name */
    public int f49814e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f49816g = 1;

    public c(List<n> list, boolean z, int i2) {
        this.f49815f = 2;
        this.f49810a = list;
        this.f49813d = z;
        this.f49815f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f49812c) {
            int size = this.f49811b.size();
            if (i2 == 0) {
                return (size - 1) - this.f49816g;
            }
            int i3 = this.f49816g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<n> list = this.f49810a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f49812c ? i2 - this.f49816g : i2;
    }

    public int d() {
        if (this.f49812c) {
            return this.f49816g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f49811b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f49810a;
        if (list != null) {
            if (this.f49812c) {
                if (list.size() > this.f49815f && this.f49810a.size() >= this.f49816g) {
                    arrayList.addAll(this.f49810a.subList(0, this.f49815f));
                    List<n> list2 = this.f49810a;
                    int i2 = this.f49815f;
                    arrayList.addAll(0, list2.subList(i2 - this.f49816g, i2));
                    arrayList.addAll(this.f49810a.subList(0, this.f49816g));
                } else {
                    arrayList.addAll(this.f49810a);
                    List<n> list3 = this.f49810a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f49816g, this.f49810a.size()));
                    arrayList.addAll(this.f49810a.subList(0, this.f49816g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f49810a.size();
                int i3 = this.f49816g;
                if (size >= i3) {
                    arrayList.addAll(this.f49810a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f49816g = i2;
        j(this.f49810a);
    }

    public void h(int i2) {
        this.f49815f = i2;
        j(this.f49810a);
    }

    public void i(int i2) {
        this.f49814e = i2;
        j(this.f49810a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f49814e && list.size() <= this.f49815f) {
            this.f49812c = true;
        } else if (list.size() > this.f49815f && this.f49813d) {
            this.f49812c = true;
        } else {
            this.f49812c = false;
        }
        this.f49811b = f();
    }
}
