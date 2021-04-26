package d.a.h0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.h0.a.i2.p;
import d.a.h0.a.t1.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.h0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y.b.e f45112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f45113f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45114g;

        public a(d.a.h0.a.y.b.e eVar, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f45112e = eVar;
            this.f45113f = canvasView;
            this.f45114g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            int h2 = this.f45112e.h();
            if (h2 != 0) {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(h2, f.this.n(h2));
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                this.f45113f.c(this.f45112e.i(), this.f45112e.j());
                this.f45113f.postInvalidate();
            }
            String str = this.f45112e.f41095i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f45114g.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/canvas/putImageData");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.e0.l.e J;
        d.a.h0.a.y.b.e o = o(unitedSchemeEntity);
        if (o == null) {
            d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(o.f41093g) && (J = d.a.h0.a.z0.f.V().J()) != null) {
            o.f41093g = J.W2();
        }
        if (!TextUtils.isEmpty(o.f41093g) && !TextUtils.isEmpty(o.f41092f)) {
            CanvasView a2 = d.a.h0.a.a0.c.d.b.a.a(o);
            if (a2 == null) {
                d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(o, a2, callbackHandler), "CanvasPutImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasPutImageData slave id = " + o.f41093g + " ; canvas id = " + o.f41092f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public final String n(int i2) {
        return i2 != 2001 ? i2 != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid";
    }

    public d.a.h0.a.y.b.e o(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.h0.a.y.b.e(str);
    }
}
