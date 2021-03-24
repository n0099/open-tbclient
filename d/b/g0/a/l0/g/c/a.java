package d.b.g0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.u0.d;
import d.b.g0.a.v1.c.i.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.a.l0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0723a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45099g;

        public C0723a(CallbackHandler callbackHandler, String str, String str2) {
            this.f45097e = callbackHandler;
            this.f45098f = str;
            this.f45099g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                a.this.k(this.f45099g, this.f45098f, this.f45097e);
            } else {
                d.b.g0.a.v1.c.c.o(hVar, this.f45097e, this.f45098f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45102b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45103c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            this.f45101a = callbackHandler;
            this.f45102b = jSONObject;
            this.f45103c = str;
        }

        @Override // d.b.g0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.g0.a.u0.d.c
        public void onFailed() {
            if (this.f45101a == null) {
                d.b.g0.a.c0.c.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                d.b.g0.a.c0.c.b("ExtCore-DebugDownload", "download failed");
                d.b.g0.a.q1.b.f.d.e(d.b.g0.a.w0.a.c(), d.b.g0.a.h.aiapps_debug_extension_core_download_failed).C();
                this.f45102b.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f45101a.handleSchemeDispatchCallback(this.f45103c, UnitedSchemeUtility.wrapCallbackParams(this.f45102b, 1001).toString());
        }

        @Override // d.b.g0.a.u0.d.c
        public void onSuccess() {
            if (this.f45101a == null) {
                d.b.g0.a.c0.c.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                File c2 = d.b.g0.a.l0.g.b.c();
                File b2 = d.b.g0.a.l0.g.b.b();
                if (c2.exists() && d.b.g0.p.d.F(c2.getPath(), b2.getPath())) {
                    d.b.g0.a.c0.c.b("ExtCore-DebugDownload", "download success");
                    d.b.g0.a.q1.b.f.d.e(d.b.g0.a.w0.a.c(), d.b.g0.a.h.aiapps_debug_extension_core_download_success).C();
                    this.f45102b.put("status", 0);
                    this.f45101a.handleSchemeDispatchCallback(this.f45103c, UnitedSchemeUtility.wrapCallbackParams(this.f45102b, 0).toString());
                } else {
                    d.b.g0.a.c0.c.b("ExtCore-DebugDownload", "download failed");
                    d.b.g0.a.q1.b.f.d.e(d.b.g0.a.w0.a.c(), d.b.g0.a.h.aiapps_debug_extension_core_download_failed).C();
                    this.f45102b.put("status", -1);
                    this.f45101a.handleSchemeDispatchCallback(this.f45103c, UnitedSchemeUtility.wrapCallbackParams(this.f45102b, 1001).toString());
                }
            } catch (JSONException e2) {
                d.b.g0.a.c0.c.c("ExtCore-DebugDownload", "build result with exception", e2);
                e2.printStackTrace();
                this.f45101a.handleSchemeDispatchCallback(this.f45103c, UnitedSchemeUtility.wrapCallbackParams(this.f45102b, 1001).toString());
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("ExtCore-DebugDownload", "params is null");
            d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_debug_extension_core_params_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = a2.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("ExtCore-DebugDownload", "url is null");
            d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_debug_extension_core_url_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = a2.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.b.g0.a.c0.c.b("ExtCore-DebugDownload", "cb is null");
            d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_debug_extension_core_cb_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.R().g(context, "mapp_cts_debug", new C0723a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        d.b.g0.a.u0.d.r(str, new b(this, callbackHandler, new JSONObject(), str2));
    }
}
