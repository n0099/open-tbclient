package h.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f78783a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f78784b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f78785c;

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
            int length = gVar.f78785c.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                gVar.f78785c[i3] = i2;
                d.n(gVar.f78783a, gVar.f78784b, i2, aVar);
                i2 += 1080;
            }
        }
    }

    public static void b(g gVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, gVar, i2, i3) == null) {
            gVar.f78783a = i2;
            gVar.f78784b = new int[i3 * 1080];
            gVar.f78785c = new int[i3];
        }
    }
}
