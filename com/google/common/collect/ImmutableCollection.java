package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.m;
import c.i.d.c.o1;
import c.i.d.c.u0;
import c.i.d.c.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes9.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Object[] EMPTY_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static abstract class a<E> extends b<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object[] f70805a;

        /* renamed from: b  reason: collision with root package name */
        public int f70806b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f70807c;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            m.b(i2, "initialCapacity");
            this.f70805a = new Object[i2];
            this.f70806b = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> b(E... eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eArr)) == null) {
                u0.b(eArr);
                g(this.f70806b + eArr.length);
                System.arraycopy(eArr, 0, this.f70805a, this.f70806b, eArr.length);
                this.f70806b += eArr.length;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public a<E> f(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                n.p(e2);
                g(this.f70806b + 1);
                Object[] objArr = this.f70805a;
                int i2 = this.f70806b;
                this.f70806b = i2 + 1;
                objArr[i2] = e2;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                Object[] objArr = this.f70805a;
                if (objArr.length < i2) {
                    this.f70805a = Arrays.copyOf(objArr, b.e(objArr.length, i2));
                    this.f70807c = false;
                } else if (this.f70807c) {
                    this.f70805a = (Object[]) objArr.clone();
                    this.f70807c = false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class b<E> {
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

        public static int e(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
                if (i3 >= 0) {
                    int i4 = i2 + (i2 >> 1) + 1;
                    if (i4 < i3) {
                        i4 = Integer.highestOneBit(i3 - 1) << 1;
                    }
                    if (i4 < 0) {
                        return Integer.MAX_VALUE;
                    }
                    return i4;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            return invokeII.intValue;
        }

        public abstract b<E> a(E e2);

        public b<E> b(E... eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eArr)) == null) {
                for (E e2 : eArr) {
                    a(e2);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<E> c(Iterable<? extends E> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable)) == null) {
                for (E e2 : iterable) {
                    a(e2);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<E> d(Iterator<? extends E> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, it)) == null) {
                while (it.hasNext()) {
                    a(it.next());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1891655736, "Lcom/google/common/collect/ImmutableCollection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1891655736, "Lcom/google/common/collect/ImmutableCollection;");
                return;
            }
        }
        EMPTY_ARRAY = new Object[0];
    }

    public ImmutableCollection() {
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

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    public ImmutableList<E> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray()) : (ImmutableList) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int copyIntoArray(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, objArr, i2)) == null) {
            o1<E> it = iterator();
            while (it.hasNext()) {
                objArr[i2] = it.next();
                i2++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public Object[] internalArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Object[]) invokeV.objValue;
    }

    public int internalArrayEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeV.intValue;
    }

    public int internalArrayStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeV.intValue;
    }

    public abstract boolean isPartialView();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract o1<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? toArray(EMPTY_ARRAY) : (Object[]) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new ImmutableList.SerializedForm(toArray()) : invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, tArr)) == null) {
            n.p(tArr);
            int size = size();
            if (tArr.length < size) {
                Object[] internalArray = internalArray();
                if (internalArray != null) {
                    return (T[]) y0.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
                }
                tArr = (T[]) u0.g(tArr, size);
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            copyIntoArray(tArr, 0);
            return tArr;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }
}
