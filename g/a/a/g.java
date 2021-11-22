package g.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72635a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f72636b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f72637c;

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
            int length = gVar.f72637c.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                gVar.f72637c[i3] = i2;
                d.n(gVar.f72635a, gVar.f72636b, i2, aVar);
                i2 += 1080;
            }
        }
    }

    public static void b(g gVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, gVar, i2, i3) == null) {
            gVar.f72635a = i2;
            gVar.f72636b = new int[i3 * 1080];
            gVar.f72637c = new int[i3];
        }
    }
}
