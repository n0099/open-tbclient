package d.b.h0.a.b1.f.c;

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
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.c;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.z0.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.b1.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0641a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44202f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.f.b f44203g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44204h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ d.b.h0.a.b1.f.a j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        public C0641a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.h0.a.b1.f.b bVar, String str, Context context, d.b.h0.a.b1.f.a aVar, String str2, e eVar) {
            this.f44201e = callbackHandler;
            this.f44202f = unitedSchemeEntity;
            this.f44203g = bVar;
            this.f44204h = str;
            this.i = context;
            this.j = aVar;
            this.k = str2;
            this.l = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.n(hVar, this.f44201e, this.f44202f);
                int b2 = hVar == null ? 10001 : hVar.b();
                a.this.o(this.f44203g, b2, c.f(b2));
            } else if (d.b.h0.a.b1.f.e.a.k().q(this.f44204h)) {
                a.this.o(this.f44203g, 2001, "error execute time");
                d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
            } else {
                a.this.r(this.i, this.f44202f, this.f44201e, this.f44204h, this.j, this.f44203g, this.k, this.l.f46461f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44207c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f44208d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.f.a f44209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.f.b f44210f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44211g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44212h;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.b.h0.a.b1.f.a aVar, d.b.h0.a.b1.f.b bVar, String str2, String str3) {
            this.f44205a = callbackHandler;
            this.f44206b = unitedSchemeEntity;
            this.f44207c = str;
            this.f44208d = context;
            this.f44209e = aVar;
            this.f44210f = bVar;
            this.f44211g = str2;
            this.f44212h = str3;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (a0.f47009b) {
                Log.d("AudioRecordAction", str + "");
            }
            a.this.p(this.f44205a, this.f44206b, this.f44207c, this.f44208d, this.f44209e, this.f44210f, this.f44211g, this.f44212h);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            if (a0.f47009b) {
                Log.d("AudioRecordAction", str + "");
            }
            d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
            a.this.o(this.f44210f, 10005, "system deny");
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/recorder");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f47009b) {
            Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f47009b) {
            Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f47009b) {
                Log.d("AudioRecordAction", "record --- illegal swanApp");
            }
            return false;
        }
        if (eVar.Z()) {
            if (a0.f47009b) {
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
        if (TextUtils.isEmpty(eVar.f46461f)) {
            d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (a0.f47009b) {
                Log.d("AudioRecordAction", "record --- none swanApp id");
            }
            return false;
        } else if (d.b.h0.a.b1.f.e.a.k().p(str)) {
            JSONObject q = q(unitedSchemeEntity.getParam("params"));
            if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            d.b.h0.a.b1.f.a a2 = d.b.h0.a.b1.f.a.a(q, d.b.h0.a.b1.f.e.a.k().j());
            if (a2 == null) {
                d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            JSONObject c3 = a2.c();
            if (c3 != null) {
                d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                unitedSchemeEntity.result = c3;
                return false;
            }
            d.b.h0.a.b1.f.b a3 = d.b.h0.a.b1.f.b.a(callbackHandler, unitedSchemeEntity, a2.f44192g, d.b.h0.a.b1.f.e.a.k().i());
            String h2 = d.b.h0.a.a2.b.h(eVar.f46461f);
            if (TextUtils.isEmpty(h2)) {
                d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.b.h0.a.c0.c.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                return false;
            } else {
                eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0641a(callbackHandler, unitedSchemeEntity, a3, str, context, a2, h2, eVar));
                if (a0.f47009b) {
                    Log.d("AudioRecordAction", "subAction is : " + str);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        } else {
            return false;
        }
    }

    public final void o(d.b.h0.a.b1.f.b bVar, int i, String str) {
        if (bVar != null && !TextUtils.isEmpty(d.b.h0.a.b1.f.b.f44198h)) {
            bVar.d(i, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            f.V().N(new d.b.h0.a.k0.b.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.b.h0.a.c0.c.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.b.h0.a.b1.f.a aVar, d.b.h0.a.b1.f.b bVar, String str2, String str3) {
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
            d.b.h0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
            s();
        } else if (c2 == 2) {
            d.b.h0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
            t();
        } else if (c2 != 3) {
        } else {
            d.b.h0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
            v();
        }
    }

    public final JSONObject q(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (a0.f47009b) {
                    Log.d("AudioRecordAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.b.h0.a.b1.f.a aVar, d.b.h0.a.b1.f.b bVar, String str2, String str3) {
        d.b.h0.a.k1.a.c(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
    }

    public final void s() {
        d.b.h0.a.b1.f.e.a.k().t();
    }

    public final void t() {
        d.b.h0.a.b1.f.e.a.k().A();
    }

    public final void u(Context context, d.b.h0.a.b1.f.a aVar, d.b.h0.a.b1.f.b bVar, String str, String str2) {
        d.b.h0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
        d.b.h0.a.b1.f.e.a.k().l(str, aVar, context, bVar, str2);
        d.b.h0.a.c0.c.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.START);
        d.b.h0.a.b1.f.e.a.k().D(true);
    }

    public final void v() {
        d.b.h0.a.b1.f.e.a.k().F();
        d.b.h0.a.b1.f.e.a.x();
    }
}
