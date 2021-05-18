package d.a.i0.a.h0.o.h.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiWebView;
import com.baidu.webkit.sdk.WebResourceResponse;
import d.a.i0.a.h0.o.h.g.d;
import d.a.i0.a.v2.q0;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class a implements d.a.i0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.h0.o.h.c.a f42296b;

    /* renamed from: c  reason: collision with root package name */
    public File f42297c = new File(d.a.i0.a.h0.o.h.d.a.a().b(), "image_temp");

    /* renamed from: d  reason: collision with root package name */
    public b f42298d;

    /* renamed from: d.a.i0.a.h0.o.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0680a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42300f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f42301g;

        public RunnableC0680a(String str, int i2, String str2) {
            this.f42299e = str;
            this.f42300f = i2;
            this.f42301g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f42298d.onError(this.f42299e, this.f42300f, this.f42301g);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onError(String str, int i2, String str2);
    }

    /* loaded from: classes2.dex */
    public class c implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i0.a.h0.o.h.c.a f42303a;

        /* renamed from: b  reason: collision with root package name */
        public String f42304b;

        /* renamed from: d.a.i0.a.h0.o.h.g.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0681a implements d.a.i0.a.h0.o.h.c.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f42305a;

            public C0681a(c cVar, File file) {
                this.f42305a = file;
            }

            @Override // d.a.i0.a.h0.o.h.c.b
            public void a() {
                d.a.i0.t.d.K(this.f42305a);
            }
        }

        public c(a aVar, d.a.i0.a.h0.o.h.c.a aVar2, String str) {
            this.f42303a = aVar2;
            this.f42304b = str;
        }

        @Override // d.a.i0.a.h0.o.h.g.d.a
        public void a(File file) {
            try {
                this.f42303a.a(this.f42304b, file, new C0681a(this, file));
            } catch (Exception e2) {
                if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                    Log.d("HybridIntercept", Log.getStackTraceString(e2));
                }
            }
        }

        @Override // d.a.i0.a.h0.o.h.g.d.a
        public void b(File file) {
            if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    public a(@NonNull Context context, d.a.i0.a.h0.o.h.c.a aVar) {
        this.f42296b = aVar;
        if (aVar == null) {
            g(context);
        }
    }

    public final WebResourceResponse b(d.a.i0.a.h0.o.h.g.b bVar) {
        if (bVar == null) {
            return null;
        }
        String str = bVar.f42310e;
        if (str != null && str.toLowerCase().contains("html")) {
            bVar.f42310e = SapiWebView.DATA_MIME_TYPE;
            bVar.f42309d = "UTF-8";
        }
        if (d.a.i0.a.v2.d.f()) {
            return new WebResourceResponse(bVar.f42310e, bVar.f42309d, bVar.f42306a, bVar.f42307b, bVar.f42308c, bVar.f42311f);
        }
        return new WebResourceResponse(bVar.f42310e, "UTF-8", bVar.f42311f);
    }

    public final void c(String str, int i2, String str2) {
        q0.q().post(new RunnableC0680a(str, i2, str2));
    }

    public String d() {
        return "";
    }

    public String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("intercept") && str.length() > 9) {
            str = str.substring(9);
        }
        if (d.a.i0.a.h0.o.h.e.a.f42292a) {
            Log.d("HybridIntercept", "real request url = " + str);
        }
        return str;
    }

    public Map<String, String> f(@NonNull g gVar) {
        return gVar.getRequestHeaders();
    }

    public final void g(Context context) {
        File b2 = d.a.i0.a.h0.o.h.d.a.a().b();
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            b2 = new File(b2, d2);
        }
        if (d.a.i0.a.h0.o.h.e.a.f42292a) {
            Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
        }
        d.a.i0.t.d.k(b2);
        this.f42296b = d.a.i0.a.c1.a.P().b(context, b2, d.a.i0.a.h0.o.h.d.a.a().g());
    }

    public WebResourceResponse h(@NonNull g gVar) {
        int i2;
        String d2 = gVar.d();
        if (!i(gVar)) {
            return gVar.b(d2, gVar.getRequestHeaders(), gVar.c());
        }
        String e2 = e(d2);
        InputStream inputStream = null;
        d.a.i0.a.h0.o.h.c.a aVar = this.f42296b;
        if (aVar != null && !aVar.isClosed()) {
            inputStream = this.f42296b.get(e2);
        }
        if (inputStream != null) {
            if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                Log.d("HybridIntercept", "adopt cached image, url = " + e2);
            }
            return new WebResourceResponse(gVar.getMimeType(), "UTF-8", inputStream);
        }
        d.a.i0.a.h0.o.h.g.b a2 = e.a(e2, f(gVar));
        if (a2 != null && (i2 = a2.f42306a) >= 400 && this.f42298d != null) {
            c(e2, i2, a2.f42307b);
        }
        WebResourceResponse b2 = b(a2);
        if (b2 != null && b2.getData() != null) {
            b2.setData(new f(b2.getData(), new d(new File(this.f42297c, d.a.i0.a.h0.o.h.d.a.a().d().a(e2)), new c(this, this.f42296b, e2))));
        }
        if (d.a.i0.a.h0.o.h.e.a.f42292a) {
            StringBuilder sb = new StringBuilder();
            sb.append("download image, response = ");
            sb.append(b2 != null);
            sb.append(" ; url = ");
            sb.append(e2);
            Log.e("HybridIntercept", sb.toString());
        }
        return b2;
    }

    public abstract boolean i(@NonNull g gVar);
}
