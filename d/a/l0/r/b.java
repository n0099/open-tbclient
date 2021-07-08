package d.a.l0.r;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements d.a.l0.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43177a;

    /* renamed from: b  reason: collision with root package name */
    public a f43178b;

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

    @Override // d.a.l0.n.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.f43178b;
            return aVar.a(this.f43177a, aVar.f43176c);
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.l0.n.a
    public void a(Context context, d.a.l0.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            this.f43177a = context;
            a aVar = new a();
            this.f43178b = aVar;
            aVar.f43176c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f43175b = cls;
                aVar.f43174a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                aVar.f43176c = aVar.f43175b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                aVar.f43175b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                aVar.f43175b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
