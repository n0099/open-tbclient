package d.a.h0.a.t1.k.i0.b;

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
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.e;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f44514c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.t1.k.i0.a f44515d;

    /* renamed from: e  reason: collision with root package name */
    public e f44516e;

    /* renamed from: f  reason: collision with root package name */
    public String f44517f;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44519f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44520g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f44521h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44522i;
        public final /* synthetic */ String j;

        public a(CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, d.a.h0.a.r1.e eVar, String str2) {
            this.f44518e = callbackHandler;
            this.f44519f = str;
            this.f44520g = jSONObject;
            this.f44521h = context;
            this.f44522i = eVar;
            this.j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            if (eVar == null || eVar.f44913d) {
                FloatButton c2 = b.this.f44515d.c();
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                d.a.h0.a.v1.c.c.m(10005, this.f44518e, this.f44519f);
                h.q(10005, eVar);
            } else if (b.this.w(eVar, this.f44520g.optString("scheme"))) {
                b.this.f44516e = eVar;
                SwanAppActivity swanAppActivity = (SwanAppActivity) this.f44521h;
                b.this.f44515d = d.a.h0.a.t1.k.i0.a.d();
                if (b.this.f44515d.c() == null) {
                    b bVar = b.this;
                    bVar.f44514c = bVar.y(this.f44521h, this.f44520g);
                    b.this.x(this.f44519f, this.f44520g, this.f44518e, swanAppActivity);
                }
                this.f44522i.H().h(this.j, Boolean.TRUE);
            } else {
                this.f44518e.handleSchemeDispatchCallback(this.f44519f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
            }
        }
    }

    /* renamed from: d.a.h0.a.t1.k.i0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0809b implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f44523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44525c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44526d;

        public C0809b(Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f44523a = activity;
            this.f44524b = jSONObject;
            this.f44525c = callbackHandler;
            this.f44526d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            if (k0.C(this.f44523a, b.this.f44517f)) {
                String optString = this.f44524b.optString("scheme");
                b bVar = b.this;
                b.this.z(this.f44523a, optString, bVar.v(bVar.f44516e.f44918i.get(0), optString), this.f44525c, this.f44526d);
                return;
            }
            try {
                String optString2 = this.f44524b.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", optString2);
                z = k0.f(this.f44523a, jSONObject.toString());
            } catch (JSONException e2) {
                if (a0.f44398b) {
                    e2.printStackTrace();
                }
                z = false;
            }
            this.f44525c.handleSchemeDispatchCallback(this.f44526d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44529f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44530g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44531h;

        public c(b bVar, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            this.f44528e = activity;
            this.f44529f = str;
            this.f44530g = callbackHandler;
            this.f44531h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            boolean O = k0.O(this.f44528e, this.f44529f);
            this.f44530g.handleSchemeDispatchCallback(this.f44531h, UnitedSchemeUtility.wrapCallbackParams(O ? 0 : 1001, O ? "open app success" : "open app fail").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44532e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44533f;

        public d(b bVar, CallbackHandler callbackHandler, String str) {
            this.f44532e = callbackHandler;
            this.f44533f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f44532e.handleSchemeDispatchCallback(this.f44533f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/showOpenAppGuide");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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
            this.f44517f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            d.a.h0.a.t1.k.i0.a d2 = d.a.h0.a.t1.k.i0.a.d();
            this.f44515d = d2;
            d2.i(this.f44517f);
            if (this.f44515d.c() != null) {
                this.f44514c = y(context, a2);
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
                        if (a0.f44398b) {
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
            for (String str2 : eVar.f44917h) {
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
        this.f44514c.setDragImageListener(new C0809b(activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        this.f44515d.g((SwanAppActivity) context, jSONObject);
        return this.f44515d.f();
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        if (!(activity instanceof SwanAppActivity) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = activity.getString(d.a.h0.a.h.aiapps_ok);
        String string2 = activity.getString(d.a.h0.a.h.aiapps_cancel);
        g.a aVar = new g.a(activity);
        aVar.f(true);
        aVar.y(str2);
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.D(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
