package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class EcOrderCardStyle {
    public static final /* synthetic */ EcOrderCardStyle[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EcOrderCardStyle COUPON;
    public static final EcOrderCardStyle DEFAULT;
    public static final EcOrderCardStyle NO_SPIKE_AND_NO_COUPON;
    public static final EcOrderCardStyle SPIKE;
    public static final EcOrderCardStyle SPIKE_AND_COUPON;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(529639741, "Lcom/kwad/components/ad/reward/model/EcOrderCardStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(529639741, "Lcom/kwad/components/ad/reward/model/EcOrderCardStyle;");
                return;
            }
        }
        SPIKE_AND_COUPON = new EcOrderCardStyle("SPIKE_AND_COUPON", 0, 1);
        SPIKE = new EcOrderCardStyle("SPIKE", 1, 2);
        COUPON = new EcOrderCardStyle("COUPON", 2, 3);
        NO_SPIKE_AND_NO_COUPON = new EcOrderCardStyle("NO_SPIKE_AND_NO_COUPON", 3, 4);
        EcOrderCardStyle ecOrderCardStyle = new EcOrderCardStyle(EngineName.DEFAULT_ENGINE, 4, 5);
        DEFAULT = ecOrderCardStyle;
        $VALUES = new EcOrderCardStyle[]{SPIKE_AND_COUPON, SPIKE, COUPON, NO_SPIKE_AND_NO_COUPON, ecOrderCardStyle};
    }

    public EcOrderCardStyle(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i2;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) {
            if (com.kwad.components.ad.reward.kwai.b.j(adInfo) || com.kwad.components.ad.reward.kwai.b.i(adInfo)) {
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
                boolean hasSpike = bN.hasSpike();
                boolean hasCoupon = bN.hasCoupon();
                return (hasSpike && hasCoupon) ? SPIKE_AND_COUPON : hasSpike ? SPIKE : hasCoupon ? COUPON : bN.hasOriginalPrice() ? NO_SPIKE_AND_NO_COUPON : DEFAULT;
            }
            return null;
        }
        return (EcOrderCardStyle) invokeL.objValue;
    }

    public static EcOrderCardStyle valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (EcOrderCardStyle) Enum.valueOf(EcOrderCardStyle.class, str) : (EcOrderCardStyle) invokeL.objValue;
    }

    public static EcOrderCardStyle[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (EcOrderCardStyle[]) $VALUES.clone() : (EcOrderCardStyle[]) invokeV.objValue;
    }

    public final int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
