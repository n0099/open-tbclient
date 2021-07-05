package com.kwad.sdk.glide.e;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.i;
import com.kwad.sdk.glide.load.engine.g;
import com.kwad.sdk.glide.load.engine.q;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final q<?, ?, ?> f37686a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<i, q<?, ?, ?>> f37687b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<i> f37688c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(905977703, "Lcom/kwad/sdk/glide/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(905977703, "Lcom/kwad/sdk/glide/e/c;");
                return;
            }
        }
        f37686a = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.kwad.sdk.glide.load.resource.e.g(), null)), null);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37687b = new ArrayMap<>();
        this.f37688c = new AtomicReference<>();
    }

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, cls, cls2, cls3)) == null) {
            i andSet = this.f37688c.getAndSet(null);
            if (andSet == null) {
                andSet = new i();
            }
            andSet.a(cls, cls2, cls3);
            return andSet;
        }
        return (i) invokeLLL.objValue;
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        InterceptResult invokeLLL;
        q<Data, TResource, Transcode> qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cls, cls2, cls3)) == null) {
            i b2 = b(cls, cls2, cls3);
            synchronized (this.f37687b) {
                qVar = (q<Data, TResource, Transcode>) this.f37687b.get(b2);
            }
            this.f37688c.set(b2);
            return qVar;
        }
        return (q) invokeLLL.objValue;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable q<?, ?, ?> qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, cls3, qVar) == null) {
            synchronized (this.f37687b) {
                ArrayMap<i, q<?, ?, ?>> arrayMap = this.f37687b;
                i iVar = new i(cls, cls2, cls3);
                if (qVar == null) {
                    qVar = f37686a;
                }
                arrayMap.put(iVar, qVar);
            }
        }
    }

    public boolean a(@Nullable q<?, ?, ?> qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qVar)) == null) ? f37686a.equals(qVar) : invokeL.booleanValue;
    }
}
