package d.a.l0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.a1.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.p0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0852a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47707g;

        public C0852a(CallbackHandler callbackHandler, String str, String str2) {
            this.f47705e = callbackHandler;
            this.f47706f = str;
            this.f47707g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                a.this.k(this.f47707g, this.f47706f, this.f47705e);
            } else {
                d.a.l0.a.e2.c.d.p(iVar, this.f47705e, this.f47706f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47709a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47710b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47711c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            this.f47709a = callbackHandler;
            this.f47710b = jSONObject;
            this.f47711c = str;
        }

        @Override // d.a.l0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.l0.a.a1.e.c
        public void onFailed() {
            if (this.f47709a == null) {
                d.a.l0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_extension_core_download_failed).F();
                this.f47710b.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f47709a.handleSchemeDispatchCallback(this.f47711c, UnitedSchemeUtility.wrapCallbackParams(this.f47710b, 1001).toString());
        }

        @Override // d.a.l0.a.a1.e.c
        public void onSuccess() {
            if (this.f47709a == null) {
                d.a.l0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                File c2 = d.a.l0.a.p0.f.c.c();
                File b2 = d.a.l0.a.p0.f.c.b();
                if (c2.exists() && d.a.l0.t.d.T(c2.getPath(), b2.getPath())) {
                    d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "download success");
                    d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_extension_core_download_success).F();
                    this.f47710b.put("status", 0);
                    this.f47709a.handleSchemeDispatchCallback(this.f47711c, UnitedSchemeUtility.wrapCallbackParams(this.f47710b, 0).toString());
                } else {
                    d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                    d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_extension_core_download_failed).F();
                    this.f47710b.put("status", -1);
                    this.f47709a.handleSchemeDispatchCallback(this.f47711c, UnitedSchemeUtility.wrapCallbackParams(this.f47710b, 1001).toString());
                }
            } catch (JSONException e2) {
                d.a.l0.a.e0.d.c("ExtCore-DebugDownload", "build result with exception", e2);
                e2.printStackTrace();
                this.f47709a.handleSchemeDispatchCallback(this.f47711c, UnitedSchemeUtility.wrapCallbackParams(this.f47710b, 1001).toString());
            }
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "params is null");
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_debug_params_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = a2.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "url is null");
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_debug_download_url_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = a2.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "cb is null");
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_debug_extension_core_cb_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.T().g(context, "mapp_cts_debug", new C0852a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        d.a.l0.a.a1.e.G(str, new b(this, callbackHandler, new JSONObject(), str2));
    }
}
