package d.a.m0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.g1.f;
import d.a.m0.a.u.e.o.k;
import d.a.m0.a.v2.q0;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.m0.a.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0859a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f47915f;

        public RunnableC0859a(UnitedSchemeEntity unitedSchemeEntity, d.a.m0.a.l1.b bVar) {
            this.f47914e = unitedSchemeEntity;
            this.f47915f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k(this.f47914e, this.f47915f);
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/openAdWebPage");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("AdLandingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String o = d.a.m0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        String n = d.a.m0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", PrefetchEvent.EVENT_DATA_EXTRA_DATA);
        if (TextUtils.isEmpty(o)) {
            d.a.m0.a.e0.d.b("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (f.V().W() == null) {
            d.a.m0.a.e0.d.g("AdLandingAction", "open page failed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else {
            d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(o, o);
            e2.f47142f = n;
            if (k.e().g()) {
                l(unitedSchemeEntity, e2);
            } else {
                k(unitedSchemeEntity, e2);
            }
            d.a.m0.a.e0.d.g("AdLanding", "open adLanding page finish");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, d.a.m0.a.l1.b bVar) {
        if (d.a.m0.a.h0.g.k.Q2("adLanding", bVar)) {
            return;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
    }

    public final void l(UnitedSchemeEntity unitedSchemeEntity, d.a.m0.a.l1.b bVar) {
        k.e().h();
        q0.Y(new RunnableC0859a(unitedSchemeEntity, bVar), 200L);
    }
}
