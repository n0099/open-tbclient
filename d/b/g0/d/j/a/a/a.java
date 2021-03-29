package d.b.g0.d.j.a.a;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nps.utils.Constant;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.g0.a.k;
import d.b.g0.a.p.c.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements f {
    public static final boolean j = k.f45051a;
    public static final String k = f.a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f47507a;

    /* renamed from: b  reason: collision with root package name */
    public d f47508b;

    /* renamed from: c  reason: collision with root package name */
    public String f47509c;

    /* renamed from: d  reason: collision with root package name */
    public String f47510d;

    /* renamed from: e  reason: collision with root package name */
    public String f47511e;

    /* renamed from: f  reason: collision with root package name */
    public String f47512f;

    /* renamed from: g  reason: collision with root package name */
    public String f47513g;

    /* renamed from: h  reason: collision with root package name */
    public Context f47514h;
    public CallbackHandler i;

    /* renamed from: d.b.g0.d.j.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0923a implements d.b.g0.a.q.g.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppDownloadAction.SwanAppDownloadType f47515a;

        public C0923a(SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
            this.f47515a = swanAppDownloadType;
        }

        @Override // d.b.g0.a.q.g.a.a
        public void a(SwanAdDownloadState swanAdDownloadState, int i) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onProgressChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
            }
        }

        @Override // d.b.g0.a.q.g.a.a
        public void b() {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onInstall:");
            }
        }

        @Override // d.b.g0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
            }
            switch (c.f47522a[this.f47515a.ordinal()]) {
                case 1:
                    a.this.u(swanAdDownloadState, String.valueOf(i));
                    return;
                case 2:
                    a.this.w(swanAdDownloadState, String.valueOf(i));
                    return;
                case 3:
                    a.this.t(String.valueOf(i));
                    return;
                case 4:
                    a.this.r();
                    return;
                case 5:
                    a.this.v(swanAdDownloadState, String.valueOf(i));
                    return;
                case 6:
                    a.this.s();
                    return;
                default:
                    return;
            }
        }

        @Override // d.b.g0.a.q.g.a.a
        public void d(String str) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
            }
        }

        @Override // d.b.g0.a.q.g.a.a
        public String e() {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onAppOpen:");
                return null;
            }
            return null;
        }

        @Override // d.b.g0.a.q.g.a.a
        public void f(boolean z) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47517a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47519c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f47520d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f47521e;

        public b(a aVar, String str, String str2, String str3, boolean z, Context context) {
            this.f47517a = str;
            this.f47518b = str2;
            this.f47519c = str3;
            this.f47520d = z;
            this.f47521e = context;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f47517a));
            String str2 = this.f47517a;
            request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
            if (!TextUtils.isEmpty(this.f47518b) && !TextUtils.isEmpty(this.f47519c)) {
                request.setNotificationVisibility(1);
                request.setTitle(this.f47518b);
                request.setDescription(this.f47519c);
                request.setVisibleInDownloadsUi(true);
                request.allowScanningByMediaScanner();
                request.setMimeType("application/vnd.android.package-archive");
            }
            DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
            if (downloadManager != null) {
                downloadManager.enqueue(request);
                if (this.f47520d) {
                    return;
                }
                d.b.g0.a.i2.e.f(this.f47521e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
            }
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            if (a.j) {
                String str2 = a.k;
                Log.d(str2, "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47522a;

        static {
            int[] iArr = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f47522a = iArr;
            try {
                iArr[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47522a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47522a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47522a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47522a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47522a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // d.b.g0.a.p.c.f
    public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.b.g0.a.q.g.a.a aVar) {
        return d.b.g0.e.a.l.c.a(context, jSONObject, swanAppDownloadType, aVar);
    }

    @Override // d.b.g0.a.p.c.f
    public boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        this.f47514h = context;
        this.i = callbackHandler;
        this.f47512f = jSONObject.optString("cb");
        this.f47513g = jSONObject.optString("onProgressUpdate");
        this.f47509c = jSONObject.optString("url");
        this.f47510d = jSONObject.optString("name");
        this.f47511e = String.valueOf(this.f47509c.hashCode());
        if (!TextUtils.isEmpty(this.f47512f) && !TextUtils.isEmpty(this.f47509c)) {
            if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                x();
            }
            return d.b.g0.e.a.l.c.a(context, jSONObject, swanAppDownloadType, new C0923a(swanAppDownloadType));
        }
        o(false, "Missing parameters");
        return false;
    }

    @Override // d.b.g0.a.p.c.f
    public boolean c(Context context, JSONObject jSONObject) {
        return q(context, jSONObject);
    }

    @NonNull
    public final String m(SwanAdDownloadState swanAdDownloadState, @NonNull String str, @NonNull String str2) {
        return n(swanAdDownloadState, str, str2, -1);
    }

    @NonNull
    public final String n(SwanAdDownloadState swanAdDownloadState, @NonNull String str, @NonNull String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i > 0) {
                jSONObject.put("state", i);
            } else {
                jSONObject.put("state", swanAdDownloadState);
            }
            jSONObject.put("progress", str);
            jSONObject.put("fileId", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return p(true, null, jSONObject);
    }

    @NonNull
    public final String o(boolean z, @Nullable String str) {
        return p(z, str, null);
    }

    @NonNull
    public final String p(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
        if (str == null) {
            str = z ? "success" : SmsLoginView.f.l;
        }
        return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
    }

    public final boolean q(Context context, JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("title");
        String optString3 = jSONObject.optString("description");
        boolean optBoolean = jSONObject.optBoolean("autoinstall");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "download url is empty");
            return false;
        }
        d.b.g0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, optString, optString2, optString3, optBoolean, context));
        return true;
    }

    public final void r() {
        this.i.handleSchemeDispatchCallback(this.f47513g, m(SwanAdDownloadState.DOWNLOAD_FAILED, "0", this.f47511e));
        this.i.handleSchemeDispatchCallback(this.f47512f, o(true, null));
        String str = this.f47507a;
        if (str != null) {
            this.i.handleSchemeDispatchCallback(str, o(false, "onStopped"));
            this.f47507a = null;
        }
    }

    public final void s() {
        if (j) {
            Log.d("SwanAdDownloadImpl", "handleInstallApp");
        }
        String concat = new File(d.b.g0.e.a.l.b.n()).getAbsolutePath().concat("/");
        String concat2 = concat.concat(this.f47511e + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        if (new File(concat2).exists()) {
            x();
            if (d.b.g0.e.a.l.e.c(concat2, false)) {
                return;
            }
            this.i.handleSchemeDispatchCallback(this.f47512f, o(false, "install apk error"));
            return;
        }
        this.i.handleSchemeDispatchCallback(this.f47512f, o(false, "Apk Not Found"));
    }

    public final void t(@NonNull String str) {
        this.i.handleSchemeDispatchCallback(this.f47513g, m(SwanAdDownloadState.DOWNLOAD_PAUSED, str, this.f47511e));
        this.i.handleSchemeDispatchCallback(this.f47512f, o(true, null));
        String str2 = this.f47507a;
        if (str2 != null) {
            this.i.handleSchemeDispatchCallback(str2, o(false, MissionEvent.MESSAGE_PAUSE));
            this.f47507a = null;
        }
    }

    public final void u(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.i.handleSchemeDispatchCallback(this.f47513g, m(swanAdDownloadState, str, this.f47511e));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED && "-1".equals(str)) {
            this.i.handleSchemeDispatchCallback(this.f47512f, n(swanAdDownloadState, str, this.f47511e, SwanAdDownloadState.DELETED.value()));
        } else if (TextUtils.equals(str, "100")) {
            this.i.handleSchemeDispatchCallback(this.f47512f, m(SwanAdDownloadState.DOWNLOADED, str, this.f47511e));
        } else {
            this.i.handleSchemeDispatchCallback(this.f47512f, m(swanAdDownloadState, str, this.f47511e));
        }
    }

    public final void v(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        if (j) {
            Log.d("SwanAdDownloadImpl", "handleResumeDownload");
        }
    }

    public final void w(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.f47507a = this.f47512f;
        this.i.handleSchemeDispatchCallback(this.f47513g, m(swanAdDownloadState, str, this.f47511e));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.i.handleSchemeDispatchCallback(this.f47512f, o(true, "onSuccess"));
            this.f47507a = null;
        }
    }

    public final void x() {
        if (this.f47508b == null) {
            this.f47508b = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f47514h.registerReceiver(this.f47508b, intentFilter);
        }
    }

    public void y() {
        d dVar = this.f47508b;
        if (dVar != null) {
            this.f47514h.unregisterReceiver(dVar);
            this.f47508b = null;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        public long time;

        public d() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                return;
            }
            if (TextUtils.equals(a.this.f47510d, intent.getData().getSchemeSpecificPart())) {
                a aVar = a.this;
                aVar.i.handleSchemeDispatchCallback(aVar.f47512f, aVar.o(true, null));
                a.this.y();
            }
        }

        public /* synthetic */ d(a aVar, C0923a c0923a) {
            this();
        }
    }
}
