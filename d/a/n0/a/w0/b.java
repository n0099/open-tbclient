package d.a.n0.a.w0;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48139a;

    /* renamed from: b  reason: collision with root package name */
    public String f48140b;

    /* renamed from: c  reason: collision with root package name */
    public String f48141c;

    /* renamed from: d  reason: collision with root package name */
    public String f48142d;

    /* renamed from: e  reason: collision with root package name */
    public long f48143e;

    /* renamed from: f  reason: collision with root package name */
    public int f48144f;

    /* renamed from: g  reason: collision with root package name */
    public String f48145g;

    /* renamed from: h  reason: collision with root package name */
    public int f48146h;

    /* renamed from: i  reason: collision with root package name */
    public String f48147i;
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
    public static b a(@NonNull d.a.n0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.f48139a = bVar.H();
            bVar2.f48141c = bVar.K();
            bVar2.f48142d = bVar.Q();
            bVar2.f48144f = bVar.G();
            bVar2.f48147i = bVar.T();
            bVar2.f48146h = bVar.n1();
            bVar2.f48143e = System.currentTimeMillis();
            bVar2.f48145g = String.valueOf(bVar.t1());
            bVar2.f48140b = bVar.I();
            bVar2.j = bVar.u1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
