package d.a.h0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.canvas.view.CanvasView;
import d.a.h0.a.i2.p;
import d.a.h0.a.t1.j;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.h0.a.y.a.a {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y.b.f f45116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f45117f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45118g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45119h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45120i;
        public final /* synthetic */ CallbackHandler j;

        public a(h hVar, d.a.h0.a.y.b.f fVar, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, d.a.h0.a.r1.e eVar, CallbackHandler callbackHandler) {
            this.f45116e = fVar;
            this.f45117f = canvasView;
            this.f45118g = str;
            this.f45119h = unitedSchemeEntity;
            this.f45120i = eVar;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean i2 = this.f45116e.i(this.f45117f, this.f45118g);
            HashMap<String, String> params = this.f45119h.getParams();
            if (params == null || params.isEmpty()) {
                return;
            }
            String str = params.get("params");
            String str2 = null;
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                try {
                    str2 = new JSONObject(str).optString("cb");
                    jSONObject.putOpt("tempFilePath", d.a.h0.a.a2.b.r(this.f45118g, this.f45120i.f43823f));
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

    public h(j jVar) {
        super(jVar, "/swanAPI/canvas/toTempFilePath");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        String str;
        d.a.h0.a.e0.l.e J;
        d.a.h0.a.y.b.f m = m(unitedSchemeEntity);
        if (m == null) {
            d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
            unitedSchemeEntity.result = l(201);
            return false;
        }
        String h2 = d.a.h0.a.a2.b.h(eVar.f43823f);
        if (TextUtils.isEmpty(h2)) {
            d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
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
        if (TextUtils.isEmpty(m.f41093g) && (J = d.a.h0.a.z0.f.V().J()) != null) {
            m.f41093g = J.W2();
        }
        if (!TextUtils.isEmpty(m.f41093g) && !TextUtils.isEmpty(m.f41092f)) {
            CanvasView a2 = d.a.h0.a.a0.c.d.b.a.a(m);
            if (a2 == null) {
                d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            p.k(new a(this, m, a2, str3, unitedSchemeEntity, eVar, callbackHandler), "tempFilePath");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.f41093g + " ; canvas id = " + m.f41092f);
        unitedSchemeEntity.result = l(201);
        return false;
    }

    public d.a.h0.a.y.b.f m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.h0.a.y.b.f(str);
    }
}
