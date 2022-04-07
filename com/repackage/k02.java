package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements SwanAppNetworkUtils.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                k02.b(this.a, i);
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            SwanAppNetworkUtils.b(new a(str));
        }
    }

    public static void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) {
            c(str, i != 1 ? i != 2 ? i != 3 ? "unknown" : "offline" : "bad" : FrsActivityConfig.GOOD);
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            d(str, str2, null);
        }
    }

    public static void d(String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            e(str, str2, str3, 0, 0, 0, 0L);
        }
    }

    public static void e(String str, String str2, @Nullable String str3, int i, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            l73 l73Var = new l73();
            l73Var.a = "swan";
            l73Var.b = str;
            l73Var.a("appid", i03.J().getAppId());
            l73Var.a(DpStatConstants.KEY_NETWORK_STATUS, str2);
            if (!TextUtils.isEmpty(str3)) {
                l73Var.a("request", str3);
                l73Var.a("request_total", String.valueOf(i));
                l73Var.a("request_fail", String.valueOf(i2));
                l73Var.a("request_slow", String.valueOf(i3));
                l73Var.a("error_duration", String.valueOf(j));
            }
            l73Var.a("jserror", o02.d().c() ? "1" : "0");
            l73Var.a(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, j02.b() ? "1" : "0");
            c73.x("1619", l73Var);
        }
    }
}
