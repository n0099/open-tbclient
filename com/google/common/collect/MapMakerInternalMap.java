package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    public static final int CONTAINS_VALUE_RETRIES = 3;
    public static final int DRAIN_MAX = 16;
    public static final int DRAIN_THRESHOLD = 63;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int MAX_SEGMENTS = 65536;
    public static final v<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE;
    public static final long serialVersionUID = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final int concurrencyLevel;
    public final transient i<K, V, E, S> entryHelper;
    public transient Set<Map.Entry<K, V>> entrySet;
    public final Equivalence<Object> keyEquivalence;
    public transient Set<K> keySet;
    public final transient int segmentMask;
    public final transient int segmentShift;
    public final transient Segment<K, V, E, S>[] segments;
    public transient Collection<V> values;

    /* loaded from: classes3.dex */
    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i2, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i2, concurrentMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strength, strength2, equivalence, equivalence2, Integer.valueOf(i2), concurrentMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Strength) objArr2[0], (Strength) objArr2[1], (Equivalence) objArr2[2], (Equivalence) objArr2[3], ((Integer) objArr2[4]).intValue(), (ConcurrentMap) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.delegate = readMapMaker(objectInputStream).i();
                readEntries(objectInputStream);
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.delegate : invokeV.objValue;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
                objectOutputStream.defaultWriteObject();
                writeMapTo(objectOutputStream);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static abstract class Strength {
        public static final /* synthetic */ Strength[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Strength STRONG;
        public static final Strength WEAK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1079825184, "Lcom/google/common/collect/MapMakerInternalMap$Strength;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1079825184, "Lcom/google/common/collect/MapMakerInternalMap$Strength;");
                    return;
                }
            }
            STRONG = new Strength("STRONG", 0) { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
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

                @Override // com.google.common.collect.MapMakerInternalMap.Strength
                public Equivalence<Object> defaultEquivalence() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Equivalence.equals() : (Equivalence) invokeV.objValue;
                }
            };
            Strength strength = new Strength("WEAK", 1) { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
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

                @Override // com.google.common.collect.MapMakerInternalMap.Strength
                public Equivalence<Object> defaultEquivalence() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Equivalence.identity() : (Equivalence) invokeV.objValue;
                }
            };
            WEAK = strength;
            $VALUES = new Strength[]{STRONG, strength};
        }

        public Strength(String str, int i2) {
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

        public static Strength valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Strength) Enum.valueOf(Strength.class, str) : (Strength) invokeL.objValue;
        }

        public static Strength[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Strength[]) $VALUES.clone() : (Strength[]) invokeV.objValue;
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public /* synthetic */ Strength(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MapMakerInternalMap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (StrongKeyDummyValueSegment) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) ? (m) hVar : (m) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MapMakerInternalMap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (StrongKeyStrongValueSegment) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) ? (n) hVar : (n) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReferenceQueue<V> queueForValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MapMakerInternalMap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.queueForValues : (ReferenceQueue) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) ? castForTesting((h) hVar).getValueReference() : (v) invokeL.objValue;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<V>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                clearReferenceQueue((ReferenceQueue<V>) this.queueForValues);
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                drainValueReferenceQueue(this.queueForValues);
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, hVar, v)) == null) ? new w(this.queueForValues, v, castForTesting((h) hVar)) : (v) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (StrongKeyWeakValueSegment) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, hVar, vVar) == null) {
                o<K, V> castForTesting = castForTesting((h) hVar);
                v vVar2 = castForTesting.f56899h;
                castForTesting.f56899h = vVar;
                vVar2.clear();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) ? (o) hVar : (o) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReferenceQueue<K> queueForKeys;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MapMakerInternalMap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.queueForKeys : (ReferenceQueue) invokeV.objValue;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                drainKeyReferenceQueue(this.queueForKeys);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (WeakKeyDummyValueSegment) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) ? (r) hVar : (r) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReferenceQueue<K> queueForKeys;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MapMakerInternalMap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.queueForKeys : (ReferenceQueue) invokeV.objValue;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                drainKeyReferenceQueue(this.queueForKeys);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (WeakKeyStrongValueSegment) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) ? (s) hVar : (s) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReferenceQueue<K> queueForKeys;
        public final ReferenceQueue<V> queueForValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MapMakerInternalMap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.queueForKeys : (ReferenceQueue) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.queueForValues : (ReferenceQueue) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? castForTesting((h) hVar).getValueReference() : (v) invokeL.objValue;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                drainKeyReferenceQueue(this.queueForKeys);
                drainValueReferenceQueue(this.queueForValues);
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, hVar, v)) == null) ? new w(this.queueForValues, v, castForTesting((h) hVar)) : (v) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (WeakKeyWeakValueSegment) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, hVar, vVar) == null) {
                t<K, V> castForTesting = castForTesting((h) hVar);
                v vVar2 = castForTesting.f56902g;
                castForTesting.f56902g = vVar;
                vVar2.clear();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V> castForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) ? (t) hVar : (t) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements v<Object, Object, d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.ref.ReferenceQueue, com.google.common.collect.MapMakerInternalMap$h] */
        /* JADX DEBUG: Return type fixed from 'com.google.common.collect.MapMakerInternalMap$v' to match base method */
        @Override // com.google.common.collect.MapMakerInternalMap.v
        public /* bridge */ /* synthetic */ v<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            c(referenceQueue, dVar);
            return this;
        }

        public v<Object, Object, d> c(ReferenceQueue<Object> referenceQueue, d dVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, referenceQueue, dVar)) == null) ? this : (v) invokeLL.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* renamed from: d */
        public d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (d) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public Object get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f56884e;

        /* renamed from: f  reason: collision with root package name */
        public final int f56885f;

        /* renamed from: g  reason: collision with root package name */
        public final E f56886g;

        public b(K k2, int i2, E e2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2, Integer.valueOf(i2), e2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56884e = k2;
            this.f56885f = i2;
            this.f56886g = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56885f : invokeV.intValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56884e : (K) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56886g : (E) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f56887e;

        /* renamed from: f  reason: collision with root package name */
        public final E f56888f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ReferenceQueue<K> referenceQueue, K k2, int i2, E e2) {
            super(k2, referenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k2, Integer.valueOf(i2), e2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], (ReferenceQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56887e = i2;
            this.f56888f = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56887e : invokeV.intValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() : (K) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56888f : (E) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements h<Object, Object, d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            throw new AssertionError();
        }

        public d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                throw new AssertionError();
            }
            return (d) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                throw new AssertionError();
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new AssertionError();
            }
            return invokeV.objValue;
        }

        /* JADX DEBUG: Return type fixed from 'com.google.common.collect.MapMakerInternalMap$h' to match base method */
        @Override // com.google.common.collect.MapMakerInternalMap.h
        public /* bridge */ /* synthetic */ d getNext() {
            a();
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                throw new AssertionError();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapMakerInternalMap mapMakerInternalMap) {
            super(mapMakerInternalMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MapMakerInternalMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c() : (Map.Entry) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class f extends l<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f56889e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapMakerInternalMap mapMakerInternalMap) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56889e = mapMakerInternalMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56889e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Map.Entry entry;
            Object key;
            Object obj2;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = this.f56889e.get(key)) != null && this.f56889e.valueEquivalence().equivalent(entry.getValue(), obj2) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56889e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new e(this.f56889e) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Map.Entry entry;
            Object key;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.f56889e.remove(key, entry.getValue()) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56889e.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class g<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f56890e;

        /* renamed from: f  reason: collision with root package name */
        public int f56891f;

        /* renamed from: g  reason: collision with root package name */
        public Segment<K, V, E, S> f56892g;

        /* renamed from: h  reason: collision with root package name */
        public AtomicReferenceArray<E> f56893h;

        /* renamed from: i  reason: collision with root package name */
        public E f56894i;

        /* renamed from: j  reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.x f56895j;

        /* renamed from: k  reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.x f56896k;
        public final /* synthetic */ MapMakerInternalMap l;

        public g(MapMakerInternalMap mapMakerInternalMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = mapMakerInternalMap;
            this.f56890e = mapMakerInternalMap.segments.length - 1;
            this.f56891f = -1;
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f56895j = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i2 = this.f56890e;
                if (i2 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = this.l.segments;
                this.f56890e = i2 - 1;
                Segment<K, V, E, S> segment = segmentArr[i2];
                this.f56892g = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f56892g.table;
                    this.f56893h = atomicReferenceArray;
                    this.f56891f = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e2) {
            boolean z;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                try {
                    Object key = e2.getKey();
                    Object liveValue = this.l.getLiveValue(e2);
                    if (liveValue != null) {
                        this.f56895j = new x(this.l, key, liveValue);
                        z = true;
                    } else {
                        z = false;
                    }
                    return z;
                } finally {
                    this.f56892g.postReadCleanup();
                }
            }
            return invokeL.booleanValue;
        }

        public MapMakerInternalMap<K, V, E, S>.x c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                MapMakerInternalMap<K, V, E, S>.x xVar = this.f56895j;
                if (xVar != null) {
                    this.f56896k = xVar;
                    a();
                    return this.f56896k;
                }
                throw new NoSuchElementException();
            }
            return (x) invokeV.objValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
                return invokeV.booleanValue;
            }
            E e2 = this.f56894i;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.f56894i = (E) e2.getNext();
                E e3 = this.f56894i;
                if (e3 == null) {
                    return false;
                }
                if (b(e3)) {
                    return true;
                }
                e2 = this.f56894i;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
                return invokeV.booleanValue;
            }
            while (true) {
                int i2 = this.f56891f;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f56893h;
                this.f56891f = i2 - 1;
                E e2 = atomicReferenceArray.get(i2);
                this.f56894i = e2;
                if (e2 != null && (b(e2) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56895j != null : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                c.i.d.c.m.e(this.f56896k != null);
                this.l.remove(this.f56896k.getKey());
                this.f56896k = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* loaded from: classes3.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        void a(S s, E e2, V v);

        Strength b();

        E c(S s, E e2, E e3);

        Strength d();

        E e(S s, K k2, int i2, E e2);

        S f(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MapMakerInternalMap mapMakerInternalMap) {
            super(mapMakerInternalMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MapMakerInternalMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c().getKey() : (K) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class k extends l<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f56897e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(MapMakerInternalMap mapMakerInternalMap) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56897e = mapMakerInternalMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56897e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f56897e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56897e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new j(this.f56897e) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? this.f56897e.remove(obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56897e.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class l<E> extends AbstractSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? MapMakerInternalMap.toArrayList(this).toArray() : (Object[]) invokeV.objValue;
        }

        public /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tArr)) == null) ? (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m<K> extends b<K, MapMaker.Dummy, m<K>> implements Object<K, MapMaker.Dummy, m<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static final class a<K> implements i<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
            public static /* synthetic */ Interceptable $ic;
            public static final a<?> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370369301, "Lcom/google/common/collect/MapMakerInternalMap$m$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1370369301, "Lcom/google/common/collect/MapMakerInternalMap$m$a;");
                        return;
                    }
                }
                a = new a<>();
            }

            public a() {
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

            public static <K> a<K> h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a<K>) a : (a) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public m<K> c(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, m<K> mVar2) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, strongKeyDummyValueSegment, mVar, mVar2)) == null) ? mVar.a(mVar2) : (m) invokeLLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public m<K> e(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k2, int i2, m<K> mVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048583, this, strongKeyDummyValueSegment, k2, i2, mVar)) == null) ? new m<>(k2, i2, mVar) : (m) invokeLLIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public StrongKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapMakerInternalMap, i2, i3)) == null) ? new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i2, i3) : (StrongKeyDummyValueSegment) invokeLII.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, MapMaker.Dummy dummy) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048585, this, strongKeyDummyValueSegment, mVar, dummy) == null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(K k2, int i2, m<K> mVar) {
            super(k2, i2, mVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2, Integer.valueOf(i2), mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], ((Integer) objArr2[1]).intValue(), (h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public m<K> a(m<K> mVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) ? new m<>(this.f56884e, this.f56885f, mVar) : (m) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? MapMaker.Dummy.VALUE : (MapMaker.Dummy) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class n<K, V> extends b<K, V, n<K, V>> implements Object<K, V, n<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public volatile V f56898h;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public static final a<?, ?> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370339510, "Lcom/google/common/collect/MapMakerInternalMap$n$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1370339510, "Lcom/google/common/collect/MapMakerInternalMap$n$a;");
                        return;
                    }
                }
                a = new a<>();
            }

            public a() {
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

            public static <K, V> a<K, V> h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a<K, V>) a : (a) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public n<K, V> c(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, n<K, V> nVar2) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, strongKeyStrongValueSegment, nVar, nVar2)) == null) ? nVar.a(nVar2) : (n) invokeLLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public n<K, V> e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k2, int i2, n<K, V> nVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048583, this, strongKeyStrongValueSegment, k2, i2, nVar)) == null) ? new n<>(k2, i2, nVar) : (n) invokeLLIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public StrongKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapMakerInternalMap, i2, i3)) == null) ? new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i2, i3) : (StrongKeyStrongValueSegment) invokeLII.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048585, this, strongKeyStrongValueSegment, nVar, v) == null) {
                    nVar.b(v);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(K k2, int i2, n<K, V> nVar) {
            super(k2, i2, nVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2, Integer.valueOf(i2), nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], ((Integer) objArr2[1]).intValue(), (h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56898h = null;
        }

        public n<K, V> a(n<K, V> nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) {
                n<K, V> nVar2 = new n<>(this.f56884e, this.f56885f, nVar);
                nVar2.f56898h = this.f56898h;
                return nVar2;
            }
            return (n) invokeL.objValue;
        }

        public void b(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                this.f56898h = v;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56898h : (V) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o<K, V> extends b<K, V, o<K, V>> implements u<K, V, o<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public volatile v<K, V, o<K, V>> f56899h;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public static final a<?, ?> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370309719, "Lcom/google/common/collect/MapMakerInternalMap$o$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1370309719, "Lcom/google/common/collect/MapMakerInternalMap$o$a;");
                        return;
                    }
                }
                a = new a<>();
            }

            public a() {
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

            public static <K, V> a<K, V> h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a<K, V>) a : (a) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Strength.WEAK : (Strength) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public o<K, V> c(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, o<K, V> oVar2) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, strongKeyWeakValueSegment, oVar, oVar2)) == null) {
                    if (Segment.isCollected(oVar)) {
                        return null;
                    }
                    return oVar.c(strongKeyWeakValueSegment.queueForValues, oVar2);
                }
                return (o) invokeLLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public o<K, V> e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k2, int i2, o<K, V> oVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048583, this, strongKeyWeakValueSegment, k2, i2, oVar)) == null) ? new o<>(k2, i2, oVar) : (o) invokeLLIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public StrongKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapMakerInternalMap, i2, i3)) == null) ? new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i2, i3) : (StrongKeyWeakValueSegment) invokeLII.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048585, this, strongKeyWeakValueSegment, oVar, v) == null) {
                    oVar.d(v, strongKeyWeakValueSegment.queueForValues);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(K k2, int i2, o<K, V> oVar) {
            super(k2, i2, oVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2, Integer.valueOf(i2), oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], ((Integer) objArr2[1]).intValue(), (h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56899h = MapMakerInternalMap.unsetWeakValueReference();
        }

        public o<K, V> c(ReferenceQueue<V> referenceQueue, o<K, V> oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, referenceQueue, oVar)) == null) {
                o<K, V> oVar2 = new o<>(this.f56884e, this.f56885f, oVar);
                oVar2.f56899h = this.f56899h.b(referenceQueue, oVar2);
                return oVar2;
            }
            return (o) invokeLL.objValue;
        }

        public void d(V v, ReferenceQueue<V> referenceQueue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, referenceQueue) == null) {
                v<K, V, o<K, V>> vVar = this.f56899h;
                this.f56899h = new w(referenceQueue, v, this);
                vVar.clear();
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56899h.get() : (V) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, o<K, V>> getValueReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56899h : (v) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class p extends MapMakerInternalMap<K, V, E, S>.g<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(MapMakerInternalMap mapMakerInternalMap) {
            super(mapMakerInternalMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MapMakerInternalMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c().getValue() : (V) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class q extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f56900e;

        public q(MapMakerInternalMap mapMakerInternalMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56900e = mapMakerInternalMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56900e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f56900e.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56900e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new p(this.f56900e) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56900e.size() : invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MapMakerInternalMap.toArrayList(this).toArray() : (Object[]) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tArr)) == null) ? (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes3.dex */
    public static final class r<K> extends c<K, MapMaker.Dummy, r<K>> implements Object<K, MapMaker.Dummy, r<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static final class a<K> implements i<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
            public static /* synthetic */ Interceptable $ic;
            public static final a<?> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370220346, "Lcom/google/common/collect/MapMakerInternalMap$r$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1370220346, "Lcom/google/common/collect/MapMakerInternalMap$r$a;");
                        return;
                    }
                }
                a = new a<>();
            }

            public a() {
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

            public static <K> a<K> h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a<K>) a : (a) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Strength.WEAK : (Strength) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public r<K> c(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, r<K> rVar2) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, weakKeyDummyValueSegment, rVar, rVar2)) == null) {
                    if (rVar.getKey() == null) {
                        return null;
                    }
                    return rVar.a(weakKeyDummyValueSegment.queueForKeys, rVar2);
                }
                return (r) invokeLLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public r<K> e(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k2, int i2, r<K> rVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048583, this, weakKeyDummyValueSegment, k2, i2, rVar)) == null) ? new r<>(weakKeyDummyValueSegment.queueForKeys, k2, i2, rVar) : (r) invokeLLIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public WeakKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapMakerInternalMap, i2, i3)) == null) ? new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i2, i3) : (WeakKeyDummyValueSegment) invokeLII.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, MapMaker.Dummy dummy) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048585, this, weakKeyDummyValueSegment, rVar, dummy) == null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ReferenceQueue<K> referenceQueue, K k2, int i2, r<K> rVar) {
            super(referenceQueue, k2, i2, rVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k2, Integer.valueOf(i2), rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], ((Integer) objArr2[2]).intValue(), (h) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public r<K> a(ReferenceQueue<K> referenceQueue, r<K> rVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, referenceQueue, rVar)) == null) ? new r<>(referenceQueue, getKey(), this.f56887e, rVar) : (r) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? MapMaker.Dummy.VALUE : (MapMaker.Dummy) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class s<K, V> extends c<K, V, s<K, V>> implements Object<K, V, s<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public volatile V f56901g;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public static final a<?, ?> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370190555, "Lcom/google/common/collect/MapMakerInternalMap$s$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1370190555, "Lcom/google/common/collect/MapMakerInternalMap$s$a;");
                        return;
                    }
                }
                a = new a<>();
            }

            public a() {
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

            public static <K, V> a<K, V> h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a<K, V>) a : (a) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Strength.WEAK : (Strength) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Strength.STRONG : (Strength) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public s<K, V> c(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, s<K, V> sVar2) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, weakKeyStrongValueSegment, sVar, sVar2)) == null) {
                    if (sVar.getKey() == null) {
                        return null;
                    }
                    return sVar.a(weakKeyStrongValueSegment.queueForKeys, sVar2);
                }
                return (s) invokeLLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public s<K, V> e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k2, int i2, s<K, V> sVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048583, this, weakKeyStrongValueSegment, k2, i2, sVar)) == null) ? new s<>(weakKeyStrongValueSegment.queueForKeys, k2, i2, sVar) : (s) invokeLLIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public WeakKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapMakerInternalMap, i2, i3)) == null) ? new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i2, i3) : (WeakKeyStrongValueSegment) invokeLII.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048585, this, weakKeyStrongValueSegment, sVar, v) == null) {
                    sVar.b(v);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(ReferenceQueue<K> referenceQueue, K k2, int i2, s<K, V> sVar) {
            super(referenceQueue, k2, i2, sVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k2, Integer.valueOf(i2), sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], ((Integer) objArr2[2]).intValue(), (h) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56901g = null;
        }

        public s<K, V> a(ReferenceQueue<K> referenceQueue, s<K, V> sVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, referenceQueue, sVar)) == null) {
                s<K, V> sVar2 = new s<>(referenceQueue, getKey(), this.f56887e, sVar);
                sVar2.b(this.f56901g);
                return sVar2;
            }
            return (s) invokeLL.objValue;
        }

        public void b(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                this.f56901g = v;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56901g : (V) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class t<K, V> extends c<K, V, t<K, V>> implements u<K, V, t<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public volatile v<K, V, t<K, V>> f56902g;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public static final a<?, ?> a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370160764, "Lcom/google/common/collect/MapMakerInternalMap$t$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1370160764, "Lcom/google/common/collect/MapMakerInternalMap$t$a;");
                        return;
                    }
                }
                a = new a<>();
            }

            public a() {
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

            public static <K, V> a<K, V> h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (a<K, V>) a : (a) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Strength.WEAK : (Strength) invokeV.objValue;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Strength.WEAK : (Strength) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public t<K, V> c(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, t<K, V> tVar2) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, weakKeyWeakValueSegment, tVar, tVar2)) == null) {
                    if (tVar.getKey() == null || Segment.isCollected(tVar)) {
                        return null;
                    }
                    return tVar.c(weakKeyWeakValueSegment.queueForKeys, weakKeyWeakValueSegment.queueForValues, tVar2);
                }
                return (t) invokeLLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public t<K, V> e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k2, int i2, t<K, V> tVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048583, this, weakKeyWeakValueSegment, k2, i2, tVar)) == null) ? new t<>(weakKeyWeakValueSegment.queueForKeys, k2, i2, tVar) : (t) invokeLLIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public WeakKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapMakerInternalMap, i2, i3)) == null) ? new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i2, i3) : (WeakKeyWeakValueSegment) invokeLII.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048585, this, weakKeyWeakValueSegment, tVar, v) == null) {
                    tVar.d(v, weakKeyWeakValueSegment.queueForValues);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(ReferenceQueue<K> referenceQueue, K k2, int i2, t<K, V> tVar) {
            super(referenceQueue, k2, i2, tVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k2, Integer.valueOf(i2), tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], ((Integer) objArr2[2]).intValue(), (h) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56902g = MapMakerInternalMap.unsetWeakValueReference();
        }

        public t<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, t<K, V> tVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, referenceQueue, referenceQueue2, tVar)) == null) {
                t<K, V> tVar2 = new t<>(referenceQueue, getKey(), this.f56887e, tVar);
                tVar2.f56902g = this.f56902g.b(referenceQueue2, tVar2);
                return tVar2;
            }
            return (t) invokeLLL.objValue;
        }

        public void d(V v, ReferenceQueue<V> referenceQueue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, referenceQueue) == null) {
                v<K, V, t<K, V>> vVar = this.f56902g;
                this.f56902g = new w(referenceQueue, v, this);
                vVar.clear();
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56902g.get() : (V) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, t<K, V>> getValueReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56902g : (v) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface u<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        v<K, V, E> getValueReference();
    }

    /* loaded from: classes3.dex */
    public interface v<K, V, E extends h<K, V, E>> {
        E a();

        v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        V get();
    }

    /* loaded from: classes3.dex */
    public static final class w<K, V, E extends h<K, V, E>> extends WeakReference<V> implements v<K, V, E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final E f56903e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(ReferenceQueue<V> referenceQueue, V v, E e2) {
            super(v, referenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, v, e2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], (ReferenceQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56903e = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public E a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56903e : (E) invokeV.objValue;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, referenceQueue, e2)) == null) ? new w(referenceQueue, get(), e2) : (v) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class x extends c.i.d.c.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f56904e;

        /* renamed from: f  reason: collision with root package name */
        public V f56905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ MapMakerInternalMap f56906g;

        public x(MapMakerInternalMap mapMakerInternalMap, K k2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, k2, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56906g = mapMakerInternalMap;
            this.f56904e = k2;
            this.f56905f = v;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return this.f56904e.equals(entry.getKey()) && this.f56905f.equals(entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56904e : (K) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56905f : (V) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56904e.hashCode() ^ this.f56905f.hashCode() : invokeV.intValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v)) == null) {
                V v2 = (V) this.f56906g.put(this.f56904e, v);
                this.f56905f = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1751347313, "Lcom/google/common/collect/MapMakerInternalMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1751347313, "Lcom/google/common/collect/MapMakerInternalMap;");
                return;
            }
        }
        UNSET_WEAK_VALUE_REFERENCE = new a();
    }

    public MapMakerInternalMap(MapMaker mapMaker, i<K, V, E, S> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapMaker, iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = iVar;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.concurrencyLevel) {
            i7++;
            i6 <<= 1;
        }
        this.segmentShift = 32 - i7;
        this.segmentMask = i6 - 1;
        this.segments = newSegmentArray(i6);
        int i8 = min / i6;
        while (i5 < (i6 * i8 < min ? i8 + 1 : i8)) {
            i5 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i4 >= segmentArr.length) {
                return;
            }
            segmentArr[i4] = createSegment(i5, -1);
            i4++;
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> create(MapMaker mapMaker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mapMaker)) == null) {
            if (mapMaker.e() == Strength.STRONG && mapMaker.f() == Strength.STRONG) {
                return new MapMakerInternalMap<>(mapMaker, n.a.h());
            }
            if (mapMaker.e() == Strength.STRONG && mapMaker.f() == Strength.WEAK) {
                return new MapMakerInternalMap<>(mapMaker, o.a.h());
            }
            if (mapMaker.e() == Strength.WEAK && mapMaker.f() == Strength.STRONG) {
                return new MapMakerInternalMap<>(mapMaker, s.a.h());
            }
            if (mapMaker.e() == Strength.WEAK && mapMaker.f() == Strength.WEAK) {
                return new MapMakerInternalMap<>(mapMaker, t.a.h());
            }
            throw new AssertionError();
        }
        return (MapMakerInternalMap) invokeL.objValue;
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mapMaker)) == null) {
            if (mapMaker.e() == Strength.STRONG && mapMaker.f() == Strength.STRONG) {
                return new MapMakerInternalMap<>(mapMaker, m.a.h());
            }
            if (mapMaker.e() == Strength.WEAK && mapMaker.f() == Strength.STRONG) {
                return new MapMakerInternalMap<>(mapMaker, r.a.h());
            }
            if (mapMaker.f() == Strength.WEAK) {
                throw new IllegalArgumentException("Map cannot have both weak and dummy values");
            }
            throw new AssertionError();
        }
        return (MapMakerInternalMap) invokeL.objValue;
    }

    public static int rehash(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            int i3 = i2 + ((i2 << 15) ^ (-12931));
            int i4 = i3 ^ (i3 >>> 10);
            int i5 = i4 + (i4 << 3);
            int i6 = i5 ^ (i5 >>> 6);
            int i7 = i6 + (i6 << 2) + (i6 << 14);
            return i7 ^ (i7 >>> 16);
        }
        return invokeI.intValue;
    }

    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, collection)) == null) {
            ArrayList<E> arrayList = new ArrayList<>(collection.size());
            Iterators.a(arrayList, collection.iterator());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static <K, V, E extends h<K, V, E>> v<K, V, E> unsetWeakValueReference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (v<K, V, E>) UNSET_WEAK_VALUE_REFERENCE : (v) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Segment<K, V, E, S> segment : this.segments) {
                segment.clear();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            int hash = hash(obj);
            return segmentFor(hash).containsKey(obj, hash);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.collect.MapMakerInternalMap$WeakKeyWeakValueSegment */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>>[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            Segment<K, V, E, S>[] segmentArr = this.segments;
            long j2 = -1;
            int i2 = 0;
            while (i2 < 3) {
                long j3 = 0;
                for (WeakKeyWeakValueSegment weakKeyWeakValueSegment : segmentArr) {
                    int i3 = weakKeyWeakValueSegment.count;
                    AtomicReferenceArray<E> atomicReferenceArray = weakKeyWeakValueSegment.table;
                    for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                        for (E e2 = atomicReferenceArray.get(i4); e2 != null; e2 = e2.getNext()) {
                            Object liveValue = weakKeyWeakValueSegment.getLiveValue(e2);
                            if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                                return true;
                            }
                        }
                    }
                    j3 += weakKeyWeakValueSegment.modCount;
                }
                if (j3 == j2) {
                    return false;
                }
                i2++;
                j2 = j3;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public E copyEntry(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, e2, e3)) == null) ? segmentFor(e2.getHash()).copyEntry(e2, e3) : (E) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>, com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
    public Segment<K, V, E, S> createSegment(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) ? (S) this.entryHelper.f(this, i2, i3) : (Segment) invokeII.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            f fVar = new f(this);
            this.entrySet = fVar;
            return fVar;
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            int hash = hash(obj);
            return segmentFor(hash).get(obj, hash);
        }
        return (V) invokeL.objValue;
    }

    public E getEntry(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            int hash = hash(obj);
            return segmentFor(hash).getEntry(obj, hash);
        }
        return (E) invokeL.objValue;
    }

    public V getLiveValue(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2)) == null) {
            if (e2.getKey() == null) {
                return null;
            }
            return (V) e2.getValue();
        }
        return (V) invokeL.objValue;
    }

    public int hash(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? rehash(this.keyEquivalence.hash(obj)) : invokeL.intValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            long j2 = 0;
            for (int i2 = 0; i2 < segmentArr.length; i2++) {
                if (segmentArr[i2].count != 0) {
                    return false;
                }
                j2 += segmentArr[i2].modCount;
            }
            if (j2 != 0) {
                for (int i3 = 0; i3 < segmentArr.length; i3++) {
                    if (segmentArr[i3].count != 0) {
                        return false;
                    }
                    j2 -= segmentArr[i3].modCount;
                }
                return j2 == 0;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isLiveForTesting(h<K, V, ?> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hVar)) == null) ? segmentFor(hVar.getHash()).getLiveValueForTesting(hVar) != null : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            k kVar = new k(this);
            this.keySet = kVar;
            return kVar;
        }
        return (Set) invokeV.objValue;
    }

    public Strength keyStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.entryHelper.b() : (Strength) invokeV.objValue;
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? new Segment[i2] : (Segment[]) invokeI.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k2, v2)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v2);
            int hash = hash(k2);
            return segmentFor(hash).put(k2, hash, v2, false);
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, k2, v2)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v2);
            int hash = hash(k2);
            return segmentFor(hash).put(k2, hash, v2, true);
        }
        return (V) invokeLL.objValue;
    }

    public void reclaimKey(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, e2) == null) {
            int hash = e2.getHash();
            segmentFor(hash).reclaimKey(e2, hash);
        }
    }

    public void reclaimValue(v<K, V, E> vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vVar) == null) {
            E a2 = vVar.a();
            int hash = a2.getHash();
            segmentFor(hash).reclaimValue((K) a2.getKey(), hash, vVar);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            int hash = hash(obj);
            return segmentFor(hash).remove(obj, hash);
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, V v2, V v3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, k2, v2, v3)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v3);
            if (v2 == null) {
                return false;
            }
            int hash = hash(k2);
            return segmentFor(hash).replace(k2, hash, v2, v3);
        }
        return invokeLLL.booleanValue;
    }

    public Segment<K, V, E, S> segmentFor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? this.segments[(i2 >>> this.segmentShift) & this.segmentMask] : (Segment) invokeI.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            long j2 = 0;
            for (Segment<K, V, E, S> segment : this.segments) {
                j2 += segment.count;
            }
            return Ints.j(j2);
        }
        return invokeV.intValue;
    }

    public Equivalence<Object> valueEquivalence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.entryHelper.d().defaultEquivalence() : (Equivalence) invokeV.objValue;
    }

    public Strength valueStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.entryHelper.d() : (Strength) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            q qVar = new q(this);
            this.values = qVar;
            return qVar;
        }
        return (Collection) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new SerializationProxy(this.entryHelper.b(), this.entryHelper.d(), this.keyEquivalence, this.entryHelper.d().defaultEquivalence(), this.concurrencyLevel, this) : invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends z<K, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3;
        public transient /* synthetic */ FieldHolder $fh;
        public final int concurrencyLevel;
        public transient ConcurrentMap<K, V> delegate;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i2, ConcurrentMap<K, V> concurrentMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strength, strength2, equivalence, equivalence2, Integer.valueOf(i2), concurrentMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i2;
            this.delegate = concurrentMap;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.concurrent.ConcurrentMap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, objectInputStream) != null) {
                return;
            }
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objectInputStream)) == null) {
                int readInt = objectInputStream.readInt();
                MapMaker mapMaker = new MapMaker();
                mapMaker.g(readInt);
                mapMaker.j(this.keyStrength);
                mapMaker.k(this.valueStrength);
                mapMaker.h(this.keyEquivalence);
                mapMaker.a(this.concurrencyLevel);
                return mapMaker;
            }
            return (MapMaker) invokeL.objValue;
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, objectOutputStream) == null) {
                objectOutputStream.writeInt(this.delegate.size());
                for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                    objectOutputStream.writeObject(entry.getKey());
                    objectOutputStream.writeObject(entry.getValue());
                }
                objectOutputStream.writeObject(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.z, c.i.d.c.d0, c.i.d.c.h0
        public ConcurrentMap<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delegate : (ConcurrentMap) invokeV.objValue;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, obj, obj2)) == null) {
            if (obj == null || obj2 == null) {
                return false;
            }
            int hash = hash(obj);
            return segmentFor(hash).remove(obj, hash, obj2);
        }
        return invokeLL.booleanValue;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, k2, v2)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v2);
            int hash = hash(k2);
            return segmentFor(hash).replace(k2, hash, v2);
        }
        return (V) invokeLL.objValue;
    }

    /* loaded from: classes3.dex */
    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int count;
        public final MapMakerInternalMap<K, V, E, S> map;
        public final int maxSegmentSize;
        public int modCount;
        public final AtomicInteger readCount;
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapMakerInternalMap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.readCount = new AtomicInteger();
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i3;
            initTable(newEntryArray(i2));
        }

        public static <K, V, E extends h<K, V, E>> boolean isCollected(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e2)) == null) ? e2.getValue() == null : invokeL.booleanValue;
        }

        public abstract E castForTesting(h<K, V, ?> hVar);

        public void clear() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.count == 0) {
                return;
            }
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                    atomicReferenceArray.set(i2, null);
                }
                maybeClearReferenceQueues();
                this.readCount.set(0);
                this.modCount++;
                this.count = 0;
            } finally {
                unlock();
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, referenceQueue) == null) {
                do {
                } while (referenceQueue.poll() != null);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean clearValueForTesting(K k2, int i2, v<K, V, ? extends h<K, V, ?>> vVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, k2, i2, vVar)) == null) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    E e2 = atomicReferenceArray.get(length);
                    for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                        Object key = hVar.getKey();
                        if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k2, key)) {
                            if (((u) hVar).getValueReference() == vVar) {
                                atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                                return true;
                            }
                            return false;
                        }
                    }
                    return false;
                } finally {
                    unlock();
                }
            }
            return invokeLIL.booleanValue;
        }

        public boolean containsKey(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, obj, i2)) == null) {
                try {
                    boolean z = false;
                    if (this.count != 0) {
                        E liveEntry = getLiveEntry(obj, i2);
                        if (liveEntry != null) {
                            if (liveEntry.getValue() != null) {
                                z = true;
                            }
                        }
                        return z;
                    }
                    return false;
                } finally {
                    postReadCleanup();
                }
            }
            return invokeLI.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                try {
                    if (this.count != 0) {
                        AtomicReferenceArray<E> atomicReferenceArray = this.table;
                        int length = atomicReferenceArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            for (E e2 = atomicReferenceArray.get(i2); e2 != null; e2 = e2.getNext()) {
                                Object liveValue = getLiveValue(e2);
                                if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                    postReadCleanup();
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                } finally {
                    postReadCleanup();
                }
            }
            return invokeL.booleanValue;
        }

        public E copyEntry(E e2, E e3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, e2, e3)) == null) ? this.map.entryHelper.c(self(), e2, e3) : (E) invokeLL.objValue;
        }

        public E copyForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, hVar, hVar2)) == null) ? this.map.entryHelper.c(self(), castForTesting(hVar), castForTesting(hVar2)) : (E) invokeLL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, referenceQueue) == null) {
                int i2 = 0;
                do {
                    Reference<? extends K> poll = referenceQueue.poll();
                    if (poll == null) {
                        return;
                    }
                    this.map.reclaimKey((h) poll);
                    i2++;
                } while (i2 != 16);
            }
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, referenceQueue) == null) {
                int i2 = 0;
                do {
                    Reference<? extends V> poll = referenceQueue.poll();
                    if (poll == null) {
                        return;
                    }
                    this.map.reclaimValue((v) poll);
                    i2++;
                } while (i2 != 16);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray;
            int length;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (length = (atomicReferenceArray = this.table).length()) >= 1073741824) {
                return;
            }
            int i2 = this.count;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i3 = 0; i3 < length; i3++) {
                E e2 = atomicReferenceArray.get(i3);
                if (e2 != null) {
                    h next = e2.getNext();
                    int hash = e2.getHash() & length2;
                    if (next == null) {
                        atomicReferenceArray2.set(hash, e2);
                    } else {
                        h hVar = e2;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        atomicReferenceArray2.set(hash, hVar);
                        while (e2 != hVar) {
                            int hash3 = e2.getHash() & length2;
                            h copyEntry = copyEntry(e2, (h) atomicReferenceArray2.get(hash3));
                            if (copyEntry != null) {
                                atomicReferenceArray2.set(hash3, copyEntry);
                            } else {
                                i2--;
                            }
                            e2 = e2.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArray2;
            this.count = i2;
        }

        public V get(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, obj, i2)) == null) {
                try {
                    E liveEntry = getLiveEntry(obj, i2);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = (V) liveEntry.getValue();
                    if (v == null) {
                        tryDrainReferenceQueues();
                    }
                    return v;
                } finally {
                    postReadCleanup();
                }
            }
            return (V) invokeLI.objValue;
        }

        public E getEntry(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, obj, i2)) == null) {
                if (this.count != 0) {
                    for (E first = getFirst(i2); first != null; first = (E) first.getNext()) {
                        if (first.getHash() == i2) {
                            Object key = first.getKey();
                            if (key == null) {
                                tryDrainReferenceQueues();
                            } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                                return first;
                            }
                        }
                    }
                    return null;
                }
                return null;
            }
            return (E) invokeLI.objValue;
        }

        public E getFirst(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                return atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
            }
            return (E) invokeI.objValue;
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                throw new AssertionError();
            }
            return (ReferenceQueue) invokeV.objValue;
        }

        public E getLiveEntry(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, obj, i2)) == null) ? getEntry(obj, i2) : (E) invokeLI.objValue;
        }

        public V getLiveValue(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, e2)) == null) {
                if (e2.getKey() == null) {
                    tryDrainReferenceQueues();
                    return null;
                }
                V v = (V) e2.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                    return null;
                }
                return v;
            }
            return (V) invokeL.objValue;
        }

        public V getLiveValueForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, hVar)) == null) ? getLiveValue(castForTesting(hVar)) : (V) invokeL.objValue;
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                throw new AssertionError();
            }
            return (ReferenceQueue) invokeV.objValue;
        }

        public v<K, V, E> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, hVar)) == null) {
                throw new AssertionError();
            }
            return (v) invokeL.objValue;
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, atomicReferenceArray) == null) {
                int length = (atomicReferenceArray.length() * 3) / 4;
                this.threshold = length;
                if (length == this.maxSegmentSize) {
                    this.threshold = length + 1;
                }
                this.table = atomicReferenceArray;
            }
        }

        public void maybeClearReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            }
        }

        public void maybeDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            }
        }

        public AtomicReferenceArray<E> newEntryArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? new AtomicReferenceArray<>(i2) : (AtomicReferenceArray) invokeI.objValue;
        }

        public E newEntryForTesting(K k2, int i2, h<K, V, ?> hVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048600, this, k2, i2, hVar)) == null) ? this.map.entryHelper.e(self(), k2, i2, castForTesting(hVar)) : (E) invokeLIL.objValue;
        }

        public v<K, V, E> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, hVar, v)) == null) {
                throw new AssertionError();
            }
            return (v) invokeLL.objValue;
        }

        public void postReadCleanup() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        public void preWriteCleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
                runLockedCleanup();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k2, int i2, V v, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{k2, Integer.valueOf(i2), v, Boolean.valueOf(z)})) == null) {
                lock();
                try {
                    preWriteCleanup();
                    int i3 = this.count + 1;
                    if (i3 > this.threshold) {
                        expand();
                        i3 = this.count + 1;
                    }
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    E e2 = atomicReferenceArray.get(length);
                    for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                        Object key = hVar.getKey();
                        if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k2, key)) {
                            V v2 = (V) hVar.getValue();
                            if (v2 == null) {
                                this.modCount++;
                                setValue(hVar, v);
                                this.count = this.count;
                                return null;
                            } else if (z) {
                                return v2;
                            } else {
                                this.modCount++;
                                setValue(hVar, v);
                                return v2;
                            }
                        }
                    }
                    this.modCount++;
                    E e3 = this.map.entryHelper.e(self(), k2, i2, e2);
                    setValue(e3, v);
                    atomicReferenceArray.set(length, e3);
                    this.count = i3;
                    return null;
                } finally {
                    unlock();
                }
            }
            return (V) invokeCommon.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimKey(E e2, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, e2, i2)) == null) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = i2 & (atomicReferenceArray.length() - 1);
                    E e3 = atomicReferenceArray.get(length);
                    for (h hVar = e3; hVar != null; hVar = hVar.getNext()) {
                        if (hVar == e2) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e3, hVar));
                            this.count--;
                            return true;
                        }
                    }
                    return false;
                } finally {
                    unlock();
                }
            }
            return invokeLI.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimValue(K k2, int i2, v<K, V, E> vVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048606, this, k2, i2, vVar)) == null) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    E e2 = atomicReferenceArray.get(length);
                    for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                        Object key = hVar.getKey();
                        if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k2, key)) {
                            if (((u) hVar).getValueReference() == vVar) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                                this.count--;
                                return true;
                            }
                            return false;
                        }
                    }
                    return false;
                } finally {
                    unlock();
                }
            }
            return invokeLIL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V remove(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, obj, i2)) == null) {
                lock();
                try {
                    preWriteCleanup();
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    E e2 = atomicReferenceArray.get(length);
                    for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                        Object key = hVar.getKey();
                        if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                            V v = (V) hVar.getValue();
                            if (v == null && !isCollected(hVar)) {
                                return null;
                            }
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                            this.count--;
                            return v;
                        }
                    }
                    return null;
                } finally {
                    unlock();
                }
            }
            return (V) invokeLI.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean removeEntryForTesting(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, e2)) == null) {
                int hash = e2.getHash();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                E e3 = atomicReferenceArray.get(length);
                for (h hVar = e3; hVar != null; hVar = hVar.getNext()) {
                    if (hVar == e2) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e3, hVar));
                        this.count--;
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public E removeFromChain(E e2, E e3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, e2, e3)) == null) {
                int i2 = this.count;
                E e4 = (E) e3.getNext();
                while (e2 != e3) {
                    E copyEntry = copyEntry(e2, e4);
                    if (copyEntry != null) {
                        e4 = copyEntry;
                    } else {
                        i2--;
                    }
                    e2 = (E) e2.getNext();
                }
                this.count = i2;
                return e4;
            }
            return (E) invokeLL.objValue;
        }

        public E removeFromChainForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, hVar, hVar2)) == null) ? removeFromChain(castForTesting(hVar), castForTesting(hVar2)) : (E) invokeLL.objValue;
        }

        public boolean removeTableEntryForTesting(h<K, V, ?> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, hVar)) == null) ? removeEntryForTesting(castForTesting(hVar)) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k2, int i2, V v, V v2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048614, this, k2, i2, v, v2)) == null) {
                lock();
                try {
                    preWriteCleanup();
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    E e2 = atomicReferenceArray.get(length);
                    for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                        Object key = hVar.getKey();
                        if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k2, key)) {
                            Object value = hVar.getValue();
                            if (value == null) {
                                if (isCollected(hVar)) {
                                    this.modCount++;
                                    atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                                    this.count--;
                                }
                                return false;
                            } else if (this.map.valueEquivalence().equivalent(v, value)) {
                                this.modCount++;
                                setValue(hVar, v2);
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                    return false;
                } finally {
                    unlock();
                }
            }
            return invokeLILL.booleanValue;
        }

        public void runCleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
                runLockedCleanup();
            }
        }

        public void runLockedCleanup() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i2, h<K, V, ?> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048618, this, i2, hVar) == null) {
                this.table.set(i2, castForTesting(hVar));
            }
        }

        public void setValue(E e2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048619, this, e2, v) == null) {
                this.map.entryHelper.a(self(), e2, v);
            }
        }

        public void setValueForTesting(h<K, V, ?> hVar, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048620, this, hVar, v) == null) {
                this.map.entryHelper.a(self(), castForTesting(hVar), v);
            }
        }

        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048621, this, hVar, vVar) == null) {
                throw new AssertionError();
            }
        }

        public void tryDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (isCollected(r4) == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
            r8.modCount++;
            r0.set(r1, removeFromChain(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(Object obj, int i2, Object obj2) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLIL = interceptable.invokeLIL(1048608, this, obj, i2, obj2)) != null) {
                return invokeLIL.booleanValue;
            }
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                h hVar = e2;
                while (true) {
                    boolean z = false;
                    if (hVar == null) {
                        return false;
                    }
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        break;
                    }
                    hVar = hVar.getNext();
                }
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k2, int i2, V v) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048613, this, k2, i2, v)) == null) {
                lock();
                try {
                    preWriteCleanup();
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    E e2 = atomicReferenceArray.get(length);
                    for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                        Object key = hVar.getKey();
                        if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k2, key)) {
                            V v2 = (V) hVar.getValue();
                            if (v2 == null) {
                                if (isCollected(hVar)) {
                                    this.modCount++;
                                    atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                                    this.count--;
                                }
                                return null;
                            }
                            this.modCount++;
                            setValue(hVar, v);
                            return v2;
                        }
                    }
                    return null;
                } finally {
                    unlock();
                }
            }
            return (V) invokeLIL.objValue;
        }
    }
}
