package d.a.h0.e.a.l;

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
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.core.AdDownloadService;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.h0.a.i2.v;
import d.a.h0.a.k;
import d.a.h0.e.a.l.g.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.h0.a.n1.a.a.a {
    public static final String j = AppRuntime.getAppContext().getPackageName();
    public static boolean k = false;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f45738f;

    /* renamed from: h  reason: collision with root package name */
    public AdDownloadService.a f45740h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45739g = false;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f45741i = new a();

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f45740h = (AdDownloadService.a) iBinder;
            if (k.f43101a) {
                Log.d("AdDownload", "service connected");
            }
            b bVar = b.this;
            bVar.l(bVar.f45738f);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f45740h = null;
            if (k.f43101a) {
                Log.d("AdDownload", "service disconnected");
            }
        }
    }

    /* renamed from: d.a.h0.e.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0900b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45743e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45744f;

        public RunnableC0900b(int i2, int i3) {
            this.f45743e = i2;
            this.f45744f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f43404d.putInt("state", this.f45743e);
            b.this.f43404d.putInt("progress", this.f45744f);
            b.this.c();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45746e;

        public c(String str) {
            this.f45746e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f43404d.putString("packageName", this.f45746e);
            b.this.c();
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45748a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f45749b;

        static {
            int[] iArr = new int[SwanAdDownloadState.values().length];
            f45749b = iArr;
            try {
                iArr[SwanAdDownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45749b[SwanAdDownloadState.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45749b[SwanAdDownloadState.PREPARE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45749b[SwanAdDownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45749b[SwanAdDownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45749b[SwanAdDownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45749b[SwanAdDownloadState.DOWNLOAD_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45749b[SwanAdDownloadState.DELETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f45748a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f45748a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f45748a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f45748a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f45748a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f45748a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.e.a.l.i.b {

        /* renamed from: a  reason: collision with root package name */
        public final String f45750a;

        /* renamed from: b  reason: collision with root package name */
        public final String f45751b;

        /* loaded from: classes3.dex */
        public class a extends a.d<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.e.a.l.i.c f45753a;

            public a(d.a.h0.e.a.l.i.c cVar) {
                this.f45753a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.e.a.l.g.a.d
            /* renamed from: b */
            public void a(Boolean bool) {
                super.a(bool);
                if (bool.booleanValue()) {
                    if (k.f43101a) {
                        Log.d("AdDownload", "安装完成");
                    }
                    d.a.h0.e.a.l.i.c cVar = this.f45753a;
                    cVar.b(cVar.g(e.this.f45751b));
                    b.this.y(SwanAdDownloadState.INSTALLED.value(), Integer.parseInt("100"));
                }
            }
        }

        public e(String str, String str2) {
            this.f45750a = str;
            this.f45751b = str2;
        }

        @Override // d.a.h0.e.a.l.i.b
        public void a() {
            String str;
            b.this.y(SwanAdDownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
            if (k.f43101a) {
                Log.d("AdDownload", "下载完成");
            }
            String str2 = this.f45750a;
            if (TextUtils.isEmpty(str2) && (str = this.f45751b) != null) {
                str2 = b.this.w(str);
                b.this.x(str2);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Uri parse = Uri.parse(this.f45751b);
            d.a.h0.e.a.l.i.c m = d.a.h0.e.a.l.g.a.m(b.this.m(), null);
            m.f(str2, parse, new a(m));
        }

        @Override // d.a.h0.e.a.l.i.b
        public void b(DownloadException downloadException) {
            b.this.y(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
        }

        @Override // d.a.h0.e.a.l.i.b
        public void c() {
            b.this.y(SwanAdDownloadState.DELETED.value(), Integer.parseInt("0"));
            if (k.f43101a) {
                Log.d("AdDownload", "下载移除");
            }
        }

        @Override // d.a.h0.e.a.l.i.b
        public void d() {
            b.this.y(SwanAdDownloadState.NOT_START.value(), Integer.parseInt("0"));
            if (k.f43101a) {
                Log.d("AdDownload", "下载等待");
            }
        }

        @Override // d.a.h0.e.a.l.i.b
        public void e(long j, long j2) {
            String o = b.o(j, j2);
            b.this.y(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt(o));
            if (k.f43101a) {
                Log.d("AdDownload", "下载进度" + o);
            }
        }

        @Override // d.a.h0.e.a.l.i.b
        public void f(long j, long j2) {
            String o = b.o(j, j2);
            b.this.y(SwanAdDownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(o));
            if (k.f43101a) {
                Log.d("AdDownload", "下载暂停" + o);
            }
        }

        @Override // d.a.h0.e.a.l.i.b
        public void onStart() {
            b.this.y(SwanAdDownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
            if (k.f43101a) {
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
        if (this.f45739g) {
            this.f45739g = false;
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            m.unbindService(this.f45741i);
        }
    }

    @Override // d.a.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        this.f45738f = bundle;
        if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
            A();
            return;
        }
        z();
        k();
    }

    public void k() {
        if (this.f45739g) {
            return;
        }
        this.f45739g = true;
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        m.bindService(intent, this.f45741i, 128);
    }

    public void l(@NonNull Bundle bundle) {
        try {
            SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
            JSONObject b2 = v.b(bundle.getString(PushConstants.PARAMS, null));
            String optString = b2.optString("url");
            if (!TextUtils.isEmpty(optString) && this.f45740h != null) {
                switch (d.f45748a[find.ordinal()]) {
                    case 1:
                        t(b2, optString);
                        break;
                    case 2:
                        v(b2, optString);
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
                        r(b2, optString);
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
        this.f45740h.a(this.f45740h.b(str));
    }

    public final void q() {
        y(SwanAdDownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
    }

    public final void r(@NonNull JSONObject jSONObject, @NonNull String str) {
        d.a.h0.e.a.l.e.c(this.f45740h.b(str).getPath(), false);
    }

    public final void s(@NonNull String str) {
        this.f45740h.c(this.f45740h.b(str));
    }

    public final void t(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2 = this.f45740h.b(str);
        int value = SwanAdDownloadState.NOT_START.value();
        int parseInt = Integer.parseInt("0");
        if (b2 == null) {
            y(value, parseInt);
            return;
        }
        long progress = b2.getProgress();
        long size = b2.getSize();
        switch (d.f45749b[SwanAdDownloadState.convert(b2.getStatus()).ordinal()]) {
            case 1:
            case 2:
            case 3:
                value = SwanAdDownloadState.NOT_START.value();
                parseInt = Integer.parseInt("0");
                break;
            case 4:
                value = SwanAdDownloadState.DOWNLOADED.value();
                parseInt = Integer.parseInt("100");
                break;
            case 5:
                value = SwanAdDownloadState.DOWNLOADING.value();
                parseInt = Integer.parseInt(o(progress, size));
                break;
            case 6:
                value = SwanAdDownloadState.DOWNLOAD_FAILED.value();
                parseInt = Integer.parseInt("0");
                break;
            case 7:
                value = SwanAdDownloadState.DOWNLOAD_PAUSED.value();
                parseInt = Integer.parseInt(o(progress, size));
                break;
            case 8:
                value = SwanAdDownloadState.DELETED.value();
                parseInt = Integer.parseInt("0");
                break;
        }
        y(value, parseInt);
    }

    public final void u(@NonNull String str) {
        this.f45740h.d(this.f45740h.b(str));
    }

    public final void v(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2 = this.f45740h.b(str);
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
        this.f45740h.e(b2);
    }

    public final String w(@NonNull String str) {
        return this.f45740h.b(str).getPackageName();
    }

    public final void x(String str) {
        d.a.h0.a.r1.d.g().post(new c(str));
    }

    public final void y(int i2, int i3) {
        d.a.h0.a.r1.d.g().post(new RunnableC0900b(i2, i3));
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
