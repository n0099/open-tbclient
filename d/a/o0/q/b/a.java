package d.a.o0.q.b;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.o0.q.b.b;
import d.a.o0.t2.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.InterfaceC1532b {

    /* renamed from: f  reason: collision with root package name */
    public static long f61986f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f61987a;

    /* renamed from: b  reason: collision with root package name */
    public String f61988b;

    /* renamed from: c  reason: collision with root package name */
    public int f61989c;

    /* renamed from: d  reason: collision with root package name */
    public c f61990d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f61991e;

    public a(PlaceId placeId, String str, int i2) {
        this.f61987a = placeId;
        this.f61988b = str;
        this.f61989c = i2;
        this.f61991e = new b(this, this.f61987a);
    }

    @Override // d.a.o0.q.b.b.InterfaceC1532b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.a.o0.k1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f61990d.a(this.f61987a, list);
    }

    public void b(int i2) {
        if (d.e(System.currentTimeMillis(), this.f61990d.e(this.f61987a), i2)) {
            List<AdvertAppInfo> b2 = this.f61990d.b(this.f61987a);
            if (d.a.o0.k1.o.k.a.e(b2)) {
                return;
            }
            for (AdvertAppInfo advertAppInfo : b2) {
                d.a.o0.t2.i0.d.g(advertAppInfo, 0, 44);
            }
        }
    }

    @Nullable
    public AdvertAppInfo c() {
        return this.f61990d.c(this.f61987a);
    }

    public boolean d() {
        return this.f61990d.f(this.f61987a);
    }

    public void e() {
        this.f61991e.b();
    }

    public void f(int i2, Map<String, String> map) {
        if (System.currentTimeMillis() - f61986f < this.f61989c * d.f64845c) {
            return;
        }
        this.f61991e.c(map, i2);
        f61986f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.T3 = this.f61988b;
            int I4 = next.I4();
            if (I4 != 0) {
                d.a.o0.t2.i0.d.g(next, 0, I4);
                it.remove();
            }
            if (d.a.o0.t2.a.l(next)) {
                it.remove();
            }
        }
    }
}
