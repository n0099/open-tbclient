package d.b.h0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.u0.d;
import d.b.h0.a.v1.c.i.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.l0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0756a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45819e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45820f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45821g;

        public C0756a(CallbackHandler callbackHandler, String str, String str2) {
            this.f45819e = callbackHandler;
            this.f45820f = str;
            this.f45821g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                a.this.k(this.f45821g, this.f45820f, this.f45819e);
            } else {
                d.b.h0.a.v1.c.c.o(hVar, this.f45819e, this.f45820f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45823a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45824b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45825c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            this.f45823a = callbackHandler;
            this.f45824b = jSONObject;
            this.f45825c = str;
        }

        @Override // d.b.h0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.h0.a.u0.d.c
        public void onFailed() {
            if (this.f45823a == null) {
                d.b.h0.a.c0.c.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                d.b.h0.a.c0.c.b("ExtCore-DebugDownload", "download failed");
                d.b.h0.a.q1.b.f.d.e(d.b.h0.a.w0.a.c(), d.b.h0.a.h.aiapps_debug_extension_core_download_failed).C();
                this.f45824b.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f45823a.handleSchemeDispatchCallback(this.f45825c, UnitedSchemeUtility.wrapCallbackParams(this.f45824b, 1001).toString());
        }

        @Override // d.b.h0.a.u0.d.c
        public void onSuccess() {
            if (this.f45823a == null) {
                d.b.h0.a.c0.c.l("ExtCore-DebugDownload", "handler is null");
                return;
            }
            try {
                File c2 = d.b.h0.a.l0.g.b.c();
                File b2 = d.b.h0.a.l0.g.b.b();
                if (c2.exists() && d.b.h0.p.d.F(c2.getPath(), b2.getPath())) {
                    d.b.h0.a.c0.c.b("ExtCore-DebugDownload", "download success");
                    d.b.h0.a.q1.b.f.d.e(d.b.h0.a.w0.a.c(), d.b.h0.a.h.aiapps_debug_extension_core_download_success).C();
                    this.f45824b.put("status", 0);
                    this.f45823a.handleSchemeDispatchCallback(this.f45825c, UnitedSchemeUtility.wrapCallbackParams(this.f45824b, 0).toString());
                } else {
                    d.b.h0.a.c0.c.b("ExtCore-DebugDownload", "download failed");
                    d.b.h0.a.q1.b.f.d.e(d.b.h0.a.w0.a.c(), d.b.h0.a.h.aiapps_debug_extension_core_download_failed).C();
                    this.f45824b.put("status", -1);
                    this.f45823a.handleSchemeDispatchCallback(this.f45825c, UnitedSchemeUtility.wrapCallbackParams(this.f45824b, 1001).toString());
                }
            } catch (JSONException e2) {
                d.b.h0.a.c0.c.c("ExtCore-DebugDownload", "build result with exception", e2);
                e2.printStackTrace();
                this.f45823a.handleSchemeDispatchCallback(this.f45825c, UnitedSchemeUtility.wrapCallbackParams(this.f45824b, 1001).toString());
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.h0.a.c0.c.b("ExtCore-DebugDownload", "params is null");
            d.b.h0.a.q1.b.f.d.e(context, d.b.h0.a.h.aiapps_debug_extension_core_params_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = a2.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("ExtCore-DebugDownload", "url is null");
            d.b.h0.a.q1.b.f.d.e(context, d.b.h0.a.h.aiapps_debug_extension_core_url_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = a2.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.b.h0.a.c0.c.b("ExtCore-DebugDownload", "cb is null");
            d.b.h0.a.q1.b.f.d.e(context, d.b.h0.a.h.aiapps_debug_extension_core_cb_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.R().g(context, "mapp_cts_debug", new C0756a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        d.b.h0.a.u0.d.r(str, new b(this, callbackHandler, new JSONObject(), str2));
    }
}
