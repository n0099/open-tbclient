package d.b.g0.g.h0;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.i2.k0;
import d.b.g0.a.z0.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f48158a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48159e;

        public a(d dVar, SwanAppActivity swanAppActivity) {
            this.f48159e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.i0.a.a(this.f48159e);
        }
    }

    public d(JsObject jsObject) {
        this.f48158a = b.d(d.b.g0.g.e.d.c.F(jsObject));
        d.b.g0.g.h0.a.a().f(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r1.equals("checkForUpdate") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c cVar) {
        if (this.f48158a == null || !JSEvent.isValid(cVar)) {
            return;
        }
        char c2 = 0;
        d.b.g0.a.c0.c.g("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", cVar.type, Boolean.valueOf(cVar.hasUpdate)));
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
            this.f48158a.a(cVar);
        } else if (c2 == 1) {
            this.f48158a.c();
        } else if (c2 != 2) {
        } else {
            this.f48158a.b();
        }
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.b.g0.a.c0.c.b("UpdateManagerApi", "applyUpdate activity is null");
            return false;
        } else if (activity.isDestroyed() || activity.getIntent() == null) {
            return false;
        } else {
            k0.X(new a(this, activity));
            return true;
        }
    }
}
