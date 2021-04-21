package d.b.h0.g.h0;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.i2.k0;
import d.b.h0.a.z0.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f48879a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48880e;

        public a(d dVar, SwanAppActivity swanAppActivity) {
            this.f48880e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.i0.a.a(this.f48880e);
        }
    }

    public d(JsObject jsObject) {
        this.f48879a = b.d(d.b.h0.g.e.d.c.F(jsObject));
        d.b.h0.g.h0.a.a().f(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r1.equals("checkForUpdate") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c cVar) {
        if (this.f48879a == null || !JSEvent.isValid(cVar)) {
            return;
        }
        char c2 = 0;
        d.b.h0.a.c0.c.g("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", cVar.type, Boolean.valueOf(cVar.hasUpdate)));
        String str = cVar.type;
        int hashCode = str.hashCode();
        if (hashCode == -1330233754) {
            if (str.equals("updateFailed")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != -1317168438) {
            if (hashCode == -585906598 && str.equals("updateReady")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            this.f48879a.a(cVar);
        } else if (c2 == 1) {
            this.f48879a.c();
        } else if (c2 != 2) {
        } else {
            this.f48879a.b();
        }
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.b.h0.a.c0.c.b("UpdateManagerApi", "applyUpdate activity is null");
            return false;
        } else if (activity.isDestroyed() || activity.getIntent() == null) {
            return false;
        } else {
            k0.X(new a(this, activity));
            return true;
        }
    }
}
