package d.a.m0.a.j1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.d;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46860f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f46861g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f46862h;

        public a(c cVar, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
            this.f46859e = callbackHandler;
            this.f46860f = str;
            this.f46861g = swanAppActionBar;
            this.f46862h = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.h(iVar)) {
                d.p(iVar, this.f46859e, this.f46860f);
            } else if (this.f46861g.getRightMenu() == null) {
                this.f46859e.handleSchemeDispatchCallback(this.f46860f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                this.f46861g.setRightMenuAlpha(this.f46862h);
                this.f46859e.handleSchemeDispatchCallback(this.f46860f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46864f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46865g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f46866h;

        public b(CallbackHandler callbackHandler, String str, boolean z, SwanAppActionBar swanAppActionBar) {
            this.f46863e = callbackHandler;
            this.f46864f = str;
            this.f46865g = z;
            this.f46866h = swanAppActionBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.h(iVar)) {
                d.p(iVar, this.f46863e, this.f46864f);
                return;
            }
            if (this.f46865g) {
                c.this.p(this.f46866h);
            } else {
                c.this.m(this.f46866h);
            }
            this.f46863e.handleSchemeDispatchCallback(this.f46864f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public c(e eVar) {
        super(eVar, "/swanAPI/menu");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        return false;
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.m0.a.a2.e eVar) {
        if (context != null && eVar != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b(SupportMenuInflater.XML_MENU, "parameters are illegal");
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
            g W = V.W();
            if (W == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.m0.a.h0.g.d m = W.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            SwanAppActionBar H1 = m.H1();
            if (H1 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            l(eVar, context, callbackHandler, optString, H1, optParamsAsJo, str);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.m0.a.e0.d.b(SupportMenuInflater.XML_MENU, "parameters dismissed");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public final void l(d.a.m0.a.a2.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2) {
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
            d.a.m0.a.e0.d.b(SupportMenuInflater.XML_MENU, "The range of alpha should be in [0.1,1]");
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

    public final void n(d.a.m0.a.a2.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
        eVar.T().g(context, "mapp_change_menu_appearance", new a(this, callbackHandler, str, swanAppActionBar, f2));
    }

    public final void o(d.a.m0.a.a2.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, boolean z) {
        eVar.T().g(context, "scope_hide_menu", new b(callbackHandler, str, z, swanAppActionBar));
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
