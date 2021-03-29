package d.b.h0.r.f0.r;

import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f50577a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f50578b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50579c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50580d;

    /* renamed from: f  reason: collision with root package name */
    public int f50582f;

    /* renamed from: e  reason: collision with root package name */
    public int f50581e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f50583g = 1;

    public c(List<n> list, boolean z, int i) {
        this.f50582f = 2;
        this.f50577a = list;
        this.f50580d = z;
        this.f50582f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f50579c) {
            int size = this.f50578b.size();
            if (i == 0) {
                return (size - 1) - this.f50583g;
            }
            int i2 = this.f50583g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<n> list = this.f50577a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f50579c ? i - this.f50583g : i;
    }

    public int d() {
        if (this.f50579c) {
            return this.f50583g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f50578b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f50577a;
        if (list != null) {
            if (this.f50579c) {
                if (list.size() > this.f50582f && this.f50577a.size() >= this.f50583g) {
                    arrayList.addAll(this.f50577a.subList(0, this.f50582f));
                    List<n> list2 = this.f50577a;
                    int i = this.f50582f;
                    arrayList.addAll(0, list2.subList(i - this.f50583g, i));
                    arrayList.addAll(this.f50577a.subList(0, this.f50583g));
                } else {
                    arrayList.addAll(this.f50577a);
                    List<n> list3 = this.f50577a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f50583g, this.f50577a.size()));
                    arrayList.addAll(this.f50577a.subList(0, this.f50583g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f50577a.size();
                int i2 = this.f50583g;
                if (size >= i2) {
                    arrayList.addAll(this.f50577a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f50583g = i;
        j(this.f50577a);
    }

    public void h(int i) {
        this.f50582f = i;
        j(this.f50577a);
    }

    public void i(int i) {
        this.f50581e = i;
        j(this.f50577a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f50581e && list.size() <= this.f50582f) {
            this.f50579c = true;
        } else if (list.size() > this.f50582f && this.f50580d) {
            this.f50579c = true;
        } else {
            this.f50579c = false;
        }
        this.f50578b = f();
    }
}
