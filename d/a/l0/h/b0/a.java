package d.a.l0.h.b0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.a2.d;
import d.a.l0.a.a2.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
import d.a.l0.f.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47156b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public h f47157a;

    /* renamed from: d.a.l0.h.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1011a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47158e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47159f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f47160g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f47161h;

        public RunnableC1011a(SwanAppActivity swanAppActivity, String str, d.a.l0.a.y.b.a aVar, d.a.l0.a.f1.e.b bVar) {
            this.f47158e = swanAppActivity;
            this.f47159f = str;
            this.f47160g = aVar;
            this.f47161h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f(this.f47158e, this.f47159f, this.f47160g, this.f47161h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f47163e;

        public b(a aVar, d.a.l0.a.y.b.a aVar2) {
            this.f47163e = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.a.l0.h.m0.c.a(this.f47163e, true, new d.a.l0.h.b0.c(false));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f47164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f47165f;

        public c(d.a.l0.a.y.b.a aVar, d.a.l0.a.f1.e.b bVar) {
            this.f47164e = aVar;
            this.f47165f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.a.l0.h.m0.c.a(this.f47164e, true, new d.a.l0.h.b0.c(true));
            a.this.e(this.f47165f);
        }
    }

    public final void c(d.a.l0.a.y.b.a aVar, String str) {
        d.a.l0.h.d.c.b bVar = new d.a.l0.h.d.c.b();
        bVar.errMsg = str;
        d.a.l0.h.m0.c.a(aVar, false, bVar);
    }

    public void d(JsObject jsObject) {
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            G = new d.a.l0.a.y.b.a();
        }
        d.a.l0.a.y.b.a aVar = G;
        e r = d.g().r();
        if (!r.e()) {
            c(aVar, "reload failed, api internal error.");
            return;
        }
        SwanAppActivity x = r.x();
        b.a L = r.L();
        if (x == null) {
            c(aVar, "reload failed, api internal error.");
            return;
        }
        String C = aVar.C("content");
        if (TextUtils.isEmpty(C)) {
            C = x.getString(g.aiapps_game_reload_dialog_content);
        }
        q0.b0(new RunnableC1011a(x, C, aVar, L));
    }

    public final void e(@NonNull d.a.l0.a.f1.e.b bVar) {
        String H = bVar.H();
        String e1 = d.a.l0.a.f1.e.c.e1(bVar.H(), bVar.T(), bVar.G());
        Bundle bundle = new Bundle();
        bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
        bundle.putString("scheme", e1);
        bundle.putInt("target", SwanAppProcessInfo.current().index);
        if (f47156b) {
            Log.d("SwanGameReloadApi", "reload-appid:" + bVar.H());
        }
        d.a.l0.a.v1.c.e.a.E().K(bundle, d.a.l0.h.b0.b.class);
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull d.a.l0.a.y.b.a aVar, @NonNull d.a.l0.a.f1.e.b bVar) {
        h hVar = this.f47157a;
        if (hVar != null && hVar.isShowing()) {
            c(aVar, "reload failed, the reload dialog has been displayed.");
            return;
        }
        h.a aVar2 = new h.a(activity);
        aVar2.U(g.aiapps_game_reload_dialog_title);
        aVar2.x(str);
        aVar2.a();
        aVar2.n(new d.a.l0.a.w2.h.a());
        aVar2.m(false);
        aVar2.B(g.aiapps_cancel, new b(this, aVar));
        aVar2.O(g.aiapps_ok, new c(aVar, bVar));
        this.f47157a = aVar2.X();
    }
}
