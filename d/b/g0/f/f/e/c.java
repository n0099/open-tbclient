package d.b.g0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47813e = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public Download f47814a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f47815b;

    /* renamed from: c  reason: collision with root package name */
    public d f47816c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.f.f.f.b f47817d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47818e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().j(this.f47818e);
            d.b.g0.f.f.a.l().i();
        }

        public b(String str) {
            this.f47818e = str;
        }
    }

    /* renamed from: d.b.g0.f.f.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0944c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f47819e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f47820f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.g0.f.f.f.a f47821g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().y(this.f47820f);
            d.b.g0.f.f.h.c.a(this.f47819e.getKeyByUser(), "installApp", null, null, new d.b.g0.f.f.h.a(this.f47820f));
            d.b.g0.f.f.a.l().n(this.f47819e.getUrl(), this.f47821g);
        }

        public RunnableC0944c(@NonNull Download download, JSONObject jSONObject, @NonNull d.b.g0.f.f.f.a aVar) {
            this.f47819e = download;
            this.f47820f = jSONObject;
            this.f47821g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47822a;

        /* renamed from: b  reason: collision with root package name */
        public String f47823b;

        public d() {
        }

        @Override // d.b.g0.f.f.f.b
        public void a(d.b.g0.f.f.g.b bVar) {
            if (c.f47813e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f47822a);
            }
            c.this.d(bVar);
            d.b.g0.f.f.c.b.f47768d.execute(new b(this.f47823b));
        }

        @Override // d.b.g0.f.f.f.a
        public void b(String str) {
            this.f47823b = str;
        }

        @Override // d.b.g0.f.f.f.a
        public void setPackageName(String str) {
            this.f47822a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f47814a = download;
        this.f47815b = jSONObject;
    }

    public void c(d.b.g0.f.f.f.b bVar) {
        this.f47817d = bVar;
        d.b.g0.f.f.c.b.f47768d.execute(new RunnableC0944c(this.f47814a, this.f47815b, this.f47816c));
    }

    public final void d(d.b.g0.f.f.g.b bVar) {
        d.b.g0.f.f.f.b bVar2 = this.f47817d;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.b.g0.f.f.h.c.a(this.f47814a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.b.g0.f.f.h.a(this.f47815b));
        }
        if (this.f47816c != null) {
            d.b.g0.f.f.a.l().u(this.f47814a.getKeyByUser(), this.f47816c);
            this.f47816c = null;
        }
    }
}
