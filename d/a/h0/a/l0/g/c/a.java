package d.a.h0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.u0.d;
import d.a.h0.a.v1.c.i.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.l0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0695a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43149f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43150g;

        public C0695a(CallbackHandler callbackHandler, String str, String str2) {
            this.f43148e = callbackHandler;
            this.f43149f = str;
            this.f43150g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                a.this.k(this.f43150g, this.f43149f, this.f43148e);
            } else {
                d.a.h0.a.v1.c.c.o(hVar, this.f43148e, this.f43149f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43152a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43153b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43154c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            this.f43152a = callbackHandler;
            this.f43153b = jSONObject;
            this.f43154c = str;
        }

        @Override // d.a.h0.a.u0.d.c
        public void a(int i2) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void onFailed() {
            if (this.f43152a == null) {
                d.a.h0.a.c0.c.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                d.a.h0.a.c0.c.b("ExtCore-DebugDownload", "download failed");
                d.a.h0.a.q1.b.f.d.e(d.a.h0.a.w0.a.c(), d.a.h0.a.h.aiapps_debug_extension_core_download_failed).C();
                this.f43153b.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f43152a.handleSchemeDispatchCallback(this.f43154c, UnitedSchemeUtility.wrapCallbackParams(this.f43153b, 1001).toString());
        }

        @Override // d.a.h0.a.u0.d.c
        public void onSuccess() {
            if (this.f43152a == null) {
                d.a.h0.a.c0.c.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                File c2 = d.a.h0.a.l0.g.b.c();
                File b2 = d.a.h0.a.l0.g.b.b();
                if (c2.exists() && d.a.h0.p.d.F(c2.getPath(), b2.getPath())) {
                    d.a.h0.a.c0.c.b("ExtCore-DebugDownload", "download success");
                    d.a.h0.a.q1.b.f.d.e(d.a.h0.a.w0.a.c(), d.a.h0.a.h.aiapps_debug_extension_core_download_success).C();
                    this.f43153b.put("status", 0);
                    this.f43152a.handleSchemeDispatchCallback(this.f43154c, UnitedSchemeUtility.wrapCallbackParams(this.f43153b, 0).toString());
                } else {
                    d.a.h0.a.c0.c.b("ExtCore-DebugDownload", "download failed");
                    d.a.h0.a.q1.b.f.d.e(d.a.h0.a.w0.a.c(), d.a.h0.a.h.aiapps_debug_extension_core_download_failed).C();
                    this.f43153b.put("status", -1);
                    this.f43152a.handleSchemeDispatchCallback(this.f43154c, UnitedSchemeUtility.wrapCallbackParams(this.f43153b, 1001).toString());
                }
            } catch (JSONException e2) {
                d.a.h0.a.c0.c.c("ExtCore-DebugDownload", "build result with exception", e2);
                e2.printStackTrace();
                this.f43152a.handleSchemeDispatchCallback(this.f43154c, UnitedSchemeUtility.wrapCallbackParams(this.f43153b, 1001).toString());
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("ExtCore-DebugDownload", "params is null");
            d.a.h0.a.q1.b.f.d.e(context, d.a.h0.a.h.aiapps_debug_extension_core_params_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = a2.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("ExtCore-DebugDownload", "url is null");
            d.a.h0.a.q1.b.f.d.e(context, d.a.h0.a.h.aiapps_debug_extension_core_url_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = a2.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.h0.a.c0.c.b("ExtCore-DebugDownload", "cb is null");
            d.a.h0.a.q1.b.f.d.e(context, d.a.h0.a.h.aiapps_debug_extension_core_cb_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.R().g(context, "mapp_cts_debug", new C0695a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        d.a.h0.a.u0.d.r(str, new b(this, callbackHandler, new JSONObject(), str2));
    }
}
