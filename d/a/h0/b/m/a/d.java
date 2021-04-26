package d.a.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45518g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f45519h;

        public a(CallbackHandler callbackHandler, String str, Context context, boolean z) {
            this.f45516e = callbackHandler;
            this.f45517f = str;
            this.f45518g = context;
            this.f45519h = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                d.this.k((Activity) this.f45518g, this.f45519h, this.f45516e, this.f45517f);
            } else {
                d.a.h0.a.v1.c.c.o(hVar, this.f45516e, this.f45517f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45522f;

        public b(d dVar, CallbackHandler callbackHandler, String str) {
            this.f45521e = callbackHandler;
            this.f45522f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.d.a aVar) {
            d.a.h0.a.c0.c.g("OpenData", "onOpenDataCallback:: " + aVar.toString());
            if (!aVar.y()) {
                d.a.h0.a.v1.c.c.l(aVar, this.f45521e, this.f45522f);
            } else {
                this.f45521e.handleSchemeDispatchCallback(this.f45522f, UnitedSchemeUtility.wrapCallbackParams(aVar.f44984g, 0).toString());
            }
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/getRealNameInfo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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
            boolean i2 = d.a.h0.a.v1.c.c.i(optParamsAsJo);
            eVar.R().h(context, "ppcert", i2, new a(callbackHandler, optString, context, i2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(Activity activity, boolean z, CallbackHandler callbackHandler, String str) {
        d.a.h0.a.v1.d.a.v(activity, "ppcert", null, z, new b(this, callbackHandler, str));
    }
}
