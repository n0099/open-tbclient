package d.b.h0.a.e0.o;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.b.h0.a.e0.g;
import d.b.h0.a.e0.o.d;
import d.b.h0.a.k;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements d.b.h0.a.e0.o.a {
    public static final boolean j = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public d f44827e;

    /* renamed from: f  reason: collision with root package name */
    public String f44828f;

    /* renamed from: g  reason: collision with root package name */
    public String f44829g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44830h;
    public boolean i;

    /* loaded from: classes2.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44831a;

        public a(String str) {
            this.f44831a = str;
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
                if (file.getPath().startsWith(new File(this.f44831a).getCanonicalPath())) {
                    e.this.f44830h = true;
                } else if (!TextUtils.isEmpty(e.this.f44829g) && file.getCanonicalPath().startsWith(new File(e.this.f44829g).getCanonicalPath())) {
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
        public final /* synthetic */ g f44833a;

        public b(g gVar) {
            this.f44833a = gVar;
        }

        @Override // d.b.h0.a.e0.o.d.b
        public void a(d.b.h0.g.i.a aVar) {
            g gVar = this.f44833a;
            if (gVar != null) {
                gVar.a(e.this.f44828f);
            }
        }
    }

    public e(Context context) {
    }

    @Override // d.b.h0.a.e0.o.a
    public String c() {
        d dVar = this.f44827e;
        if (dVar != null) {
            return dVar.g();
        }
        if (j) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
            return "";
        }
        return "";
    }

    @Override // d.b.h0.a.e0.o.a
    public void d(Activity activity) {
        this.f44827e.d(activity);
    }

    @Override // d.b.h0.a.e0.o.a
    public void destroy() {
        d dVar = this.f44827e;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // d.b.h0.a.e0.o.a
    public void e(g gVar) {
        d dVar = this.f44827e;
        if (dVar != null) {
            dVar.k(new b(gVar));
        }
    }

    @Override // d.b.h0.a.e0.o.a
    public d.b.h0.a.e0.k.a g() {
        return this.f44827e.h();
    }

    @Override // d.b.h0.a.e0.o.a
    public void j(d.b.h0.a.e0.w.a aVar) {
        if (d.b.h0.a.w0.a.N().G(0) && aVar != null) {
            if (j) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.f45031b);
            }
            String str = aVar.f45031b;
            this.f44829g = str;
            this.f44827e.j(d.b.h0.a.e0.i.a.a("appjs", str));
        }
    }

    public int k() {
        return d.b.h0.a.e0.i.a.b(this.f44830h, this.i);
    }

    @Override // d.b.h0.a.e0.o.a
    public void loadUrl(String str) {
        if (this.f44827e == null) {
            String S = d.b.h0.a.e0.w.d.L().S();
            d dVar = new d(S, "runtime/index.js");
            this.f44827e = dVar;
            this.f44828f = str;
            dVar.i(new a(S));
        } else if (j) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }
}
