package d.a.m0.g.c.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50823e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public Download f50824a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50825b;

    /* renamed from: c  reason: collision with root package name */
    public d f50826c = new d();

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.g.c.f.b f50827d;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50828e;

        /* renamed from: f  reason: collision with root package name */
        public String f50829f;

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.g.c.a.n().t(this.f50829f);
            d.a.m0.g.c.a.n().l(this.f50828e);
            d.a.m0.g.c.a.n().k();
        }

        public b(String str, String str2) {
            this.f50828e = str;
            this.f50829f = str2;
        }
    }

    /* renamed from: d.a.m0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1059c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Download f50830e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f50831f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.m0.g.c.f.a f50832g;

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.g.c.a.n().G(this.f50831f);
            d.a.m0.g.c.i.c.a(this.f50830e.getKeyByUser(), "installApp", null, null, new d.a.m0.g.c.i.a(this.f50831f));
            d.a.m0.g.c.a.n().r(AppRuntime.getAppContext(), this.f50830e.getUrl(), this.f50830e.getKeyByUser(), this.f50832g);
        }

        public RunnableC1059c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.m0.g.c.f.a aVar) {
            this.f50830e = download;
            this.f50831f = jSONObject;
            this.f50832g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.g.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public String f50833a;

        /* renamed from: b  reason: collision with root package name */
        public String f50834b;

        public d() {
        }

        @Override // d.a.m0.g.c.f.a
        public void a(String str) {
            this.f50834b = str;
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
            if (c.f50823e) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.f50833a);
            }
            c.this.d(bVar);
            d.a.m0.g.c.c.b.f50770d.execute(new b(this.f50834b, this.f50833a));
        }

        @Override // d.a.m0.g.c.f.a
        public void setPackageName(String str) {
            this.f50833a = str;
        }
    }

    public c(Download download, JSONObject jSONObject) {
        this.f50824a = download;
        this.f50825b = jSONObject;
    }

    public void c(d.a.m0.g.c.f.b bVar) {
        this.f50827d = bVar;
        d.a.m0.g.c.c.b.f50770d.execute(new RunnableC1059c(this.f50824a, this.f50825b, this.f50826c));
    }

    public final void d(d.a.m0.g.c.g.b bVar) {
        d.a.m0.g.c.f.b bVar2 = this.f50827d;
        if (bVar2 != null) {
            bVar2.b(bVar);
        }
        if (bVar != null && !bVar.d()) {
            d.a.m0.g.c.i.c.a(this.f50824a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.m0.g.c.i.a(this.f50825b));
        }
        if (this.f50826c != null) {
            d.a.m0.g.c.a.n().B(this.f50824a.getKeyByUser(), this.f50826c);
            this.f50826c = null;
        }
    }
}
