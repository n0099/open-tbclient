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
public class c extends d.a.h0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y.b.c f45109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f45110f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45111g;

        public a(c cVar, d.a.h0.a.y.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f45109e = cVar2;
            this.f45110f = canvasView;
            this.f45111g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject i2 = this.f45109e.i(this.f45110f);
            String str = this.f45109e.f41095i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f45111g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, 0).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/canvas/getImageData");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.e0.l.e J;
        d.a.h0.a.y.b.c m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f41093g) && (J = d.a.h0.a.z0.f.V().J()) != null) {
            m.f41093g = J.W2();
        }
        if (!TextUtils.isEmpty(m.f41093g) && !TextUtils.isEmpty(m.f41092f)) {
            CanvasView a2 = d.a.h0.a.a0.c.d.b.a.a(m);
            if (a2 == null) {
                d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f41093g + " ; canvas id = " + m.f41092f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.a.h0.a.y.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.h0.a.y.b.c(str);
    }
}
