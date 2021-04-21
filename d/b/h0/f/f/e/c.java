package d.b.h0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48535e = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Download f48536a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f48537b;

    /* renamed from: c  reason: collision with root package name */
    public d f48538c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.f.f.f.b f48539d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48540e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.f.f.a.l().j(this.f48540e);
            d.b.h0.f.f.a.l().i();
        }

        public b(String str) {
            this.f48540e = str;
        }
    }

    /* renamed from: d.b.h0.f.f.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0977c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f48541e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f48542f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.h0.f.f.f.a f48543g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.f.f.a.l().y(this.f48542f);
            d.b.h0.f.f.h.c.a(this.f48541e.getKeyByUser(), "installApp", null, null, new d.b.h0.f.f.h.a(this.f48542f));
            d.b.h0.f.f.a.l().n(this.f48541e.getUrl(), this.f48543g);
        }

        public RunnableC0977c(@NonNull Download download, JSONObject jSONObject, @NonNull d.b.h0.f.f.f.a aVar) {
            this.f48541e = download;
            this.f48542f = jSONObject;
            this.f48543g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.h0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48544a;

        /* renamed from: b  reason: collision with root package name */
        public String f48545b;

        public d() {
        }

        @Override // d.b.h0.f.f.f.b
        public void a(d.b.h0.f.f.g.b bVar) {
            if (c.f48535e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f48544a);
            }
            c.this.d(bVar);
            d.b.h0.f.f.c.b.f48490d.execute(new b(this.f48545b));
        }

        @Override // d.b.h0.f.f.f.a
        public void b(String str) {
            this.f48545b = str;
        }

        @Override // d.b.h0.f.f.f.a
        public void setPackageName(String str) {
            this.f48544a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f48536a = download;
        this.f48537b = jSONObject;
    }

    public void c(d.b.h0.f.f.f.b bVar) {
        this.f48539d = bVar;
        d.b.h0.f.f.c.b.f48490d.execute(new RunnableC0977c(this.f48536a, this.f48537b, this.f48538c));
    }

    public final void d(d.b.h0.f.f.g.b bVar) {
        d.b.h0.f.f.f.b bVar2 = this.f48539d;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.b.h0.f.f.h.c.a(this.f48536a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.b.h0.f.f.h.a(this.f48537b));
        }
        if (this.f48538c != null) {
            d.b.h0.f.f.a.l().u(this.f48536a.getKeyByUser(), this.f48538c);
            this.f48538c = null;
        }
    }
}
