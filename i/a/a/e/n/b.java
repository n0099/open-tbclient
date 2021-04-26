package i.a.a.e.n;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import d.r.b.a.a.f.d.d;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static Gson f68213c = new Gson();

    /* renamed from: a  reason: collision with root package name */
    public c f68214a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68215b = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlPageParams f68217f;

        public a(int i2, UrlPageParams urlPageParams) {
            this.f68216e = i2;
            this.f68217f = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f68214a != null) {
                if (this.f68216e == 1) {
                    b.this.f68214a.b(this.f68217f);
                }
                if (this.f68216e == 3) {
                    b.this.f68214a.a(this.f68217f);
                }
            }
        }
    }

    /* renamed from: i.a.a.e.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1880b implements Runnable {
        public RunnableC1880b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f68214a != null) {
                b.this.f68214a.onNativeOperation(new i.a.a.e.j.a(2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(UrlPageParams urlPageParams);

        void b(UrlPageParams urlPageParams);

        String getToken();

        void onNativeOperation(i.a.a.e.j.a aVar);
    }

    public b(c cVar) {
        this.f68214a = cVar;
    }

    public final void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f68215b.post(runnable);
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
                if (this.f68214a != null) {
                    b(new RunnableC1880b());
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
            urlPageParams = (UrlPageParams) f68213c.fromJson(str, (Class<Object>) UrlPageParams.class);
            try {
                d.g("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
            } catch (Throwable th) {
                th = th;
                urlPageParams2 = urlPageParams;
                d.d("YYPaySdkJsInterface", str2 + " error,", th);
                urlPageParams = urlPageParams2;
                if (this.f68214a == null) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (this.f68214a == null) {
            b(new a(i2, urlPageParams));
        }
    }

    @JavascriptInterface
    public String getToken() {
        c cVar = this.f68214a;
        if (cVar != null) {
            return cVar.getToken();
        }
        d.e("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
        return "";
    }
}
