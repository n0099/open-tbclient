package d.a.p0.g0;

import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = 1;
    public static int k = 2;
    public static int l = 3;
    public static int m = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Fragment f52618a;

    /* renamed from: b  reason: collision with root package name */
    public int f52619b;

    /* renamed from: c  reason: collision with root package name */
    public String f52620c;

    /* renamed from: d  reason: collision with root package name */
    public int f52621d;

    /* renamed from: e  reason: collision with root package name */
    public int f52622e;

    /* renamed from: f  reason: collision with root package name */
    public int f52623f;

    /* renamed from: g  reason: collision with root package name */
    public String f52624g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.g0.e.a f52625h;

    /* renamed from: i  reason: collision with root package name */
    public int f52626i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1571807980, "Ld/a/p0/g0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1571807980, "Ld/a/p0/g0/c;");
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
        this.f52626i = j;
    }
}
