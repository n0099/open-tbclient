package d.a.h0.b;

import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final b f45593g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.h0.a.b.a f45594a;

    /* renamed from: b  reason: collision with root package name */
    public final int f45595b;

    /* renamed from: c  reason: collision with root package name */
    public final int f45596c;

    /* renamed from: d  reason: collision with root package name */
    public int f45597d;

    /* renamed from: e  reason: collision with root package name */
    public int f45598e;

    /* renamed from: f  reason: collision with root package name */
    public final int f45599f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1577600616, "Ld/a/h0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1577600616, "Ld/a/h0/b/b;");
                return;
            }
        }
        f45593g = new b();
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
        d.a.h0.a.b.a aVar = d.a.h0.a.b.a.f45561a.get();
        this.f45594a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f45594a.o().getResources().getDisplayMetrics();
        this.f45596c = displayMetrics.heightPixels;
        this.f45595b = displayMetrics.widthPixels;
        this.f45599f = displayMetrics.densityDpi;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f45593g : (b) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f45597d;
            return i2 != 0 ? new int[]{i2, this.f45598e, this.f45599f} : new int[]{this.f45595b, this.f45596c, this.f45599f};
        }
        return (int[]) invokeV.objValue;
    }
}
