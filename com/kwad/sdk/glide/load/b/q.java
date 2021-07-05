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
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class q<Model, Data> implements n<Model, Data> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n<Model, Data>> f37885a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f37886b;

    /* loaded from: classes7.dex */
    public static class a<Data> implements com.kwad.sdk.glide.load.a.d<Data>, d.a<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<com.kwad.sdk.glide.load.a.d<Data>> f37887a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<List<Throwable>> f37888b;

        /* renamed from: c  reason: collision with root package name */
        public int f37889c;

        /* renamed from: d  reason: collision with root package name */
        public Priority f37890d;

        /* renamed from: e  reason: collision with root package name */
        public d.a<? super Data> f37891e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<Throwable> f37892f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f37893g;

        public a(@NonNull List<com.kwad.sdk.glide.load.a.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, pool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37888b = pool;
            com.kwad.sdk.glide.g.j.a(list);
            this.f37887a = list;
            this.f37889c = 0;
        }

        private void e() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.f37893g) {
                return;
            }
            if (this.f37889c < this.f37887a.size() - 1) {
                this.f37889c++;
                a(this.f37890d, this.f37891e);
                return;
            }
            com.kwad.sdk.glide.g.j.a(this.f37892f);
            this.f37891e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f37892f)));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37887a.get(0).a() : (Class) invokeV.objValue;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, priority, aVar) == null) {
                this.f37890d = priority;
                this.f37891e = aVar;
                this.f37892f = this.f37888b.acquire();
                this.f37887a.get(this.f37889c).a(priority, this);
                if (this.f37893g) {
                    c();
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@NonNull Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                ((List) com.kwad.sdk.glide.g.j.a(this.f37892f)).add(exc);
                e();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@Nullable Data data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                if (data != null) {
                    this.f37891e.a((d.a<? super Data>) data);
                } else {
                    e();
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                List<Throwable> list = this.f37892f;
                if (list != null) {
                    this.f37888b.release(list);
                }
                this.f37892f = null;
                for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f37887a) {
                    dVar.b();
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f37893g = true;
                for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f37887a) {
                    dVar.c();
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37887a.get(0).d() : (DataSource) invokeV.objValue;
        }
    }

    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37885a = list;
        this.f37886b = pool;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        n.a<Data> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            int size = this.f37885a.size();
            ArrayList arrayList = new ArrayList(size);
            com.kwad.sdk.glide.load.c cVar = null;
            for (int i4 = 0; i4 < size; i4++) {
                n<Model, Data> nVar = this.f37885a.get(i4);
                if (nVar.a(model) && (a2 = nVar.a(model, i2, i3, eVar)) != null) {
                    cVar = a2.f37878a;
                    arrayList.add(a2.f37880c);
                }
            }
            if (arrayList.isEmpty() || cVar == null) {
                return null;
            }
            return new n.a<>(cVar, new a(arrayList, this.f37886b));
        }
        return (n.a) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, model)) == null) {
            for (n<Model, Data> nVar : this.f37885a) {
                if (nVar.a(model)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f37885a.toArray()) + '}';
        }
        return (String) invokeV.objValue;
    }
}
