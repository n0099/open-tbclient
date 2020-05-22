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
    public static final a ncU = new a();
    private static long[] ncT = new long[0];

    private a() {
    }

    public final Map<String, String> a() {
        return b;
    }

    public final void a(SdkConfig sdkConfig) {
        q.m(sdkConfig, "config");
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
        tv.chushou.basis.d.b.a(new b.a((Application) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getApplication())).xm(sdkConfig.getDebug()));
        tv.chushou.zues.utils.h.a(sdkConfig.getApplication(), com.kascend.chushou.d.c.mHD.c(), sdkConfig.getResources());
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
                a aVar = a.ncU;
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
                a aVar = a.ncU;
                a.c--;
            }
        }
    }

    private final void d() {
        tv.chushou.basis.d.b.dRk().registerActivityLifecycleCallbacks(new g());
    }

    private final void c(SdkConfig sdkConfig) {
        com.kascend.chushou.d.e.b(sdkConfig.getOkhttp(), sdkConfig.getServer());
        com.kascend.chushou.d.e.g();
        tv.chushou.a.a.b.a.dRv().O(f.ncW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes5.dex */
    public static final class f implements Runnable {
        public static final f ncW = new f();

        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kascend.chushou.d.e.e();
        }
    }

    private final void d(SdkConfig sdkConfig) {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dRm().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            aVar.putString("xappkey", (String) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getXappkey()));
        }
        if (aVar != null) {
            aVar.putString("xsecret", (String) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getXsecret()));
        }
        tv.chushou.basis.d.b.dRm().e(ThirdParty.class, (Class) tv.chushou.a.a.a.c.checkNotNull(sdkConfig.getThirdParty()));
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
        public static final e ncV = new e();

        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kascend.chushou.b.dDS().a = tv.chushou.zues.utils.a.gx(tv.chushou.basis.d.b.dRk());
            com.kascend.chushou.b.dDS().b = tv.chushou.zues.utils.a.gy(tv.chushou.basis.d.b.dRk());
            com.kascend.chushou.d.e.a();
        }
    }

    private final void e() {
        tv.chushou.a.a.b.a.dRv().O(e.ncV);
        com.kascend.chushou.toolkit.d.a.dGd().b();
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
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dRm().S(ThirdParty.class);
        if (thirdParty != null) {
            if (context == null) {
                context = tv.chushou.basis.d.b.dRk();
            }
            if (thirdParty.isLogined()) {
                b(context);
                return;
            }
            LoginParam loginParam = new LoginParam();
            loginParam.setForceLogin(true);
            q.l((Object) context, "c");
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
            a.ncU.b(this.a);
        }

        @Override // com.kascend.cstvsdk.interfaces.Callback
        public void onFailure(int i, String str, Object obj) {
        }
    }

    public final void c() {
        if (!LoginManager.Instance().islogined()) {
            com.kascend.chushou.d.h dDZ = com.kascend.chushou.d.h.dDZ();
            q.l((Object) dDZ, "SP_Manager.Instance()");
            String s = dDZ.s();
            if (!(s == null || s.length() == 0)) {
                d++;
                if (d <= 3) {
                    LoginManager.Instance().autoLogin(new C0829a());
                }
            }
        }
    }

    @h
    /* renamed from: com.kascend.cstvsdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0829a implements SimpleCallback {
        C0829a() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onStart() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onSuccess() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onFailure(int i, String str, Object obj) {
            a.ncU.c();
        }
    }

    public final void b(Context context) {
        if (context == null) {
            context = tv.chushou.basis.d.b.dRk();
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
            context = tv.chushou.basis.d.b.dRk();
        }
        if (com.kascend.chushou.d.e.c(context, null)) {
            tv.chushou.zues.utils.e.d("SdkUtils", "goToRecharge");
            ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dRm().S(ThirdParty.class);
            if (thirdParty != null) {
                q.l((Object) context, "c");
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
                a aVar = a.ncU;
                a.ncT = jArr;
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
        }
    }

    public final boolean a(String str) {
        if (ncT.length == 0) {
            com.kascend.chushou.c.c.dDV().a(new b());
            return false;
        }
        long O = tv.chushou.zues.utils.h.O(str, 0L);
        return (O == 0 || a(ncT, O) == -1) ? false : true;
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
