package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import b.i.d.c.d;
import b.i.d.c.d1;
import b.i.d.c.m;
import b.i.d.c.s0;
import b.i.d.c.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient v0<E> backingMap;
    public transient long size;

    /* loaded from: classes2.dex */
    public class a extends AbstractMapBasedMultiset<E>.c<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultiset f63264i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractMapBasedMultiset abstractMapBasedMultiset) {
            super(abstractMapBasedMultiset);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AbstractMapBasedMultiset) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63264i = abstractMapBasedMultiset;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        public E b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f63264i.backingMap.i(i2) : (E) invokeI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AbstractMapBasedMultiset<E>.c<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultiset f63265i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractMapBasedMultiset abstractMapBasedMultiset) {
            super(abstractMapBasedMultiset);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AbstractMapBasedMultiset) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63265i = abstractMapBasedMultiset;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c */
        public s0.a<E> b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f63265i.backingMap.g(i2) : (s0.a) invokeI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class c<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f63266e;

        /* renamed from: f  reason: collision with root package name */
        public int f63267f;

        /* renamed from: g  reason: collision with root package name */
        public int f63268g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultiset f63269h;

        public c(AbstractMapBasedMultiset abstractMapBasedMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63269h = abstractMapBasedMultiset;
            this.f63266e = this.f63269h.backingMap.e();
            this.f63267f = -1;
            this.f63268g = this.f63269h.backingMap.f33057d;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63269h.backingMap.f33057d != this.f63268g) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a();
                return this.f63266e >= 0;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (hasNext()) {
                    T b2 = b(this.f63266e);
                    int i2 = this.f63266e;
                    this.f63267f = i2;
                    this.f63266e = this.f63269h.backingMap.s(i2);
                    return b2;
                }
                throw new NoSuchElementException();
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractMapBasedMultiset abstractMapBasedMultiset;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a();
                m.e(this.f63267f != -1);
                this.f63269h.size -= abstractMapBasedMultiset.backingMap.x(this.f63267f);
                this.f63266e = this.f63269h.backingMap.t(this.f63266e, this.f63267f);
                this.f63267f = -1;
                this.f63268g = this.f63269h.backingMap.f33057d;
            }
        }
    }

    public AbstractMapBasedMultiset(int i2) {
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
        init(i2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            int h2 = d1.h(objectInputStream);
            init(3);
            d1.g(this, objectInputStream, h2);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            d1.k(this, objectOutputStream);
        }
    }

    @Override // b.i.d.c.d, b.i.d.c.s0
    public final int add(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
            if (i2 == 0) {
                return count(e2);
            }
            n.f(i2 > 0, "occurrences cannot be negative: %s", i2);
            int m = this.backingMap.m(e2);
            if (m == -1) {
                this.backingMap.u(e2, i2);
                this.size += i2;
                return 0;
            }
            int k = this.backingMap.k(m);
            long j = i2;
            long j2 = k + j;
            n.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
            this.backingMap.B(m, (int) j2);
            this.size += j;
            return k;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: E, ? super E */
    public void addTo(s0<? super E> s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s0Var) == null) {
            n.p(s0Var);
            int e2 = this.backingMap.e();
            while (e2 >= 0) {
                s0Var.add((E) this.backingMap.i(e2), this.backingMap.k(e2));
                e2 = this.backingMap.s(e2);
            }
        }
    }

    @Override // b.i.d.c.d, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.backingMap.a();
            this.size = 0L;
        }
    }

    @Override // b.i.d.c.s0
    public final int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.backingMap.f(obj) : invokeL.intValue;
    }

    @Override // b.i.d.c.d
    public final int distinctElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.backingMap.C() : invokeV.intValue;
    }

    @Override // b.i.d.c.d
    public final Iterator<E> elementIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    @Override // b.i.d.c.d
    public final Iterator<s0.a<E>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new b(this) : (Iterator) invokeV.objValue;
    }

    public abstract void init(int i2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, b.i.d.c.s0
    public final Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Multisets.j(this) : (Iterator) invokeV.objValue;
    }

    @Override // b.i.d.c.d, b.i.d.c.s0
    public final int remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, obj, i2)) == null) {
            if (i2 == 0) {
                return count(obj);
            }
            n.f(i2 > 0, "occurrences cannot be negative: %s", i2);
            int m = this.backingMap.m(obj);
            if (m == -1) {
                return 0;
            }
            int k = this.backingMap.k(m);
            if (k > i2) {
                this.backingMap.B(m, k - i2);
            } else {
                this.backingMap.x(m);
                i2 = k;
            }
            this.size -= i2;
            return k;
        }
        return invokeLI.intValue;
    }

    @Override // b.i.d.c.d, b.i.d.c.s0
    public final int setCount(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, e2, i2)) == null) {
            m.b(i2, "count");
            v0<E> v0Var = this.backingMap;
            int v = i2 == 0 ? v0Var.v(e2) : v0Var.u(e2, i2);
            this.size += i2 - v;
            return v;
        }
        return invokeLI.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, b.i.d.c.s0
    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Ints.j(this.size) : invokeV.intValue;
    }

    @Override // b.i.d.c.d, b.i.d.c.s0
    public final boolean setCount(E e2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, e2, i2, i3)) == null) {
            m.b(i2, "oldCount");
            m.b(i3, "newCount");
            int m = this.backingMap.m(e2);
            if (m == -1) {
                if (i2 != 0) {
                    return false;
                }
                if (i3 > 0) {
                    this.backingMap.u(e2, i3);
                    this.size += i3;
                }
                return true;
            } else if (this.backingMap.k(m) != i2) {
                return false;
            } else {
                if (i3 == 0) {
                    this.backingMap.x(m);
                    this.size -= i2;
                } else {
                    this.backingMap.B(m, i3);
                    this.size += i3 - i2;
                }
                return true;
            }
        }
        return invokeLII.booleanValue;
    }
}
