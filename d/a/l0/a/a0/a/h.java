package d.a.l0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.l0.a.v2.q;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.l0.a.a0.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a0.b.f f40580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f40581f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f40582g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f40583h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f40584i;
        public final /* synthetic */ CallbackHandler j;

        public a(h hVar, d.a.l0.a.a0.b.f fVar, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.a2.e eVar, CallbackHandler callbackHandler) {
            this.f40580e = fVar;
            this.f40581f = canvasView;
            this.f40582g = str;
            this.f40583h = unitedSchemeEntity;
            this.f40584i = eVar;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean i2 = this.f40580e.i(this.f40581f, this.f40582g);
            HashMap<String, String> params = this.f40583h.getParams();
            if (params == null || params.isEmpty()) {
                return;
            }
            String str = params.get("params");
            String str2 = null;
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                try {
                    str2 = new JSONObject(str).optString("cb");
                    jSONObject.putOpt("tempFilePath", d.a.l0.a.k2.b.J(this.f40582g, this.f40584i.f40749f));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.j.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, i2 ? 0 : 1001).toString());
        }
    }

    public h(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/toTempFilePath");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        String str;
        d.a.l0.a.h0.g.f J;
        d.a.l0.a.a0.b.f m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        String x = d.a.l0.a.k2.b.x(eVar.f40749f);
        if (TextUtils.isEmpty(x)) {
            d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        String str2 = x + File.separator + Calendar.getInstance().getTimeInMillis();
        if (m.h()) {
            str = str2 + ".jpg";
        } else {
            str = str2 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        }
        String str3 = str;
        if (TextUtils.isEmpty(m.f40846g) && (J = d.a.l0.a.g1.f.V().J()) != null) {
            m.f40846g = J.g3();
        }
        if (!TextUtils.isEmpty(m.f40846g) && !TextUtils.isEmpty(m.f40845f)) {
            CanvasView a2 = d.a.l0.a.c0.c.d.b.a.a(m);
            if (a2 == null) {
                d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            q.j(new a(this, m, a2, str3, unitedSchemeEntity, eVar, callbackHandler), "tempFilePath");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.l0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.f40846g + " ; canvas id = " + m.f40845f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.a.l0.a.a0.b.f m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.l0.a.a0.b.f(str);
    }
}
