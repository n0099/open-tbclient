package d.a.j0.o.b;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.j0.o.b.b;
import d.a.j0.s2.h0.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.InterfaceC1371b {

    /* renamed from: f  reason: collision with root package name */
    public static long f57046f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f57047a;

    /* renamed from: b  reason: collision with root package name */
    public String f57048b;

    /* renamed from: c  reason: collision with root package name */
    public int f57049c;

    /* renamed from: d  reason: collision with root package name */
    public c f57050d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f57051e;

    public a(PlaceId placeId, String str, int i2) {
        this.f57047a = placeId;
        this.f57048b = str;
        this.f57049c = i2;
        this.f57051e = new b(this, this.f57047a);
    }

    @Override // d.a.j0.o.b.b.InterfaceC1371b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.a.j0.j1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f57050d.a(this.f57047a, list);
    }

    public void b(int i2) {
        if (d.a.j0.s2.c.e(System.currentTimeMillis(), this.f57050d.e(this.f57047a), i2)) {
            List<AdvertAppInfo> b2 = this.f57050d.b(this.f57047a);
            if (d.a.j0.j1.o.k.a.e(b2)) {
                return;
            }
            for (AdvertAppInfo advertAppInfo : b2) {
                d.g(advertAppInfo, 0, 44);
            }
        }
    }

    @Nullable
    public AdvertAppInfo c() {
        return this.f57050d.c(this.f57047a);
    }

    public boolean d() {
        return this.f57050d.f(this.f57047a);
    }

    public void e() {
        this.f57051e.b();
    }

    public void f(int i2, Map<String, String> map) {
        if (System.currentTimeMillis() - f57046f < this.f57049c * d.a.j0.s2.c.f60197c) {
            return;
        }
        this.f57051e.c(map, i2);
        f57046f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.c4 = this.f57048b;
            int E4 = next.E4();
            if (E4 != 0) {
                d.g(next, 0, E4);
                it.remove();
            }
            if (d.a.j0.s2.a.l(next)) {
                it.remove();
            }
        }
    }
}
