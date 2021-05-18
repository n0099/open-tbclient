package d.a.i0.h.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.i0.a.j2.k;
import d.a.i0.a.j2.p.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.f.i.k.f.a f47218e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.y.b.a f47219f;

    /* renamed from: g  reason: collision with root package name */
    public String f47220g;

    /* renamed from: d.a.i0.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1015a implements d.a.i0.f.i.k.f.a {
        public C1015a() {
        }

        @Override // d.a.i0.f.i.k.f.a
        public void a(int i2) {
            b bVar = new b();
            bVar.progress = i2;
            JSEvent jSEvent = new JSEvent("ProgressChange");
            jSEvent.data = bVar;
            a.this.dispatchEvent(jSEvent);
        }

        @Override // d.a.i0.f.i.k.f.a
        public void b() {
        }

        @Override // d.a.i0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            d dVar = new d();
            dVar.state = downloadState.value();
            JSEvent jSEvent = new JSEvent("StateChange");
            jSEvent.data = dVar;
            a.this.dispatchEvent(jSEvent);
        }

        @Override // d.a.i0.f.i.k.f.a
        public void d(String str) {
        }

        @Override // d.a.i0.f.i.k.f.a
        public String e() {
            return a.this.f47220g;
        }

        @Override // d.a.i0.f.i.k.f.a
        public void f(boolean z) {
        }
    }

    public a(JSRuntime jSRuntime, d.a.i0.a.y.b.a aVar) {
        super(jSRuntime);
        this.f47219f = aVar;
        if (A()) {
            this.f47218e = new C1015a();
            d.a.i0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.f47218e);
        }
    }

    public final boolean A() {
        this.f47220g = d.a.i0.h.t.a.f().getPackageName();
        if (!d.a.i0.h.t.a.f().b()) {
            d.a.i0.h.d.c.b bVar = new d.a.i0.h.d.c.b();
            bVar.errMsg = "download url is empty";
            d.a.i0.h.m0.c.a(this.f47219f, false, bVar);
            B("reallyDownloadNull", this.f47220g);
            return false;
        } else if (C(AppRuntime.getAppContext(), this.f47220g)) {
            d.a.i0.h.d.c.b bVar2 = new d.a.i0.h.d.c.b();
            bVar2.errMsg = "apk has installed";
            d.a.i0.h.m0.c.a(this.f47219f, false, bVar2);
            B("reallyHasInstalled", this.f47220g);
            return false;
        } else {
            c cVar = new c();
            cVar.statusCode = 0;
            cVar.packageName = this.f47220g;
            d.a.i0.h.m0.c.a(this.f47219f, true, cVar);
            return true;
        }
    }

    public void B(String str, String str2) {
        e eVar = new e();
        eVar.f43012b = str;
        eVar.f43011a = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
        eVar.a("targetPackageName", str2);
        k.g(eVar);
    }

    public final boolean C(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    return context.getPackageManager().getPackageInfo(str, 0) != null;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public final void D(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.iterator().next() == null) {
            return;
        }
        String str2 = queryIntentActivities.iterator().next().activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(new ComponentName(str, str2));
        intent2.setFlags(270532608);
        try {
            context.startActivity(intent2);
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void deleteDownload() {
        d.a.i0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD, this.f47218e);
    }

    @JavascriptInterface
    public void installApp() {
        d.a.i0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.f47218e);
    }

    @JavascriptInterface
    public void openApp() {
        D(AppRuntime.getAppContext(), this.f47220g);
    }

    @JavascriptInterface
    public void pauseDownload() {
        d.a.i0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f47218e);
    }

    @JavascriptInterface
    public void resumeDownload() {
        d.a.i0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD, this.f47218e);
    }

    @JavascriptInterface
    public void startDownload() {
        d.a.i0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f47218e);
    }
}
