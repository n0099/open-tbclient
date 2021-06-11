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
    public static final boolean f50715e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public Download f50716a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50717b;

    /* renamed from: c  reason: collision with root package name */
    public d f50718c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.g.c.f.b f50719d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50720e;

        /* renamed from: f  reason: collision with root package name */
        public String f50721f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().t(this.f50721f);
            d.a.l0.g.c.a.n().l(this.f50720e);
            d.a.l0.g.c.a.n().k();
        }

        public b(String str, String str2) {
            this.f50720e = str;
            this.f50721f = str2;
        }
    }

    /* renamed from: d.a.l0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1056c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f50722e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f50723f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.l0.g.c.f.a f50724g;

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.g.c.a.n().G(this.f50723f);
            d.a.l0.g.c.i.c.a(this.f50722e.getKeyByUser(), "installApp", null, null, new d.a.l0.g.c.i.a(this.f50723f));
            d.a.l0.g.c.a.n().r(AppRuntime.getAppContext(), this.f50722e.getUrl(), this.f50722e.getKeyByUser(), this.f50724g);
        }

        public RunnableC1056c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.l0.g.c.f.a aVar) {
            this.f50722e = download;
            this.f50723f = jSONObject;
            this.f50724g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f50725a;

        /* renamed from: b  reason: collision with root package name */
        public String f50726b;

        public d() {
        }

        @Override // d.a.l0.g.c.f.a
        public void a(String str) {
            this.f50726b = str;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            if (c.f50715e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f50725a);
            }
            c.this.d(bVar);
            d.a.l0.g.c.c.b.f50662d.execute(new b(this.f50726b, this.f50725a));
        }

        @Override // d.a.l0.g.c.f.a
        public void setPackageName(String str) {
            this.f50725a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f50716a = download;
        this.f50717b = jSONObject;
    }

    public void c(d.a.l0.g.c.f.b bVar) {
        this.f50719d = bVar;
        d.a.l0.g.c.c.b.f50662d.execute(new RunnableC1056c(this.f50716a, this.f50717b, this.f50718c));
    }

    public final void d(d.a.l0.g.c.g.b bVar) {
        d.a.l0.g.c.f.b bVar2 = this.f50719d;
        if (bVar2 != null) {
            bVar2.b(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.a.l0.g.c.i.c.a(this.f50716a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.b.g0, String.valueOf(bVar.c()), new d.a.l0.g.c.i.a(this.f50717b));
        }
        if (this.f50718c != null) {
            d.a.l0.g.c.a.n().B(this.f50716a.getKeyByUser(), this.f50718c);
            this.f50718c = null;
        }
    }
}
