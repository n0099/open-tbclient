package d.a.r0;

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
    public static final boolean f67440f;

    /* renamed from: g  reason: collision with root package name */
    public static String f67441g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f67442a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67443b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67444c;

    /* renamed from: d  reason: collision with root package name */
    public long f67445d;

    /* renamed from: e  reason: collision with root package name */
    public int f67446e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458396038, "Ld/a/r0/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-458396038, "Ld/a/r0/m;");
                return;
            }
        }
        f67440f = l.f67439a & true;
        f67441g = "ControlData";
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
        this.f67442a = str;
        this.f67443b = i2;
        this.f67444c = i3;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67442a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f67443b != 0 && this.f67444c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f67440f) {
                    Log.d(f67441g, "id " + this.f67442a + " mLimitUnit " + this.f67443b + " mLimitCnt " + this.f67444c + "mCount =  " + this.f67446e + " duration " + ((valueOf.longValue() - this.f67445d) / 1000));
                }
                if (this.f67445d != 0 && (valueOf.longValue() - this.f67445d) / 1000 <= this.f67443b && this.f67446e >= this.f67444c) {
                    if (f67440f) {
                        Log.d(f67441g, "control");
                    }
                    return true;
                }
                if (this.f67445d == 0) {
                    this.f67445d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f67445d) / 1000 > this.f67443b) {
                    this.f67445d = valueOf.longValue();
                    this.f67446e = 0;
                    if (f67440f) {
                        Log.d(f67441g, "reset");
                    }
                }
                this.f67446e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f67446e;
            return i2 != 0 && i2 == this.f67444c;
        }
        return invokeV.booleanValue;
    }
}
