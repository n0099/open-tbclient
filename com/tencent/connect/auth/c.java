package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.others.lang.StringUtil;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.e;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public AuthAgent f39089a;

    /* renamed from: b  reason: collision with root package name */
    public QQToken f39090b;

    public c(String str, Context context) {
        f.c("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f39090b = new QQToken(str);
        this.f39089a = new AuthAgent(this.f39090b);
        com.tencent.connect.a.a.c(context, this.f39090b);
        f.c("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static c a(String str, Context context) {
        e.a(context.getApplicationContext());
        f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            c cVar = new c(str, context);
            f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
            return cVar;
        } catch (PackageManager.NameNotFoundException e2) {
            f.b("openSDK_LOG.QQAuth", "createInstance() error --end", e2);
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQAuth", "reAuth()");
        return this.f39089a.doLogin(activity, str, iUiListener, true, null);
    }

    public boolean c() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.f39090b.isSessionValid() ? "true" : "false");
        sb.append("");
        f.a("openSDK_LOG.QQAuth", sb.toString());
        return this.f39090b.isSessionValid();
    }

    public QQToken b() {
        return this.f39090b;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, "");
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        f.c("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, null, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        f.c("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        String packageName = activity.getApplicationContext().getPackageName();
        String str3 = null;
        try {
            Iterator<ApplicationInfo> it = activity.getPackageManager().getInstalledApplications(128).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ApplicationInfo next = it.next();
                if (packageName.equals(next.packageName)) {
                    str3 = next.sourceDir;
                    break;
                }
            }
            if (str3 != null) {
                String a2 = com.tencent.open.utils.a.a(new File(str3));
                if (!TextUtils.isEmpty(a2)) {
                    f.a("openSDK_LOG.QQAuth", "-->login channelId: " + a2);
                    return a(activity, str, iUiListener, a2, a2, "");
                }
            }
        } catch (Throwable th) {
            f.b("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
            th.printStackTrace();
        }
        f.b("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f39089a.doLogin(activity, str, iUiListener, false, fragment);
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = StringUtil.NULL_STRING;
        }
        if (str3.equals("")) {
            str3 = StringUtil.NULL_STRING;
        }
        if (str4.equals("")) {
            str4 = StringUtil.NULL_STRING;
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f39089a.doLogin(activity, str, iUiListener);
    }

    public void a() {
        this.f39089a.a((IUiListener) null);
    }

    public void a(IUiListener iUiListener) {
        this.f39089a.b(iUiListener);
    }

    public void a(String str, String str2) {
        f.a("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f39090b.setAccessToken(str, str2);
    }

    public void a(Context context, String str) {
        f.a("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f39090b.setOpenId(str);
        com.tencent.connect.a.a.d(context, this.f39090b);
        f.a("openSDK_LOG.QQAuth", "setOpenId() --end");
    }
}
