package d.b.g0.a.b1.f.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.c;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.a.z0.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.a.b1.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0621a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43873f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.f.b f43874g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43875h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ d.b.g0.a.b1.f.a j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        public C0621a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.b1.f.b bVar, String str, Context context, d.b.g0.a.b1.f.a aVar, String str2, e eVar) {
            this.f43872e = callbackHandler;
            this.f43873f = unitedSchemeEntity;
            this.f43874g = bVar;
            this.f43875h = str;
            this.i = context;
            this.j = aVar;
            this.k = str2;
            this.l = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.n(hVar, this.f43872e, this.f43873f);
                int b2 = hVar == null ? 10001 : hVar.b();
                a.this.o(this.f43874g, b2, c.f(b2));
            } else if (d.b.g0.a.b1.f.e.a.k().q(this.f43875h)) {
                a.this.o(this.f43874g, 2001, "error execute time");
                d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
            } else {
                a.this.r(this.i, this.f43873f, this.f43872e, this.f43875h, this.j, this.f43874g, this.k, this.l.f46132f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43877b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43878c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f43879d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.f.a f43880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.f.b f43881f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43882g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43883h;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.b.g0.a.b1.f.a aVar, d.b.g0.a.b1.f.b bVar, String str2, String str3) {
            this.f43876a = callbackHandler;
            this.f43877b = unitedSchemeEntity;
            this.f43878c = str;
            this.f43879d = context;
            this.f43880e = aVar;
            this.f43881f = bVar;
            this.f43882g = str2;
            this.f43883h = str3;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46680b) {
                Log.d("AudioRecordAction", str + "");
            }
            a.this.p(this.f43876a, this.f43877b, this.f43878c, this.f43879d, this.f43880e, this.f43881f, this.f43882g, this.f43883h);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            if (a0.f46680b) {
                Log.d("AudioRecordAction", str + "");
            }
            d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
            a.this.o(this.f43881f, 10005, "system deny");
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/recorder");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f46680b) {
            Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46680b) {
            Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46680b) {
                Log.d("AudioRecordAction", "record --- illegal swanApp");
            }
            return false;
        }
        if (eVar.Z()) {
            if (a0.f46680b) {
                Log.d("AudioRecordAction", "AudioRecordAction does not supported when app is invisible.");
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -944894266) {
                if (hashCode == 731105865 && str.equals("/swanAPI/recorder/resume")) {
                    c2 = 1;
                }
            } else if (str.equals("/swanAPI/recorder/start")) {
                c2 = 0;
            }
            if (c2 == 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (c2 == 1) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
        }
        if (TextUtils.isEmpty(eVar.f46132f)) {
            d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (a0.f46680b) {
                Log.d("AudioRecordAction", "record --- none swanApp id");
            }
            return false;
        } else if (d.b.g0.a.b1.f.e.a.k().p(str)) {
            JSONObject q = q(unitedSchemeEntity.getParam("params"));
            if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            d.b.g0.a.b1.f.a a2 = d.b.g0.a.b1.f.a.a(q, d.b.g0.a.b1.f.e.a.k().j());
            if (a2 == null) {
                d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            JSONObject c3 = a2.c();
            if (c3 != null) {
                d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                unitedSchemeEntity.result = c3;
                return false;
            }
            d.b.g0.a.b1.f.b a3 = d.b.g0.a.b1.f.b.a(callbackHandler, unitedSchemeEntity, a2.f43863g, d.b.g0.a.b1.f.e.a.k().i());
            String h2 = d.b.g0.a.a2.b.h(eVar.f46132f);
            if (TextUtils.isEmpty(h2)) {
                d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.b.g0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                return false;
            } else {
                eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0621a(callbackHandler, unitedSchemeEntity, a3, str, context, a2, h2, eVar));
                if (a0.f46680b) {
                    Log.d("AudioRecordAction", "subAction is : " + str);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        } else {
            return false;
        }
    }

    public final void o(d.b.g0.a.b1.f.b bVar, int i, String str) {
        if (bVar != null && !TextUtils.isEmpty(d.b.g0.a.b1.f.b.f43869h)) {
            bVar.d(i, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            f.V().N(new d.b.g0.a.k0.b.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.b.g0.a.c0.c.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.b.g0.a.b1.f.a aVar, d.b.g0.a.b1.f.b bVar, String str2, String str3) {
        char c2;
        switch (str.hashCode()) {
            case -948211622:
                if (str.equals("/swanAPI/recorder/pause")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -944894266:
                if (str.equals("/swanAPI/recorder/start")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 731105865:
                if (str.equals("/swanAPI/recorder/resume")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 2047729950:
                if (str.equals("/swanAPI/recorder/stop")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            u(context, aVar, bVar, str2, str3);
        } else if (c2 == 1) {
            d.b.g0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
            s();
        } else if (c2 == 2) {
            d.b.g0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
            t();
        } else if (c2 != 3) {
        } else {
            d.b.g0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
            v();
        }
    }

    public final JSONObject q(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (a0.f46680b) {
                    Log.d("AudioRecordAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.b.g0.a.b1.f.a aVar, d.b.g0.a.b1.f.b bVar, String str2, String str3) {
        d.b.g0.a.k1.a.c(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
    }

    public final void s() {
        d.b.g0.a.b1.f.e.a.k().t();
    }

    public final void t() {
        d.b.g0.a.b1.f.e.a.k().A();
    }

    public final void u(Context context, d.b.g0.a.b1.f.a aVar, d.b.g0.a.b1.f.b bVar, String str, String str2) {
        d.b.g0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
        d.b.g0.a.b1.f.e.a.k().l(str, aVar, context, bVar, str2);
        d.b.g0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.START);
        d.b.g0.a.b1.f.e.a.k().D(true);
    }

    public final void v() {
        d.b.g0.a.b1.f.e.a.k().F();
        d.b.g0.a.b1.f.e.a.x();
    }
}
