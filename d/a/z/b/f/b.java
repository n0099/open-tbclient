package d.a.z.b.f;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes9.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f71499g;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f71500h;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f71501i;
    public static final FloatBuffer j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-801099287, "Ld/a/z/b/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-801099287, "Ld/a/z/b/f/b;");
                return;
            }
        }
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f71499g = fArr;
        f71500h = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f71501i = d.a.z.b.h.a.b(fArr);
        j = d.a.z.b.h.a.b(f71500h);
    }

    public b() {
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
        this.f71493a = f71501i;
        this.f71494b = j;
        this.f71496d = 2;
        this.f71497e = 2 * 4;
        this.f71495c = f71499g.length / 2;
        this.f71498f = 8;
    }
}
