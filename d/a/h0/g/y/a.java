package d.a.h0.g.y;

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
import d.a.h0.a.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46896b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public g f46897a;

    /* renamed from: d.a.h0.g.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0974a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46899f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46900g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f46901h;

        public RunnableC0974a(SwanAppActivity swanAppActivity, String str, d.a.h0.g.e.d.c cVar, d.a.h0.a.y0.e.b bVar) {
            this.f46898e = swanAppActivity;
            this.f46899f = str;
            this.f46900g = cVar;
            this.f46901h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f(this.f46898e, this.f46899f, this.f46900g, this.f46901h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46903e;

        public b(a aVar, d.a.h0.g.e.d.c cVar) {
            this.f46903e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.a.h0.g.i0.b.a(this.f46903e, true, new d.a.h0.g.y.c(false));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f46905f;

        public c(d.a.h0.g.e.d.c cVar, d.a.h0.a.y0.e.b bVar) {
            this.f46904e = cVar;
            this.f46905f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.a.h0.g.i0.b.a(this.f46904e, true, new d.a.h0.g.y.c(true));
            a.this.e(this.f46905f);
        }
    }

    public final void c(d.a.h0.g.e.d.c cVar, String str) {
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        bVar.errMsg = str;
        d.a.h0.g.i0.b.a(cVar, false, bVar);
    }

    public void d(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.a.h0.g.e.d.c();
        }
        d.a.h0.g.e.d.c cVar = F;
        e p = d.e().p();
        if (!p.d()) {
            c(cVar, "reload failed, api internal error.");
            return;
        }
        SwanAppActivity v = p.v();
        b.a J = p.J();
        if (v == null) {
            c(cVar, "reload failed, api internal error.");
            return;
        }
        String B = cVar.B("content");
        if (TextUtils.isEmpty(B)) {
            B = v.getString(h.swangame_reload_dialog_content);
        }
        k0.X(new RunnableC0974a(v, B, cVar, J));
    }

    public final void e(@NonNull d.a.h0.a.y0.e.b bVar) {
        String G = bVar.G();
        String X0 = d.a.h0.a.y0.e.c.X0(bVar.G(), bVar.S(), bVar.F());
        Bundle bundle = new Bundle();
        bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, G);
        bundle.putString("scheme", X0);
        bundle.putInt("target", SwanAppProcessInfo.current().index);
        if (f46896b) {
            Log.d("SwanGameReloadApi", "reload-appid:" + bVar.G());
        }
        d.a.h0.a.n1.c.e.a.C().I(bundle, d.a.h0.g.y.b.class);
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull d.a.h0.g.e.d.c cVar, @NonNull d.a.h0.a.y0.e.b bVar) {
        g gVar = this.f46897a;
        if (gVar != null && gVar.isShowing()) {
            c(cVar, "reload failed, the reload dialog has been displayed.");
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.U(h.swangame_reload_dialog_title);
        aVar.y(str);
        aVar.a();
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(false);
        aVar.C(h.aiapps_cancel, new b(this, cVar));
        aVar.O(h.aiapps_ok, new c(cVar, bVar));
        this.f46897a = aVar.X();
    }
}
