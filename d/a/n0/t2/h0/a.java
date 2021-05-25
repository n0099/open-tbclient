package d.a.n0.t2.h0;

import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.c.e.p.l;
import d.a.m0.z0.c;
import d.a.n0.t2.d;
import d.a.n0.t2.k;
import d.a.n0.t2.o;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.n0.q.b.a f61130a;
    public final int k;
    public final int l;
    public final int m;

    /* renamed from: b  reason: collision with root package name */
    public final int f61131b = d.a.n0.a.h().m();

    /* renamed from: c  reason: collision with root package name */
    public final int f61132c = d.a.n0.a.h().p();

    /* renamed from: d  reason: collision with root package name */
    public final int f61133d = d.a.n0.a.h().j();

    /* renamed from: e  reason: collision with root package name */
    public final int f61134e = d.a.n0.a.h().k() - 1;

    /* renamed from: f  reason: collision with root package name */
    public final int f61135f = d.a.n0.a.h().l();

    /* renamed from: g  reason: collision with root package name */
    public final int f61136g = d.a.n0.a.h().o();

    /* renamed from: h  reason: collision with root package name */
    public final int f61137h = d.a.n0.a.h().n();
    public int j = d.a("daily_show_count");

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f61138i = new HashMap();

    public a() {
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        this.f61130a = new d.a.n0.q.b.a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", d.a.n0.a.h().q());
    }

    @Override // d.a.n0.t2.k
    public AdvertAppInfo a(c cVar) {
        if (!cVar.j && !cVar.k) {
            int i2 = cVar.f50982c;
            String str = cVar.f50986g;
            int i3 = cVar.f50983d;
            int i4 = cVar.f50988i;
            float f2 = cVar.f50985f;
            int i5 = cVar.f50987h;
            f(i2, i3, i4, cVar);
            if (this.f61138i.containsKey(str)) {
                return this.f61138i.get(str);
            }
            if (d(i2, i3) && e(i5, f2, cVar.f50984e)) {
                AdvertAppInfo c2 = this.f61130a.c();
                if (c2 != null) {
                    c2.Q3 = "PIC_PAGE_BANNER";
                    c2.position = i2;
                    this.f61138i.put(str, c2);
                    int i6 = this.j + 1;
                    this.j = i6;
                    d.g("daily_show_count", i6);
                }
                return c2;
            }
        }
        return null;
    }

    @Override // d.a.n0.t2.k
    public o b(ViewStub viewStub, TbPageContext tbPageContext) {
        return new d.a.n0.t2.f0.d.a.c(viewStub, tbPageContext);
    }

    public final Map<String, String> c(c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("forum_id", cVar.l);
        hashMap.put("forum_name", cVar.m);
        return hashMap;
    }

    public final boolean d(int i2, int i3) {
        if (i2 >= this.f61134e && i2 > i3) {
            return i3 == 0 || i2 - i3 >= this.f61135f;
        }
        return false;
    }

    public final boolean e(int i2, float f2, float f3) {
        int i3;
        if (this.f61131b == 4) {
            return true;
        }
        if (f2 == 0.0f) {
            return false;
        }
        if (!(((float) this.k) / ((float) this.l) > f2)) {
            return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f61131b) == 1 || i3 == 2);
        }
        int i4 = this.f61131b;
        return i4 == 3 || i4 == 1;
    }

    public final void f(int i2, int i3, int i4, c cVar) {
        if (this.j >= this.f61137h) {
            return;
        }
        this.f61130a.b(this.f61133d);
        if (!this.f61130a.d() && i2 > i3) {
            int i5 = this.f61135f;
            if (i3 + i5 <= i4 && i2 >= (i3 + i5) - this.f61136g) {
                this.f61130a.f(Math.min(this.f61137h - this.j, this.f61132c), c(cVar));
            }
        }
    }

    @Override // d.a.n0.t2.k
    public void onDestroy() {
        this.f61130a.e();
    }
}
