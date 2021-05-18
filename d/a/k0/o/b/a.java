package d.a.k0.o.b;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.k0.o.b.b;
import d.a.k0.s2.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.InterfaceC1443b {

    /* renamed from: f  reason: collision with root package name */
    public static long f57753f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f57754a;

    /* renamed from: b  reason: collision with root package name */
    public String f57755b;

    /* renamed from: c  reason: collision with root package name */
    public int f57756c;

    /* renamed from: d  reason: collision with root package name */
    public c f57757d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f57758e;

    public a(PlaceId placeId, String str, int i2) {
        this.f57754a = placeId;
        this.f57755b = str;
        this.f57756c = i2;
        this.f57758e = new b(this, this.f57754a);
    }

    @Override // d.a.k0.o.b.b.InterfaceC1443b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.a.k0.j1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f57757d.a(this.f57754a, list);
    }

    public void b(int i2) {
        if (d.e(System.currentTimeMillis(), this.f57757d.e(this.f57754a), i2)) {
            List<AdvertAppInfo> b2 = this.f57757d.b(this.f57754a);
            if (d.a.k0.j1.o.k.a.e(b2)) {
                return;
            }
            for (AdvertAppInfo advertAppInfo : b2) {
                d.a.k0.s2.i0.d.g(advertAppInfo, 0, 44);
            }
        }
    }

    @Nullable
    public AdvertAppInfo c() {
        return this.f57757d.c(this.f57754a);
    }

    public boolean d() {
        return this.f57757d.f(this.f57754a);
    }

    public void e() {
        this.f57758e.b();
    }

    public void f(int i2, Map<String, String> map) {
        if (System.currentTimeMillis() - f57753f < this.f57756c * d.f60926c) {
            return;
        }
        this.f57758e.c(map, i2);
        f57753f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.P3 = this.f57755b;
            int G4 = next.G4();
            if (G4 != 0) {
                d.a.k0.s2.i0.d.g(next, 0, G4);
                it.remove();
            }
            if (d.a.k0.s2.a.l(next)) {
                it.remove();
            }
        }
    }
}
