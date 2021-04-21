package d.b.h0.a.y0;

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
import d.b.h0.a.f2.e;
import d.b.h0.a.i2.k0;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.u0.d;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.y0.e.c;
import d.b.h0.a.z1.h;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0912a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f47784a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47785b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47786c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47787d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47789f;

        public C0912a(a aVar, c.a aVar2, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            this.f47784a = aVar2;
            this.f47785b = str;
            this.f47786c = str2;
            this.f47787d = callbackHandler;
            this.f47788e = unitedSchemeEntity;
            this.f47789f = str3;
        }

        @Override // d.b.h0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.h0.a.u0.d.c
        public void onFailed() {
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(7L);
            aVar.h(9L);
            aVar.e("debug download pkg fail");
            e.a().f(aVar);
            d.b.h0.a.y0.d.a.d(d.b.h0.a.w0.a.c(), aVar, 0, this.f47786c);
            d.b.h0.a.z1.k.d dVar = new d.b.h0.a.z1.k.d();
            dVar.p(aVar);
            dVar.r(this.f47784a);
            h.H(dVar);
            this.f47788e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }

        @Override // d.b.h0.a.u0.d.c
        public void onSuccess() {
            ((c.a) this.f47784a.v0(true)).R0("1.6.0");
            SwanLauncher.j().n(this.f47784a, null);
            a.l(this.f47785b, this.f47786c, this.f47787d, this.f47788e, this.f47789f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47790a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47791b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47792c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f47790a = callbackHandler;
            this.f47791b = unitedSchemeEntity;
            this.f47792c = str;
        }

        @Override // d.b.h0.a.y0.a.d
        public void a() {
            a.k(this.f47790a, this.f47791b, this.f47792c, 0);
        }

        @Override // d.b.h0.a.y0.a.d
        public void b() {
            a.k(this.f47790a, this.f47791b, this.f47792c, 1001);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.b.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f47793c;

        public c(d dVar) {
            this.f47793c = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.n1.a.b.c.b, d.b.h0.a.n1.a.b.c.c, d.b.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.h0.a.n1.a.b.a.b bVar) {
            if (bVar.a() != null && bVar.a().getInt("ok") == 0) {
                d dVar = this.f47793c;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            d dVar2 = this.f47793c;
            if (dVar2 != null) {
                dVar2.b();
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

    public static void k(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i));
        } else {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i).toString(), str);
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
            d.b.h0.a.y0.b.j(str2, bVar);
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
        d.b.h0.a.r1.d.e().q().J(bundle, d.b.h0.a.y0.b.class, new c(dVar));
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.a("LaunchAction", "handle entity: ", unitedSchemeEntity);
        String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
        d.b.h0.a.c0.c.g("LaunchAction", "launch scheme = " + uri);
        String h2 = SwanLauncher.h();
        d.b.h0.a.r1.d.e().s().J().E0(h2);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("paramsValue is empty");
            e.a().f(aVar);
            d.b.h0.a.y0.d.a.d(context, aVar, 0, "");
            d.b.h0.a.z1.k.d dVar = new d.b.h0.a.z1.k.d();
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
                d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
                aVar2.j(1L);
                aVar2.h(1L);
                aVar2.e("appId is empty");
                e.a().f(aVar2);
                d.b.h0.a.y0.d.a.d(context, aVar2, 0, "");
                d.b.h0.a.z1.k.d dVar2 = new d.b.h0.a.z1.k.d();
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
                if (d.b.h0.a.u.a.e(L) && !d.b.h0.a.u.a.f(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar3.m0("srcAppId", G);
                aVar3.m0("srcAppPage", k0.n().d());
            }
            if (a0.f47009b && !TextUtils.isEmpty(optString5)) {
                d.C0881d c0881d = new d.C0881d();
                c0881d.f47320a = optString5;
                d.b.h0.a.u0.d.t(c0881d, new C0912a(this, aVar3, optString4, optString, callbackHandler, unitedSchemeEntity, optString8));
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar3.v0(false);
                SwanLauncher.j().n(aVar3, null);
                l(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                d.b.h0.a.f2.a aVar4 = new d.b.h0.a.f2.a();
                aVar4.j(1L);
                aVar4.h(1L);
                aVar4.e("release but downloadUrl is not empty");
                e.a().f(aVar4);
                d.b.h0.a.y0.d.a.d(context, aVar4, 0, optString);
                d.b.h0.a.z1.k.d dVar3 = new d.b.h0.a.z1.k.d();
                dVar3.t(str2);
                dVar3.m(optString);
                dVar3.r(aVar3);
                dVar3.l("scheme", uri);
                h.H(dVar3);
                return false;
            }
        } catch (JSONException e2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            d.b.h0.a.f2.a aVar5 = new d.b.h0.a.f2.a();
            aVar5.j(1L);
            aVar5.h(1L);
            aVar5.e("parse paramsValue with JSONException:" + e2.getMessage());
            e.a().f(aVar5);
            d.b.h0.a.y0.d.a.d(context, aVar5, 0, "");
            d.b.h0.a.z1.k.d dVar4 = new d.b.h0.a.z1.k.d();
            dVar4.p(aVar5);
            dVar4.t(str2);
            dVar4.l("scheme", uri);
            h.H(dVar4);
            return false;
        }
    }
}
