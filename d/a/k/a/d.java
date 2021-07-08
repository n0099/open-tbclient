package d.a.k.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f42722b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f42723c = 40;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cesium.a.b f42724a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1525271570, "Ld/a/k/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1525271570, "Ld/a/k/a/d;");
        }
    }

    public d() {
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
        com.baidu.cesium.a.b bVar = new com.baidu.cesium.a.b(f42723c);
        this.f42724a = bVar;
        bVar.a(0, f42723c, true);
    }

    public void a(com.baidu.cesium.a.b bVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, bVar, i2, i3, i4) == null) {
            com.baidu.cesium.a.b d2 = this.f42724a.d(i2, i2 + i3);
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        d2.e(bVar);
                    } else if (i4 == 3) {
                        d2.c(bVar);
                    }
                }
                d2.d(bVar);
            } else {
                d2.b(bVar);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                this.f42724a.a(i2 + i5, d2.d(i5));
            }
        }
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42724a.a() : (byte[]) invokeV.objValue;
    }
}
