package com.fun.ad.sdk.internal.api.utils;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.g.h;
import c.g.o0;
import c.g.u0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdReporter {
    public static /* synthetic */ Interceptable $ic;
    public static final o0 a;
    public transient /* synthetic */ FieldHolder $fh;
    public final u0 mAdIdent;

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
        a = o0.a();
    }

    public AdReporter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdIdent = new u0();
    }

    public static void adEvent(u0 u0Var, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, u0Var, obj, objArr) == null) {
            report("ad", u0Var, obj, false, objArr);
        }
    }

    public static void adEvent(boolean z, u0 u0Var, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), u0Var, obj, objArr}) == null) {
            report("ad", u0Var, obj, z, objArr);
        }
    }

    public static void report(String str, u0 u0Var, Object obj, boolean z, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, u0Var, obj, Boolean.valueOf(z), objArr}) == null) {
            report(str, u0Var.a, u0Var.f29352b, u0Var.f29354d, u0Var.f29355e, u0Var.f29353c, obj, z, objArr);
        }
    }

    public static void report(String str, String str2, int i2, String str3, String str4, long j2, Object obj, boolean z, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, Long.valueOf(j2), obj, Boolean.valueOf(z), objArr}) == null) {
            a.c(str, new HashMap<String, Object>(j2, str2, i2, str4, str3, obj, z, objArr) { // from class: com.fun.ad.sdk.internal.api.utils.AdReporter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f56314b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f56315c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f56316d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f56317e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ Object f56318f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ boolean f56319g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ Object[] f56320h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {Long.valueOf(j2), str2, Integer.valueOf(i2), str4, str3, obj, Boolean.valueOf(z), objArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = j2;
                    this.f56314b = str2;
                    this.f56315c = i2;
                    this.f56316d = str4;
                    this.f56317e = str3;
                    this.f56318f = obj;
                    this.f56319g = z;
                    this.f56320h = objArr;
                    put("lid", Long.valueOf(j2));
                    put("sid", str2);
                    put("sidv", Integer.valueOf(i2));
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
                    int i5 = 0;
                    while (true) {
                        Object[] objArr3 = this.f56320h;
                        if (i5 >= objArr3.length) {
                            return;
                        }
                        put(objArr3[i5].toString(), this.f56320h[i5 + 1]);
                        i5 += 2;
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
            int a2 = h.a(funAdSlot.getSid(), pid);
            u0 u0Var = this.mAdIdent;
            String sid = funAdSlot.getSid();
            long currentTimeMillis = System.currentTimeMillis();
            String str = pid.pid;
            String str2 = pid.type;
            u0Var.a = sid;
            u0Var.f29352b = a2;
            u0Var.f29353c = currentTimeMillis;
            u0Var.f29354d = str;
            u0Var.f29355e = str2;
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

    public void recordOnClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            adEvent(z, this.mAdIdent, "onclick", new Object[0]);
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

    public void recordRenderFailed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            adEvent(this.mAdIdent, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
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

    public void recordReward(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            adEvent(this.mAdIdent, "reward", "valid", Boolean.valueOf(z));
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

    public void recordShowSucceed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            adEvent(z, this.mAdIdent, "sh_succeed", new Object[0]);
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

    public void recordVideoErr(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            adEvent(this.mAdIdent, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
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
