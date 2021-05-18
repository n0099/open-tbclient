package d.a.i0.a.f1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.i0.a.a1.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.f1.e.c;
import d.a.i0.a.j2.k;
import d.a.i0.a.v2.q0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.i0.a.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0616a implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f41634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41635b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f41636c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41637d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41638e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41639f;

        public C0616a(a aVar, c.a aVar2, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            this.f41634a = aVar2;
            this.f41635b = str;
            this.f41636c = str2;
            this.f41637d = callbackHandler;
            this.f41638e = unitedSchemeEntity;
            this.f41639f = str3;
        }

        @Override // d.a.i0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.i0.a.a1.e.c
        public void onFailed() {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(7L);
            aVar.h(9L);
            aVar.e("debug download pkg fail");
            d.a.i0.a.q2.e.a().f(aVar);
            d.a.i0.a.f1.d.a.d(d.a.i0.a.c1.a.b(), aVar, 0, this.f41636c);
            d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(this.f41634a);
            k.L(dVar);
            this.f41638e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }

        @Override // d.a.i0.a.a1.e.c
        public void onSuccess() {
            ((c.a) this.f41634a.z0(true)).Y0("1.6.0");
            SwanLauncher.j().n(this.f41634a, null);
            a.l(this.f41635b, this.f41636c, this.f41637d, this.f41638e, this.f41639f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f41642c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f41640a = callbackHandler;
            this.f41641b = unitedSchemeEntity;
            this.f41642c = str;
        }

        @Override // d.a.i0.a.f1.a.d
        public void a() {
            a.k(this.f41640a, this.f41641b, this.f41642c, 1001);
        }

        @Override // d.a.i0.a.f1.a.d
        public void b() {
            a.k(this.f41640a, this.f41641b, this.f41642c, 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d.a.i0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f41643c;

        public c(d dVar) {
            this.f41643c = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v1.a.b.c.b, d.a.i0.a.v1.a.b.c.c, d.a.i0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.i0.a.v1.a.b.a.b bVar) {
            if (bVar.a() != null && bVar.a().getInt("ok") == 0) {
                d dVar = this.f41643c;
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            d dVar2 = this.f41643c;
            if (dVar2 != null) {
                dVar2.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b();
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/launch");
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
            d.a.i0.a.f1.b.j(str2, bVar);
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
        d.a.i0.a.a2.d.g().z().L(bundle, d.a.i0.a.f1.b.class, new c(dVar));
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.e0.d.a("LaunchAction", "handle entity: ", unitedSchemeEntity);
        String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
        d.a.i0.a.e0.d.g("LaunchAction", "launch scheme = " + uri);
        String h2 = SwanLauncher.h();
        d.a.i0.a.a2.d.g().r().L().I0(h2);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("paramsValue is empty");
            d.a.i0.a.q2.e.a().f(aVar);
            d.a.i0.a.f1.d.a.d(context, aVar, 0, "");
            d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
            dVar.p(aVar);
            dVar.t(str2);
            dVar.l("scheme", uri);
            k.L(dVar);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString4 = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
            String optString5 = jSONObject.optString("downloadurl");
            String optString6 = jSONObject.optString("clkid");
            String optString7 = jSONObject.optString("notinhis");
            String optString8 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
                aVar2.j(1L);
                aVar2.h(1L);
                aVar2.e("appId is empty");
                d.a.i0.a.q2.e.a().f(aVar2);
                d.a.i0.a.f1.d.a.d(context, aVar2, 0, "");
                d.a.i0.a.j2.p.d dVar2 = new d.a.i0.a.j2.p.d();
                dVar2.p(aVar2);
                dVar2.t(str2);
                dVar2.l("scheme", uri);
                k.L(dVar2);
                return false;
            }
            c.a aVar3 = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(optString)).Q0(optString2)).H0(str2)).J0(uri)).x0(optString6)).O0(optString7)).I0(h2);
            if (eVar != null && !TextUtils.isEmpty(optString4)) {
                aVar3.q0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString3);
                aVar3.q0(BeanConstants.CHANNEL_ID_NAVI, optString4);
                b.a N = eVar.N();
                if (N == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = N.H();
                if (d.a.i0.a.v.a.e(N) && !d.a.i0.a.v.a.f(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar3.q0("srcAppId", H);
                aVar3.q0("srcAppPage", q0.n().f());
            }
            if (a0.f40775b && !TextUtils.isEmpty(optString5)) {
                e.d dVar3 = new e.d();
                dVar3.f40516a = optString5;
                e.I(dVar3, new C0616a(this, aVar3, optString4, optString, callbackHandler, unitedSchemeEntity, optString8));
                return true;
            } else if (TextUtils.isEmpty(optString5)) {
                aVar3.z0(false);
                SwanLauncher.j().n(aVar3, null);
                l(optString4, optString, callbackHandler, unitedSchemeEntity, optString8);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                d.a.i0.a.q2.a aVar4 = new d.a.i0.a.q2.a();
                aVar4.j(1L);
                aVar4.h(1L);
                aVar4.e("release but downloadUrl is not empty");
                d.a.i0.a.q2.e.a().f(aVar4);
                d.a.i0.a.f1.d.a.d(context, aVar4, 0, optString);
                d.a.i0.a.j2.p.d dVar4 = new d.a.i0.a.j2.p.d();
                dVar4.t(str2);
                dVar4.m(optString);
                dVar4.r(aVar3);
                dVar4.l("scheme", uri);
                k.L(dVar4);
                return false;
            }
        } catch (JSONException e2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            d.a.i0.a.q2.a aVar5 = new d.a.i0.a.q2.a();
            aVar5.j(1L);
            aVar5.h(1L);
            aVar5.e("parse paramsValue with JSONException:" + e2.getMessage());
            d.a.i0.a.q2.e.a().f(aVar5);
            d.a.i0.a.f1.d.a.d(context, aVar5, 0, "");
            d.a.i0.a.j2.p.d dVar5 = new d.a.i0.a.j2.p.d();
            dVar5.p(aVar5);
            dVar5.t(str2);
            dVar5.l("scheme", uri);
            k.L(dVar5);
            return false;
        }
    }
}
