package d.b.g0.g.y;

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
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.r1.d;
import d.b.g0.a.r1.e;
import d.b.g0.a.y0.e.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49069b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public g f49070a;

    /* renamed from: d.b.g0.g.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1015a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f49071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49073g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f49074h;

        public RunnableC1015a(SwanAppActivity swanAppActivity, String str, d.b.g0.g.e.d.c cVar, d.b.g0.a.y0.e.b bVar) {
            this.f49071e = swanAppActivity;
            this.f49072f = str;
            this.f49073g = cVar;
            this.f49074h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f(this.f49071e, this.f49072f, this.f49073g, this.f49074h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49075e;

        public b(a aVar, d.b.g0.g.e.d.c cVar) {
            this.f49075e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            d.b.g0.g.i0.b.a(this.f49075e, true, new d.b.g0.g.y.c(false));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f49077f;

        public c(d.b.g0.g.e.d.c cVar, d.b.g0.a.y0.e.b bVar) {
            this.f49076e = cVar;
            this.f49077f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            d.b.g0.g.i0.b.a(this.f49076e, true, new d.b.g0.g.y.c(true));
            a.this.e(this.f49077f);
        }
    }

    public final void c(d.b.g0.g.e.d.c cVar, String str) {
        d.b.g0.g.e.d.b bVar = new d.b.g0.g.e.d.b();
        bVar.errMsg = str;
        d.b.g0.g.i0.b.a(cVar, false, bVar);
    }

    public void d(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.b.g0.g.e.d.c();
        }
        d.b.g0.g.e.d.c cVar = F;
        e s = d.e().s();
        if (!s.d()) {
            c(cVar, "reload failed, api internal error.");
            return;
        }
        SwanAppActivity n = s.n();
        b.a J = s.J();
        if (n == null) {
            c(cVar, "reload failed, api internal error.");
            return;
        }
        String B = cVar.B("content");
        if (TextUtils.isEmpty(B)) {
            B = n.getString(h.swangame_reload_dialog_content);
        }
        k0.X(new RunnableC1015a(n, B, cVar, J));
    }

    public final void e(@NonNull d.b.g0.a.y0.e.b bVar) {
        String G = bVar.G();
        String X0 = d.b.g0.a.y0.e.c.X0(bVar.G(), bVar.S(), bVar.F());
        Bundle bundle = new Bundle();
        bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, G);
        bundle.putString("scheme", X0);
        bundle.putInt("target", SwanAppProcessInfo.current().index);
        if (f49069b) {
            Log.d("SwanGameReloadApi", "reload-appid:" + bVar.G());
        }
        d.b.g0.a.n1.c.e.a.C().I(bundle, d.b.g0.g.y.b.class);
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull d.b.g0.g.e.d.c cVar, @NonNull d.b.g0.a.y0.e.b bVar) {
        g gVar = this.f49070a;
        if (gVar != null && gVar.isShowing()) {
            c(cVar, "reload failed, the reload dialog has been displayed.");
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.U(h.swangame_reload_dialog_title);
        aVar.y(str);
        aVar.a();
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(false);
        aVar.C(h.aiapps_cancel, new b(this, cVar));
        aVar.O(h.aiapps_ok, new c(cVar, bVar));
        this.f49070a = aVar.X();
    }
}
