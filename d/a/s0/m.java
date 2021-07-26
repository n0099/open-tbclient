package d.a.s0;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f68118f;

    /* renamed from: g  reason: collision with root package name */
    public static String f68119g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f68120a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68121b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68122c;

    /* renamed from: d  reason: collision with root package name */
    public long f68123d;

    /* renamed from: e  reason: collision with root package name */
    public int f68124e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457472517, "Ld/a/s0/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457472517, "Ld/a/s0/m;");
                return;
            }
        }
        f68118f = l.f68117a & true;
        f68119g = "ControlData";
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
        this.f68120a = str;
        this.f68121b = i2;
        this.f68122c = i3;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68120a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f68121b != 0 && this.f68122c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f68118f) {
                    Log.d(f68119g, "id " + this.f68120a + " mLimitUnit " + this.f68121b + " mLimitCnt " + this.f68122c + "mCount =  " + this.f68124e + " duration " + ((valueOf.longValue() - this.f68123d) / 1000));
                }
                if (this.f68123d != 0 && (valueOf.longValue() - this.f68123d) / 1000 <= this.f68121b && this.f68124e >= this.f68122c) {
                    if (f68118f) {
                        Log.d(f68119g, "control");
                    }
                    return true;
                }
                if (this.f68123d == 0) {
                    this.f68123d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f68123d) / 1000 > this.f68121b) {
                    this.f68123d = valueOf.longValue();
                    this.f68124e = 0;
                    if (f68118f) {
                        Log.d(f68119g, "reset");
                    }
                }
                this.f68124e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f68124e;
            return i2 != 0 && i2 == this.f68122c;
        }
        return invokeV.booleanValue;
    }
}
