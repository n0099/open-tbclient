package d.a.i0.a.h0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import d.a.i0.a.k;
import d.a.i0.a.l0.g;
import d.a.i0.a.l0.j;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42034c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.a f42035a;

    /* renamed from: b  reason: collision with root package name */
    public j f42036b;

    /* loaded from: classes2.dex */
    public class a extends d.a.i0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f42037a;

        /* renamed from: b  reason: collision with root package name */
        public String f42038b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f42037a = str;
            this.f42038b = str2;
            if (c.f42034c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.i0.a.l0.n.b
        public String a() {
            return this.f42038b;
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            return super.b();
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public void c(d.a.i0.a.l0.a aVar) {
            if (c.this.f42036b != null) {
                c.this.f42036b.a(aVar);
            }
            aVar.y0();
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public void d(d.a.i0.a.l0.a aVar) {
            super.d(aVar);
        }

        @Override // d.a.i0.a.l0.n.b
        public String getInitBasePath() {
            return this.f42037a;
        }
    }

    public c(@NonNull String str, @NonNull String str2) {
        this.f42035a = d.a.i0.a.l0.f.c(c(), new a(str, str2), null);
        this.f42035a.addJavascriptInterface(new b(this.f42035a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final g c() {
        g.b bVar = new g.b();
        bVar.c(3);
        bVar.b(d.a.i0.a.h0.k.a.b());
        return bVar.a();
    }

    public d.a.i0.a.l0.a d() {
        return this.f42035a;
    }

    public void e() {
        d.a.i0.a.l0.a aVar = this.f42035a;
        if (aVar != null) {
            aVar.k0();
            this.f42035a = null;
        }
        this.f42036b = null;
    }

    public void f(j jVar) {
        this.f42036b = jVar;
    }
}
