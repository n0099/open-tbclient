package d.a.s0.n1.o.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63829e;

    /* renamed from: f  reason: collision with root package name */
    public int f63830f;

    /* renamed from: g  reason: collision with root package name */
    public int f63831g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63832h;

    /* renamed from: i  reason: collision with root package name */
    public n f63833i;

    public b(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63832h = false;
        this.f63833i = nVar;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f63830f = i2;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f63829e = z;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f63831g = i2;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f63832h = z;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (nVar = this.f63833i) == null) {
            return;
        }
        if (!this.f63832h) {
            nVar.j(this.f63830f, this.f63831g, this.f63829e, 2);
        }
        this.f63833i.j(this.f63830f, this.f63831g, this.f63829e, 1);
    }
}
