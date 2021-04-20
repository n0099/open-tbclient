package d.b.g0.a.t1.k.i0.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.e;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f46790c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.t1.k.i0.a f46791d;

    /* renamed from: e  reason: collision with root package name */
    public e f46792e;

    /* renamed from: f  reason: collision with root package name */
    public String f46793f;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46794e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46795f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46796g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f46797h;
        public final /* synthetic */ d.b.g0.a.r1.e i;
        public final /* synthetic */ String j;

        public a(CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, d.b.g0.a.r1.e eVar, String str2) {
            this.f46794e = callbackHandler;
            this.f46795f = str;
            this.f46796g = jSONObject;
            this.f46797h = context;
            this.i = eVar;
            this.j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            if (eVar == null || eVar.f47163d) {
                FloatButton c2 = b.this.f46791d.c();
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                d.b.g0.a.v1.c.c.m(10005, this.f46794e, this.f46795f);
                h.q(10005, eVar);
            } else if (b.this.w(eVar, this.f46796g.optString("scheme"))) {
                b.this.f46792e = eVar;
                SwanAppActivity swanAppActivity = (SwanAppActivity) this.f46797h;
                b.this.f46791d = d.b.g0.a.t1.k.i0.a.d();
                if (b.this.f46791d.c() == null) {
                    b bVar = b.this;
                    bVar.f46790c = bVar.y(this.f46797h, this.f46796g);
                    b.this.x(this.f46795f, this.f46796g, this.f46794e, swanAppActivity);
                }
                this.i.H().h(this.j, Boolean.TRUE);
            } else {
                this.f46794e.handleSchemeDispatchCallback(this.f46795f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
            }
        }
    }

    /* renamed from: d.b.g0.a.t1.k.i0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0850b implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f46798a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46800c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46801d;

        public C0850b(Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f46798a = activity;
            this.f46799b = jSONObject;
            this.f46800c = callbackHandler;
            this.f46801d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            if (k0.C(this.f46798a, b.this.f46793f)) {
                String optString = this.f46799b.optString("scheme");
                b bVar = b.this;
                b.this.z(this.f46798a, optString, bVar.v(bVar.f46792e.i.get(0), optString), this.f46800c, this.f46801d);
                return;
            }
            try {
                String optString2 = this.f46799b.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", optString2);
                z = k0.f(this.f46798a, jSONObject.toString());
            } catch (JSONException e2) {
                if (a0.f46680b) {
                    e2.printStackTrace();
                }
                z = false;
            }
            this.f46800c.handleSchemeDispatchCallback(this.f46801d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46804f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46805g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46806h;

        public c(b bVar, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            this.f46803e = activity;
            this.f46804f = str;
            this.f46805g = callbackHandler;
            this.f46806h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            boolean O = k0.O(this.f46803e, this.f46804f);
            this.f46805g.handleSchemeDispatchCallback(this.f46806h, UnitedSchemeUtility.wrapCallbackParams(O ? 0 : 1001, O ? "open app success" : "open app fail").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46808f;

        public d(b bVar, CallbackHandler callbackHandler, String str) {
            this.f46807e = callbackHandler;
            this.f46808f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f46807e.handleSchemeDispatchCallback(this.f46808f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/showOpenAppGuide");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
            return false;
        } else {
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            String optString2 = a2.optString("name");
            this.f46793f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            d.b.g0.a.t1.k.i0.a d2 = d.b.g0.a.t1.k.i0.a.d();
            this.f46791d = d2;
            d2.i(this.f46793f);
            if (this.f46791d.c() != null) {
                this.f46790c = y(context, a2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
            b.a L = eVar.L();
            if (L != null && !TextUtils.isEmpty(L.S())) {
                eVar.R().e("mapp_open_external_app", new a(callbackHandler, optString, a2, context, eVar, L.S()));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
            return false;
        }
    }

    public final String v(String str, String str2) {
        String str3;
        String str4 = "";
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                str3 = "";
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        if (next.equals("slogan_base")) {
                            str4 = jSONObject.optString(next);
                        }
                        if (str2.contains(next)) {
                            str3 = jSONObject.optString(next);
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        if (a0.f46680b) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            return str4 + str3;
                        }
                        return null;
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                str3 = "";
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                return str4 + str3;
            }
        }
        return null;
    }

    public final boolean w(e eVar, String str) {
        if (eVar != null && !TextUtils.isEmpty(str)) {
            for (String str2 : eVar.f47167h) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void x(String str, JSONObject jSONObject, CallbackHandler callbackHandler, Activity activity) {
        if (callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f46790c.setDragImageListener(new C0850b(activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        this.f46791d.g((SwanAppActivity) context, jSONObject);
        return this.f46791d.f();
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        if (!(activity instanceof SwanAppActivity) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = activity.getString(d.b.g0.a.h.aiapps_ok);
        String string2 = activity.getString(d.b.g0.a.h.aiapps_cancel);
        g.a aVar = new g.a(activity);
        aVar.f(true);
        aVar.y(str2);
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.D(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
