package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class a<E> extends v<Object> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final w f68174a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Class<E> f68175b;

    /* renamed from: c  reason: collision with root package name */
    public final v<E> f68176c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523933246, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(523933246, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/a;");
                return;
            }
        }
        f68174a = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, fVar, aVar)) == null) {
                    Type b2 = aVar.b();
                    if ((b2 instanceof GenericArrayType) || ((b2 instanceof Class) && ((Class) b2).isArray())) {
                        Type g2 = com.bytedance.sdk.openadsdk.preload.a.b.b.g(b2);
                        return new a(fVar, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(g2)), com.bytedance.sdk.openadsdk.preload.a.b.b.e(g2));
                    }
                    return null;
                }
                return (v) invokeLL.objValue;
            }
        };
    }

    public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, v<E> vVar, Class<E> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, vVar, cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68176c = new m(fVar, vVar, cls);
        this.f68175b = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, obj) == null) {
            if (obj == null) {
                cVar.f();
                return;
            }
            cVar.b();
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                this.f68176c.a(cVar, Array.get(obj, i2));
            }
            cVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public Object b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f68384i) {
                aVar.j();
                return null;
            }
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                arrayList.add(this.f68176c.b(aVar));
            }
            aVar.b();
            int size = arrayList.size();
            Object newInstance = Array.newInstance((Class<?>) this.f68175b, size);
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(newInstance, i2, arrayList.get(i2));
            }
            return newInstance;
        }
        return invokeL.objValue;
    }
}
