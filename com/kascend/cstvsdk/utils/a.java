package com.kascend.cstvsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.auth.BaiduAuthActivity;
import com.kascend.chushou.view.base.BaseActivity;
import com.kascend.cstvsdk.SdkConfig;
import com.kascend.cstvsdk.bean.LoginParam;
import com.kascend.cstvsdk.bean.LoginResp;
import com.kascend.cstvsdk.interfaces.Callback;
import com.kascend.cstvsdk.interfaces.SimpleCallback;
import com.kascend.cstvsdk.interfaces.ThirdParty;
import java.util.HashMap;
import java.util.Map;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.chushou.basis.d.b;
import tv.chushou.basis.http.HttpExecutor;
@h
/* loaded from: classes5.dex */
public final class a {
    private static Map<String, String> b;
    private static int c;
    private static int d;
    public static final a mIX = new a();
    private static long[] mIW = new long[0];

    private a() {
    }

    public final Map<String, String> a() {
        return b;
    }

    public final void a(SdkConfig sdkConfig) {
        q.j(sdkConfig, "config");
        b(sdkConfig);
        d();
        c(sdkConfig);
        d(sdkConfig);
        e();
        if (sdkConfig.getInitFresco()) {
            tv.chushou.zues.widget.fresco.a.b(sdkConfig.getApplication(), HttpExecutor.getOkHttpClient().newBuilder().addInterceptor(new com.kascend.chushou.toolkit.e()).build());
        }
        c();
        a("");
    }

