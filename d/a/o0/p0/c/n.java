package d.a.o0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.a.c.k.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f61830h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f61832f;

    /* renamed from: e  reason: collision with root package name */
    public int f61831e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f61833g = -1;

    public int b() {
        return this.f61833g;
    }

    public String c() {
        return this.f61832f;
    }

    public int e() {
        return this.f61831e;
    }

    public boolean g() {
        return StringUtils.isNull(this.f61832f) || this.f61831e < 0;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61830h;
    }

    public void h(int i2) {
        this.f61833g = i2;
    }

    public void i(String str) {
        this.f61832f = str;
    }

    public void k(int i2) {
        this.f61831e = i2;
    }
}
