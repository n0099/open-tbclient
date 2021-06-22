package d.a.n0.r.f0.r;

import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f53592a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f53593b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53594c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53595d;

    /* renamed from: f  reason: collision with root package name */
    public int f53597f;

    /* renamed from: e  reason: collision with root package name */
    public int f53596e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f53598g = 1;

    public c(List<n> list, boolean z, int i2) {
        this.f53597f = 2;
        this.f53592a = list;
        this.f53595d = z;
        this.f53597f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f53594c) {
            int size = this.f53593b.size();
            if (i2 == 0) {
                return (size - 1) - this.f53598g;
            }
            int i3 = this.f53598g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<n> list = this.f53592a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f53594c ? i2 - this.f53598g : i2;
    }

    public int d() {
        if (this.f53594c) {
            return this.f53598g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f53593b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f53592a;
        if (list != null) {
            if (this.f53594c) {
                if (list.size() > this.f53597f && this.f53592a.size() >= this.f53598g) {
                    arrayList.addAll(this.f53592a.subList(0, this.f53597f));
                    List<n> list2 = this.f53592a;
                    int i2 = this.f53597f;
                    arrayList.addAll(0, list2.subList(i2 - this.f53598g, i2));
                    arrayList.addAll(this.f53592a.subList(0, this.f53598g));
                } else {
                    arrayList.addAll(this.f53592a);
                    List<n> list3 = this.f53592a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f53598g, this.f53592a.size()));
                    arrayList.addAll(this.f53592a.subList(0, this.f53598g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f53592a.size();
                int i3 = this.f53598g;
                if (size >= i3) {
                    arrayList.addAll(this.f53592a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f53598g = i2;
        j(this.f53592a);
    }

    public void h(int i2) {
        this.f53597f = i2;
        j(this.f53592a);
    }

    public void i(int i2) {
        this.f53596e = i2;
        j(this.f53592a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f53596e && list.size() <= this.f53597f) {
            this.f53594c = true;
        } else if (list.size() > this.f53597f && this.f53595d) {
            this.f53594c = true;
        } else {
            this.f53594c = false;
        }
        this.f53593b = f();
    }
}
