package d.a.m0.r.f0.r;

import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f53485a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f53486b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53487c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53488d;

    /* renamed from: f  reason: collision with root package name */
    public int f53490f;

    /* renamed from: e  reason: collision with root package name */
    public int f53489e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f53491g = 1;

    public c(List<n> list, boolean z, int i2) {
        this.f53490f = 2;
        this.f53485a = list;
        this.f53488d = z;
        this.f53490f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f53487c) {
            int size = this.f53486b.size();
            if (i2 == 0) {
                return (size - 1) - this.f53491g;
            }
            int i3 = this.f53491g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<n> list = this.f53485a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f53487c ? i2 - this.f53491g : i2;
    }

    public int d() {
        if (this.f53487c) {
            return this.f53491g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f53486b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f53485a;
        if (list != null) {
            if (this.f53487c) {
                if (list.size() > this.f53490f && this.f53485a.size() >= this.f53491g) {
                    arrayList.addAll(this.f53485a.subList(0, this.f53490f));
                    List<n> list2 = this.f53485a;
                    int i2 = this.f53490f;
                    arrayList.addAll(0, list2.subList(i2 - this.f53491g, i2));
                    arrayList.addAll(this.f53485a.subList(0, this.f53491g));
                } else {
                    arrayList.addAll(this.f53485a);
                    List<n> list3 = this.f53485a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f53491g, this.f53485a.size()));
                    arrayList.addAll(this.f53485a.subList(0, this.f53491g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f53485a.size();
                int i3 = this.f53491g;
                if (size >= i3) {
                    arrayList.addAll(this.f53485a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f53491g = i2;
        j(this.f53485a);
    }

    public void h(int i2) {
        this.f53490f = i2;
        j(this.f53485a);
    }

    public void i(int i2) {
        this.f53489e = i2;
        j(this.f53485a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f53489e && list.size() <= this.f53490f) {
            this.f53487c = true;
        } else if (list.size() > this.f53490f && this.f53488d) {
            this.f53487c = true;
        } else {
            this.f53487c = false;
        }
        this.f53486b = f();
    }
}
