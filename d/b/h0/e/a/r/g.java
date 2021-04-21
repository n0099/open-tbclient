package d.b.h0.e.a.r;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class g implements d.b.h0.a.q.g.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f48440a;

    /* renamed from: b  reason: collision with root package name */
    public String f48441b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f48442c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAdDownloadState f48443d = SwanAdDownloadState.NOT_START;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.e.a.m.e f48444e;

    /* renamed from: f  reason: collision with root package name */
    public b f48445f;

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public long time;

        public b() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                return;
            }
            if (!TextUtils.equals(g.this.f48442c.y(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            g.this.j("3");
        }
    }

    public g(Context context, AdElementInfo adElementInfo, d.b.h0.e.a.m.e eVar) {
        this.f48440a = context;
        this.f48442c = adElementInfo;
        this.f48444e = eVar;
    }

    @Override // d.b.h0.a.q.g.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // d.b.h0.a.q.g.a.a
    public void b() {
        h();
    }

    @Override // d.b.h0.a.q.g.a.a
    public void c(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.f48443d == swanAdDownloadState) {
            return;
        }
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f48443d = swanAdDownloadState;
    }

    @Override // d.b.h0.a.q.g.a.a
    public void d(String str) {
    }

    @Override // d.b.h0.a.q.g.a.a
    public String e() {
        return null;
    }

    @Override // d.b.h0.a.q.g.a.a
    public void f(boolean z) {
    }

    public final void h() {
        if (this.f48445f == null) {
            this.f48445f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f48440a.registerReceiver(this.f48445f, intentFilter);
        }
    }

    public void i() {
        b bVar = this.f48445f;
        if (bVar != null) {
            this.f48440a.unregisterReceiver(bVar);
            this.f48445f = null;
        }
    }

    public final void j(String str) {
        d.b.h0.e.a.p.b bVar = new d.b.h0.e.a.p.b();
        bVar.s = this.f48441b;
        bVar.r = str;
        d.b.h0.e.a.p.d.e(bVar, this.f48442c, this.f48444e);
    }

    public void k(String str) {
        this.f48441b = str;
        j("1");
        Context context = this.f48440a;
        if (context != null) {
            d.b.h0.a.q1.b.f.d.e(context, d.b.h0.e.a.i.gdt_ad_start_download).E();
        }
    }
}
