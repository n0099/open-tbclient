package d.b.i0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.b.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f58749h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f58751f;

    /* renamed from: e  reason: collision with root package name */
    public int f58750e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f58752g = -1;

    public int a() {
        return this.f58752g;
    }

    public String e() {
        return this.f58751f;
    }

    public int f() {
        return this.f58750e;
    }

    public boolean g() {
        return StringUtils.isNull(this.f58751f) || this.f58750e < 0;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f58749h;
    }

    public void j(int i) {
        this.f58752g = i;
    }

    public void k(String str) {
        this.f58751f = str;
    }

    public void l(int i) {
        this.f58750e = i;
    }
}
