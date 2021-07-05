package d.a.s0.a0.e0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.n0;
/* loaded from: classes9.dex */
public class d extends BaseCardInfo implements p, n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f57055e;

    /* renamed from: f  reason: collision with root package name */
    public String f57056f;

    /* renamed from: g  reason: collision with root package name */
    public int f57057g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57058h;

    public d(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertAppInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57056f = "";
        this.f57057g = 0;
        this.f57058h = false;
        this.f57055e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.a.s0.a0.e0.p
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    public AdvertAppInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57055e : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // d.a.r0.r.q.n0
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57058h : invokeV.booleanValue;
    }

    @Override // d.a.r0.r.q.n0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.position : invokeV.intValue;
    }

    @Override // d.a.s0.a0.e0.p
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f57055e;
            return d.a.c.e.m.b.d(advertAppInfo != null ? advertAppInfo.R3 : "-1", -1);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f57055e;
            if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.f4) {
                return AdvertAppInfo.h4;
            }
            AdvertAppInfo advertAppInfo2 = this.f57055e;
            if (advertAppInfo2 == null || (iLegoAdvert = advertAppInfo2.T3) == null) {
                return null;
            }
            BdUniqueId bdUniqueId = AdvertAppInfo.i4;
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            if (goodsStyle != 2) {
                if (goodsStyle != 6) {
                    if (goodsStyle != 7) {
                        if (goodsStyle != 8) {
                            switch (goodsStyle) {
                                case 12:
                                    return AdvertAppInfo.n4;
                                case 13:
                                    return AdvertAppInfo.m4;
                                case 14:
                                    break;
                                default:
                                    return bdUniqueId;
                            }
                        }
                    }
                    return AdvertAppInfo.l4;
                }
                return AdvertAppInfo.k4;
            }
            return AdvertAppInfo.j4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.s0.a0.e0.p
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.r0.r.q.n0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57055e : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // d.a.s0.a0.e0.p
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.r0.r.q.n0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.position = i2;
            this.f57055e.position = i2;
            this.f57058h = true;
        }
    }

    public d() {
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
        this.f57056f = "";
        this.f57057g = 0;
        this.f57058h = false;
        this.f57055e = null;
        this.position = -1;
    }
}
