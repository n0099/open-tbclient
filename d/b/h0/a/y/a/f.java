package d.b.h0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.b.h0.a.i2.p;
import d.b.h0.a.t1.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.h0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y.b.e f47681e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f47682f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47683g;

        public a(d.b.h0.a.y.b.e eVar, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f47681e = eVar;
            this.f47682f = canvasView;
            this.f47683g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            int h2 = this.f47681e.h();
            if (h2 != 0) {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(h2, f.this.n(h2));
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                this.f47682f.c(this.f47681e.i(), this.f47681e.j());
                this.f47682f.postInvalidate();
            }
            String str = this.f47681e.i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f47683g.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/canvas/putImageData");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.e0.l.e A;
        d.b.h0.a.y.b.e o = o(unitedSchemeEntity);
        if (o == null) {
            d.b.h0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(o.f43835g) && (A = d.b.h0.a.z0.f.V().A()) != null) {
            o.f43835g = A.X2();
        }
        if (!TextUtils.isEmpty(o.f43835g) && !TextUtils.isEmpty(o.f43834f)) {
            CanvasView a2 = d.b.h0.a.a0.c.d.b.a.a(o);
            if (a2 == null) {
                d.b.h0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(o, a2, callbackHandler), "CanvasPutImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.h0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData slave id = " + o.f43835g + " ; canvas id = " + o.f43834f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public final String n(int i) {
        return i != 2001 ? i != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid";
    }

    public d.b.h0.a.y.b.e o(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.b.h0.a.y.b.e(str);
    }
}
