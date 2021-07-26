package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import d.f.d.a.n;
import d.f.d.c.b0;
import d.f.d.c.d1;
import d.f.d.c.j0;
import d.f.d.c.m;
import d.f.d.c.o0;
import d.f.d.c.s0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class ConcurrentHashMultiset<E> extends d.f.d.c.d<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: classes6.dex */
    public class b extends AbstractIterator<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final Iterator<Map.Entry<E, AtomicInteger>> f33355g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMultiset f33356h;

        public b(ConcurrentHashMultiset concurrentHashMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concurrentHashMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33356h = concurrentHashMultiset;
            this.f33355g = this.f33356h.countMap.entrySet().iterator();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d */
        public s0.a<E> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                while (this.f33355g.hasNext()) {
                    Map.Entry<E, AtomicInteger> next = this.f33355g.next();
                    int i2 = next.getValue().get();
                    if (i2 != 0) {
                        return Multisets.h(next.getKey(), i2);
                    }
                }
                return b();
            }
            return (s0.a) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends b0<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public s0.a<E> f33357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterator f33358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMultiset f33359g;

        public c(ConcurrentHashMultiset concurrentHashMultiset, Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concurrentHashMultiset, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33359g = concurrentHashMultiset;
            this.f33358f = it;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.h0
        /* renamed from: d */
        public Iterator<s0.a<E>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33358f : (Iterator) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.b0, java.util.Iterator
        /* renamed from: e */
        public s0.a<E> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                s0.a<E> aVar = (s0.a) super.next();
                this.f33357e = aVar;
                return aVar;
            }
            return (s0.a) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                m.e(this.f33357e != null);
                this.f33359g.setCount(this.f33357e.getElement(), 0);
                this.f33357e = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends d.f.d.c.d<E>.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMultiset f33360f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ConcurrentHashMultiset concurrentHashMultiset) {
            super(concurrentHashMultiset);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concurrentHashMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d.f.d.c.d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33360f = concurrentHashMultiset;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.d.b, com.google.common.collect.Multisets.d
        /* renamed from: c */
        public ConcurrentHashMultiset<E> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33360f : (ConcurrentHashMultiset) invokeV.objValue;
        }

        public final List<s0.a<E>> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList m = Lists.m(size());
                Iterators.a(m, iterator());
                return m;
            }
            return (List) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d().toArray() : (Object[]) invokeV.objValue;
        }

        public /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this(concurrentHashMultiset);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) ? (T[]) d().toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d1.b<ConcurrentHashMultiset> f33361a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-387612513, "Lcom/google/common/collect/ConcurrentHashMultiset$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-387612513, "Lcom/google/common/collect/ConcurrentHashMultiset$e;");
                    return;
                }
            }
            f33361a = d1.a(ConcurrentHashMultiset.class, "countMap");
        }
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {concurrentMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.k(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ConcurrentHashMultiset<>(new ConcurrentHashMap()) : (ConcurrentHashMultiset) invokeV.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            e.f33361a.b(this, (ConcurrentMap) objectInputStream.readObject());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            ArrayList m = Lists.m(size());
            for (s0.a aVar : entrySet()) {
                Object element = aVar.getElement();
                for (int count = aVar.getCount(); count > 0; count--) {
                    m.add(element);
                }
            }
            return m;
        }
        return (List) invokeV.objValue;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.countMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L33;
     */
    @Override // d.f.d.c.d, d.f.d.c.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int add(E e2, int i2) {
        InterceptResult invokeLI;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
            n.p(e2);
            if (i2 == 0) {
                return count(e2);
            }
            m.d(i2, "occurences");
            do {
                atomicInteger = (AtomicInteger) Maps.A(this.countMap, e2);
                if (atomicInteger != null || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i2))) != null) {
                    while (true) {
                        int i3 = atomicInteger.get();
                        if (i3 == 0) {
                            break;
                        }
                        try {
                            if (atomicInteger.compareAndSet(i3, d.f.d.f.c.a(i3, i2))) {
                                return i3;
                            }
                        } catch (ArithmeticException unused) {
                            throw new IllegalArgumentException("Overflow adding " + i2 + " occurrences to a count of " + i3);
                        }
                    }
                } else {
                    return 0;
                }
            } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // d.f.d.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.countMap.clear();
        }
    }

    @Override // d.f.d.c.d, java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.f.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            AtomicInteger atomicInteger = (AtomicInteger) Maps.A(this.countMap, obj);
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }
        return invokeL.intValue;
    }

    @Override // d.f.d.c.d
    public Set<E> createElementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this, this.countMap.keySet()) : (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.d
    @Deprecated
    public Set<s0.a<E>> createEntrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(this, null) : (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.d
    public int distinctElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.countMap.size() : invokeV.intValue;
    }

    @Override // d.f.d.c.d
    public Iterator<E> elementIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // d.f.d.c.d
    public Iterator<s0.a<E>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new c(this, new b(this)) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // d.f.d.c.d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.countMap.isEmpty() : invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.f.d.c.s0
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Multisets.j(this) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public int remove(Object obj, int i2) {
        InterceptResult invokeLI;
        int i3;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, obj, i2)) == null) {
            if (i2 == 0) {
                return count(obj);
            }
            m.d(i2, "occurences");
            AtomicInteger atomicInteger = (AtomicInteger) Maps.A(this.countMap, obj);
            if (atomicInteger == null) {
                return 0;
            }
            do {
                i3 = atomicInteger.get();
                if (i3 == 0) {
                    return 0;
                }
                max = Math.max(0, i3 - i2);
            } while (!atomicInteger.compareAndSet(i3, max));
            if (max == 0) {
                this.countMap.remove(obj, atomicInteger);
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public boolean removeExactly(Object obj, int i2) {
        InterceptResult invokeLI;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, obj, i2)) == null) {
            if (i2 == 0) {
                return true;
            }
            m.d(i2, "occurences");
            AtomicInteger atomicInteger = (AtomicInteger) Maps.A(this.countMap, obj);
            if (atomicInteger == null) {
                return false;
            }
            do {
                i3 = atomicInteger.get();
                if (i3 < i2) {
                    return false;
                }
                i4 = i3 - i2;
            } while (!atomicInteger.compareAndSet(i3, i4));
            if (i4 == 0) {
                this.countMap.remove(obj, atomicInteger);
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r6 != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L31;
     */
    @Override // d.f.d.c.d, d.f.d.c.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setCount(E e2, int i2) {
        InterceptResult invokeLI;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, e2, i2)) == null) {
            n.p(e2);
            m.b(i2, "count");
            do {
                atomicInteger = (AtomicInteger) Maps.A(this.countMap, e2);
                if (atomicInteger == null && (i2 == 0 || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i2))) == null)) {
                    return 0;
                }
                while (true) {
                    int i3 = atomicInteger.get();
                    if (i3 == 0) {
                        break;
                    } else if (atomicInteger.compareAndSet(i3, i2)) {
                        if (i2 == 0) {
                            this.countMap.remove(e2, atomicInteger);
                        }
                        return i3;
                    }
                }
            } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long j = 0;
            for (AtomicInteger atomicInteger : this.countMap.values()) {
                j += atomicInteger.get();
            }
            return Ints.j(j);
        }
        return invokeV.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? snapshot().toArray() : (Object[]) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends j0<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f33354e;

        public a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concurrentHashMultiset, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33354e = set;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj != null && d.f.d.c.n.e(this.f33354e, obj) : invokeL.booleanValue;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? standardContainsAll(collection) : invokeL.booleanValue;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? obj != null && d.f.d.c.n.f(this.f33354e, obj) : invokeL.booleanValue;
        }

        @Override // d.f.d.c.y, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) ? standardRemoveAll(collection) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.j0, d.f.d.c.y, d.f.d.c.h0
        public Set<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33354e : (Set) invokeV.objValue;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            ConcurrentHashMultiset<E> create = create();
            o0.a(create, iterable);
            return create;
        }
        return (ConcurrentHashMultiset) invokeL.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tArr)) == null) ? (T[]) snapshot().toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, concurrentMap)) == null) ? new ConcurrentHashMultiset<>(concurrentMap) : (ConcurrentHashMultiset) invokeL.objValue;
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public boolean setCount(E e2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, e2, i2, i3)) == null) {
            n.p(e2);
            m.b(i2, "oldCount");
            m.b(i3, "newCount");
            AtomicInteger atomicInteger = (AtomicInteger) Maps.A(this.countMap, e2);
            if (atomicInteger == null) {
                if (i2 != 0) {
                    return false;
                }
                return i3 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i3)) == null;
            }
            int i4 = atomicInteger.get();
            if (i4 == i2) {
                if (i4 == 0) {
                    if (i3 == 0) {
                        this.countMap.remove(e2, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i3);
                    return this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2);
                } else if (atomicInteger.compareAndSet(i4, i3)) {
                    if (i3 == 0) {
                        this.countMap.remove(e2, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLII.booleanValue;
    }
}
