package d.b.g0.a.t1.k.r0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class e extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.e0.n.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46560b;

        public a(d dVar, CallbackHandler callbackHandler) {
            this.f46559a = dVar;
            this.f46560b = callbackHandler;
        }

        @Override // d.b.g0.a.e0.n.d
        public void a(String str) {
        }

        @Override // d.b.g0.a.e0.n.d
        public boolean b(String str) {
            if (e.this.l(str, this.f46559a.r)) {
                e.this.k(str, this.f46560b, this.f46559a.i);
                return true;
            }
            return false;
        }

        @Override // d.b.g0.a.e0.n.d
        public void c(int i, String str, String str2) {
        }

        @Override // d.b.g0.a.e0.n.d
        public void d(String str) {
        }

        @Override // d.b.g0.a.e0.n.d
        public void goBack() {
        }
    }

    public e(j jVar, String str) {
        super(jVar, str);
    }

    public final boolean k(String str, CallbackHandler callbackHandler, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e2) {
            if (a0.f46288b) {
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
        swanAppSlaveManager.g1(new a(dVar, callbackHandler));
    }
}
