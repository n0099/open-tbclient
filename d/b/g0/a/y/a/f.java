package d.b.g0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.b.g0.a.i2.p;
import d.b.g0.a.t1.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.g0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y.b.e f46960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f46961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46962g;

        public a(d.b.g0.a.y.b.e eVar, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f46960e = eVar;
            this.f46961f = canvasView;
            this.f46962g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            int h2 = this.f46960e.h();
            if (h2 != 0) {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(h2, f.this.n(h2));
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                this.f46961f.c(this.f46960e.i(), this.f46960e.j());
                this.f46961f.postInvalidate();
            }
            String str = this.f46960e.i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f46962g.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/canvas/putImageData");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.e0.l.e A;
        d.b.g0.a.y.b.e o = o(unitedSchemeEntity);
        if (o == null) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(o.f43114g) && (A = d.b.g0.a.z0.f.V().A()) != null) {
            o.f43114g = A.X2();
        }
        if (!TextUtils.isEmpty(o.f43114g) && !TextUtils.isEmpty(o.f43113f)) {
            CanvasView a2 = d.b.g0.a.a0.c.d.b.a.a(o);
            if (a2 == null) {
                d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(o, a2, callbackHandler), "CanvasPutImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData slave id = " + o.f43114g + " ; canvas id = " + o.f43113f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public final String n(int i) {
        return i != 2001 ? i != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid";
    }

    public d.b.g0.a.y.b.e o(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.b.g0.a.y.b.e(str);
    }
}
