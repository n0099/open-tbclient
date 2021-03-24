package d.b.g0.a.e0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.e0.p.j;
import d.b.g0.a.i2.e0;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class k<T extends j> extends d.b.g0.l.h.b<d.b.g0.l.k.g> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44187f = d.b.g0.a.k.f45050a;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f44188e;

    public k(@NonNull T t) {
        this.f44188e = t;
    }

    @Override // d.b.g0.l.h.b
    public int e() {
        return super.e();
    }

    @Override // d.b.g0.l.h.e
    @NonNull
    public Bundle g(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            this.f44188e.k(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public String m() {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.h.c
    /* renamed from: n */
    public String j(d.b.g0.l.k.g gVar) {
        if (TextUtils.isEmpty(gVar.o)) {
            gVar.o = m();
        }
        int i = gVar.f48923h;
        if (i == 0) {
            return d.b.g0.a.e0.p.r.b.b(gVar.o, String.valueOf(gVar.i));
        }
        if (i == 1) {
            return d.b.g0.a.e0.p.r.b.d(gVar.o, String.valueOf(gVar.i));
        }
        return null;
    }

    @CallSuper
    public void p(@NonNull d.b.g0.l.k.g gVar, @Nullable d.b.g0.a.f2.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
    @CallSuper
    /* renamed from: q */
    public void l(d.b.g0.l.k.g gVar, d.b.g0.l.k.a aVar) {
        super.l(gVar, aVar);
        d.b.g0.p.d.x(gVar.f48916a);
        if (f44187f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gVar + ", error=" + aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
    /* renamed from: r */
    public final void b(d.b.g0.l.k.g gVar) {
        super.b(gVar);
        p(gVar, t(gVar));
        if (f44187f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
    /* renamed from: s */
    public void i(d.b.g0.l.k.g gVar) {
        super.i(gVar);
        if (f44187f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gVar);
        }
    }

    public final d.b.g0.a.f2.a t(d.b.g0.l.k.g gVar) {
        if (!e0.a(new File(gVar.f48916a), gVar.m)) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(12L);
            aVar.b(2300L);
            aVar.c("分包签名校验失败");
            return aVar;
        } else if (d.b.g0.a.e0.p.r.b.g(gVar)) {
            return null;
        } else {
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(12L);
            aVar2.b(2320L);
            aVar2.c("分包解压失败");
            return aVar2;
        }
    }
}
