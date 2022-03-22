package h.a.a.e.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProductInfo a;

    /* renamed from: b  reason: collision with root package name */
    public int f45203b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45204c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45205d;

    /* renamed from: e  reason: collision with root package name */
    public int f45206e;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f45203b = Integer.MIN_VALUE;
        this.f45206e = -1;
        this.f45204c = z;
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProductInfo productInfo = this.a;
            if (productInfo != null) {
                return productInfo.destAmount / 100.0d;
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ProductInfo productInfo = this.a;
            if (productInfo != null) {
                return productInfo.srcAmount;
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("PayAmount{currencyType=");
            sb.append(this.f45203b);
            sb.append(", srcAmount=");
            ProductInfo productInfo = this.a;
            sb.append(productInfo != null ? productInfo.srcAmount : 0.0d);
            sb.append(", dstAmount=");
            ProductInfo productInfo2 = this.a;
            sb.append(productInfo2 != null ? productInfo2.destAmount : 0L);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public c(ProductInfo productInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {productInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45203b = Integer.MIN_VALUE;
        this.f45206e = -1;
        this.a = productInfo;
    }

    public c(ProductInfo productInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {productInfo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45203b = Integer.MIN_VALUE;
        this.f45206e = -1;
        this.a = productInfo;
        this.f45203b = i;
    }
}
