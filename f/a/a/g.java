package f.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f44722b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f44723c;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(g gVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gVar, aVar) == null) {
            int length = gVar.f44723c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                gVar.f44723c[i2] = i;
                d.n(gVar.a, gVar.f44722b, i, aVar);
                i += 1080;
            }
        }
    }

    public static void b(g gVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, gVar, i, i2) == null) {
            gVar.a = i;
            gVar.f44722b = new int[i2 * 1080];
            gVar.f44723c = new int[i2];
        }
    }
}
