package d.a.l0.a.c2.f.r0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.a.l0.a.c2.f.a0;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.h0.j.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f44938a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44939b;

        public a(d dVar, CallbackHandler callbackHandler) {
            this.f44938a = dVar;
            this.f44939b = callbackHandler;
        }

        @Override // d.a.l0.a.h0.j.d
        public void a(String str) {
        }

        @Override // d.a.l0.a.h0.j.d
        public void b(int i2) {
        }

        @Override // d.a.l0.a.h0.j.d
        public boolean c(String str) {
            if (e.this.l(str, this.f44938a.r)) {
                e.this.k(str, this.f44939b, this.f44938a.f44524i);
                return true;
            }
            return false;
        }

        @Override // d.a.l0.a.h0.j.d
        public void d(int i2, String str, String str2) {
        }

        @Override // d.a.l0.a.h0.j.d
        public void e(String str) {
        }

        @Override // d.a.l0.a.h0.j.d
        public void goBack() {
        }
    }

    public e(d.a.l0.a.c2.e eVar, String str) {
        super(eVar, str);
    }

    public final boolean k(String str, CallbackHandler callbackHandler, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e2) {
            if (a0.f44625b) {
                e2.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        return true;
    }

    public boolean l(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void m(CallbackHandler callbackHandler, SwanAppSlaveManager swanAppSlaveManager, d dVar) {
        swanAppSlaveManager.q1(new a(dVar, callbackHandler));
    }
}
