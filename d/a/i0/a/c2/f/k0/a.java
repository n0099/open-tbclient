package d.a.i0.a.c2.f.k0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.a2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.u.e.i.a;
import d.a.i0.a.u.e.i.b;
/* loaded from: classes3.dex */
public final class a extends a0 implements b.c {

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f40948c;

    /* renamed from: d.a.i0.a.c2.f.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0575a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40949e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.c f40950f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f40951g;

        public C0575a(CallbackHandler callbackHandler, a.c cVar, e eVar) {
            this.f40949e = callbackHandler;
            this.f40950f = cVar;
            this.f40951g = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            a.this.k(iVar, this.f40949e, this.f40950f, this.f40951g.d0());
        }
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getLocation");
    }

    @Override // d.a.i0.a.u.e.i.b.c
    public void b(a.c cVar, int i2) {
        if (this.f40948c == null) {
            return;
        }
        d.b("GetLocationAction", "request location error code : " + i2);
        this.f40948c.handleSchemeDispatchCallback(cVar.f44848c, UnitedSchemeUtility.wrapCallbackParams(i2).toString());
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f40775b) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f40948c = callbackHandler;
        if (eVar == null) {
            d.b("location", "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        a.c b2 = a.c.b(unitedSchemeEntity.getParam("params"));
        if (b2 != null && b2.a()) {
            if (TextUtils.isEmpty(b2.f44848c)) {
                d.b("location", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.T().g(context, "mapp_location", new C0575a(callbackHandler, b2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.b("location", "params is invalid");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
        return false;
    }

    @Override // d.a.i0.a.u.e.i.b.c
    public void f(a.c cVar, String str) {
        CallbackHandler callbackHandler = this.f40948c;
        if (callbackHandler == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.f44848c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    @Override // d.a.i0.a.u.e.i.b.c
    public void g(a.c cVar, b bVar) {
        if (a0.f40775b) {
            Log.d("GetLocationAction", "convert info : " + bVar.a());
        }
        CallbackHandler callbackHandler = this.f40948c;
        if (callbackHandler == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.f44848c, UnitedSchemeUtility.wrapCallbackParams(bVar.a(), 0).toString());
    }

    public final void k(i<b.e> iVar, CallbackHandler callbackHandler, a.c cVar, boolean z) {
        d.g("GetLocationAction", "authorized result is " + iVar);
        if (d.a.i0.a.e2.c.d.h(iVar)) {
            d.a.i0.a.u.e.i.b.d().e(cVar, this, z);
            return;
        }
        int b2 = iVar.b();
        callbackHandler.handleSchemeDispatchCallback(cVar.f44848c, UnitedSchemeUtility.wrapCallbackParams(b2, d.a.i0.a.e2.c.d.f(b2)).toString());
    }
}
