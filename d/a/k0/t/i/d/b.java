package d.a.k0.t.i.d;

import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f61707a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f61708b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61709c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61710d;

    /* renamed from: f  reason: collision with root package name */
    public int f61712f;

    /* renamed from: e  reason: collision with root package name */
    public int f61711e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f61713g = 1;

    public b(List<a2> list, boolean z, int i2) {
        this.f61712f = 2;
        this.f61710d = z;
        this.f61712f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f61709c) {
            int size = this.f61708b.size();
            if (i2 == 0) {
                return (size - 1) - this.f61713g;
            }
            int i3 = this.f61713g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<a2> list = this.f61707a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f61709c ? i2 - this.f61713g : i2;
    }

    public int d() {
        if (this.f61709c) {
            return this.f61713g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f61708b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f61707a;
        if (list != null) {
            if (this.f61709c) {
                if (list.size() > this.f61712f && this.f61707a.size() >= this.f61713g) {
                    arrayList.addAll(this.f61707a.subList(0, this.f61712f));
                    List<a2> list2 = this.f61707a;
                    int i2 = this.f61712f;
                    arrayList.addAll(0, list2.subList(i2 - this.f61713g, i2));
                    arrayList.addAll(this.f61707a.subList(0, this.f61713g));
                } else {
                    arrayList.addAll(this.f61707a);
                    List<a2> list3 = this.f61707a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f61713g, this.f61707a.size()));
                    arrayList.addAll(this.f61707a.subList(0, this.f61713g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f61707a.size();
                int i3 = this.f61713g;
                if (size >= i3) {
                    arrayList.addAll(this.f61707a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f61713g = i2;
        j(this.f61707a);
    }

    public void h(int i2) {
        this.f61712f = i2;
        j(this.f61707a);
    }

    public void i(int i2) {
        this.f61711e = i2;
        j(this.f61707a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f61707a = list;
        if (list != null && list.size() >= this.f61711e && list.size() <= this.f61712f) {
            this.f61709c = true;
        } else if (list.size() > this.f61712f && this.f61710d) {
            this.f61709c = true;
        } else {
            this.f61709c = false;
        }
        this.f61708b = f();
    }
}
