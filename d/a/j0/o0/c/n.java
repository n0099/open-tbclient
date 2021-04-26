package d.a.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57198h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f57200f;

    /* renamed from: e  reason: collision with root package name */
    public int f57199e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f57201g = -1;

    public int c() {
        return this.f57201g;
    }

    public String e() {
        return this.f57200f;
    }

    public int f() {
        return this.f57199e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57198h;
    }

    public boolean h() {
        return StringUtils.isNull(this.f57200f) || this.f57199e < 0;
    }

    public void i(int i2) {
        this.f57201g = i2;
    }

    public void k(String str) {
        this.f57200f = str;
    }

    public void l(int i2) {
        this.f57199e = i2;
    }
}
