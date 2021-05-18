package d.a.i0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.a1.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43870e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43871f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43872g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43873h;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2) {
            this.f43870e = callbackHandler;
            this.f43871f = str;
            this.f43872g = context;
            this.f43873h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                d.this.l(this.f43872g, this.f43873h, this.f43871f, this.f43870e);
            } else {
                d.a.i0.a.e2.c.d.p(iVar, this.f43870e, this.f43871f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43875a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43876b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43877c;

        public b(d dVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f43875a = context;
            this.f43876b = callbackHandler;
            this.f43877c = str;
        }

        @Override // d.a.i0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.i0.a.a1.e.c
        public void onFailed() {
            d.a.i0.a.z1.b.f.e.f(this.f43875a, d.a.i0.a.h.aiapps_debug_swan_core_download_failed).F();
            this.f43876b.handleSchemeDispatchCallback(this.f43877c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // d.a.i0.a.a1.e.c
        public void onSuccess() {
            File d2 = d.a.i0.a.m2.d.a.d();
            File c2 = d.a.i0.a.m2.d.a.c();
            if (a0.f40775b) {
                Log.d("replaceSwanCore", "swanCoreZipFile: " + d2 + " swanCoreDir: " + c2);
            }
            if (d2.exists() && d.a.i0.t.d.T(d2.getPath(), c2.getPath())) {
                d.a.i0.a.u1.a.a.L(true);
                d.a.i0.a.z1.b.f.e.f(this.f43875a, d.a.i0.a.h.aiapps_debug_swan_core_download_success).F();
                this.f43876b.handleSchemeDispatchCallback(this.f43877c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return;
            }
            d.a.i0.a.z1.b.f.e.f(this.f43875a, d.a.i0.a.h.aiapps_debug_swan_core_download_failed).F();
            this.f43876b.handleSchemeDispatchCallback(this.f43877c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public d(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/replaceSwanCore");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.z1.b.f.e.f(context, d.a.i0.a.h.aiapps_debug_params_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        String optString = a2.optString("url");
        String optString2 = a2.optString("cb");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            eVar.T().g(context, "mapp_cts_debug", new a(callbackHandler, optString2, context, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.a.i0.a.z1.b.f.e.f(context, d.a.i0.a.h.aiapps_debug_download_url_empty).F();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
        return false;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        d.a.i0.a.a1.e.H(str, new b(this, context, callbackHandler, str2));
    }
}
