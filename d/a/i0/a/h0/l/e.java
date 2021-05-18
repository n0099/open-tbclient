package d.a.i0.a.h0.l;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import d.a.i0.a.l0.j;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements d.a.i0.a.h0.l.a {
    public static final boolean j = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public d f42049e;

    /* renamed from: f  reason: collision with root package name */
    public String f42050f;

    /* renamed from: g  reason: collision with root package name */
    public String f42051g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42052h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42053i;

    /* loaded from: classes2.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42054a;

        public a(String str) {
            this.f42054a = str;
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
                if (file.getPath().startsWith(new File(this.f42054a).getCanonicalPath())) {
                    e.this.f42052h = true;
                } else if (!TextUtils.isEmpty(e.this.f42051g) && file.getCanonicalPath().startsWith(new File(e.this.f42051g).getCanonicalPath())) {
                    e.this.f42053i = true;
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
        public final /* synthetic */ d.a.i0.a.h0.b f42056a;

        public b(d.a.i0.a.h0.b bVar) {
            this.f42056a = bVar;
        }

        @Override // d.a.i0.a.l0.j
        public void a(d.a.i0.a.l0.a aVar) {
            d.a.i0.a.h0.b bVar = this.f42056a;
            if (bVar != null) {
                bVar.a(e.this.f42050f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42058e;

        public c(e eVar, int i2) {
            this.f42058e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(this.f42058e);
            } catch (Throwable th) {
                d.a.i0.a.e0.d.b("V8MasterAdapter", th.getMessage());
            }
        }
    }

    public e(Context context) {
    }

    @Override // d.a.i0.a.h0.l.a
    public void D(d.a.i0.a.h0.u.a aVar) {
        if (aVar == null) {
            return;
        }
        if (j) {
            Log.d("V8MasterAdapter", "pathList item: " + aVar.f42428b);
        }
        String str = aVar.f42428b;
        this.f42051g = str;
        this.f42049e.j(d.a.i0.a.h0.d.a.a("appjs", str));
    }

    @Override // d.a.i0.a.h0.l.a
    public String b() {
        d dVar = this.f42049e;
        if (dVar != null) {
            return dVar.g();
        }
        if (j) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
            return "";
        }
        return "";
    }

    @Override // d.a.i0.a.h0.l.a
    public void c(d.a.i0.a.h0.b bVar) {
        d dVar = this.f42049e;
        if (dVar != null) {
            dVar.k(new b(bVar));
        }
    }

    @Override // d.a.i0.a.h0.l.a
    public void destroy() {
        d dVar = this.f42049e;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // d.a.i0.a.h0.l.a
    public void e(Activity activity) {
        d dVar = this.f42049e;
        if (dVar != null) {
            dVar.d(activity);
        }
    }

    @Override // d.a.i0.a.h0.l.a
    public d.a.i0.a.h0.f.a g() {
        return this.f42049e.h();
    }

    public d j(String str) {
        return new d(str, "runtime/index.js");
    }

    public int k() {
        return d.a.i0.a.h0.d.a.b(this.f42052h, this.f42053i);
    }

    @Override // d.a.i0.a.h0.l.a
    public void loadUrl(String str) {
        if (this.f42049e == null) {
            String U = g.N().U();
            d j2 = j(U);
            this.f42049e = j2;
            this.f42050f = str;
            j2.i(new a(U));
        } else if (j) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    @Override // d.a.i0.a.h0.l.a
    @AnyThread
    public void r(int i2) {
        d.a.i0.a.l0.a h2;
        d dVar = this.f42049e;
        if (dVar == null || (h2 = dVar.h()) == null) {
            return;
        }
        h2.runOnJSThread(new c(this, i2));
    }
}
