package d.a.h0.e.a.r;

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
public class g implements d.a.h0.a.q.g.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f45899a;

    /* renamed from: b  reason: collision with root package name */
    public String f45900b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f45901c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAdDownloadState f45902d = SwanAdDownloadState.NOT_START;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.e.a.m.e f45903e;

    /* renamed from: f  reason: collision with root package name */
    public b f45904f;

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
            if (!TextUtils.equals(g.this.f45901c.y(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            g.this.j("3");
        }
    }

    public g(Context context, AdElementInfo adElementInfo, d.a.h0.e.a.m.e eVar) {
        this.f45899a = context;
        this.f45901c = adElementInfo;
        this.f45903e = eVar;
    }

    @Override // d.a.h0.a.q.g.a.a
    public void a() {
        h();
    }

    @Override // d.a.h0.a.q.g.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i2) {
    }

    @Override // d.a.h0.a.q.g.a.a
    public void c(SwanAdDownloadState swanAdDownloadState, int i2) {
        if (this.f45902d == swanAdDownloadState) {
            return;
        }
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f45902d = swanAdDownloadState;
    }

    @Override // d.a.h0.a.q.g.a.a
    public void d(String str) {
    }

    @Override // d.a.h0.a.q.g.a.a
    public String e() {
        return null;
    }

    @Override // d.a.h0.a.q.g.a.a
    public void f(boolean z) {
    }

    public final void h() {
        if (this.f45904f == null) {
            this.f45904f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f45899a.registerReceiver(this.f45904f, intentFilter);
        }
    }

    public void i() {
        b bVar = this.f45904f;
        if (bVar != null) {
            this.f45899a.unregisterReceiver(bVar);
            this.f45904f = null;
        }
    }

    public final void j(String str) {
        d.a.h0.e.a.p.b bVar = new d.a.h0.e.a.p.b();
        bVar.s = this.f45900b;
        bVar.r = str;
        d.a.h0.e.a.p.d.e(bVar, this.f45901c, this.f45903e);
    }

    public void k(String str) {
        this.f45900b = str;
        j("1");
        Context context = this.f45899a;
        if (context != null) {
            d.a.h0.a.q1.b.f.d.e(context, d.a.h0.e.a.i.gdt_ad_start_download).E();
        }
    }
}
