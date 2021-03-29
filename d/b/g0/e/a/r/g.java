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
    public Context f47719a;

    /* renamed from: b  reason: collision with root package name */
    public String f47720b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f47721c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAdDownloadState f47722d = SwanAdDownloadState.NOT_START;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.e.a.m.e f47723e;

    /* renamed from: f  reason: collision with root package name */
    public b f47724f;

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
            if (!TextUtils.equals(g.this.f47721c.y(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            g.this.j("3");
        }
    }

    public g(Context context, AdElementInfo adElementInfo, d.b.g0.e.a.m.e eVar) {
        this.f47719a = context;
        this.f47721c = adElementInfo;
        this.f47723e = eVar;
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
        if (this.f47722d == swanAdDownloadState) {
            return;
        }
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f47722d = swanAdDownloadState;
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
        if (this.f47724f == null) {
            this.f47724f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f47719a.registerReceiver(this.f47724f, intentFilter);
        }
    }

    public void i() {
        b bVar = this.f47724f;
        if (bVar != null) {
            this.f47719a.unregisterReceiver(bVar);
            this.f47724f = null;
        }
    }

    public final void j(String str) {
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.s = this.f47720b;
        bVar.r = str;
        d.b.g0.e.a.p.d.e(bVar, this.f47721c, this.f47723e);
    }

    public void k(String str) {
        this.f47720b = str;
        j("1");
        Context context = this.f47719a;
        if (context != null) {
            d.b.g0.a.q1.b.f.d.e(context, d.b.g0.e.a.i.gdt_ad_start_download).E();
        }
    }
}
