package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<C0455a<?>> f37682a;

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0455a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f37683a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f37684b;

        public C0455a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37684b = cls;
            this.f37683a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f37684b.isAssignableFrom(cls) : invokeL.booleanValue;
        }
    }

    public a() {
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
        this.f37682a = new ArrayList();
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            synchronized (this) {
                for (C0455a<?> c0455a : this.f37682a) {
                    if (c0455a.a(cls)) {
                        return (com.kwad.sdk.glide.load.a<T>) c0455a.f37683a;
                    }
                }
                return null;
            }
        }
        return (com.kwad.sdk.glide.load.a) invokeL.objValue;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, aVar) == null) {
            synchronized (this) {
                this.f37682a.add(new C0455a<>(cls, aVar));
            }
        }
    }
}
