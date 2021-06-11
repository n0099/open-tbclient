package d.a.l0.a.c2.f.i0.b;

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
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.f;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.h;
import d.a.l0.a.j2.k;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f44745c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.c2.f.i0.a f44746d;

    /* renamed from: e  reason: collision with root package name */
    public f f44747e;

    /* renamed from: f  reason: collision with root package name */
    public String f44748f;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44751g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f44752h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f44753i;
        public final /* synthetic */ String j;

        public a(CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, e eVar, String str2) {
            this.f44749e = callbackHandler;
            this.f44750f = str;
            this.f44751g = jSONObject;
            this.f44752h = context;
            this.f44753i = eVar;
            this.j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            if (fVar == null || fVar.f45373d) {
                FloatButton c2 = b.this.f44746d.c();
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                d.a.l0.a.e2.c.d.n(10005, this.f44749e, this.f44750f);
                k.p(10005, fVar);
            } else if (b.this.w(fVar, this.f44751g.optString("scheme"))) {
                b.this.f44747e = fVar;
                SwanAppActivity swanAppActivity = (SwanAppActivity) this.f44752h;
                b.this.f44746d = d.a.l0.a.c2.f.i0.a.d();
                if (b.this.f44746d.c() == null) {
                    b bVar = b.this;
                    bVar.f44745c = bVar.y(this.f44752h, this.f44751g);
                    b.this.x(this.f44750f, this.f44751g, this.f44749e, swanAppActivity);
                }
                this.f44753i.J().h(this.j, Boolean.TRUE);
            } else {
                this.f44749e.handleSchemeDispatchCallback(this.f44750f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
            }
        }
    }

    /* renamed from: d.a.l0.a.c2.f.i0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0639b implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f44754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44755b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44756c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44757d;

        public C0639b(Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f44754a = activity;
            this.f44755b = jSONObject;
            this.f44756c = callbackHandler;
            this.f44757d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            if (q0.F(this.f44754a, b.this.f44748f)) {
                String optString = this.f44755b.optString("scheme");
                b bVar = b.this;
                b.this.z(this.f44754a, optString, bVar.v(bVar.f44747e.f45378i.get(0), optString), this.f44756c, this.f44757d);
                return;
            }
            try {
                String optString2 = this.f44755b.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", optString2);
                z = q0.e(this.f44754a, jSONObject.toString());
            } catch (JSONException e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
                z = false;
            }
            this.f44756c.handleSchemeDispatchCallback(this.f44757d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44760f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44761g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44762h;

        public c(b bVar, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            this.f44759e = activity;
            this.f44760f = str;
            this.f44761g = callbackHandler;
            this.f44762h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            boolean T = q0.T(this.f44759e, this.f44760f);
            this.f44761g.handleSchemeDispatchCallback(this.f44762h, UnitedSchemeUtility.wrapCallbackParams(T ? 0 : 1001, T ? "open app success" : "open app fail").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44763e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44764f;

        public d(b bVar, CallbackHandler callbackHandler, String str) {
            this.f44763e = callbackHandler;
            this.f44764f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f44763e.handleSchemeDispatchCallback(this.f44764f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showOpenAppGuide");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
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
            this.f44748f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            d.a.l0.a.c2.f.i0.a d2 = d.a.l0.a.c2.f.i0.a.d();
            this.f44746d = d2;
            d2.i(this.f44748f);
            if (this.f44746d.c() != null) {
                this.f44745c = y(context, a2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
            b.a N = eVar.N();
            if (N != null && !TextUtils.isEmpty(N.T())) {
                eVar.T().e("mapp_open_external_app", new a(callbackHandler, optString, a2, context, eVar, N.T()));
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
                        if (a0.f44625b) {
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

    public final boolean w(f fVar, String str) {
        if (fVar != null && !TextUtils.isEmpty(str)) {
            for (String str2 : fVar.f45377h) {
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
        this.f44745c.setDragImageListener(new C0639b(activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        this.f44746d.g((SwanAppActivity) context, jSONObject);
        return this.f44746d.f();
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        if (!(activity instanceof SwanAppActivity) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = activity.getString(h.aiapps_confirm);
        String string2 = activity.getString(h.aiapps_cancel);
        h.a aVar = new h.a(activity);
        aVar.f(true);
        aVar.x(str2);
        aVar.n(new d.a.l0.a.w2.h.a());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.C(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
