package d.b.h0.a.e0.o;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.b.h0.a.k;
import d.b.h0.g.i.g;
import d.b.h0.g.i.h;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44820d = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.a f44821a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.g.e.a f44822b = new d.b.h0.g.e.a();

    /* renamed from: c  reason: collision with root package name */
    public b f44823c;

    /* loaded from: classes2.dex */
    public class a extends d.b.h0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f44824a;

        /* renamed from: b  reason: collision with root package name */
        public String f44825b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f44824a = str;
            this.f44825b = str2;
            if (d.f44820d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.b.h0.g.i.n.b
        public String a() {
            return this.f44825b;
        }

        @Override // d.b.h0.g.i.n.a, d.b.h0.g.i.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.b.h0.a.w0.a.N().G(0)) {
                if (d.f44820d) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.f44824a);
                }
                return d.b.h0.a.e0.i.a.a("appframe", this.f44824a);
            }
            return null;
        }

        @Override // d.b.h0.g.i.n.a, d.b.h0.g.i.n.b
        public void c(d.b.h0.g.i.a aVar) {
            if (d.this.f44823c != null) {
                d.this.f44823c.a(aVar);
            }
            aVar.u0();
        }

        @Override // d.b.h0.g.i.n.a, d.b.h0.g.i.n.b
        public void d(d.b.h0.g.i.a aVar) {
            d.this.f44822b.b(aVar, d.b.h0.a.w0.a.c());
        }

        @Override // d.b.h0.g.i.n.b
        public String getInitBasePath() {
            return this.f44824a;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.b.h0.g.i.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.f44821a = g.c(e(), new a(str, str2), null);
    }

    public void d(Activity activity) {
        this.f44822b.a(activity);
    }

    public final h e() {
        h.b bVar = new h.b();
        bVar.c(1);
        bVar.b(d.b.h0.a.e0.o.f.a.b());
        return bVar.a();
    }

    public void f() {
        this.f44821a.h0();
    }

    public String g() {
        return this.f44821a.f48883g;
    }

    public d.b.h0.g.i.a h() {
        return this.f44821a;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f44821a.w0(jSCacheCallback);
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f44821a.x0(codeCacheSetting);
    }

    public void k(b bVar) {
        this.f44823c = bVar;
    }
}
