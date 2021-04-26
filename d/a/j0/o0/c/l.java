package d.a.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f57192i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f57193e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f57194f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f57195g;

    /* renamed from: h  reason: collision with root package name */
    public String f57196h;

    public String c() {
        return this.f57196h;
    }

    public int e() {
        return this.f57194f;
    }

    public boolean f() {
        return StringUtils.isNull(this.f57195g) || StringUtils.isNull(this.f57196h) || this.f57193e < 0 || this.f57194f < 0;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57192i;
    }

    public void h(String str) {
        this.f57196h = str;
    }

    public void i(int i2) {
        this.f57194f = i2;
    }

    public void k(int i2) {
    }

    public void l(String str) {
        this.f57195g = str;
    }

    public void m(int i2) {
        this.f57193e = i2;
    }
}
