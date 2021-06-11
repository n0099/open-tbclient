package i.a.a.e.p;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes8.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static Gson f72240c = new Gson();

    /* renamed from: a  reason: collision with root package name */
    public f f72241a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f72242b = new Handler(Looper.getMainLooper());

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlPageParams f72244f;

        public a(int i2, UrlPageParams urlPageParams) {
            this.f72243e = i2;
            this.f72244f = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f72241a != null) {
                if (this.f72243e == 1) {
                    b.this.f72241a.b(this.f72244f);
                }
                if (this.f72243e == 3) {
                    b.this.f72241a.a(this.f72244f);
                }
            }
        }
    }

    /* renamed from: i.a.a.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1997b implements Runnable {
        public RunnableC1997b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f72241a != null) {
                b.this.f72241a.onNativeOperation(new NativeOperationParams(2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72247e;

        public c(String str) {
            this.f72247e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f72241a != null) {
                b.this.f72241a.onNativeOperation(new NativeOperationParams(5, this.f72247e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72249e;

        public d(String str) {
            this.f72249e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f72241a != null) {
                b.this.f72241a.onNativeOperation(new NativeOperationParams(4, this.f72249e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72251e;

        public e(String str) {
            this.f72251e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f72241a != null) {
                b.this.f72241a.onNativeOperation(new NativeOperationParams(6, this.f72251e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(UrlPageParams urlPageParams);

        void b(UrlPageParams urlPageParams);

        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);
    }

    public b(f fVar) {
        this.f72241a = fVar;
    }

    public final void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f72242b.post(runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAndroid(int i2, String str) {
        UrlPageParams urlPageParams;
        RLog.info("YYPaySdkJsInterface", "callAndroid: code=" + i2 + ", params=" + str);
        switch (i2) {
            case 1:
            case 3:
                String str2 = i2 == 1 ? "CODE_OPEN_URL_PAGE" : "CODE_UPFATE_TOP_INFO";
                UrlPageParams urlPageParams2 = null;
                try {
                    urlPageParams = (UrlPageParams) f72240c.fromJson(str, (Class<Object>) UrlPageParams.class);
                    try {
                        RLog.info("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
                    } catch (Throwable th) {
                        th = th;
                        urlPageParams2 = urlPageParams;
                        RLog.error("YYPaySdkJsInterface", str2 + " error,", th);
                        urlPageParams = urlPageParams2;
                        if (this.f72241a == null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                if (this.f72241a == null) {
                    b(new a(i2, urlPageParams));
                    return;
                }
                return;
            case 2:
                if (this.f72241a != null) {
                    b(new RunnableC1997b());
                    return;
                }
                return;
            case 4:
                if (this.f72241a != null) {
                    b(new d(str));
                    return;
                }
                return;
            case 5:
                if (this.f72241a != null) {
                    b(new c(str));
                    return;
                }
                return;
            case 6:
                if (this.f72241a != null) {
                    b(new e(str));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @JavascriptInterface
    public String getToken() {
        f fVar = this.f72241a;
        if (fVar != null) {
            return fVar.getToken();
        }
        RLog.error("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
        return "";
    }
}
