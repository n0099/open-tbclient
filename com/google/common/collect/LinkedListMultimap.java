package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import b.i.d.c.m;
import b.i.d.c.n1;
import b.i.d.c.p0;
import b.i.d.c.q0;
import b.i.d.c.s0;
import b.i.d.c.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes2.dex */
public class LinkedListMultimap<K, V> extends b.i.d.c.c<K, V> implements p0<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient g<K, V> head;
    public transient Map<K, f<K, V>> keyToKeyList;
    public transient int modCount;
    public transient int size;
    public transient g<K, V> tail;

    /* loaded from: classes2.dex */
    public class a extends AbstractSequentialList<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f63424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f63425f;

        public a(LinkedListMultimap linkedListMultimap, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63425f = linkedListMultimap;
            this.f63424e = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new i(this.f63425f, this.f63424e, i2) : (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                f fVar = (f) this.f63425f.keyToKeyList.get(this.f63424e);
                if (fVar == null) {
                    return 0;
                }
                return fVar.f63437c;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f63426e;

        public b(LinkedListMultimap linkedListMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63426e = linkedListMultimap;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new h(this.f63426e, i2) : (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63426e.size : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Sets.c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f63427e;

        public c(LinkedListMultimap linkedListMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63427e = linkedListMultimap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.f63427e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(this.f63427e, null) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? !this.f63427e.removeAll(obj).isEmpty() : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63427e.keyToKeyList.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends AbstractSequentialList<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f63428e;

        /* loaded from: classes2.dex */
        public class a extends n1<Map.Entry<K, V>, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f63429f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, listIterator, hVar};
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
                this.f63429f = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.i.d.c.m1
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.getValue() : (V) invokeL.objValue;
            }

            @Override // b.i.d.c.n1, java.util.ListIterator
            public void set(V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v) == null) {
                    this.f63429f.f(v);
                }
            }
        }

        public d(LinkedListMultimap linkedListMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63428e = linkedListMultimap;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                h hVar = new h(this.f63428e, i2);
                return new a(this, hVar, hVar);
            }
            return (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63428e.size : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class f<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public g<K, V> f63435a;

        /* renamed from: b  reason: collision with root package name */
        public g<K, V> f63436b;

        /* renamed from: c  reason: collision with root package name */
        public int f63437c;

        public f(g<K, V> gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63435a = gVar;
            this.f63436b = gVar;
            gVar.j = null;
            gVar.f63442i = null;
            this.f63437c = 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class g<K, V> extends b.i.d.c.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f63438e;

        /* renamed from: f  reason: collision with root package name */
        public V f63439f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f63440g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f63441h;

        /* renamed from: i  reason: collision with root package name */
        public g<K, V> f63442i;
        public g<K, V> j;

        public g(K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63438e = k;
            this.f63439f = v;
        }

        @Override // b.i.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63438e : (K) invokeV.objValue;
        }

        @Override // b.i.d.c.b, java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63439f : (V) invokeV.objValue;
        }

        @Override // b.i.d.c.b, java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) {
                V v2 = this.f63439f;
                this.f63439f = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class h implements ListIterator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f63443e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f63444f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f63445g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f63446h;

        /* renamed from: i  reason: collision with root package name */
        public int f63447i;
        public final /* synthetic */ LinkedListMultimap j;

        public h(LinkedListMultimap linkedListMultimap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = linkedListMultimap;
            this.f63447i = this.j.modCount;
            int size = linkedListMultimap.size();
            n.t(i2, size);
            if (i2 >= size / 2) {
                this.f63446h = linkedListMultimap.tail;
                this.f63443e = size;
                while (true) {
                    int i5 = i2 + 1;
                    if (i2 >= size) {
                        break;
                    }
                    previous();
                    i2 = i5;
                }
            } else {
                this.f63444f = linkedListMultimap.head;
                while (true) {
                    int i6 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i6;
                }
            }
            this.f63445g = null;
        }

        public void a(Map.Entry<K, V> entry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, entry) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.j.modCount != this.f63447i) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c */
        public g<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                b();
                LinkedListMultimap.checkElement(this.f63444f);
                g<K, V> gVar = this.f63444f;
                this.f63445g = gVar;
                this.f63446h = gVar;
                this.f63444f = gVar.f63440g;
                this.f63443e++;
                return gVar;
            }
            return (g) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: d */
        public g<K, V> previous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                b();
                LinkedListMultimap.checkElement(this.f63446h);
                g<K, V> gVar = this.f63446h;
                this.f63445g = gVar;
                this.f63444f = gVar;
                this.f63446h = gVar.f63441h;
                this.f63443e--;
                return gVar;
            }
            return (g) invokeV.objValue;
        }

        public void e(Map.Entry<K, V> entry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, entry) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void f(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, v) == null) {
                n.w(this.f63445g != null);
                this.f63445g.f63439f = v;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                b();
                return this.f63444f != null;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                b();
                return this.f63446h != null;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f63443e : invokeV.intValue;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f63443e - 1 : invokeV.intValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                b();
                m.e(this.f63445g != null);
                g<K, V> gVar = this.f63445g;
                if (gVar != this.f63444f) {
                    this.f63446h = gVar.f63441h;
                    this.f63443e--;
                } else {
                    this.f63444f = gVar.f63440g;
                }
                this.j.removeNode(this.f63445g);
                this.f63445g = null;
                this.f63447i = this.j.modCount;
            }
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            e((Map.Entry) obj);
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkedListMultimap() {
        this(12);
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

    /* JADX INFO: Access modifiers changed from: private */
    public g<K, V> addNode(K k, V v, g<K, V> gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, k, v, gVar)) == null) {
            g<K, V> gVar2 = new g<>(k, v);
            if (this.head == null) {
                this.tail = gVar2;
                this.head = gVar2;
                this.keyToKeyList.put(k, new f<>(gVar2));
                this.modCount++;
            } else if (gVar == null) {
                g<K, V> gVar3 = this.tail;
                gVar3.f63440g = gVar2;
                gVar2.f63441h = gVar3;
                this.tail = gVar2;
                f<K, V> fVar = this.keyToKeyList.get(k);
                if (fVar == null) {
                    this.keyToKeyList.put(k, new f<>(gVar2));
                    this.modCount++;
                } else {
                    fVar.f63437c++;
                    g<K, V> gVar4 = fVar.f63436b;
                    gVar4.f63442i = gVar2;
                    gVar2.j = gVar4;
                    fVar.f63436b = gVar2;
                }
            } else {
                this.keyToKeyList.get(k).f63437c++;
                gVar2.f63441h = gVar.f63441h;
                gVar2.j = gVar.j;
                gVar2.f63440g = gVar;
                gVar2.f63442i = gVar;
                g<K, V> gVar5 = gVar.j;
                if (gVar5 == null) {
                    this.keyToKeyList.get(k).f63435a = gVar2;
                } else {
                    gVar5.f63442i = gVar2;
                }
                g<K, V> gVar6 = gVar.f63441h;
                if (gVar6 == null) {
                    this.head = gVar2;
                } else {
                    gVar6.f63440g = gVar2;
                }
                gVar.f63441h = gVar2;
                gVar.j = gVar2;
            }
            this.size++;
            return gVar2;
        }
        return (g) invokeLLL.objValue;
    }

    public static void checkElement(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, obj) == null) && obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? new LinkedListMultimap<>() : (LinkedListMultimap) invokeV.objValue;
    }

    private List<V> getCopy(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, this, obj)) == null) ? Collections.unmodifiableList(Lists.k(new i(this, obj))) : (List) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.LinkedListMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            this.keyToKeyList = CompactLinkedHashMap.create();
            int readInt = objectInputStream.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, obj) == null) {
            Iterators.e(new i(this, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, gVar) == null) {
            g<K, V> gVar2 = gVar.f63441h;
            if (gVar2 != null) {
                gVar2.f63440g = gVar.f63440g;
            } else {
                this.head = gVar.f63440g;
            }
            g<K, V> gVar3 = gVar.f63440g;
            if (gVar3 != null) {
                gVar3.f63441h = gVar.f63441h;
            } else {
                this.tail = gVar.f63441h;
            }
            if (gVar.j == null && gVar.f63442i == null) {
                this.keyToKeyList.remove(gVar.f63438e).f63437c = 0;
                this.modCount++;
            } else {
                f<K, V> fVar = this.keyToKeyList.get(gVar.f63438e);
                fVar.f63437c--;
                g<K, V> gVar4 = gVar.j;
                if (gVar4 == null) {
                    fVar.f63435a = gVar.f63442i;
                } else {
                    gVar4.f63442i = gVar.f63442i;
                }
                g<K, V> gVar5 = gVar.f63442i;
                if (gVar5 == null) {
                    fVar.f63436b = gVar.j;
                } else {
                    gVar5.j = gVar.j;
                }
            }
            this.size--;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(size());
            for (Map.Entry<K, V> entry : entries()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // b.i.d.c.q0
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.head = null;
            this.tail = null;
            this.keyToKeyList.clear();
            this.size = 0;
            this.modCount++;
        }
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // b.i.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.keyToKeyList.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? values().contains(obj) : invokeL.booleanValue;
    }

    @Override // b.i.d.c.c
    public Map<K, Collection<V>> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new Multimaps.a(this) : (Map) invokeV.objValue;
    }

    @Override // b.i.d.c.c
    public Set<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new c(this) : (Set) invokeV.objValue;
    }

    @Override // b.i.d.c.c
    public s0<K> createKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new Multimaps.c(this) : (s0) invokeV.objValue;
    }

    @Override // b.i.d.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.head == null : invokeV.booleanValue;
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ s0 keys() {
        return super.keys();
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public boolean put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, k, v)) == null) {
            addNode(k, v, null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(q0 q0Var) {
        return super.putAll(q0Var);
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // b.i.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // b.i.d.c.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public LinkedListMultimap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.keyToKeyList = y0.c(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? new LinkedListMultimap<>(i2) : (LinkedListMultimap) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.c
    public List<Map.Entry<K, V>> createEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new b(this) : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.c
    public List<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new d(this) : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.c, b.i.d.c.q0
    public List<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (List) super.entries() : (List) invokeV.objValue;
    }

    @Override // b.i.d.c.q0
    public List<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k)) == null) ? new a(this, k) : (List) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.d.c.c, b.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.q0
    public List<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            List<V> copy = getCopy(obj);
            removeAllNodes(obj);
            return copy;
        }
        return (List) invokeL.objValue;
    }

    @Override // b.i.d.c.c, b.i.d.c.q0
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, k, iterable)) == null) {
            List<V> copy = getCopy(k);
            i iVar = new i(this, k);
            Iterator<? extends V> it = iterable.iterator();
            while (iVar.hasNext() && it.hasNext()) {
                iVar.next();
                iVar.set(it.next());
            }
            while (iVar.hasNext()) {
                iVar.next();
                iVar.remove();
            }
            while (it.hasNext()) {
                iVar.add(it.next());
            }
            return copy;
        }
        return (List) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.c, b.i.d.c.q0
    public List<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (List) super.values() : (List) invokeV.objValue;
    }

    public static <K, V> LinkedListMultimap<K, V> create(q0<? extends K, ? extends V> q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, q0Var)) == null) ? new LinkedListMultimap<>(q0Var) : (LinkedListMultimap) invokeL.objValue;
    }

    /* loaded from: classes2.dex */
    public class e implements Iterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Set<K> f63430e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f63431f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f63432g;

        /* renamed from: h  reason: collision with root package name */
        public int f63433h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f63434i;

        public e(LinkedListMultimap linkedListMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63434i = linkedListMultimap;
            this.f63430e = Sets.g(this.f63434i.keySet().size());
            this.f63431f = this.f63434i.head;
            this.f63433h = this.f63434i.modCount;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63434i.modCount != this.f63433h) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.f63431f != null;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            g<K, V> gVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a();
                LinkedListMultimap.checkElement(this.f63431f);
                g<K, V> gVar2 = this.f63431f;
                this.f63432g = gVar2;
                this.f63430e.add(gVar2.f63438e);
                do {
                    gVar = this.f63431f.f63440g;
                    this.f63431f = gVar;
                    if (gVar == null) {
                        break;
                    }
                } while (!this.f63430e.add(gVar.f63438e));
                return this.f63432g.f63438e;
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a();
                m.e(this.f63432g != null);
                this.f63434i.removeAllNodes(this.f63432g.f63438e);
                this.f63432g = null;
                this.f63433h = this.f63434i.modCount;
            }
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this(linkedListMultimap);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements ListIterator<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Object f63448e;

        /* renamed from: f  reason: collision with root package name */
        public int f63449f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f63450g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f63451h;

        /* renamed from: i  reason: collision with root package name */
        public g<K, V> f63452i;
        public final /* synthetic */ LinkedListMultimap j;

        public i(LinkedListMultimap linkedListMultimap, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = linkedListMultimap;
            this.f63448e = obj;
            f fVar = (f) linkedListMultimap.keyToKeyList.get(obj);
            this.f63450g = fVar == null ? null : fVar.f63435a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                this.f63452i = this.j.addNode(this.f63448e, v, this.f63450g);
                this.f63449f++;
                this.f63451h = null;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63450g != null : invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63452i != null : invokeV.booleanValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                LinkedListMultimap.checkElement(this.f63450g);
                g<K, V> gVar = this.f63450g;
                this.f63451h = gVar;
                this.f63452i = gVar;
                this.f63450g = gVar.f63442i;
                this.f63449f++;
                return gVar.f63439f;
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63449f : invokeV.intValue;
        }

        @Override // java.util.ListIterator
        public V previous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                LinkedListMultimap.checkElement(this.f63452i);
                g<K, V> gVar = this.f63452i;
                this.f63451h = gVar;
                this.f63450g = gVar;
                this.f63452i = gVar.j;
                this.f63449f--;
                return gVar.f63439f;
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63449f - 1 : invokeV.intValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                m.e(this.f63451h != null);
                g<K, V> gVar = this.f63451h;
                if (gVar != this.f63450g) {
                    this.f63452i = gVar.j;
                    this.f63449f--;
                } else {
                    this.f63450g = gVar.f63442i;
                }
                this.j.removeNode(this.f63451h);
                this.f63451h = null;
            }
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v) == null) {
                n.w(this.f63451h != null);
                this.f63451h.f63439f = v;
            }
        }

        public i(LinkedListMultimap linkedListMultimap, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedListMultimap, obj, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.j = linkedListMultimap;
            f fVar = (f) linkedListMultimap.keyToKeyList.get(obj);
            int i5 = fVar == null ? 0 : fVar.f63437c;
            n.t(i2, i5);
            if (i2 >= i5 / 2) {
                this.f63452i = fVar == null ? null : fVar.f63436b;
                this.f63449f = i5;
                while (true) {
                    int i6 = i2 + 1;
                    if (i2 >= i5) {
                        break;
                    }
                    previous();
                    i2 = i6;
                }
            } else {
                this.f63450g = fVar == null ? null : fVar.f63435a;
                while (true) {
                    int i7 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i7;
                }
            }
            this.f63448e = obj;
            this.f63451h = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkedListMultimap(q0<? extends K, ? extends V> q0Var) {
        this(q0Var.keySet().size());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q0Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        putAll(q0Var);
    }
}
