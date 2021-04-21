package d.b.h0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.b.h0.a.i2.p;
import d.b.h0.a.t1.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.h0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y.b.c f47678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f47679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47680g;

        public a(c cVar, d.b.h0.a.y.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            this.f47678e = cVar2;
            this.f47679f = canvasView;
            this.f47680g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject i = this.f47678e.i(this.f47679f);
            String str = this.f47678e.i;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f47680g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, 0).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/canvas/getImageData");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.e0.l.e A;
        d.b.h0.a.y.b.c m = m(unitedSchemeEntity);
        if (m == null) {
            d.b.h0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        if (TextUtils.isEmpty(m.f43835g) && (A = d.b.h0.a.z0.f.V().A()) != null) {
            m.f43835g = A.X2();
        }
        if (!TextUtils.isEmpty(m.f43835g) && !TextUtils.isEmpty(m.f43834f)) {
            CanvasView a2 = d.b.h0.a.a0.c.d.b.a.a(m);
            if (a2 == null) {
                d.b.h0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.h0.a.c0.c.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f43835g + " ; canvas id = " + m.f43834f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.b.h0.a.y.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.b.h0.a.y.b.c(str);
    }
}
