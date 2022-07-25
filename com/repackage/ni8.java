package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes6.dex */
public class ni8 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo I0;
    public boolean J0;
    public String K0;
    public String L0;
    public String M0;
    public long N0;
    public int O0;
    public boolean P0;
    public int Q0;

    public ni8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J0 = false;
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            return advertAppInfo == null ? "" : advertAppInfo.g;
        }
        return (String) invokeV.objValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            return advertAppInfo == null ? "" : advertAppInfo.a;
        }
        return (String) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.J0 ? "PB_BANNER" : this.P0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.h;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            return advertAppInfo != null && advertAppInfo.m() == 0;
        }
        return invokeV.booleanValue;
    }

    public void V0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.I0 = advertAppInfo;
            advertAppInfo.s(app);
            this.I0.j = S0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            if (advertAppInfo == null) {
                return 0;
            }
            return ng.e(advertAppInfo.f, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!an4.c().g() && (advertAppInfo = this.I0) != null && (iLegoAdvert = advertAppInfo.h) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.u;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && this.J0) {
                return AdvertAppInfo.u;
            }
            AdvertAppInfo advertAppInfo2 = this.I0;
            if (advertAppInfo2 != null && advertAppInfo2.h != null) {
                int i = advertAppInfo2.c;
                if (i != 1001 && i != -1001) {
                    if (T0() != null) {
                        return AdvertAppInfo.w;
                    }
                    return null;
                }
                return AdvertAppInfo.u;
            }
            return AdvertAppInfo.u;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
