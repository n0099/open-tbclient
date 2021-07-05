package d.a.r0.o0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55513a;

    /* renamed from: b  reason: collision with root package name */
    public int f55514b;

    /* renamed from: c  reason: collision with root package name */
    public String f55515c;

    /* renamed from: d  reason: collision with root package name */
    public String f55516d;

    /* renamed from: e  reason: collision with root package name */
    public String f55517e;

    /* renamed from: f  reason: collision with root package name */
    public long f55518f;

    /* renamed from: g  reason: collision with root package name */
    public long f55519g;

    /* renamed from: h  reason: collision with root package name */
    public long f55520h;

    public b() {
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
        this.f55518f = -1L;
        this.f55519g = -1L;
        this.f55520h = -1L;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55517e : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f55516d = str;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f55513a = i2;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f55515c = str;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f55514b = i2;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f55517e = str;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "-netErrorCode-" + this.f55513a + "-serverCode-" + this.f55514b + "-dnsStatus-" + this.f55516d + "-exception-" + this.f55515c + "-url-" + this.f55517e + "-dataLenth-" + this.f55518f + "-fileLength-" + this.f55519g + "-contentLen-" + this.f55520h;
        }
        return (String) invokeV.objValue;
    }
}
