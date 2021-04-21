package d.b.j0.s2.e0;

import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.b.c.e.p.l;
import d.b.j0.s2.c;
import d.b.j0.s2.j;
import d.b.j0.s2.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.j0.o.b.a f62086a;
    public final int k;
    public final int l;
    public final int m;

    /* renamed from: b  reason: collision with root package name */
    public final int f62087b = d.b.j0.a.e().j();

    /* renamed from: c  reason: collision with root package name */
    public final int f62088c = d.b.j0.a.e().m();

    /* renamed from: d  reason: collision with root package name */
    public final int f62089d = d.b.j0.a.e().g();

    /* renamed from: e  reason: collision with root package name */
    public final int f62090e = d.b.j0.a.e().h() - 1;

    /* renamed from: f  reason: collision with root package name */
    public final int f62091f = d.b.j0.a.e().i();

    /* renamed from: g  reason: collision with root package name */
    public final int f62092g = d.b.j0.a.e().l();

    /* renamed from: h  reason: collision with root package name */
    public final int f62093h = d.b.j0.a.e().k();
    public int j = c.a("daily_show_count");
    public final Map<String, AdvertAppInfo> i = new HashMap();

    public a() {
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        this.f62086a = new d.b.j0.o.b.a(PlaceId.PIC_PAGE_BANNER, "PB_BANNER", d.b.j0.a.e().n());
    }

    @Override // d.b.j0.s2.j
    public n a(ViewStub viewStub, TbPageContext tbPageContext) {
        return new d.b.j0.s2.c0.d.a.c(viewStub, tbPageContext);
    }

    @Override // d.b.j0.s2.j
    public AdvertAppInfo b(d.b.i0.z0.c cVar) {
        if (!cVar.j && !cVar.k) {
            int i = cVar.f52413c;
            String str = cVar.f52417g;
            int i2 = cVar.f52414d;
            int i3 = cVar.i;
            float f2 = cVar.f52416f;
            int i4 = cVar.f52418h;
            f(i, i2, i3, cVar);
            if (this.i.containsKey(str)) {
                return this.i.get(str);
            }
            if (d(i, i2) && e(i4, f2, cVar.f52415e)) {
                AdvertAppInfo c2 = this.f62086a.c();
                if (c2 != null) {
                    c2.c4 = "PIC_PAGE_BANNER";
                    c2.position = i;
                    this.i.put(str, c2);
                    int i5 = this.j + 1;
                    this.j = i5;
                    c.g("daily_show_count", i5);
                }
                return c2;
            }
        }
        return null;
    }

    public final Map<String, String> c(d.b.i0.z0.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("forum_id", cVar.l);
        hashMap.put("forum_name", cVar.m);
        return hashMap;
    }

    public final boolean d(int i, int i2) {
        if (i >= this.f62090e && i > i2) {
            return i2 == 0 || i - i2 >= this.f62091f;
        }
        return false;
    }

    public final boolean e(int i, float f2, float f3) {
        int i2;
        if (this.f62087b == 4) {
            return true;
        }
        if (f2 == 0.0f) {
            return false;
        }
        if (!(((float) this.k) / ((float) this.l) > f2)) {
            return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i))) > this.m && ((i2 = this.f62087b) == 1 || i2 == 2);
        }
        int i3 = this.f62087b;
        return i3 == 3 || i3 == 1;
    }

    public final void f(int i, int i2, int i3, d.b.i0.z0.c cVar) {
        if (this.j >= this.f62093h) {
            return;
        }
        this.f62086a.b(this.f62089d);
        if (!this.f62086a.d() && i > i2) {
            int i4 = this.f62091f;
            if (i2 + i4 <= i3 && i >= (i2 + i4) - this.f62092g) {
                this.f62086a.f(Math.min(this.f62093h - this.j, this.f62088c), c(cVar));
            }
        }
    }

    @Override // d.b.j0.s2.j
    public void onDestroy() {
        this.f62086a.e();
    }
}
