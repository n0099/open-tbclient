package d.a.q0.a.w0;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51441a;

    /* renamed from: b  reason: collision with root package name */
    public String f51442b;

    /* renamed from: c  reason: collision with root package name */
    public String f51443c;

    /* renamed from: d  reason: collision with root package name */
    public String f51444d;

    /* renamed from: e  reason: collision with root package name */
    public long f51445e;

    /* renamed from: f  reason: collision with root package name */
    public int f51446f;

    /* renamed from: g  reason: collision with root package name */
    public String f51447g;

    /* renamed from: h  reason: collision with root package name */
    public int f51448h;

    /* renamed from: i  reason: collision with root package name */
    public String f51449i;
    public String j;

    public b() {
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

    @NonNull
    public static b a(@NonNull d.a.q0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.f51441a = bVar.H();
            bVar2.f51443c = bVar.K();
            bVar2.f51444d = bVar.Q();
            bVar2.f51446f = bVar.G();
            bVar2.f51449i = bVar.T();
            bVar2.f51448h = bVar.n1();
            bVar2.f51445e = System.currentTimeMillis();
            bVar2.f51447g = String.valueOf(bVar.t1());
            bVar2.f51442b = bVar.I();
            bVar2.j = bVar.u1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
