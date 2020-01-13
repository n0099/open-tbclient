package com.kascend.cstvsdk.interfaces;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import com.kascend.cstvsdk.bean.LoginParam;
import com.kascend.cstvsdk.bean.LoginResp;
import com.kascend.cstvsdk.bean.ShareParam;
import tv.chushou.basis.d.a;
@Keep
/* loaded from: classes4.dex */
public interface ThirdParty extends a {
    tv.chushou.common.player.a createPlayer();

    boolean isLogined();

    void jumpToLogin(Context context, LoginParam loginParam, Callback<LoginResp> callback);

    void jumpToRecharge(Context context, Callback<Object> callback);

    void onEnterLiveRoom(Activity activity);

    void onExitLiveRoom(Activity activity);

    void share(Context context, ShareParam shareParam, ShareListener shareListener);
}
