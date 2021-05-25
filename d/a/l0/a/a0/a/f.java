package d.a.l0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.l0.a.v2.q;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.l0.a.a0.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a0.b.e f40576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f40577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40578g;

        public a(d.a.l0.a.a0.b.e eVar, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f40576e = eVar;
            this.f40577f = canvasView;
            this.f40578g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            int h2 = this.f40576e.h();
            if (h2 != 0) {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(h2, f.this.n(h2));
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                this.f40577f.c(this.f40576e.i(), this.f40576e.j());
                this.f40577f.postInvalidate();
            }
            String str = this.f40576e.f40848i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f40578g.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
        }
    }

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/putImageData");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.h0.g.f J;
        d.a.l0.a.a0.b.e o = o(unitedSchemeEntity);
        if (o == null) {
            d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(o.f40846g) && (J = d.a.l0.a.g1.f.V().J()) != null) {
            o.f40846g = J.g3();
        }
        if (!TextUtils.isEmpty(o.f40846g) && !TextUtils.isEmpty(o.f40845f)) {
            CanvasView a2 = d.a.l0.a.c0.c.d.b.a.a(o);
            if (a2 == null) {
                d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            q.j(new a(o, a2, callbackHandler), "CanvasPutImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasPutImageData slave id = " + o.f40846g + " ; canvas id = " + o.f40845f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public final String n(int i2) {
        return i2 != 2001 ? i2 != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid";
    }

    public d.a.l0.a.a0.b.e o(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.l0.a.a0.b.e(str);
    }
}
