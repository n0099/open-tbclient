package d.b.h0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.u0.d;
import d.b.h0.a.v1.c.i.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45838f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45839g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45840h;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2) {
            this.f45837e = callbackHandler;
            this.f45838f = str;
            this.f45839g = context;
            this.f45840h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                d.this.l(this.f45839g, this.f45840h, this.f45838f, this.f45837e);
            } else {
                d.b.h0.a.v1.c.c.o(hVar, this.f45837e, this.f45838f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45842b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45843c;

        public b(d dVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f45841a = context;
            this.f45842b = callbackHandler;
            this.f45843c = str;
        }

        @Override // d.b.h0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.h0.a.u0.d.c
        public void onFailed() {
            d.b.h0.a.q1.b.f.d.e(this.f45841a, d.b.h0.a.h.aiapps_debug_swan_core_download_failed).C();
            this.f45842b.handleSchemeDispatchCallback(this.f45843c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // d.b.h0.a.u0.d.c
        public void onSuccess() {
            File d2 = d.b.h0.a.b2.d.a.d();
            File c2 = d.b.h0.a.b2.d.a.c();
            if (a0.f47009b) {
                Log.d("replaceSwanCore", "swanCoreZipFile: " + d2 + " swanCoreDir: " + c2);
            }
            if (d2.exists() && d.b.h0.p.d.F(d2.getPath(), c2.getPath())) {
                d.b.h0.a.m1.a.a.H(true);
                d.b.h0.a.q1.b.f.d.e(this.f45841a, d.b.h0.a.h.aiapps_debug_swan_core_download_success).C();
                this.f45842b.handleSchemeDispatchCallback(this.f45843c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return;
            }
            d.b.h0.a.q1.b.f.d.e(this.f45841a, d.b.h0.a.h.aiapps_debug_swan_core_download_failed).C();
            this.f45842b.handleSchemeDispatchCallback(this.f45843c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/debug/replaceSwanCore");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.h0.a.q1.b.f.d.e(context, d.b.h0.a.h.aiapps_debug_swan_core_params_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        String optString = a2.optString("url");
        String optString2 = a2.optString("cb");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            eVar.R().g(context, "mapp_cts_debug", new a(callbackHandler, optString2, context, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.b.h0.a.q1.b.f.d.e(context, d.b.h0.a.h.aiapps_debug_swan_core_url_empty).C();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
        return false;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        d.b.h0.a.u0.d.s(str, new b(this, context, callbackHandler, str2));
    }
}
