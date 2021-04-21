package d.b.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.b.c.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f59165e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f59166f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f59167g;

    /* renamed from: h  reason: collision with root package name */
    public String f59168h;

    public String a() {
        return this.f59168h;
    }

    public int e() {
        return this.f59166f;
    }

    public boolean f() {
        return StringUtils.isNull(this.f59167g) || StringUtils.isNull(this.f59168h) || this.f59165e < 0 || this.f59166f < 0;
    }

    public void g(String str) {
        this.f59168h = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public void j(int i2) {
        this.f59166f = i2;
    }

    public void k(int i2) {
    }

    public void l(String str) {
        this.f59167g = str;
    }

    public void n(int i2) {
        this.f59165e = i2;
    }
}
