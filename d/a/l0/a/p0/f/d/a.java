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
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.p0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0796a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44031e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44032f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44033g;

        public C0796a(CallbackHandler callbackHandler, String str, String str2) {
            this.f44031e = callbackHandler;
            this.f44032f = str;
            this.f44033g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                a.this.k(this.f44033g, this.f44032f, this.f44031e);
            } else {
                d.a.l0.a.e2.c.d.p(iVar, this.f44031e, this.f44032f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44035a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44036b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44037c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            this.f44035a = callbackHandler;
            this.f44036b = jSONObject;
            this.f44037c = str;
        }

        @Override // d.a.l0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.l0.a.a1.e.c
        public void onFailed() {
            if (this.f44035a == null) {
                d.a.l0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_extension_core_download_failed).F();
                this.f44036b.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f44035a.handleSchemeDispatchCallback(this.f44037c, UnitedSchemeUtility.wrapCallbackParams(this.f44036b, 1001).toString());
        }

        @Override // d.a.l0.a.a1.e.c
        public void onSuccess() {
            if (this.f44035a == null) {
                d.a.l0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                File c2 = d.a.l0.a.p0.f.c.c();
                File b2 = d.a.l0.a.p0.f.c.b();
                if (c2.exists() && d.a.l0.t.d.T(c2.getPath(), b2.getPath())) {
                    d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "download success");
                    d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_extension_core_download_success).F();
                    this.f44036b.put("status", 0);
                    this.f44035a.handleSchemeDispatchCallback(this.f44037c, UnitedSchemeUtility.wrapCallbackParams(this.f44036b, 0).toString());
                } else {
                    d.a.l0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                    d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_extension_core_download_failed).F();
                    this.f44036b.put("status", -1);
                    this.f44035a.handleSchemeDispatchCallback(this.f44037c, UnitedSchemeUtility.wrapCallbackParams(this.f44036b, 1001).toString());
                }
            } catch (JSONException e2) {
                d.a.l0.a.e0.d.c("ExtCore-DebugDownload", "build result with exception", e2);
                e2.printStackTrace();
                this.f44035a.handleSchemeDispatchCallback(this.f44037c, UnitedSchemeUtility.wrapCallbackParams(this.f44036b, 1001).toString());
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
        eVar.T().g(context, "mapp_cts_debug", new C0796a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        d.a.l0.a.a1.e.G(str, new b(this, callbackHandler, new JSONObject(), str2));
    }
}
