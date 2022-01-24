package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.g;
import c.i.d.c.n;
import c.i.d.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
/* loaded from: classes3.dex */
public final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Range<C> range;

    /* loaded from: classes3.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DiscreteDomain<C> domain;
        public final Range<C> range;

        public /* synthetic */ SerializedForm(Range range, DiscreteDomain discreteDomain, a aVar) {
            this(range, discreteDomain);
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new RegularContiguousSet(this.range, this.domain) : invokeV.objValue;
        }

        public SerializedForm(Range<C> range, DiscreteDomain<C> discreteDomain) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {range, discreteDomain};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.range = range;
            this.domain = discreteDomain;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends g<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final C f54848f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RegularContiguousSet f54849g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RegularContiguousSet regularContiguousSet, Comparable comparable) {
            super(comparable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {regularContiguousSet, comparable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54849g = regularContiguousSet;
            this.f54848f = (C) this.f54849g.last();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.g
        /* renamed from: b */
        public C a(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2)) == null) {
                if (RegularContiguousSet.equalsOrThrow(c2, this.f54848f)) {
                    return null;
                }
                return this.f54849g.domain.next(c2);
            }
            return (C) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends g<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final C f54850f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RegularContiguousSet f54851g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RegularContiguousSet regularContiguousSet, Comparable comparable) {
            super(comparable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {regularContiguousSet, comparable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54851g = regularContiguousSet;
            this.f54850f = (C) this.f54851g.first();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.g
        /* renamed from: b */
        public C a(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2)) == null) {
                if (RegularContiguousSet.equalsOrThrow(c2, this.f54850f)) {
                    return null;
                }
                return this.f54851g.domain.previous(c2);
            }
            return (C) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegularContiguousSet(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {range, discreteDomain};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((DiscreteDomain) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.range = range;
    }

    public static boolean equalsOrThrow(Comparable<?> comparable, Comparable<?> comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, comparable, comparable2)) == null) ? comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0 : invokeLL.booleanValue;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, range)) == null) ? this.range.isConnected(range) ? ContiguousSet.create(this.range.intersection(range), this.domain) : new EmptyContiguousSet(this.domain) : (ContiguousSet) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            try {
                return this.range.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? n.b(this, collection) : invokeL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.domain.supportsFastOffset) {
                return new ImmutableAsList<C>(this) { // from class: com.google.common.collect.RegularContiguousSet.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RegularContiguousSet this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.common.collect.ImmutableAsList
                    public ImmutableSortedSet<C> delegateCollection() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0 : (ImmutableSortedSet) invokeV2.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.List
                    public C get(int i2) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                            c.i.d.a.n.n(i2, size());
                            RegularContiguousSet regularContiguousSet = this.this$0;
                            return (C) regularContiguousSet.domain.offset(regularContiguousSet.first(), i2);
                        }
                        return (C) invokeI.objValue;
                    }
                };
            }
            return super.createAsList();
        }
        return (ImmutableList) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RegularContiguousSet) {
                RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
                if (this.domain.equals(regularContiguousSet.domain)) {
                    return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
                }
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Sets.d(this) : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.RegularContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((RegularContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (contains(obj)) {
                return (int) this.domain.distance(first(), (Comparable) obj);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, contiguousSet)) == null) {
            c.i.d.a.n.p(contiguousSet);
            c.i.d.a.n.d(this.domain.equals(contiguousSet.domain));
            if (contiguousSet.isEmpty()) {
                return contiguousSet;
            }
            Comparable comparable = (Comparable) Ordering.natural().max(first(), contiguousSet.first());
            Comparable comparable2 = (Comparable) Ordering.natural().min(last(), contiguousSet.last());
            return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
        }
        return (ContiguousSet) invokeL.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            BoundType boundType = BoundType.CLOSED;
            return range(boundType, boundType);
        }
        return (Range) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            long distance = this.domain.distance(first(), last());
            if (distance >= 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return ((int) distance) + 1;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.RegularContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.RegularContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((RegularContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new SerializedForm(this.range, this.domain, null) : invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public o1<C> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this, last()) : (o1) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.range.lowerBound.leastValueAbove(this.domain) : (C) invokeV.objValue;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> headSetImpl(C c2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, c2, z)) == null) ? intersectionInCurrentDomain(Range.upTo(c2, BoundType.forBoolean(z))) : (ContiguousSet) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public o1<C> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new a(this, first()) : (o1) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.range.upperBound.greatestValueBelow(this.domain) : (C) invokeV.objValue;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, boundType, boundType2)) == null) ? Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain)) : (Range) invokeLL.objValue;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{c2, Boolean.valueOf(z), c3, Boolean.valueOf(z2)})) == null) {
            if (c2.compareTo(c3) == 0 && !z && !z2) {
                return new EmptyContiguousSet(this.domain);
            }
            return intersectionInCurrentDomain(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2)));
        }
        return (ContiguousSet) invokeCommon.objValue;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> tailSetImpl(C c2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048600, this, c2, z)) == null) ? intersectionInCurrentDomain(Range.downTo(c2, BoundType.forBoolean(z))) : (ContiguousSet) invokeLZ.objValue;
    }
}
