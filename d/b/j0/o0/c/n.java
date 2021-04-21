package d.b.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.b.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f59170h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f59172f;

    /* renamed from: e  reason: collision with root package name */
    public int f59171e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f59173g = -1;

    public int a() {
        return this.f59173g;
    }

    public String e() {
        return this.f59172f;
    }

    public int f() {
        return this.f59171e;
    }

    public boolean g() {
        return StringUtils.isNull(this.f59172f) || this.f59171e < 0;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f59170h;
    }

    public void j(int i) {
        this.f59173g = i;
    }

    public void k(String str) {
        this.f59172f = str;
    }

    public void l(int i) {
        this.f59171e = i;
    }
}
