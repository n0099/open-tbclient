package d.b.i0.t.i.d;

import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f62364a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f62365b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62366c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62367d;

    /* renamed from: f  reason: collision with root package name */
    public int f62369f;

    /* renamed from: e  reason: collision with root package name */
    public int f62368e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f62370g = 1;

    public b(List<a2> list, boolean z, int i) {
        this.f62369f = 2;
        this.f62367d = z;
        this.f62369f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f62366c) {
            int size = this.f62365b.size();
            if (i == 0) {
                return (size - 1) - this.f62370g;
            }
            int i2 = this.f62370g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<a2> list = this.f62364a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f62366c ? i - this.f62370g : i;
    }

    public int d() {
        if (this.f62366c) {
            return this.f62370g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f62365b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f62364a;
        if (list != null) {
            if (this.f62366c) {
                if (list.size() > this.f62369f && this.f62364a.size() >= this.f62370g) {
                    arrayList.addAll(this.f62364a.subList(0, this.f62369f));
                    List<a2> list2 = this.f62364a;
                    int i = this.f62369f;
                    arrayList.addAll(0, list2.subList(i - this.f62370g, i));
                    arrayList.addAll(this.f62364a.subList(0, this.f62370g));
                } else {
                    arrayList.addAll(this.f62364a);
                    List<a2> list3 = this.f62364a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f62370g, this.f62364a.size()));
                    arrayList.addAll(this.f62364a.subList(0, this.f62370g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f62364a.size();
                int i2 = this.f62370g;
                if (size >= i2) {
                    arrayList.addAll(this.f62364a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f62370g = i;
        j(this.f62364a);
    }

    public void h(int i) {
        this.f62369f = i;
        j(this.f62364a);
    }

    public void i(int i) {
        this.f62368e = i;
        j(this.f62364a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f62364a = list;
        if (list != null && list.size() >= this.f62368e && list.size() <= this.f62369f) {
            this.f62366c = true;
        } else if (list.size() > this.f62369f && this.f62367d) {
            this.f62366c = true;
        } else {
            this.f62366c = false;
        }
        this.f62365b = f();
    }
}
