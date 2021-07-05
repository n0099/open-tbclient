package d.a.r0.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Long f55428a;

    /* renamed from: b  reason: collision with root package name */
    public int f55429b;

    /* renamed from: c  reason: collision with root package name */
    public Long f55430c;

    /* renamed from: d  reason: collision with root package name */
    public int f55431d;

    /* renamed from: e  reason: collision with root package name */
    public String f55432e;

    /* renamed from: f  reason: collision with root package name */
    public String f55433f;

    /* renamed from: g  reason: collision with root package name */
    public int f55434g;

    /* renamed from: h  reason: collision with root package name */
    public Long f55435h;

    /* renamed from: i  reason: collision with root package name */
    public int f55436i;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "YYPayResult{amount=" + this.f55428a + ", appid=" + this.f55429b + ", currencyAmount=" + this.f55430c + ", currencyType=" + this.f55431d + ", expand='" + this.f55432e + "', orderId='" + this.f55433f + "', status=" + this.f55434g + ", uid=" + this.f55435h + ", usedChannel=" + this.f55436i + '}';
        }
        return (String) invokeV.objValue;
    }
}
