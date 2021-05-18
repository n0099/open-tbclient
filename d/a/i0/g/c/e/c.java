package d.a.i0.g.c.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46865e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public Download f46866a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f46867b;

    /* renamed from: c  reason: collision with root package name */
    public d f46868c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.g.c.f.b f46869d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f46870e;

        /* renamed from: f  reason: collision with root package name */
        public String f46871f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.g.c.a.n().t(this.f46871f);
            d.a.i0.g.c.a.n().l(this.f46870e);
            d.a.i0.g.c.a.n().k();
        }

        public b(String str, String str2) {
            this.f46870e = str;
            this.f46871f = str2;
        }
    }

    /* renamed from: d.a.i0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0989c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f46872e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f46873f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.i0.g.c.f.a f46874g;

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.g.c.a.n().G(this.f46873f);
            d.a.i0.g.c.i.c.a(this.f46872e.getKeyByUser(), "installApp", null, null, new d.a.i0.g.c.i.a(this.f46873f));
            d.a.i0.g.c.a.n().r(AppRuntime.getAppContext(), this.f46872e.getUrl(), this.f46872e.getKeyByUser(), this.f46874g);
        }

        public RunnableC0989c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.i0.g.c.f.a aVar) {
            this.f46872e = download;
            this.f46873f = jSONObject;
            this.f46874g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46875a;

        /* renamed from: b  reason: collision with root package name */
        public String f46876b;

        public d() {
        }

        @Override // d.a.i0.g.c.f.a
        public void a(String str) {
            this.f46876b = str;
        }

        @Override // d.a.i0.g.c.f.b
        public void b(d.a.i0.g.c.g.b bVar) {
            if (c.f46865e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f46875a);
            }
            c.this.d(bVar);
            d.a.i0.g.c.c.b.f46812d.execute(new b(this.f46876b, this.f46875a));
        }

        @Override // d.a.i0.g.c.f.a
        public void setPackageName(String str) {
            this.f46875a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f46866a = download;
        this.f46867b = jSONObject;
    }

    public void c(d.a.i0.g.c.f.b bVar) {
        this.f46869d = bVar;
        d.a.i0.g.c.c.b.f46812d.execute(new RunnableC0989c(this.f46866a, this.f46867b, this.f46868c));
    }

    public final void d(d.a.i0.g.c.g.b bVar) {
        d.a.i0.g.c.f.b bVar2 = this.f46869d;
        if (bVar2 != null) {
            bVar2.b(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.a.i0.g.c.i.c.a(this.f46866a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.a.i0.g.c.i.a(this.f46867b));
        }
        if (this.f46868c != null) {
            d.a.i0.g.c.a.n().B(this.f46866a.getKeyByUser(), this.f46868c);
            this.f46868c = null;
        }
    }
}
