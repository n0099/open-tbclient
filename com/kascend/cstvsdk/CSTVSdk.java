package com.kascend.cstvsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import com.kascend.chushou.player.ui.pk.f;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.cstvsdk.interfaces.SimpleCallback;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.l;
import tv.chushou.a.a.d.b;
import tv.chushou.widget.a.c;
@Keep
@h
/* loaded from: classes5.dex */
public final class CSTVSdk {
    public static final CSTVSdk INSTANCE = new CSTVSdk();
    public static final String TAG = "CSTVSdk";
    public static final int TYPE_LOGIN = 1;
    public static final int TYPE_LOGOUT = 2;
    private static volatile boolean inited;

    public final void startH5(Context context, String str) {
        startH5$default(this, context, str, null, 4, null);
    }

    private CSTVSdk() {
    }

    public final boolean getInitialized() {
        return inited && c.getResources() != null;
    }

    public final void init(SdkConfig sdkConfig) {
        q.m(sdkConfig, "config");
        if (!getInitialized()) {
            synchronized (this) {
                com.kascend.cstvsdk.utils.a.nzV.a(sdkConfig);
                inited = true;
                l lVar = l.nPb;
            }
        }
    }

    public final void openLogin(String str, String str2) {
        q.m(str, "openUid");
        q.m(str2, "accessToken");
        LoginManager.Instance().openLogin(str, b.encrypt(str2), null, null);
    }

    public final void onLoginStatusChanged(int i) {
        tv.chushou.basis.d.b.dWf().d(TAG, "onLoginStatusChanged: " + i);
        if (i == 2) {
            LoginManager.Instance().openLogout(null);
        } else if (i == 1) {
            LoginManager.Instance().openLogout(new a());
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class a implements SimpleCallback {
        a() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onStart() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onSuccess() {
            Application application;
            if (com.kascend.cstvsdk.utils.a.nzV.b() && CSTVSdk.INSTANCE.getInitialized()) {
                Activity e = com.kascend.chushou.d.b.e();
                if (e != null) {
                    application = e;
                } else {
                    Application dWe = tv.chushou.basis.d.b.dWe();
                    q.l((Object) dWe, "Router.application()");
                    application = dWe;
                }
                com.kascend.cstvsdk.utils.a.nzV.b(application);
            }
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onFailure(int i, String str, Object obj) {
        }
    }

    public final void startLiveRoom(Context context, String str, String str2) {
        if (context != null) {
            String str3 = str;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            String str4 = str2;
            if (!(str4 == null || str4.length() == 0)) {
                com.kascend.cstvsdk.utils.a.nzV.a(context, str, str2);
            }
        }
    }

    public static /* synthetic */ void startH5$default(CSTVSdk cSTVSdk, Context context, String str, String str2, int i, Object obj) {
        cSTVSdk.startH5(context, str, (i & 4) != 0 ? null : str2);
    }

    public final void startH5(Context context, String str, String str2) {
        if (context == null) {
            context = tv.chushou.basis.d.b.dWe();
        }
        com.kascend.chushou.d.a.a(context, str, str2);
    }

    public final void check() {
        f.a(inited, "确保调用了fun CSTVSdk.init(config: SdkConfig)方法", new Object[0]);
    }
}
