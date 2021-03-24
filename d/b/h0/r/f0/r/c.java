package d.b.h0.r.f0.r;

import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f50576a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f50577b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50578c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50579d;

    /* renamed from: f  reason: collision with root package name */
    public int f50581f;

    /* renamed from: e  reason: collision with root package name */
    public int f50580e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f50582g = 1;

    public c(List<n> list, boolean z, int i) {
        this.f50581f = 2;
        this.f50576a = list;
        this.f50579d = z;
        this.f50581f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f50578c) {
            int size = this.f50577b.size();
            if (i == 0) {
                return (size - 1) - this.f50582g;
            }
            int i2 = this.f50582g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<n> list = this.f50576a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f50578c ? i - this.f50582g : i;
    }

    public int d() {
        if (this.f50578c) {
            return this.f50582g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f50577b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f50576a;
        if (list != null) {
            if (this.f50578c) {
                if (list.size() > this.f50581f && this.f50576a.size() >= this.f50582g) {
                    arrayList.addAll(this.f50576a.subList(0, this.f50581f));
                    List<n> list2 = this.f50576a;
                    int i = this.f50581f;
                    arrayList.addAll(0, list2.subList(i - this.f50582g, i));
                    arrayList.addAll(this.f50576a.subList(0, this.f50582g));
                } else {
                    arrayList.addAll(this.f50576a);
                    List<n> list3 = this.f50576a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f50582g, this.f50576a.size()));
                    arrayList.addAll(this.f50576a.subList(0, this.f50582g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f50576a.size();
                int i2 = this.f50582g;
                if (size >= i2) {
                    arrayList.addAll(this.f50576a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f50582g = i;
        j(this.f50576a);
    }

    public void h(int i) {
        this.f50581f = i;
        j(this.f50576a);
    }

    public void i(int i) {
        this.f50580e = i;
        j(this.f50576a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f50580e && list.size() <= this.f50581f) {
            this.f50578c = true;
        } else if (list.size() > this.f50581f && this.f50579d) {
            this.f50578c = true;
        } else {
            this.f50578c = false;
        }
        this.f50577b = f();
    }
}
