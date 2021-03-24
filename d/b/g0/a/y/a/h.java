package d.b.g0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.b.g0.a.i2.p;
import d.b.g0.a.t1.j;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d.b.g0.a.y.a.a {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y.b.f f46963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f46964f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46965g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46966h;
        public final /* synthetic */ d.b.g0.a.r1.e i;
        public final /* synthetic */ CallbackHandler j;

        public a(h hVar, d.b.g0.a.y.b.f fVar, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler) {
            this.f46963e = fVar;
            this.f46964f = canvasView;
            this.f46965g = str;
            this.f46966h = unitedSchemeEntity;
            this.i = eVar;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean i = this.f46963e.i(this.f46964f, this.f46965g);
            HashMap<String, String> params = this.f46966h.getParams();
            if (params == null || params.isEmpty()) {
                return;
            }
            String str = params.get("params");
            String str2 = null;
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                try {
                    str2 = new JSONObject(str).optString("cb");
                    jSONObject.putOpt("tempFilePath", d.b.g0.a.a2.b.r(this.f46965g, this.i.f45739f));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.j.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, i ? 0 : 1001).toString());
        }
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/canvas/toTempFilePath");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        String str;
        d.b.g0.a.e0.l.e A;
        d.b.g0.a.y.b.f m = m(unitedSchemeEntity);
        if (m == null) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        String h2 = d.b.g0.a.a2.b.h(eVar.f45739f);
        if (TextUtils.isEmpty(h2)) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        String str2 = h2 + File.separator + Calendar.getInstance().getTimeInMillis();
        if (m.h()) {
            str = str2 + ".jpg";
        } else {
            str = str2 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        }
        String str3 = str;
        if (TextUtils.isEmpty(m.f43113g) && (A = d.b.g0.a.z0.f.V().A()) != null) {
            m.f43113g = A.X2();
        }
        if (!TextUtils.isEmpty(m.f43113g) && !TextUtils.isEmpty(m.f43112f)) {
            CanvasView a2 = d.b.g0.a.a0.c.d.b.a.a(m);
            if (a2 == null) {
                d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(this, m, a2, str3, unitedSchemeEntity, eVar, callbackHandler), "tempFilePath");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.f43113g + " ; canvas id = " + m.f43112f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.b.g0.a.y.b.f m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.b.g0.a.y.b.f(str);
    }
}
