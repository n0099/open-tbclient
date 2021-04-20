package d.b.g0.a.t.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import d.b.g0.a.v1.c.h;
import d.b.g0.g.c0.c;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0807a implements d.b.g0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46327e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46328f;

        public C0807a(a aVar, CallbackHandler callbackHandler, String str) {
            this.f46327e = callbackHandler;
            this.f46328f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<JSONObject> hVar) {
            JSONObject wrapCallbackParams;
            if (hVar.c() && a.r(hVar.f47200a)) {
                JSONObject optJSONObject = hVar.f47200a.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                }
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.b());
                c.b(this.f46327e, wrapCallbackParams.toString());
            }
            this.f46327e.handleSchemeDispatchCallback(this.f46328f, wrapCallbackParams.toString());
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static boolean r(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0");
    }

    public d.b.g0.a.t.e.b q(String str) {
        if (d.f46321c) {
            Log.d("Api-CheckSession", "start check session");
        }
        CallbackHandler h2 = a().h();
        e O = e.O();
        if (O == null) {
            c.b(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.b.g0.a.t.e.b(1001, "empty swanApp");
        }
        String B = O.B();
        if (TextUtils.isEmpty(B)) {
            c.b(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            return new d.b.g0.a.t.e.b(1001, "empty app key");
        }
        JSONObject l = d.l(str);
        if (l == null) {
            c.b(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return new d.b.g0.a.t.e.b(201, "empty joParams");
        }
        String optString = l.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.b(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return new d.b.g0.a.t.e.b(201, "empty cb");
        }
        Context h3 = h();
        if (!O.z().e(h3)) {
            c.b(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            return new d.b.g0.a.t.e.b(10004, "user not logged in");
        }
        d.b.g0.a.v1.c.i.c g2 = d.b.g0.a.r1.d.e().o().a().a().g(h3, B);
        g2.p(new C0807a(this, h2, optString));
        g2.a();
        return new d.b.g0.a.t.e.b(0);
    }
}
