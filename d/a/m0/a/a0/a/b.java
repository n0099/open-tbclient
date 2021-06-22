package d.a.m0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.a0.a.a {

    /* loaded from: classes2.dex */
    public class a implements CanvasView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44355a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44356b;

        public a(b bVar, String str, CallbackHandler callbackHandler) {
            this.f44355a = str;
            this.f44356b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.canvas.view.CanvasView.c
        public void a() {
            String str = this.f44355a;
            if (str != null) {
                this.f44356b.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
            }
        }
    }

    public b(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/drawCanvas");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.a0.b.b m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.m0.a.e0.d.b("SwanAppCanvas", "draw model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(m.f44629f)) {
            d.a.m0.a.c0.g.a.a("SwanAppAction", "canvasId is empty ");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f44630g)) {
            d.a.m0.a.c0.g.a.a("SwanAppAction", "drawCanvas slaveId is empty");
            d.a.m0.a.h0.g.f J = d.a.m0.a.g1.f.V().J();
            if (J != null) {
                m.f44630g = J.g3();
            }
        }
        d.a.m0.a.c0.c.d.a aVar = (d.a.m0.a.c0.c.d.a) d.a.m0.a.c0.d.a.a(m);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
            return false;
        }
        boolean H = aVar.H(m, new a(this, optString, callbackHandler));
        j(unitedSchemeEntity, callbackHandler, H);
        return H;
    }

    public d.a.m0.a.a0.b.b m(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.m0.a.a0.b.b(unitedSchemeEntity.getParams().get("params"));
    }
}
