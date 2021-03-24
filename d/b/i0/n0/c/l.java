package d.b.i0.n0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.b.b.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f57044e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f57045f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f57046g;

    /* renamed from: h  reason: collision with root package name */
    public String f57047h;

    public String a() {
        return this.f57047h;
    }

    public int e() {
        return this.f57045f;
    }

    public boolean f() {
        return StringUtils.isNull(this.f57046g) || StringUtils.isNull(this.f57047h) || this.f57044e < 0 || this.f57045f < 0;
    }

    public void g(String str) {
        this.f57047h = str;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public void j(int i2) {
        this.f57045f = i2;
    }

    public void k(int i2) {
    }

    public void l(String str) {
        this.f57046g = str;
    }

    public void n(int i2) {
        this.f57044e = i2;
    }
}
