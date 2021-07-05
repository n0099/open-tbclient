package d.a.s0.n1.p;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f63902f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f63903a;

    /* renamed from: b  reason: collision with root package name */
    public String f63904b;

    /* renamed from: c  reason: collision with root package name */
    public String f63905c;

    /* renamed from: d  reason: collision with root package name */
    public int f63906d;

    /* renamed from: e  reason: collision with root package name */
    public String f63907e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1616921836, "Ld/a/s0/n1/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1616921836, "Ld/a/s0/n1/p/e;");
                return;
            }
        }
        f63902f = new HashMap<>();
    }

    public e() {
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
        this.f63904b = "";
    }

    public static e a(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append("_");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return f63902f.get(sb.toString());
        }
        return (e) invokeJL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f63903a);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f63904b) ? "" : this.f63904b);
            f63902f.put(sb.toString(), this);
        }
    }
}
