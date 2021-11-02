package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import b.i.d.c.h1;
import b.i.d.c.m;
import b.i.d.c.s0;
import b.i.d.f.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements h1<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableSortedMultiset<E> descendingMultiset;

    /* loaded from: classes2.dex */
    public static final class SerializedForm<E> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Comparator<? super E> comparator;
        public final int[] counts;
        public final E[] elements;

        public SerializedForm(h1<E> h1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.comparator = h1Var.comparator();
            int size = h1Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i4 = 0;
            for (s0.a<E> aVar : h1Var.entrySet()) {
                this.elements[i4] = aVar.getElement();
                this.counts[i4] = aVar.getCount();
                i4++;
            }
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int length = this.elements.length;
                a aVar = new a(this.comparator);
                for (int i2 = 0; i2 < length; i2++) {
                    aVar.q(this.elements[i2], this.counts[i2]);
                }
                return aVar.k();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class a<E> extends ImmutableMultiset.b<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final Comparator<? super E> f63385d;

        /* renamed from: e  reason: collision with root package name */
        public E[] f63386e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f63387f;

        /* renamed from: g  reason: collision with root package name */
        public int f63388g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f63389h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Comparator<? super E> comparator) {
            super(true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(comparator);
            this.f63385d = comparator;
            this.f63386e = (E[]) new Object[4];
            this.f63387f = new int[4];
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b, com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableCollection.b a(Object obj) {
            m(obj);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b f(Object obj) {
            m(obj);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b g(Object[] objArr) {
            n(objArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b h(Iterable iterable) {
            o(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b i(Iterator it) {
            p(it);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b j(Object obj, int i2) {
            q(obj, i2);
            return this;
        }

        public a<E> m(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e2)) == null) {
                q(e2, 1);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> n(E... eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eArr)) == null) {
                for (E e2 : eArr) {
                    m(e2);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> o(Iterable<? extends E> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iterable)) == null) {
                if (iterable instanceof s0) {
                    for (s0.a<E> aVar : ((s0) iterable).entrySet()) {
                        q(aVar.getElement(), aVar.getCount());
                    }
                } else {
                    for (E e2 : iterable) {
                        m(e2);
                    }
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> p(Iterator<? extends E> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, it)) == null) {
                while (it.hasNext()) {
                    m(it.next());
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> q(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, e2, i2)) == null) {
                n.p(e2);
                m.b(i2, "occurrences");
                if (i2 == 0) {
                    return this;
                }
                u();
                E[] eArr = this.f63386e;
                int i3 = this.f63388g;
                eArr[i3] = e2;
                this.f63387f[i3] = i2;
                this.f63388g = i3 + 1;
                return this;
            }
            return (a) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: r */
        public ImmutableSortedMultiset<E> k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                t();
                int i2 = this.f63388g;
                if (i2 == 0) {
                    return ImmutableSortedMultiset.emptyMultiset(this.f63385d);
                }
                RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f63385d, i2, this.f63386e);
                long[] jArr = new long[this.f63388g + 1];
                int i3 = 0;
                while (i3 < this.f63388g) {
                    int i4 = i3 + 1;
                    jArr[i4] = jArr[i3] + this.f63387f[i3];
                    i3 = i4;
                }
                this.f63389h = true;
                return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f63388g);
            }
            return (ImmutableSortedMultiset) invokeV.objValue;
        }

        public final void s(boolean z) {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (i2 = this.f63388g) == 0) {
                return;
            }
            E[] eArr = (E[]) Arrays.copyOf(this.f63386e, i2);
            Arrays.sort(eArr, this.f63385d);
            int i3 = 1;
            for (int i4 = 1; i4 < eArr.length; i4++) {
                if (this.f63385d.compare((Object) eArr[i3 - 1], (Object) eArr[i4]) < 0) {
                    eArr[i3] = eArr[i4];
                    i3++;
                }
            }
            Arrays.fill(eArr, i3, this.f63388g, (Object) null);
            if (z) {
                int i5 = i3 * 4;
                int i6 = this.f63388g;
                if (i5 > i6 * 3) {
                    eArr = (E[]) Arrays.copyOf(eArr, c.e(i6, (i6 / 2) + 1));
                }
            }
            int[] iArr = new int[eArr.length];
            for (int i7 = 0; i7 < this.f63388g; i7++) {
                int binarySearch = Arrays.binarySearch(eArr, 0, i3, this.f63386e[i7], this.f63385d);
                int[] iArr2 = this.f63387f;
                if (iArr2[i7] >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + iArr2[i7];
                } else {
                    iArr[binarySearch] = ~iArr2[i7];
                }
            }
            this.f63386e = eArr;
            this.f63387f = iArr;
            this.f63388g = i3;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048590, this) != null) {
                return;
            }
            s(false);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f63388g;
                if (i2 < i4) {
                    int[] iArr = this.f63387f;
                    if (iArr[i2] > 0) {
                        E[] eArr = this.f63386e;
                        eArr[i3] = eArr[i2];
                        iArr[i3] = iArr[i2];
                        i3++;
                    }
                    i2++;
                } else {
                    Arrays.fill(this.f63386e, i3, i4, (Object) null);
                    Arrays.fill(this.f63387f, i3, this.f63388g, 0);
                    this.f63388g = i3;
                    return;
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                int i2 = this.f63388g;
                E[] eArr = this.f63386e;
                if (i2 == eArr.length) {
                    s(true);
                } else if (this.f63389h) {
                    this.f63386e = (E[]) Arrays.copyOf(eArr, eArr.length);
                }
                this.f63389h = false;
            }
        }
    }

    public ImmutableSortedMultiset() {
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

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, comparableArr)) == null) ? copyOf(Ordering.natural(), Arrays.asList(comparableArr)) : (ImmutableSortedMultiset) invokeL.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(h1<E> h1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, h1Var)) == null) ? copyOfSortedEntries(h1Var.comparator(), Lists.j(h1Var.entrySet())) : (ImmutableSortedMultiset) invokeL.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<s0.a<E>> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, comparator, collection)) == null) {
            if (collection.isEmpty()) {
                return emptyMultiset(comparator);
            }
            ImmutableList.a aVar = new ImmutableList.a(collection.size());
            long[] jArr = new long[collection.size() + 1];
            int i2 = 0;
            for (s0.a<E> aVar2 : collection) {
                aVar.h(aVar2.getElement());
                int i3 = i2 + 1;
                jArr[i3] = jArr[i2] + aVar2.getCount();
                i2 = i3;
            }
            return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.j(), comparator), jArr, 0, collection.size());
        }
        return (ImmutableSortedMultiset) invokeLL.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, comparator)) == null) {
            if (Ordering.natural().equals(comparator)) {
                return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
            }
            return new RegularImmutableSortedMultiset(comparator);
        }
        return (ImmutableSortedMultiset) invokeL.objValue;
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a<>(Ordering.natural()) : (a) invokeV.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : (ImmutableSortedMultiset) invokeV.objValue;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, comparator)) == null) ? new a<>(comparator) : (a) invokeL.objValue;
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? new a<>(Ordering.natural().reverse()) : (a) invokeV.objValue;
    }

    @Override // b.i.d.c.h1, b.i.d.c.f1
    public final Comparator<? super E> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? elementSet().comparator() : (Comparator) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, b.i.d.c.s0
    public abstract /* synthetic */ int count(Object obj);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultiset, b.i.d.c.s0
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ s0.a<E> firstEntry();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ h1 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // b.i.d.c.h1
    public abstract ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType);

    public abstract /* synthetic */ s0.a<E> lastEntry();

    @Override // b.i.d.c.h1
    @Deprecated
    public final s0.a<E> pollFirstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // b.i.d.c.h1
    @Deprecated
    public final s0.a<E> pollLastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (s0.a) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.d.c.h1
    public /* bridge */ /* synthetic */ h1 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ h1 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // b.i.d.c.h1
    public abstract ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new SerializedForm(this) : invokeV.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) ? copyOf(Ordering.natural(), iterable) : (ImmutableSortedMultiset) invokeL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, comparable)) == null) ? new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1) : (ImmutableSortedMultiset) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.h1
    public ImmutableSortedMultiset<E> descendingMultiset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
            if (immutableSortedMultiset == null) {
                immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
                this.descendingMultiset = immutableSortedMultiset;
            }
            return immutableSortedMultiset;
        }
        return (ImmutableSortedMultiset) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.d.c.h1
    public ImmutableSortedMultiset<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, e2, boundType, e3, boundType2)) == null) {
            n.l(comparator().compare(e2, e3) <= 0, "Expected lowerBound <= upperBound but %s > %s", e2, e3);
            return tailMultiset((ImmutableSortedMultiset<E>) e2, boundType).headMultiset((ImmutableSortedMultiset<E>) e3, boundType2);
        }
        return (ImmutableSortedMultiset) invokeLLLL.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, it)) == null) ? copyOf(Ordering.natural(), it) : (ImmutableSortedMultiset) invokeL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, comparable, comparable2)) == null) ? copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2)) : (ImmutableSortedMultiset) invokeLL.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, comparator, it)) == null) {
            n.p(comparator);
            a aVar = new a(comparator);
            aVar.p(it);
            return aVar.k();
        }
        return (ImmutableSortedMultiset) invokeLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, comparable, comparable2, comparable3)) == null) ? copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3)) : (ImmutableSortedMultiset) invokeLLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, comparable, comparable2, comparable3, comparable4)) == null) ? copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4)) : (ImmutableSortedMultiset) invokeLLLL.objValue;
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, comparator, iterable)) == null) {
            if (iterable instanceof ImmutableSortedMultiset) {
                ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
                if (comparator.equals(immutableSortedMultiset.comparator())) {
                    return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
                }
            }
            a aVar = new a(comparator);
            aVar.o(iterable);
            return aVar.k();
        }
        return (ImmutableSortedMultiset) invokeLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65551, null, comparable, comparable2, comparable3, comparable4, comparable5)) == null) ? copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5)) : (ImmutableSortedMultiset) invokeLLLLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{comparable, comparable2, comparable3, comparable4, comparable5, comparable6, comparableArr})) == null) {
            ArrayList l = Lists.l(comparableArr.length + 6);
            Collections.addAll(l, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
            Collections.addAll(l, comparableArr);
            return copyOf(Ordering.natural(), l);
        }
        return (ImmutableSortedMultiset) invokeCommon.objValue;
    }
}
