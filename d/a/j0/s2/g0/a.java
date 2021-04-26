package d.a.j0.s2.g0;

import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.c.e.p.l;
import d.a.j0.s2.c;
import d.a.j0.s2.j;
import d.a.j0.s2.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.j0.o.b.a f60285a;
    public final int k;
    public final int l;
    public final int m;

    /* renamed from: b  reason: collision with root package name */
    public final int f60286b = d.a.j0.a.e().j();

    /* renamed from: c  reason: collision with root package name */
    public final int f60287c = d.a.j0.a.e().m();

    /* renamed from: d  reason: collision with root package name */
    public final int f60288d = d.a.j0.a.e().g();

    /* renamed from: e  reason: collision with root package name */
    public final int f60289e = d.a.j0.a.e().h() - 1;

    /* renamed from: f  reason: collision with root package name */
    public final int f60290f = d.a.j0.a.e().i();

    /* renamed from: g  reason: collision with root package name */
    public final int f60291g = d.a.j0.a.e().l();

    /* renamed from: h  reason: collision with root package name */
    public final int f60292h = d.a.j0.a.e().k();
    public int j = c.a("daily_show_count");

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f60293i = new HashMap();

    public a() {
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        this.f60285a = new d.a.j0.o.b.a(PlaceId.PIC_PAGE_BANNER, "PB_BANNER", d.a.j0.a.e().n());
    }

    @Override // d.a.j0.s2.j
    public AdvertAppInfo a(d.a.i0.z0.c cVar) {
        if (!cVar.j && !cVar.k) {
            int i2 = cVar.f50090c;
            String str = cVar.f50094g;
            int i3 = cVar.f50091d;
            int i4 = cVar.f50096i;
            float f2 = cVar.f50093f;
            int i5 = cVar.f50095h;
            f(i2, i3, i4, cVar);
            if (this.f60293i.containsKey(str)) {
                return this.f60293i.get(str);
            }
            if (d(i2, i3) && e(i5, f2, cVar.f50092e)) {
                AdvertAppInfo c2 = this.f60285a.c();
                if (c2 != null) {
                    c2.c4 = "PIC_PAGE_BANNER";
                    c2.position = i2;
                    this.f60293i.put(str, c2);
                    int i6 = this.j + 1;
                    this.j = i6;
                    c.g("daily_show_count", i6);
                }
                return c2;
            }
        }
        return null;
    }

    @Override // d.a.j0.s2.j
    public n b(ViewStub viewStub, TbPageContext tbPageContext) {
        return new d.a.j0.s2.e0.d.a.c(viewStub, tbPageContext);
    }

    public final Map<String, String> c(d.a.i0.z0.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("forum_id", cVar.l);
        hashMap.put("forum_name", cVar.m);
        return hashMap;
    }

    public final boolean d(int i2, int i3) {
        if (i2 >= this.f60289e && i2 > i3) {
            return i3 == 0 || i2 - i3 >= this.f60290f;
        }
        return false;
    }

    public final boolean e(int i2, float f2, float f3) {
        int i3;
        if (this.f60286b == 4) {
            return true;
        }
        if (f2 == 0.0f) {
            return false;
        }
        if (!(((float) this.k) / ((float) this.l) > f2)) {
            return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f60286b) == 1 || i3 == 2);
        }
        int i4 = this.f60286b;
        return i4 == 3 || i4 == 1;
    }

    public final void f(int i2, int i3, int i4, d.a.i0.z0.c cVar) {
        if (this.j >= this.f60292h) {
            return;
        }
        this.f60285a.b(this.f60288d);
        if (!this.f60285a.d() && i2 > i3) {
            int i5 = this.f60290f;
            if (i3 + i5 <= i4 && i2 >= (i3 + i5) - this.f60291g) {
                this.f60285a.f(Math.min(this.f60292h - this.j, this.f60287c), c(cVar));
            }
        }
    }

    @Override // d.a.j0.s2.j
    public void onDestroy() {
        this.f60285a.e();
    }
}
