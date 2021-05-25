package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f58014h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f58016f;

    /* renamed from: e  reason: collision with root package name */
    public int f58015e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f58017g = -1;

    public int c() {
        return this.f58017g;
    }

    public String e() {
        return this.f58016f;
    }

    public int f() {
        return this.f58015e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58014h;
    }

    public boolean h() {
        return StringUtils.isNull(this.f58016f) || this.f58015e < 0;
    }

    public void i(int i2) {
        this.f58017g = i2;
    }

    public void k(String str) {
        this.f58016f = str;
    }

    public void l(int i2) {
        this.f58015e = i2;
    }
}
