package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.k;
import c.i.d.a.n;
import c.i.d.a.o;
import c.i.d.c.g0;
import c.i.d.c.h1;
import c.i.d.c.m;
import c.i.d.c.m1;
import c.i.d.c.o1;
import c.i.d.c.s0;
import c.i.d.c.t0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes9.dex */
public final class Multisets {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class ImmutableEntry<E> extends b<E> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final int count;
        public final E element;

        public ImmutableEntry(E e2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.element = e2;
            this.count = i2;
            m.b(i2, "count");
        }

        @Override // c.i.d.c.s0.a
        public final int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.count : invokeV.intValue;
        }

        @Override // c.i.d.c.s0.a
        public final E getElement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.element : (E) invokeV.objValue;
        }

        public ImmutableEntry<E> nextInBucket() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (ImmutableEntry) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class UnmodifiableMultiset<E> extends g0<E> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final s0<? extends E> delegate;
        public transient Set<E> elementSet;
        public transient Set<s0.a<E>> entrySet;

        public UnmodifiableMultiset(s0<? extends E> s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = s0Var;
        }

        @Override // c.i.d.c.y, java.util.Collection, java.util.List
        public boolean add(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // c.i.d.c.y, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public Set<E> createElementSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.unmodifiableSet(this.delegate.elementSet()) : (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.g0, c.i.d.c.s0
        public Set<E> elementSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Set<E> set = this.elementSet;
                if (set == null) {
                    Set<E> createElementSet = createElementSet();
                    this.elementSet = createElementSet;
                    return createElementSet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.g0, c.i.d.c.s0
        public Set<s0.a<E>> entrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Set<s0.a<E>> set = this.entrySet;
                if (set == null) {
                    Set<s0.a<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
                    this.entrySet = unmodifiableSet;
                    return unmodifiableSet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
        public Iterator<E> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Iterators.B(this.delegate.iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // c.i.d.c.g0, c.i.d.c.s0
        public int setCount(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, e2, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLI.intValue;
        }

        @Override // c.i.d.c.g0, c.i.d.c.s0
        public int add(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLI.intValue;
        }

        @Override // c.i.d.c.g0, c.i.d.c.s0
        public int remove(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, obj, i2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLI.intValue;
        }

        @Override // c.i.d.c.g0, c.i.d.c.s0
        public boolean setCount(E e2, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, e2, i2, i3)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLII.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: c.i.d.c.s0<? extends E>, c.i.d.c.s0<E> */
        @Override // c.i.d.c.g0, c.i.d.c.y, c.i.d.c.h0
        public s0<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (s0<? extends E>) this.delegate : (s0) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends m1<s0.a<E>, E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterator it) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [E, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [E, java.lang.Object] */
        @Override // c.i.d.c.m1
        /* renamed from: b */
        public E a(s0.a<E> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? aVar.getElement() : invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class b<E> implements s0.a<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof s0.a) {
                    s0.a aVar = (s0.a) obj;
                    return getCount() == aVar.getCount() && k.a(getElement(), aVar.getElement());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                E element = getElement();
                return (element == null ? 0 : element.hashCode()) ^ getCount();
            }
            return invokeV.intValue;
        }

        @Override // c.i.d.c.s0.a
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String valueOf = String.valueOf(getElement());
                int count = getCount();
                if (count == 1) {
                    return valueOf;
                }
                return valueOf + " x " + count;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class c<E> extends Sets.c<E> {
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

        public abstract s0<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b().clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? b().contains(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? b().containsAll(collection) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b().isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? b().remove(obj, Integer.MAX_VALUE) > 0 : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b().entrySet().size() : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class d<E> extends Sets.c<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public abstract s0<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b().clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof s0.a) {
                    s0.a aVar = (s0.a) obj;
                    return aVar.getCount() > 0 && b().count(aVar.getElement()) == aVar.getCount();
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof s0.a) {
                    s0.a aVar = (s0.a) obj;
                    E e2 = (E) aVar.getElement();
                    int count = aVar.getCount();
                    if (count != 0) {
                        return b().setCount(e2, count, 0);
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<E> extends g<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final s0<E> f71002e;

        /* renamed from: f  reason: collision with root package name */
        public final o<? super E> f71003f;

        /* loaded from: classes9.dex */
        public class a implements o<s0.a<E>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f71004e;

            public a(e eVar) {
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
                this.f71004e = eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.a.o
            /* renamed from: a */
            public boolean apply(s0.a<E> aVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.f71004e.f71003f.apply(aVar.getElement()) : invokeL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(s0<E> s0Var, o<? super E> oVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((t0) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(s0Var);
            this.f71002e = s0Var;
            n.p(oVar);
            this.f71003f = oVar;
        }

        @Override // c.i.d.c.d, c.i.d.c.s0
        public int add(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
                n.l(this.f71003f.apply(e2), "Element %s does not match predicate %s", e2, this.f71003f);
                return this.f71002e.add(e2, i2);
            }
            return invokeLI.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
        /* renamed from: b */
        public o1<E> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Iterators.l(this.f71002e.iterator(), this.f71003f) : (o1) invokeV.objValue;
        }

        @Override // c.i.d.c.s0
        public int count(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                int count = this.f71002e.count(obj);
                if (count <= 0 || !this.f71003f.apply(obj)) {
                    return 0;
                }
                return count;
            }
            return invokeL.intValue;
        }

        @Override // c.i.d.c.d
        public Set<E> createElementSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Sets.b(this.f71002e.elementSet(), this.f71003f) : (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.d
        public Set<s0.a<E>> createEntrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Sets.b(this.f71002e.entrySet(), new a(this)) : (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.d
        public Iterator<E> elementIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                throw new AssertionError("should never be called");
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.d
        public Iterator<s0.a<E>> entryIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                throw new AssertionError("should never be called");
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.d, c.i.d.c.s0
        public int remove(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i2)) == null) {
                m.b(i2, "occurrences");
                if (i2 == 0) {
                    return count(obj);
                }
                if (contains(obj)) {
                    return this.f71002e.remove(obj, i2);
                }
                return 0;
            }
            return invokeLI.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<E> implements Iterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final s0<E> f71005e;

        /* renamed from: f  reason: collision with root package name */
        public final Iterator<s0.a<E>> f71006f;

        /* renamed from: g  reason: collision with root package name */
        public s0.a<E> f71007g;

        /* renamed from: h  reason: collision with root package name */
        public int f71008h;

        /* renamed from: i  reason: collision with root package name */
        public int f71009i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f71010j;

        public f(s0<E> s0Var, Iterator<s0.a<E>> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71005e = s0Var;
            this.f71006f = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71008h > 0 || this.f71006f.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (hasNext()) {
                    if (this.f71008h == 0) {
                        s0.a<E> next = this.f71006f.next();
                        this.f71007g = next;
                        int count = next.getCount();
                        this.f71008h = count;
                        this.f71009i = count;
                    }
                    this.f71008h--;
                    this.f71010j = true;
                    return this.f71007g.getElement();
                }
                throw new NoSuchElementException();
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                m.e(this.f71010j);
                if (this.f71009i == 1) {
                    this.f71006f.remove();
                } else {
                    this.f71005e.remove(this.f71007g.getElement());
                }
                this.f71009i--;
                this.f71010j = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class g<E> extends c.i.d.c.d<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        @Override // c.i.d.c.d, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                elementSet().clear();
            }
        }

        @Override // c.i.d.c.d
        public int distinctElements() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? elementSet().size() : invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, c.i.d.c.s0
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Multisets.k(this) : invokeV.intValue;
        }

        public /* synthetic */ g(t0 t0Var) {
            this();
        }
    }

    public static <E> boolean a(s0<E> s0Var, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, s0Var, abstractMapBasedMultiset)) == null) {
            if (abstractMapBasedMultiset.isEmpty()) {
                return false;
            }
            abstractMapBasedMultiset.addTo(s0Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static <E> boolean b(s0<E> s0Var, s0<? extends E> s0Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, s0Var, s0Var2)) == null) {
            if (s0Var2 instanceof AbstractMapBasedMultiset) {
                return a(s0Var, (AbstractMapBasedMultiset) s0Var2);
            }
            if (s0Var2.isEmpty()) {
                return false;
            }
            for (s0.a<? extends E> aVar : s0Var2.entrySet()) {
                s0Var.add(aVar.getElement(), aVar.getCount());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static <E> boolean c(s0<E> s0Var, Collection<? extends E> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, s0Var, collection)) == null) {
            n.p(s0Var);
            n.p(collection);
            if (collection instanceof s0) {
                return b(s0Var, d(collection));
            }
            if (collection.isEmpty()) {
                return false;
            }
            return Iterators.a(s0Var, collection.iterator());
        }
        return invokeLL.booleanValue;
    }

    public static <T> s0<T> d(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? (s0) iterable : (s0) invokeL.objValue;
    }

    public static <E> Iterator<E> e(Iterator<s0.a<E>> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, it)) == null) ? new a(it) : (Iterator) invokeL.objValue;
    }

    public static boolean f(s0<?> s0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, s0Var, obj)) == null) {
            if (obj == s0Var) {
                return true;
            }
            if (obj instanceof s0) {
                s0 s0Var2 = (s0) obj;
                if (s0Var.size() == s0Var2.size() && s0Var.entrySet().size() == s0Var2.entrySet().size()) {
                    for (s0.a aVar : s0Var2.entrySet()) {
                        if (s0Var.count(aVar.getElement()) != aVar.getCount()) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <E> s0<E> g(s0<E> s0Var, o<? super E> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, s0Var, oVar)) == null) {
            if (s0Var instanceof e) {
                e eVar = (e) s0Var;
                return new e(eVar.f71002e, Predicates.c(eVar.f71003f, oVar));
            }
            return new e(s0Var, oVar);
        }
        return (s0) invokeLL.objValue;
    }

    public static <E> s0.a<E> h(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, e2, i2)) == null) ? new ImmutableEntry(e2, i2) : (s0.a) invokeLI.objValue;
    }

    public static int i(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            if (iterable instanceof s0) {
                return ((s0) iterable).elementSet().size();
            }
            return 11;
        }
        return invokeL.intValue;
    }

    public static <E> Iterator<E> j(s0<E> s0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, s0Var)) == null) ? new f(s0Var, s0Var.entrySet().iterator()) : (Iterator) invokeL.objValue;
    }

    public static int k(s0<?> s0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, s0Var)) == null) {
            long j2 = 0;
            for (s0.a<?> aVar : s0Var.entrySet()) {
                j2 += aVar.getCount();
            }
            return Ints.j(j2);
        }
        return invokeL.intValue;
    }

    public static boolean l(s0<?> s0Var, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, s0Var, collection)) == null) {
            if (collection instanceof s0) {
                collection = ((s0) collection).elementSet();
            }
            return s0Var.elementSet().removeAll(collection);
        }
        return invokeLL.booleanValue;
    }

    public static boolean m(s0<?> s0Var, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, s0Var, collection)) == null) {
            n.p(collection);
            if (collection instanceof s0) {
                collection = ((s0) collection).elementSet();
            }
            return s0Var.elementSet().retainAll(collection);
        }
        return invokeLL.booleanValue;
    }

    public static <E> int n(s0<E> s0Var, E e2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, null, s0Var, e2, i2)) == null) {
            m.b(i2, "count");
            int count = s0Var.count(e2);
            int i3 = i2 - count;
            if (i3 > 0) {
                s0Var.add(e2, i3);
            } else if (i3 < 0) {
                s0Var.remove(e2, -i3);
            }
            return count;
        }
        return invokeLLI.intValue;
    }

    public static <E> boolean o(s0<E> s0Var, E e2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, s0Var, e2, i2, i3)) == null) {
            m.b(i2, "oldCount");
            m.b(i3, "newCount");
            if (s0Var.count(e2) == i2) {
                s0Var.setCount(e2, i3);
                return true;
            }
            return false;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.i.d.c.s0<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> s0<E> p(s0<? extends E> s0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, s0Var)) == null) {
            if ((s0Var instanceof UnmodifiableMultiset) || (s0Var instanceof ImmutableMultiset)) {
                return s0Var;
            }
            n.p(s0Var);
            return new UnmodifiableMultiset(s0Var);
        }
        return (s0) invokeL.objValue;
    }

    public static <E> h1<E> q(h1<E> h1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, h1Var)) == null) {
            n.p(h1Var);
            return new UnmodifiableSortedMultiset(h1Var);
        }
        return (h1) invokeL.objValue;
    }
}
