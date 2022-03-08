package com.dxmpay.apollon.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ImmersiveStatusBarManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImmersiveStatusBarManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void setMiuiFlymeBarDark(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, activity, z) == null) {
            if (Build.VERSION.SDK_INT < 27) {
                if (ImmersiveOSUtils.isMIUI6Plus()) {
                    StatusBarUtils.setMIUIStatusBarDarkFont(activity.getWindow(), z);
                } else if (ImmersiveOSUtils.isFlymeOS4Plus()) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, z);
                }
            }
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void setTopBar(Activity activity, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, activity, view, z) == null) {
            if (ImmersiveOSUtils.isSupportStatusBarDarkFont() && !ImmersiveOSUtils.isSpecialOS()) {
                view.setBackgroundColor(StatusBarUtils.blendARGB(0, -16777216, 0.0f));
                setMiuiFlymeBarDark(activity, z);
                return;
            }
            view.setBackgroundColor(StatusBarUtils.blendARGB(0, -16777216, StatusBarUtils.sBarAlpha));
        }
    }
}
