package d.a.l0.a.o.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.core.AdDownloadService;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import d.a.l0.f.i.k.d.a;
import d.a.l0.f.i.r.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.v1.a.a.a {
    public static final String j = AppRuntime.getAppContext().getPackageName();
    public static boolean k = false;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f47557f;

    /* renamed from: h  reason: collision with root package name */
    public AdDownloadService.a f47559h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47558g = false;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f47560i = new ServiceConnectionC0836a();

    /* renamed from: d.a.l0.a.o.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ServiceConnectionC0836a implements ServiceConnection {
        public ServiceConnectionC0836a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f47559h = (AdDownloadService.a) iBinder;
            if (k.f46875a) {
                Log.d("AdDownload", "service connected");
            }
            a aVar = a.this;
            aVar.l(aVar.f47557f);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a.this.f47559h = null;
            if (k.f46875a) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47563f;

        public b(int i2, int i3) {
            this.f47562e = i2;
            this.f47563f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f48946d.putInt("state", this.f47562e);
            a.this.f48946d.putInt("progress", this.f47563f);
            a.this.c();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47565e;

        public c(String str) {
            this.f47565e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f48946d.putString("packageName", this.f47565e);
            a.this.c();
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47567a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f47568b;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f47568b = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47568b[DownloadState.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47568b[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47568b[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47568b[DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47568b[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f47568b[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f47568b[DownloadState.DELETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f47567a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f47567a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f47567a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f47567a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f47567a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f47567a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.l0.f.i.k.f.c {

        /* renamed from: a  reason: collision with root package name */
        public final String f47569a;

        /* renamed from: b  reason: collision with root package name */
        public final String f47570b;

        /* renamed from: d.a.l0.a.o.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0837a extends a.d<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.f.i.k.f.d f47572a;

            public C0837a(d.a.l0.f.i.k.f.d dVar) {
                this.f47572a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.f.i.k.d.a.d
            /* renamed from: b */
            public void a(Boolean bool) {
                super.a(bool);
                if (bool.booleanValue()) {
                    if (k.f46875a) {
                        Log.d("AdDownload", "安装完成");
                    }
                    d.a.l0.f.i.k.f.d dVar = this.f47572a;
                    dVar.b(dVar.g(e.this.f47570b));
                    a.this.y(DownloadState.INSTALLED.value(), Integer.parseInt("100"));
                }
            }
        }

        public e(String str, String str2) {
            this.f47569a = str;
            this.f47570b = str2;
        }

        @Override // d.a.l0.f.i.k.f.c
        public void a() {
            String str;
            a.this.y(DownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
            if (k.f46875a) {
                Log.d("AdDownload", "下载完成");
            }
            String str2 = this.f47569a;
            if (TextUtils.isEmpty(str2) && (str = this.f47570b) != null) {
                str2 = a.this.w(str);
                a.this.x(str2);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Uri parse = Uri.parse(this.f47570b);
            d.a.l0.f.i.k.f.d m = d.a.l0.f.i.k.d.a.m(a.this.m(), null);
            m.f(str2, parse, new C0837a(m));
        }

        @Override // d.a.l0.f.i.k.f.c
        public void b(DownloadException downloadException) {
            a.this.y(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
        }

        @Override // d.a.l0.f.i.k.f.c
        public void c() {
            a.this.y(DownloadState.DELETED.value(), Integer.parseInt("0"));
            if (k.f46875a) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // d.a.l0.f.i.k.f.c
        public void d() {
            a.this.y(DownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (k.f46875a) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // d.a.l0.f.i.k.f.c
        public void e(long j, long j2) {
            String o = a.o(j, j2);
            a.this.y(DownloadState.DOWNLOADING.value(), Integer.parseInt(o));
            if (k.f46875a) {
                Log.d("AdDownload", "下载进度" + o);
            }
        }

        @Override // d.a.l0.f.i.k.f.c
        public void f(long j, long j2) {
            String o = a.o(j, j2);
            a.this.y(DownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(o));
            if (k.f46875a) {
                Log.d("AdDownload", "下载暂停" + o);
            }
        }

        @Override // d.a.l0.f.i.k.f.c
        public void onStart() {
            a.this.y(DownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
            if (k.f46875a) {
                Log.d("AdDownload", "下载开始");
            }
        }
    }

    public static String n() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "swanAdDownload";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }
        return "";
    }

    public static String o(long j2, long j3) {
        return (j3 <= 0 || j2 <= 0) ? "0" : String.valueOf((int) Math.floor((j2 * 100) / j3));
    }

    public void A() {
        if (k) {
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            m.stopService(intent);
            k = false;
        }
    }

    public void B() {
        if (this.f47558g) {
            this.f47558g = false;
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            m.unbindService(this.f47560i);
        }
    }

    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        this.f47557f = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            A();
            return;
        }
        z();
        k();
    }

    public void k() {
        if (this.f47558g) {
            return;
        }
        this.f47558g = true;
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        m.bindService(intent, this.f47560i, 128);
    }

    public void l(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject d2 = w.d(bundle.getString(PushConstants.PARAMS, null));
            String optString = d2.optString("url");
            if (!TextUtils.isEmpty(optString) && this.f47559h != null) {
                switch (d.f47567a[find.ordinal()]) {
                    case 1:
                        t(d2, optString);
                        break;
                    case 2:
                        v(d2, optString);
                        break;
                    case 3:
                        s(optString);
                        break;
                    case 4:
                        p(optString);
                        break;
                    case 5:
                        u(optString);
                        break;
                    case 6:
                        r(d2, optString);
                        break;
                }
            }
        } catch (Exception unused) {
            q();
        }
    }

    public final Context m() {
        return AppRuntime.getAppContext();
    }

    public final void p(@NonNull String str) {
        this.f47559h.a(this.f47559h.b(str));
    }

    public final void q() {
        y(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    public final void r(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2 = this.f47559h.b(str);
        if (b2 == null) {
            return;
        }
        g.c(b2.getPath(), false);
    }

    public final void s(@NonNull String str) {
        this.f47559h.c(this.f47559h.b(str));
    }

    public final void t(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2 = this.f47559h.b(str);
        int value = DownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (b2 == null) {
            y(value, parseInt);
            return;
        }
        long progress = b2.getProgress();
        long size = b2.getSize();
        switch (d.f47568b[DownloadState.convert(b2.getStatus()).ordinal()]) {
            case 1:
            case 2:
            case 3:
                value = DownloadState.NOT_START.value();
                parseInt = Integer.parseInt("0");
                break;
            case 4:
                value = DownloadState.DOWNLOADED.value();
                parseInt = Integer.parseInt("100");
                break;
            case 5:
                value = DownloadState.DOWNLOADING.value();
                parseInt = Integer.parseInt(o(progress, size));
                break;
            case 6:
                value = DownloadState.DOWNLOAD_FAILED.value();
                parseInt = Integer.parseInt("0");
                break;
            case 7:
                value = DownloadState.DOWNLOAD_PAUSED.value();
                parseInt = Integer.parseInt(o(progress, size));
                break;
            case 8:
                value = DownloadState.DELETED.value();
                parseInt = Integer.parseInt("0");
                break;
        }
        y(value, parseInt);
    }

    public final void u(@NonNull String str) {
        this.f47559h.d(this.f47559h.b(str));
    }

    public final void v(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2 = this.f47559h.b(str);
        String optString = jSONObject.optString("name");
        String n = n();
        if (TextUtils.isEmpty(n)) {
            q();
            return;
        }
        File file = new File(n);
        String valueOf = String.valueOf(str.hashCode());
        String concat = file.getAbsolutePath().concat("/");
        String concat2 = concat.concat(valueOf + ".apk");
        if (b2 == null) {
            DownloadInfo.a aVar = new DownloadInfo.a();
            aVar.e(str);
            aVar.d(concat2);
            aVar.c(optString);
            b2 = aVar.a();
        }
        b2.setDownloadListener(new e(optString, str));
        this.f47559h.e(b2);
    }

    public final String w(@NonNull String str) {
        DownloadInfo b2 = this.f47559h.b(str);
        return b2 == null ? "" : b2.getPackageName();
    }

    public final void x(String str) {
        d.a.l0.a.a2.d.i().post(new c(str));
    }

    public final void y(int i2, int i3) {
        d.a.l0.a.a2.d.i().post(new b(i2, i3));
        B();
    }

    public void z() {
        if (k) {
            return;
        }
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        m.startService(intent);
        k = true;
    }
}
