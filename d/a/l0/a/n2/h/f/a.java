package d.a.l0.a.n2.h.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.n2.h.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.n2.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0776a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43840b;

        public C0776a(a aVar, CallbackHandler callbackHandler, String str) {
            this.f43839a = callbackHandler;
            this.f43840b = str;
        }

        @Override // d.a.l0.a.n2.h.c
        public void a(int i2) {
            d.g("MemoryWarningAction", "trimMemory consume level:" + i2);
            if (i2 == 10 || i2 == 15) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("level", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f43839a.handleSchemeDispatchCallback(this.f43840b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/memoryWarning");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (context != null && callbackHandler != null && eVar != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b("MemoryWarningAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b("MemoryWarningAction", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            j(context, callbackHandler, optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.b("MemoryWarningAction", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public void j(Context context, CallbackHandler callbackHandler, String str) {
        d.a.l0.a.n2.h.d trimMemoryDispatcher;
        if ((context instanceof d.a.l0.a.n2.h.e) && (trimMemoryDispatcher = ((d.a.l0.a.n2.h.e) context).getTrimMemoryDispatcher()) != null) {
            trimMemoryDispatcher.b(new C0776a(this, callbackHandler, str));
        }
    }
}
