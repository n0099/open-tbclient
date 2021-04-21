package d.b.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f48076g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f48077h;

        public a(CallbackHandler callbackHandler, String str, Context context, boolean z) {
            this.f48074e = callbackHandler;
            this.f48075f = str;
            this.f48076g = context;
            this.f48077h = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                d.this.k((Activity) this.f48076g, this.f48077h, this.f48074e, this.f48075f);
            } else {
                d.b.h0.a.v1.c.c.o(hVar, this.f48074e, this.f48075f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48078e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48079f;

        public b(d dVar, CallbackHandler callbackHandler, String str) {
            this.f48078e = callbackHandler;
            this.f48079f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.d.a aVar) {
            d.b.h0.a.c0.c.g("OpenData", "onOpenDataCallback:: " + aVar.toString());
            if (!aVar.y()) {
                d.b.h0.a.v1.c.c.l(aVar, this.f48078e, this.f48079f);
            } else {
                this.f48078e.handleSchemeDispatchCallback(this.f48079f, UnitedSchemeUtility.wrapCallbackParams(aVar.f47560g, 0).toString());
            }
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/getRealNameInfo");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
            return false;
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            boolean i = d.b.h0.a.v1.c.c.i(optParamsAsJo);
            eVar.R().h(context, "ppcert", i, new a(callbackHandler, optString, context, i));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(Activity activity, boolean z, CallbackHandler callbackHandler, String str) {
        d.b.h0.a.v1.d.a.v(activity, "ppcert", null, z, new b(this, callbackHandler, str));
    }
}
