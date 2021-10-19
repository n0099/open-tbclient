package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.m;
import c.i.d.c.n1;
import c.i.d.c.p0;
import c.i.d.c.q0;
import c.i.d.c.s0;
import c.i.d.c.y0;
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
/* loaded from: classes9.dex */
public class LinkedListMultimap<K, V> extends c.i.d.c.c<K, V> implements p0<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient g<K, V> head;
    public transient Map<K, f<K, V>> keyToKeyList;
    public transient int modCount;
    public transient int size;
    public transient g<K, V> tail;

    /* loaded from: classes9.dex */
    public class a extends AbstractSequentialList<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f70926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70927f;

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
            this.f70927f = linkedListMultimap;
            this.f70926e = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new i(this.f70927f, this.f70926e, i2) : (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                f fVar = (f) this.f70927f.keyToKeyList.get(this.f70926e);
                if (fVar == null) {
                    return 0;
                }
                return fVar.f70939c;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70928e;

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
            this.f70928e = linkedListMultimap;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new h(this.f70928e, i2) : (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70928e.size : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends Sets.c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70929e;

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
            this.f70929e = linkedListMultimap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.f70929e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(this.f70929e, null) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? !this.f70929e.removeAll(obj).isEmpty() : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70929e.keyToKeyList.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends AbstractSequentialList<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70930e;

        /* loaded from: classes9.dex */
        public class a extends n1<Map.Entry<K, V>, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f70931f;

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
                this.f70931f = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.c.m1
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.getValue() : (V) invokeL.objValue;
            }

            @Override // c.i.d.c.n1, java.util.ListIterator
            public void set(V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v) == null) {
                    this.f70931f.f(v);
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
            this.f70930e = linkedListMultimap;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                h hVar = new h(this.f70930e, i2);
                return new a(this, hVar, hVar);
            }
            return (ListIterator) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70930e.size : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class f<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public g<K, V> f70937a;

        /* renamed from: b  reason: collision with root package name */
        public g<K, V> f70938b;

        /* renamed from: c  reason: collision with root package name */
        public int f70939c;

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
            this.f70937a = gVar;
            this.f70938b = gVar;
            gVar.f70945j = null;
            gVar.f70944i = null;
            this.f70939c = 1;
        }
    }

    /* loaded from: classes9.dex */
    public static final class g<K, V> extends c.i.d.c.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f70940e;

        /* renamed from: f  reason: collision with root package name */
        public V f70941f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f70942g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f70943h;

        /* renamed from: i  reason: collision with root package name */
        public g<K, V> f70944i;

        /* renamed from: j  reason: collision with root package name */
        public g<K, V> f70945j;

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
            this.f70940e = k;
            this.f70941f = v;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70940e : (K) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70941f : (V) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) {
                V v2 = this.f70941f;
                this.f70941f = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements ListIterator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f70946e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f70947f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f70948g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f70949h;

        /* renamed from: i  reason: collision with root package name */
        public int f70950i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70951j;

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
            this.f70951j = linkedListMultimap;
            this.f70950i = this.f70951j.modCount;
            int size = linkedListMultimap.size();
            n.t(i2, size);
            if (i2 >= size / 2) {
                this.f70949h = linkedListMultimap.tail;
                this.f70946e = size;
                while (true) {
                    int i5 = i2 + 1;
                    if (i2 >= size) {
                        break;
                    }
                    previous();
                    i2 = i5;
                }
            } else {
                this.f70947f = linkedListMultimap.head;
                while (true) {
                    int i6 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i6;
                }
            }
            this.f70948g = null;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f70951j.modCount != this.f70950i) {
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
                LinkedListMultimap.checkElement(this.f70947f);
                g<K, V> gVar = this.f70947f;
                this.f70948g = gVar;
                this.f70949h = gVar;
                this.f70947f = gVar.f70942g;
                this.f70946e++;
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
                LinkedListMultimap.checkElement(this.f70949h);
                g<K, V> gVar = this.f70949h;
                this.f70948g = gVar;
                this.f70947f = gVar;
                this.f70949h = gVar.f70943h;
                this.f70946e--;
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
                n.w(this.f70948g != null);
                this.f70948g.f70941f = v;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                b();
                return this.f70947f != null;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                b();
                return this.f70949h != null;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f70946e : invokeV.intValue;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f70946e - 1 : invokeV.intValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                b();
                m.e(this.f70948g != null);
                g<K, V> gVar = this.f70948g;
                if (gVar != this.f70947f) {
                    this.f70949h = gVar.f70943h;
                    this.f70946e--;
                } else {
                    this.f70947f = gVar.f70942g;
                }
                this.f70951j.removeNode(this.f70948g);
                this.f70948g = null;
                this.f70950i = this.f70951j.modCount;
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
                gVar3.f70942g = gVar2;
                gVar2.f70943h = gVar3;
                this.tail = gVar2;
                f<K, V> fVar = this.keyToKeyList.get(k);
                if (fVar == null) {
                    this.keyToKeyList.put(k, new f<>(gVar2));
                    this.modCount++;
                } else {
                    fVar.f70939c++;
                    g<K, V> gVar4 = fVar.f70938b;
                    gVar4.f70944i = gVar2;
                    gVar2.f70945j = gVar4;
                    fVar.f70938b = gVar2;
                }
            } else {
                this.keyToKeyList.get(k).f70939c++;
                gVar2.f70943h = gVar.f70943h;
                gVar2.f70945j = gVar.f70945j;
                gVar2.f70942g = gVar;
                gVar2.f70944i = gVar;
                g<K, V> gVar5 = gVar.f70945j;
                if (gVar5 == null) {
                    this.keyToKeyList.get(k).f70937a = gVar2;
                } else {
                    gVar5.f70944i = gVar2;
                }
                g<K, V> gVar6 = gVar.f70943h;
                if (gVar6 == null) {
                    this.head = gVar2;
                } else {
                    gVar6.f70942g = gVar2;
                }
                gVar.f70943h = gVar2;
                gVar.f70945j = gVar2;
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
            g<K, V> gVar2 = gVar.f70943h;
            if (gVar2 != null) {
                gVar2.f70942g = gVar.f70942g;
            } else {
                this.head = gVar.f70942g;
            }
            g<K, V> gVar3 = gVar.f70942g;
            if (gVar3 != null) {
                gVar3.f70943h = gVar.f70943h;
            } else {
                this.tail = gVar.f70943h;
            }
            if (gVar.f70945j == null && gVar.f70944i == null) {
                this.keyToKeyList.remove(gVar.f70940e).f70939c = 0;
                this.modCount++;
            } else {
                f<K, V> fVar = this.keyToKeyList.get(gVar.f70940e);
                fVar.f70939c--;
                g<K, V> gVar4 = gVar.f70945j;
                if (gVar4 == null) {
                    fVar.f70937a = gVar.f70944i;
                } else {
                    gVar4.f70944i = gVar.f70944i;
                }
                g<K, V> gVar5 = gVar.f70944i;
                if (gVar5 == null) {
                    fVar.f70938b = gVar.f70945j;
                } else {
                    gVar5.f70945j = gVar.f70945j;
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

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // c.i.d.c.q0
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

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // c.i.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.keyToKeyList.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? values().contains(obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.c
    public Map<K, Collection<V>> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new Multimaps.a(this) : (Map) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Set<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new c(this) : (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public s0<K> createKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new Multimaps.c(this) : (s0) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.head == null : invokeV.booleanValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ s0 keys() {
        return super.keys();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public boolean put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, k, v)) == null) {
            addNode(k, v, null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(q0 q0Var) {
        return super.putAll(q0Var);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // c.i.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // c.i.d.c.c
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
    @Override // c.i.d.c.c
    public List<Map.Entry<K, V>> createEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new b(this) : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.c
    public List<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new d(this) : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.c, c.i.d.c.q0
    public List<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (List) super.entries() : (List) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public List<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k)) == null) ? new a(this, k) : (List) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.q0
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

    @Override // c.i.d.c.c, c.i.d.c.q0
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
    @Override // c.i.d.c.c, c.i.d.c.q0
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

    /* loaded from: classes9.dex */
    public class e implements Iterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Set<K> f70932e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f70933f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f70934g;

        /* renamed from: h  reason: collision with root package name */
        public int f70935h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70936i;

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
            this.f70936i = linkedListMultimap;
            this.f70932e = Sets.g(this.f70936i.keySet().size());
            this.f70933f = this.f70936i.head;
            this.f70935h = this.f70936i.modCount;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f70936i.modCount != this.f70935h) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.f70933f != null;
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
                LinkedListMultimap.checkElement(this.f70933f);
                g<K, V> gVar2 = this.f70933f;
                this.f70934g = gVar2;
                this.f70932e.add(gVar2.f70940e);
                do {
                    gVar = this.f70933f.f70942g;
                    this.f70933f = gVar;
                    if (gVar == null) {
                        break;
                    }
                } while (!this.f70932e.add(gVar.f70940e));
                return this.f70934g.f70940e;
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a();
                m.e(this.f70934g != null);
                this.f70936i.removeAllNodes(this.f70934g.f70940e);
                this.f70934g = null;
                this.f70935h = this.f70936i.modCount;
            }
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this(linkedListMultimap);
        }
    }

    /* loaded from: classes9.dex */
    public class i implements ListIterator<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Object f70952e;

        /* renamed from: f  reason: collision with root package name */
        public int f70953f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f70954g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f70955h;

        /* renamed from: i  reason: collision with root package name */
        public g<K, V> f70956i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ LinkedListMultimap f70957j;

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
            this.f70957j = linkedListMultimap;
            this.f70952e = obj;
            f fVar = (f) linkedListMultimap.keyToKeyList.get(obj);
            this.f70954g = fVar == null ? null : fVar.f70937a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                this.f70956i = this.f70957j.addNode(this.f70952e, v, this.f70954g);
                this.f70953f++;
                this.f70955h = null;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70954g != null : invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70956i != null : invokeV.booleanValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                LinkedListMultimap.checkElement(this.f70954g);
                g<K, V> gVar = this.f70954g;
                this.f70955h = gVar;
                this.f70956i = gVar;
                this.f70954g = gVar.f70944i;
                this.f70953f++;
                return gVar.f70941f;
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70953f : invokeV.intValue;
        }

        @Override // java.util.ListIterator
        public V previous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                LinkedListMultimap.checkElement(this.f70956i);
                g<K, V> gVar = this.f70956i;
                this.f70955h = gVar;
                this.f70954g = gVar;
                this.f70956i = gVar.f70945j;
                this.f70953f--;
                return gVar.f70941f;
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70953f - 1 : invokeV.intValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                m.e(this.f70955h != null);
                g<K, V> gVar = this.f70955h;
                if (gVar != this.f70954g) {
                    this.f70956i = gVar.f70945j;
                    this.f70953f--;
                } else {
                    this.f70954g = gVar.f70944i;
                }
                this.f70957j.removeNode(this.f70955h);
                this.f70955h = null;
            }
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v) == null) {
                n.w(this.f70955h != null);
                this.f70955h.f70941f = v;
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
            this.f70957j = linkedListMultimap;
            f fVar = (f) linkedListMultimap.keyToKeyList.get(obj);
            int i5 = fVar == null ? 0 : fVar.f70939c;
            n.t(i2, i5);
            if (i2 >= i5 / 2) {
                this.f70956i = fVar == null ? null : fVar.f70938b;
                this.f70953f = i5;
                while (true) {
                    int i6 = i2 + 1;
                    if (i2 >= i5) {
                        break;
                    }
                    previous();
                    i2 = i6;
                }
            } else {
                this.f70954g = fVar == null ? null : fVar.f70937a;
                while (true) {
                    int i7 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i7;
                }
            }
            this.f70952e = obj;
            this.f70955h = null;
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
