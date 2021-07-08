package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class b implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f31825a;

    /* loaded from: classes5.dex */
    public static final class a<E> extends v<Collection<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final v<E> f31826a;

        /* renamed from: b  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Collection<E>> f31827b;

        public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type, v<E> vVar, com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Collection<E>> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, type, vVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31826a = new m(fVar, vVar, type);
            this.f31827b = iVar;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Collection) ((Collection) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public Collection<E> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f32028i) {
                    aVar.j();
                    return null;
                }
                Collection<E> a2 = this.f31827b.a();
                aVar.a();
                while (aVar.e()) {
                    a2.add(this.f31826a.b(aVar));
                }
                aVar.b();
                return a2;
            }
            return (Collection) invokeL.objValue;
        }

        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Collection<E> collection) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, collection) == null) {
                if (collection == null) {
                    cVar.f();
                    return;
                }
                cVar.b();
                for (E e2 : collection) {
                    this.f31826a.a(cVar, e2);
                }
                cVar.c();
            }
        }
    }

    public b(com.bytedance.sdk.openadsdk.preload.a.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31825a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            Type b2 = aVar.b();
            Class<? super T> a2 = aVar.a();
            if (Collection.class.isAssignableFrom(a2)) {
                Type a3 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(b2, (Class<?>) a2);
                return new a(fVar, a3, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a3)), this.f31825a.a(aVar));
            }
            return null;
        }
        return (v) invokeLL.objValue;
    }
}
