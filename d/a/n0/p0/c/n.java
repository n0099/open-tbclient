package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.a.c.k.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f61705h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f61707f;

    /* renamed from: e  reason: collision with root package name */
    public int f61706e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f61708g = -1;

    public int b() {
        return this.f61708g;
    }

    public String c() {
        return this.f61707f;
    }

    public int e() {
        return this.f61706e;
    }

    public boolean g() {
        return StringUtils.isNull(this.f61707f) || this.f61706e < 0;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61705h;
    }

    public void h(int i2) {
        this.f61708g = i2;
    }

    public void i(String str) {
        this.f61707f = str;
    }

    public void k(int i2) {
        this.f61706e = i2;
    }
}
