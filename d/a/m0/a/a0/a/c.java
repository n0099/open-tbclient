package d.a.m0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.m0.a.v2.q;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.m0.a.a0.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a0.b.c f44357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f44358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44359g;

        public a(c cVar, d.a.m0.a.a0.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f44357e = cVar2;
            this.f44358f = canvasView;
            this.f44359g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject i2 = this.f44357e.i(this.f44358f);
            String str = this.f44357e.f44632i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f44359g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, 0).toString());
        }
    }

    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/getImageData");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.h0.g.f J;
        d.a.m0.a.a0.b.c m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.m0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f44630g) && (J = d.a.m0.a.g1.f.V().J()) != null) {
            m.f44630g = J.g3();
        }
        if (!TextUtils.isEmpty(m.f44630g) && !TextUtils.isEmpty(m.f44629f)) {
            CanvasView a2 = d.a.m0.a.c0.c.d.b.a.a(m);
            if (a2 == null) {
                d.a.m0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            q.j(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.m0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f44630g + " ; canvas id = " + m.f44629f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.a.m0.a.a0.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.m0.a.a0.b.c(str);
    }
}
