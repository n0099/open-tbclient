package h.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f61714b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f61715c;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(g gVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gVar, aVar) == null) {
            int length = gVar.f61715c.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                gVar.f61715c[i3] = i2;
                d.n(gVar.a, gVar.f61714b, i2, aVar);
                i2 += 1080;
            }
        }
    }

    public static void b(g gVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, gVar, i2, i3) == null) {
            gVar.a = i2;
            gVar.f61714b = new int[i3 * 1080];
            gVar.f61715c = new int[i3];
        }
    }
}
