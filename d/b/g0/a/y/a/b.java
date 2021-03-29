package d.b.g0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.b.g0.a.t1.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements CanvasView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46955a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46956b;

        public a(b bVar, String str, CallbackHandler callbackHandler) {
            this.f46955a = str;
            this.f46956b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.canvas.view.CanvasView.c
        public void a() {
            String str = this.f46955a;
            if (str != null) {
                this.f46956b.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
            }
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/canvas/drawCanvas");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.y.b.b m = m(unitedSchemeEntity);
        if (m == null) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "draw model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(m.f43113f)) {
            d.b.g0.a.a0.g.a.a("SwanAppAction", "canvasId is empty ");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f43114g)) {
            d.b.g0.a.a0.g.a.a("SwanAppAction", "drawCanvas slaveId is empty");
            d.b.g0.a.e0.l.e A = d.b.g0.a.z0.f.V().A();
            if (A != null) {
                m.f43114g = A.X2();
            }
        }
        d.b.g0.a.a0.c.d.a aVar = (d.b.g0.a.a0.c.d.a) d.b.g0.a.a0.d.a.a(m);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
            return false;
        }
        boolean H = aVar.H(m, new a(this, optString, callbackHandler));
        j(unitedSchemeEntity, callbackHandler, H);
        return H;
    }

    public d.b.g0.a.y.b.b m(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.g0.a.y.b.b(unitedSchemeEntity.getParams().get("params"));
    }
}
