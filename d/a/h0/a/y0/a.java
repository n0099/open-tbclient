package d.a.h0.a.y0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.h0.a.f2.e;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.u0.d;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.y0.e.c;
import d.a.h0.a.z1.h;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0851a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f45218a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45219b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45220c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45221d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45223f;

        public C0851a(a aVar, c.a aVar2, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            this.f45218a = aVar2;
            this.f45219b = str;
            this.f45220c = str2;
            this.f45221d = callbackHandler;
            this.f45222e = unitedSchemeEntity;
            this.f45223f = str3;
        }

        @Override // d.a.h0.a.u0.d.c
        public void a(int i2) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void onFailed() {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(7L);
            aVar.h(9L);
            aVar.e("debug download pkg fail");
            e.a().f(aVar);
            d.a.h0.a.y0.d.a.d(d.a.h0.a.w0.a.c(), aVar, 0, this.f45220c);
            d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
            dVar.p(aVar);
            dVar.r(this.f45218a);
            h.H(dVar);
            this.f45222e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }

        @Override // d.a.h0.a.u0.d.c
        public void onSuccess() {
            ((c.a) this.f45218a.v0(true)).R0("1.6.0");
            SwanLauncher.j().n(this.f45218a, null);
            a.l(this.f45219b, this.f45220c, this.f45221d, this.f45222e, this.f45223f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45224a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45225b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45226c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f45224a = callbackHandler;
            this.f45225b = unitedSchemeEntity;
            this.f45226c = str;
        }

        @Override // d.a.h0.a.y0.a.d
        public void a() {
            a.k(this.f45224a, this.f45225b, this.f45226c, 1001);
        }

        @Override // d.a.h0.a.y0.a.d
        public void b() {
            a.k(this.f45224a, this.f45225b, this.f45226c, 0);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f45227c;

        public c(d dVar) {
            this.f45227c = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.a.b.c.b, d.a.h0.a.n1.a.b.c.c, d.a.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
            if (bVar.a() != null && bVar.a().getInt("ok") == 0) {
                d dVar = this.f45227c;
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            d dVar2 = this.f45227c;
            if (dVar2 != null) {
                dVar2.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b();
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/launch");
    }

    public static void k(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2));
        } else {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2).toString(), str);
        }
    }

    public static void l(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
            return;
        }
        b bVar = new b(callbackHandler, unitedSchemeEntity, str3);
        if (ProcessUtils.isMainProcess()) {
            d.a.h0.a.y0.b.j(str2, bVar);
        } else {
            m(str2, bVar);
        }
    }

    public static void m(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        d.a.h0.a.r1.d.e().x().J(bundle, d.a.h0.a.y0.b.class, new c(dVar));
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.a("LaunchAction", "handle entity: ", unitedSchemeEntity);
        String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
        d.a.h0.a.c0.c.g("LaunchAction", "launch scheme = " + uri);
        String h2 = SwanLauncher.h();
        d.a.h0.a.r1.d.e().p().J().E0(h2);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("paramsValue is empty");
            e.a().f(aVar);
            d.a.h0.a.y0.d.a.d(context, aVar, 0, "");
            d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
            dVar.p(aVar);
            dVar.t(str2);
            dVar.l("scheme", uri);
            h.H(dVar);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("extraData");
            String optString4 = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
            String optString5 = jSONObject.optString("downloadurl");
            String optString6 = jSONObject.optString("clkid");
            String optString7 = jSONObject.optString("notinhis");
            String optString8 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
                aVar2.j(1L);
                aVar2.h(1L);
                aVar2.e("appId is empty");
                e.a().f(aVar2);
                d.a.h0.a.y0.d.a.d(context, aVar2, 0, "");
                d.a.h0.a.z1.k.d dVar2 = new d.a.h0.a.z1.k.d();
                dVar2.p(aVar2);
                dVar2.t(str2);
                dVar2.l("scheme", uri);
                h.H(dVar2);
                return false;
            }
            c.a aVar3 = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().q0(optString)).J0(optString2)).D0(str2)).F0(uri)).t0(optString6)).H0(optString7)).E0(h2);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar3.m0("extraData", optString3);
                aVar3.m0(BeanConstants.CHANNEL_ID_NAVI, optString4);
                b.a L = eVar.L();
                if (L == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String G = L.G();
                if (d.a.h0.a.u.a.e(L) && !d.a.h0.a.u.a.f(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar3.m0("srcAppId", G);
                aVar3.m0("srcAppPage", k0.n().d());
            }
            if (a0.f44398b && !TextUtils.isEmpty(optString5)) {
                d.C0820d c0820d = new d.C0820d();
                c0820d.f44731a = optString5;
                d.a.h0.a.u0.d.t(c0820d, new C0851a(this, aVar3, optString4, optString, callbackHandler, unitedSchemeEntity, optString8));
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar3.v0(false);
                SwanLauncher.j().n(aVar3, null);
                l(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                d.a.h0.a.f2.a aVar4 = new d.a.h0.a.f2.a();
                aVar4.j(1L);
                aVar4.h(1L);
                aVar4.e("release but downloadUrl is not empty");
                e.a().f(aVar4);
                d.a.h0.a.y0.d.a.d(context, aVar4, 0, optString);
                d.a.h0.a.z1.k.d dVar3 = new d.a.h0.a.z1.k.d();
                dVar3.t(str2);
                dVar3.m(optString);
                dVar3.r(aVar3);
                dVar3.l("scheme", uri);
                h.H(dVar3);
                return false;
            }
        } catch (JSONException e2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            d.a.h0.a.f2.a aVar5 = new d.a.h0.a.f2.a();
            aVar5.j(1L);
            aVar5.h(1L);
            aVar5.e("parse paramsValue with JSONException:" + e2.getMessage());
            e.a().f(aVar5);
            d.a.h0.a.y0.d.a.d(context, aVar5, 0, "");
            d.a.h0.a.z1.k.d dVar4 = new d.a.h0.a.z1.k.d();
            dVar4.p(aVar5);
            dVar4.t(str2);
            dVar4.l("scheme", uri);
            h.H(dVar4);
            return false;
        }
    }
}
