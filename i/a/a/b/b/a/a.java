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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f72752a;

    /* renamed from: b  reason: collision with root package name */
    public PayType f72753b;

    /* renamed from: c  reason: collision with root package name */
    public long f72754c;

    /* renamed from: d  reason: collision with root package name */
    public String f72755d;

    /* renamed from: e  reason: collision with root package name */
    public ProductInfo f72756e;

    /* renamed from: f  reason: collision with root package name */
    public int f72757f;

    /* renamed from: g  reason: collision with root package name */
    public int f72758g;

    /* renamed from: h  reason: collision with root package name */
    public IMiddlePayService.SubscriptType f72759h;

    /* renamed from: i  reason: collision with root package name */
    public IMiddlePayService.ChargeSource f72760i;
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
        this.f72753b = PayType.ALI_PAY;
        this.f72755d = "";
        this.f72759h = IMiddlePayService.SubscriptType.NORMAL_CHARGE;
        this.f72760i = IMiddlePayService.ChargeSource.WALLET_CHARGE;
        this.j = "";
    }

    public final void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f72754c = j;
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f72757f = i2;
        }
    }

    public final Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Activity activity = this.f72752a;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    public final AppCustomExpand b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (AppCustomExpand) invokeV.objValue;
    }

    public final IPayCallback<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (IPayCallback) invokeV.objValue;
    }

    public final IMiddlePayService.ChargeSource d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72760i : (IMiddlePayService.ChargeSource) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f72758g : invokeV.intValue;
    }

    public final Map<String, Object> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (Map) invokeV.objValue;
    }

    public final ProductInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ProductInfo productInfo = this.f72756e;
            if (productInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("info");
            }
            return productInfo;
        }
        return (ProductInfo) invokeV.objValue;
    }

    public final PayType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f72753b : (PayType) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final IMiddlePayService.SubscriptType j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f72759h : (IMiddlePayService.SubscriptType) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f72755d : (String) invokeV.objValue;
    }

    public final IToken l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : (IToken) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f72754c : invokeV.longValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f72757f : invokeV.intValue;
    }

    public final void p(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            this.f72752a = activity;
        }
    }

    public final void q(AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, appCustomExpand) == null) {
            this.n = appCustomExpand;
        }
    }

    public final void r(IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iPayCallback) == null) {
            this.l = iPayCallback;
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f72758g = i2;
        }
    }

    public final void t(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, map) == null) {
            this.k = map;
        }
    }

    public final void u(ProductInfo productInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, productInfo) == null) {
            this.f72756e = productInfo;
        }
    }

    public final void v(PayType payType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, payType) == null) {
            this.f72753b = payType;
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.j = str;
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f72755d = str;
        }
    }

    public final void y(IToken iToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, iToken) == null) {
            this.m = iToken;
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.o = str;
        }
    }
}
