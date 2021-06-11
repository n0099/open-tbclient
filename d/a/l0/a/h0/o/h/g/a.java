package d.a.l0.a.h0.o.h.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiWebView;
import com.baidu.webkit.sdk.WebResourceResponse;
import d.a.l0.a.h0.o.h.g.d;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class a implements d.a.l0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.h0.o.h.c.a f46146b;

    /* renamed from: c  reason: collision with root package name */
    public File f46147c = new File(d.a.l0.a.h0.o.h.d.a.a().b(), "image_temp");

    /* renamed from: d  reason: collision with root package name */
    public b f46148d;

    /* renamed from: d.a.l0.a.h0.o.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0747a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46150f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46151g;

        public RunnableC0747a(String str, int i2, String str2) {
            this.f46149e = str;
            this.f46150f = i2;
            this.f46151g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f46148d.onError(this.f46149e, this.f46150f, this.f46151g);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onError(String str, int i2, String str2);
    }

    /* loaded from: classes2.dex */
    public class c implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.h0.o.h.c.a f46153a;

        /* renamed from: b  reason: collision with root package name */
        public String f46154b;

        /* renamed from: d.a.l0.a.h0.o.h.g.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0748a implements d.a.l0.a.h0.o.h.c.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f46155a;

            public C0748a(c cVar, File file) {
                this.f46155a = file;
            }

            @Override // d.a.l0.a.h0.o.h.c.b
            public void a() {
                d.a.l0.t.d.K(this.f46155a);
            }
        }

        public c(a aVar, d.a.l0.a.h0.o.h.c.a aVar2, String str) {
            this.f46153a = aVar2;
            this.f46154b = str;
        }

        @Override // d.a.l0.a.h0.o.h.g.d.a
        public void a(File file) {
            try {
                this.f46153a.a(this.f46154b, file, new C0748a(this, file));
            } catch (Exception e2) {
                if (d.a.l0.a.h0.o.h.e.a.f46142a) {
                    Log.d("HybridIntercept", Log.getStackTraceString(e2));
                }
            }
        }

        @Override // d.a.l0.a.h0.o.h.g.d.a
        public void b(File file) {
            if (d.a.l0.a.h0.o.h.e.a.f46142a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    public a(@NonNull Context context, d.a.l0.a.h0.o.h.c.a aVar) {
        this.f46146b = aVar;
        if (aVar == null) {
            g(context);
        }
    }

    public final WebResourceResponse b(d.a.l0.a.h0.o.h.g.b bVar) {
        if (bVar == null) {
            return null;
        }
        String str = bVar.f46160e;
        if (str != null && str.toLowerCase().contains("html")) {
            bVar.f46160e = SapiWebView.DATA_MIME_TYPE;
            bVar.f46159d = "UTF-8";
        }
        if (d.a.l0.a.v2.d.f()) {
            return new WebResourceResponse(bVar.f46160e, bVar.f46159d, bVar.f46156a, bVar.f46157b, bVar.f46158c, bVar.f46161f);
        }
        return new WebResourceResponse(bVar.f46160e, "UTF-8", bVar.f46161f);
    }

    public final void c(String str, int i2, String str2) {
        q0.q().post(new RunnableC0747a(str, i2, str2));
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
        if (d.a.l0.a.h0.o.h.e.a.f46142a) {
            Log.d("HybridIntercept", "real request url = " + str);
        }
        return str;
    }

    public Map<String, String> f(@NonNull g gVar) {
        return gVar.getRequestHeaders();
    }

    public final void g(Context context) {
        File b2 = d.a.l0.a.h0.o.h.d.a.a().b();
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            b2 = new File(b2, d2);
        }
        if (d.a.l0.a.h0.o.h.e.a.f46142a) {
            Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
        }
        d.a.l0.t.d.k(b2);
        this.f46146b = d.a.l0.a.c1.a.P().b(context, b2, d.a.l0.a.h0.o.h.d.a.a().g());
    }

    public WebResourceResponse h(@NonNull g gVar) {
        int i2;
        String d2 = gVar.d();
        if (!i(gVar)) {
            return gVar.b(d2, gVar.getRequestHeaders(), gVar.c());
        }
        String e2 = e(d2);
        InputStream inputStream = null;
        d.a.l0.a.h0.o.h.c.a aVar = this.f46146b;
        if (aVar != null && !aVar.isClosed()) {
            inputStream = this.f46146b.get(e2);
        }
        if (inputStream != null) {
            if (d.a.l0.a.h0.o.h.e.a.f46142a) {
                Log.d("HybridIntercept", "adopt cached image, url = " + e2);
            }
            return new WebResourceResponse(gVar.getMimeType(), "UTF-8", inputStream);
        }
        d.a.l0.a.h0.o.h.g.b a2 = e.a(e2, f(gVar));
        if (a2 != null && (i2 = a2.f46156a) >= 400 && this.f46148d != null) {
            c(e2, i2, a2.f46157b);
        }
        WebResourceResponse b2 = b(a2);
        if (b2 != null && b2.getData() != null) {
            b2.setData(new f(b2.getData(), new d(new File(this.f46147c, d.a.l0.a.h0.o.h.d.a.a().d().a(e2)), new c(this, this.f46146b, e2))));
        }
        if (d.a.l0.a.h0.o.h.e.a.f46142a) {
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
