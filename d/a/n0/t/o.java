package d.a.n0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class o implements d.a.c.k.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f54586h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54587e;

    /* renamed from: f  reason: collision with root package name */
    public String f54588f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54589g = false;

    public String b() {
        return this.f54587e;
    }

    public String c() {
        return this.f54588f;
    }

    public boolean e() {
        return this.f54589g;
    }

    public void g(String str) {
        this.f54587e = str;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f54586h;
    }

    public void h(boolean z) {
        this.f54589g = z;
    }

    public void i(String str) {
        this.f54588f = str;
    }
}
