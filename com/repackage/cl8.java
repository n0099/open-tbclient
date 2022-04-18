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
/* loaded from: classes5.dex */
public class cl8 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo F0;
    public boolean G0;
    public String H0;
    public String I0;
    public String J0;
    public long K0;
    public int L0;
    public boolean M0;
    public int N0;
    public boolean O0;

    public cl8() {
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
        this.G0 = false;
        this.O0 = false;
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.F0;
            return advertAppInfo == null ? "" : advertAppInfo.h;
        }
        return (String) invokeV.objValue;
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.F0;
            return advertAppInfo == null ? "" : advertAppInfo.a;
        }
        return (String) invokeV.objValue;
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.G0 ? "PB_BANNER" : this.M0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.F0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.i;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.F0;
            return advertAppInfo != null && advertAppInfo.q() == 0;
        }
        return invokeV.booleanValue;
    }

    public void R0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.F0 = advertAppInfo;
            advertAppInfo.s(app);
            this.F0.k = O0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.F0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.F0;
            if (advertAppInfo == null) {
                return 0;
            }
            return mg.e(advertAppInfo.g, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.repackage.uo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!bn4.c().g() && (advertAppInfo = this.F0) != null && (iLegoAdvert = advertAppInfo.i) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.x;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && this.G0) {
                return AdvertAppInfo.x;
            }
            AdvertAppInfo advertAppInfo2 = this.F0;
            if (advertAppInfo2 != null && advertAppInfo2.i != null) {
                int i = advertAppInfo2.c;
                if (i != 1001 && i != -1001) {
                    if (P0() != null) {
                        return AdvertAppInfo.z;
                    }
                    return null;
                }
                return AdvertAppInfo.x;
            }
            return AdvertAppInfo.x;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
