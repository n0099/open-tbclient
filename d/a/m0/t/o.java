package d.a.m0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class o implements d.a.c.k.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f54479h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54480e;

    /* renamed from: f  reason: collision with root package name */
    public String f54481f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54482g = false;

    public String b() {
        return this.f54480e;
    }

    public String c() {
        return this.f54481f;
    }

    public boolean e() {
        return this.f54482g;
    }

    public void g(String str) {
        this.f54480e = str;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f54479h;
    }

    public void h(boolean z) {
        this.f54482g = z;
    }

    public void i(String str) {
        this.f54481f = str;
    }
}
