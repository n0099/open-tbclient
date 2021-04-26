package d.a.i0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class o implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f49910h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f49911e;

    /* renamed from: f  reason: collision with root package name */
    public String f49912f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49913g = false;

    public String c() {
        return this.f49911e;
    }

    public String e() {
        return this.f49912f;
    }

    public boolean f() {
        return this.f49913g;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f49910h;
    }

    public void h(String str) {
        this.f49911e = str;
    }

    public void i(boolean z) {
        this.f49913g = z;
    }

    public void k(String str) {
        this.f49912f = str;
    }
}
