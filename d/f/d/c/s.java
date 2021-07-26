package d.f.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class s<K, V> extends d.f.d.c.c<K, V> implements u<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final q0<K, V> f71356e;

    /* renamed from: f  reason: collision with root package name */
    public final d.f.d.a.o<? super K> f71357f;

    /* loaded from: classes8.dex */
    public static class a<K, V> extends c0<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f71358e;

        public a(K k) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71358e = k;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Queue
        public boolean add(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v)) == null) {
                add(0, v);
                throw null;
            }
            return invokeL.booleanValue;
        }

        @Override // d.f.d.c.y, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) {
                addAll(0, collection);
                throw null;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.y, d.f.d.c.h0
        /* renamed from: d */
        public List<V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.emptyList() : (List) invokeV.objValue;
        }

        @Override // java.util.List
        public void add(int i2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, v) == null) {
                d.f.d.a.n.t(i2, 0);
                throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f71358e);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends V> collection) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, collection)) == null) {
                d.f.d.a.n.p(collection);
                d.f.d.a.n.t(i2, 0);
                throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f71358e);
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends y<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f71360e;

        public c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71360e = sVar;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (this.f71360e.f71356e.containsKey(entry.getKey()) && this.f71360e.f71357f.apply((Object) entry.getKey())) {
                        return this.f71360e.f71356e.remove(entry.getKey(), entry.getValue());
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.y, d.f.d.c.h0
        public Collection<Map.Entry<K, V>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? n.c(this.f71360e.f71356e.entries(), this.f71360e.c()) : (Collection) invokeV.objValue;
        }
    }

    public s(q0<K, V> q0Var, d.f.d.a.o<? super K> oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q0Var, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.f.d.a.n.p(q0Var);
        this.f71356e = q0Var;
        d.f.d.a.n.p(oVar);
        this.f71357f = oVar;
    }

    public Collection<V> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f71356e instanceof e1) {
                return ImmutableSet.of();
            }
            return ImmutableList.of();
        }
        return (Collection) invokeV.objValue;
    }

    @Override // d.f.d.c.u
    public d.f.d.a.o<? super Map.Entry<K, V>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Maps.q(this.f71357f) : (d.f.d.a.o) invokeV.objValue;
    }

    @Override // d.f.d.c.q0
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            keySet().clear();
        }
    }

    @Override // d.f.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this.f71356e.containsKey(obj)) {
                return this.f71357f.apply(obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.c
    public Map<K, Collection<V>> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Maps.k(this.f71356e.asMap(), this.f71357f) : (Map) invokeV.objValue;
    }

    @Override // d.f.d.c.c
    public Set<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Sets.b(this.f71356e.keySet(), this.f71357f) : (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.c
    public s0<K> createKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Multisets.g(this.f71356e.keys(), this.f71357f) : (s0) invokeV.objValue;
    }

    @Override // d.f.d.c.c
    public Collection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new v(this) : (Collection) invokeV.objValue;
    }

    @Override // d.f.d.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.q0, d.f.d.c.p0
    public Collection<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) {
            if (this.f71357f.apply(k)) {
                return this.f71356e.get(k);
            }
            if (this.f71356e instanceof e1) {
                return new b(k);
            }
            return new a(k);
        }
        return (Collection) invokeL.objValue;
    }

    @Override // d.f.d.c.q0, d.f.d.c.p0
    public Collection<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) ? containsKey(obj) ? this.f71356e.removeAll(obj) : a() : (Collection) invokeL.objValue;
    }

    @Override // d.f.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = 0;
            for (Collection<V> collection : asMap().values()) {
                i2 += collection.size();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public static class b<K, V> extends j0<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f71359e;

        public b(K k) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71359e = k;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Queue
        public boolean add(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f71359e);
            }
            return invokeL.booleanValue;
        }

        @Override // d.f.d.c.y, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                d.f.d.a.n.p(collection);
                throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f71359e);
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.j0, d.f.d.c.y, d.f.d.c.h0
        public Set<V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.emptySet() : (Set) invokeV.objValue;
        }
    }
}
