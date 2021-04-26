package d.a.h0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.h0.a.t1.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements CanvasView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45107a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45108b;

        public a(b bVar, String str, CallbackHandler callbackHandler) {
            this.f45107a = str;
            this.f45108b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.canvas.view.CanvasView.c
        public void a() {
            String str = this.f45107a;
            if (str != null) {
                this.f45108b.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
            }
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/canvas/drawCanvas");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.y.b.b m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.h0.a.c0.c.b("SwanAppCanvas", "draw model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(m.f41092f)) {
            d.a.h0.a.a0.g.a.a("SwanAppAction", "canvasId is empty ");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f41093g)) {
            d.a.h0.a.a0.g.a.a("SwanAppAction", "drawCanvas slaveId is empty");
            d.a.h0.a.e0.l.e J = d.a.h0.a.z0.f.V().J();
            if (J != null) {
                m.f41093g = J.W2();
            }
        }
        d.a.h0.a.a0.c.d.a aVar = (d.a.h0.a.a0.c.d.a) d.a.h0.a.a0.d.a.a(m);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
            return false;
        }
        boolean H = aVar.H(m, new a(this, optString, callbackHandler));
        j(unitedSchemeEntity, callbackHandler, H);
        return H;
    }

    public d.a.h0.a.y.b.b m(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.y.b.b(unitedSchemeEntity.getParams().get("params"));
    }
}
