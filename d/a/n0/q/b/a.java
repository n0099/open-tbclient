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
public class a implements b.InterfaceC1528b {

    /* renamed from: f  reason: collision with root package name */
    public static long f61861f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f61862a;

    /* renamed from: b  reason: collision with root package name */
    public String f61863b;

    /* renamed from: c  reason: collision with root package name */
    public int f61864c;

    /* renamed from: d  reason: collision with root package name */
    public c f61865d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f61866e;

    public a(PlaceId placeId, String str, int i2) {
        this.f61862a = placeId;
        this.f61863b = str;
        this.f61864c = i2;
        this.f61866e = new b(this, this.f61862a);
    }

    @Override // d.a.n0.q.b.b.InterfaceC1528b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.a.n0.k1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f61865d.a(this.f61862a, list);
    }

    public void b(int i2) {
        if (d.e(System.currentTimeMillis(), this.f61865d.e(this.f61862a), i2)) {
            List<AdvertAppInfo> b2 = this.f61865d.b(this.f61862a);
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
        return this.f61865d.c(this.f61862a);
    }

    public boolean d() {
        return this.f61865d.f(this.f61862a);
    }

    public void e() {
        this.f61866e.b();
    }

    public void f(int i2, Map<String, String> map) {
        if (System.currentTimeMillis() - f61861f < this.f61864c * d.f64720c) {
            return;
        }
        this.f61866e.c(map, i2);
        f61861f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.T3 = this.f61863b;
            int I4 = next.I4();
            if (I4 != 0) {
                d.a.n0.t2.i0.d.g(next, 0, I4);
                it.remove();
            }
            if (d.a.n0.t2.a.l(next)) {
                it.remove();
            }
        }
    }
}
