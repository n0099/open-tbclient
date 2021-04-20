package d.b.g0.f.f.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48206e = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public Download f48207a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f48208b;

    /* renamed from: c  reason: collision with root package name */
    public d f48209c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.f.f.f.b f48210d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48211e;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().j(this.f48211e);
            d.b.g0.f.f.a.l().i();
        }

        public b(String str) {
            this.f48211e = str;
        }
    }

    /* renamed from: d.b.g0.f.f.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0957c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f48212e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f48213f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.g0.f.f.f.a f48214g;

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.f.f.a.l().y(this.f48213f);
            d.b.g0.f.f.h.c.a(this.f48212e.getKeyByUser(), "installApp", null, null, new d.b.g0.f.f.h.a(this.f48213f));
            d.b.g0.f.f.a.l().n(this.f48212e.getUrl(), this.f48214g);
        }

        public RunnableC0957c(@NonNull Download download, JSONObject jSONObject, @NonNull d.b.g0.f.f.f.a aVar) {
            this.f48212e = download;
            this.f48213f = jSONObject;
            this.f48214g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.f.f.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48215a;

        /* renamed from: b  reason: collision with root package name */
        public String f48216b;

        public d() {
        }

        @Override // d.b.g0.f.f.f.b
        public void a(d.b.g0.f.f.g.b bVar) {
            if (c.f48206e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f48215a);
            }
            c.this.d(bVar);
            d.b.g0.f.f.c.b.f48161d.execute(new b(this.f48216b));
        }

        @Override // d.b.g0.f.f.f.a
        public void b(String str) {
            this.f48216b = str;
        }

        @Override // d.b.g0.f.f.f.a
        public void setPackageName(String str) {
            this.f48215a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f48207a = download;
        this.f48208b = jSONObject;
    }

    public void c(d.b.g0.f.f.f.b bVar) {
        this.f48210d = bVar;
        d.b.g0.f.f.c.b.f48161d.execute(new RunnableC0957c(this.f48207a, this.f48208b, this.f48209c));
    }

    public final void d(d.b.g0.f.f.g.b bVar) {
        d.b.g0.f.f.f.b bVar2 = this.f48210d;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.b.g0.f.f.h.c.a(this.f48207a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.b.g0.f.f.h.a(this.f48208b));
        }
        if (this.f48209c != null) {
            d.b.g0.f.f.a.l().u(this.f48207a.getKeyByUser(), this.f48209c);
            this.f48209c = null;
        }
    }
}
