package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.g;
import b.i.d.a.k;
import b.i.d.a.n;
import b.i.d.c.m;
import b.i.d.c.n1;
import b.i.d.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
public final class Lists {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final E first;
        public final E[] rest;

        public OnePlusArrayList(E e2, E[] eArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2, eArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.first = e2;
            n.p(eArr);
            this.rest = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                n.n(i2, size());
                return i2 == 0 ? this.first : this.rest[i2 - 1];
            }
            return (E) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.e(this.rest.length, 1) : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class StringAsImmutableList extends ImmutableList<Character> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String string;

        public StringAsImmutableList(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Character) {
                    return this.string.indexOf(((Character) obj).charValue());
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof Character) {
                    return this.string.lastIndexOf(((Character) obj).charValue());
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.string.length() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.List
        public Character get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                n.n(i2, size());
                return Character.valueOf(this.string.charAt(i2));
            }
            return (Character) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
                n.v(i2, i3, size());
                return Lists.b(this.string.substring(i2, i3));
            }
            return (ImmutableList) invokeII.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<F> fromList;
        public final g<? super F, ? extends T> function;

        /* loaded from: classes2.dex */
        public class a extends n1<F, T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ TransformingRandomAccessList f63453f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(TransformingRandomAccessList transformingRandomAccessList, ListIterator listIterator) {
                super(listIterator);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {transformingRandomAccessList, listIterator};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((ListIterator) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63453f = transformingRandomAccessList;
            }

            @Override // b.i.d.c.m1
            public T a(F f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f2)) == null) ? this.f63453f.function.apply(f2) : (T) invokeL.objValue;
            }
        }

        public TransformingRandomAccessList(List<F> list, g<? super F, ? extends T> gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(list);
            this.fromList = list;
            n.p(gVar);
            this.function = gVar;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.fromList.clear();
            }
        }

        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: F, ? super F */
        @Override // java.util.AbstractList, java.util.List
        public T get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.function.apply((F) this.fromList.get(i2)) : (T) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fromList.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? listIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? new a(this, this.fromList.listIterator(i2)) : (ListIterator) invokeI.objValue;
        }

        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: F, ? super F */
        @Override // java.util.AbstractList, java.util.List
        public T remove(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.function.apply((F) this.fromList.remove(i2)) : (T) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.fromList.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<F> fromList;
        public final g<? super F, ? extends T> function;

        /* loaded from: classes2.dex */
        public class a extends n1<F, T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ TransformingSequentialList f63454f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(TransformingSequentialList transformingSequentialList, ListIterator listIterator) {
                super(listIterator);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {transformingSequentialList, listIterator};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((ListIterator) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63454f = transformingSequentialList;
            }

            @Override // b.i.d.c.m1
            public T a(F f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f2)) == null) ? this.f63454f.function.apply(f2) : (T) invokeL.objValue;
            }
        }

        public TransformingSequentialList(List<F> list, g<? super F, ? extends T> gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(list);
            this.fromList = list;
            n.p(gVar);
            this.function = gVar;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.fromList.clear();
            }
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new a(this, this.fromList.listIterator(i2)) : (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fromList.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final E first;
        public final E[] rest;
        public final E second;

        public TwoPlusArrayList(E e2, E e3, E[] eArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2, e3, eArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.first = e2;
            this.second = e3;
            n.p(eArr);
            this.rest = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        n.n(i2, size());
                        return this.rest[i2 - 2];
                    }
                    return this.second;
                }
                return this.first;
            }
            return (E) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.e(this.rest.length, 2) : invokeV.intValue;
        }
    }

    public static <E> List<E> a(E e2, E[] eArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, e2, eArr)) == null) ? new OnePlusArrayList(e2, eArr) : (List) invokeLL.objValue;
    }

    public static ImmutableList<Character> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            n.p(str);
            return new StringAsImmutableList(str);
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            m.b(i2, "arraySize");
            return Ints.j(i2 + 5 + (i2 / 10));
        }
        return invokeI.intValue;
    }

    public static boolean d(List<?> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, obj)) == null) {
            n.p(list);
            if (obj == list) {
                return true;
            }
            if (obj instanceof List) {
                List list2 = (List) obj;
                int size = list.size();
                if (size != list2.size()) {
                    return false;
                }
                if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (!k.a(list.get(i2), list2.get(i2))) {
                            return false;
                        }
                    }
                    return true;
                }
                return Iterators.h(list.iterator(), list2.iterator());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int e(List<?> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, obj)) == null) {
            if (list instanceof RandomAccess) {
                return f(list, obj);
            }
            ListIterator<?> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (k.a(obj, listIterator.next())) {
                    return listIterator.previousIndex();
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int f(List<?> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, obj)) == null) {
            int size = list.size();
            int i2 = 0;
            if (obj == null) {
                while (i2 < size) {
                    if (list.get(i2) == null) {
                        return i2;
                    }
                    i2++;
                }
                return -1;
            }
            while (i2 < size) {
                if (obj.equals(list.get(i2))) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int g(List<?> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, obj)) == null) {
            if (list instanceof RandomAccess) {
                return h(list, obj);
            }
            ListIterator<?> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (k.a(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int h(List<?> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, obj)) == null) {
            if (obj == null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (list.get(size) == null) {
                        return size;
                    }
                }
                return -1;
            }
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (obj.equals(list.get(size2))) {
                    return size2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static <E> ArrayList<E> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new ArrayList<>() : (ArrayList) invokeV.objValue;
    }

    public static <E> ArrayList<E> j(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iterable)) == null) {
            n.p(iterable);
            if (iterable instanceof Collection) {
                return new ArrayList<>(b.i.d.c.n.a(iterable));
            }
            return k(iterable.iterator());
        }
        return (ArrayList) invokeL.objValue;
    }

    public static <E> ArrayList<E> k(Iterator<? extends E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, it)) == null) {
            ArrayList<E> i2 = i();
            Iterators.a(i2, it);
            return i2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static <E> ArrayList<E> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            m.b(i2, "initialArraySize");
            return new ArrayList<>(i2);
        }
        return (ArrayList) invokeI.objValue;
    }

    public static <E> ArrayList<E> m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? new ArrayList<>(c(i2)) : (ArrayList) invokeI.objValue;
    }

    public static <F, T> List<T> n(List<F> list, g<? super F, ? extends T> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, list, gVar)) == null) ? list instanceof RandomAccess ? new TransformingRandomAccessList(list, gVar) : new TransformingSequentialList(list, gVar) : (List) invokeLL.objValue;
    }
}
