package d.b.h0.a.c2.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.c0.c;
import d.b.h0.a.c2.f.b;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.c2.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0671a implements d.b.h0.a.c2.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44516b;

        public C0671a(a aVar, CallbackHandler callbackHandler, String str) {
            this.f44515a = callbackHandler;
            this.f44516b = str;
        }

        @Override // d.b.h0.a.c2.f.a
        public void a(int i) {
            c.g("MemoryWarningAction", "trimMemory consume level:" + i);
            if (i == 10 || i == 15) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("level", i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f44515a.handleSchemeDispatchCallback(this.f44516b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/memoryWarning");
    }

    @Override // d.b.h0.a.t1.k.a0
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
        if ((context instanceof d.b.h0.a.c2.f.c) && (trimMemoryDispatcher = ((d.b.h0.a.c2.f.c) context).getTrimMemoryDispatcher()) != null) {
            trimMemoryDispatcher.b(new C0671a(this, callbackHandler, str));
        }
    }
}
