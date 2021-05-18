package d.a.i0.a.p.d;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.service.AsInstallService;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface o {

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43804a;

        static {
            int[] iArr = new int[DownloadParams.SwanAppDownloadType.values().length];
            f43804a = iArr;
            try {
                iArr[DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43804a[DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43804a[DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43804a[DownloadParams.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43804a[DownloadParams.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43804a[DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements o {
        public static final boolean j = d.a.i0.a.k.f43025a;

        /* renamed from: a  reason: collision with root package name */
        public String f43805a;

        /* renamed from: b  reason: collision with root package name */
        public c f43806b;

        /* renamed from: c  reason: collision with root package name */
        public String f43807c;

        /* renamed from: d  reason: collision with root package name */
        public String f43808d;

        /* renamed from: e  reason: collision with root package name */
        public String f43809e;

        /* renamed from: f  reason: collision with root package name */
        public String f43810f;

        /* renamed from: g  reason: collision with root package name */
        public String f43811g;

        /* renamed from: h  reason: collision with root package name */
        public Context f43812h;

        /* renamed from: i  reason: collision with root package name */
        public CallbackHandler f43813i;

        /* loaded from: classes2.dex */
        public class a implements d.a.i0.f.i.k.f.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadParams.SwanAppDownloadType f43814a;

            public a(DownloadParams.SwanAppDownloadType swanAppDownloadType) {
                this.f43814a = swanAppDownloadType;
            }

            @Override // d.a.i0.f.i.k.f.a
            public void a(int i2) {
                if (b.j) {
                    Log.d("SwanAdDownloadImpl", "onProgressChange:" + i2);
                }
            }

            @Override // d.a.i0.f.i.k.f.a
            public void b() {
                if (b.j) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // d.a.i0.f.i.k.f.a
            public void c(DownloadState downloadState, int i2) {
                if (b.j) {
                    Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i2);
                }
                switch (a.f43804a[this.f43814a.ordinal()]) {
                    case 1:
                        b.this.u(downloadState, String.valueOf(i2));
                        return;
                    case 2:
                        b.this.w(downloadState, String.valueOf(i2));
                        return;
                    case 3:
                        b.this.t(String.valueOf(i2));
                        return;
                    case 4:
                        b.this.r();
                        return;
                    case 5:
                        b.this.v(downloadState, String.valueOf(i2));
                        return;
                    case 6:
                        b.this.s();
                        return;
                    default:
                        return;
                }
            }

            @Override // d.a.i0.f.i.k.f.a
            public void d(String str) {
                if (b.j) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // d.a.i0.f.i.k.f.a
            public String e() {
                if (b.j) {
                    Log.d("SwanAdDownloadImpl", "onAppOpen:");
                    return null;
                }
                return null;
            }

            @Override // d.a.i0.f.i.k.f.a
            public void f(boolean z) {
                if (b.j) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }
        }

        /* renamed from: d.a.i0.a.p.d.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0778b implements d.a.i0.a.s1.f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43816a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43817b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43818c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43819d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f43820e;

            public C0778b(b bVar, String str, String str2, String str3, boolean z, Context context) {
                this.f43816a = str;
                this.f43817b = str2;
                this.f43818c = str3;
                this.f43819d = z;
                this.f43820e = context;
            }

            @Override // d.a.i0.a.s1.f
            public void a(String str) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f43816a));
                String str2 = this.f43816a;
                request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
                if (!TextUtils.isEmpty(this.f43817b) && !TextUtils.isEmpty(this.f43818c)) {
                    request.setNotificationVisibility(1);
                    request.setTitle(this.f43817b);
                    request.setDescription(this.f43818c);
                    request.setVisibleInDownloadsUi(true);
                    request.allowScanningByMediaScanner();
                    request.setMimeType("application/vnd.android.package-archive");
                }
                DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                    if (this.f43819d) {
                        return;
                    }
                    d.a.i0.a.v2.f.g(this.f43820e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                }
            }

            @Override // d.a.i0.a.s1.f
            public void b(int i2, String str) {
                if (b.j) {
                    Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i2 + " errorMsg: " + str);
                }
            }
        }

        @Override // d.a.i0.a.p.d.o
        public boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.i0.f.i.k.f.a aVar) {
            return p(context, jSONObject, swanAppDownloadType, aVar);
        }

        @Override // d.a.i0.a.p.d.o
        public boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            this.f43812h = context;
            this.f43813i = callbackHandler;
            this.f43810f = jSONObject.optString("cb");
            this.f43811g = jSONObject.optString("onProgressUpdate");
            this.f43807c = jSONObject.optString("url");
            this.f43808d = jSONObject.optString("name");
            this.f43809e = String.valueOf(this.f43807c.hashCode());
            if (!TextUtils.isEmpty(this.f43810f) && !TextUtils.isEmpty(this.f43807c)) {
                if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                    x();
                }
                DownloadParams.SwanAppDownloadType find = DownloadParams.SwanAppDownloadType.find(swanAppDownloadType.getTypeName());
                return p(context, jSONObject, find, new a(find));
            }
            n(false, "Missing parameters");
            return false;
        }

        @Override // d.a.i0.a.p.d.o
        public boolean d(Context context, JSONObject jSONObject) {
            return q(context, jSONObject);
        }

        @NonNull
        public final String l(DownloadState downloadState, @NonNull String str, @NonNull String str2) {
            return m(downloadState, str, str2, -1);
        }

        @NonNull
        public final String m(DownloadState downloadState, @NonNull String str, @NonNull String str2, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (i2 > 0) {
                    jSONObject.put("state", i2);
                } else {
                    jSONObject.put("state", downloadState);
                }
                jSONObject.put("progress", str);
                jSONObject.put("fileId", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return o(true, null, jSONObject);
        }

        @NonNull
        public final String n(boolean z, @Nullable String str) {
            return o(z, str, null);
        }

        @NonNull
        public final String o(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
            if (str == null) {
                str = z ? "success" : SmsLoginView.f.l;
            }
            return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
        }

        public final boolean p(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.i0.f.i.k.f.a aVar) {
            Bundle bundle = new Bundle();
            bundle.putString("type", swanAppDownloadType.getTypeName());
            bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
            d.a.i0.a.v1.c.e.a E = d.a.i0.a.v1.c.e.a.E();
            if (E != null) {
                E.L(bundle, d.a.i0.a.o.h.a.class, new d.a.i0.a.o.h.b(aVar, swanAppDownloadType));
                return true;
            }
            return true;
        }

        public final boolean q(Context context, JSONObject jSONObject) {
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("description");
            boolean optBoolean = jSONObject.optBoolean("autoinstall");
            if (TextUtils.isEmpty(optString)) {
                d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "download url is empty");
                return false;
            }
            d.a.i0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0778b(this, optString, optString2, optString3, optBoolean, context));
            return true;
        }

        public final void r() {
            this.f43813i.handleSchemeDispatchCallback(this.f43811g, l(DownloadState.DOWNLOAD_FAILED, "0", this.f43809e));
            this.f43813i.handleSchemeDispatchCallback(this.f43810f, n(true, null));
            String str = this.f43805a;
            if (str != null) {
                this.f43813i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                this.f43805a = null;
            }
        }

        public final void s() {
            if (j) {
                Log.d("SwanAdDownloadImpl", "handleInstallApp");
            }
            String concat = new File(d.a.i0.a.o.h.a.n()).getAbsolutePath().concat("/");
            String concat2 = concat.concat(this.f43809e + ".apk");
            if (new File(concat2).exists()) {
                x();
                if (d.a.i0.f.i.r.g.c(concat2, false)) {
                    return;
                }
                this.f43813i.handleSchemeDispatchCallback(this.f43810f, n(false, "install apk error"));
                return;
            }
            this.f43813i.handleSchemeDispatchCallback(this.f43810f, n(false, "Apk Not Found"));
        }

        public final void t(@NonNull String str) {
            this.f43813i.handleSchemeDispatchCallback(this.f43811g, l(DownloadState.DOWNLOAD_PAUSED, str, this.f43809e));
            this.f43813i.handleSchemeDispatchCallback(this.f43810f, n(true, null));
            String str2 = this.f43805a;
            if (str2 != null) {
                this.f43813i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                this.f43805a = null;
            }
        }

        public final void u(@NonNull DownloadState downloadState, @NonNull String str) {
            this.f43813i.handleSchemeDispatchCallback(this.f43811g, l(downloadState, str, this.f43809e));
            if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                this.f43813i.handleSchemeDispatchCallback(this.f43810f, m(downloadState, str, this.f43809e, DownloadState.DELETED.value()));
            } else if (TextUtils.equals(str, "100")) {
                this.f43813i.handleSchemeDispatchCallback(this.f43810f, l(DownloadState.DOWNLOADED, str, this.f43809e));
            } else {
                this.f43813i.handleSchemeDispatchCallback(this.f43810f, l(downloadState, str, this.f43809e));
            }
        }

        public final void v(@NonNull DownloadState downloadState, @NonNull String str) {
            if (j) {
                Log.d("SwanAdDownloadImpl", "handleResumeDownload");
            }
        }

        public final void w(@NonNull DownloadState downloadState, @NonNull String str) {
            this.f43805a = this.f43810f;
            this.f43813i.handleSchemeDispatchCallback(this.f43811g, l(downloadState, str, this.f43809e));
            if (downloadState == DownloadState.DOWNLOADED) {
                this.f43813i.handleSchemeDispatchCallback(this.f43810f, n(true, "onSuccess"));
                this.f43805a = null;
            }
        }

        public final void x() {
            if (this.f43806b == null) {
                this.f43806b = new c(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                this.f43812h.registerReceiver(this.f43806b, intentFilter);
            }
        }

        public void y() {
            c cVar = this.f43806b;
            if (cVar != null) {
                this.f43812h.unregisterReceiver(cVar);
                this.f43806b = null;
            }
        }

        /* loaded from: classes2.dex */
        public class c extends BroadcastReceiver {
            public long time;

            public c() {
                this.time = 0L;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                    return;
                }
                if (TextUtils.equals(b.this.f43808d, intent.getData().getSchemeSpecificPart())) {
                    b bVar = b.this;
                    bVar.f43813i.handleSchemeDispatchCallback(bVar.f43810f, bVar.n(true, null));
                    b.this.y();
                }
            }

            public /* synthetic */ c(b bVar, a aVar) {
                this();
            }
        }
    }

    boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.i0.f.i.k.f.a aVar);

    boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean d(Context context, JSONObject jSONObject);
}
