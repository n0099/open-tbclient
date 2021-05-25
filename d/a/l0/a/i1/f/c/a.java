package d.a.l0.a.i1.f.c;

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
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.d;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.s1.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.i1.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0714a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.f.b f42928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42929h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f42930i;
        public final /* synthetic */ d.a.l0.a.i1.f.a j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        public C0714a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.i1.f.b bVar, String str, Context context, d.a.l0.a.i1.f.a aVar, String str2, e eVar) {
            this.f42926e = callbackHandler;
            this.f42927f = unitedSchemeEntity;
            this.f42928g = bVar;
            this.f42929h = str;
            this.f42930i = context;
            this.j = aVar;
            this.k = str2;
            this.l = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.h(iVar)) {
                d.o(iVar, this.f42926e, this.f42927f);
                int b2 = iVar == null ? 10001 : iVar.b();
                a.this.o(this.f42928g, b2, d.f(b2));
            } else if (d.a.l0.a.i1.f.e.a.k().q(this.f42929h)) {
                a.this.o(this.f42928g, 2001, "error execute time");
                d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
            } else {
                a.this.r(this.f42930i, this.f42927f, this.f42926e, this.f42929h, this.j, this.f42928g, this.k, this.l.f40749f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42933c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f42934d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.f.a f42935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.f.b f42936f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f42937g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42938h;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.a.l0.a.i1.f.a aVar, d.a.l0.a.i1.f.b bVar, String str2, String str3) {
            this.f42931a = callbackHandler;
            this.f42932b = unitedSchemeEntity;
            this.f42933c = str;
            this.f42934d = context;
            this.f42935e = aVar;
            this.f42936f = bVar;
            this.f42937g = str2;
            this.f42938h = str3;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f40949b) {
                Log.d("AudioRecordAction", str + "");
            }
            a.this.p(this.f42931a, this.f42932b, this.f42933c, this.f42934d, this.f42935e, this.f42936f, this.f42937g, this.f42938h);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            if (a0.f40949b) {
                Log.d("AudioRecordAction", str + "");
            }
            d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
            a.this.o(this.f42936f, 10005, "system deny");
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/recorder");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f40949b) {
            Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f40949b) {
            Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f40949b) {
                Log.d("AudioRecordAction", "record --- illegal swanApp");
            }
            return false;
        }
        if (eVar.d0()) {
            if (a0.f40949b) {
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
        if (TextUtils.isEmpty(eVar.f40749f)) {
            d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (a0.f40949b) {
                Log.d("AudioRecordAction", "record --- none swanApp id");
            }
            return false;
        } else if (d.a.l0.a.i1.f.e.a.k().p(str)) {
            JSONObject q = q(unitedSchemeEntity.getParam("params"));
            if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            d.a.l0.a.i1.f.a a2 = d.a.l0.a.i1.f.a.a(q, d.a.l0.a.i1.f.e.a.k().j());
            if (a2 == null) {
                d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            JSONObject c3 = a2.c();
            if (c3 != null) {
                d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                unitedSchemeEntity.result = c3;
                return false;
            }
            d.a.l0.a.i1.f.b a3 = d.a.l0.a.i1.f.b.a(callbackHandler, unitedSchemeEntity, a2.f42916g, d.a.l0.a.i1.f.e.a.k().i());
            String x = d.a.l0.a.k2.b.x(eVar.f40749f);
            if (TextUtils.isEmpty(x)) {
                d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.l0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                return false;
            } else {
                eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0714a(callbackHandler, unitedSchemeEntity, a3, str, context, a2, x, eVar));
                if (a0.f40949b) {
                    Log.d("AudioRecordAction", "subAction is : " + str);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        } else {
            return false;
        }
    }

    public final void o(d.a.l0.a.i1.f.b bVar, int i2, String str) {
        if (bVar != null && !TextUtils.isEmpty(d.a.l0.a.i1.f.b.f42922h)) {
            bVar.d(i2, str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, i2);
            jSONObject.put("errMsg", str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("recorderError", hashMap));
        } catch (JSONException e2) {
            d.a.l0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.a.l0.a.i1.f.a aVar, d.a.l0.a.i1.f.b bVar, String str2, String str3) {
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
            d.a.l0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
            s();
        } else if (c2 == 2) {
            d.a.l0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
            t();
        } else if (c2 != 3) {
        } else {
            d.a.l0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
            v();
        }
    }

    public final JSONObject q(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (a0.f40949b) {
                    Log.d("AudioRecordAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.i1.f.a aVar, d.a.l0.a.i1.f.b bVar, String str2, String str3) {
        d.a.l0.a.s1.e.g(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
    }

    public final void s() {
        d.a.l0.a.i1.f.e.a.k().t();
    }

    public final void t() {
        d.a.l0.a.i1.f.e.a.k().A();
    }

    public final void u(Context context, d.a.l0.a.i1.f.a aVar, d.a.l0.a.i1.f.b bVar, String str, String str2) {
        d.a.l0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
        d.a.l0.a.i1.f.e.a.k().l(str, aVar, context, bVar, str2);
        d.a.l0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.START);
        d.a.l0.a.i1.f.e.a.k().D(true);
    }

    public final void v() {
        d.a.l0.a.i1.f.e.a.k().F();
        d.a.l0.a.i1.f.e.a.x();
    }
}
