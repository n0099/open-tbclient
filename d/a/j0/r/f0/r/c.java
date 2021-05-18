package d.a.j0.r.f0.r;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f49766a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f49767b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49768c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49769d;

    /* renamed from: f  reason: collision with root package name */
    public int f49771f;

    /* renamed from: e  reason: collision with root package name */
    public int f49770e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f49772g = 1;

    public c(List<n> list, boolean z, int i2) {
        this.f49771f = 2;
        this.f49766a = list;
        this.f49769d = z;
        this.f49771f = i2;
        j(list);
    }

    public int a(int i2) {
        if (this.f49768c) {
            int size = this.f49767b.size();
            if (i2 == 0) {
                return (size - 1) - this.f49772g;
            }
            int i3 = this.f49772g;
            return i2 == size - i3 ? i3 : i2;
        }
        return i2;
    }

    public int b() {
        List<n> list = this.f49766a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i2) {
        return this.f49768c ? i2 - this.f49772g : i2;
    }

    public int d() {
        if (this.f49768c) {
            return this.f49772g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f49767b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f49766a;
        if (list != null) {
            if (this.f49768c) {
                if (list.size() > this.f49771f && this.f49766a.size() >= this.f49772g) {
                    arrayList.addAll(this.f49766a.subList(0, this.f49771f));
                    List<n> list2 = this.f49766a;
                    int i2 = this.f49771f;
                    arrayList.addAll(0, list2.subList(i2 - this.f49772g, i2));
                    arrayList.addAll(this.f49766a.subList(0, this.f49772g));
                } else {
                    arrayList.addAll(this.f49766a);
                    List<n> list3 = this.f49766a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f49772g, this.f49766a.size()));
                    arrayList.addAll(this.f49766a.subList(0, this.f49772g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f49766a.size();
                int i3 = this.f49772g;
                if (size >= i3) {
                    arrayList.addAll(this.f49766a.subList(0, i3));
                }
            }
        }
        return arrayList;
    }

    public void g(int i2) {
        this.f49772g = i2;
        j(this.f49766a);
    }

    public void h(int i2) {
        this.f49771f = i2;
        j(this.f49766a);
    }

    public void i(int i2) {
        this.f49770e = i2;
        j(this.f49766a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f49770e && list.size() <= this.f49771f) {
            this.f49768c = true;
        } else if (list.size() > this.f49771f && this.f49769d) {
            this.f49768c = true;
        } else {
            this.f49768c = false;
        }
        this.f49767b = f();
    }
}
