package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f37696a;

    /* loaded from: classes7.dex */
    public static final class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final g<T> f37697a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f37698b;

        public a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37698b = cls;
            this.f37697a = gVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f37698b.isAssignableFrom(cls) : invokeL.booleanValue;
        }
    }

    public f() {
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
        this.f37696a = new ArrayList();
    }

    @Nullable
    public synchronized <Z> g<Z> a(@NonNull Class<Z> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            synchronized (this) {
                int size = this.f37696a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a<?> aVar = this.f37696a.get(i2);
                    if (aVar.a(cls)) {
                        return (g<Z>) aVar.f37697a;
                    }
                }
                return null;
            }
        }
        return (g) invokeL.objValue;
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, gVar) == null) {
            synchronized (this) {
                this.f37696a.add(new a<>(cls, gVar));
            }
        }
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, gVar) == null) {
            synchronized (this) {
                this.f37696a.add(0, new a<>(cls, gVar));
            }
        }
    }
}
