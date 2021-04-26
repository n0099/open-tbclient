package d.a.h0.g.i;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class c extends d.a.h0.g.i.a {

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
        public static final boolean f46364g = k.f43101a;

        /* renamed from: e  reason: collision with root package name */
        public d.a.h0.g.i.b f46365e;
        @V8JavascriptField
        public a env;

        /* renamed from: f  reason: collision with root package name */
        public d.a.h0.g.l.e f46366f;

        public b(d.a.h0.g.i.b bVar, String str) {
            super(bVar);
            this.f46365e = bVar;
            a aVar = new a();
            this.env = aVar;
            aVar.basePath = str;
        }

        @JavascriptInterface
        public String getAPIs(int i2) {
            return f46364g ? d.a.h0.a.m1.a.a.n() ? d.a.h0.a.i2.i.d(i2, true) : "" : !d.a.h0.a.i2.i.h() ? "" : d.a.h0.a.i2.i.d(i2, true);
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return d.a.h0.a.x0.b.b.a(this.f46365e);
        }

        @JavascriptInterface
        public d.a.h0.g.l.e getFileSystemManager() {
            if (this.f46366f == null) {
                this.f46366f = new d.a.h0.g.l.e((d.a.h0.g.i.a) this.f46365e);
            }
            return this.f46366f;
        }
    }

    public c(@NonNull String str, @NonNull d.a.h0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // d.a.h0.g.i.a
    @NonNull
    public EventTarget A() {
        b bVar = new b(this, this.f46355f.getInitBasePath());
        bVar.env.config = d.a.h0.a.b2.c.a.b();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }
}
