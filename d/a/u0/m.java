package d.a.u0;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f70666f;

    /* renamed from: g  reason: collision with root package name */
    public static String f70667g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f70668a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70669b;

    /* renamed from: c  reason: collision with root package name */
    public final int f70670c;

    /* renamed from: d  reason: collision with root package name */
    public long f70671d;

    /* renamed from: e  reason: collision with root package name */
    public int f70672e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-455625475, "Ld/a/u0/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-455625475, "Ld/a/u0/m;");
                return;
            }
        }
        f70666f = l.f70665a & true;
        f70667g = "ControlData";
    }

    public m(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70668a = str;
        this.f70669b = i2;
        this.f70670c = i3;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70668a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f70669b != 0 && this.f70670c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f70666f) {
                    Log.d(f70667g, "id " + this.f70668a + " mLimitUnit " + this.f70669b + " mLimitCnt " + this.f70670c + "mCount =  " + this.f70672e + " duration " + ((valueOf.longValue() - this.f70671d) / 1000));
                }
                if (this.f70671d != 0 && (valueOf.longValue() - this.f70671d) / 1000 <= this.f70669b && this.f70672e >= this.f70670c) {
                    if (f70666f) {
                        Log.d(f70667g, "control");
                    }
                    return true;
                }
                if (this.f70671d == 0) {
                    this.f70671d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f70671d) / 1000 > this.f70669b) {
                    this.f70671d = valueOf.longValue();
                    this.f70672e = 0;
                    if (f70666f) {
                        Log.d(f70667g, "reset");
                    }
                }
                this.f70672e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f70672e;
            return i2 != 0 && i2 == this.f70670c;
        }
        return invokeV.booleanValue;
    }
}
