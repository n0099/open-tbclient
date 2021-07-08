package d.f.b.a.i0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f70463a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70464b;

    /* renamed from: c  reason: collision with root package name */
    public final int f70465c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70466d;

    public f(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        k kVar = new k(bArr);
        kVar.l(i2 * 8);
        kVar.g(16);
        kVar.g(16);
        kVar.g(24);
        kVar.g(24);
        this.f70463a = kVar.g(20);
        this.f70464b = kVar.g(3) + 1;
        this.f70465c = kVar.g(5) + 1;
        this.f70466d = ((kVar.g(4) & 15) << 32) | (kVar.g(32) & 4294967295L);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70465c * this.f70463a : invokeV.intValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f70466d * 1000000) / this.f70463a : invokeV.longValue;
    }
}
