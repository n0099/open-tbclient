package d.b.i0.o.b;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.b.i0.o.b.b;
import d.b.i0.s2.f0.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.InterfaceC1409b {

    /* renamed from: f  reason: collision with root package name */
    public static long f58603f;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f58604a;

    /* renamed from: b  reason: collision with root package name */
    public String f58605b;

    /* renamed from: c  reason: collision with root package name */
    public int f58606c;

    /* renamed from: d  reason: collision with root package name */
    public c f58607d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public b f58608e;

    public a(PlaceId placeId, String str, int i) {
        this.f58604a = placeId;
        this.f58605b = str;
        this.f58606c = i;
        this.f58608e = new b(this, this.f58604a);
    }

    @Override // d.b.i0.o.b.b.InterfaceC1409b
    public void a(boolean z, List<AdvertAppInfo> list) {
        if (!z || d.b.i0.j1.o.k.a.e(list)) {
            return;
        }
        g(list);
        this.f58607d.a(this.f58604a, list);
    }

    public void b(int i) {
        if (d.b.i0.s2.c.e(System.currentTimeMillis(), this.f58607d.e(this.f58604a), i)) {
            List<AdvertAppInfo> b2 = this.f58607d.b(this.f58604a);
            if (d.b.i0.j1.o.k.a.e(b2)) {
                return;
            }
            for (AdvertAppInfo advertAppInfo : b2) {
                d.g(advertAppInfo, 0, 44);
            }
        }
    }

    @Nullable
    public AdvertAppInfo c() {
        return this.f58607d.c(this.f58604a);
    }

    public boolean d() {
        return this.f58607d.f(this.f58604a);
    }

    public void e() {
        this.f58608e.b();
    }

    public void f(int i, Map<String, String> map) {
        if (System.currentTimeMillis() - f58603f < this.f58606c * d.b.i0.s2.c.f61592c) {
            return;
        }
        this.f58608e.c(map, i);
        f58603f = System.currentTimeMillis();
    }

    public final void g(List<AdvertAppInfo> list) {
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.c4 = this.f58605b;
            int E4 = next.E4();
            if (E4 != 0) {
                d.g(next, 0, E4);
                it.remove();
            }
            if (d.b.i0.s2.a.l(next)) {
                it.remove();
            }
        }
    }
}
