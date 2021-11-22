package com.google.common.collect;

import b.h.d.a.n;
import b.h.d.c.d;
import b.h.d.c.d1;
import b.h.d.c.m;
import b.h.d.c.o0;
import b.h.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes11.dex */
public final class EnumMultiset<E extends Enum<E>> extends d<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient int[] counts;
    public transient int distinctElements;
    public transient E[] enumConstants;
    public transient long size;
    public transient Class<E> type;

    /* loaded from: classes11.dex */
    public class a extends EnumMultiset<E>.c<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ EnumMultiset f64215h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnumMultiset enumMultiset) {
            super(enumMultiset);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enumMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((EnumMultiset) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64215h = enumMultiset;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b */
        public E a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (E) this.f64215h.enumConstants[i2] : (E) invokeI.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class b extends EnumMultiset<E>.c<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ EnumMultiset f64216h;

        /* loaded from: classes11.dex */
        public class a extends Multisets.b<E> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64217e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f64218f;

            public a(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64218f = bVar;
                this.f64217e = i2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.c.s0.a
            /* renamed from: a */
            public E getElement() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (E) this.f64218f.f64216h.enumConstants[this.f64217e] : (E) invokeV.objValue;
            }

            @Override // b.h.d.c.s0.a
            public int getCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64218f.f64216h.counts[this.f64217e] : invokeV.intValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnumMultiset enumMultiset) {
            super(enumMultiset);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enumMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((EnumMultiset) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64216h = enumMultiset;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b */
        public s0.a<E> a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new a(this, i2) : (s0.a) invokeI.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public abstract class c<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f64219e;

        /* renamed from: f  reason: collision with root package name */
        public int f64220f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EnumMultiset f64221g;

        public c(EnumMultiset enumMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enumMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64221g = enumMultiset;
            this.f64219e = 0;
            this.f64220f = -1;
        }

        public abstract T a(int i2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                while (this.f64219e < this.f64221g.enumConstants.length) {
                    int[] iArr = this.f64221g.counts;
                    int i2 = this.f64219e;
                    if (iArr[i2] > 0) {
                        return true;
                    }
                    this.f64219e = i2 + 1;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (hasNext()) {
                    T a2 = a(this.f64219e);
                    int i2 = this.f64219e;
                    this.f64220f = i2;
                    this.f64219e = i2 + 1;
                    return a2;
                }
                throw new NoSuchElementException();
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                m.e(this.f64220f >= 0);
                if (this.f64221g.counts[this.f64220f] > 0) {
                    EnumMultiset.access$210(this.f64221g);
                    this.f64221g.size -= this.f64221g.counts[this.f64220f];
                    this.f64221g.counts[this.f64220f] = 0;
                }
                this.f64220f = -1;
            }
        }
    }

    public EnumMultiset(Class<E> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = cls;
        n.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i2 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i2 - 1;
        return i2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) ? new EnumMultiset<>(cls) : (EnumMultiset) invokeL.objValue;
    }

    private boolean isActuallyE(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, obj)) == null) {
            if (obj instanceof Enum) {
                Enum r5 = (Enum) obj;
                int ordinal = r5.ordinal();
                E[] eArr = this.enumConstants;
                return ordinal < eArr.length && eArr[ordinal] == r5;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            Class<E> cls = (Class) objectInputStream.readObject();
            this.type = cls;
            E[] enumConstants = cls.getEnumConstants();
            this.enumConstants = enumConstants;
            this.counts = new int[enumConstants.length];
            d1.f(this, objectInputStream);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.type);
            d1.k(this, objectOutputStream);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumMultiset<E extends java.lang.Enum<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.h.d.c.d, b.h.d.c.s0
    public /* bridge */ /* synthetic */ int add(Object obj, int i2) {
        return add((EnumMultiset<E>) ((Enum) obj), i2);
    }

    public void checkIsE(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            n.p(obj);
            if (isActuallyE(obj)) {
                return;
            }
            throw new ClassCastException("Expected an " + this.type + " but got " + obj);
        }
    }

    @Override // b.h.d.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.counts, 0);
            this.size = 0L;
            this.distinctElements = 0;
        }
    }

    @Override // b.h.d.c.d, java.util.AbstractCollection, java.util.Collection, b.h.d.c.s0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // b.h.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == null || !isActuallyE(obj)) {
                return 0;
            }
            return this.counts[((Enum) obj).ordinal()];
        }
        return invokeL.intValue;
    }

    @Override // b.h.d.c.d
    public int distinctElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.distinctElements : invokeV.intValue;
    }

    @Override // b.h.d.c.d
    public Iterator<E> elementIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    @Override // b.h.d.c.d, b.h.d.c.s0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // b.h.d.c.d
    public Iterator<s0.a<E>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new b(this) : (Iterator) invokeV.objValue;
    }

    @Override // b.h.d.c.d, b.h.d.c.s0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // b.h.d.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, b.h.d.c.s0
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Multisets.j(this) : (Iterator) invokeV.objValue;
    }

    @Override // b.h.d.c.d, b.h.d.c.s0
    public int remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, obj, i2)) == null) {
            if (obj == null || !isActuallyE(obj)) {
                return 0;
            }
            Enum r1 = (Enum) obj;
            m.b(i2, "occurrences");
            if (i2 == 0) {
                return count(obj);
            }
            int ordinal = r1.ordinal();
            int[] iArr = this.counts;
            int i3 = iArr[ordinal];
            if (i3 == 0) {
                return 0;
            }
            if (i3 <= i2) {
                iArr[ordinal] = 0;
                this.distinctElements--;
                this.size -= i3;
            } else {
                iArr[ordinal] = i3 - i2;
                this.size -= i2;
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumMultiset<E extends java.lang.Enum<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.h.d.c.d, b.h.d.c.s0
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i2) {
        return setCount((EnumMultiset<E>) ((Enum) obj), i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, b.h.d.c.s0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Ints.j(this.size) : invokeV.intValue;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            Iterator<E> it = iterable.iterator();
            n.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
            EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
            o0.a(enumMultiset, iterable);
            return enumMultiset;
        }
        return (EnumMultiset) invokeL.objValue;
    }

    public int add(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
            checkIsE(e2);
            m.b(i2, "occurrences");
            if (i2 == 0) {
                return count(e2);
            }
            int ordinal = e2.ordinal();
            int i3 = this.counts[ordinal];
            long j = i2;
            long j2 = i3 + j;
            n.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
            this.counts[ordinal] = (int) j2;
            if (i3 == 0) {
                this.distinctElements++;
            }
            this.size += j;
            return i3;
        }
        return invokeLI.intValue;
    }

    public int setCount(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, e2, i2)) == null) {
            checkIsE(e2);
            m.b(i2, "count");
            int ordinal = e2.ordinal();
            int[] iArr = this.counts;
            int i3 = iArr[ordinal];
            iArr[ordinal] = i2;
            this.size += i2 - i3;
            if (i3 == 0 && i2 > 0) {
                this.distinctElements++;
            } else if (i3 > 0 && i2 == 0) {
                this.distinctElements--;
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, iterable, cls)) == null) {
            EnumMultiset<E> create = create(cls);
            o0.a(create, iterable);
            return create;
        }
        return (EnumMultiset) invokeLL.objValue;
    }
}
