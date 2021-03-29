package d.b.g0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45477f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45478g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f45479h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, f fVar) {
            this.f45476e = callbackHandler;
            this.f45477f = unitedSchemeEntity;
            this.f45478g = str;
            this.f45479h = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.n(hVar, this.f45476e, this.f45477f);
                return;
            }
            String str = this.f45478g;
            c.this.k(d.b.g0.a.e1.b.c(str, str), this.f45479h);
            d.b.g0.a.c0.c.g("AdLanding", "open adLanding page success");
            UnitedSchemeUtility.callCallback(this.f45476e, this.f45477f, 0);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/openAdLandingPage");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String n = d.b.g0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.g0.a.c0.c.g("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        eVar.R().g(context, "mapp_i_open_adlanding", new a(callbackHandler, unitedSchemeEntity, n, W));
        return true;
    }

    public final void k(d.b.g0.a.e1.b bVar, f fVar) {
        d.b.g0.a.c0.c.g("AdLanding", "openAdLanding: page url=" + bVar.f44364c);
        f.b i = fVar.i("adLanding");
        i.n(f.f44013g, f.i);
        i.k("adLanding", bVar).b();
    }
}
