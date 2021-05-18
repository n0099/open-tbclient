package d.a.k0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f57899i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f57900e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f57901f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f57902g;

    /* renamed from: h  reason: collision with root package name */
    public String f57903h;

    public String c() {
        return this.f57903h;
    }

    public int e() {
        return this.f57901f;
    }

    public boolean f() {
        return StringUtils.isNull(this.f57902g) || StringUtils.isNull(this.f57903h) || this.f57900e < 0 || this.f57901f < 0;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57899i;
    }

    public void h(String str) {
        this.f57903h = str;
    }

    public void i(int i2) {
        this.f57901f = i2;
    }

    public void k(int i2) {
    }

    public void l(String str) {
        this.f57902g = str;
    }

    public void m(int i2) {
        this.f57900e = i2;
    }
}
