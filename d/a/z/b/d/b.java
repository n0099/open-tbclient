package d.a.z.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
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
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f71481c = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f71482a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f71483b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-801158869, "Ld/a/z/b/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-801158869, "Ld/a/z/b/d/b;");
        }
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71483b = EGL14.EGL_NO_SURFACE;
        this.f71482a = aVar;
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            if (this.f71483b == EGL14.EGL_NO_SURFACE) {
                this.f71483b = this.f71482a.b(obj);
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar.d(this.f71483b)) {
            return;
        }
        aVar.e(this.f71483b);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f71482a.g(this.f71483b);
            this.f71483b = EGL14.EGL_NO_SURFACE;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f71482a.h(this.f71483b, j);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean i2 = this.f71482a.i(this.f71483b);
            if (!i2) {
                Log.d(f71481c, "WARNING: swapBuffers() failed");
            }
            return i2;
        }
        return invokeV.booleanValue;
    }
}
