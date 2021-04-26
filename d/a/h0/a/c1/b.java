package d.a.h0.a.c1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.c;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.z0.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41753e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f41755g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f41756h;

        public a(b bVar, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
            this.f41753e = callbackHandler;
            this.f41754f = str;
            this.f41755g = swanAppActionBar;
            this.f41756h = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f41753e, this.f41754f);
            } else if (this.f41755g.getRightMenu() == null) {
                this.f41753e.handleSchemeDispatchCallback(this.f41754f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                this.f41755g.setRightMenuAlpha(this.f41756h);
                this.f41753e.handleSchemeDispatchCallback(this.f41754f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* renamed from: d.a.h0.a.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0602b implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f41759g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f41760h;

        public C0602b(CallbackHandler callbackHandler, String str, boolean z, SwanAppActionBar swanAppActionBar) {
            this.f41757e = callbackHandler;
            this.f41758f = str;
            this.f41759g = z;
            this.f41760h = swanAppActionBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f41757e, this.f41758f);
                return;
            }
            if (this.f41759g) {
                b.this.p(this.f41760h);
            } else {
                b.this.m(this.f41760h);
            }
            this.f41757e.handleSchemeDispatchCallback(this.f41758f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/menu");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        return false;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (context != null && eVar != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.h0.a.c0.c.b(SupportMenuInflater.XML_MENU, "parameters are illegal");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            f V = f.V();
            if (V == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.h0.a.e0.l.f W = V.W();
            if (W == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.h0.a.e0.l.c m = W.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            SwanAppActionBar C1 = m.C1();
            if (C1 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            l(eVar, context, callbackHandler, optString, C1, optParamsAsJo, str);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b(SupportMenuInflater.XML_MENU, "parameters dismissed");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public final void l(e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2) {
        if (swanAppActionBar == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuEnabled")) {
            o(eVar, context, callbackHandler, str, swanAppActionBar, jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED, true));
        } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuOpacity")) {
            float optDouble = (float) jSONObject.optDouble("alpha", 1.0d);
            if (optDouble <= 1.0f && optDouble >= 0.1f) {
                n(eVar, context, callbackHandler, str, swanAppActionBar, optDouble);
                return;
            }
            d.a.h0.a.c0.c.b(SupportMenuInflater.XML_MENU, "The range of alpha should be in [0.1,1]");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } else {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final boolean m(SwanAppActionBar swanAppActionBar) {
        View rightMenu;
        if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
            return false;
        }
        rightMenu.setVisibility(4);
        swanAppActionBar.setRightMenuEnable(false);
        return true;
    }

    public final void n(e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
        eVar.R().g(context, "mapp_change_menu_appearance", new a(this, callbackHandler, str, swanAppActionBar, f2));
    }

    public final void o(e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, boolean z) {
        eVar.R().g(context, "scope_hide_menu", new C0602b(callbackHandler, str, z, swanAppActionBar));
    }

    public final boolean p(SwanAppActionBar swanAppActionBar) {
        View rightMenu;
        if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
            return false;
        }
        rightMenu.setVisibility(0);
        swanAppActionBar.setRightMenuEnable(true);
        return true;
    }
}
