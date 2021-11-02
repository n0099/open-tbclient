package i.a.a.b.b.a;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f72170a;

    /* renamed from: b  reason: collision with root package name */
    public PayType f72171b;

    /* renamed from: c  reason: collision with root package name */
    public long f72172c;

    /* renamed from: d  reason: collision with root package name */
    public String f72173d;

    /* renamed from: e  reason: collision with root package name */
    public ProductInfo f72174e;

    /* renamed from: f  reason: collision with root package name */
    public int f72175f;

    /* renamed from: g  reason: collision with root package name */
    public int f72176g;

    /* renamed from: h  reason: collision with root package name */
    public IMiddlePayService.SubscriptType f72177h;

    /* renamed from: i  reason: collision with root package name */
    public IMiddlePayService.ChargeSource f72178i;
    public String j;
    public Map<String, Object> k;
    public IPayCallback<String> l;
    public IToken m;
    public AppCustomExpand n;
    public String o;

    public a() {
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
        this.f72171b = PayType.ALI_PAY;
        this.f72173d = "";
        this.f72177h = IMiddlePayService.SubscriptType.NORMAL_CHARGE;
        this.f72178i = IMiddlePayService.ChargeSource.WALLET_CHARGE;
        this.j = "";
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f72175f = i2;
        }
    }

    public final AppCustomExpand a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (AppCustomExpand) invokeV.objValue;
    }

    public final IPayCallback<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (IPayCallback) invokeV.objValue;
    }

    public final IMiddlePayService.ChargeSource c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72178i : (IMiddlePayService.ChargeSource) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72176g : invokeV.intValue;
    }

    public final Map<String, Object> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (Map) invokeV.objValue;
    }

    public final ProductInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ProductInfo productInfo = this.f72174e;
            if (productInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("info");
            }
            return productInfo;
        }
        return (ProductInfo) invokeV.objValue;
    }

    public final PayType g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72171b : (PayType) invokeV.objValue;
    }

    public final Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Activity activity = this.f72170a;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final IMiddlePayService.SubscriptType i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f72177h : (IMiddlePayService.SubscriptType) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f72173d : (String) invokeV.objValue;
    }

    public final IToken k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (IToken) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public final long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f72172c : invokeV.longValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f72175f : invokeV.intValue;
    }

    public final void o(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            this.f72170a = activity;
        }
    }

    public final void p(AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, appCustomExpand) == null) {
            this.n = appCustomExpand;
        }
    }

    public final void q(IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iPayCallback) == null) {
            this.l = iPayCallback;
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f72176g = i2;
        }
    }

    public final void s(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            this.k = map;
        }
    }

    public final void t(ProductInfo productInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, productInfo) == null) {
            this.f72174e = productInfo;
        }
    }

    public final void u(PayType payType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, payType) == null) {
            this.f72171b = payType;
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.j = str;
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f72173d = str;
        }
    }

    public final void x(IToken iToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iToken) == null) {
            this.m = iToken;
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.o = str;
        }
    }

    public final void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.f72172c = j;
        }
    }
}
