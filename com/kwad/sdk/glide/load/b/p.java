package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r f37881a;

    /* renamed from: b  reason: collision with root package name */
    public final a f37882b;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<?>, C0461a<?>> f37883a;

        /* renamed from: com.kwad.sdk.glide.load.b.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0461a<Model> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final List<n<Model, ?>> f37884a;

            public C0461a(List<n<Model, ?>> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37884a = list;
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
            this.f37883a = new HashMap();
        }

        @Nullable
        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                C0461a<?> c0461a = this.f37883a.get(cls);
                if (c0461a == null) {
                    return null;
                }
                return (List<n<Model, ?>>) c0461a.f37884a;
            }
            return (List) invokeL.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f37883a.clear();
            }
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, list) == null) || this.f37883a.put(cls, new C0461a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((r) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public p(@NonNull r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37882b = new a();
        this.f37881a = rVar;
    }

    @NonNull
    public static <A> Class<A> b(@NonNull A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, a2)) == null) ? (Class<A>) a2.getClass() : (Class) invokeL.objValue;
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> b(@NonNull Class<A> cls) {
        InterceptResult invokeL;
        List<n<A, ?>> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cls)) == null) {
            synchronized (this) {
                a2 = this.f37882b.a(cls);
                if (a2 == null) {
                    a2 = Collections.unmodifiableList(this.f37881a.a(cls));
                    this.f37882b.a(cls, a2);
                }
            }
            return a2;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        List<Class<?>> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            synchronized (this) {
                b2 = this.f37881a.b(cls);
            }
            return b2;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public <A> List<n<A, ?>> a(@NonNull A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a2)) == null) {
            List<n<A, ?>> b2 = b((Class) b(a2));
            int size = b2.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                n<A, ?> nVar = b2.get(i2);
                if (nVar.a(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(nVar);
                }
            }
            return emptyList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, oVar) == null) {
            synchronized (this) {
                this.f37881a.a(cls, cls2, oVar);
                this.f37882b.a();
            }
        }
    }
}
