package d.a.n0.v.i.d;

import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f65710a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f65711b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65712c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65713d;

    /* renamed from: f  reason: collision with root package name */
    public int f65715f;

    /* renamed from: e  reason: collision with root package name */
    public int f65714e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f65716g = 1;

    public b(List<a2> list, boolean z, int i2) {
        this.f65715f = 2;
        this.f65713d = z;
        this.f65715f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f65712c) {
            int size = this.f65711b.size();
            if (i2 == 0) {
                return (size - 1) - this.f65716g;
            }
            int i3 = this.f65716g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<a2> list = this.f65710a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f65712c ? i2 - this.f65716g : i2;
    }

    public int d() {
        if (this.f65712c) {
            return this.f65716g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f65711b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f65710a;
        if (list != null) {
            if (this.f65712c) {
                if (list.size() > this.f65715f && this.f65710a.size() >= this.f65716g) {
                    arrayList.addAll(this.f65710a.subList(0, this.f65715f));
                    List<a2> list2 = this.f65710a;
                    int i2 = this.f65715f;
                    arrayList.addAll(0, list2.subList(i2 - this.f65716g, i2));
                    arrayList.addAll(this.f65710a.subList(0, this.f65716g));
                } else {
                    arrayList.addAll(this.f65710a);
                    List<a2> list3 = this.f65710a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f65716g, this.f65710a.size()));
                    arrayList.addAll(this.f65710a.subList(0, this.f65716g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f65710a.size();
                int i3 = this.f65716g;
                if (size >= i3) {
                    arrayList.addAll(this.f65710a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f65716g = i2;
        j(this.f65710a);
    }

    public void h(int i2) {
        this.f65715f = i2;
        j(this.f65710a);
    }

    public void i(int i2) {
        this.f65714e = i2;
        j(this.f65710a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f65710a = list;
        if (list != null && list.size() >= this.f65714e && list.size() <= this.f65715f) {
            this.f65712c = true;
        } else if (list.size() > this.f65715f && this.f65713d) {
            this.f65712c = true;
        } else {
            this.f65712c = false;
        }
        this.f65711b = f();
    }
}
