package d.a.o0.v.i.d;

import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f65835a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f65836b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65838d;

    /* renamed from: f  reason: collision with root package name */
    public int f65840f;

    /* renamed from: e  reason: collision with root package name */
    public int f65839e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f65841g = 1;

    public b(List<a2> list, boolean z, int i2) {
        this.f65840f = 2;
        this.f65838d = z;
        this.f65840f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f65837c) {
            int size = this.f65836b.size();
            if (i2 == 0) {
                return (size - 1) - this.f65841g;
            }
            int i3 = this.f65841g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<a2> list = this.f65835a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f65837c ? i2 - this.f65841g : i2;
    }

    public int d() {
        if (this.f65837c) {
            return this.f65841g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f65836b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f65835a;
        if (list != null) {
            if (this.f65837c) {
                if (list.size() > this.f65840f && this.f65835a.size() >= this.f65841g) {
                    arrayList.addAll(this.f65835a.subList(0, this.f65840f));
                    List<a2> list2 = this.f65835a;
                    int i2 = this.f65840f;
                    arrayList.addAll(0, list2.subList(i2 - this.f65841g, i2));
                    arrayList.addAll(this.f65835a.subList(0, this.f65841g));
                } else {
                    arrayList.addAll(this.f65835a);
                    List<a2> list3 = this.f65835a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f65841g, this.f65835a.size()));
                    arrayList.addAll(this.f65835a.subList(0, this.f65841g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f65835a.size();
                int i3 = this.f65841g;
                if (size >= i3) {
                    arrayList.addAll(this.f65835a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f65841g = i2;
        j(this.f65835a);
    }

    public void h(int i2) {
        this.f65840f = i2;
        j(this.f65835a);
    }

    public void i(int i2) {
        this.f65839e = i2;
        j(this.f65835a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f65835a = list;
        if (list != null && list.size() >= this.f65839e && list.size() <= this.f65840f) {
            this.f65837c = true;
        } else if (list.size() > this.f65840f && this.f65838d) {
            this.f65837c = true;
        } else {
            this.f65837c = false;
        }
        this.f65836b = f();
    }
}
