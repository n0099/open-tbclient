package d.a.h0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45995e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Download f45996a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f45997b;

    /* renamed from: c  reason: collision with root package name */
    public d f45998c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.f.f.f.b f45999d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f46000e;

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.f.f.a.l().j(this.f46000e);
            d.a.h0.f.f.a.l().i();
        }

        public b(String str) {
            this.f46000e = str;
        }
    }

    /* renamed from: d.a.h0.f.f.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0916c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f46001e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f46002f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.h0.f.f.f.a f46003g;

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.f.f.a.l().y(this.f46002f);
            d.a.h0.f.f.h.c.a(this.f46001e.getKeyByUser(), "installApp", null, null, new d.a.h0.f.f.h.a(this.f46002f));
            d.a.h0.f.f.a.l().n(this.f46001e.getUrl(), this.f46003g);
        }

        public RunnableC0916c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.h0.f.f.f.a aVar) {
            this.f46001e = download;
            this.f46002f = jSONObject;
            this.f46003g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46004a;

        /* renamed from: b  reason: collision with root package name */
        public String f46005b;

        public d() {
        }

        @Override // d.a.h0.f.f.f.a
        public void a(String str) {
            this.f46005b = str;
        }

        @Override // d.a.h0.f.f.f.b
        public void b(d.a.h0.f.f.g.b bVar) {
            if (c.f45995e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f46004a);
            }
            c.this.d(bVar);
            d.a.h0.f.f.c.b.f45950d.execute(new b(this.f46005b));
        }

        @Override // d.a.h0.f.f.f.a
        public void setPackageName(String str) {
            this.f46004a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f45996a = download;
        this.f45997b = jSONObject;
    }

    public void c(d.a.h0.f.f.f.b bVar) {
        this.f45999d = bVar;
        d.a.h0.f.f.c.b.f45950d.execute(new RunnableC0916c(this.f45996a, this.f45997b, this.f45998c));
    }

    public final void d(d.a.h0.f.f.g.b bVar) {
        d.a.h0.f.f.f.b bVar2 = this.f45999d;
        if (bVar2 != null) {
            bVar2.b(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.a.h0.f.f.h.c.a(this.f45996a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.a.h0.f.f.h.a(this.f45997b));
        }
        if (this.f45998c != null) {
            d.a.h0.f.f.a.l().u(this.f45996a.getKeyByUser(), this.f45998c);
            this.f45998c = null;
        }
    }
}
