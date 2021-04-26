package d.a.h0.a.e0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.e0.p.j;
import d.a.h0.a.i2.e0;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class k<T extends j> extends d.a.h0.l.h.b<d.a.h0.l.k.g> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f42212f = d.a.h0.a.k.f43101a;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f42213e;

    public k(@NonNull T t) {
        this.f42213e = t;
    }

    @Override // d.a.h0.l.h.b
    public int h() {
        return super.h();
    }

    public String l() {
        return null;
    }

    @Override // d.a.h0.l.h.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            this.f42213e.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.h.c
    /* renamed from: o */
    public String e(d.a.h0.l.k.g gVar) {
        if (TextUtils.isEmpty(gVar.o)) {
            gVar.o = l();
        }
        int i2 = gVar.f47154h;
        if (i2 == 0) {
            return d.a.h0.a.e0.p.r.b.b(gVar.o, String.valueOf(gVar.f47155i));
        }
        if (i2 == 1) {
            return d.a.h0.a.e0.p.r.b.d(gVar.o, String.valueOf(gVar.f47155i));
        }
        return null;
    }

    @CallSuper
    public void p(@NonNull d.a.h0.l.k.g gVar, @Nullable d.a.h0.a.f2.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
    @CallSuper
    /* renamed from: q */
    public void f(d.a.h0.l.k.g gVar, d.a.h0.l.k.a aVar) {
        super.f(gVar, aVar);
        d.a.h0.p.d.x(gVar.f47147a);
        if (f42212f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gVar + ", error=" + aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
    /* renamed from: r */
    public final void i(d.a.h0.l.k.g gVar) {
        super.i(gVar);
        p(gVar, t(gVar));
        if (f42212f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
    /* renamed from: s */
    public void d(d.a.h0.l.k.g gVar) {
        super.d(gVar);
        if (f42212f) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gVar);
        }
    }

    public final d.a.h0.a.f2.a t(d.a.h0.l.k.g gVar) {
        if (!e0.a(new File(gVar.f47147a), gVar.m)) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(12L);
            aVar.b(2300L);
            aVar.c("分包签名校验失败");
            return aVar;
        } else if (d.a.h0.a.e0.p.r.b.g(gVar)) {
            return null;
        } else {
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(12L);
            aVar2.b(2320L);
            aVar2.c("分包解压失败");
            return aVar2;
        }
    }
}
