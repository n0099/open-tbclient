package d.a.p0.n0;

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
    public Long f52790a;

    /* renamed from: b  reason: collision with root package name */
    public int f52791b;

    /* renamed from: c  reason: collision with root package name */
    public Long f52792c;

    /* renamed from: d  reason: collision with root package name */
    public int f52793d;

    /* renamed from: e  reason: collision with root package name */
    public String f52794e;

    /* renamed from: f  reason: collision with root package name */
    public String f52795f;

    /* renamed from: g  reason: collision with root package name */
    public int f52796g;

    /* renamed from: h  reason: collision with root package name */
    public Long f52797h;

    /* renamed from: i  reason: collision with root package name */
    public int f52798i;

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
            return "YYPayResult{amount=" + this.f52790a + ", appid=" + this.f52791b + ", currencyAmount=" + this.f52792c + ", currencyType=" + this.f52793d + ", expand='" + this.f52794e + "', orderId='" + this.f52795f + "', status=" + this.f52796g + ", uid=" + this.f52797h + ", usedChannel=" + this.f52798i + '}';
        }
        return (String) invokeV.objValue;
    }
}
