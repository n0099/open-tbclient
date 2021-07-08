package d.a.g0.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class b<T> implements d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<T> f42361a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.g0.a.a<List<T>> f42362b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.g0.a.a<List<T>> f42363c;

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

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b() : (b) invokeV.objValue;
    }

    @Override // d.a.g0.a.b.d
    public void a(d.a.g0.a.a<List<T>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f42362b = aVar;
            this.f42361a = null;
        }
    }

    @Override // d.a.g0.a.b.d
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.f42361a;
            if (list != null) {
                return list;
            }
            d.a.g0.a.a<List<T>> aVar = this.f42362b;
            if (aVar != null) {
                List<T> list2 = aVar.get();
                this.f42361a = list2;
                return list2;
            }
            d.a.g0.a.a<List<T>> aVar2 = this.f42363c;
            if (aVar2 != null) {
                return aVar2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