    private final void b(SdkConfig sdkConfig) {
        tv.chushou.basis.d.b.a(new b.a((Application) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getApplication())).wO(sdkConfig.getDebug()));
        tv.chushou.zues.utils.h.a(sdkConfig.getApplication(), com.kascend.chushou.d.c.mnH.c(), sdkConfig.getResources());
        tv.chushou.widget.a.c.b(sdkConfig.getResources());
    }

    @h
    /* loaded from: classes5.dex */
    public static final class g implements Application.ActivityLifecycleCallbacks {
        g() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof BaseActivity) {
                a aVar = a.mIX;
                a.c++;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            com.kascend.chushou.d.b.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            com.kascend.chushou.d.b.b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof BaseActivity) {
                a aVar = a.mIX;
                a.c--;
            }
        }
    }

    private final void d() {
        tv.chushou.basis.d.b.dJp().registerActivityLifecycleCallbacks(new g());
    }

    private final void c(SdkConfig sdkConfig) {
        com.kascend.chushou.d.e.b(sdkConfig.getOkhttp(), sdkConfig.getServer());
        com.kascend.chushou.d.e.g();
        tv.chushou.a.a.b.a.dJA().M(f.mIZ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes5.dex */
    public static final class f implements Runnable {
        public static final f mIZ = new f();

        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kascend.chushou.d.e.e();
        }
    }

    private final void d(SdkConfig sdkConfig) {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dJr().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            aVar.putString("xappkey", (String) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getXappkey()));
        }
        if (aVar != null) {
            aVar.putString("xsecret", (String) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getXsecret()));
        }
        tv.chushou.basis.d.b.dJr().e(ThirdParty.class, (Class) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getThirdParty()));
        HashMap hashMap = new HashMap();
        Map<String, String> sdkHostParams = sdkConfig.getSdkHostParams();
        if (sdkHostParams != null) {
            for (Map.Entry<String, String> entry : sdkHostParams.entrySet()) {
                hashMap.put("__bd_" + entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("__bd__sdk_version", "1.0.2");
        b = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes5.dex */
    public static final class e implements Runnable {
        public static final e mIY = new e();

        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kascend.chushou.b.dwA().a = tv.chushou.zues.utils.a.fW(tv.chushou.basis.d.b.dJp());
            com.kascend.chushou.b.dwA().b = tv.chushou.zues.utils.a.fX(tv.chushou.basis.d.b.dJp());
            com.kascend.chushou.d.e.a();
        }
    }

    private final void e() {
        tv.chushou.a.a.b.a.dJA().M(e.mIY);
        com.kascend.chushou.toolkit.d.a.dyK().b();
    }

    public final void a(Context context, String str, String str2) {
        ListItem listItem = new ListItem();
        listItem.mTargetKey = str;
        listItem.mLiveType = str2;
        listItem.mType = "1";
        listItem.fromBaidu = true;
        com.kascend.chushou.d.e.a(context, listItem, (JSONObject) null);
    }

    public final boolean b() {
        return c > 0;
    }

    public final void a(Context context) {
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dJr().S(ThirdParty.class);
        if (thirdParty != null) {
            if (context == null) {
                context = tv.chushou.basis.d.b.dJp();
            }
            if (thirdParty.isLogined()) {
                b(context);
                return;
            }
            LoginParam loginParam = new LoginParam();
            loginParam.setForceLogin(true);
            q.i(context, "c");
            thirdParty.jumpToLogin(context, loginParam, new c(context));
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class c implements Callback<LoginResp> {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kascend.cstvsdk.interfaces.Callback
        /* renamed from: a */
        public void onSuccess(LoginResp loginResp) {
            a.mIX.b(this.a);
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onFailure(int i, String str, Object obj) {
        }
    }

    public final void c() {
        if (!LoginManager.Instance().islogined()) {
            com.kascend.chushou.d.h dwH = com.kascend.chushou.d.h.dwH();
            q.i(dwH, "SP_Manager.Instance()");
            String s = dwH.s();
            if (!(s == null || s.length() == 0)) {
                d++;
                if (d <= 3) {
                    LoginManager.Instance().autoLogin(new C0771a());
                }
            }
        }
    }

    @h
    /* renamed from: com.kascend.cstvsdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0771a implements SimpleCallback {
        C0771a() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onStart() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onSuccess() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onFailure(int i, String str, Object obj) {
            a.mIX.c();
        }
    }

    public final void b(Context context) {
        if (context == null) {
            context = tv.chushou.basis.d.b.dJp();
        }
        Activity a = com.kascend.chushou.d.f.a(context);
        Intent intent = new Intent(context, BaiduAuthActivity.class);
        if (a == null) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final void c(Context context) {
        if (context == null) {
            context = tv.chushou.basis.d.b.dJp();
        }
        if (com.kascend.chushou.d.e.c(context, null)) {
            tv.chushou.zues.utils.e.d("SdkUtils", "goToRecharge");
            ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dJr().S(ThirdParty.class);
            if (thirdParty != null) {
                q.i(context, "c");
                thirdParty.jumpToRecharge(context, new d());
            }
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class d implements Callback<Object> {
        d() {
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onStart() {
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onSuccess(Object obj) {
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onFailure(int i, String str, Object obj) {
        }
    }

    public final void a(int i) {
        Map<String, String> map = b;
        if (map != null) {
            map.put("__bd_net_type", String.valueOf(i));
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class b implements com.kascend.chushou.c.b {
        b() {
        }

        @Override // com.kascend.chushou.c.b
        public void a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a(String str, JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject != null ? jSONObject.optJSONArray("data") : null;
            if (optJSONArray != null) {
                long[] jArr = new long[optJSONArray.length()];
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    jArr[i] = optJSONArray.optLong(i, 0L);
                }
                a aVar = a.mIX;
                a.mIW = jArr;
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
        }
    }

    public final boolean a(String str) {
        if (mIW.length == 0) {
            com.kascend.chushou.c.c.dwD().a(new b());
            return false;
        }
        long P = tv.chushou.zues.utils.h.P(str, 0L);
        return (P == 0 || a(mIW, P) == -1) ? false : true;
    }

    private final int a(long[] jArr, long j) {
        int i = 0;
        int length = jArr.length - 1;
        while (i <= length) {
            int i2 = ((length - i) / 2) + i;
            long j2 = jArr[i2];
            if (j2 == j) {
                return i2;
            }
            if (j2 > j) {
                length = i2 - 1;
            } else {
                i = i2 + 1;
            }
        }
        return -1;
    }
}
