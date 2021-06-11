package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.a.c.k.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f61699i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61700e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f61701f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f61702g;

    /* renamed from: h  reason: collision with root package name */
    public String f61703h;

    public String b() {
        return this.f61703h;
    }

    public int c() {
        return this.f61701f;
    }

    public boolean e() {
        return StringUtils.isNull(this.f61702g) || StringUtils.isNull(this.f61703h) || this.f61700e < 0 || this.f61701f < 0;
    }

    public void g(String str) {
        this.f61703h = str;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61699i;
    }

    public void h(int i2) {
        this.f61701f = i2;
    }

    public void i(int i2) {
    }

    public void k(String str) {
        this.f61702g = str;
    }

    public void l(int i2) {
        this.f61700e = i2;
    }
}
