package d.a.l0.g.c.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47041e = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public Download f47042a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f47043b;

    /* renamed from: c  reason: collision with root package name */
    public d f47044c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.g.c.f.b f47045d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47046e;

        /* renamed from: f  reason: collision with root package name */
        public String f47047f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().t(this.f47047f);
            d.a.l0.g.c.a.n().l(this.f47046e);
            d.a.l0.g.c.a.n().k();
        }

        public b(String str, String str2) {
            this.f47046e = str;
            this.f47047f = str2;
        }
    }

    /* renamed from: d.a.l0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1000c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f47048e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f47049f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.l0.g.c.f.a f47050g;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().G(this.f47049f);
            d.a.l0.g.c.i.c.a(this.f47048e.getKeyByUser(), "installApp", null, null, new d.a.l0.g.c.i.a(this.f47049f));
            d.a.l0.g.c.a.n().r(AppRuntime.getAppContext(), this.f47048e.getUrl(), this.f47048e.getKeyByUser(), this.f47050g);
        }

        public RunnableC1000c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.l0.g.c.f.a aVar) {
            this.f47048e = download;
            this.f47049f = jSONObject;
            this.f47050g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47051a;

        /* renamed from: b  reason: collision with root package name */
        public String f47052b;

        public d() {
        }

        @Override // d.a.l0.g.c.f.a
        public void a(String str) {
            this.f47052b = str;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            if (c.f47041e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f47051a);
            }
            c.this.d(bVar);
            d.a.l0.g.c.c.b.f46988d.execute(new b(this.f47052b, this.f47051a));
        }

        @Override // d.a.l0.g.c.f.a
        public void setPackageName(String str) {
            this.f47051a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f47042a = download;
        this.f47043b = jSONObject;
    }

    public void c(d.a.l0.g.c.f.b bVar) {
        this.f47045d = bVar;
        d.a.l0.g.c.c.b.f46988d.execute(new RunnableC1000c(this.f47042a, this.f47043b, this.f47044c));
    }

    public final void d(d.a.l0.g.c.g.b bVar) {
        d.a.l0.g.c.f.b bVar2 = this.f47045d;
        if (bVar2 != null) {
            bVar2.b(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.a.l0.g.c.i.c.a(this.f47042a.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.c()), new d.a.l0.g.c.i.a(this.f47043b));
        }
        if (this.f47044c != null) {
            d.a.l0.g.c.a.n().B(this.f47042a.getKeyByUser(), this.f47044c);
            this.f47044c = null;
        }
    }
}
