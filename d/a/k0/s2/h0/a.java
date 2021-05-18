package d.a.k0.s2.h0;

import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.c.e.p.l;
import d.a.j0.z0.c;
import d.a.k0.s2.d;
import d.a.k0.s2.k;
import d.a.k0.s2.o;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.k0.o.b.a f61028a;
    public final int k;
    public final int l;
    public final int m;

    /* renamed from: b  reason: collision with root package name */
    public final int f61029b = d.a.k0.a.e().j();

    /* renamed from: c  reason: collision with root package name */
    public final int f61030c = d.a.k0.a.e().m();

    /* renamed from: d  reason: collision with root package name */
    public final int f61031d = d.a.k0.a.e().g();

    /* renamed from: e  reason: collision with root package name */
    public final int f61032e = d.a.k0.a.e().h() - 1;

    /* renamed from: f  reason: collision with root package name */
    public final int f61033f = d.a.k0.a.e().i();

    /* renamed from: g  reason: collision with root package name */
    public final int f61034g = d.a.k0.a.e().l();

    /* renamed from: h  reason: collision with root package name */
    public final int f61035h = d.a.k0.a.e().k();
    public int j = d.a("daily_show_count");

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f61036i = new HashMap();

    public a() {
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        this.f61028a = new d.a.k0.o.b.a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", d.a.k0.a.e().n());
    }

    @Override // d.a.k0.s2.k
    public AdvertAppInfo a(c cVar) {
        if (!cVar.j && !cVar.k) {
            int i2 = cVar.f50909c;
            String str = cVar.f50913g;
            int i3 = cVar.f50910d;
            int i4 = cVar.f50915i;
            float f2 = cVar.f50912f;
            int i5 = cVar.f50914h;
            f(i2, i3, i4, cVar);
            if (this.f61036i.containsKey(str)) {
                return this.f61036i.get(str);
            }
            if (d(i2, i3) && e(i5, f2, cVar.f50911e)) {
                AdvertAppInfo c2 = this.f61028a.c();
                if (c2 != null) {
                    c2.P3 = "PIC_PAGE_BANNER";
                    c2.position = i2;
                    this.f61036i.put(str, c2);
                    int i6 = this.j + 1;
                    this.j = i6;
                    d.g("daily_show_count", i6);
                }
                return c2;
            }
        }
        return null;
    }

    @Override // d.a.k0.s2.k
    public o b(ViewStub viewStub, TbPageContext tbPageContext) {
        return new d.a.k0.s2.f0.d.a.c(viewStub, tbPageContext);
    }

    public final Map<String, String> c(c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("forum_id", cVar.l);
        hashMap.put("forum_name", cVar.m);
        return hashMap;
    }

    public final boolean d(int i2, int i3) {
        if (i2 >= this.f61032e && i2 > i3) {
            return i3 == 0 || i2 - i3 >= this.f61033f;
        }
        return false;
    }

    public final boolean e(int i2, float f2, float f3) {
        int i3;
        if (this.f61029b == 4) {
            return true;
        }
        if (f2 == 0.0f) {
            return false;
        }
        if (!(((float) this.k) / ((float) this.l) > f2)) {
            return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f61029b) == 1 || i3 == 2);
        }
        int i4 = this.f61029b;
        return i4 == 3 || i4 == 1;
    }

    public final void f(int i2, int i3, int i4, c cVar) {
        if (this.j >= this.f61035h) {
            return;
        }
        this.f61028a.b(this.f61031d);
        if (!this.f61028a.d() && i2 > i3) {
            int i5 = this.f61033f;
            if (i3 + i5 <= i4 && i2 >= (i3 + i5) - this.f61034g) {
                this.f61028a.f(Math.min(this.f61035h - this.j, this.f61030c), c(cVar));
            }
        }
    }

    @Override // d.a.k0.s2.k
    public void onDestroy() {
        this.f61028a.e();
    }
}
