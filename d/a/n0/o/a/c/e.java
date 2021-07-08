package d.a.n0.o.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class e<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e<K, V>.b f50911a;

    /* renamed from: b  reason: collision with root package name */
    public e<K, V>.c f50912b;

    /* renamed from: c  reason: collision with root package name */
    public e<K, V>.C1151e f50913c;

    /* loaded from: classes7.dex */
    public final class a<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f50914e;

        /* renamed from: f  reason: collision with root package name */
        public int f50915f;

        /* renamed from: g  reason: collision with root package name */
        public int f50916g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f50917h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50918i;

        public a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50918i = eVar;
            this.f50917h = false;
            this.f50914e = i2;
            this.f50915f = eVar.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50916g < this.f50915f : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                T t = (T) this.f50918i.b(this.f50916g, this.f50914e);
                this.f50916g++;
                this.f50917h = true;
                return t;
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f50917h) {
                    int i2 = this.f50916g - 1;
                    this.f50916g = i2;
                    this.f50915f--;
                    this.f50917h = false;
                    this.f50918i.h(i2);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50919e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50919e = eVar;
        }

        public boolean a(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                int d2 = this.f50919e.d();
                for (Map.Entry<K, V> entry : collection) {
                    this.f50919e.g(entry.getKey(), entry.getValue());
                }
                return d2 != this.f50919e.d();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f50919e.a();
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int e2 = this.f50919e.e(entry.getKey());
                    if (e2 < 0) {
                        return false;
                    }
                    return d.a.n0.o.a.c.b.b(this.f50919e.b(e2, 1), entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? e.k(this, obj) : invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = 0;
                for (int d2 = this.f50919e.d() - 1; d2 >= 0; d2--) {
                    Object b2 = this.f50919e.b(d2, 0);
                    Object b3 = this.f50919e.b(d2, 1);
                    i2 += (b2 == null ? 0 : b2.hashCode()) ^ (b3 == null ? 0 : b3.hashCode());
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f50919e.d() == 0 : invokeV.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new d(this.f50919e) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f50919e.d() : invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Object[]) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, tArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes7.dex */
    public final class c implements Set<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50920e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50920e = eVar;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f50920e.a();
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.f50920e.e(obj) >= 0 : invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) ? e.j(this.f50920e.c(), collection) : invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? e.k(this, obj) : invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int i2 = 0;
                for (int d2 = this.f50920e.d() - 1; d2 >= 0; d2--) {
                    Object b2 = this.f50920e.b(d2, 0);
                    i2 += b2 == null ? 0 : b2.hashCode();
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f50920e.d() == 0 : invokeV.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new a(this.f50920e, 0) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                int e2 = this.f50920e.e(obj);
                if (e2 >= 0) {
                    this.f50920e.h(e2);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, collection)) == null) ? e.o(this.f50920e.c(), collection) : invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, collection)) == null) ? e.p(this.f50920e.c(), collection) : invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f50920e.d() : invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f50920e.q(0) : (Object[]) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, tArr)) == null) ? (T[]) this.f50920e.r(tArr, 0) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes7.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f50921e;

        /* renamed from: f  reason: collision with root package name */
        public int f50922f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f50923g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f50924h;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50924h = eVar;
            this.f50923g = false;
            this.f50921e = eVar.d() - 1;
            this.f50922f = -1;
        }

        public Map.Entry<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f50922f++;
                this.f50923g = true;
                return this;
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this.f50923g) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        return d.a.n0.o.a.c.b.b(entry.getKey(), this.f50924h.b(this.f50922f, 0)) && d.a.n0.o.a.c.b.b(entry.getValue(), this.f50924h.b(this.f50922f, 1));
                    }
                    return false;
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f50923g) {
                    return (K) this.f50924h.b(this.f50922f, 0);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f50923g) {
                    return (V) this.f50924h.b(this.f50922f, 1);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50922f < this.f50921e : invokeV.booleanValue;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f50923g) {
                    Object b2 = this.f50924h.b(this.f50922f, 0);
                    Object b3 = this.f50924h.b(this.f50922f, 1);
                    return (b2 == null ? 0 : b2.hashCode()) ^ (b3 != null ? b3.hashCode() : 0);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return invokeV.intValue;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (this.f50923g) {
                    this.f50924h.h(this.f50922f);
                    this.f50922f--;
                    this.f50921e--;
                    this.f50923g = false;
                    return;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v)) == null) {
                if (this.f50923g) {
                    return (V) this.f50924h.i(this.f50922f, v);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) invokeL.objValue;
        }

        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return getKey() + "=" + getValue();
            }
            return (String) invokeV.objValue;
        }
    }

    /* renamed from: d.a.n0.o.a.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1151e implements Collection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50925e;

        public C1151e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50925e = eVar;
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f50925e.a();
            }
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.f50925e.f(obj) >= 0 : invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50925e.d() == 0 : invokeV.booleanValue;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new a(this.f50925e, 1) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                int f2 = this.f50925e.f(obj);
                if (f2 >= 0) {
                    this.f50925e.h(f2);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) {
                int d2 = this.f50925e.d();
                int i2 = 0;
                boolean z = false;
                while (i2 < d2) {
                    if (collection.contains(this.f50925e.b(i2, 1))) {
                        this.f50925e.h(i2);
                        i2--;
                        d2--;
                        z = true;
                    }
                    i2++;
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, collection)) == null) {
                int d2 = this.f50925e.d();
                int i2 = 0;
                boolean z = false;
                while (i2 < d2) {
                    if (!collection.contains(this.f50925e.b(i2, 1))) {
                        this.f50925e.h(i2);
                        i2--;
                        d2--;
                        z = true;
                    }
                    i2++;
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f50925e.d() : invokeV.intValue;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f50925e.q(1) : (Object[]) invokeV.objValue;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tArr)) == null) ? (T[]) this.f50925e.r(tArr, 1) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    public e() {
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

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, collection)) == null) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!map.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, set, obj)) == null) {
            if (set == obj) {
                return true;
            }
            if (obj instanceof Set) {
                Set set2 = (Set) obj;
                try {
                    if (set.size() == set2.size()) {
                        if (set.containsAll(set2)) {
                            return true;
                        }
                    }
                    return false;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, collection)) == null) {
            int size = map.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                map.remove(it.next());
            }
            return size != map.size();
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, collection)) == null) {
            int size = map.size();
            Iterator<K> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            return size != map.size();
        }
        return invokeLL.booleanValue;
    }

    public abstract void a();

    public abstract Object b(int i2, int i3);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i2);

    public abstract V i(int i2, V v);

    public Set<Map.Entry<K, V>> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f50911a == null) {
                this.f50911a = new b(this);
            }
            return this.f50911a;
        }
        return (Set) invokeV.objValue;
    }

    public Set<K> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f50912b == null) {
                this.f50912b = new c(this);
            }
            return this.f50912b;
        }
        return (Set) invokeV.objValue;
    }

    public Collection<V> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f50913c == null) {
                this.f50913c = new C1151e(this);
            }
            return this.f50913c;
        }
        return (Collection) invokeV.objValue;
    }

    public Object[] q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            int d2 = d();
            Object[] objArr = new Object[d2];
            for (int i3 = 0; i3 < d2; i3++) {
                objArr[i3] = b(i3, i2);
            }
            return objArr;
        }
        return (Object[]) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, tArr, i2)) == null) {
            int d2 = d();
            if (tArr.length < d2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
            }
            for (int i3 = 0; i3 < d2; i3++) {
                tArr[i3] = b(i3, i2);
            }
            if (tArr.length > d2) {
                tArr[d2] = null;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeLI.objValue);
    }
}
