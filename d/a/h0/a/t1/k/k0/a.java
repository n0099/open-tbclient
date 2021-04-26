package d.a.h0.a.t1.k.k0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c0.c;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.c.g.a;
import d.a.h0.a.t.c.g.b;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public final class a extends a0 implements b.c {

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f44566c;

    /* renamed from: d.a.h0.a.t1.k.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0812a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44567e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.c f44568f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f44569g;

        public C0812a(CallbackHandler callbackHandler, a.c cVar, e eVar) {
            this.f44567e = callbackHandler;
            this.f44568f = cVar;
            this.f44569g = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            a.this.k(hVar, this.f44567e, this.f44568f, this.f44569g.Z());
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getLocation");
    }

    @Override // d.a.h0.a.t.c.g.b.c
    public void b(a.c cVar, int i2) {
        if (this.f44566c == null) {
            return;
        }
        c.b("GetLocationAction", "request location error code : " + i2);
        this.f44566c.handleSchemeDispatchCallback(cVar.f44178c, UnitedSchemeUtility.wrapCallbackParams(i2).toString());
    }

    @Override // d.a.h0.a.t.c.g.b.c
    public void e(a.c cVar, String str) {
        CallbackHandler callbackHandler = this.f44566c;
        if (callbackHandler == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.f44178c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    @Override // d.a.h0.a.t.c.g.b.c
    public void f(a.c cVar, b bVar) {
        if (a0.f44398b) {
            Log.d("GetLocationAction", "convert info : " + bVar.a());
        }
        CallbackHandler callbackHandler = this.f44566c;
        if (callbackHandler == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.f44178c, UnitedSchemeUtility.wrapCallbackParams(bVar.a(), 0).toString());
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f44566c = callbackHandler;
        if (eVar == null) {
            c.b("location", "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        a.c b2 = a.c.b(unitedSchemeEntity.getParam("params"));
        if (b2 != null && b2.a()) {
            if (TextUtils.isEmpty(b2.f44178c)) {
                c.b("location", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.R().g(context, "mapp_location", new C0812a(callbackHandler, b2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        c.b("location", "params is invalid");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
        return false;
    }

    public final void k(h<b.e> hVar, CallbackHandler callbackHandler, a.c cVar, boolean z) {
        c.g("GetLocationAction", "authorized result is " + hVar);
        if (d.a.h0.a.v1.c.c.h(hVar)) {
            d.a.h0.a.t.c.g.b.d().e(cVar, this, z);
            return;
        }
        int b2 = hVar.b();
        callbackHandler.handleSchemeDispatchCallback(cVar.f44178c, UnitedSchemeUtility.wrapCallbackParams(b2, d.a.h0.a.v1.c.c.f(b2)).toString());
    }
}
