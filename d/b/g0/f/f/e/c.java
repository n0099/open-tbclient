package d.b.g0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47814e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Download f47815a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f47816b;

    /* renamed from: c  reason: collision with root package name */
    public d f47817c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.f.f.f.b f47818d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47819e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().j(this.f47819e);
            d.b.g0.f.f.a.l().i();
        }

        public b(String str) {
            this.f47819e = str;
        }
    }

    /* renamed from: d.b.g0.f.f.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0945c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f47820e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f47821f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.g0.f.f.f.a f47822g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().y(this.f47821f);
            d.b.g0.f.f.h.c.a(this.f47820e.getKeyByUser(), "installApp", null, null, new d.b.g0.f.f.h.a(this.f47821f));
            d.b.g0.f.f.a.l().n(this.f47820e.getUrl(), this.f47822g);
        }

        public RunnableC0945c(@NonNull Download download, JSONObject jSONObject, @NonNull d.b.g0.f.f.f.a aVar) {
            this.f47820e = download;
            this.f47821f = jSONObject;
            this.f47822g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47823a;

        /* renamed from: b  reason: collision with root package name */
        public String f47824b;

        public d() {
        }

        @Override // d.b.g0.f.f.f.b
        public void a(d.b.g0.f.f.g.b bVar) {
            if (c.f47814e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f47823a);
            }
            c.this.d(bVar);
            d.b.g0.f.f.c.b.f47769d.execute(new b(this.f47824b));
        }

        @Override // d.b.g0.f.f.f.a
        public void b(String str) {
            this.f47824b = str;
        }

        @Override // d.b.g0.f.f.f.a
        public void setPackageName(String str) {
            this.f47823a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f47815a = download;
        this.f47816b = jSONObject;
    }

    public void c(d.b.g0.f.f.f.b bVar) {
        this.f47818d = bVar;
        d.b.g0.f.f.c.b.f47769d.execute(new RunnableC0945c(this.f47815a, this.f47816b, this.f47817c));
    }

    public final void d(d.b.g0.f.f.g.b bVar) {
        d.b.g0.f.f.f.b bVar2 = this.f47818d;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.b.g0.f.f.h.c.a(this.f47815a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.b.g0.f.f.h.a(this.f47816b));
        }
        if (this.f47817c != null) {
            d.b.g0.f.f.a.l().u(this.f47815a.getKeyByUser(), this.f47817c);
            this.f47817c = null;
        }
    }
}
