package d.b.h0.g.t;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.wallet.core.beans.BeanConstants;
import d.b.h0.a.f2.e;
import d.b.h0.a.i2.i0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.u0.d;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.y0.e.c;
import d.b.h0.a.z1.h;
import d.b.h0.g.q.a;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a extends UnitedSchemeBaseInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49290a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f49291b;

    /* renamed from: d.b.h0.g.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1023a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f49292a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f49293b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49294c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49295d;

        /* renamed from: d.b.h0.g.t.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1024a implements Runnable {
            public RunnableC1024a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.a.q1.b.f.d.f(C1023a.this.f49292a, "小游戏包下载成功").C();
            }
        }

        /* renamed from: d.b.h0.g.t.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements d.b.h0.a.u0.b {
            public b() {
            }

            @Override // d.b.h0.a.u0.b
            public void a(int i, d.b.h0.a.u0.a aVar) {
                d.b.h0.g.z.a.a aVar2;
                a.c cVar = (a.c) aVar;
                if (i != 0 || cVar == null || (aVar2 = cVar.f49268c) == null) {
                    return;
                }
                C1023a.this.f49293b.I0(aVar2.f49415a);
                C1023a c1023a = C1023a.this;
                Intent W0 = c.W0(c1023a.f49292a, c1023a.f49293b);
                W0.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
                W0.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                C1023a.this.f49292a.startActivity(W0);
                C1023a c1023a2 = C1023a.this;
                UnitedSchemeUtility.callCallback(c1023a2.f49294c, c1023a2.f49295d, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }

        public C1023a(Context context, c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f49292a = context;
            this.f49293b = cVar;
            this.f49294c = callbackHandler;
            this.f49295d = unitedSchemeEntity;
        }

        @Override // d.b.h0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.h0.a.u0.d.c
        public void onFailed() {
            if (a.f49290a) {
                Log.d("SwanGameLaunchAction", "onFailed");
            }
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(7L);
            aVar.h(9L);
            aVar.e("debug download pkg fail");
            e.a().f(aVar);
            d.b.h0.a.y0.d.a.d(this.f49292a, aVar, 1, this.f49293b.G());
            this.f49295d.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }

        @Override // d.b.h0.a.u0.d.c
        public void onSuccess() {
            if (a.f49290a) {
                Log.d("SwanGameLaunchAction", "onSuccess");
            }
            k0.X(new RunnableC1024a());
            this.f49293b.R0("1.6.0");
            this.f49293b.v0(true);
            d.b.h0.a.y0.e.b c2 = a.this.c(this.f49293b);
            if (c2 == null) {
                return;
            }
            d.b.h0.g.q.a.c(c2, new b());
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f49291b = hashSet;
        hashSet.add("_baiduboxapp");
    }

    public final b c(c cVar) {
        if (cVar == null) {
            return null;
        }
        b U0 = b.U0();
        U0.q0(cVar.G());
        U0.D0(cVar.S());
        U0.J0(cVar.b0());
        U0.v0(cVar.j0());
        U0.t0(cVar.K());
        U0.y0(cVar.n0());
        U0.F0(cVar.V());
        U0.H0(cVar.Z());
        U0.Q0(cVar.f0());
        U0.x0(cVar.N());
        U0.R0(cVar.g0());
        U0.z1("0");
        U0.p0(cVar.F());
        return U0;
    }

    public final String d(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    public final String e(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        return substring.endsWith(File.separator) ? substring.substring(0, substring.length() - 1) : substring;
    }

    public final String f(Uri uri) {
        return i0.h(uri.getQuery(), f49291b);
    }

    public final void g(c cVar, String str, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.C0881d c0881d = new d.C0881d();
        cVar.G();
        c0881d.f47320a = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        d.b.h0.g.q.a.h(c0881d, new C1023a(applicationContext, cVar, callbackHandler, unitedSchemeEntity));
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aigames_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0204  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str;
        String param;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String d2 = d(uri);
        if (f49290a) {
            Log.d("SwanGameLaunchAction", "mAppId: " + d2);
        }
        if (TextUtils.isEmpty(d2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("appId is empty");
            e.a().f(aVar);
            d.b.h0.a.z1.k.d dVar = new d.b.h0.a.z1.k.d();
            dVar.q(h.n(1));
            dVar.p(aVar);
            dVar.l("scheme", uri.toString());
            h.H(dVar);
            return true;
        }
        if (d.b.h0.g.i0.f.d.e() != null) {
            boolean exists = new File(d.b.h0.g.i0.f.d.e()).exists();
            if (f49290a) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
                aVar2.j(1L);
                aVar2.h(1L);
                aVar2.e("v8 is error");
                e.a().f(aVar2);
                d.b.h0.a.z1.k.d dVar2 = new d.b.h0.a.z1.k.d();
                dVar2.q(h.n(1));
                dVar2.p(aVar2);
                dVar2.l(V8Engine.TYPE_V8, uri.toString());
                h.H(dVar2);
                return true;
            }
        }
        String e2 = e(d2, uri);
        if (f49290a) {
            Log.d("SwanGameLaunchAction", "pagePath: " + e2);
        }
        String f2 = f(uri);
        if (f49290a) {
            Log.d("SwanGameLaunchAction", "query: " + f2);
        }
        c.a aVar3 = (c.a) ((c.a) ((c.a) ((c.a) new c.a().q0(d2)).F0(uri.toString())).p0(1)).B0(false);
        if (!TextUtils.isEmpty(e2)) {
            aVar3.J0(e2 + "?" + f2);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param2);
                aVar3.D0(jSONObject.optString("from"));
                aVar3.H0(jSONObject.optString("notinhis"));
                aVar3.m0("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar3.m0("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
                try {
                    JSONObject b2 = d.b.h0.p.c.b(aVar3.S(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY), "pre_source");
                    if (b2 != null) {
                        aVar3.m0(UBCCloudControlProcessor.UBC_KEY, b2.toString());
                    }
                    String optString = jSONObject.optString("veloce");
                    if (!TextUtils.isEmpty(optString)) {
                        long optLong = new JSONObject(optString).optLong("starttime");
                        if (optLong > 0) {
                            aVar3.u("veloce_start_time", optLong);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    if (f49290a) {
                        Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (f49290a) {
                    }
                    param = unitedSchemeEntity.getParam(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                    if (!d.b.h0.a.m1.a.a.u()) {
                    }
                    aVar3.B0(true);
                    g(aVar3, param, context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            } catch (JSONException e4) {
                e = e4;
                str = null;
            }
        }
        if (f49290a) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar3);
        }
        param = unitedSchemeEntity.getParam(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
        if ((!d.b.h0.a.m1.a.a.u() || f49290a) && !TextUtils.isEmpty(param)) {
            aVar3.B0(true);
            g(aVar3, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.j().n(aVar3, null);
        d.b.h0.a.y0.a.l(str, d2, callbackHandler, unitedSchemeEntity, null);
        return true;
    }
}
