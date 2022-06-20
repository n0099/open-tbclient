package com.fun.ad.sdk.internal.api.utils;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.repackage.ob9;
import com.repackage.vg9;
import com.repackage.xb9;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AdReporter {
    public static /* synthetic */ Interceptable $ic;
    public static final Reporter a;
    public transient /* synthetic */ FieldHolder $fh;
    public final vg9 mAdIdent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1543495945, "Lcom/fun/ad/sdk/internal/api/utils/AdReporter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1543495945, "Lcom/fun/ad/sdk/internal/api/utils/AdReporter;");
                return;
            }
        }
        a = xb9.a();
    }

    public AdReporter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdIdent = new vg9();
    }

    public static void adEvent(vg9 vg9Var, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, vg9Var, obj, objArr) == null) {
            report(LaunchStatsUtils.AD, vg9Var, obj, false, objArr);
        }
    }

    public static void adEvent(boolean z, vg9 vg9Var, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), vg9Var, obj, objArr}) == null) {
            report(LaunchStatsUtils.AD, vg9Var, obj, z, objArr);
        }
    }

    public static void report(String str, vg9 vg9Var, Object obj, boolean z, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, vg9Var, obj, Boolean.valueOf(z), objArr}) == null) {
            report(str, vg9Var.a, vg9Var.b, vg9Var.d, vg9Var.e, vg9Var.c, obj, z, objArr);
        }
    }

    public static void report(String str, String str2, int i, String str3, String str4, long j, Object obj, boolean z, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Integer.valueOf(i), str3, str4, Long.valueOf(j), obj, Boolean.valueOf(z), objArr}) == null) {
            a.logEvent(str, new HashMap<String, Object>(j, str2, i, str4, str3, obj, z, objArr) { // from class: com.fun.ad.sdk.internal.api.utils.AdReporter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ String b;
                public final /* synthetic */ int c;
                public final /* synthetic */ String d;
                public final /* synthetic */ String e;
                public final /* synthetic */ Object f;
                public final /* synthetic */ boolean g;
                public final /* synthetic */ Object[] h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {Long.valueOf(j), str2, Integer.valueOf(i), str4, str3, obj, Boolean.valueOf(z), objArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = j;
                    this.b = str2;
                    this.c = i;
                    this.d = str4;
                    this.e = str3;
                    this.f = obj;
                    this.g = z;
                    this.h = objArr;
                    put("lid", Long.valueOf(j));
                    put("sid", str2);
                    put("sidv", Integer.valueOf(i));
                    put("type", str4);
                    put("aid", str3);
                    put("st", obj);
                    put("dup", Integer.valueOf(z ? 1 : 0));
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    if (objArr.length % 2 != 0) {
                        throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                    }
                    int i4 = 0;
                    while (true) {
                        Object[] objArr3 = this.h;
                        if (i4 >= objArr3.length) {
                            return;
                        }
                        put(objArr3[i4].toString(), this.h[i4 + 1]);
                        i4 += 2;
                    }
                }
            });
        }
    }

    public void recordCloseOverlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            adEvent(this.mAdIdent, "overlay_close", new Object[0]);
        }
    }

    public void recordLeftApplication() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            adEvent(this.mAdIdent, "left_app", new Object[0]);
        }
    }

    public void recordLoadFailed(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            adEvent(this.mAdIdent, "ld_err", NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void recordLoadStart(FunAdSlot funAdSlot, Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, funAdSlot, pid) == null) {
            int a2 = ob9.a(funAdSlot.getSid(), pid);
            vg9 vg9Var = this.mAdIdent;
            String sid = funAdSlot.getSid();
            long currentTimeMillis = System.currentTimeMillis();
            String str = pid.pid;
            String str2 = pid.type;
            vg9Var.a = sid;
            vg9Var.b = a2;
            vg9Var.c = currentTimeMillis;
            vg9Var.d = str;
            vg9Var.e = str2;
            adEvent(this.mAdIdent, "ld_start", new Object[0]);
        }
    }

    public void recordLoadSucceed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            adEvent(this.mAdIdent, "ld_succeed", new Object[0]);
        }
    }

    public void recordOnCached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            adEvent(this.mAdIdent, "oncached", new Object[0]);
        }
    }

    public void recordOnClicked(boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, strArr) == null) {
            String str = (strArr == null || strArr.length <= 0) ? "" : strArr[0];
            if (TextUtils.isEmpty(str)) {
                adEvent(z, this.mAdIdent, "onclick", new Object[0]);
            } else {
                adEvent(z, this.mAdIdent, "onclick", "tid", str);
            }
        }
    }

    public void recordOnClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            adEvent(this.mAdIdent, "onclosed", new Object[0]);
        }
    }

    public void recordOpenOverlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            adEvent(this.mAdIdent, "overlay_open", new Object[0]);
        }
    }

    public void recordRenderFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            adEvent(this.mAdIdent, "render_failed", new Object[0]);
        }
    }

    public void recordRenderFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            adEvent(this.mAdIdent, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
        }
    }

    public void recordRenderSucceed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            adEvent(this.mAdIdent, "render_succeed", new Object[0]);
        }
    }

    public void recordReward() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            adEvent(this.mAdIdent, "reward", new Object[0]);
        }
    }

    public void recordReward(boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, strArr) == null) {
            String str = (strArr == null || strArr.length <= 0) ? "" : strArr[0];
            if (TextUtils.isEmpty(str)) {
                adEvent(this.mAdIdent, "reward", "valid", Boolean.valueOf(z));
            } else {
                adEvent(this.mAdIdent, "reward", "valid", Boolean.valueOf(z), "tid", str);
            }
        }
    }

    public void recordShowFailed(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, obj) == null) {
            adEvent(this.mAdIdent, "sh_failed", NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void recordShowStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            adEvent(this.mAdIdent, "sh_start", new Object[0]);
        }
    }

    public void recordShowStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            adEvent(z, this.mAdIdent, "sh_start", new Object[0]);
        }
    }

    public void recordShowSucceed(boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, strArr) == null) {
            String str = (strArr == null || strArr.length <= 0) ? "" : strArr[0];
            if (TextUtils.isEmpty(str)) {
                adEvent(z, this.mAdIdent, "sh_succeed", new Object[0]);
            } else {
                adEvent(z, this.mAdIdent, "sh_succeed", "tid", str);
            }
        }
    }

    public void recordSplashSkip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            adEvent(this.mAdIdent, "splash_skip", new Object[0]);
        }
    }

    public void recordSplashTimeOver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            adEvent(this.mAdIdent, "splash_timeover", new Object[0]);
        }
    }

    public void recordUnlikeCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            adEvent(this.mAdIdent, "unlike_canceled", new Object[0]);
        }
    }

    public void recordUnlikeSelected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            adEvent(this.mAdIdent, "unlike_selected", new Object[0]);
        }
    }

    public void recordVideoCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            adEvent(this.mAdIdent, "video_complete", new Object[0]);
        }
    }

    public void recordVideoErr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            adEvent(this.mAdIdent, "video_err", new Object[0]);
        }
    }

    public void recordVideoErr(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            adEvent(this.mAdIdent, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
        }
    }

    public void recordVideoPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            adEvent(this.mAdIdent, "video_pause", new Object[0]);
        }
    }

    public void recordVideoResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            adEvent(this.mAdIdent, "video_resume", new Object[0]);
        }
    }

    public void recordVideoSkipped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            adEvent(this.mAdIdent, "video_skip", new Object[0]);
        }
    }

    public void recordVideoStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            adEvent(this.mAdIdent, "video_start", new Object[0]);
        }
    }
}
