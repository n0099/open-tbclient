package d.a.i0.f.j.m;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d.a.i0.h.t.c.c {

    /* renamed from: d.a.i0.f.j.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0979a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46694a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f46695b;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f46695b = iArr;
            try {
                iArr[Download.DownloadState.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46695b[Download.DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46695b[Download.DownloadState.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46695b[Download.DownloadState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46695b[Download.DownloadState.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46695b[Download.DownloadState.FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f46694a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46694a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46694a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46694a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f46694a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f46694a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f46694a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.i0.a.v1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public d.a.i0.f.i.k.f.a f46696c;

        public b(d.a.i0.f.i.k.f.a aVar) {
            this.f46696c = aVar;
        }

        @Override // d.a.i0.a.v1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.i0.a.v1.a.b.c.a
        public boolean c() {
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v1.a.b.c.c, d.a.i0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.i0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            if (a2 == null) {
                return;
            }
            a.f(a2, this.f46696c);
        }
    }

    public static void f(@NonNull Bundle bundle, d.a.i0.f.i.k.f.a aVar) {
        char c2;
        String string = bundle.getString("functionType");
        if (string == null || aVar == null) {
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int hashCode = string.hashCode();
        if (hashCode != -1013362275) {
            if (hashCode == -530890460 && string.equals("onSuccess")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (string.equals("onFail")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int optInt = jSONObject.optInt("progress", -1);
            if (optInt > -1 && optInt <= 100) {
                aVar.a(optInt);
            }
            if (jSONObject.optBoolean("installed")) {
                aVar.c(DownloadState.INSTALLED, optInt);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            switch (C0979a.f46695b[Download.DownloadState.getState(optJSONObject.optInt("status", -1)).ordinal()]) {
                case 1:
                    aVar.c(DownloadState.WAIT, optInt);
                    return;
                case 2:
                    aVar.c(DownloadState.DOWNLOADING, optInt);
                    return;
                case 3:
                    aVar.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                    return;
                case 4:
                    aVar.c(DownloadState.DOWNLOAD_FAILED, optInt);
                    return;
                case 5:
                    aVar.c(DownloadState.DELETED, optInt);
                    return;
                case 6:
                    aVar.c(DownloadState.DOWNLOADED, optInt);
                    return;
                default:
                    aVar.c(DownloadState.NOT_START, optInt);
                    return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.i0.h.t.c.c
    public boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.i0.f.i.k.f.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", getPackageName());
            jSONObject.put("key_download_url", e());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, d.a.i0.f.j.b.o.z() == null ? "" : d.a.i0.f.j.b.o.z().configName);
            jSONObject.put("download_params", jSONObject2.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String d2 = d(swanAppDownloadType);
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, d2);
        bundle.putString("ubc_params", new d.a.i0.f.j.r.a().a());
        bundle.putString("data", jSONObject.toString());
        d.a.i0.a.v1.c.e.a z = d.a.i0.a.a2.d.g().z();
        if (z != null) {
            z.L(bundle, d.a.i0.f.j.n.f.class, new b(aVar));
            return false;
        }
        return false;
    }

    @Override // d.a.i0.h.t.c.c
    public boolean b() {
        return (TextUtils.isEmpty(e()) || TextUtils.isEmpty(getPackageName())) ? false : true;
    }

    public final String d(SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        switch (C0979a.f46694a[swanAppDownloadType.ordinal()]) {
            case 1:
                return "queryStatus";
            case 2:
                return "startDownload";
            case 3:
                return "pauseDownload";
            case 4:
            case 5:
                return "deleteDownload";
            case 6:
                return "resumeDownload";
            case 7:
                return "installApp";
            default:
                return "";
        }
    }

    public final String e() {
        return d.a.i0.f.j.b.o.H();
    }

    @Override // d.a.i0.h.t.c.c
    public String getPackageName() {
        return d.a.i0.f.j.b.o.I();
    }

    @Override // d.a.i0.h.t.c.c
    public void init() {
        d.a.i0.f.j.b.o.w();
    }
}
