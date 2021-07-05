package com.kwad.sdk.glide.load.resource.e;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?, ?>> f38308a;

    /* loaded from: classes7.dex */
    public static final class a<Z, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e<Z, R> f38309a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<Z> f38310b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<R> f38311c;

        public a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38310b = cls;
            this.f38311c = cls2;
            this.f38309a = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) ? this.f38310b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f38311c) : invokeLL.booleanValue;
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
        this.f38308a = new ArrayList();
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) {
            synchronized (this) {
                if (cls2.isAssignableFrom(cls)) {
                    return g.a();
                }
                for (a<?, ?> aVar : this.f38308a) {
                    if (aVar.a(cls, cls2)) {
                        return (e<Z, R>) aVar.f38309a;
                    }
                }
                throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
            }
        }
        return (e) invokeLL.objValue;
    }

    public synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, eVar) == null) {
            synchronized (this) {
                this.f38308a.add(new a<>(cls, cls2, eVar));
            }
        }
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (cls2.isAssignableFrom(cls)) {
                    arrayList.add(cls2);
                    return arrayList;
                }
                for (a<?, ?> aVar : this.f38308a) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(cls2);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeLL.objValue;
    }
}
