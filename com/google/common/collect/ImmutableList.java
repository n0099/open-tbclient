package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.m;
import c.i.d.c.o0;
import c.i.d.c.o1;
import c.i.d.c.p1;
import c.i.d.c.u0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes10.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public static /* synthetic */ Interceptable $ic;
    public static final p1<Object> EMPTY_ITR;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient ImmutableList<E> forwardList;

        public ReverseImmutableList(ImmutableList<E> immutableList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? (size() - 1) - i2 : invokeI.intValue;
        }

        private int reversePosition(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? size() - i2 : invokeI.intValue;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.forwardList.contains(obj) : invokeL.booleanValue;
        }

        @Override // java.util.List
        public E get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                n.n(i2, size());
                return this.forwardList.get(reverseIndex(i2));
            }
            return (E) invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                int lastIndexOf = this.forwardList.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    return reverseIndex(lastIndexOf);
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.forwardList.isPartialView() : invokeV.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                int indexOf = this.forwardList.indexOf(obj);
                if (indexOf >= 0) {
                    return reverseIndex(indexOf);
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.forwardList : (ImmutableList) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.forwardList.size() : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return super.listIterator(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
                n.v(i2, i3, size());
                return this.forwardList.subList(reversePosition(i3), reversePosition(i2)).reverse();
            }
            return (ImmutableList) invokeII.objValue;
        }
    }

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ImmutableList.copyOf(this.elements) : invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class SubList extends ImmutableList<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient int length;
        public final transient int offset;
        public final /* synthetic */ ImmutableList this$0;

        public SubList(ImmutableList immutableList, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableList, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = immutableList;
            this.offset = i2;
            this.length = i3;
        }

        @Override // java.util.List
        public E get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                n.n(i2, this.length);
                return this.this$0.get(i2 + this.offset);
            }
            return (E) invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object[] internalArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.internalArray() : (Object[]) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.internalArrayStart() + this.offset + this.length : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.internalArrayStart() + this.offset : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.length : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return super.listIterator(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
                n.v(i2, i3, this.length);
                ImmutableList immutableList = this.this$0;
                int i4 = this.offset;
                return immutableList.subList(i2 + i4, i3 + i4);
            }
            return (ImmutableList) invokeII.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
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

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableCollection.b a(Object obj) {
            h(obj);
            return this;
        }

        public a<E> h(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                super.f(e2);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> i(Iterator<? extends E> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, it)) == null) {
                super.d(it);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public ImmutableList<E> j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.f70108c = true;
                return ImmutableList.asImmutableList(this.f70106a, this.f70107b);
            }
            return (ImmutableList) invokeV.objValue;
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
        }
    }

    /* loaded from: classes10.dex */
    public static class b<E> extends c.i.d.c.a<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final ImmutableList<E> f70109g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImmutableList<E> immutableList, int i2) {
            super(immutableList.size(), i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70109g = immutableList;
        }

        @Override // c.i.d.c.a
        public E a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f70109g.get(i2) : (E) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(553503240, "Lcom/google/common/collect/ImmutableList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(553503240, "Lcom/google/common/collect/ImmutableList;");
                return;
            }
        }
        EMPTY_ITR = new b(RegularImmutableList.EMPTY, 0);
    }

    public ImmutableList() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, objArr)) == null) ? asImmutableList(objArr, objArr.length) : (ImmutableList) invokeL.objValue;
    }

    public static <E> a<E> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <E> a<E> builderWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            m.b(i2, "expectedSize");
            return new a<>(i2);
        }
        return (a) invokeI.objValue;
    }

    public static <E> ImmutableList<E> construct(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, objArr)) == null) {
            u0.b(objArr);
            return asImmutableList(objArr);
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            n.p(iterable);
            if (iterable instanceof Collection) {
                return copyOf((Collection) iterable);
            }
            return copyOf(iterable.iterator());
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static <E> ImmutableList<E> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? (ImmutableList<E>) RegularImmutableList.EMPTY : (ImmutableList) invokeV.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, objectInputStream) == null) {
            throw new InvalidObjectException("Use SerializedForm");
        }
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, iterable)) == null) {
            Comparable[] comparableArr = (Comparable[]) o0.q(iterable, new Comparable[0]);
            u0.b(comparableArr);
            Arrays.sort(comparableArr);
            return asImmutableList(comparableArr);
        }
        return (ImmutableList) invokeL.objValue;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, e2) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeIL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (ImmutableList) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? indexOf(obj) >= 0 : invokeL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, objArr, i2)) == null) {
            int size = size();
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i2 + i3] = get(i3);
            }
            return i2 + size;
        }
        return invokeLI.intValue;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? Lists.d(this, obj) : invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int size = size();
            int i2 = 1;
            for (int i3 = 0; i3 < size; i3++) {
                i2 = ~(~((i2 * 31) + get(i3).hashCode()));
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            return Lists.e(this, obj);
        }
        return invokeL.intValue;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            return Lists.g(this, obj);
        }
        return invokeL.intValue;
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E) invokeI.objValue;
    }

    public ImmutableList<E> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? size() <= 1 ? this : new ReverseImmutableList(this) : (ImmutableList) invokeV.objValue;
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i2, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i2, e2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E) invokeIL.objValue;
    }

    public ImmutableList<E> subListUnchecked(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) ? new SubList(this, i2, i3 - i2) : (ImmutableList) invokeII.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new SerializedForm(toArray()) : invokeV.objValue;
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, objArr, i2)) == null) {
            if (i2 == 0) {
                return of();
            }
            return new RegularImmutableList(objArr, i2);
        }
        return (ImmutableList) invokeLI.objValue;
    }

    public static <E> ImmutableList<E> of(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, e2)) == null) ? construct(e2) : (ImmutableList) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public o1<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? listIterator() : (o1) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public ImmutableList<E> subList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i2, i3)) == null) {
            n.v(i2, i3, size());
            int i4 = i3 - i2;
            if (i4 == size()) {
                return this;
            }
            if (i4 == 0) {
                return of();
            }
            return subListUnchecked(i2, i3);
        }
        return (ImmutableList) invokeII.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, e2, e3)) == null) ? construct(e2, e3) : (ImmutableList) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public p1<E> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? listIterator(0) : (p1) invokeV.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, e2, e3, e4)) == null) ? construct(e2, e3, e4) : (ImmutableList) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public p1<E> listIterator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            n.t(i2, size());
            if (isEmpty()) {
                return (p1<E>) EMPTY_ITR;
            }
            return new b(this, i2);
        }
        return (p1) invokeI.objValue;
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            if (collection instanceof ImmutableCollection) {
                ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
                return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
            }
            return construct(collection.toArray());
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, e2, e3, e4, e5)) == null) ? construct(e2, e3, e4, e5) : (ImmutableList) invokeLLLL.objValue;
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, comparator, iterable)) == null) {
            n.p(comparator);
            Object[] o = o0.o(iterable);
            u0.b(o);
            Arrays.sort(o, comparator);
            return asImmutableList(o);
        }
        return (ImmutableList) invokeLL.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65552, null, e2, e3, e4, e5, e6)) == null) ? construct(e2, e3, e4, e5, e6) : (ImmutableList) invokeLLLLL.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{e2, e3, e4, e5, e6, e7})) == null) ? construct(e2, e3, e4, e5, e6, e7) : (ImmutableList) invokeCommon.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{e2, e3, e4, e5, e6, e7, e8})) == null) ? construct(e2, e3, e4, e5, e6, e7, e8) : (ImmutableList) invokeCommon.objValue;
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
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
            aVar.h(next);
            aVar.i(it);
            return aVar.j();
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{e2, e3, e4, e5, e6, e7, e8, e9})) == null) ? construct(e2, e3, e4, e5, e6, e7, e8, e9) : (ImmutableList) invokeCommon.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{e2, e3, e4, e5, e6, e7, e8, e9, e10})) == null) ? construct(e2, e3, e4, e5, e6, e7, e8, e9, e10) : (ImmutableList) invokeCommon.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{e2, e3, e4, e5, e6, e7, e8, e9, e10, e11})) == null) ? construct(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11) : (ImmutableList) invokeCommon.objValue;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12})) == null) ? construct(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12) : (ImmutableList) invokeCommon.objValue;
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, eArr})) == null) {
            n.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
            Object[] objArr = new Object[eArr.length + 12];
            objArr[0] = e2;
            objArr[1] = e3;
            objArr[2] = e4;
            objArr[3] = e5;
            objArr[4] = e6;
            objArr[5] = e7;
            objArr[6] = e8;
            objArr[7] = e9;
            objArr[8] = e10;
            objArr[9] = e11;
            objArr[10] = e12;
            objArr[11] = e13;
            System.arraycopy(eArr, 0, objArr, 12, eArr.length);
            return construct(objArr);
        }
        return (ImmutableList) invokeCommon.objValue;
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, eArr)) == null) {
            if (eArr.length == 0) {
                return of();
            }
            return construct((Object[]) eArr.clone());
        }
        return (ImmutableList) invokeL.objValue;
    }
}
