package d.a.i0.r.f0.r;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f48936a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f48937b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48938c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48939d;

    /* renamed from: f  reason: collision with root package name */
    public int f48941f;

    /* renamed from: e  reason: collision with root package name */
    public int f48940e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f48942g = 1;

    public c(List<n> list, boolean z, int i2) {
        this.f48941f = 2;
        this.f48936a = list;
        this.f48939d = z;
        this.f48941f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f48938c) {
            int size = this.f48937b.size();
            if (i2 == 0) {
                return (size - 1) - this.f48942g;
            }
            int i3 = this.f48942g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<n> list = this.f48936a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f48938c ? i2 - this.f48942g : i2;
    }

    public int d() {
        if (this.f48938c) {
            return this.f48942g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f48937b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f48936a;
        if (list != null) {
            if (this.f48938c) {
                if (list.size() > this.f48941f && this.f48936a.size() >= this.f48942g) {
                    arrayList.addAll(this.f48936a.subList(0, this.f48941f));
                    List<n> list2 = this.f48936a;
                    int i2 = this.f48941f;
                    arrayList.addAll(0, list2.subList(i2 - this.f48942g, i2));
                    arrayList.addAll(this.f48936a.subList(0, this.f48942g));
                } else {
                    arrayList.addAll(this.f48936a);
                    List<n> list3 = this.f48936a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f48942g, this.f48936a.size()));
                    arrayList.addAll(this.f48936a.subList(0, this.f48942g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f48936a.size();
                int i3 = this.f48942g;
                if (size >= i3) {
                    arrayList.addAll(this.f48936a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f48942g = i2;
        j(this.f48936a);
    }

    public void h(int i2) {
        this.f48941f = i2;
        j(this.f48936a);
    }

    public void i(int i2) {
        this.f48940e = i2;
        j(this.f48936a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f48940e && list.size() <= this.f48941f) {
            this.f48938c = true;
        } else if (list.size() > this.f48941f && this.f48939d) {
            this.f48938c = true;
        } else {
            this.f48938c = false;
        }
        this.f48937b = f();
    }
}
