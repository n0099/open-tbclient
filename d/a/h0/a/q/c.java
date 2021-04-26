package d.a.h0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43546g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f43547h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, f fVar) {
            this.f43544e = callbackHandler;
            this.f43545f = unitedSchemeEntity;
            this.f43546g = str;
            this.f43547h = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.n(hVar, this.f43544e, this.f43545f);
                return;
            }
            String str = this.f43546g;
            c.this.k(d.a.h0.a.e1.b.c(str, str), this.f43547h);
            d.a.h0.a.c0.c.g("AdLanding", "open adLanding page success");
            UnitedSchemeUtility.callCallback(this.f43544e, this.f43545f, 0);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/openAdLandingPage");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String n = d.a.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.a.h0.a.c0.c.g("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        eVar.R().g(context, "mapp_i_open_adlanding", new a(callbackHandler, unitedSchemeEntity, n, W));
        return true;
    }

    public final void k(d.a.h0.a.e1.b bVar, f fVar) {
        d.a.h0.a.c0.c.g("AdLanding", "openAdLanding: page url=" + bVar.f42394c);
        f.b i2 = fVar.i("adLanding");
        i2.n(f.f42031g, f.f42033i);
        i2.k("adLanding", bVar).b();
    }
}
