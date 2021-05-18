package d.a.i0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.g.g;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43960f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43961g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f43962h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, g gVar) {
            this.f43959e = callbackHandler;
            this.f43960f = unitedSchemeEntity;
            this.f43961g = str;
            this.f43962h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.o(iVar, this.f43959e, this.f43960f);
                return;
            }
            String str = this.f43961g;
            b.this.k(d.a.i0.a.l1.b.e(str, str), this.f43962h);
            d.a.i0.a.e0.d.g("AdLanding", "open adLanding page success");
            UnitedSchemeUtility.callCallback(this.f43959e, this.f43960f, 0);
        }
    }

    public b(e eVar) {
        super(eVar, "/swanAPI/openAdLandingPage");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String o = d.a.i0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.i0.a.e0.d.g("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        g W = f.V().W();
        if (W == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        eVar.T().g(context, "mapp_i_open_adlanding", new a(callbackHandler, unitedSchemeEntity, o, W));
        return true;
    }

    public final void k(d.a.i0.a.l1.b bVar, g gVar) {
        d.a.i0.a.e0.d.g("AdLanding", "openAdLanding: page url=" + bVar.f43185g);
        g.b i2 = gVar.i("adLanding");
        i2.n(g.f41902g, g.f41904i);
        i2.k("adLanding", bVar).b();
    }
}
