package d.a.o0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.a.c.k.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f61824i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61825e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f61826f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f61827g;

    /* renamed from: h  reason: collision with root package name */
    public String f61828h;

    public String b() {
        return this.f61828h;
    }

    public int c() {
        return this.f61826f;
    }

    public boolean e() {
        return StringUtils.isNull(this.f61827g) || StringUtils.isNull(this.f61828h) || this.f61825e < 0 || this.f61826f < 0;
    }

    public void g(String str) {
        this.f61828h = str;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61824i;
    }

    public void h(int i2) {
        this.f61826f = i2;
    }

    public void i(int i2) {
    }

    public void k(String str) {
        this.f61827g = str;
    }

    public void l(int i2) {
        this.f61825e = i2;
    }
}
