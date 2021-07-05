package d.a.b0.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b0.f.b;
/* loaded from: classes8.dex */
public abstract class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.d f43843a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f43844b;

    /* renamed from: c  reason: collision with root package name */
    public b.e f43845c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC0581b f43846d;

    /* renamed from: e  reason: collision with root package name */
    public b.c f43847e;

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
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f43843a = null;
            this.f43844b = null;
            this.f43845c = null;
            this.f43846d = null;
            this.f43847e = null;
        }
    }

    public final boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            b.InterfaceC0581b interfaceC0581b = this.f43846d;
            return interfaceC0581b != null && interfaceC0581b.d(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final boolean a(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
            b.c cVar = this.f43847e;
            return cVar != null && cVar.e(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void b() {
        b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f43843a) == null) {
            return;
        }
        dVar.c(this);
    }

    public final void c() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f43844b) == null) {
            return;
        }
        aVar.b(this);
    }

    public final void d() {
        b.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f43845c) == null) {
            return;
        }
        eVar.a(this);
    }

    public final void setOnCompletionListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f43844b = aVar;
        }
    }

    public final void setOnErrorListener(b.InterfaceC0581b interfaceC0581b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC0581b) == null) {
            this.f43846d = interfaceC0581b;
        }
    }

    public final void setOnInfoListener(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f43847e = cVar;
        }
    }

    public final void setOnPreparedListener(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.f43843a = dVar;
        }
    }

    public final void setOnTerminalListener(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.f43845c = eVar;
        }
    }
}
