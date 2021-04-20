package d.b.i0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class l implements d.b.c.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f58744e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f58745f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f58746g;

    /* renamed from: h  reason: collision with root package name */
    public String f58747h;

    public String a() {
        return this.f58747h;
    }

    public int e() {
        return this.f58745f;
    }

    public boolean f() {
        return StringUtils.isNull(this.f58746g) || StringUtils.isNull(this.f58747h) || this.f58744e < 0 || this.f58745f < 0;
    }

    public void g(String str) {
        this.f58747h = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public void j(int i2) {
        this.f58745f = i2;
    }

    public void k(int i2) {
    }

    public void l(String str) {
        this.f58746g = str;
    }

    public void n(int i2) {
        this.f58744e = i2;
    }
}
