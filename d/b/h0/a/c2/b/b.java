package d.b.h0.a.c2.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.c2.b.d;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44489b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44490c;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44488a = callbackHandler;
            this.f44489b = unitedSchemeEntity;
            this.f44490c = str;
        }

        @Override // d.b.h0.a.c2.b.d.b
        public void a(int i) {
            b.this.k(i, this.f44488a, this.f44489b, this.f44490c);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/startMediaVolumeListen");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("startMediaVolumeListen", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            return false;
        } else if (context == null) {
            d.b.h0.a.c0.c.b("startMediaVolumeListen", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.h0.a.c0.c.b("startMediaVolumeListen", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.c0.c.b("startMediaVolumeListen", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("id");
            if (TextUtils.isEmpty(optString2)) {
                d.b.h0.a.c0.c.b("startMediaVolumeListen", "id is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.e().d(optString2, new a(callbackHandler, unitedSchemeEntity, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(double d2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
        JSONObject jSONObject = new JSONObject();
        int f2 = (int) ((d2 / d.e().f()) * 100.0d);
        if (f2 < 0) {
            f2 = 0;
        }
        if (f2 > 100) {
            f2 = 100;
        }
        try {
            jSONObject.put("volume", f2);
            if (a0.f47009b) {
                Log.d("startMediaVolumeListen", "NewVolume: " + f2);
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        } catch (JSONException e2) {
            d.b.h0.a.c0.c.b("startMediaVolumeListen", "handle volume json error，" + e2.toString());
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "Json error").toString(), str);
        }
    }
}
