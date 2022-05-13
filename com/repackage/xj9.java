package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes7.dex */
public class xj9 implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PidLoader a;
    public final long b;
    public long c;

    /* loaded from: classes7.dex */
    public class a implements fk9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final fk9 a;
        public final /* synthetic */ xj9 b;

        public a(xj9 xj9Var, fk9 fk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj9Var, fk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xj9Var;
            this.a = fk9Var;
        }

        @Override // com.repackage.fk9
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.repackage.fk9
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.a(i, str);
            }
        }

        @Override // com.repackage.fk9
        public void a(boolean z, String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, strArr) == null) {
                this.a.a(z, strArr);
            }
        }

        @Override // com.repackage.fk9
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.c = System.currentTimeMillis();
                this.a.b();
            }
        }

        @Override // com.repackage.fk9
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                this.a.b(i, str);
            }
        }

        @Override // com.repackage.fk9
        public void b(RippedAd rippedAd, String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, rippedAd, strArr) == null) {
                this.a.b(rippedAd, strArr);
            }
        }

        @Override // com.repackage.fk9
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.a.c();
            }
        }

        @Override // com.repackage.fk9
        public void c(RippedAd rippedAd, String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, strArr) == null) {
                this.a.c(rippedAd, strArr);
            }
        }
    }

    public xj9(PidLoader pidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pidLoader;
        this.b = pidLoader.getPid().tmout * 60 * 1000;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(fk9 fk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fk9Var) == null) {
            this.a.addListener(new a(this, fk9Var));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.destroy(z);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getAdCount() : invokeV.intValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunAdType getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getAdType() : (FunAdType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) ? this.a.getNativeAd(context, str) : (FunNativeAd) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) ? this.a.getNativeAd2(context, str) : (FunNativeAd2) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getPid() : (Ssp.Pid) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public RippedAd getRippedAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getRippedAd() : (RippedAd) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.isLoaded() && System.currentTimeMillis() - this.c < this.b : invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean load(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, funAdSlot)) == null) ? this.a.load(context, funAdSlot) : invokeLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(fk9 fk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fk9Var) == null) {
            this.a.removeListener(fk9Var);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean show(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, activity, viewGroup, str, funNativeAdInflater)) == null) ? this.a.show(activity, viewGroup, str, funNativeAdInflater) : invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, activity, viewGroup, str)) == null) ? this.a.showSplash(activity, viewGroup, str) : (FunSplashAd) invokeLLL.objValue;
    }
}
