package d.a.m0.a.e2.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.e2.a f45454a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45455b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45456c;

        public a(i iVar, d.a.m0.a.e2.a aVar, CallbackHandler callbackHandler, String str) {
            this.f45454a = aVar;
            this.f45455b = callbackHandler;
            this.f45456c = str;
        }

        @Override // d.a.m0.a.e2.a.j
        public void a() {
            this.f45454a.F(this);
            d.a.m0.a.u.e.l.b.F(this.f45455b, this.f45456c);
        }
    }

    public i(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openSetting");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f44733b) {
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
            d.a.m0.a.e2.a T = eVar.T();
            if (!eVar.T().E()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not open setting page");
                return false;
            }
            T.C(new a(this, T, callbackHandler, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
