package d.a.n0.v.i.d;

import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f61995a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f61996b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61997c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61998d;

    /* renamed from: f  reason: collision with root package name */
    public int f62000f;

    /* renamed from: e  reason: collision with root package name */
    public int f61999e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f62001g = 1;

    public b(List<a2> list, boolean z, int i2) {
        this.f62000f = 2;
        this.f61998d = z;
        this.f62000f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f61997c) {
            int size = this.f61996b.size();
            if (i2 == 0) {
                return (size - 1) - this.f62001g;
            }
            int i3 = this.f62001g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<a2> list = this.f61995a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f61997c ? i2 - this.f62001g : i2;
    }

    public int d() {
        if (this.f61997c) {
            return this.f62001g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f61996b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f61995a;
        if (list != null) {
            if (this.f61997c) {
                if (list.size() > this.f62000f && this.f61995a.size() >= this.f62001g) {
                    arrayList.addAll(this.f61995a.subList(0, this.f62000f));
                    List<a2> list2 = this.f61995a;
                    int i2 = this.f62000f;
                    arrayList.addAll(0, list2.subList(i2 - this.f62001g, i2));
                    arrayList.addAll(this.f61995a.subList(0, this.f62001g));
                } else {
                    arrayList.addAll(this.f61995a);
                    List<a2> list3 = this.f61995a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f62001g, this.f61995a.size()));
                    arrayList.addAll(this.f61995a.subList(0, this.f62001g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f61995a.size();
                int i3 = this.f62001g;
                if (size >= i3) {
                    arrayList.addAll(this.f61995a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f62001g = i2;
        j(this.f61995a);
    }

    public void h(int i2) {
        this.f62000f = i2;
        j(this.f61995a);
    }

    public void i(int i2) {
        this.f61999e = i2;
        j(this.f61995a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f61995a = list;
        if (list != null && list.size() >= this.f61999e && list.size() <= this.f62000f) {
            this.f61997c = true;
        } else if (list.size() > this.f62000f && this.f61998d) {
            this.f61997c = true;
        } else {
            this.f61997c = false;
        }
        this.f61996b = f();
    }
}
