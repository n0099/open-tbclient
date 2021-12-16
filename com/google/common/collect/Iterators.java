package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.k;
import c.i.d.a.n;
import c.i.d.a.o;
import c.i.d.c.m;
import c.i.d.c.m1;
import c.i.d.c.o1;
import c.i.d.c.p1;
import c.i.d.c.x0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.text.Typography;
/* loaded from: classes3.dex */
public final class Iterators {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class EmptyModifiableIterator implements Iterator<Object> {
        public static final /* synthetic */ EmptyModifiableIterator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EmptyModifiableIterator INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-430420216, "Lcom/google/common/collect/Iterators$EmptyModifiableIterator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-430420216, "Lcom/google/common/collect/Iterators$EmptyModifiableIterator;");
                    return;
                }
            }
            EmptyModifiableIterator emptyModifiableIterator = new EmptyModifiableIterator("INSTANCE", 0);
            INSTANCE = emptyModifiableIterator;
            $VALUES = new EmptyModifiableIterator[]{emptyModifiableIterator};
        }

        public EmptyModifiableIterator(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EmptyModifiableIterator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EmptyModifiableIterator) Enum.valueOf(EmptyModifiableIterator.class, str) : (EmptyModifiableIterator) invokeL.objValue;
        }

        public static EmptyModifiableIterator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EmptyModifiableIterator[]) $VALUES.clone() : (EmptyModifiableIterator[]) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public Object next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                throw new NoSuchElementException();
            }
            return invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                m.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends o1<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterator f56814e;

        public a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56814e = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56814e.hasNext() : invokeV.booleanValue;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56814e.next() : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends AbstractIterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Iterator f56815g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f56816h;

        public b(Iterator it, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56815g = it;
            this.f56816h = oVar;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
        @Override // com.google.common.collect.AbstractIterator
        public T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                while (this.f56815g.hasNext()) {
                    ?? next = this.f56815g.next();
                    if (this.f56816h.apply(next)) {
                        return next;
                    }
                }
                return b();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends m1<F, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.i.d.a.g f56817f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, c.i.d.a.g gVar) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it, gVar};
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
            this.f56817f = gVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
        @Override // c.i.d.c.m1
        public T a(F f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f2)) == null) ? this.f56817f.apply(f2) : invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends o1<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f56818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f56819f;

        public d(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56819f = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.f56818e : invokeV.booleanValue;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!this.f56818e) {
                    this.f56818e = true;
                    return this.f56819f;
                }
                throw new NoSuchElementException();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e<T> extends c.i.d.c.a<T> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: i  reason: collision with root package name */
        public static final p1<Object> f56820i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final T[] f56821g;

        /* renamed from: h  reason: collision with root package name */
        public final int f56822h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(907880962, "Lcom/google/common/collect/Iterators$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(907880962, "Lcom/google/common/collect/Iterators$e;");
                    return;
                }
            }
            f56820i = new e(new Object[0], 0, 0, 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(T[] tArr, int i2, int i3, int i4) {
            super(i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f56821g = tArr;
            this.f56822h = i2;
        }

        @Override // c.i.d.c.a
        public T a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f56821g[this.f56822h + i2] : (T) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Iterator<? extends T> f56823e;

        /* renamed from: f  reason: collision with root package name */
        public Iterator<? extends T> f56824f;

        /* renamed from: g  reason: collision with root package name */
        public Iterator<? extends Iterator<? extends T>> f56825g;

        /* renamed from: h  reason: collision with root package name */
        public Deque<Iterator<? extends Iterator<? extends T>>> f56826h;

        public f(Iterator<? extends Iterator<? extends T>> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56824f = Iterators.i();
            n.p(it);
            this.f56825g = it;
        }

        public final Iterator<? extends Iterator<? extends T>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (Iterator) invokeV.objValue;
            }
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f56825g;
                if (it != null && it.hasNext()) {
                    return this.f56825g;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f56826h;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f56825g = this.f56826h.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return invokeV.booleanValue;
            }
            while (true) {
                Iterator<? extends T> it = this.f56824f;
                n.p(it);
                if (it.hasNext()) {
                    return true;
                }
                Iterator<? extends Iterator<? extends T>> a = a();
                this.f56825g = a;
                if (a == null) {
                    return false;
                }
                Iterator<? extends T> next = a.next();
                this.f56824f = next;
                if (next instanceof f) {
                    f fVar = (f) next;
                    this.f56824f = fVar.f56824f;
                    if (this.f56826h == null) {
                        this.f56826h = new ArrayDeque();
                    }
                    this.f56826h.addFirst(this.f56825g);
                    if (fVar.f56826h != null) {
                        while (!fVar.f56826h.isEmpty()) {
                            this.f56826h.addFirst(fVar.f56826h.removeLast());
                        }
                    }
                    this.f56825g = fVar.f56825g;
                }
            }
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (hasNext()) {
                    Iterator<? extends T> it = this.f56824f;
                    this.f56823e = it;
                    return it.next();
                }
                throw new NoSuchElementException();
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                m.e(this.f56823e != null);
                this.f56823e.remove();
                this.f56823e = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g<T> extends o1<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Queue<x0<T>> f56827e;

        /* loaded from: classes3.dex */
        public class a implements Comparator<x0<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Comparator f56828e;

            public a(g gVar, Comparator comparator) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, comparator};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56828e = comparator;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(x0<T> x0Var, x0<T> x0Var2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, x0Var, x0Var2)) == null) ? this.f56828e.compare(x0Var.peek(), x0Var2.peek()) : invokeLL.intValue;
            }
        }

        public g(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iterable, comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56827e = new PriorityQueue(2, new a(this, comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f56827e.add(Iterators.s(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.f56827e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                x0<T> remove = this.f56827e.remove();
                T next = remove.next();
                if (remove.hasNext()) {
                    this.f56827e.add(remove);
                }
                return next;
            }
            return (T) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class h<E> implements x0<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<? extends E> f56829e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f56830f;

        /* renamed from: g  reason: collision with root package name */
        public E f56831g;

        public h(Iterator<? extends E> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(it);
            this.f56829e = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56830f || this.f56829e.hasNext() : invokeV.booleanValue;
        }

        @Override // c.i.d.c.x0, java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!this.f56830f) {
                    return this.f56829e.next();
                }
                E e2 = this.f56831g;
                this.f56830f = false;
                this.f56831g = null;
                return e2;
            }
            return (E) invokeV.objValue;
        }

        @Override // c.i.d.c.x0
        public E peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!this.f56830f) {
                    this.f56831g = this.f56829e.next();
                    this.f56830f = true;
                }
                return this.f56831g;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                n.x(!this.f56830f, "Can't remove after you've peeked at next");
                this.f56829e.remove();
            }
        }
    }

    public static <F, T> Iterator<T> A(Iterator<F> it, c.i.d.a.g<? super F, ? extends T> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, it, gVar)) == null) {
            n.p(gVar);
            return new c(it, gVar);
        }
        return (Iterator) invokeLL.objValue;
    }

    public static <T> o1<T> B(Iterator<? extends T> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, it)) == null) {
            n.p(it);
            if (it instanceof o1) {
                return (o1) it;
            }
            return new a(it);
        }
        return (o1) invokeL.objValue;
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, collection, it)) == null) {
            n.p(collection);
            n.p(it);
            boolean z = false;
            while (it.hasNext()) {
                z |= collection.add(it.next());
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static int b(Iterator<?> it, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, it, i2)) == null) {
            n.p(it);
            int i3 = 0;
            n.e(i2 >= 0, "numberToAdvance must be nonnegative");
            while (i3 < i2 && it.hasNext()) {
                it.next();
                i3++;
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public static <T> boolean c(Iterator<T> it, o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, it, oVar)) == null) ? q(it, oVar) != -1 : invokeLL.booleanValue;
    }

    public static <T> ListIterator<T> d(Iterator<T> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, it)) == null) ? (ListIterator) it : (ListIterator) invokeL.objValue;
    }

    public static void e(Iterator<?> it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, it) == null) {
            n.p(it);
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    public static <T> Iterator<T> f(Iterator<? extends Iterator<? extends T>> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, it)) == null) ? new f(it) : (Iterator) invokeL.objValue;
    }

    public static boolean g(Iterator<?> it, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, it, obj)) == null) {
            if (obj == null) {
                while (it.hasNext()) {
                    if (it.next() == null) {
                        return true;
                    }
                }
                return false;
            }
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(Iterator<?> it, Iterator<?> it2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, it, it2)) == null) {
            while (it.hasNext()) {
                if (!it2.hasNext() || !k.a(it.next(), it2.next())) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return !it2.hasNext();
        }
        return invokeLL.booleanValue;
    }

    public static <T> o1<T> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? j() : (o1) invokeV.objValue;
    }

    public static <T> p1<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? (p1<T>) e.f56820i : (p1) invokeV.objValue;
    }

    public static <T> Iterator<T> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? EmptyModifiableIterator.INSTANCE : (Iterator) invokeV.objValue;
    }

    public static <T> o1<T> l(Iterator<T> it, o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, it, oVar)) == null) {
            n.p(it);
            n.p(oVar);
            return new b(it, oVar);
        }
        return (o1) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static <T> T m(Iterator<T> it, o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, it, oVar)) == null) {
            n.p(it);
            n.p(oVar);
            while (it.hasNext()) {
                ?? next = it.next();
                if (oVar.apply(next)) {
                    return next;
                }
            }
            throw new NoSuchElementException();
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T n(Iterator<T> it) {
        T next;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, it)) == null) {
            do {
                next = it.next();
            } while (it.hasNext());
            return next;
        }
        return (T) invokeL.objValue;
    }

    public static <T> T o(Iterator<? extends T> it, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, it, t)) == null) ? it.hasNext() ? it.next() : t : (T) invokeLL.objValue;
    }

    public static <T> T p(Iterator<T> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, it)) == null) {
            T next = it.next();
            if (it.hasNext()) {
                StringBuilder sb = new StringBuilder();
                sb.append("expected one element but was: <");
                sb.append(next);
                for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(it.next());
                }
                if (it.hasNext()) {
                    sb.append(", ...");
                }
                sb.append(Typography.greater);
                throw new IllegalArgumentException(sb.toString());
            }
            return next;
        }
        return (T) invokeL.objValue;
    }

    public static <T> int q(Iterator<T> it, o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, it, oVar)) == null) {
            n.q(oVar, "predicate");
            int i2 = 0;
            while (it.hasNext()) {
                if (oVar.apply(it.next())) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static <T> o1<T> r(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, iterable, comparator)) == null) {
            n.q(iterable, "iterators");
            n.q(comparator, "comparator");
            return new g(iterable, comparator);
        }
        return (o1) invokeLL.objValue;
    }

    public static <T> x0<T> s(Iterator<? extends T> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, it)) == null) {
            if (it instanceof h) {
                return (h) it;
            }
            return new h(it);
        }
        return (x0) invokeL.objValue;
    }

    public static <T> T t(Iterator<T> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, it)) == null) {
            if (it.hasNext()) {
                T next = it.next();
                it.remove();
                return next;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static boolean u(Iterator<?> it, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, it, collection)) == null) {
            n.p(collection);
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean v(Iterator<T> it, o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, it, oVar)) == null) {
            n.p(oVar);
            boolean z = false;
            while (it.hasNext()) {
                if (oVar.apply(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean w(Iterator<?> it, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, it, collection)) == null) {
            n.p(collection);
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static <T> o1<T> x(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, t)) == null) ? new d(t) : (o1) invokeL.objValue;
    }

    public static int y(Iterator<?> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, it)) == null) {
            long j2 = 0;
            while (it.hasNext()) {
                it.next();
                j2++;
            }
            return Ints.j(j2);
        }
        return invokeL.intValue;
    }

    public static String z(Iterator<?> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, it)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            boolean z = true;
            while (it.hasNext()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                z = false;
                sb.append(it.next());
            }
            sb.append(']');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
