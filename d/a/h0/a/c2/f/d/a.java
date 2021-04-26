package d.a.h0.a.c2.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c0.c;
import d.a.h0.a.c2.f.b;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.c2.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0610a implements d.a.h0.a.c2.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41809b;

        public C0610a(a aVar, CallbackHandler callbackHandler, String str) {
            this.f41808a = callbackHandler;
            this.f41809b = str;
        }

        @Override // d.a.h0.a.c2.f.a
        public void a(int i2) {
            c.g("MemoryWarningAction", "trimMemory consume level:" + i2);
            if (i2 == 10 || i2 == 15) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("level", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f41808a.handleSchemeDispatchCallback(this.f41809b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/memoryWarning");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (context != null && callbackHandler != null && eVar != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.b("MemoryWarningAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.b("MemoryWarningAction", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            j(context, callbackHandler, optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        c.b("MemoryWarningAction", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public void j(Context context, CallbackHandler callbackHandler, String str) {
        b trimMemoryDispatcher;
        if ((context instanceof d.a.h0.a.c2.f.c) && (trimMemoryDispatcher = ((d.a.h0.a.c2.f.c) context).getTrimMemoryDispatcher()) != null) {
            trimMemoryDispatcher.b(new C0610a(this, callbackHandler, str));
        }
    }
}
