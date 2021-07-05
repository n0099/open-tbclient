package d.a.c.e.b.b.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Type[] f44061a;

    /* renamed from: b  reason: collision with root package name */
    public Type f44062b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f44063c;

    public c(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44061a = null;
        this.f44062b = null;
        this.f44063c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f44061a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f44062b = rawType;
            Type[] typeArr = this.f44061a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f44063c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f44063c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44063c : (Class) invokeV.objValue;
    }

    public Type[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44061a : (Type[]) invokeV.objValue;
    }
}
