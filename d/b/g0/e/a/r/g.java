package d.b.g0.e.a.r;

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
public class g implements d.b.g0.a.q.g.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f48111a;

    /* renamed from: b  reason: collision with root package name */
    public String f48112b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f48113c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAdDownloadState f48114d = SwanAdDownloadState.NOT_START;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.e.a.m.e f48115e;

    /* renamed from: f  reason: collision with root package name */
    public b f48116f;

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
            if (!TextUtils.equals(g.this.f48113c.y(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            g.this.j("3");
        }
    }

    public g(Context context, AdElementInfo adElementInfo, d.b.g0.e.a.m.e eVar) {
        this.f48111a = context;
        this.f48113c = adElementInfo;
        this.f48115e = eVar;
    }

    @Override // d.b.g0.a.q.g.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // d.b.g0.a.q.g.a.a
    public void b() {
        h();
    }

    @Override // d.b.g0.a.q.g.a.a
    public void c(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.f48114d == swanAdDownloadState) {
            return;
        }
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f48114d = swanAdDownloadState;
    }

    @Override // d.b.g0.a.q.g.a.a
    public void d(String str) {
    }

    @Override // d.b.g0.a.q.g.a.a
    public String e() {
        return null;
    }

    @Override // d.b.g0.a.q.g.a.a
    public void f(boolean z) {
    }

    public final void h() {
        if (this.f48116f == null) {
            this.f48116f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f48111a.registerReceiver(this.f48116f, intentFilter);
        }
    }

    public void i() {
        b bVar = this.f48116f;
        if (bVar != null) {
            this.f48111a.unregisterReceiver(bVar);
            this.f48116f = null;
        }
    }

    public final void j(String str) {
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.s = this.f48112b;
        bVar.r = str;
        d.b.g0.e.a.p.d.e(bVar, this.f48113c, this.f48115e);
    }

    public void k(String str) {
        this.f48112b = str;
        j("1");
        Context context = this.f48111a;
        if (context != null) {
            d.b.g0.a.q1.b.f.d.e(context, d.b.g0.e.a.i.gdt_ad_start_download).E();
        }
    }
}
