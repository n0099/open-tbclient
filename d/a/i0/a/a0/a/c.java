package d.a.i0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.i0.a.v2.q;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.i0.a.a0.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a0.b.c f40399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f40400f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40401g;

        public a(c cVar, d.a.i0.a.a0.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f40399e = cVar2;
            this.f40400f = canvasView;
            this.f40401g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject i2 = this.f40399e.i(this.f40400f);
            String str = this.f40399e.f40674i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f40401g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, 0).toString());
        }
    }

    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/getImageData");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.h0.g.f J;
        d.a.i0.a.a0.b.c m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.i0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f40672g) && (J = d.a.i0.a.g1.f.V().J()) != null) {
            m.f40672g = J.g3();
        }
        if (!TextUtils.isEmpty(m.f40672g) && !TextUtils.isEmpty(m.f40671f)) {
            CanvasView a2 = d.a.i0.a.c0.c.d.b.a.a(m);
            if (a2 == null) {
                d.a.i0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            q.j(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.i0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f40672g + " ; canvas id = " + m.f40671f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.a.i0.a.a0.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.i0.a.a0.b.c(str);
    }
}
