package d.a.m0.f.i.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import d.a.m0.f.i.l.g;
import d.a.m0.f.i.q.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b implements d.a.m0.f.i.k.f.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f50490a;

    /* renamed from: b  reason: collision with root package name */
    public String f50491b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f50492c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadState f50493d = DownloadState.NOT_START;

    /* renamed from: e  reason: collision with root package name */
    public g f50494e;

    /* renamed from: f  reason: collision with root package name */
    public C1037b f50495f;

    /* renamed from: d.a.m0.f.i.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1037b extends BroadcastReceiver {
        public long time;

        public C1037b() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                return;
            }
            if (!TextUtils.equals(b.this.f50492c.y(), intent.getData().getSchemeSpecificPart()) || System.currentTimeMillis() - this.time < TimeUnit.SECONDS.toMillis(10L)) {
                return;
            }
            this.time = System.currentTimeMillis();
            b.this.j("3");
        }
    }

    public b(Context context, AdElementInfo adElementInfo, g gVar) {
        this.f50490a = context;
        this.f50492c = adElementInfo;
        this.f50494e = gVar;
    }

    @Override // d.a.m0.f.i.k.f.a
    public void a(int i2) {
    }

    @Override // d.a.m0.f.i.k.f.a
    public void b() {
        h();
    }

    @Override // d.a.m0.f.i.k.f.a
    public void c(DownloadState downloadState, int i2) {
        if (this.f50493d == downloadState) {
            return;
        }
        if (downloadState == DownloadState.DOWNLOADED) {
            j("2");
            h();
        }
        this.f50493d = downloadState;
    }

    @Override // d.a.m0.f.i.k.f.a
    public void d(String str) {
    }

    @Override // d.a.m0.f.i.k.f.a
    public String e() {
        return null;
    }

    @Override // d.a.m0.f.i.k.f.a
    public void f(boolean z) {
    }

    public final void h() {
        if (this.f50495f == null) {
            this.f50495f = new C1037b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
            this.f50490a.registerReceiver(this.f50495f, intentFilter);
        }
    }

    public void i() {
        C1037b c1037b = this.f50495f;
        if (c1037b != null) {
            this.f50490a.unregisterReceiver(c1037b);
            this.f50495f = null;
        }
    }

    public final void j(String str) {
        d.a.m0.f.i.q.a aVar = new d.a.m0.f.i.q.a();
        aVar.s = this.f50491b;
        aVar.r = str;
        d.e(aVar, this.f50492c, this.f50494e);
    }

    public void k(String str) {
        this.f50491b = str;
        j("1");
    }
}
