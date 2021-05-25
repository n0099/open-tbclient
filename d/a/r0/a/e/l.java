package d.a.r0.a.e;

import android.text.TextUtils;
import d.a.r0.a.c;
import d.a.r0.a.e.d;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<String, Long> f64435a = new LinkedHashMap<>();

    /* loaded from: classes5.dex */
    public class a extends d.a.r0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.l f64436e;

        public a(l lVar, com.baidu.ubs.analytics.a.l lVar2) {
            this.f64436e = lVar2;
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            new c.j().c(this.f64436e);
        }
    }

    public final void a(String str) {
        d dVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
        synchronized (this.f64435a) {
            Long remove = this.f64435a.remove(str);
            if (remove == null) {
                return;
            }
            try {
                lVar.setStartTime(String.valueOf(remove));
                lVar.t(str);
                lVar.z(String.valueOf(System.currentTimeMillis()));
                dVar = d.a.f64413a;
                lVar.setPath(dVar.b());
                lVar.x(m.d().I());
            } catch (Exception e2) {
                d.a.r0.a.f.i.a(e2.toString());
                d.a.r0.a.f.a.b(e2.toString());
            }
            d.a.r0.a.f.b.c(new a(this, lVar));
        }
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f64435a) {
            this.f64435a.put(str, Long.valueOf(System.currentTimeMillis()));
            String.valueOf(System.currentTimeMillis());
        }
    }
}
