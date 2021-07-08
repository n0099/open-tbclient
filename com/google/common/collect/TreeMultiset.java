package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import d.f.d.a.j;
import d.f.d.a.n;
import d.f.d.c.d1;
import d.f.d.c.h;
import d.f.d.c.h1;
import d.f.d.c.m;
import d.f.d.c.o0;
import d.f.d.c.s0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class TreeMultiset<E> extends h<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient e<E> header;
    public final transient GeneralRange<E> range;
    public final transient f<e<E>> rootReference;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static abstract class Aggregate {
        public static final /* synthetic */ Aggregate[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Aggregate DISTINCT;
        public static final Aggregate SIZE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889868940, "Lcom/google/common/collect/TreeMultiset$Aggregate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1889868940, "Lcom/google/common/collect/TreeMultiset$Aggregate;");
                    return;
                }
            }
            SIZE = new Aggregate("SIZE", 0) { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.TreeMultiset.Aggregate
                public int nodeAggregate(e<?> eVar) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, eVar)) == null) ? eVar.f33466b : invokeL.intValue;
                }

                @Override // com.google.common.collect.TreeMultiset.Aggregate
                public long treeAggregate(e<?> eVar) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                        if (eVar == null) {
                            return 0L;
                        }
                        return eVar.f33468d;
                    }
                    return invokeL.longValue;
                }
            };
            Aggregate aggregate = new Aggregate("DISTINCT", 1) { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.collect.TreeMultiset.Aggregate
                public int nodeAggregate(e<?> eVar) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, eVar)) == null) {
                        return 1;
                    }
                    return invokeL.intValue;
                }

                @Override // com.google.common.collect.TreeMultiset.Aggregate
                public long treeAggregate(e<?> eVar) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                        if (eVar == null) {
                            return 0L;
                        }
                        return eVar.f33467c;
                    }
                    return invokeL.longValue;
                }
            };
            DISTINCT = aggregate;
            $VALUES = new Aggregate[]{SIZE, aggregate};
        }

        public Aggregate(String str, int i2) {
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

        public static Aggregate valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Aggregate) Enum.valueOf(Aggregate.class, str) : (Aggregate) invokeL.objValue;
        }

        public static Aggregate[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Aggregate[]) $VALUES.clone() : (Aggregate[]) invokeV.objValue;
        }

        public abstract int nodeAggregate(e<?> eVar);

        public abstract long treeAggregate(e<?> eVar);

        public /* synthetic */ Aggregate(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes6.dex */
    public class a extends Multisets.b<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f33456e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TreeMultiset f33457f;

        public a(TreeMultiset treeMultiset, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeMultiset, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33457f = treeMultiset;
            this.f33456e = eVar;
        }

        @Override // d.f.d.c.s0.a
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int x = this.f33456e.x();
                return x == 0 ? this.f33457f.count(getElement()) : x;
            }
            return invokeV.intValue;
        }

        @Override // d.f.d.c.s0.a
        public E getElement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (E) this.f33456e.y() : (E) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Iterator<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public e<E> f33458e;

        /* renamed from: f  reason: collision with root package name */
        public s0.a<E> f33459f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TreeMultiset f33460g;

        public b(TreeMultiset treeMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33460g = treeMultiset;
            this.f33458e = this.f33460g.firstNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public s0.a<E> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (hasNext()) {
                    s0.a<E> wrapEntry = this.f33460g.wrapEntry(this.f33458e);
                    this.f33459f = wrapEntry;
                    if (this.f33458e.f33473i != this.f33460g.header) {
                        this.f33458e = this.f33458e.f33473i;
                    } else {
                        this.f33458e = null;
                    }
                    return wrapEntry;
                }
                throw new NoSuchElementException();
            }
            return (s0.a) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f33458e == null) {
                    return false;
                }
                if (this.f33460g.range.tooHigh(this.f33458e.y())) {
                    this.f33458e = null;
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                m.e(this.f33459f != null);
                this.f33460g.setCount(this.f33459f.getElement(), 0);
                this.f33459f = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Iterator<s0.a<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public e<E> f33461e;

        /* renamed from: f  reason: collision with root package name */
        public s0.a<E> f33462f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TreeMultiset f33463g;

        public c(TreeMultiset treeMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33463g = treeMultiset;
            this.f33461e = this.f33463g.lastNode();
            this.f33462f = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public s0.a<E> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (hasNext()) {
                    s0.a<E> wrapEntry = this.f33463g.wrapEntry(this.f33461e);
                    this.f33462f = wrapEntry;
                    if (this.f33461e.f33472h != this.f33463g.header) {
                        this.f33461e = this.f33461e.f33472h;
                    } else {
                        this.f33461e = null;
                    }
                    return wrapEntry;
                }
                throw new NoSuchElementException();
            }
            return (s0.a) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f33461e == null) {
                    return false;
                }
                if (this.f33463g.range.tooLow(this.f33461e.y())) {
                    this.f33461e = null;
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                m.e(this.f33462f != null);
                this.f33463g.setCount(this.f33462f.getElement(), 0);
                this.f33462f = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33464a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-606887321, "Lcom/google/common/collect/TreeMultiset$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-606887321, "Lcom/google/common/collect/TreeMultiset$d;");
                    return;
                }
            }
            int[] iArr = new int[BoundType.values().length];
            f33464a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33464a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final E f33465a;

        /* renamed from: b  reason: collision with root package name */
        public int f33466b;

        /* renamed from: c  reason: collision with root package name */
        public int f33467c;

        /* renamed from: d  reason: collision with root package name */
        public long f33468d;

        /* renamed from: e  reason: collision with root package name */
        public int f33469e;

        /* renamed from: f  reason: collision with root package name */
        public e<E> f33470f;

        /* renamed from: g  reason: collision with root package name */
        public e<E> f33471g;

        /* renamed from: h  reason: collision with root package name */
        public e<E> f33472h;

        /* renamed from: i  reason: collision with root package name */
        public e<E> f33473i;

        public e(E e2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.d(i2 > 0);
            this.f33465a = e2;
            this.f33466b = i2;
            this.f33468d = i2;
            this.f33467c = 1;
            this.f33469e = 1;
            this.f33470f = null;
            this.f33471g = null;
        }

        public static long L(e<?> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eVar)) == null) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f33468d;
            }
            return invokeL.longValue;
        }

        public static int z(e<?> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, eVar)) == null) {
                if (eVar == null) {
                    return 0;
                }
                return eVar.f33469e;
            }
            return invokeL.intValue;
        }

        public final e<E> A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int s = s();
                if (s == -2) {
                    if (this.f33471g.s() > 0) {
                        this.f33471g = this.f33471g.I();
                    }
                    return H();
                } else if (s != 2) {
                    C();
                    return this;
                } else {
                    if (this.f33470f.s() < 0) {
                        this.f33470f = this.f33470f.H();
                    }
                    return I();
                }
            }
            return (e) invokeV.objValue;
        }

        public final void B() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                D();
                C();
            }
        }

        public final void C() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33469e = Math.max(z(this.f33470f), z(this.f33471g)) + 1;
            }
        }

        public final void D() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f33467c = TreeMultiset.distinctElements(this.f33470f) + 1 + TreeMultiset.distinctElements(this.f33471g);
                this.f33468d = this.f33466b + L(this.f33470f) + L(this.f33471g);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048580, this, comparator, e2, i2, iArr)) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare < 0) {
                    e<E> eVar = this.f33470f;
                    if (eVar == null) {
                        iArr[0] = 0;
                        return this;
                    }
                    this.f33470f = eVar.E(comparator, e2, i2, iArr);
                    if (iArr[0] > 0) {
                        if (i2 >= iArr[0]) {
                            this.f33467c--;
                            this.f33468d -= iArr[0];
                        } else {
                            this.f33468d -= i2;
                        }
                    }
                    return iArr[0] == 0 ? this : A();
                } else if (compare > 0) {
                    e<E> eVar2 = this.f33471g;
                    if (eVar2 == null) {
                        iArr[0] = 0;
                        return this;
                    }
                    this.f33471g = eVar2.E(comparator, e2, i2, iArr);
                    if (iArr[0] > 0) {
                        if (i2 >= iArr[0]) {
                            this.f33467c--;
                            this.f33468d -= iArr[0];
                        } else {
                            this.f33468d -= i2;
                        }
                    }
                    return A();
                } else {
                    int i3 = this.f33466b;
                    iArr[0] = i3;
                    if (i2 >= i3) {
                        return v();
                    }
                    this.f33466b = i3 - i2;
                    this.f33468d -= i2;
                    return this;
                }
            }
            return (e) invokeLLIL.objValue;
        }

        public final e<E> F(e<E> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
                e<E> eVar2 = this.f33471g;
                if (eVar2 == null) {
                    return this.f33470f;
                }
                this.f33471g = eVar2.F(eVar);
                this.f33467c--;
                this.f33468d -= eVar.f33466b;
                return A();
            }
            return (e) invokeL.objValue;
        }

        public final e<E> G(e<E> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
                e<E> eVar2 = this.f33470f;
                if (eVar2 == null) {
                    return this.f33471g;
                }
                this.f33470f = eVar2.G(eVar);
                this.f33467c--;
                this.f33468d -= eVar.f33466b;
                return A();
            }
            return (e) invokeL.objValue;
        }

        public final e<E> H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                n.w(this.f33471g != null);
                e<E> eVar = this.f33471g;
                this.f33471g = eVar.f33470f;
                eVar.f33470f = this;
                eVar.f33468d = this.f33468d;
                eVar.f33467c = this.f33467c;
                B();
                eVar.C();
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        public final e<E> I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                n.w(this.f33470f != null);
                e<E> eVar = this.f33470f;
                this.f33470f = eVar.f33471g;
                eVar.f33471g = this;
                eVar.f33468d = this.f33468d;
                eVar.f33467c = this.f33467c;
                B();
                eVar.C();
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        public e<E> J(Comparator<? super E> comparator, E e2, int i2, int i3, int[] iArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{comparator, e2, Integer.valueOf(i2), Integer.valueOf(i3), iArr})) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare < 0) {
                    e<E> eVar = this.f33470f;
                    if (eVar == null) {
                        iArr[0] = 0;
                        if (i2 == 0 && i3 > 0) {
                            q(e2, i3);
                        }
                        return this;
                    }
                    this.f33470f = eVar.J(comparator, e2, i2, i3, iArr);
                    if (iArr[0] == i2) {
                        if (i3 == 0 && iArr[0] != 0) {
                            this.f33467c--;
                        } else if (i3 > 0 && iArr[0] == 0) {
                            this.f33467c++;
                        }
                        this.f33468d += i3 - iArr[0];
                    }
                    return A();
                } else if (compare > 0) {
                    e<E> eVar2 = this.f33471g;
                    if (eVar2 == null) {
                        iArr[0] = 0;
                        if (i2 == 0 && i3 > 0) {
                            r(e2, i3);
                        }
                        return this;
                    }
                    this.f33471g = eVar2.J(comparator, e2, i2, i3, iArr);
                    if (iArr[0] == i2) {
                        if (i3 == 0 && iArr[0] != 0) {
                            this.f33467c--;
                        } else if (i3 > 0 && iArr[0] == 0) {
                            this.f33467c++;
                        }
                        this.f33468d += i3 - iArr[0];
                    }
                    return A();
                } else {
                    int i4 = this.f33466b;
                    iArr[0] = i4;
                    if (i2 == i4) {
                        if (i3 == 0) {
                            return v();
                        }
                        this.f33468d += i3 - i4;
                        this.f33466b = i3;
                    }
                    return this;
                }
            }
            return (e) invokeCommon.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            InterceptResult invokeLLIL;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048586, this, comparator, e2, i2, iArr)) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare < 0) {
                    e<E> eVar = this.f33470f;
                    if (eVar == null) {
                        iArr[0] = 0;
                        if (i2 > 0) {
                            q(e2, i2);
                        }
                        return this;
                    }
                    this.f33470f = eVar.K(comparator, e2, i2, iArr);
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f33467c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f33467c++;
                    }
                    this.f33468d += i2 - iArr[0];
                    return A();
                } else if (compare > 0) {
                    e<E> eVar2 = this.f33471g;
                    if (eVar2 == null) {
                        iArr[0] = 0;
                        if (i2 > 0) {
                            r(e2, i2);
                        }
                        return this;
                    }
                    this.f33471g = eVar2.K(comparator, e2, i2, iArr);
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f33467c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f33467c++;
                    }
                    this.f33468d += i2 - iArr[0];
                    return A();
                } else {
                    iArr[0] = this.f33466b;
                    if (i2 == 0) {
                        return v();
                    }
                    this.f33468d += i2 - i3;
                    this.f33466b = i2;
                    return this;
                }
            }
            return (e) invokeLLIL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> p(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048587, this, comparator, e2, i2, iArr)) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare < 0) {
                    e<E> eVar = this.f33470f;
                    if (eVar == null) {
                        iArr[0] = 0;
                        q(e2, i2);
                        return this;
                    }
                    int i3 = eVar.f33469e;
                    this.f33470f = eVar.p(comparator, e2, i2, iArr);
                    if (iArr[0] == 0) {
                        this.f33467c++;
                    }
                    this.f33468d += i2;
                    return this.f33470f.f33469e == i3 ? this : A();
                } else if (compare > 0) {
                    e<E> eVar2 = this.f33471g;
                    if (eVar2 == null) {
                        iArr[0] = 0;
                        r(e2, i2);
                        return this;
                    }
                    int i4 = eVar2.f33469e;
                    this.f33471g = eVar2.p(comparator, e2, i2, iArr);
                    if (iArr[0] == 0) {
                        this.f33467c++;
                    }
                    this.f33468d += i2;
                    return this.f33471g.f33469e == i4 ? this : A();
                } else {
                    int i5 = this.f33466b;
                    iArr[0] = i5;
                    long j = i2;
                    n.d(((long) i5) + j <= 2147483647L);
                    this.f33466b += i2;
                    this.f33468d += j;
                    return this;
                }
            }
            return (e) invokeLLIL.objValue;
        }

        public final e<E> q(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, e2, i2)) == null) {
                e<E> eVar = new e<>(e2, i2);
                this.f33470f = eVar;
                TreeMultiset.successor(this.f33472h, eVar, this);
                this.f33469e = Math.max(2, this.f33469e);
                this.f33467c++;
                this.f33468d += i2;
                return this;
            }
            return (e) invokeLI.objValue;
        }

        public final e<E> r(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, e2, i2)) == null) {
                e<E> eVar = new e<>(e2, i2);
                this.f33471g = eVar;
                TreeMultiset.successor(this, eVar, this.f33473i);
                this.f33469e = Math.max(2, this.f33469e);
                this.f33467c++;
                this.f33468d += i2;
                return this;
            }
            return (e) invokeLI.objValue;
        }

        public final int s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? z(this.f33470f) - z(this.f33471g) : invokeV.intValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> t(Comparator<? super E> comparator, E e2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, comparator, e2)) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare < 0) {
                    e<E> eVar = this.f33470f;
                    return eVar == null ? this : (e) j.a(eVar.t(comparator, e2), this);
                } else if (compare == 0) {
                    return this;
                } else {
                    e<E> eVar2 = this.f33471g;
                    if (eVar2 == null) {
                        return null;
                    }
                    return eVar2.t(comparator, e2);
                }
            }
            return (e) invokeLL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Multisets.h(y(), x()).toString() : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public int u(Comparator<? super E> comparator, E e2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, comparator, e2)) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare < 0) {
                    e<E> eVar = this.f33470f;
                    if (eVar == null) {
                        return 0;
                    }
                    return eVar.u(comparator, e2);
                } else if (compare > 0) {
                    e<E> eVar2 = this.f33471g;
                    if (eVar2 == null) {
                        return 0;
                    }
                    return eVar2.u(comparator, e2);
                } else {
                    return this.f33466b;
                }
            }
            return invokeLL.intValue;
        }

        public final e<E> v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                int i2 = this.f33466b;
                this.f33466b = 0;
                TreeMultiset.successor(this.f33472h, this.f33473i);
                e<E> eVar = this.f33470f;
                if (eVar == null) {
                    return this.f33471g;
                }
                e<E> eVar2 = this.f33471g;
                if (eVar2 == null) {
                    return eVar;
                }
                if (eVar.f33469e >= eVar2.f33469e) {
                    e<E> eVar3 = this.f33472h;
                    eVar3.f33470f = eVar.F(eVar3);
                    eVar3.f33471g = this.f33471g;
                    eVar3.f33467c = this.f33467c - 1;
                    eVar3.f33468d = this.f33468d - i2;
                    return eVar3.A();
                }
                e<E> eVar4 = this.f33473i;
                eVar4.f33471g = eVar2.G(eVar4);
                eVar4.f33470f = this.f33470f;
                eVar4.f33467c = this.f33467c - 1;
                eVar4.f33468d = this.f33468d - i2;
                return eVar4.A();
            }
            return (e) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> w(Comparator<? super E> comparator, E e2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, comparator, e2)) == null) {
                int compare = comparator.compare(e2, (E) this.f33465a);
                if (compare > 0) {
                    e<E> eVar = this.f33471g;
                    return eVar == null ? this : (e) j.a(eVar.w(comparator, e2), this);
                } else if (compare == 0) {
                    return this;
                } else {
                    e<E> eVar2 = this.f33470f;
                    if (eVar2 == null) {
                        return null;
                    }
                    return eVar2.w(comparator, e2);
                }
            }
            return (e) invokeLL.objValue;
        }

        public int x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f33466b : invokeV.intValue;
        }

        public E y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f33465a : (E) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class f<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f33474a;

        public f() {
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

        public void a(T t, T t2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, t2) == null) {
                if (this.f33474a == t) {
                    this.f33474a = t2;
                    return;
                }
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f33474a = null;
            }
        }

        public T c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33474a : (T) invokeV.objValue;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, generalRange, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Comparator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    private long aggregateAboveRange(Aggregate aggregate, e<E> eVar) {
        InterceptResult invokeLL;
        long treeAggregate;
        long aggregateAboveRange;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, aggregate, eVar)) == null) {
            if (eVar == null) {
                return 0L;
            }
            int compare = comparator().compare(this.range.getUpperEndpoint(), eVar.f33465a);
            if (compare > 0) {
                return aggregateAboveRange(aggregate, eVar.f33471g);
            }
            if (compare == 0) {
                int i2 = d.f33464a[this.range.getUpperBoundType().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return aggregate.treeAggregate(eVar.f33471g);
                    }
                    throw new AssertionError();
                }
                treeAggregate = aggregate.nodeAggregate(eVar);
                aggregateAboveRange = aggregate.treeAggregate(eVar.f33471g);
            } else {
                treeAggregate = aggregate.treeAggregate(eVar.f33471g) + aggregate.nodeAggregate(eVar);
                aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f33470f);
            }
            return treeAggregate + aggregateAboveRange;
        }
        return invokeLL.longValue;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        InterceptResult invokeLL;
        long treeAggregate;
        long aggregateBelowRange;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, aggregate, eVar)) == null) {
            if (eVar == null) {
                return 0L;
            }
            int compare = comparator().compare(this.range.getLowerEndpoint(), eVar.f33465a);
            if (compare < 0) {
                return aggregateBelowRange(aggregate, eVar.f33470f);
            }
            if (compare == 0) {
                int i2 = d.f33464a[this.range.getLowerBoundType().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return aggregate.treeAggregate(eVar.f33470f);
                    }
                    throw new AssertionError();
                }
                treeAggregate = aggregate.nodeAggregate(eVar);
                aggregateBelowRange = aggregate.treeAggregate(eVar.f33470f);
            } else {
                treeAggregate = aggregate.treeAggregate(eVar.f33470f) + aggregate.nodeAggregate(eVar);
                aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f33471g);
            }
            return treeAggregate + aggregateBelowRange;
        }
        return invokeLL.longValue;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, aggregate)) == null) {
            e<E> c2 = this.rootReference.c();
            long treeAggregate = aggregate.treeAggregate(c2);
            if (this.range.hasLowerBound()) {
                treeAggregate -= aggregateBelowRange(aggregate, c2);
            }
            return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c2) : treeAggregate;
        }
        return invokeL.longValue;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? new TreeMultiset<>(Ordering.natural()) : (TreeMultiset) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> firstNode() {
        InterceptResult invokeV;
        e<E> eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.rootReference.c() == null) {
                return null;
            }
            if (!this.range.hasLowerBound()) {
                eVar = this.header.f33473i;
            } else {
                E lowerEndpoint = this.range.getLowerEndpoint();
                eVar = this.rootReference.c().t(comparator(), lowerEndpoint);
                if (eVar == null) {
                    return null;
                }
                if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, eVar.y()) == 0) {
                    eVar = eVar.f33473i;
                }
            }
            if (eVar == this.header || !this.range.contains(eVar.y())) {
                return null;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> lastNode() {
        InterceptResult invokeV;
        e<E> eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.rootReference.c() == null) {
                return null;
            }
            if (!this.range.hasUpperBound()) {
                eVar = this.header.f33472h;
            } else {
                E upperEndpoint = this.range.getUpperEndpoint();
                eVar = this.rootReference.c().w(comparator(), upperEndpoint);
                if (eVar == null) {
                    return null;
                }
                if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, eVar.y()) == 0) {
                    eVar = eVar.f33472h;
                }
            }
            if (eVar == this.header || !this.range.contains(eVar.y())) {
                return null;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            Comparator comparator = (Comparator) objectInputStream.readObject();
            d1.a(h.class, "comparator").b(this, comparator);
            d1.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
            d1.a(TreeMultiset.class, "rootReference").b(this, new f(null));
            e eVar = new e(null, 1);
            d1.a(TreeMultiset.class, "header").b(this, eVar);
            successor(eVar, eVar);
            d1.f(this, objectInputStream);
        }
    }

    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, eVar, eVar2) == null) {
            eVar.f33473i = eVar2;
            eVar2.f33472h = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s0.a<E> wrapEntry(e<E> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, this, eVar)) == null) ? new a(this, eVar) : (s0.a) invokeL.objValue;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(elementSet().comparator());
            d1.k(this, objectOutputStream);
        }
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public int add(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
            m.b(i2, "occurrences");
            if (i2 == 0) {
                return count(e2);
            }
            n.d(this.range.contains(e2));
            e<E> c2 = this.rootReference.c();
            if (c2 == null) {
                comparator().compare(e2, e2);
                e<E> eVar = new e<>(e2, i2);
                e<E> eVar2 = this.header;
                successor(eVar2, eVar, eVar2);
                this.rootReference.a(c2, eVar);
                return 0;
            }
            int[] iArr = new int[1];
            this.rootReference.a(c2, c2.p(comparator(), e2, i2, iArr));
            return iArr[0];
        }
        return invokeLI.intValue;
    }

    @Override // d.f.d.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        if (!this.range.hasLowerBound() && !this.range.hasUpperBound()) {
            e<E> eVar = this.header.f33473i;
            while (true) {
                e<E> eVar2 = this.header;
                if (eVar != eVar2) {
                    e<E> eVar3 = eVar.f33473i;
                    eVar.f33466b = 0;
                    eVar.f33470f = null;
                    eVar.f33471g = null;
                    eVar.f33472h = null;
                    eVar.f33473i = null;
                    eVar = eVar3;
                } else {
                    successor(eVar2, eVar2);
                    this.rootReference.b();
                    return;
                }
            }
        } else {
            Iterators.e(entryIterator());
        }
    }

    @Override // d.f.d.c.h, d.f.d.c.h1, d.f.d.c.f1
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // d.f.d.c.d, java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.f.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            try {
                e<E> c2 = this.rootReference.c();
                if (this.range.contains(obj) && c2 != null) {
                    return c2.u(comparator(), obj);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // d.f.d.c.h
    public Iterator<s0.a<E>> descendingEntryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new c(this) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.h, d.f.d.c.h1
    public /* bridge */ /* synthetic */ h1 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // d.f.d.c.d
    public int distinctElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Ints.j(aggregateForEntries(Aggregate.DISTINCT)) : invokeV.intValue;
    }

    @Override // d.f.d.c.d
    public Iterator<E> elementIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Multisets.e(entryIterator()) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.h, d.f.d.c.d, d.f.d.c.s0
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // d.f.d.c.d
    public Iterator<s0.a<E>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new b(this) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // d.f.d.c.h, d.f.d.c.h1
    public /* bridge */ /* synthetic */ s0.a firstEntry() {
        return super.firstEntry();
    }

    @Override // d.f.d.c.h1
    public h1<E> headMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, e2, boundType)) == null) ? new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.header) : (h1) invokeLL.objValue;
    }

    @Override // d.f.d.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.f.d.c.s0
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Multisets.j(this) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.h, d.f.d.c.h1
    public /* bridge */ /* synthetic */ s0.a lastEntry() {
        return super.lastEntry();
    }

    @Override // d.f.d.c.h, d.f.d.c.h1
    public /* bridge */ /* synthetic */ s0.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // d.f.d.c.h, d.f.d.c.h1
    public /* bridge */ /* synthetic */ s0.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public int remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, obj, i2)) == null) {
            m.b(i2, "occurrences");
            if (i2 == 0) {
                return count(obj);
            }
            e<E> c2 = this.rootReference.c();
            int[] iArr = new int[1];
            try {
                if (this.range.contains(obj) && c2 != null) {
                    this.rootReference.a(c2, c2.E(comparator(), obj, i2, iArr));
                    return iArr[0];
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public int setCount(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, e2, i2)) == null) {
            m.b(i2, "count");
            if (!this.range.contains(e2)) {
                n.d(i2 == 0);
                return 0;
            }
            e<E> c2 = this.rootReference.c();
            if (c2 == null) {
                if (i2 > 0) {
                    add(e2, i2);
                }
                return 0;
            }
            int[] iArr = new int[1];
            this.rootReference.a(c2, c2.K(comparator(), e2, i2, iArr));
            return iArr[0];
        }
        return invokeLI.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? Ints.j(aggregateForEntries(Aggregate.SIZE)) : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.f.d.c.h, d.f.d.c.h1
    public /* bridge */ /* synthetic */ h1 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // d.f.d.c.h1
    public h1<E> tailMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, e2, boundType)) == null) ? new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e2, boundType)), this.header) : (h1) invokeLL.objValue;
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, comparator)) == null) ? comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator) : (TreeMultiset) invokeL.objValue;
    }

    public static int distinctElements(e<?> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, eVar)) == null) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f33467c;
        }
        return invokeL.intValue;
    }

    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, eVar, eVar2, eVar3) == null) {
            successor(eVar, eVar2);
            successor(eVar2, eVar3);
        }
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, iterable)) == null) {
            TreeMultiset<E> create = create();
            o0.a(create, iterable);
            return create;
        }
        return (TreeMultiset) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Comparator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>(null, 1);
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    @Override // d.f.d.c.d, d.f.d.c.s0
    public boolean setCount(E e2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, e2, i2, i3)) == null) {
            m.b(i3, "newCount");
            m.b(i2, "oldCount");
            n.d(this.range.contains(e2));
            e<E> c2 = this.rootReference.c();
            if (c2 != null) {
                int[] iArr = new int[1];
                this.rootReference.a(c2, c2.J(comparator(), e2, i2, i3, iArr));
                return iArr[0] == i2;
            } else if (i2 == 0) {
                if (i3 > 0) {
                    add(e2, i3);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeLII.booleanValue;
    }
}
