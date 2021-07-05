package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<i> f37689a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<i, List<Class<?>>> f37690b;

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
        this.f37689a = new AtomicReference<>();
        this.f37690b = new ArrayMap<>();
    }

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        InterceptResult invokeLLL;
        List<Class<?>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cls, cls2, cls3)) == null) {
            i andSet = this.f37689a.getAndSet(null);
            if (andSet == null) {
                andSet = new i(cls, cls2, cls3);
            } else {
                andSet.a(cls, cls2, cls3);
            }
            synchronized (this.f37690b) {
                list = this.f37690b.get(andSet);
            }
            this.f37689a.set(andSet);
            return list;
        }
        return (List) invokeLLL.objValue;
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, cls3, list) == null) {
            synchronized (this.f37690b) {
                this.f37690b.put(new i(cls, cls2, cls3), list);
            }
        }
    }
}
