package d.b.h0.d.j.a.a;

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
import d.b.h0.a.k;
import d.b.h0.a.p.c.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements f {
    public static final boolean j = k.f45772a;
    public static final String k = f.a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f48228a;

    /* renamed from: b  reason: collision with root package name */
    public d f48229b;

    /* renamed from: c  reason: collision with root package name */
    public String f48230c;

    /* renamed from: d  reason: collision with root package name */
    public String f48231d;

    /* renamed from: e  reason: collision with root package name */
    public String f48232e;

    /* renamed from: f  reason: collision with root package name */
    public String f48233f;

    /* renamed from: g  reason: collision with root package name */
    public String f48234g;

    /* renamed from: h  reason: collision with root package name */
    public Context f48235h;
    public CallbackHandler i;

    /* renamed from: d.b.h0.d.j.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0955a implements d.b.h0.a.q.g.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppDownloadAction.SwanAppDownloadType f48236a;

        public C0955a(SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
            this.f48236a = swanAppDownloadType;
        }

        @Override // d.b.h0.a.q.g.a.a
        public void a(SwanAdDownloadState swanAdDownloadState, int i) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onProgressChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
            }
        }

        @Override // d.b.h0.a.q.g.a.a
        public void b() {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onInstall:");
            }
        }

        @Override // d.b.h0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + swanAdDownloadState + ", onProgressChange:" + i);
            }
            switch (c.f48243a[this.f48236a.ordinal()]) {
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

        @Override // d.b.h0.a.q.g.a.a
        public void d(String str) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
            }
        }

        @Override // d.b.h0.a.q.g.a.a
        public String e() {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onAppOpen:");
                return null;
            }
            return null;
        }

        @Override // d.b.h0.a.q.g.a.a
        public void f(boolean z) {
            if (a.j) {
                Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48238a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48239b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48240c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f48241d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f48242e;

        public b(a aVar, String str, String str2, String str3, boolean z, Context context) {
            this.f48238a = str;
            this.f48239b = str2;
            this.f48240c = str3;
            this.f48241d = z;
            this.f48242e = context;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f48238a));
            String str2 = this.f48238a;
            request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
            if (!TextUtils.isEmpty(this.f48239b) && !TextUtils.isEmpty(this.f48240c)) {
                request.setNotificationVisibility(1);
                request.setTitle(this.f48239b);
                request.setDescription(this.f48240c);
                request.setVisibleInDownloadsUi(true);
                request.allowScanningByMediaScanner();
                request.setMimeType("application/vnd.android.package-archive");
            }
            DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
            if (downloadManager != null) {
                downloadManager.enqueue(request);
                if (this.f48241d) {
                    return;
                }
                d.b.h0.a.i2.e.f(this.f48242e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
            }
        }

        @Override // d.b.h0.a.k1.b
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
        public static final /* synthetic */ int[] f48243a;

        static {
            int[] iArr = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f48243a = iArr;
            try {
                iArr[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48243a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48243a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48243a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f48243a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48243a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // d.b.h0.a.p.c.f
    public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.b.h0.a.q.g.a.a aVar) {
        return d.b.h0.e.a.l.c.a(context, jSONObject, swanAppDownloadType, aVar);
    }

    @Override // d.b.h0.a.p.c.f
    public boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        this.f48235h = context;
        this.i = callbackHandler;
        this.f48233f = jSONObject.optString("cb");
        this.f48234g = jSONObject.optString("onProgressUpdate");
        this.f48230c = jSONObject.optString("url");
        this.f48231d = jSONObject.optString("name");
        this.f48232e = String.valueOf(this.f48230c.hashCode());
        if (!TextUtils.isEmpty(this.f48233f) && !TextUtils.isEmpty(this.f48230c)) {
            if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                x();
            }
            return d.b.h0.e.a.l.c.a(context, jSONObject, swanAppDownloadType, new C0955a(swanAppDownloadType));
        }
        o(false, "Missing parameters");
        return false;
    }

    @Override // d.b.h0.a.p.c.f
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
            d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "download url is empty");
            return false;
        }
        d.b.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, optString, optString2, optString3, optBoolean, context));
        return true;
    }

    public final void r() {
        this.i.handleSchemeDispatchCallback(this.f48234g, m(SwanAdDownloadState.DOWNLOAD_FAILED, "0", this.f48232e));
        this.i.handleSchemeDispatchCallback(this.f48233f, o(true, null));
        String str = this.f48228a;
        if (str != null) {
            this.i.handleSchemeDispatchCallback(str, o(false, "onStopped"));
            this.f48228a = null;
        }
    }

    public final void s() {
        if (j) {
            Log.d("SwanAdDownloadImpl", "handleInstallApp");
        }
        String concat = new File(d.b.h0.e.a.l.b.n()).getAbsolutePath().concat("/");
        String concat2 = concat.concat(this.f48232e + ".apk");
        if (new File(concat2).exists()) {
            x();
            if (d.b.h0.e.a.l.e.c(concat2, false)) {
                return;
            }
            this.i.handleSchemeDispatchCallback(this.f48233f, o(false, "install apk error"));
            return;
        }
        this.i.handleSchemeDispatchCallback(this.f48233f, o(false, "Apk Not Found"));
    }

    public final void t(@NonNull String str) {
        this.i.handleSchemeDispatchCallback(this.f48234g, m(SwanAdDownloadState.DOWNLOAD_PAUSED, str, this.f48232e));
        this.i.handleSchemeDispatchCallback(this.f48233f, o(true, null));
        String str2 = this.f48228a;
        if (str2 != null) {
            this.i.handleSchemeDispatchCallback(str2, o(false, MissionEvent.MESSAGE_PAUSE));
            this.f48228a = null;
        }
    }

    public final void u(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.i.handleSchemeDispatchCallback(this.f48234g, m(swanAdDownloadState, str, this.f48232e));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED && "-1".equals(str)) {
            this.i.handleSchemeDispatchCallback(this.f48233f, n(swanAdDownloadState, str, this.f48232e, SwanAdDownloadState.DELETED.value()));
        } else if (TextUtils.equals(str, "100")) {
            this.i.handleSchemeDispatchCallback(this.f48233f, m(SwanAdDownloadState.DOWNLOADED, str, this.f48232e));
        } else {
            this.i.handleSchemeDispatchCallback(this.f48233f, m(swanAdDownloadState, str, this.f48232e));
        }
    }

    public final void v(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        if (j) {
            Log.d("SwanAdDownloadImpl", "handleResumeDownload");
        }
    }

    public final void w(@NonNull SwanAdDownloadState swanAdDownloadState, @NonNull String str) {
        this.f48228a = this.f48233f;
        this.i.handleSchemeDispatchCallback(this.f48234g, m(swanAdDownloadState, str, this.f48232e));
        if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.i.handleSchemeDispatchCallback(this.f48233f, o(true, "onSuccess"));
            this.f48228a = null;
        }
    }

    public final void x() {
        if (this.f48229b == null) {
            this.f48229b = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            this.f48235h.registerReceiver(this.f48229b, intentFilter);
        }
    }

    public void y() {
        d dVar = this.f48229b;
        if (dVar != null) {
            this.f48235h.unregisterReceiver(dVar);
            this.f48229b = null;
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
            if (TextUtils.equals(a.this.f48231d, intent.getData().getSchemeSpecificPart())) {
                a aVar = a.this;
                aVar.i.handleSchemeDispatchCallback(aVar.f48233f, aVar.o(true, null));
                a.this.y();
            }
        }

        public /* synthetic */ d(a aVar, C0955a c0955a) {
            this();
        }
    }
}
