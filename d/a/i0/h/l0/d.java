package d.a.i0.h.l0;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.g1.f;
import d.a.i0.a.v2.e0;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f47272a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47273e;

        public a(d dVar, SwanAppActivity swanAppActivity) {
            this.f47273e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.a(this.f47273e);
        }
    }

    public d(JsObject jsObject) {
        this.f47272a = b.d(d.a.i0.a.y.b.a.G(jsObject));
        d.a.i0.h.l0.a.a().f(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r1.equals("checkForUpdate") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c cVar) {
        if (this.f47272a == null || !JSEvent.isValid(cVar)) {
            return;
        }
        char c2 = 0;
        d.a.i0.a.e0.d.g("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", cVar.type, Boolean.valueOf(cVar.hasUpdate)));
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
            this.f47272a.a(cVar);
        } else if (c2 == 1) {
            this.f47272a.c();
        } else if (c2 != 2) {
        } else {
            this.f47272a.b();
        }
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.a.i0.a.e0.d.b("UpdateManagerApi", "applyUpdate activity is null");
            return false;
        } else if (activity.isDestroyed() || activity.getIntent() == null) {
            return false;
        } else {
            q0.b0(new a(this, activity));
            return true;
        }
    }
}
