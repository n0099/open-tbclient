package d.a.j0.t.i.d;

import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f60983a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f60984b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60985c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60986d;

    /* renamed from: f  reason: collision with root package name */
    public int f60988f;

    /* renamed from: e  reason: collision with root package name */
    public int f60987e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f60989g = 1;

    public b(List<a2> list, boolean z, int i2) {
        this.f60988f = 2;
        this.f60986d = z;
        this.f60988f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f60985c) {
            int size = this.f60984b.size();
            if (i2 == 0) {
                return (size - 1) - this.f60989g;
            }
            int i3 = this.f60989g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<a2> list = this.f60983a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f60985c ? i2 - this.f60989g : i2;
    }

    public int d() {
        if (this.f60985c) {
            return this.f60989g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f60984b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f60983a;
        if (list != null) {
            if (this.f60985c) {
                if (list.size() > this.f60988f && this.f60983a.size() >= this.f60989g) {
                    arrayList.addAll(this.f60983a.subList(0, this.f60988f));
                    List<a2> list2 = this.f60983a;
                    int i2 = this.f60988f;
                    arrayList.addAll(0, list2.subList(i2 - this.f60989g, i2));
                    arrayList.addAll(this.f60983a.subList(0, this.f60989g));
                } else {
                    arrayList.addAll(this.f60983a);
                    List<a2> list3 = this.f60983a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f60989g, this.f60983a.size()));
                    arrayList.addAll(this.f60983a.subList(0, this.f60989g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f60983a.size();
                int i3 = this.f60989g;
                if (size >= i3) {
                    arrayList.addAll(this.f60983a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f60989g = i2;
        j(this.f60983a);
    }

    public void h(int i2) {
        this.f60988f = i2;
        j(this.f60983a);
    }

    public void i(int i2) {
        this.f60987e = i2;
        j(this.f60983a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f60983a = list;
        if (list != null && list.size() >= this.f60987e && list.size() <= this.f60988f) {
            this.f60985c = true;
        } else if (list.size() > this.f60988f && this.f60986d) {
            this.f60985c = true;
        } else {
            this.f60985c = false;
        }
        this.f60984b = f();
    }
}
