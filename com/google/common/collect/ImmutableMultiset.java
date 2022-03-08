package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.c.a.n;
import c.i.c.c.o1;
import c.i.c.c.s0;
import c.i.c.c.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements s0<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableList<E> asList;
    public transient ImmutableSet<s0.a<E>> entrySet;

    /* loaded from: classes7.dex */
    public final class EntrySet extends IndexedImmutableSet<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImmutableMultiset this$0;

        public EntrySet(ImmutableMultiset immutableMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = immutableMultiset;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof s0.a) {
                    s0.a aVar = (s0.a) obj;
                    return aVar.getCount() > 0 && this.this$0.count(aVar.getElement()) == aVar.getCount();
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.this$0.isPartialView() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.this$0.elementSet().size() : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new EntrySetSerializedForm(this.this$0) : invokeV.objValue;
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this(immutableMultiset);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.IndexedImmutableSet
        public s0.a<E> get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.this$0.getEntry(i2) : (s0.a) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class EntrySetSerializedForm<E> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.multiset.entrySet() : invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends o1<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f53194e;

        /* renamed from: f  reason: collision with root package name */
        public E f53195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Iterator f53196g;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMultiset, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53196g = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53194e > 0 || this.f53196g.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f53194e <= 0) {
                    s0.a aVar = (s0.a) this.f53196g.next();
                    this.f53195f = (E) aVar.getElement();
                    this.f53194e = aVar.getCount();
                }
                this.f53194e--;
                return this.f53195f;
            }
            return (E) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<E> extends ImmutableCollection.b<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v0<E> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f53197b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53198c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b() {
            this(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: c.i.c.c.v0<E>, c.i.c.c.v0<T> */
        /* JADX DEBUG: Type inference failed for r4v5. Raw type applied. Possible types: c.i.c.c.v0<E>, c.i.c.c.v0<T> */
        public static <T> v0<T> l(Iterable<T> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
                if (iterable instanceof RegularImmutableMultiset) {
                    return (v0<E>) ((RegularImmutableMultiset) iterable).contents;
                }
                if (iterable instanceof AbstractMapBasedMultiset) {
                    return (v0<E>) ((AbstractMapBasedMultiset) iterable).backingMap;
                }
                return null;
            }
            return (v0) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: f */
        public b<E> a(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) ? j(e2, 1) : (b) invokeL.objValue;
        }

        public b<E> g(E... eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eArr)) == null) {
                super.b(eArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableMultiset$b<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public b<E> h(Iterable<? extends E> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iterable)) == null) {
                if (iterable instanceof s0) {
                    s0 d2 = Multisets.d(iterable);
                    v0 l = l(d2);
                    if (l != null) {
                        v0<E> v0Var = this.a;
                        v0Var.d(Math.max(v0Var.C(), l.C()));
                        for (int e2 = l.e(); e2 >= 0; e2 = l.s(e2)) {
                            j(l.i(e2), l.k(e2));
                        }
                    } else {
                        Set<s0.a<E>> entrySet = d2.entrySet();
                        v0<E> v0Var2 = this.a;
                        v0Var2.d(Math.max(v0Var2.C(), entrySet.size()));
                        for (s0.a<E> aVar : d2.entrySet()) {
                            j(aVar.getElement(), aVar.getCount());
                        }
                    }
                } else {
                    super.c(iterable);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<E> i(Iterator<? extends E> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, it)) == null) {
                super.d(it);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<E> j(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, e2, i2)) == null) {
                if (i2 == 0) {
                    return this;
                }
                if (this.f53197b) {
                    this.a = new v0<>((v0<? extends E>) this.a);
                    this.f53198c = false;
                }
                this.f53197b = false;
                n.p(e2);
                v0<E> v0Var = this.a;
                v0Var.u(e2, i2 + v0Var.f(e2));
                return this;
            }
            return (b) invokeLI.objValue;
        }

        public ImmutableMultiset<E> k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.a.C() == 0) {
                    return ImmutableMultiset.of();
                }
                if (this.f53198c) {
                    this.a = new v0<>((v0<? extends E>) this.a);
                    this.f53198c = false;
                }
                this.f53197b = true;
                return new RegularImmutableMultiset(this.a);
            }
            return (ImmutableMultiset) invokeV.objValue;
        }

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f53197b = false;
            this.f53198c = false;
            this.a = v0.c(i2);
        }

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f53197b = false;
            this.f53198c = false;
            this.a = null;
        }
    }

    public ImmutableMultiset() {
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

    public static <E> b<E> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b<>() : (b) invokeV.objValue;
    }

    public static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eArr)) == null) {
            b bVar = new b();
            bVar.g(eArr);
            return bVar.k();
        }
        return (ImmutableMultiset) invokeL.objValue;
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends s0.a<? extends E>> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, collection)) == null) {
            b bVar = new b(collection.size());
            for (s0.a<? extends E> aVar : collection) {
                bVar.j(aVar.getElement(), aVar.getCount());
            }
            return bVar.k();
        }
        return (ImmutableMultiset) invokeL.objValue;
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eArr)) == null) ? copyFromElements(eArr) : (ImmutableMultiset) invokeL.objValue;
    }

    private ImmutableSet<s0.a<E>> createEntrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? isEmpty() ? ImmutableSet.of() : new EntrySet(this, null) : (ImmutableSet) invokeV.objValue;
    }

    public static <E> ImmutableMultiset<E> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? RegularImmutableMultiset.EMPTY : (ImmutableMultiset) invokeV.objValue;
    }

    @Override // c.i.c.c.s0
    @Deprecated
    public final int add(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeLI.intValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImmutableList<E> immutableList = this.asList;
            if (immutableList == null) {
                ImmutableList<E> asList = super.asList();
                this.asList = asList;
                return asList;
            }
            return immutableList;
        }
        return (ImmutableList) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? count(obj) > 0 : invokeL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, objArr, i2)) == null) {
            o1<s0.a<E>> it = entrySet().iterator();
            while (it.hasNext()) {
                s0.a<E> next = it.next();
                Arrays.fill(objArr, i2, next.getCount() + i2, next.getElement());
                i2 += next.getCount();
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public abstract /* synthetic */ int count(Object obj);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.c.c.s0
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, c.i.c.c.s0
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? Multisets.f(this, obj) : invokeL.booleanValue;
    }

    public abstract s0.a<E> getEntry(int i2);

    @Override // java.util.Collection, c.i.c.c.s0
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Sets.d(entrySet()) : invokeV.intValue;
    }

    @Override // c.i.c.c.s0
    @Deprecated
    public final int remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, obj, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeLI.intValue;
    }

    @Override // c.i.c.c.s0
    @Deprecated
    public final int setCount(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, e2, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeLI.intValue;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? entrySet().toString() : (String) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable)) == null) {
            if (iterable instanceof ImmutableMultiset) {
                ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
                if (!immutableMultiset.isPartialView()) {
                    return immutableMultiset;
                }
            }
            b bVar = new b(Multisets.i(iterable));
            bVar.h(iterable);
            return bVar.k();
        }
        return (ImmutableMultiset) invokeL.objValue;
    }

    public static <E> ImmutableMultiset<E> of(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, e2)) == null) ? copyFromElements(e2) : (ImmutableMultiset) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.c.c.s0
    public ImmutableSet<s0.a<E>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImmutableSet<s0.a<E>> immutableSet = this.entrySet;
            if (immutableSet == null) {
                ImmutableSet<s0.a<E>> createEntrySet = createEntrySet();
                this.entrySet = createEntrySet;
                return createEntrySet;
            }
            return immutableSet;
        }
        return (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public o1<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this, entrySet().iterator()) : (o1) invokeV.objValue;
    }

    @Override // c.i.c.c.s0
    @Deprecated
    public final boolean setCount(E e2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, e2, i2, i3)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeLII.booleanValue;
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, e2, e3)) == null) ? copyFromElements(e2, e3) : (ImmutableMultiset) invokeLL.objValue;
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, e2, e3, e4)) == null) ? copyFromElements(e2, e3, e4) : (ImmutableMultiset) invokeLLL.objValue;
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, e2, e3, e4, e5)) == null) ? copyFromElements(e2, e3, e4, e5) : (ImmutableMultiset) invokeLLLL.objValue;
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5, E e6) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, e2, e3, e4, e5, e6)) == null) ? copyFromElements(e2, e3, e4, e5, e6) : (ImmutableMultiset) invokeLLLLL.objValue;
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{e2, e3, e4, e5, e6, e7, eArr})) == null) ? new b().a(e2).a(e3).a(e4).a(e5).a(e6).a(e7).g(eArr).k() : (ImmutableMultiset) invokeCommon.objValue;
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, it)) == null) {
            b bVar = new b();
            bVar.i(it);
            return bVar.k();
        }
        return (ImmutableMultiset) invokeL.objValue;
    }
}
