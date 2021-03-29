package d.b.i0.t.i.d;

import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f60800a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f60801b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60802c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60803d;

    /* renamed from: f  reason: collision with root package name */
    public int f60805f;

    /* renamed from: e  reason: collision with root package name */
    public int f60804e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f60806g = 1;

    public b(List<a2> list, boolean z, int i) {
        this.f60805f = 2;
        this.f60803d = z;
        this.f60805f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f60802c) {
            int size = this.f60801b.size();
            if (i == 0) {
                return (size - 1) - this.f60806g;
            }
            int i2 = this.f60806g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<a2> list = this.f60800a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f60802c ? i - this.f60806g : i;
    }

    public int d() {
        if (this.f60802c) {
            return this.f60806g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f60801b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f60800a;
        if (list != null) {
            if (this.f60802c) {
                if (list.size() > this.f60805f && this.f60800a.size() >= this.f60806g) {
                    arrayList.addAll(this.f60800a.subList(0, this.f60805f));
                    List<a2> list2 = this.f60800a;
                    int i = this.f60805f;
                    arrayList.addAll(0, list2.subList(i - this.f60806g, i));
                    arrayList.addAll(this.f60800a.subList(0, this.f60806g));
                } else {
                    arrayList.addAll(this.f60800a);
                    List<a2> list3 = this.f60800a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f60806g, this.f60800a.size()));
                    arrayList.addAll(this.f60800a.subList(0, this.f60806g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f60800a.size();
                int i2 = this.f60806g;
                if (size >= i2) {
                    arrayList.addAll(this.f60800a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f60806g = i;
        j(this.f60800a);
    }

    public void h(int i) {
        this.f60805f = i;
        j(this.f60800a);
    }

    public void i(int i) {
        this.f60804e = i;
        j(this.f60800a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f60800a = list;
        if (list != null && list.size() >= this.f60804e && list.size() <= this.f60805f) {
            this.f60802c = true;
        } else if (list.size() > this.f60805f && this.f60803d) {
            this.f60802c = true;
        } else {
            this.f60802c = false;
        }
        this.f60801b = f();
    }
}
