package com.kascend.cstvsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import com.kascend.chushou.player.ui.pk.f;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.cstvsdk.interfaces.SimpleCallback;
import kotlin.jvm.internal.q;
import kotlin.k;
import tv.chushou.a.a.d.b;
@Keep
/* loaded from: classes4.dex */
public final class CSTVSdk {
    public static final CSTVSdk INSTANCE = new CSTVSdk();
    public static final String TAG = "CSTVSdk";
    public static final int TYPE_LOGIN = 1;
    public static final int TYPE_LOGOUT = 2;
    private static volatile boolean initialized;

    private CSTVSdk() {
    }

    public final boolean getInitialized() {
        return initialized;
    }

    public final void setInitialized(boolean z) {
        initialized = z;
    }

    public final void init(SdkConfig sdkConfig) {
        q.j(sdkConfig, "config");
        if (!initialized) {
            synchronized (this) {
                com.kascend.cstvsdk.utils.a.njI.a(sdkConfig);
                initialized = true;
                k kVar = k.nAY;
            }
        }
    }

    public final void openLogin(String str, String str2) {
        q.j(str, "openUid");
        q.j(str2, "accessToken");
        LoginManager.Instance().openLogin(str, b.encrypt(str2), null, null);
    }

    public final void onLoginStatusChanged(int i) {
        tv.chushou.basis.d.b.dOF().d(TAG, "onLoginStatusChanged: " + i);
        if (i == 2) {
            LoginManager.Instance().openLogout(null);
        } else if (i == 1) {
            LoginManager.Instance().openLogout(new a());
        }
    }

    /* loaded from: classes4.dex */
    public static final class a implements SimpleCallback {
        a() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onStart() {
        }

        @Override // com.kascend.cstvsdk.interfaces.SimpleCallback
        public void onSuccess() {
            Application application;
            if (com.kascend.cstvsdk.utils.a.njI.b() && CSTVSdk.INSTANCE.getInitialized()) {
                Activity e = com.kascend.chushou.d.b.e();
                if (e != null) {
                    application = e;
                } else {
                    Application dOE = tv.chushou.basis.d.b.dOE();
                    q.i(dOE, "Router.application()");
                    application = dOE;
                }
                com.kascend.cstvsdk.utils.a.njI.b(application);
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
                com.kascend.cstvsdk.utils.a.njI.a(context, str, str2);
            }
        }
    }

    public final void check() {
        f.a(initialized, "确保调用了fun CSTVSdk.init(config: SdkConfig)方法", new Object[0]);
    }
}
