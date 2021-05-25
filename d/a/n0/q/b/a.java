package d.a.n0.q.b;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.n0.q.b.b;
import d.a.n0.t2.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.InterfaceC1472b {

    /* renamed from: f  reason: collision with root package name */
    public static long f58170f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f58171a;

    /* renamed from: b  reason: collision with root package name */
    public String f58172b;

    /* renamed from: c  reason: collision with root package name */
    public int f58173c;

    /* renamed from: d  reason: collision with root package name */
    public c f58174d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f58175e;

    public a(PlaceId placeId, String str, int i2) {
        this.f58171a = placeId;
        this.f58172b = str;
        this.f58173c = i2;
        this.f58175e = new b(this, this.f58171a);
    }

    @Override // d.a.n0.q.b.b.InterfaceC1472b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.a.n0.k1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f58174d.a(this.f58171a, list);
    }

    public void b(int i2) {
        if (d.e(System.currentTimeMillis(), this.f58174d.e(this.f58171a), i2)) {
            List<AdvertAppInfo> b2 = this.f58174d.b(this.f58171a);
            if (d.a.n0.k1.o.k.a.e(b2)) {
                return;
            }
            for (AdvertAppInfo advertAppInfo : b2) {
                d.a.n0.t2.i0.d.g(advertAppInfo, 0, 44);
            }
        }
    }

    @Nullable
    public AdvertAppInfo c() {
        return this.f58174d.c(this.f58171a);
    }

    public boolean d() {
        return this.f58174d.f(this.f58171a);
    }

    public void e() {
        this.f58175e.b();
    }

    public void f(int i2, Map<String, String> map) {
        if (System.currentTimeMillis() - f58170f < this.f58173c * d.f61028c) {
            return;
        }
        this.f58175e.c(map, i2);
        f58170f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.Q3 = this.f58172b;
            int H4 = next.H4();
            if (H4 != 0) {
                d.a.n0.t2.i0.d.g(next, 0, H4);
                it.remove();
            }
            if (d.a.n0.t2.a.l(next)) {
                it.remove();
            }
        }
    }
}
