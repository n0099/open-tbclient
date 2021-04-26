package d.a.h0.a.e0.o;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.h0.a.e0.g;
import d.a.h0.a.e0.o.d;
import d.a.h0.a.k;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements d.a.h0.a.e0.o.a {
    public static final boolean j = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public d f42126e;

    /* renamed from: f  reason: collision with root package name */
    public String f42127f;

    /* renamed from: g  reason: collision with root package name */
    public String f42128g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42129h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42130i;

    /* loaded from: classes2.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42131a;

        public a(String str) {
            this.f42131a = str;
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
                if (file.getPath().startsWith(new File(this.f42131a).getCanonicalPath())) {
                    e.this.f42129h = true;
                } else if (!TextUtils.isEmpty(e.this.f42128g) && file.getCanonicalPath().startsWith(new File(e.this.f42128g).getCanonicalPath())) {
                    e.this.f42130i = true;
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
        public final /* synthetic */ g f42133a;

        public b(g gVar) {
            this.f42133a = gVar;
        }

        @Override // d.a.h0.a.e0.o.d.b
        public void a(d.a.h0.g.i.a aVar) {
            g gVar = this.f42133a;
            if (gVar != null) {
                gVar.a(e.this.f42127f);
            }
        }
    }

    public e(Context context) {
    }

    @Override // d.a.h0.a.e0.o.a
    public void C(d.a.h0.a.e0.w.a aVar) {
        if (d.a.h0.a.w0.a.N().u(0) && aVar != null) {
            if (j) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.f42337b);
            }
            String str = aVar.f42337b;
            this.f42128g = str;
            this.f42126e.j(d.a.h0.a.e0.i.a.a("appjs", str));
        }
    }

    @Override // d.a.h0.a.e0.o.a
    public String c() {
        d dVar = this.f42126e;
        if (dVar != null) {
            return dVar.g();
        }
        if (j) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
            return "";
        }
        return "";
    }

    @Override // d.a.h0.a.e0.o.a
    public void d(g gVar) {
        d dVar = this.f42126e;
        if (dVar != null) {
            dVar.k(new b(gVar));
        }
    }

    @Override // d.a.h0.a.e0.o.a
    public void destroy() {
        d dVar = this.f42126e;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // d.a.h0.a.e0.o.a
    public void e(Activity activity) {
        this.f42126e.d(activity);
    }

    @Override // d.a.h0.a.e0.o.a
    public d.a.h0.a.e0.k.a g() {
        return this.f42126e.h();
    }

    public int j() {
        return d.a.h0.a.e0.i.a.b(this.f42129h, this.f42130i);
    }

    @Override // d.a.h0.a.e0.o.a
    public void loadUrl(String str) {
        if (this.f42126e == null) {
            String S = d.a.h0.a.e0.w.d.L().S();
            d dVar = new d(S, "runtime/index.js");
            this.f42126e = dVar;
            this.f42127f = str;
            dVar.i(new a(S));
        } else if (j) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }
}
