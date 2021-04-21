package d.b.j0.o.b;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.b.j0.o.b.b;
import d.b.j0.s2.f0.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.InterfaceC1432b {

    /* renamed from: f  reason: collision with root package name */
    public static long f59024f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f59025a;

    /* renamed from: b  reason: collision with root package name */
    public String f59026b;

    /* renamed from: c  reason: collision with root package name */
    public int f59027c;

    /* renamed from: d  reason: collision with root package name */
    public c f59028d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f59029e;

    public a(PlaceId placeId, String str, int i) {
        this.f59025a = placeId;
        this.f59026b = str;
        this.f59027c = i;
        this.f59029e = new b(this, this.f59025a);
    }

    @Override // d.b.j0.o.b.b.InterfaceC1432b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.b.j0.j1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f59028d.a(this.f59025a, list);
    }

    public void b(int i) {
        if (d.b.j0.s2.c.e(System.currentTimeMillis(), this.f59028d.e(this.f59025a), i)) {
            List<AdvertAppInfo> b2 = this.f59028d.b(this.f59025a);
            if (d.b.j0.j1.o.k.a.e(b2)) {
                return;
            }
            for (AdvertAppInfo advertAppInfo : b2) {
                d.g(advertAppInfo, 0, 44);
            }
        }
    }

    @Nullable
    public AdvertAppInfo c() {
        return this.f59028d.c(this.f59025a);
    }

    public boolean d() {
        return this.f59028d.f(this.f59025a);
    }

    public void e() {
        this.f59029e.b();
    }

    public void f(int i, Map<String, String> map) {
        if (System.currentTimeMillis() - f59024f < this.f59027c * d.b.j0.s2.c.f62013c) {
            return;
        }
        this.f59029e.c(map, i);
        f59024f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.c4 = this.f59026b;
            int E4 = next.E4();
            if (E4 != 0) {
                d.g(next, 0, E4);
                it.remove();
            }
            if (d.b.j0.s2.a.l(next)) {
                it.remove();
            }
        }
    }
}
