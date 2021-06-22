package d.a.m0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.a1.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.j.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.m0.a.p0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0855a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47814f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47815g;

        public C0855a(CallbackHandler callbackHandler, String str, String str2) {
            this.f47813e = callbackHandler;
            this.f47814f = str;
            this.f47815g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                a.this.k(this.f47815g, this.f47814f, this.f47813e);
            } else {
                d.a.m0.a.e2.c.d.p(iVar, this.f47813e, this.f47814f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47817a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47818b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47819c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            this.f47817a = callbackHandler;
            this.f47818b = jSONObject;
            this.f47819c = str;
        }

        @Override // d.a.m0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.m0.a.a1.e.c
        public void onFailed() {
            if (this.f47817a == null) {
                d.a.m0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                d.a.m0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                d.a.m0.a.z1.b.f.e.f(d.a.m0.a.c1.a.b(), d.a.m0.a.h.aiapps_debug_extension_core_download_failed).F();
                this.f47818b.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f47817a.handleSchemeDispatchCallback(this.f47819c, UnitedSchemeUtility.wrapCallbackParams(this.f47818b, 1001).toString());
        }

        @Override // d.a.m0.a.a1.e.c
        public void onSuccess() {
            if (this.f47817a == null) {
                d.a.m0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                File c2 = d.a.m0.a.p0.f.c.c();
                File b2 = d.a.m0.a.p0.f.c.b();
                if (c2.exists() && d.a.m0.t.d.T(c2.getPath(), b2.getPath())) {
                    d.a.m0.a.e0.d.b("ExtCore-DebugDownload", "download success");
                    d.a.m0.a.z1.b.f.e.f(d.a.m0.a.c1.a.b(), d.a.m0.a.h.aiapps_debug_extension_core_download_success).F();
                    this.f47818b.put("status", 0);
                    this.f47817a.handleSchemeDispatchCallback(this.f47819c, UnitedSchemeUtility.wrapCallbackParams(this.f47818b, 0).toString());
                } else {
                    d.a.m0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                    d.a.m0.a.z1.b.f.e.f(d.a.m0.a.c1.a.b(), d.a.m0.a.h.aiapps_debug_extension_core_download_failed).F();
                    this.f47818b.put("status", -1);
                    this.f47817a.handleSchemeDispatchCallback(this.f47819c, UnitedSchemeUtility.wrapCallbackParams(this.f47818b, 1001).toString());
                }
            } catch (JSONException e2) {
                d.a.m0.a.e0.d.c("ExtCore-DebugDownload", "build result with exception", e2);
                e2.printStackTrace();
                this.f47817a.handleSchemeDispatchCallback(this.f47819c, UnitedSchemeUtility.wrapCallbackParams(this.f47818b, 1001).toString());
            }
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.m0.a.e0.d.b("ExtCore-DebugDownload", "params is null");
            d.a.m0.a.z1.b.f.e.f(context, d.a.m0.a.h.aiapps_debug_params_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = a2.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("ExtCore-DebugDownload", "url is null");
            d.a.m0.a.z1.b.f.e.f(context, d.a.m0.a.h.aiapps_debug_download_url_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = a2.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.m0.a.e0.d.b("ExtCore-DebugDownload", "cb is null");
            d.a.m0.a.z1.b.f.e.f(context, d.a.m0.a.h.aiapps_debug_extension_core_cb_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.T().g(context, "mapp_cts_debug", new C0855a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        d.a.m0.a.a1.e.G(str, new b(this, callbackHandler, new JSONObject(), str2));
    }
}
