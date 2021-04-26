package d.a.h0.d.j.a.a;

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
import d.a.h0.a.k;
import d.a.h0.a.p.c.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements f {
    public static final boolean j = k.f43101a;
    public static final String k = f.a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f45677a;

    /* renamed from: b  reason: collision with root package name */
    public d f45678b;

    /* renamed from: c  reason: collision with root package name */
    public String f45679c;

    /* renamed from: d  reason: collision with root package name */
    public String f45680d;

    /* renamed from: e  reason: collision with root package name */
    public String f45681e;

    /* renamed from: f  reason: collision with root package name */
    public String f45682f;

    /* renamed from: g  reason: collision with root package name */
    public String f45683g;

    /* renamed from: h  reason: collision with root package name */
    public Context f45684h;

    /* renamed from: i  reason: collision with root package name */
    public CallbackHandler f45685i;

    /* renamed from: d.a.h0.d.j.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0894a implements d.a.h0.a.q.g.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppDownloadAction.SwanAppDownloadType f45686a;

        public C0894a(SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
            this.f45686a = swanAppDownloadType;
        }

        @Override // d.a.h0.a.q.g.a.a
        public void a() {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onInstall:");
            }
        }

        @Override // d.a.h0.a.q.g.a.a
        public void b(SwanAdDownloadState swanAdDownloadState, int i2) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onProgressChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i2);
            }
        }

        @Override // d.a.h0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i2) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i2);
            }
            switch (c.f45693a[this.f45686a.ordinal()]) {
                case 1:
                    a.this.u(swanAdDownloadState, String.valueOf(i2));
                    return;
                case 2:
                    a.this.w(swanAdDownloadState, String.valueOf(i2));
                    return;
                case 3:
                    a.this.t(String.valueOf(i2));
                    return;
                case 4:
                    a.this.r();
                    return;
                case 5:
                    a.this.v(swanAdDownloadState, String.valueOf(i2));
                    return;
                case 6:
                    a.this.s();
                    return;
                default:
                    return;
            }
        }

        @Override // d.a.h0.a.q.g.a.a
        public void d(String str) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
            }
        }

        @Override // d.a.h0.a.q.g.a.a
        public String e() {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onAppOpen:");
                return null;
            }
            return null;
        }

        @Override // d.a.h0.a.q.g.a.a
        public void f(boolean z) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45688a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45689b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45690c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f45691d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45692e;

        public b(a aVar, String str, String str2, String str3, boolean z, Context context) {
            this.f45688a = str;
            this.f45689b = str2;
            this.f45690c = str3;
            this.f45691d = z;
            this.f45692e = context;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f45688a));
            String str2 = this.f45688a;
            request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
            if (!TextUtils.isEmpty(this.f45689b) && !TextUtils.isEmpty(this.f45690c)) {
                request.setNotificationVisibility(1);
                request.setTitle(this.f45689b);
                request.setDescription(this.f45690c);
                request.setVisibleInDownloadsUi(true);
                request.allowScanningByMediaScanner();
                request.setMimeType("application/vnd.android.package-archive");
            }
            DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
            if (downloadManager != null) {
                downloadManager.enqueue(request);
                if (this.f45691d) {
                    return;
                }
                d.a.h0.a.i2.e.f(this.f45692e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
            }
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            if (a.j) {
                String str2 = a.k;
                Log.d(str2, "onAuthorizedFailed,  errorCode: " + i2 + " errorMsg: " + str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45693a;

        static {
            int[] iArr = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f45693a = iArr;
            try {
                iArr[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45693a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45693a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45693a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45693a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45693a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // d.a.h0.a.p.c.f
    public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.h0.a.q.g.a.a aVar) {
        return d.a.h0.e.a.l.c.a(context, jSONObject, swanAppDownloadType, aVar);
    }

    @Override // d.a.h0.a.p.c.f
    public boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        this.f45684h = context;
        this.f45685i = callbackHandler;
        this.f45682f = jSONObject.optString("cb");
        this.f45683g = jSONObject.optString("onProgressUpdate");
        this.f45679c = jSONObject.optString("url");
        this.f45680d = jSONObject.optString("name");
        this.f45681e = String.valueOf(this.f45679c.hashCode());
        if (!TextUtils.isEmpty(this.f45682f) && !TextUtils.isEmpty(this.f45679c)) {
            if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                x();
            }
            return d.a.h0.e.a.l.c.a(context, jSONObject, swanAppDownloadType, new C0894a(swanAppDownloadType));
        }
        o(false, "Missing parameters");
        return false;
    }

    @Override // d.a.h0.a.p.c.f
    public boolean c(Context context, JSONObject jSONObject) {
        return q(context, jSONObject);
    }

    @NonNull
    public final String m(SwanAdDownloadState swanAdDownloadState, @NonNull String str, @NonNull String str2) {
        return n(swanAdDownloadState, str, str2, -1);
    }

    @NonNull
    public final String n(SwanAdDownloadState swanAdDownloadState, @NonNull String str, @NonNull String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i2 > 0) {
                jSONObject.put("state", i2);
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
            d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "download url is empty");
            return false;
        }
        d.a.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, optString, optString2, optString3, optBoolean, context));
        return true;
    }

    public final void r() {
        this.f45685i.handleSchemeDispatchCallback(this.f45683g, m(SwanAdDownloadState.DOWNLOAD_FAILED, "0", this.f45681e));
        this.f45685i.handleSchemeDispatchCallback(this.f45682f, o(true, null));
        String str = this.f45677a;
        if (str != null) {
            this.f45685i.handleSchemeDispatchCallback(str, o(false, "onStopped"));
            this.f45677a = null;
        }
    }

    public final void s() {
        if (j) {
            Log.d("SwanAdDownloadImpl", "handleInstallApp");
        }
        String concat = new File(d.a.h0.e.a.l.b.n()).getAbsolutePath().concat("/");
        String concat2 = concat.concat(this.f45681e + ".apk");
        if (new File(concat2).exists()) {
            x();
            if (d.a.h0.e.a.l.e.c(concat2, false)) {
                return;
            }
            this.f45685i.handleSchemeDispatchCallback(this.f45682f, o(false, "install apk error"));
            return;
        }
        this.f45685i.handleSchemeDispatchCallback(this.f45682f, o(false, "Apk Not Found"));
    }

    public final void t(@NonNull String str) {
        this.f45685i.handleSchemeDispatchCallback(this.f45683g, m(SwanAdDownloadState.DOWNLOAD_PAUSED, str, this.f45681e));
        this.f45685i.handleSchemeDispatchCallback(this.f45682f, o(true, null));
        String str2 = this.f45677a;
        if (str2 != null) {
            this.f45685i.handleSchemeDispatchCallback(str2, o(false, MissionEvent.MESSAGE_PAUSE));
            this.f45677a = null;
        }
    }

    public final void u(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.f45685i.handleSchemeDispatchCallback(this.f45683g, m(swanAdDownloadState, str, this.f45681e));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED && "-1".equals(str)) {
            this.f45685i.handleSchemeDispatchCallback(this.f45682f, n(swanAdDownloadState, str, this.f45681e, SwanAdDownloadState.DELETED.value()));
        } else if (TextUtils.equals(str, "100")) {
            this.f45685i.handleSchemeDispatchCallback(this.f45682f, m(SwanAdDownloadState.DOWNLOADED, str, this.f45681e));
        } else {
            this.f45685i.handleSchemeDispatchCallback(this.f45682f, m(swanAdDownloadState, str, this.f45681e));
        }
    }

    public final void v(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        if (j) {
            Log.d("SwanAdDownloadImpl", "handleResumeDownload");
        }
    }

    public final void w(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.f45677a = this.f45682f;
        this.f45685i.handleSchemeDispatchCallback(this.f45683g, m(swanAdDownloadState, str, this.f45681e));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.f45685i.handleSchemeDispatchCallback(this.f45682f, o(true, "onSuccess"));
            this.f45677a = null;
        }
    }

    public final void x() {
        if (this.f45678b == null) {
            this.f45678b = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f45684h.registerReceiver(this.f45678b, intentFilter);
        }
    }

    public void y() {
        d dVar = this.f45678b;
        if (dVar != null) {
            this.f45684h.unregisterReceiver(dVar);
            this.f45678b = null;
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
            if (TextUtils.equals(a.this.f45680d, intent.getData().getSchemeSpecificPart())) {
                a aVar = a.this;
                aVar.f45685i.handleSchemeDispatchCallback(aVar.f45682f, aVar.o(true, null));
                a.this.y();
            }
        }

        public /* synthetic */ d(a aVar, C0894a c0894a) {
            this();
        }
    }
}
