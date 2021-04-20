package d.b.g0.a.c1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.c;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.a.z0.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f44136g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f44137h;

        public a(b bVar, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
            this.f44134e = callbackHandler;
            this.f44135f = str;
            this.f44136g = swanAppActionBar;
            this.f44137h = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f44134e, this.f44135f);
            } else if (this.f44136g.getRightMenu() == null) {
                this.f44134e.handleSchemeDispatchCallback(this.f44135f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                this.f44136g.setRightMenuAlpha(this.f44137h);
                this.f44134e.handleSchemeDispatchCallback(this.f44135f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* renamed from: d.b.g0.a.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0643b implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44139f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44140g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f44141h;

        public C0643b(CallbackHandler callbackHandler, String str, boolean z, SwanAppActionBar swanAppActionBar) {
            this.f44138e = callbackHandler;
            this.f44139f = str;
            this.f44140g = z;
            this.f44141h = swanAppActionBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f44138e, this.f44139f);
                return;
            }
            if (this.f44140g) {
                b.this.p(this.f44141h);
            } else {
                b.this.m(this.f44141h);
            }
            this.f44138e.handleSchemeDispatchCallback(this.f44139f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/menu");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        return false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (context != null && eVar != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b(SupportMenuInflater.XML_MENU, "parameters are illegal");
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
            d.b.g0.a.e0.l.f W = V.W();
            if (W == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.b.g0.a.e0.l.c m = W.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            SwanAppActionBar D1 = m.D1();
            if (D1 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            l(eVar, context, callbackHandler, optString, D1, optParamsAsJo, str);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b(SupportMenuInflater.XML_MENU, "parameters dismissed");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public final void l(e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2) {
        if (swanAppActionBar == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuEnabled")) {
            o(eVar, context, callbackHandler, str, swanAppActionBar, jSONObject.optBoolean(SapiOptions.t, true));
        } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuOpacity")) {
            float optDouble = (float) jSONObject.optDouble("alpha", 1.0d);
            if (optDouble <= 1.0f && optDouble >= 0.1f) {
                n(eVar, context, callbackHandler, str, swanAppActionBar, optDouble);
                return;
            }
            d.b.g0.a.c0.c.b(SupportMenuInflater.XML_MENU, "The range of alpha should be in [0.1,1]");
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
        eVar.R().g(context, "scope_hide_menu", new C0643b(callbackHandler, str, z, swanAppActionBar));
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
