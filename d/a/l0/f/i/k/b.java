package d.a.l0.f.i.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import d.a.l0.f.i.l.g;
import d.a.l0.f.i.q.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b implements d.a.l0.f.i.k.f.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f46708a;

    /* renamed from: b  reason: collision with root package name */
    public String f46709b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f46710c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadState f46711d = DownloadState.NOT_START;

    /* renamed from: e  reason: collision with root package name */
    public g f46712e;

    /* renamed from: f  reason: collision with root package name */
    public C0978b f46713f;

    /* renamed from: d.a.l0.f.i.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0978b extends BroadcastReceiver {
        public long time;

        public C0978b() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                return;
            }
            if (!TextUtils.equals(b.this.f46710c.y(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            b.this.j("3");
        }
    }

    public b(Context context, AdElementInfo adElementInfo, g gVar) {
        this.f46708a = context;
        this.f46710c = adElementInfo;
        this.f46712e = gVar;
    }

    @Override // d.a.l0.f.i.k.f.a
    public void a(int i2) {
    }

    @Override // d.a.l0.f.i.k.f.a
    public void b() {
        h();
    }

    @Override // d.a.l0.f.i.k.f.a
    public void c(DownloadState downloadState, int i2) {
        if (this.f46711d == downloadState) {
            return;
        }
        if (downloadState == DownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f46711d = downloadState;
    }

    @Override // d.a.l0.f.i.k.f.a
    public void d(String str) {
    }

    @Override // d.a.l0.f.i.k.f.a
    public String e() {
        return null;
    }

    @Override // d.a.l0.f.i.k.f.a
    public void f(boolean z) {
    }

    public final void h() {
        if (this.f46713f == null) {
            this.f46713f = new C0978b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
            this.f46708a.registerReceiver(this.f46713f, intentFilter);
        }
    }

    public void i() {
        C0978b c0978b = this.f46713f;
        if (c0978b != null) {
            this.f46708a.unregisterReceiver(c0978b);
            this.f46713f = null;
        }
    }

    public final void j(String str) {
        d.a.l0.f.i.q.a aVar = new d.a.l0.f.i.q.a();
        aVar.s = this.f46709b;
        aVar.r = str;
        d.e(aVar, this.f46710c, this.f46712e);
    }

    public void k(String str) {
        this.f46709b = str;
        j("1");
    }
}
