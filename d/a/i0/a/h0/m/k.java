package d.a.i0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.h0.m.j;
import d.a.i0.a.v2.j0;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class k<T extends j> extends d.a.i0.n.f.b<d.a.i0.n.h.g> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f42195f = d.a.i0.a.k.f43025a;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f42196e;

    public k(@NonNull T t) {
        this.f42196e = t;
    }

    @Override // d.a.i0.n.f.b
    public int g() {
        return super.g();
    }

    public String l() {
        return null;
    }

    @Override // d.a.i0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            this.f42196e.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.f.c
    /* renamed from: o */
    public String d(d.a.i0.n.h.g gVar) {
        if (TextUtils.isEmpty(gVar.o)) {
            gVar.o = l();
        }
        int i2 = gVar.f47837h;
        if (i2 == 0) {
            return d.a.i0.a.h0.m.r.b.b(gVar.o, String.valueOf(gVar.f47838i));
        }
        if (i2 == 1) {
            return d.a.i0.a.h0.m.r.b.d(gVar.o, String.valueOf(gVar.f47838i));
        }
        return null;
    }

    @CallSuper
    public void p(@NonNull d.a.i0.n.h.g gVar, @Nullable d.a.i0.a.q2.a aVar) {
    }

    @CallSuper
    public void q(d.a.i0.n.h.g gVar, d.a.i0.n.h.a aVar) {
        super.e(gVar, aVar);
        d.a.i0.a.e0.d.h("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + gVar.f47830a);
        d.a.i0.t.d.L(gVar.f47830a);
        if (f42195f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gVar + ", error=" + aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
    /* renamed from: r */
    public final void i(d.a.i0.n.h.g gVar) {
        super.i(gVar);
        p(gVar, t(gVar));
        if (f42195f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
    /* renamed from: s */
    public void c(d.a.i0.n.h.g gVar) {
        super.c(gVar);
        if (f42195f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gVar);
        }
    }

    public final d.a.i0.a.q2.a t(d.a.i0.n.h.g gVar) {
        if (!j0.a(new File(gVar.f47830a), gVar.m)) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(12L);
            aVar.b(2300L);
            aVar.c("分包签名校验失败");
            return aVar;
        } else if (d.a.i0.a.h0.m.r.b.g(gVar)) {
            return null;
        } else {
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(12L);
            aVar2.b(2320L);
            aVar2.c("分包解压失败");
            return aVar2;
        }
    }
}
