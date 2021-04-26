package d.a.h0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44830e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44831f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44832g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f44833h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44834i;

        public a(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2) {
            this.f44830e = z;
            this.f44831f = callbackHandler;
            this.f44832g = str;
            this.f44833h = activity;
            this.f44834i = str2;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                f.this.k(this.f44830e, this.f44831f, this.f44832g, this.f44833h, this.f44834i, "snsapi_userinfo");
            } else {
                this.f44831f.handleSchemeDispatchCallback(this.f44832g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44836f;

        public b(f fVar, CallbackHandler callbackHandler, String str) {
            this.f44835e = callbackHandler;
            this.f44836f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.d.a aVar) {
            d.a.h0.a.c0.c.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (!aVar.y()) {
                d.a.h0.a.v1.c.c.l(aVar, this.f44835e, this.f44836f);
            } else {
                this.f44835e.handleSchemeDispatchCallback(this.f44836f, UnitedSchemeUtility.wrapCallbackParams(aVar.f44984g, 0).toString());
            }
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/getUserInfo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.a.h0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.a.h0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.a.h0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        }
        Activity v = context instanceof Activity ? (Activity) context : eVar.v();
        if (v == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            d.a.h0.g.c0.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
            return false;
        }
        String e2 = d.a.h0.a.l1.g.b.e(optParamsAsJo.optString("__plugin__", null));
        d.a.h0.a.m.b i2 = eVar.i();
        boolean i3 = d.a.h0.a.v1.c.c.i(optParamsAsJo);
        if (!i2.e(context) && i3) {
            i2.f(v, null, new a(i3, callbackHandler, optString, v, e2));
        } else {
            k(i3, callbackHandler, optString, v, e2, "snsapi_userinfo");
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        d.a.h0.a.v1.d.a.v(activity, str3, str2, z, new b(this, callbackHandler, str));
    }
}
