package d.b.i0.n0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class n implements d.b.b.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57049h = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public String f57051f;

    /* renamed from: e  reason: collision with root package name */
    public int f57050e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f57052g = -1;

    public int a() {
        return this.f57052g;
    }

    public String e() {
        return this.f57051f;
    }

    public int f() {
        return this.f57050e;
    }

    public boolean g() {
        return StringUtils.isNull(this.f57051f) || this.f57050e < 0;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f57049h;
    }

    public void j(int i) {
        this.f57052g = i;
    }

    public void k(String str) {
        this.f57051f = str;
    }

    public void l(int i) {
        this.f57050e = i;
    }
}
