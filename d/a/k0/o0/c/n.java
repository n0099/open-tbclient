package d.a.k0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57905h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f57907f;

    /* renamed from: e  reason: collision with root package name */
    public int f57906e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f57908g = -1;

    public int c() {
        return this.f57908g;
    }

    public String e() {
        return this.f57907f;
    }

    public int f() {
        return this.f57906e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57905h;
    }

    public boolean h() {
        return StringUtils.isNull(this.f57907f) || this.f57906e < 0;
    }

    public void i(int i2) {
        this.f57908g = i2;
    }

    public void k(String str) {
        this.f57907f = str;
    }

    public void l(int i2) {
        this.f57906e = i2;
    }
}
