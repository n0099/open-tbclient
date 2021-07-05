package d.a.r0.e0;

import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = 1;
    public static int k = 2;
    public static int l = 3;
    public static int m = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Fragment f55251a;

    /* renamed from: b  reason: collision with root package name */
    public int f55252b;

    /* renamed from: c  reason: collision with root package name */
    public String f55253c;

    /* renamed from: d  reason: collision with root package name */
    public int f55254d;

    /* renamed from: e  reason: collision with root package name */
    public int f55255e;

    /* renamed from: f  reason: collision with root package name */
    public int f55256f;

    /* renamed from: g  reason: collision with root package name */
    public String f55257g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.e0.e.a f55258h;

    /* renamed from: i  reason: collision with root package name */
    public int f55259i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1911965648, "Ld/a/r0/e0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1911965648, "Ld/a/r0/e0/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55259i = j;
    }
}
