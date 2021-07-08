package d.a.o0.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Long f52134a;

    /* renamed from: b  reason: collision with root package name */
    public int f52135b;

    /* renamed from: c  reason: collision with root package name */
    public Long f52136c;

    /* renamed from: d  reason: collision with root package name */
    public int f52137d;

    /* renamed from: e  reason: collision with root package name */
    public String f52138e;

    /* renamed from: f  reason: collision with root package name */
    public String f52139f;

    /* renamed from: g  reason: collision with root package name */
    public int f52140g;

    /* renamed from: h  reason: collision with root package name */
    public Long f52141h;

    /* renamed from: i  reason: collision with root package name */
    public int f52142i;

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
            return "YYPayResult{amount=" + this.f52134a + ", appid=" + this.f52135b + ", currencyAmount=" + this.f52136c + ", currencyType=" + this.f52137d + ", expand='" + this.f52138e + "', orderId='" + this.f52139f + "', status=" + this.f52140g + ", uid=" + this.f52141h + ", usedChannel=" + this.f52142i + '}';
        }
        return (String) invokeV.objValue;
    }
}
