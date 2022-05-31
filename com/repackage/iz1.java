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
public class iz1 {
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
                iz1.b(this.a, i);
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
            j63 j63Var = new j63();
            j63Var.a = "swan";
            j63Var.b = str;
            j63Var.a("appid", gz2.J().getAppId());
            j63Var.a(DpStatConstants.KEY_NETWORK_STATUS, str2);
            if (!TextUtils.isEmpty(str3)) {
                j63Var.a("request", str3);
                j63Var.a("request_total", String.valueOf(i));
                j63Var.a("request_fail", String.valueOf(i2));
                j63Var.a("request_slow", String.valueOf(i3));
                j63Var.a("error_duration", String.valueOf(j));
            }
            j63Var.a("jserror", mz1.d().c() ? "1" : "0");
            j63Var.a(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, hz1.b() ? "1" : "0");
            a63.x("1619", j63Var);
        }
    }
}
