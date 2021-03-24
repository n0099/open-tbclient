package d.b.g0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.e0.l.i;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.z0.f;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.a.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0757a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f45468f;

        public RunnableC0757a(UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.e1.b bVar) {
            this.f45467e = unitedSchemeEntity;
            this.f45468f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k(this.f45467e, this.f45468f);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/openAdWebPage");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46287b) {
            Log.d("AdLandingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String n = d.b.g0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "extraData");
        if (TextUtils.isEmpty(n)) {
            d.b.g0.a.c0.c.b("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (f.V().W() == null) {
            d.b.g0.a.c0.c.g("AdLandingAction", "open page failed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else {
            d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(n, n);
            c2.f44362b = m;
            if (d.b.g0.a.t.c.m.j.c().d()) {
                l(unitedSchemeEntity, c2);
            } else {
                k(unitedSchemeEntity, c2);
            }
            d.b.g0.a.c0.c.g("AdLanding", "open adLanding page finish");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.e1.b bVar) {
        if (i.K2("adLanding", bVar)) {
            return;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
    }

    public final void l(UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.e1.b bVar) {
        d.b.g0.a.t.c.m.j.c().e();
        k0.U(new RunnableC0757a(unitedSchemeEntity, bVar), 200L);
    }
}
