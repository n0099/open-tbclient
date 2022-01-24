package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.k;
import c.i.d.c.m;
import c.i.d.c.n0;
import c.i.d.c.q0;
import c.i.d.c.s0;
import c.i.d.c.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes3.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_KEY_CAPACITY = 16;
    public static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    public static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ValueEntry<K, V> multimapHeaderEntry;
    public transient int valueSetCapacity;

    /* loaded from: classes3.dex */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements c<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ValueEntry<K, V> nextInValueBucket;
        public ValueEntry<K, V> predecessorInMultimap;
        public c<K, V> predecessorInValueSet;
        public final int smearedValueHash;
        public ValueEntry<K, V> successorInMultimap;
        public c<K, V> successorInValueSet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValueEntry(K k, V v, int i2, ValueEntry<K, V> valueEntry) {
            super(k, v);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, v, Integer.valueOf(i2), valueEntry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.smearedValueHash = i2;
            this.nextInValueBucket = valueEntry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.predecessorInMultimap : (ValueEntry) invokeV.objValue;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.predecessorInValueSet : (c) invokeV.objValue;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.successorInMultimap : (ValueEntry) invokeV.objValue;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.successorInValueSet : (c) invokeV.objValue;
        }

        public boolean matchesValue(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, obj, i2)) == null) ? this.smearedValueHash == i2 && k.a(getValue(), obj) : invokeLI.booleanValue;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, valueEntry) == null) {
                this.predecessorInMultimap = valueEntry;
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.predecessorInValueSet = cVar;
            }
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, valueEntry) == null) {
                this.successorInMultimap = valueEntry;
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                this.successorInValueSet = cVar;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Iterator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ValueEntry<K, V> f54720e;

        /* renamed from: f  reason: collision with root package name */
        public ValueEntry<K, V> f54721f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMultimap f54722g;

        public a(LinkedHashMultimap linkedHashMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedHashMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54722g = linkedHashMultimap;
            this.f54720e = this.f54722g.multimapHeaderEntry.successorInMultimap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = this.f54720e;
                    this.f54721f = valueEntry;
                    this.f54720e = valueEntry.successorInMultimap;
                    return valueEntry;
                }
                throw new NoSuchElementException();
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54720e != this.f54722g.multimapHeaderEntry : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                m.e(this.f54721f != null);
                this.f54722g.remove(this.f54721f.getKey(), this.f54721f.getValue());
                this.f54721f = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends Sets.c<V> implements c<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f54723e;

        /* renamed from: f  reason: collision with root package name */
        public ValueEntry<K, V>[] f54724f;

        /* renamed from: g  reason: collision with root package name */
        public int f54725g;

        /* renamed from: h  reason: collision with root package name */
        public int f54726h;

        /* renamed from: i  reason: collision with root package name */
        public c<K, V> f54727i;

        /* renamed from: j  reason: collision with root package name */
        public c<K, V> f54728j;
        public final /* synthetic */ LinkedHashMultimap k;

        /* loaded from: classes3.dex */
        public class a implements Iterator<V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public c<K, V> f54729e;

            /* renamed from: f  reason: collision with root package name */
            public ValueEntry<K, V> f54730f;

            /* renamed from: g  reason: collision with root package name */
            public int f54731g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ b f54732h;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54732h = bVar;
                this.f54729e = this.f54732h.f54727i;
                this.f54731g = this.f54732h.f54726h;
            }

            public final void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f54732h.f54726h != this.f54731g) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    a();
                    return this.f54729e != this.f54732h;
                }
                return invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public V next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    if (hasNext()) {
                        ValueEntry<K, V> valueEntry = (ValueEntry) this.f54729e;
                        V value = valueEntry.getValue();
                        this.f54730f = valueEntry;
                        this.f54729e = valueEntry.getSuccessorInValueSet();
                        return value;
                    }
                    throw new NoSuchElementException();
                }
                return (V) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    a();
                    m.e(this.f54730f != null);
                    this.f54732h.remove(this.f54730f.getValue());
                    this.f54731g = this.f54732h.f54726h;
                    this.f54730f = null;
                }
            }
        }

        public b(LinkedHashMultimap linkedHashMultimap, K k, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedHashMultimap, k, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = linkedHashMultimap;
            this.f54725g = 0;
            this.f54726h = 0;
            this.f54723e = k;
            this.f54727i = this;
            this.f54728j = this;
            this.f54724f = new ValueEntry[n0.a(i2, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                int d2 = n0.d(v);
                int c2 = c() & d2;
                ValueEntry<K, V> valueEntry = this.f54724f[c2];
                for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                    if (valueEntry2.matchesValue(v, d2)) {
                        return false;
                    }
                }
                ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f54723e, v, d2, valueEntry);
                LinkedHashMultimap.succeedsInValueSet(this.f54728j, valueEntry3);
                LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
                LinkedHashMultimap.succeedsInMultimap(this.k.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
                LinkedHashMultimap.succeedsInMultimap(valueEntry3, this.k.multimapHeaderEntry);
                this.f54724f[c2] = valueEntry3;
                this.f54725g++;
                this.f54726h++;
                d();
                return true;
            }
            return invokeL.booleanValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54724f.length - 1 : invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Arrays.fill(this.f54724f, (Object) null);
                this.f54725g = 0;
                for (c<K, V> cVar = this.f54727i; cVar != this; cVar = cVar.getSuccessorInValueSet()) {
                    LinkedHashMultimap.deleteFromMultimap((ValueEntry) cVar);
                }
                LinkedHashMultimap.succeedsInValueSet(this, this);
                this.f54726h++;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                int d2 = n0.d(obj);
                for (ValueEntry<K, V> valueEntry = this.f54724f[c() & d2]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                    if (valueEntry.matchesValue(obj, d2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.common.collect.LinkedHashMultimap$c<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && n0.b(this.f54725g, this.f54724f.length, 1.0d)) {
                int length = this.f54724f.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.f54724f = valueEntryArr;
                int i2 = length - 1;
                for (c cVar = (c<K, V>) this.f54727i; cVar != this; cVar = (c<K, V>) cVar.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) cVar;
                    int i3 = valueEntry.smearedValueHash & i2;
                    valueEntry.nextInValueBucket = valueEntryArr[i3];
                    valueEntryArr[i3] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54728j : (c) invokeV.objValue;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54727i : (c) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                int d2 = n0.d(obj);
                int c2 = c() & d2;
                ValueEntry<K, V> valueEntry = null;
                for (ValueEntry<K, V> valueEntry2 = this.f54724f[c2]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                    if (valueEntry2.matchesValue(obj, d2)) {
                        if (valueEntry == null) {
                            this.f54724f[c2] = valueEntry2.nextInValueBucket;
                        } else {
                            valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                        }
                        LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                        LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                        this.f54725g--;
                        this.f54726h++;
                        return true;
                    }
                    valueEntry = valueEntry2;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                this.f54728j = cVar;
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                this.f54727i = cVar;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f54725g : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface c<K, V> {
        c<K, V> getPredecessorInValueSet();

        c<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(c<K, V> cVar);

        void setSuccessorInValueSet(c<K, V> cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkedHashMultimap(int i2, int i3) {
        super(y0.e(i2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.valueSetCapacity = 2;
        m.b(i3, "expectedValuesPerKey");
        this.valueSetCapacity = i3;
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new LinkedHashMultimap<>(16, 2) : (LinkedHashMultimap) invokeV.objValue;
    }

    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, valueEntry) == null) {
            succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
        }
    }

    public static <K, V> void deleteFromValueSet(c<K, V> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, cVar) == null) {
            succeedsInValueSet(cVar.getPredecessorInValueSet(), cVar.getSuccessorInValueSet());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.Map */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.LinkedHashMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
            this.multimapHeaderEntry = valueEntry;
            succeedsInMultimap(valueEntry, valueEntry);
            this.valueSetCapacity = 2;
            int readInt = objectInputStream.readInt();
            Map e2 = y0.e(12);
            for (int i2 = 0; i2 < readInt; i2++) {
                Object readObject = objectInputStream.readObject();
                e2.put(readObject, createCollection(readObject));
            }
            int readInt2 = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt2; i3++) {
                Object readObject2 = objectInputStream.readObject();
                ((Collection) e2.get(readObject2)).add(objectInputStream.readObject());
            }
            setMap(e2);
        }
    }

    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, valueEntry, valueEntry2) == null) {
            valueEntry.setSuccessorInMultimap(valueEntry2);
            valueEntry2.setPredecessorInMultimap(valueEntry);
        }
    }

    public static <K, V> void succeedsInValueSet(c<K, V> cVar, c<K, V> cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, cVar, cVar2) == null) {
            cVar.setSuccessorInValueSet(cVar2);
            cVar2.setPredecessorInValueSet(cVar);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(keySet().size());
            for (K k : keySet()) {
                objectOutputStream.writeObject(k);
            }
            objectOutputStream.writeInt(size());
            for (Map.Entry<K, V> entry : entries()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }
    }

    @Override // com.google.common.collect.AbstractSetMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.clear();
            ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
            succeedsInMultimap(valueEntry, valueEntry);
        }
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    @Override // com.google.common.collect.AbstractSetMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.keySet() : (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ s0 keys() {
        return super.keys();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(q0 q0Var) {
        return super.putAll(q0Var);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // c.i.d.c.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
    public Iterator<V> valueIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Maps.O(entryIterator()) : (Iterator) invokeV.objValue;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? super.values() : (Collection) invokeV.objValue;
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) ? new LinkedHashMultimap<>(Maps.e(i2), Maps.e(i3)) : (LinkedHashMultimap) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? y0.f(this.valueSetCapacity) : (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public Set<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? super.entries() : (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, k, iterable)) == null) ? super.replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable) : (Set) invokeLL.objValue;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? new b(this, k, this.valueSetCapacity) : (Collection) invokeL.objValue;
    }

    public static <K, V> LinkedHashMultimap<K, V> create(q0<? extends K, ? extends V> q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, q0Var)) == null) {
            LinkedHashMultimap<K, V> create = create(q0Var.keySet().size(), 2);
            create.putAll(q0Var);
            return create;
        }
        return (LinkedHashMultimap) invokeL.objValue;
    }
}
