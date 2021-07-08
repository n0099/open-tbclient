package d.a.p0.h3.h0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes8.dex */
public class o extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo C0;
    public boolean D0;
    public String E0;
    public String F0;
    public String G0;
    public long H0;
    public int I0;
    public boolean J0;
    public int K0;
    public boolean L0;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D0 = false;
        this.L0 = false;
    }

    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.C0;
            return advertAppInfo == null ? "" : advertAppInfo.S3;
        }
        return (String) invokeV.objValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.C0;
            return advertAppInfo == null ? "" : advertAppInfo.L3;
        }
        return (String) invokeV.objValue;
    }

    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D0 ? "PB_BANNER" : this.J0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.C0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.T3;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.C0;
            return advertAppInfo != null && advertAppInfo.w4() == 0;
        }
        return invokeV.booleanValue;
    }

    public void H0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.C0 = advertAppInfo;
            advertAppInfo.y4(app);
            this.C0.V3 = E0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.C0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.C0;
            if (advertAppInfo == null) {
                return 0;
            }
            return d.a.c.e.m.b.d(advertAppInfo.R3, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!d.a.o0.r.k.c().g() && (advertAppInfo = this.C0) != null && (iLegoAdvert = advertAppInfo.T3) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.g4;
            }
            if (d.a.o0.b.d.L() && this.D0) {
                return AdvertAppInfo.g4;
            }
            AdvertAppInfo advertAppInfo2 = this.C0;
            if (advertAppInfo2 != null && advertAppInfo2.T3 != null) {
                int i2 = advertAppInfo2.N3;
                if (i2 != 1001 && i2 != -1001) {
                    if (F0() != null) {
                        return AdvertAppInfo.i4;
                    }
                    return null;
                }
                return AdvertAppInfo.g4;
            }
            return AdvertAppInfo.g4;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
