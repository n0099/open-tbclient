package i.a.a.e.n;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import d.r.b.a.a.f.d.d;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes8.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static Gson f68893c = new Gson();

    /* renamed from: a  reason: collision with root package name */
    public c f68894a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68895b = new Handler(Looper.getMainLooper());

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlPageParams f68897f;

        public a(int i2, UrlPageParams urlPageParams) {
            this.f68896e = i2;
            this.f68897f = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f68894a != null) {
                if (this.f68896e == 1) {
                    b.this.f68894a.b(this.f68897f);
                }
                if (this.f68896e == 3) {
                    b.this.f68894a.a(this.f68897f);
                }
            }
        }
    }

    /* renamed from: i.a.a.e.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1943b implements Runnable {
        public RunnableC1943b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f68894a != null) {
                b.this.f68894a.onNativeOperation(new i.a.a.e.j.a(2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(UrlPageParams urlPageParams);

        void b(UrlPageParams urlPageParams);

        String getToken();

        void onNativeOperation(i.a.a.e.j.a aVar);
    }

    public b(c cVar) {
        this.f68894a = cVar;
    }

    public final void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f68895b.post(runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAndroid(int i2, String str) {
        UrlPageParams urlPageParams;
        if (i2 != 1) {
            if (i2 == 2) {
                if (this.f68894a != null) {
                    b(new RunnableC1943b());
                    return;
                }
                return;
            } else if (i2 != 3) {
                return;
            }
        }
        String str2 = i2 == 1 ? "CODE_OPEN_URL_PAGE" : "CODE_UPFATE_TOP_INFO";
        UrlPageParams urlPageParams2 = null;
        try {
            urlPageParams = (UrlPageParams) f68893c.fromJson(str, (Class<Object>) UrlPageParams.class);
            try {
                d.g("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
            } catch (Throwable th) {
                th = th;
                urlPageParams2 = urlPageParams;
                d.d("YYPaySdkJsInterface", str2 + " error,", th);
                urlPageParams = urlPageParams2;
                if (this.f68894a == null) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (this.f68894a == null) {
            b(new a(i2, urlPageParams));
        }
    }

    @JavascriptInterface
    public String getToken() {
        c cVar = this.f68894a;
        if (cVar != null) {
            return cVar.getToken();
        }
        d.e("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
        return "";
    }
}
