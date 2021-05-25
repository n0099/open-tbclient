package d.a.l0.a.h0.l;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.l0.j;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements d.a.l0.a.h0.l.a {
    public static final boolean j = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public d f42223e;

    /* renamed from: f  reason: collision with root package name */
    public String f42224f;

    /* renamed from: g  reason: collision with root package name */
    public String f42225g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42226h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42227i;

    /* loaded from: classes2.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42228a;

        public a(String str) {
            this.f42228a = str;
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
                if (file.getPath().startsWith(new File(this.f42228a).getCanonicalPath())) {
                    e.this.f42226h = true;
                } else if (!TextUtils.isEmpty(e.this.f42225g) && file.getCanonicalPath().startsWith(new File(e.this.f42225g).getCanonicalPath())) {
                    e.this.f42227i = true;
                }
            } catch (IOException e2) {
                if (e.j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.b f42230a;

        public b(d.a.l0.a.h0.b bVar) {
            this.f42230a = bVar;
        }

        @Override // d.a.l0.a.l0.j
        public void a(d.a.l0.a.l0.a aVar) {
            d.a.l0.a.h0.b bVar = this.f42230a;
            if (bVar != null) {
                bVar.a(e.this.f42224f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42232e;

        public c(e eVar, int i2) {
            this.f42232e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(this.f42232e);
            } catch (Throwable th) {
                d.a.l0.a.e0.d.b("V8MasterAdapter", th.getMessage());
            }
        }
    }

    public e(Context context) {
    }

    @Override // d.a.l0.a.h0.l.a
    public void D(d.a.l0.a.h0.u.a aVar) {
        if (aVar == null) {
            return;
        }
        if (j) {
            Log.d("V8MasterAdapter", "pathList item: " + aVar.f42602b);
        }
        String str = aVar.f42602b;
        this.f42225g = str;
        this.f42223e.j(d.a.l0.a.h0.d.a.a("appjs", str));
    }

    @Override // d.a.l0.a.h0.l.a
    public String b() {
        d dVar = this.f42223e;
        if (dVar != null) {
            return dVar.g();
        }
        if (j) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
            return "";
        }
        return "";
    }

    @Override // d.a.l0.a.h0.l.a
    public void c(d.a.l0.a.h0.b bVar) {
        d dVar = this.f42223e;
        if (dVar != null) {
            dVar.k(new b(bVar));
        }
    }

    @Override // d.a.l0.a.h0.l.a
    public void destroy() {
        d dVar = this.f42223e;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // d.a.l0.a.h0.l.a
    public void e(Activity activity) {
        d dVar = this.f42223e;
        if (dVar != null) {
            dVar.d(activity);
        }
    }

    @Override // d.a.l0.a.h0.l.a
    public d.a.l0.a.h0.f.a g() {
        return this.f42223e.h();
    }

    public d j(String str) {
        return new d(str, "runtime/index.js");
    }

    public int k() {
        return d.a.l0.a.h0.d.a.b(this.f42226h, this.f42227i);
    }

    @Override // d.a.l0.a.h0.l.a
    public void loadUrl(String str) {
        if (this.f42223e == null) {
            String U = g.N().U();
            d j2 = j(U);
            this.f42223e = j2;
            this.f42224f = str;
            j2.i(new a(U));
        } else if (j) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    @Override // d.a.l0.a.h0.l.a
    @AnyThread
    public void r(int i2) {
        d.a.l0.a.l0.a h2;
        d dVar = this.f42223e;
        if (dVar == null || (h2 = dVar.h()) == null) {
            return;
        }
        h2.runOnJSThread(new c(this, i2));
    }
}
