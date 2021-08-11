package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.m;
import c.i.d.c.n0;
import c.i.d.c.o1;
import c.i.d.c.u0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.SortedSet;
/* loaded from: classes10.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CUTOFF = 751619276;
    public static final double DESIRED_LOAD_FACTOR = 0.7d;
    public static final int MAX_TABLE_SIZE = 1073741824;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableList<E> asList;

    /* loaded from: classes10.dex */
    public static class SerializedForm implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.elements = objArr;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ImmutableSet.copyOf(this.elements) : invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class a<E> extends ImmutableCollection.a<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public Object[] f70145d;

        /* renamed from: e  reason: collision with root package name */
        public int f70146e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: h */
        public a<E> a(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                n.p(e2);
                if (this.f70145d != null && ImmutableSet.chooseTableSize(this.f70107b) <= this.f70145d.length) {
                    k(e2);
                    return this;
                }
                this.f70145d = null;
                super.f(e2);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> i(E... eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eArr)) == null) {
                if (this.f70145d != null) {
                    for (E e2 : eArr) {
                        a(e2);
                    }
                } else {
                    super.b(eArr);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> j(Iterator<? extends E> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, it)) == null) {
                n.p(it);
                while (it.hasNext()) {
                    a(it.next());
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void k(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048580, this, e2) != null) {
                return;
            }
            int length = this.f70145d.length - 1;
            int hashCode = e2.hashCode();
            int c2 = n0.c(hashCode);
            while (true) {
                int i2 = c2 & length;
                Object[] objArr = this.f70145d;
                Object obj = objArr[i2];
                if (obj == null) {
                    objArr[i2] = e2;
                    this.f70146e += hashCode;
                    super.f(e2);
                    return;
                } else if (obj.equals(e2)) {
                    return;
                } else {
                    c2 = i2 + 1;
                }
            }
        }

        public ImmutableSet<E> l() {
            InterceptResult invokeV;
            ImmutableSet<E> construct;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i2 = this.f70107b;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (this.f70145d == null || ImmutableSet.chooseTableSize(i2) != this.f70145d.length) {
                            construct = ImmutableSet.construct(this.f70107b, this.f70106a);
                            this.f70107b = construct.size();
                        } else {
                            Object[] copyOf = ImmutableSet.shouldTrim(this.f70107b, this.f70106a.length) ? Arrays.copyOf(this.f70106a, this.f70107b) : this.f70106a;
                            int i3 = this.f70146e;
                            Object[] objArr = this.f70145d;
                            construct = new RegularImmutableSet<>(copyOf, i3, objArr, objArr.length - 1, this.f70107b);
                        }
                        this.f70108c = true;
                        this.f70145d = null;
                        return construct;
                    }
                    return ImmutableSet.of(this.f70106a[0]);
                }
                return ImmutableSet.of();
            }
            return (ImmutableSet) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f70145d = new Object[ImmutableSet.chooseTableSize(i2)];
        }
    }

    public ImmutableSet() {
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

    public static <E> a<E> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <E> a<E> builderWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            m.b(i2, "expectedSize");
            return new a<>(i2);
        }
        return (a) invokeI.objValue;
    }

    public static int chooseTableSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            int max = Math.max(i2, 2);
            if (max < 751619276) {
                int highestOneBit = Integer.highestOneBit(max - 1) << 1;
                while (highestOneBit * 0.7d < max) {
                    highestOneBit <<= 1;
                }
                return highestOneBit;
            }
            n.e(max < 1073741824, "collection too large");
            return 1073741824;
        }
        return invokeI.intValue;
    }

    public static <E> ImmutableSet<E> construct(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, objArr)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    int chooseTableSize = chooseTableSize(i2);
                    Object[] objArr2 = new Object[chooseTableSize];
                    int i3 = chooseTableSize - 1;
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj = objArr[i6];
                        u0.a(obj, i6);
                        int hashCode = obj.hashCode();
                        int c2 = n0.c(hashCode);
                        while (true) {
                            int i7 = c2 & i3;
                            Object obj2 = objArr2[i7];
                            if (obj2 == null) {
                                objArr[i5] = obj;
                                objArr2[i7] = obj;
                                i4 += hashCode;
                                i5++;
                                break;
                            } else if (obj2.equals(obj)) {
                                break;
                            } else {
                                c2++;
                            }
                        }
                    }
                    Arrays.fill(objArr, i5, i2, (Object) null);
                    if (i5 == 1) {
                        return new SingletonImmutableSet(objArr[0], i4);
                    }
                    if (chooseTableSize(i5) < chooseTableSize / 2) {
                        return construct(i5, objArr);
                    }
                    if (shouldTrim(i5, objArr.length)) {
                        objArr = Arrays.copyOf(objArr, i5);
                    }
                    return new RegularImmutableSet(objArr, i4, objArr2, i3, i5);
                }
                return of(objArr[0]);
            }
            return of();
        }
        return (ImmutableSet) invokeIL.objValue;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
                ImmutableSet<E> immutableSet = (ImmutableSet) collection;
                if (!immutableSet.isPartialView()) {
                    return immutableSet;
                }
            }
            Object[] array = collection.toArray();
            return construct(array.length, array);
        }
        return (ImmutableSet) invokeL.objValue;
    }

    public static <E> ImmutableSet<E> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? RegularImmutableSet.EMPTY : (ImmutableSet) invokeV.objValue;
    }

    public static boolean shouldTrim(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i2, i3)) == null) ? i2 < (i3 >> 1) + (i3 >> 2) : invokeII.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImmutableList<E> immutableList = this.asList;
            if (immutableList == null) {
                ImmutableList<E> createAsList = createAsList();
                this.asList = createAsList;
                return createAsList;
            }
            return immutableList;
        }
        return (ImmutableList) invokeV.objValue;
    }

    public ImmutableList<E> createAsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ImmutableList.asImmutableList(toArray()) : (ImmutableList) invokeV.objValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
                return false;
            }
            return Sets.a(this, obj);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Sets.d(this) : invokeV.intValue;
    }

    public boolean isHashCodeFast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract o1<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new SerializedForm(toArray()) : invokeV.objValue;
    }

    public static <E> ImmutableSet<E> of(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, e2)) == null) ? new SingletonImmutableSet(e2) : (ImmutableSet) invokeL.objValue;
    }

    public static <E> ImmutableSet<E> of(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, e2, e3)) == null) ? construct(2, e2, e3) : (ImmutableSet) invokeLL.objValue;
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, e2, e3, e4)) == null) ? construct(3, e2, e3, e4) : (ImmutableSet) invokeLLL.objValue;
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, e2, e3, e4, e5)) == null) ? construct(4, e2, e3, e4, e5) : (ImmutableSet) invokeLLLL.objValue;
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return copyOf((Collection) iterable);
            }
            return copyOf(iterable.iterator());
        }
        return (ImmutableSet) invokeL.objValue;
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65552, null, e2, e3, e4, e5, e6)) == null) ? construct(5, e2, e3, e4, e5, e6) : (ImmutableSet) invokeLLLLL.objValue;
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{e2, e3, e4, e5, e6, e7, eArr})) == null) {
            n.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
            int length = eArr.length + 6;
            Object[] objArr = new Object[length];
            objArr[0] = e2;
            objArr[1] = e3;
            objArr[2] = e4;
            objArr[3] = e5;
            objArr[4] = e6;
            objArr[5] = e7;
            System.arraycopy(eArr, 0, objArr, 6, eArr.length);
            return construct(length, objArr);
        }
        return (ImmutableSet) invokeCommon.objValue;
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, it)) == null) {
            if (!it.hasNext()) {
                return of();
            }
            E next = it.next();
            if (!it.hasNext()) {
                return of((Object) next);
            }
            a aVar = new a();
            aVar.a(next);
            aVar.j(it);
            return aVar.l();
        }
        return (ImmutableSet) invokeL.objValue;
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, eArr)) == null) {
            int length = eArr.length;
            if (length != 0) {
                if (length != 1) {
                    return construct(eArr.length, (Object[]) eArr.clone());
                }
                return of((Object) eArr[0]);
            }
            return of();
        }
        return (ImmutableSet) invokeL.objValue;
    }
}
