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
public class c extends d.b.g0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y.b.c f46957e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f46958f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46959g;

        public a(c cVar, d.b.g0.a.y.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f46957e = cVar2;
            this.f46958f = canvasView;
            this.f46959g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject i = this.f46957e.i(this.f46958f);
            String str = this.f46957e.i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f46959g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, 0).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/canvas/getImageData");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.e0.l.e A;
        d.b.g0.a.y.b.c m = m(unitedSchemeEntity);
        if (m == null) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f43114g) && (A = d.b.g0.a.z0.f.V().A()) != null) {
            m.f43114g = A.X2();
        }
        if (!TextUtils.isEmpty(m.f43114g) && !TextUtils.isEmpty(m.f43113f)) {
            CanvasView a2 = d.b.g0.a.a0.c.d.b.a.a(m);
            if (a2 == null) {
                d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f43114g + " ; canvas id = " + m.f43113f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.b.g0.a.y.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.b.g0.a.y.b.c(str);
    }
}
