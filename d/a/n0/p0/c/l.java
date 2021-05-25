package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f58008i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f58009e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f58010f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f58011g;

    /* renamed from: h  reason: collision with root package name */
    public String f58012h;

    public String c() {
        return this.f58012h;
    }

    public int e() {
        return this.f58010f;
    }

    public boolean f() {
        return StringUtils.isNull(this.f58011g) || StringUtils.isNull(this.f58012h) || this.f58009e < 0 || this.f58010f < 0;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58008i;
    }

    public void h(String str) {
        this.f58012h = str;
    }

    public void i(int i2) {
        this.f58010f = i2;
    }

    public void k(int i2) {
    }

    public void l(String str) {
        this.f58011g = str;
    }

    public void m(int i2) {
        this.f58009e = i2;
    }
}
