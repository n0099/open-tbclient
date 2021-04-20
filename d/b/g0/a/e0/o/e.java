package d.b.g0.a.e0.o;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.b.g0.a.e0.g;
import d.b.g0.a.e0.o.d;
import d.b.g0.a.k;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements d.b.g0.a.e0.o.a {
    public static final boolean j = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public d f44498e;

    /* renamed from: f  reason: collision with root package name */
    public String f44499f;

    /* renamed from: g  reason: collision with root package name */
    public String f44500g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44501h;
    public boolean i;

    /* loaded from: classes2.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44502a;

        public a(String str) {
            this.f44502a = str;
        }

        @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
        public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (e.j) {
                Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (file.getPath().startsWith(new File(this.f44502a).getCanonicalPath())) {
                    e.this.f44501h = true;
                } else if (!TextUtils.isEmpty(e.this.f44500g) && file.getCanonicalPath().startsWith(new File(e.this.f44500g).getCanonicalPath())) {
                    e.this.i = true;
                }
            } catch (IOException e2) {
                if (e.j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f44504a;

        public b(g gVar) {
            this.f44504a = gVar;
        }

        @Override // d.b.g0.a.e0.o.d.b
        public void a(d.b.g0.g.i.a aVar) {
            g gVar = this.f44504a;
            if (gVar != null) {
                gVar.a(e.this.f44499f);
            }
        }
    }

    public e(Context context) {
    }

    @Override // d.b.g0.a.e0.o.a
    public String c() {
        d dVar = this.f44498e;
        if (dVar != null) {
            return dVar.g();
        }
        if (j) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
            return "";
        }
        return "";
    }

    @Override // d.b.g0.a.e0.o.a
    public void d(Activity activity) {
        this.f44498e.d(activity);
    }

    @Override // d.b.g0.a.e0.o.a
    public void destroy() {
        d dVar = this.f44498e;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // d.b.g0.a.e0.o.a
    public void e(g gVar) {
        d dVar = this.f44498e;
        if (dVar != null) {
            dVar.k(new b(gVar));
        }
    }

    @Override // d.b.g0.a.e0.o.a
    public d.b.g0.a.e0.k.a g() {
        return this.f44498e.h();
    }

    @Override // d.b.g0.a.e0.o.a
    public void j(d.b.g0.a.e0.w.a aVar) {
        if (d.b.g0.a.w0.a.N().G(0) && aVar != null) {
            if (j) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.f44702b);
            }
            String str = aVar.f44702b;
            this.f44500g = str;
            this.f44498e.j(d.b.g0.a.e0.i.a.a("appjs", str));
        }
    }

    public int k() {
        return d.b.g0.a.e0.i.a.b(this.f44501h, this.i);
    }

    @Override // d.b.g0.a.e0.o.a
    public void loadUrl(String str) {
        if (this.f44498e == null) {
            String S = d.b.g0.a.e0.w.d.L().S();
            d dVar = new d(S, "runtime/index.js");
            this.f44498e = dVar;
            this.f44499f = str;
            dVar.i(new a(S));
        } else if (j) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }
}
