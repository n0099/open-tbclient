package d.l.a.e.b.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.b.l.f;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f72263a;

    /* renamed from: b  reason: collision with root package name */
    public final d.l.a.e.b.i.a f72264b;

    public c(InputStream inputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72263a = inputStream;
        this.f72264b = new d.l.a.e.b.i.a(i2);
    }

    @Override // d.l.a.e.b.h.b
    public d.l.a.e.b.i.a a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.l.a.e.b.i.a aVar = this.f72264b;
            aVar.f72267c = this.f72263a.read(aVar.f72265a);
            return this.f72264b;
        }
        return (d.l.a.e.b.i.a) invokeV.objValue;
    }

    @Override // d.l.a.e.b.h.b
    public void a(d.l.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // d.l.a.e.b.h.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f.E(this.f72263a);
        }
    }
}
