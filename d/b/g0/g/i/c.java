package d.b.g0.g.i;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class c extends d.b.g0.g.i.a {

    /* loaded from: classes3.dex */
    public static class a {
        @V8JavascriptField
        public String basePath;
        @V8JavascriptField
        public Object config;
    }

    /* loaded from: classes3.dex */
    public static class b extends EventTargetImpl {

        /* renamed from: g  reason: collision with root package name */
        public static final boolean f48561g = k.f45443a;

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.g.i.b f48562e;
        @V8JavascriptField
        public a env;

        /* renamed from: f  reason: collision with root package name */
        public d.b.g0.g.l.e f48563f;

        public b(d.b.g0.g.i.b bVar, String str) {
            super(bVar);
            this.f48562e = bVar;
            a aVar = new a();
            this.env = aVar;
            aVar.basePath = str;
        }

        @JavascriptInterface
        public String getAPIs(int i) {
            return f48561g ? d.b.g0.a.m1.a.a.n() ? d.b.g0.a.i2.i.d(i, true) : "" : !d.b.g0.a.i2.i.h() ? "" : d.b.g0.a.i2.i.d(i, true);
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return d.b.g0.a.x0.b.b.a(this.f48562e);
        }

        @JavascriptInterface
        public d.b.g0.g.l.e getFileSystemManager() {
            if (this.f48563f == null) {
                this.f48563f = new d.b.g0.g.l.e((d.b.g0.g.i.a) this.f48562e);
            }
            return this.f48563f;
        }
    }

    public c(@NonNull String str, @NonNull d.b.g0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // d.b.g0.g.i.a
    @NonNull
    public EventTarget H() {
        b bVar = new b(this, this.f48553f.getInitBasePath());
        bVar.env.config = d.b.g0.a.b2.c.a.b();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }
}
