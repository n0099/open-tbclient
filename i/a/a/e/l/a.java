package i.a.a.e.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ProductInfo f75848a;

    /* renamed from: b  reason: collision with root package name */
    public int f75849b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75850c;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f75849b = Integer.MIN_VALUE;
        this.f75850c = z;
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProductInfo productInfo = this.f75848a;
            if (productInfo != null) {
                return productInfo.destAmount / 100.0d;
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public Double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ProductInfo productInfo = this.f75848a;
            if (productInfo != null) {
                return productInfo.srcAmount;
            }
            return Double.valueOf(0.0d);
        }
        return (Double) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("PayAmount{currencyType=");
            sb.append(this.f75849b);
            sb.append(", srcAmount=");
            ProductInfo productInfo = this.f75848a;
            sb.append(productInfo != null ? productInfo.srcAmount.doubleValue() : 0.0d);
            sb.append(", dstAmount=");
            ProductInfo productInfo2 = this.f75848a;
            sb.append(productInfo2 != null ? productInfo2.destAmount : 0L);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public a(ProductInfo productInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {productInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75849b = Integer.MIN_VALUE;
        this.f75848a = productInfo;
    }

    public a(ProductInfo productInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {productInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75849b = Integer.MIN_VALUE;
        this.f75848a = productInfo;
        this.f75849b = i2;
    }
}
