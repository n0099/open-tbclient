package d.a.z.a.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.z.a.j.f;
/* loaded from: classes8.dex */
public abstract class d implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68669a;

    /* renamed from: b  reason: collision with root package name */
    public f.a f68670b;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68669a = 0;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68669a : invokeV.intValue;
    }

    public abstract void b();

    public void c(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f68670b = aVar;
            if (aVar != null) {
                aVar.a(a(), this);
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f68669a == i2) {
            return;
        }
        this.f68669a = i2;
        f.a aVar = this.f68670b;
        if (aVar != null) {
            aVar.a(i2, this);
        }
    }

    public void e(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            int i2 = this.f68669a;
            if (i2 != 0 && 3 != i2 && 2 != i2) {
                c(aVar);
                return;
            }
            d(1);
            c(aVar);
            try {
                b();
            } catch (Throwable th) {
                th.printStackTrace();
                d(3);
            }
        }
    }
}
