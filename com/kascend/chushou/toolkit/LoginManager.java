package com.kascend.chushou.toolkit;

import android.app.Activity;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.view.base.BaseActivity;
import com.kascend.cstvsdk.interfaces.SimpleCallback;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
@Keep
/* loaded from: classes5.dex */
public class LoginManager {
    private static final String TAG = "LoginManager";
    private static volatile LoginManager sInstance;
    private MyUserInfo mUserInfo;

    public static LoginManager Instance() {
        if (sInstance == null) {
            synchronized (LoginManager.class) {
                if (sInstance == null) {
                    sInstance = new LoginManager();
                }
            }
        }
        return sInstance;
    }

    private LoginManager() {
    }

    public boolean islogined() {
        return this.mUserInfo != null;
    }

    public boolean isMySelf(String str) {
        String str2 = null;
        if (this.mUserInfo != null) {
            str2 = this.mUserInfo.mUserID;
        }
        return !h.isEmpty(str) && str.equals(str2);
    }

    public MyUserInfo getUserInfo() {
        return this.mUserInfo;
    }

    public void baiduLogin(String str) {
        com.kascend.chushou.c.c.dDV().e(str, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.toolkit.LoginManager.1
            @Override // com.kascend.chushou.c.b
            public void a() {
                RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 30L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.toolkit.LoginManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LoginManager.this.showProcessDialog(true);
                    }
                });
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str2, JSONObject jSONObject) {
                LoginManager.this.showProcessDialog(false);
                g.Kz(a.i.cs_baidu_login_success);
                ParserRet dF = com.kascend.chushou.c.g.dF(jSONObject);
                if (dF.mRc == 0 && dF.mData != null) {
                    LoginManager.this.userLoginIn((MyUserInfo) dF.mData);
                    return;
                }
                a(dF.mRc, dF.mMessage);
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str2) {
                LoginManager.this.showProcessDialog(false);
                LoginManager.this.userLogout();
                g.Kz(a.i.cs_baidu_login_failed);
            }
        });
    }

    public void openLogin(String str, String str2, String str3, final SimpleCallback simpleCallback) {
        com.kascend.chushou.c.c.dDV().a(str, str2, str3, new JsonCallbackWrapper() { // from class: com.kascend.chushou.toolkit.LoginManager.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str4, JSONObject jSONObject) {
                ParserRet dF = com.kascend.chushou.c.g.dF(jSONObject);
                if (dF.mRc == 0 && dF.mData != null) {
                    LoginManager.this.userLoginIn((MyUserInfo) dF.mData);
                    if (simpleCallback != null) {
                        simpleCallback.onSuccess();
                        return;
                    }
                    return;
                }
                callFailure(dF.mRc, dF.mMessage, str4);
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str4, @Nullable String str5) {
                LoginManager.this.userLogout();
                if (simpleCallback != null) {
                    simpleCallback.onFailure(i, str4, str5);
                }
            }
        });
    }

    public void autoLogin(final SimpleCallback simpleCallback) {
        com.kascend.chushou.c.c.dDV().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.toolkit.LoginManager.3
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
                if (simpleCallback != null) {
                    simpleCallback.onStart();
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str, JSONObject jSONObject) {
                ParserRet dF = com.kascend.chushou.c.g.dF(jSONObject);
                if (dF.mRc == 0 && dF.mData != null) {
                    LoginManager.this.userLoginIn((MyUserInfo) dF.mData);
                    if (simpleCallback != null) {
                        simpleCallback.onSuccess();
                        return;
                    }
                    return;
                }
                callFailure(dF.mRc, dF.mMessage, str);
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str, @Nullable String str2) {
                if (simpleCallback != null) {
                    simpleCallback.onFailure(i, str, str2);
                }
            }
        });
    }

    public void openLogout(final SimpleCallback simpleCallback) {
        if (simpleCallback != null) {
            simpleCallback.onStart();
        }
        if (islogined()) {
            com.kascend.chushou.c.c.dDV().b(new JsonCallbackWrapper() { // from class: com.kascend.chushou.toolkit.LoginManager.4
                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callStart() {
                }

                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callSuccess(String str, JSONObject jSONObject) {
                    LoginManager.this.userLogout();
                    if (simpleCallback != null) {
                        simpleCallback.onSuccess();
                    }
                }

                @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
                public void callFailure(int i, @Nullable String str, @Nullable String str2) {
                    LoginManager.this.userLogout();
                    if (simpleCallback != null) {
                        simpleCallback.onSuccess();
                    }
                }
            });
            return;
        }
        userLogout();
        if (simpleCallback != null) {
            simpleCallback.onSuccess();
        }
    }

    public void userLogout() {
        this.mUserInfo = null;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dRm().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            aVar.remove("token");
        }
        com.kascend.chushou.d.h.dDZ().h();
        com.kascend.chushou.d.h.dDZ().e("");
        com.kascend.chushou.d.h.dDZ().d(false);
        com.kascend.chushou.d.h.dDZ().c(false);
        tv.chushou.zues.a.a.post(new i(1, true));
        tv.chushou.basis.d.b.dRl().d(TAG, "userLogout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userLoginIn(MyUserInfo myUserInfo) {
        this.mUserInfo = myUserInfo;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dRm().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            aVar.putString("token", myUserInfo.mToken);
        }
        com.kascend.chushou.d.h.dDZ().a(myUserInfo);
        com.kascend.chushou.d.h.dDZ().e(myUserInfo.mToken);
        tv.chushou.zues.a.a.post(new i(0, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProcessDialog(boolean z) {
        Activity e = com.kascend.chushou.d.b.e();
        if ((e instanceof BaseActivity) && !e.isFinishing()) {
            ((BaseActivity) e).i(z);
        }
    }
}
