package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.load.b.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f37894a;

    /* renamed from: b  reason: collision with root package name */
    public static final n<Object, Object> f37895b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final List<b<?, ?>> f37896c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37897d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b<?, ?>> f37898e;

    /* renamed from: f  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f37899f;

    /* loaded from: classes7.dex */
    public static class a implements n<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.b.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
                return null;
            }
            return (n.a) invokeCommon.objValue;
        }

        @Override // com.kwad.sdk.glide.load.b.n
        public boolean a(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<Model, Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Class<Data> f37900a;

        /* renamed from: b  reason: collision with root package name */
        public final o<? extends Model, ? extends Data> f37901b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<Model> f37902c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37902c = cls;
            this.f37900a = cls2;
            this.f37901b = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f37902c.isAssignableFrom(cls) : invokeL.booleanValue;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) ? a(cls) && this.f37900a.isAssignableFrom(cls2) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, pool)) == null) ? new q<>(list, pool) : (q) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(85360698, "Lcom/kwad/sdk/glide/load/b/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(85360698, "Lcom/kwad/sdk/glide/load/b/r;");
                return;
            }
        }
        f37894a = new c();
        f37895b = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f37894a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Pools.Pool) objArr2[0], (c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool, cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37896c = new ArrayList();
        this.f37898e = new HashSet();
        this.f37899f = pool;
        this.f37897d = cVar;
    }

    @NonNull
    public static <Model, Data> n<Model, Data> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (n<Model, Data>) f37895b : (n) invokeV.objValue;
    }

    @NonNull
    private <Model, Data> n<Model, Data> a(@NonNull b<?, ?> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, this, bVar)) == null) ? (n) com.kwad.sdk.glide.g.j.a(bVar.f37901b.a(this)) : (n) invokeL.objValue;
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{cls, cls2, oVar, Boolean.valueOf(z)}) == null) {
            b<?, ?> bVar = new b<>(cls, cls2, oVar);
            List<b<?, ?>> list = this.f37896c;
            list.add(z ? list.size() : 0, bVar);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) {
            synchronized (this) {
                try {
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (b<?, ?> bVar : this.f37896c) {
                        if (this.f37898e.contains(bVar)) {
                            z = true;
                        } else if (bVar.a(cls, cls2)) {
                            this.f37898e.add(bVar);
                            arrayList.add(a(bVar));
                            this.f37898e.remove(bVar);
                        }
                    }
                    if (arrayList.size() > 1) {
                        return this.f37897d.a(arrayList, this.f37899f);
                    }
                    if (arrayList.size() == 1) {
                        return (n) arrayList.get(0);
                    }
                    if (z) {
                        return a();
                    }
                    throw new Registry.NoModelLoaderAvailableException(cls, cls2);
                } catch (Throwable th) {
                    this.f37898e.clear();
                    throw th;
                }
            }
        }
        return (n) invokeLL.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            synchronized (this) {
                try {
                    arrayList = new ArrayList();
                    for (b<?, ?> bVar : this.f37896c) {
                        if (!this.f37898e.contains(bVar) && bVar.a(cls)) {
                            this.f37898e.add(bVar);
                            arrayList.add(a(bVar));
                            this.f37898e.remove(bVar);
                        }
                    }
                } catch (Throwable th) {
                    this.f37898e.clear();
                    throw th;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, oVar) == null) {
            synchronized (this) {
                a(cls, cls2, oVar, true);
            }
        }
    }

    @NonNull
    public synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (b<?, ?> bVar : this.f37896c) {
                    if (!arrayList.contains(bVar.f37900a) && bVar.a(cls)) {
                        arrayList.add(bVar.f37900a);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
