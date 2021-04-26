package d.a.h0.a.v1.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.a f44887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44888b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44889c;

        public a(i iVar, d.a.h0.a.v1.a aVar, CallbackHandler callbackHandler, String str) {
            this.f44887a = aVar;
            this.f44888b = callbackHandler;
            this.f44889c = str;
        }

        @Override // d.a.h0.a.v1.a.j
        public void a() {
            this.f44887a.E(this);
            d.a.h0.a.t.c.j.a.C(this.f44888b, this.f44889c);
        }
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/openSetting");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            d.a.h0.a.v1.a R = eVar.R();
            if (!eVar.R().D()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not open setting page");
                return false;
            }
            R.B(new a(this, R, callbackHandler, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
