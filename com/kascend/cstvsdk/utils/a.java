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
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.chushou.basis.d.b;
import tv.chushou.basis.http.HttpExecutor;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public final class a {
    private static Map<String, String> b;
    private static int c;
    private static int d;
    public static final a njI = new a();
    private static long[] njH = new long[0];

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
            tv.chushou.zues.widget.fresco.a.b(sdkConfig.getApplication(), HttpExecutor.getOkHttpClient());
        }
        c();
        com.kascend.chushou.a.a.dAG().b();
        a("");
    }

    private final void b(SdkConfig sdkConfig) {
        tv.chushou.basis.d.b.a(new b.a((Application) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getApplication())).wY(sdkConfig.getDebug()));
        h.a(sdkConfig.getApplication(), com.kascend.chushou.d.c.mOu.c(), sdkConfig.getResources());
        tv.chushou.widget.a.c.d(sdkConfig.getResources());
    }

    /* loaded from: classes4.dex */
    public static final class g implements Application.ActivityLifecycleCallbacks {
        g() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof BaseActivity) {
                a aVar = a.njI;
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
                a aVar = a.njI;
                a.c--;
            }
        }
    }

    private final void d() {
        tv.chushou.basis.d.b.dOE().registerActivityLifecycleCallbacks(new g());
    }

    private final void c(SdkConfig sdkConfig) {
        com.kascend.chushou.d.e.b(sdkConfig.getOkhttp(), sdkConfig.getServer());
        com.kascend.chushou.d.e.g();
        tv.chushou.a.a.b.a.dOP().H(f.njK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class f implements Runnable {
        public static final f njK = new f();

        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kascend.chushou.d.e.e();
        }
    }

    private final void d(SdkConfig sdkConfig) {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            aVar.putString("xappkey", (String) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getXappkey()));
        }
        if (aVar != null) {
            aVar.putString("xsecret", (String) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getXsecret()));
        }
        tv.chushou.basis.d.b.dOG().e(ThirdParty.class, (Class) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getThirdParty()));
        HashMap hashMap = new HashMap();
        Map<String, String> sdkHostParams = sdkConfig.getSdkHostParams();
        if (sdkHostParams != null) {
            for (Map.Entry<String, String> entry : sdkHostParams.entrySet()) {
                hashMap.put("__bd_" + entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("__bd__sdk_version", "1.0.0");
        b = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class e implements Runnable {
        public static final e njJ = new e();

        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kascend.chushou.b.dAF().a = tv.chushou.zues.utils.a.hg(tv.chushou.basis.d.b.dOE());
            com.kascend.chushou.b.dAF().b = tv.chushou.zues.utils.a.hh(tv.chushou.basis.d.b.dOE());
            com.kascend.chushou.d.e.a();
        }
    }

    private final void e() {
        tv.chushou.a.a.b.a.dOP().H(e.njJ);
        com.kascend.chushou.toolkit.d.a.dDe().b();
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
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dOG().T(ThirdParty.class);
        if (thirdParty != null) {
            if (context == null) {
                context = tv.chushou.basis.d.b.dOE();
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

    /* loaded from: classes4.dex */
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
            a.njI.b(this.a);
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onFailure(int i, String str, Object obj) {
        }
    }

    public final void c() {
        if (!LoginManager.Instance().islogined()) {
            com.kascend.chushou.d.h dAM = com.kascend.chushou.d.h.dAM();
            q.i(dAM, "SP_Manager.Instance()");
            String s = dAM.s();
            if (!(s == null || s.length() == 0)) {
                d++;
                if (d <= 3) {
                    LoginManager.Instance().autoLogin(new C0717a());
                }
            }
        }
    }

    /* renamed from: com.kascend.cstvsdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0717a implements SimpleCallback {
        C0717a() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onStart() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onSuccess() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onFailure(int i, String str, Object obj) {
            a.njI.c();
        }
    }

    public final void b(Context context) {
        if (context == null) {
            context = tv.chushou.basis.d.b.dOE();
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
            context = tv.chushou.basis.d.b.dOE();
        }
        if (com.kascend.chushou.d.e.c(context, null)) {
            tv.chushou.zues.utils.e.d("SdkUtils", "goToRecharge");
            ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dOG().T(ThirdParty.class);
            if (thirdParty != null) {
                q.i(context, "c");
                thirdParty.jumpToRecharge(context, new d());
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                a aVar = a.njI;
                a.njH = jArr;
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
        }
    }

    public final boolean a(String str) {
        if (njH.length == 0) {
            com.kascend.chushou.c.c.dAI().b(new b());
            return false;
        }
        long Q = h.Q(str, 0L);
        return (Q == 0 || a(njH, Q) == -1) ? false : true;
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
