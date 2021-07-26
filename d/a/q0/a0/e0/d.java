package d.a.q0.a0.e0;

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
import d.a.p0.s.q.n0;
/* loaded from: classes7.dex */
public class d extends BaseCardInfo implements p, n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f54343e;

    /* renamed from: f  reason: collision with root package name */
    public String f54344f;

    /* renamed from: g  reason: collision with root package name */
    public int f54345g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54346h;

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
        this.f54344f = "";
        this.f54345g = 0;
        this.f54346h = false;
        this.f54343e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.a.q0.a0.e0.p
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    public AdvertAppInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54343e : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.n0
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54346h : invokeV.booleanValue;
    }

    @Override // d.a.p0.s.q.n0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.position : invokeV.intValue;
    }

    @Override // d.a.q0.a0.e0.p
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f54343e;
            return d.a.d.e.m.b.d(advertAppInfo != null ? advertAppInfo.X3 : "-1", -1);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f54343e;
            if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.l4) {
                return AdvertAppInfo.n4;
            }
            AdvertAppInfo advertAppInfo2 = this.f54343e;
            if (advertAppInfo2 == null || (iLegoAdvert = advertAppInfo2.Z3) == null) {
                return null;
            }
            BdUniqueId bdUniqueId = AdvertAppInfo.o4;
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            if (goodsStyle != 2) {
                if (goodsStyle != 6) {
                    if (goodsStyle != 7) {
                        if (goodsStyle != 8) {
                            switch (goodsStyle) {
                                case 12:
                                    return AdvertAppInfo.t4;
                                case 13:
                                    return AdvertAppInfo.s4;
                                case 14:
                                    break;
                                default:
                                    return bdUniqueId;
                            }
                        }
                    }
                    return AdvertAppInfo.r4;
                }
                return AdvertAppInfo.q4;
            }
            return AdvertAppInfo.p4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.q0.a0.e0.p
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.s.q.n0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f54343e : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // d.a.q0.a0.e0.p
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.p0.s.q.n0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.position = i2;
            this.f54343e.position = i2;
            this.f54346h = true;
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
        this.f54344f = "";
        this.f54345g = 0;
        this.f54346h = false;
        this.f54343e = null;
        this.position = -1;
    }
}
