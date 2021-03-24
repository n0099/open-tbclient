package d.b.i0.t.i.d;

import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f60799a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f60800b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60801c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60802d;

    /* renamed from: f  reason: collision with root package name */
    public int f60804f;

    /* renamed from: e  reason: collision with root package name */
    public int f60803e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f60805g = 1;

    public b(List<a2> list, boolean z, int i) {
        this.f60804f = 2;
        this.f60802d = z;
        this.f60804f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f60801c) {
            int size = this.f60800b.size();
            if (i == 0) {
                return (size - 1) - this.f60805g;
            }
            int i2 = this.f60805g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<a2> list = this.f60799a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f60801c ? i - this.f60805g : i;
    }

    public int d() {
        if (this.f60801c) {
            return this.f60805g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f60800b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f60799a;
        if (list != null) {
            if (this.f60801c) {
                if (list.size() > this.f60804f && this.f60799a.size() >= this.f60805g) {
                    arrayList.addAll(this.f60799a.subList(0, this.f60804f));
                    List<a2> list2 = this.f60799a;
                    int i = this.f60804f;
                    arrayList.addAll(0, list2.subList(i - this.f60805g, i));
                    arrayList.addAll(this.f60799a.subList(0, this.f60805g));
                } else {
                    arrayList.addAll(this.f60799a);
                    List<a2> list3 = this.f60799a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f60805g, this.f60799a.size()));
                    arrayList.addAll(this.f60799a.subList(0, this.f60805g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f60799a.size();
                int i2 = this.f60805g;
                if (size >= i2) {
                    arrayList.addAll(this.f60799a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f60805g = i;
        j(this.f60799a);
    }

    public void h(int i) {
        this.f60804f = i;
        j(this.f60799a);
    }

    public void i(int i) {
        this.f60803e = i;
        j(this.f60799a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f60799a = list;
        if (list != null && list.size() >= this.f60803e && list.size() <= this.f60804f) {
            this.f60801c = true;
        } else if (list.size() > this.f60804f && this.f60802d) {
            this.f60801c = true;
        } else {
            this.f60801c = false;
        }
        this.f60800b = f();
    }
}
