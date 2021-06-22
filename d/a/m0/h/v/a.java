package d.a.m0.h.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.m0.a.a1.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.f1.e.c;
import d.a.m0.a.j2.p.d;
import d.a.m0.a.k;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q0;
import d.a.m0.h.s.a;
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
    public static final boolean f51485a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f51486b;

    /* renamed from: d.a.m0.h.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1112a implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f51487a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f51488b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51489c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51490d;

        /* renamed from: d.a.m0.h.v.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1113a implements Runnable {
            public RunnableC1113a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.z1.b.f.e.g(C1112a.this.f51487a, "小游戏包下载成功").F();
            }
        }

        /* renamed from: d.a.m0.h.v.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements d.a.m0.a.a1.b {
            public b() {
            }

            @Override // d.a.m0.a.a1.b
            public void a(int i2, d.a.m0.a.a1.a aVar) {
                d.a.m0.h.c0.a.a aVar2;
                a.c cVar = (a.c) aVar;
                if (i2 != 0 || cVar == null || (aVar2 = cVar.f51458c) == null) {
                    return;
                }
                C1112a.this.f51488b.P0(aVar2.f51039b);
                C1112a c1112a = C1112a.this;
                Intent d1 = c.d1(c1112a.f51487a, c1112a.f51488b);
                d1.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
                d1.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                C1112a.this.f51487a.startActivity(d1);
                C1112a c1112a2 = C1112a.this;
                UnitedSchemeUtility.callCallback(c1112a2.f51489c, c1112a2.f51490d, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }

        public C1112a(Context context, c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f51487a = context;
            this.f51488b = cVar;
            this.f51489c = callbackHandler;
            this.f51490d = unitedSchemeEntity;
        }

        @Override // d.a.m0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.m0.a.a1.e.c
        public void onFailed() {
            if (a.f51485a) {
                Log.d("SwanGameLaunchAction", "onFailed");
            }
            d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
            aVar.j(7L);
            aVar.h(9L);
            aVar.e("debug download pkg fail");
            d.a.m0.a.q2.e.a().f(aVar);
            d.a.m0.a.f1.d.a.d(this.f51487a, aVar, 1, this.f51488b.H());
            this.f51490d.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }

        @Override // d.a.m0.a.a1.e.c
        public void onSuccess() {
            if (a.f51485a) {
                Log.d("SwanGameLaunchAction", "onSuccess");
            }
            q0.b0(new RunnableC1113a());
            this.f51488b.Y0("1.6.0");
            this.f51488b.z0(true);
            d.a.m0.a.f1.e.b d2 = a.this.d(this.f51488b);
            if (d2 == null) {
                return;
            }
            d.a.m0.h.s.a.c(d2, new b());
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f51486b = hashSet;
        hashSet.add("_baiduboxapp");
    }

    @SuppressLint({"BDOfflineUrl"})
    public final b c() {
        b.a aVar = new b.a();
        aVar.A1("小程序测试");
        aVar.u0("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.N0(Color.parseColor("#FF308EF0"));
        aVar.H0("1230000000000000");
        aVar.x1("小程序简介");
        aVar.D1("测试服务类目");
        aVar.E1("测试主体信息");
        aVar.z1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.G1("1.0");
        aVar.B1("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public final b d(c cVar) {
        if (cVar == null) {
            return null;
        }
        b c2 = c();
        c2.u0(cVar.H());
        c2.H0(cVar.T());
        c2.Q0(cVar.e0());
        c2.z0(cVar.m0());
        c2.x0(cVar.L());
        c2.C0(cVar.r0());
        c2.J0(cVar.W());
        c2.O0(cVar.c0());
        c2.X0(cVar.i0());
        c2.B0(cVar.O());
        c2.Y0(cVar.j0());
        c2.G1("0");
        c2.t0(cVar.G());
        return c2;
    }

    public final String e(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    public final String f(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        return substring.endsWith(File.separator) ? substring.substring(0, substring.length() - 1) : substring;
    }

    public final String g(Uri uri) {
        return o0.i(uri.getQuery(), f51486b);
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aigames_launch_interceptor";
    }

    public final void h(c cVar, String str, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e.d dVar = new e.d();
        cVar.H();
        dVar.f44474a = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        d.a.m0.h.s.a.h(dVar, new C1112a(applicationContext, cVar, callbackHandler, unitedSchemeEntity));
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x019a  */
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
        String e2 = e(uri);
        if (f51485a) {
            Log.d("SwanGameLaunchAction", "mAppId: " + e2);
        }
        if (TextUtils.isEmpty(e2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
            aVar.j(1L);
            aVar.h(1L);
            aVar.e("appId is empty");
            d.a.m0.a.q2.e.a().f(aVar);
            d dVar = new d();
            dVar.q(d.a.m0.a.j2.k.m(1));
            dVar.p(aVar);
            dVar.l("scheme", uri.toString());
            d.a.m0.a.j2.k.L(dVar);
            return true;
        }
        String f2 = f(e2, uri);
        if (f51485a) {
            Log.d("SwanGameLaunchAction", "pagePath: " + f2);
        }
        String g2 = g(uri);
        if (f51485a) {
            Log.d("SwanGameLaunchAction", "query: " + g2);
        }
        c.a aVar2 = (c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(e2)).J0(uri.toString())).t0(1)).F0(false);
        if (!TextUtils.isEmpty(f2)) {
            aVar2.Q0(f2 + "?" + g2);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param2);
                aVar2.H0(jSONObject.optString("from"));
                aVar2.O0(jSONObject.optString("notinhis"));
                aVar2.q0("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                    aVar2.q0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                }
                str = jSONObject.optString(BeanConstants.CHANNEL_ID_NAVI);
                try {
                    JSONObject b2 = d.a.m0.t.c.b(aVar2.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                    if (b2 != null) {
                        aVar2.q0(UBCCloudControlProcessor.UBC_KEY, b2.toString());
                    }
                    String optString = jSONObject.optString("veloce");
                    if (!TextUtils.isEmpty(optString)) {
                        long optLong = new JSONObject(optString).optLong("starttime");
                        if (optLong > 0) {
                            aVar2.w("veloce_start_time", optLong);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    if (f51485a) {
                        Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (f51485a) {
                    }
                    param = unitedSchemeEntity.getParam(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                    if (!d.a.m0.a.u1.a.a.w()) {
                    }
                    aVar2.F0(true);
                    h(aVar2, param, context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            } catch (JSONException e4) {
                e = e4;
                str = null;
            }
        }
        if (f51485a) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar2);
        }
        param = unitedSchemeEntity.getParam(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
        if ((!d.a.m0.a.u1.a.a.w() || f51485a) && !TextUtils.isEmpty(param)) {
            aVar2.F0(true);
            h(aVar2, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.j().n(aVar2, null);
        d.a.m0.a.f1.a.l(str, e2, callbackHandler, unitedSchemeEntity, null);
        return true;
    }
}
