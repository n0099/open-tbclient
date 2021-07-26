package d.a.f0.b;

import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final b f42745g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.f0.a.b.a f42746a;

    /* renamed from: b  reason: collision with root package name */
    public final int f42747b;

    /* renamed from: c  reason: collision with root package name */
    public final int f42748c;

    /* renamed from: d  reason: collision with root package name */
    public int f42749d;

    /* renamed from: e  reason: collision with root package name */
    public int f42750e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42751f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-197406746, "Ld/a/f0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-197406746, "Ld/a/f0/b/b;");
                return;
            }
        }
        f42745g = new b();
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
        d.a.f0.a.b.a aVar = d.a.f0.a.b.a.f42713a.get();
        this.f42746a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f42746a.o().getResources().getDisplayMetrics();
        this.f42748c = displayMetrics.heightPixels;
        this.f42747b = displayMetrics.widthPixels;
        this.f42751f = displayMetrics.densityDpi;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f42745g : (b) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f42749d;
            return i2 != 0 ? new int[]{i2, this.f42750e, this.f42751f} : new int[]{this.f42747b, this.f42748c, this.f42751f};
        }
        return (int[]) invokeV.objValue;
    }
}
