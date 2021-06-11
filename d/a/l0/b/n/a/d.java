package d.a.l0.b.n.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49993e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49994f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49995g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f49996h;

        public a(CallbackHandler callbackHandler, String str, Context context, boolean z) {
            this.f49993e = callbackHandler;
            this.f49994f = str;
            this.f49995g = context;
            this.f49996h = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                d.this.k((Activity) this.f49995g, this.f49996h, this.f49993e, this.f49994f);
            } else {
                d.a.l0.a.e2.c.d.p(iVar, this.f49993e, this.f49994f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49999f;

        public b(d dVar, CallbackHandler callbackHandler, String str) {
            this.f49998e = callbackHandler;
            this.f49999f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.d.a aVar) {
            d.a.l0.a.e0.d.g("OpenData", "onOpenDataCallback:: " + aVar.toString());
            if (!aVar.F()) {
                d.a.l0.a.e2.c.d.m(aVar, this.f49998e, this.f49999f);
            } else {
                this.f49998e.handleSchemeDispatchCallback(this.f49999f, UnitedSchemeUtility.wrapCallbackParams(aVar.f45447g, 0).toString());
            }
        }
    }

    public d(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getRealNameInfo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
            boolean i2 = d.a.l0.a.e2.c.d.i(optParamsAsJo);
            eVar.T().h(context, "ppcert", i2, new a(callbackHandler, optString, context, i2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(Activity activity, boolean z, CallbackHandler callbackHandler, String str) {
        d.a.l0.a.e2.d.a.C(activity, "ppcert", null, z, "GetRealNameInfo", new b(this, callbackHandler, str));
    }
}
