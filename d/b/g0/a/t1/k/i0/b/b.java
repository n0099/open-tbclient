package d.b.g0.a.t1.k.i0.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
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
/* loaded from: classes2.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f46398c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.t1.k.i0.a f46399d;

    /* renamed from: e  reason: collision with root package name */
    public e f46400e;

    /* renamed from: f  reason: collision with root package name */
    public String f46401f;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46403f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46404g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f46405h;
        public final /* synthetic */ d.b.g0.a.r1.e i;
        public final /* synthetic */ String j;

        public a(CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, d.b.g0.a.r1.e eVar, String str2) {
            this.f46402e = callbackHandler;
            this.f46403f = str;
            this.f46404g = jSONObject;
            this.f46405h = context;
            this.i = eVar;
            this.j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            if (eVar == null || eVar.f46771d) {
                FloatButton c2 = b.this.f46399d.c();
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                d.b.g0.a.v1.c.c.m(10005, this.f46402e, this.f46403f);
                h.q(10005, eVar);
            } else if (b.this.w(eVar, this.f46404g.optString("scheme"))) {
                b.this.f46400e = eVar;
                SwanAppActivity swanAppActivity = (SwanAppActivity) this.f46405h;
                b.this.f46399d = d.b.g0.a.t1.k.i0.a.d();
                if (b.this.f46399d.c() == null) {
                    b bVar = b.this;
                    bVar.f46398c = bVar.y(this.f46405h, this.f46404g);
                    b.this.x(this.f46403f, this.f46404g, this.f46402e, swanAppActivity);
                }
                this.i.H().h(this.j, Boolean.TRUE);
            } else {
                this.f46402e.handleSchemeDispatchCallback(this.f46403f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
            }
        }
    }

    /* renamed from: d.b.g0.a.t1.k.i0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0838b implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f46406a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46407b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46408c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46409d;

        public C0838b(Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            this.f46406a = activity;
            this.f46407b = jSONObject;
            this.f46408c = callbackHandler;
            this.f46409d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            if (k0.C(this.f46406a, b.this.f46401f)) {
                String optString = this.f46407b.optString("scheme");
                b bVar = b.this;
                b.this.z(this.f46406a, optString, bVar.v(bVar.f46400e.i.get(0), optString), this.f46408c, this.f46409d);
                return;
            }
            try {
                String optString2 = this.f46407b.optString("downloadUrl");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", optString2);
                z = k0.f(this.f46406a, jSONObject.toString());
            } catch (JSONException e2) {
                if (a0.f46288b) {
                    e2.printStackTrace();
                }
                z = false;
            }
            this.f46408c.handleSchemeDispatchCallback(this.f46409d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46413g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46414h;

        public c(b bVar, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            this.f46411e = activity;
            this.f46412f = str;
            this.f46413g = callbackHandler;
            this.f46414h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            boolean O = k0.O(this.f46411e, this.f46412f);
            this.f46413g.handleSchemeDispatchCallback(this.f46414h, UnitedSchemeUtility.wrapCallbackParams(O ? 0 : 1001, O ? "open app success" : "open app fail").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46416f;

        public d(b bVar, CallbackHandler callbackHandler, String str) {
            this.f46415e = callbackHandler;
            this.f46416f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f46415e.handleSchemeDispatchCallback(this.f46416f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
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
            this.f46401f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            d.b.g0.a.t1.k.i0.a d2 = d.b.g0.a.t1.k.i0.a.d();
            this.f46399d = d2;
            d2.i(this.f46401f);
            if (this.f46399d.c() != null) {
                this.f46398c = y(context, a2);
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
                        if (a0.f46288b) {
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
            for (String str2 : eVar.f46775h) {
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
        this.f46398c.setDragImageListener(new C0838b(activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        this.f46399d.g((SwanAppActivity) context, jSONObject);
        return this.f46399d.f();
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
