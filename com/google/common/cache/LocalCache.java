package com.google.common.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes9.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger A;
    public static final s<Object, Object> B;
    public static final Queue<?> C;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f70653e;

    /* renamed from: f  reason: collision with root package name */
    public final int f70654f;

    /* renamed from: g  reason: collision with root package name */
    public final Segment<K, V>[] f70655g;

    /* renamed from: h  reason: collision with root package name */
    public final int f70656h;

    /* renamed from: i  reason: collision with root package name */
    public final Equivalence<Object> f70657i;

    /* renamed from: j  reason: collision with root package name */
    public final Equivalence<Object> f70658j;
    public final Strength k;
    public final Strength l;
    public final long m;
    public final c.i.d.b.j<K, V> n;
    public final long o;
    public final long p;
    public final long q;
    public final Queue<RemovalNotification<K, V>> r;
    public final c.i.d.b.i<K, V> s;
    public final c.i.d.a.t t;
    public final EntryFactory u;
    public final c.i.d.b.b v;
    public final CacheLoader<? super K, V> w;
    public Set<K> x;
    public Collection<V> y;
    public Set<Map.Entry<K, V>> z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static abstract class EntryFactory {
        public static final /* synthetic */ EntryFactory[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ACCESS_MASK = 1;
        public static final EntryFactory STRONG;
        public static final EntryFactory STRONG_ACCESS;
        public static final EntryFactory STRONG_ACCESS_WRITE;
        public static final EntryFactory STRONG_WRITE;
        public static final EntryFactory WEAK;
        public static final EntryFactory WEAK_ACCESS;
        public static final EntryFactory WEAK_ACCESS_WRITE;
        public static final int WEAK_MASK = 4;
        public static final EntryFactory WEAK_WRITE;
        public static final int WRITE_MASK = 2;
        public static final EntryFactory[] factories;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(105659723, "Lcom/google/common/cache/LocalCache$EntryFactory;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(105659723, "Lcom/google/common/cache/LocalCache$EntryFactory;");
                    return;
                }
            }
            STRONG = new EntryFactory("STRONG", 0) { // from class: com.google.common.cache.LocalCache.EntryFactory.1
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(1048576, this, segment, k, i2, hVar)) == null) ? new o(k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            STRONG_ACCESS = new EntryFactory("STRONG_ACCESS", 1) { // from class: com.google.common.cache.LocalCache.EntryFactory.2
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, segment, hVar, hVar2)) == null) {
                        c.i.d.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                        copyAccessEntry(hVar, copyEntry);
                        return copyEntry;
                    }
                    return (c.i.d.b.h) invokeLLL.objValue;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, k, i2, hVar)) == null) ? new m(k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            STRONG_WRITE = new EntryFactory("STRONG_WRITE", 2) { // from class: com.google.common.cache.LocalCache.EntryFactory.3
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, segment, hVar, hVar2)) == null) {
                        c.i.d.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                        copyWriteEntry(hVar, copyEntry);
                        return copyEntry;
                    }
                    return (c.i.d.b.h) invokeLLL.objValue;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, k, i2, hVar)) == null) ? new q(k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            STRONG_ACCESS_WRITE = new EntryFactory("STRONG_ACCESS_WRITE", 3) { // from class: com.google.common.cache.LocalCache.EntryFactory.4
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, segment, hVar, hVar2)) == null) {
                        c.i.d.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                        copyAccessEntry(hVar, copyEntry);
                        copyWriteEntry(hVar, copyEntry);
                        return copyEntry;
                    }
                    return (c.i.d.b.h) invokeLLL.objValue;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, k, i2, hVar)) == null) ? new n(k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            WEAK = new EntryFactory("WEAK", 4) { // from class: com.google.common.cache.LocalCache.EntryFactory.5
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(1048576, this, segment, k, i2, hVar)) == null) ? new w(segment.keyReferenceQueue, k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            WEAK_ACCESS = new EntryFactory("WEAK_ACCESS", 5) { // from class: com.google.common.cache.LocalCache.EntryFactory.6
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, segment, hVar, hVar2)) == null) {
                        c.i.d.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                        copyAccessEntry(hVar, copyEntry);
                        return copyEntry;
                    }
                    return (c.i.d.b.h) invokeLLL.objValue;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, k, i2, hVar)) == null) ? new u(segment.keyReferenceQueue, k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            WEAK_WRITE = new EntryFactory("WEAK_WRITE", 6) { // from class: com.google.common.cache.LocalCache.EntryFactory.7
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, segment, hVar, hVar2)) == null) {
                        c.i.d.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                        copyWriteEntry(hVar, copyEntry);
                        return copyEntry;
                    }
                    return (c.i.d.b.h) invokeLLL.objValue;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, k, i2, hVar)) == null) ? new y(segment.keyReferenceQueue, k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            EntryFactory entryFactory = new EntryFactory("WEAK_ACCESS_WRITE", 7) { // from class: com.google.common.cache.LocalCache.EntryFactory.8
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

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, segment, hVar, hVar2)) == null) {
                        c.i.d.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                        copyAccessEntry(hVar, copyEntry);
                        copyWriteEntry(hVar, copyEntry);
                        return copyEntry;
                    }
                    return (c.i.d.b.h) invokeLLL.objValue;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar) {
                    InterceptResult invokeLLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, k, i2, hVar)) == null) ? new v(segment.keyReferenceQueue, k, i2, hVar) : (c.i.d.b.h) invokeLLIL.objValue;
                }
            };
            WEAK_ACCESS_WRITE = entryFactory;
            EntryFactory entryFactory2 = STRONG;
            EntryFactory entryFactory3 = STRONG_ACCESS;
            EntryFactory entryFactory4 = STRONG_WRITE;
            EntryFactory entryFactory5 = STRONG_ACCESS_WRITE;
            EntryFactory entryFactory6 = WEAK;
            EntryFactory entryFactory7 = WEAK_ACCESS;
            EntryFactory entryFactory8 = WEAK_WRITE;
            $VALUES = new EntryFactory[]{entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8, entryFactory};
            factories = new EntryFactory[]{entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8, entryFactory};
        }

        public EntryFactory(String str, int i2) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{strength, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return factories[(strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
            }
            return (EntryFactory) invokeCommon.objValue;
        }

        public static EntryFactory valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (EntryFactory) Enum.valueOf(EntryFactory.class, str) : (EntryFactory) invokeL.objValue;
        }

        public static EntryFactory[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (EntryFactory[]) $VALUES.clone() : (EntryFactory[]) invokeV.objValue;
        }

        public <K, V> void copyAccessEntry(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, hVar, hVar2) == null) {
                hVar2.setAccessTime(hVar.getAccessTime());
                LocalCache.c(hVar.getPreviousInAccessQueue(), hVar2);
                LocalCache.c(hVar2, hVar.getNextInAccessQueue());
                LocalCache.x(hVar);
            }
        }

        public <K, V> c.i.d.b.h<K, V> copyEntry(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, hVar, hVar2)) == null) ? newEntry(segment, hVar.getKey(), hVar.getHash(), hVar2) : (c.i.d.b.h) invokeLLL.objValue;
        }

        public <K, V> void copyWriteEntry(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, hVar2) == null) {
                hVar2.setWriteTime(hVar.getWriteTime());
                LocalCache.d(hVar.getPreviousInWriteQueue(), hVar2);
                LocalCache.d(hVar2, hVar.getNextInWriteQueue());
                LocalCache.y(hVar);
            }
        }

        public abstract <K, V> c.i.d.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i2, c.i.d.b.h<K, V> hVar);

        public /* synthetic */ EntryFactory(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes9.dex */
    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements c.i.d.b.f<K, V>, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public transient c.i.d.b.f<K, V> autoDelegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LocalCache) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.google.common.cache.CacheLoader<? super K, V>, com.google.common.cache.CacheLoader<? super K1 extends K, V1 extends V> */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.autoDelegate = (c.i.d.b.f<K, V>) recreateCacheBuilder().b((CacheLoader<? super K, V>) this.loader);
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.autoDelegate : invokeV.objValue;
        }

        @Override // c.i.d.b.f, c.i.d.a.g
        public final V apply(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? this.autoDelegate.apply(k) : (V) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public V get(K k) throws ExecutionException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? this.autoDelegate.get(k) : (V) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable)) == null) ? this.autoDelegate.getAll(iterable) : (ImmutableMap) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public V getUnchecked(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) ? this.autoDelegate.getUnchecked(k) : (V) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public void refresh(K k) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, k) == null) {
                this.autoDelegate.refresh(k);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements c.i.d.b.f<K, V> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, cacheLoader), null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheBuilder, cacheLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((LocalCache) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.d.a.n.p(cacheLoader);
        }

        @Override // c.i.d.b.f, c.i.d.a.g
        public final V apply(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? getUnchecked(k) : (V) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public V get(K k) throws ExecutionException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? this.localCache.p(k) : (V) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable)) == null) ? this.localCache.l(iterable) : (ImmutableMap) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public V getUnchecked(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) {
                try {
                    return get(k);
                } catch (ExecutionException e2) {
                    throw new UncheckedExecutionException(e2.getCause());
                }
            }
            return (V) invokeL.objValue;
        }

        @Override // c.i.d.b.f
        public void refresh(K k) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, k) == null) {
                this.localCache.F(k);
            }
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new LoadingSerializationProxy(this.localCache) : invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class LocalManualCache<K, V> implements c.i.d.b.c<K, V>, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final LocalCache<K, V> localCache;

        /* loaded from: classes9.dex */
        public class a extends CacheLoader<Object, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Callable f70659a;

            public a(LocalManualCache localManualCache, Callable callable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {localManualCache, callable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70659a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (V) this.f70659a.call() : (V) invokeL.objValue;
            }
        }

        public /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // c.i.d.b.c
        public ConcurrentMap<K, V> asMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.localCache : (ConcurrentMap) invokeV.objValue;
        }

        @Override // c.i.d.b.c
        public void cleanUp() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.localCache.b();
            }
        }

        @Override // c.i.d.b.c
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, callable)) == null) {
                c.i.d.a.n.p(callable);
                return this.localCache.k(k, new a(this, callable));
            }
            return (V) invokeLL.objValue;
        }

        @Override // c.i.d.b.c
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iterable)) == null) ? this.localCache.m(iterable) : (ImmutableMap) invokeL.objValue;
        }

        @Override // c.i.d.b.c
        public V getIfPresent(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? this.localCache.n(obj) : (V) invokeL.objValue;
        }

        @Override // c.i.d.b.c
        public void invalidate(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                c.i.d.a.n.p(obj);
                this.localCache.remove(obj);
            }
        }

        @Override // c.i.d.b.c
        public void invalidateAll(Iterable<?> iterable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, iterable) == null) {
                this.localCache.r(iterable);
            }
        }

        @Override // c.i.d.b.c
        public void put(K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, v) == null) {
                this.localCache.put(k, v);
            }
        }

        @Override // c.i.d.b.c
        public void putAll(Map<? extends K, ? extends V> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                this.localCache.putAll(map);
            }
        }

        @Override // c.i.d.b.c
        public long size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.localCache.u() : invokeV.longValue;
        }

        @Override // c.i.d.b.c
        public c.i.d.b.d stats() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                c.i.d.b.a aVar = new c.i.d.b.a();
                aVar.g(this.localCache.v);
                for (Segment<K, V> segment : this.localCache.f70655g) {
                    aVar.g(segment.statsCounter);
                }
                return aVar.f();
            }
            return (c.i.d.b.d) invokeV.objValue;
        }

        public Object writeReplace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new ManualSerializationProxy(this.localCache) : invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((LocalCache) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.i.d.b.c
        public void invalidateAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.localCache.clear();
            }
        }

        public LocalManualCache(LocalCache<K, V> localCache) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.localCache = localCache;
        }
    }

    /* loaded from: classes9.dex */
    public static class ManualSerializationProxy<K, V> extends c.i.d.b.e<K, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final int concurrencyLevel;
        public transient c.i.d.b.c<K, V> delegate;
        public final long expireAfterAccessNanos;
        public final long expireAfterWriteNanos;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final CacheLoader<? super K, V> loader;
        public final long maxWeight;
        public final c.i.d.b.i<? super K, ? super V> removalListener;
        public final c.i.d.a.t ticker;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;
        public final c.i.d.b.j<K, V> weigher;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.k, localCache.l, localCache.f70657i, localCache.f70658j, localCache.p, localCache.o, localCache.m, localCache.n, localCache.f70656h, localCache.s, localCache.t, localCache.w);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Strength) objArr2[0], (Strength) objArr2[1], (Equivalence) objArr2[2], (Equivalence) objArr2[3], ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), (c.i.d.b.j) objArr2[7], ((Integer) objArr2[8]).intValue(), (c.i.d.b.i) objArr2[9], (c.i.d.a.t) objArr2[10], (CacheLoader) objArr2[11]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.delegate = (c.i.d.b.c<K, V>) recreateCacheBuilder().a();
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.delegate : invokeV.objValue;
        }

        /* JADX DEBUG: Type inference failed for r1v11. Raw type applied. Possible types: c.i.d.b.j<K, V>, c.i.d.b.j<? super K1 extends K, ? super V1 extends V> */
        /* JADX DEBUG: Type inference failed for r1v7. Raw type applied. Possible types: c.i.d.b.i<? super K, ? super V>, c.i.d.b.i<? super K1 extends K, ? super V1 extends V> */
        public CacheBuilder<K, V> recreateCacheBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.y();
                cacheBuilder.A(this.keyStrength);
                cacheBuilder.B(this.valueStrength);
                cacheBuilder.v(this.keyEquivalence);
                cacheBuilder.D(this.valueEquivalence);
                cacheBuilder.e(this.concurrencyLevel);
                cacheBuilder.z(this.removalListener);
                cacheBuilder.f70638a = false;
                long j2 = this.expireAfterWriteNanos;
                if (j2 > 0) {
                    cacheBuilder.g(j2, TimeUnit.NANOSECONDS);
                }
                long j3 = this.expireAfterAccessNanos;
                if (j3 > 0) {
                    cacheBuilder.f(j3, TimeUnit.NANOSECONDS);
                }
                c.i.d.b.j jVar = this.weigher;
                if (jVar != CacheBuilder.OneWeigher.INSTANCE) {
                    cacheBuilder.E(jVar);
                    long j4 = this.maxWeight;
                    if (j4 != -1) {
                        cacheBuilder.x(j4);
                    }
                } else {
                    long j5 = this.maxWeight;
                    if (j5 != -1) {
                        cacheBuilder.w(j5);
                    }
                }
                c.i.d.a.t tVar = this.ticker;
                if (tVar != null) {
                    cacheBuilder.C(tVar);
                }
                return cacheBuilder;
            }
            return (CacheBuilder) invokeV.objValue;
        }

        public ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j2, long j3, long j4, c.i.d.b.j<K, V> jVar, int i2, c.i.d.b.i<? super K, ? super V> iVar, c.i.d.a.t tVar, CacheLoader<? super K, V> cacheLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {strength, strength2, equivalence, equivalence2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), jVar, Integer.valueOf(i2), iVar, tVar, cacheLoader};
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
            this.expireAfterWriteNanos = j2;
            this.expireAfterAccessNanos = j3;
            this.maxWeight = j4;
            this.weigher = jVar;
            this.concurrencyLevel = i2;
            this.removalListener = iVar;
            this.ticker = (tVar == c.i.d.a.t.b() || tVar == CacheBuilder.s) ? null : null;
            this.loader = cacheLoader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.b.e, c.i.d.c.h0
        public c.i.d.b.c<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.delegate : (c.i.d.b.c) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class NullEntry implements c.i.d.b.h<Object, Object> {
        public static final /* synthetic */ NullEntry[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NullEntry INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(288106792, "Lcom/google/common/cache/LocalCache$NullEntry;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(288106792, "Lcom/google/common/cache/LocalCache$NullEntry;");
                    return;
                }
            }
            NullEntry nullEntry = new NullEntry("INSTANCE", 0);
            INSTANCE = nullEntry;
            $VALUES = new NullEntry[]{nullEntry};
        }

        public NullEntry(String str, int i2) {
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

        public static NullEntry valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NullEntry) Enum.valueOf(NullEntry.class, str) : (NullEntry) invokeL.objValue;
        }

        public static NullEntry[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NullEntry[]) $VALUES.clone() : (NullEntry[]) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.i.d.b.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.i.d.b.h
        public Object getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<Object, Object> getNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<Object, Object> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<Object, Object> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<Object, Object> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<Object, Object> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public s<Object, Object> getValueReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (s) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.i.d.b.h
        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            }
        }

        @Override // c.i.d.b.h
        public void setNextInAccessQueue(c.i.d.b.h<Object, Object> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            }
        }

        @Override // c.i.d.b.h
        public void setNextInWriteQueue(c.i.d.b.h<Object, Object> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) {
            }
        }

        @Override // c.i.d.b.h
        public void setPreviousInAccessQueue(c.i.d.b.h<Object, Object> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
            }
        }

        @Override // c.i.d.b.h
        public void setPreviousInWriteQueue(c.i.d.b.h<Object, Object> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            }
        }

        @Override // c.i.d.b.h
        public void setValueReference(s<Object, Object> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, sVar) == null) {
            }
        }

        @Override // c.i.d.b.h
        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static abstract class Strength {
        public static final /* synthetic */ Strength[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Strength SOFT;
        public static final Strength STRONG;
        public static final Strength WEAK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210472546, "Lcom/google/common/cache/LocalCache$Strength;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(210472546, "Lcom/google/common/cache/LocalCache$Strength;");
                    return;
                }
            }
            STRONG = new Strength("STRONG", 0) { // from class: com.google.common.cache.LocalCache.Strength.1
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

                @Override // com.google.common.cache.LocalCache.Strength
                public Equivalence<Object> defaultEquivalence() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Equivalence.equals() : (Equivalence) invokeV.objValue;
                }

                @Override // com.google.common.cache.LocalCache.Strength
                public <K, V> s<K, V> referenceValue(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, V v, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, hVar, v, i2)) == null) ? i2 == 1 ? new p(v) : new a0(v, i2) : (s) invokeLLLI.objValue;
                }
            };
            SOFT = new Strength("SOFT", 1) { // from class: com.google.common.cache.LocalCache.Strength.2
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

                @Override // com.google.common.cache.LocalCache.Strength
                public Equivalence<Object> defaultEquivalence() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Equivalence.identity() : (Equivalence) invokeV.objValue;
                }

                @Override // com.google.common.cache.LocalCache.Strength
                public <K, V> s<K, V> referenceValue(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, V v, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, hVar, v, i2)) == null) ? i2 == 1 ? new l(segment.valueReferenceQueue, v, hVar) : new z(segment.valueReferenceQueue, v, hVar, i2) : (s) invokeLLLI.objValue;
                }
            };
            Strength strength = new Strength("WEAK", 2) { // from class: com.google.common.cache.LocalCache.Strength.3
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

                @Override // com.google.common.cache.LocalCache.Strength
                public Equivalence<Object> defaultEquivalence() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Equivalence.identity() : (Equivalence) invokeV.objValue;
                }

                @Override // com.google.common.cache.LocalCache.Strength
                public <K, V> s<K, V> referenceValue(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, V v, int i2) {
                    InterceptResult invokeLLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLLI = interceptable2.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, segment, hVar, v, i2)) == null) ? i2 == 1 ? new x(segment.valueReferenceQueue, v, hVar) : new b0(segment.valueReferenceQueue, v, hVar, i2) : (s) invokeLLLI.objValue;
                }
            };
            WEAK = strength;
            $VALUES = new Strength[]{STRONG, SOFT, strength};
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

        public abstract <K, V> s<K, V> referenceValue(Segment<K, V> segment, c.i.d.b.h<K, V> hVar, V v, int i2);

        public /* synthetic */ Strength(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements s<Object, Object> {
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

        @Override // com.google.common.cache.LocalCache.s
        public c.i.d.b.h<Object, Object> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<Object, Object> f(ReferenceQueue<Object> referenceQueue, Object obj, c.i.d.b.h<Object, Object> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, referenceQueue, obj, hVar)) == null) ? this : (s) invokeLLL.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a0<K, V> extends p<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f70665f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(V v, int i2) {
            super(v);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70665f = i2;
        }

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70665f : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends AbstractQueue<Object> {
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

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ImmutableSet.of().iterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Queue
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // java.util.Queue
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b0<K, V> extends x<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f70666f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar, int i2) {
            super(referenceQueue, v, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, v, hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], (c.i.d.b.h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70666f = i2;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70666f : invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, referenceQueue, v, hVar)) == null) ? new b0(referenceQueue, v, hVar, this.f70666f) : (s) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public abstract class c<T> extends AbstractSet<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentMap<?, ?> f70667e;

        public c(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache, concurrentMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70667e = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70667e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70667e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70667e.size() : invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? LocalCache.J(this).toArray() : (Object[]) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eArr)) == null) ? (E[]) LocalCache.J(this).toArray(eArr) : (E[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class c0<K, V> extends AbstractQueue<c.i.d.b.h<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.i.d.b.h<K, V> f70668e;

        /* loaded from: classes9.dex */
        public class a extends d<K, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public c.i.d.b.h<K, V> f70669e;

            /* renamed from: f  reason: collision with root package name */
            public c.i.d.b.h<K, V> f70670f;

            public a(c0 c0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70669e = this;
                this.f70670f = this;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public c.i.d.b.h<K, V> getNextInWriteQueue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70669e : (c.i.d.b.h) invokeV.objValue;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70670f : (c.i.d.b.h) invokeV.objValue;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public long getWriteTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return Long.MAX_VALUE;
                }
                return invokeV.longValue;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
                    this.f70669e = hVar;
                }
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                    this.f70670f = hVar;
                }
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public void setWriteTime(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b extends c.i.d.c.g<c.i.d.b.h<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c0 f70671f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(c0 c0Var, c.i.d.b.h hVar) {
                super(hVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var, hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70671f = c0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.c.g
            /* renamed from: b */
            public c.i.d.b.h<K, V> a(c.i.d.b.h<K, V> hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) {
                    c.i.d.b.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
                    if (nextInWriteQueue == this.f70671f.f70668e) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
                return (c.i.d.b.h) invokeL.objValue;
            }
        }

        public c0() {
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
            this.f70668e = new a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
                LocalCache.d(hVar.getPreviousInWriteQueue(), hVar.getNextInWriteQueue());
                LocalCache.d(this.f70668e.getPreviousInWriteQueue(), hVar);
                LocalCache.d(hVar, this.f70668e);
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: b */
        public c.i.d.b.h<K, V> peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.i.d.b.h<K, V> nextInWriteQueue = this.f70668e.getNextInWriteQueue();
                if (nextInWriteQueue == this.f70668e) {
                    return null;
                }
                return nextInWriteQueue;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: c */
        public c.i.d.b.h<K, V> poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.i.d.b.h<K, V> nextInWriteQueue = this.f70668e.getNextInWriteQueue();
                if (nextInWriteQueue == this.f70668e) {
                    return null;
                }
                remove(nextInWriteQueue);
                return nextInWriteQueue;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            c.i.d.b.h<K, V> nextInWriteQueue = this.f70668e.getNextInWriteQueue();
            while (true) {
                c.i.d.b.h<K, V> hVar = this.f70668e;
                if (nextInWriteQueue != hVar) {
                    c.i.d.b.h<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.y(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    hVar.setNextInWriteQueue(hVar);
                    c.i.d.b.h<K, V> hVar2 = this.f70668e;
                    hVar2.setPreviousInWriteQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? ((c.i.d.b.h) obj).getNextInWriteQueue() != NullEntry.INSTANCE : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70668e.getNextInWriteQueue() == this.f70668e : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<c.i.d.b.h<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new b(this, peek()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
                c.i.d.b.h hVar = (c.i.d.b.h) obj;
                c.i.d.b.h<K, V> previousInWriteQueue = hVar.getPreviousInWriteQueue();
                c.i.d.b.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
                LocalCache.d(previousInWriteQueue, nextInWriteQueue);
                LocalCache.y(hVar);
                return nextInWriteQueue != NullEntry.INSTANCE;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i2 = 0;
                for (c.i.d.b.h<K, V> nextInWriteQueue = this.f70668e.getNextInWriteQueue(); nextInWriteQueue != this.f70668e; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                    i2++;
                }
                return i2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class d<K, V> implements c.i.d.b.h<K, V> {
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
                }
            }
        }

        @Override // c.i.d.b.h
        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        @Override // c.i.d.b.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.intValue;
        }

        @Override // c.i.d.b.h
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (K) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<K, V> getNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public s<K, V> getValueReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (s) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        @Override // c.i.d.b.h
        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setValueReference(s<K, V> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, sVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class d0 implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f70672e;

        /* renamed from: f  reason: collision with root package name */
        public V f70673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LocalCache f70674g;

        public d0(LocalCache localCache, K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache, k, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70674g = localCache;
            this.f70672e = k;
            this.f70673f = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return this.f70672e.equals(entry.getKey()) && this.f70673f.equals(entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70672e : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70673f : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70672e.hashCode() ^ this.f70673f.hashCode() : invokeV.intValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v)) == null) {
                V v2 = (V) this.f70674g.put(this.f70672e, v);
                this.f70673f = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return getKey() + "=" + getValue();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<K, V> extends AbstractQueue<c.i.d.b.h<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.i.d.b.h<K, V> f70675e;

        /* loaded from: classes9.dex */
        public class a extends d<K, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public c.i.d.b.h<K, V> f70676e;

            /* renamed from: f  reason: collision with root package name */
            public c.i.d.b.h<K, V> f70677f;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70676e = this;
                this.f70677f = this;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public long getAccessTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return Long.MAX_VALUE;
                }
                return invokeV.longValue;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public c.i.d.b.h<K, V> getNextInAccessQueue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70676e : (c.i.d.b.h) invokeV.objValue;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70677f : (c.i.d.b.h) invokeV.objValue;
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public void setAccessTime(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                }
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                    this.f70676e = hVar;
                }
            }

            @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
            public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                    this.f70677f = hVar;
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b extends c.i.d.c.g<c.i.d.b.h<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f70678f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(e eVar, c.i.d.b.h hVar) {
                super(hVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70678f = eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.c.g
            /* renamed from: b */
            public c.i.d.b.h<K, V> a(c.i.d.b.h<K, V> hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) {
                    c.i.d.b.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
                    if (nextInAccessQueue == this.f70678f.f70675e) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
                return (c.i.d.b.h) invokeL.objValue;
            }
        }

        public e() {
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
            this.f70675e = new a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
                LocalCache.c(hVar.getPreviousInAccessQueue(), hVar.getNextInAccessQueue());
                LocalCache.c(this.f70675e.getPreviousInAccessQueue(), hVar);
                LocalCache.c(hVar, this.f70675e);
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: b */
        public c.i.d.b.h<K, V> peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.i.d.b.h<K, V> nextInAccessQueue = this.f70675e.getNextInAccessQueue();
                if (nextInAccessQueue == this.f70675e) {
                    return null;
                }
                return nextInAccessQueue;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: c */
        public c.i.d.b.h<K, V> poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.i.d.b.h<K, V> nextInAccessQueue = this.f70675e.getNextInAccessQueue();
                if (nextInAccessQueue == this.f70675e) {
                    return null;
                }
                remove(nextInAccessQueue);
                return nextInAccessQueue;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            c.i.d.b.h<K, V> nextInAccessQueue = this.f70675e.getNextInAccessQueue();
            while (true) {
                c.i.d.b.h<K, V> hVar = this.f70675e;
                if (nextInAccessQueue != hVar) {
                    c.i.d.b.h<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.x(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    hVar.setNextInAccessQueue(hVar);
                    c.i.d.b.h<K, V> hVar2 = this.f70675e;
                    hVar2.setPreviousInAccessQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? ((c.i.d.b.h) obj).getNextInAccessQueue() != NullEntry.INSTANCE : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70675e.getNextInAccessQueue() == this.f70675e : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<c.i.d.b.h<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new b(this, peek()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
                c.i.d.b.h hVar = (c.i.d.b.h) obj;
                c.i.d.b.h<K, V> previousInAccessQueue = hVar.getPreviousInAccessQueue();
                c.i.d.b.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
                LocalCache.c(previousInAccessQueue, nextInAccessQueue);
                LocalCache.x(hVar);
                return nextInAccessQueue != NullEntry.INSTANCE;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i2 = 0;
                for (c.i.d.b.h<K, V> nextInAccessQueue = this.f70675e.getNextInAccessQueue(); nextInAccessQueue != this.f70675e; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                    i2++;
                }
                return i2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LocalCache localCache) {
            super(localCache);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LocalCache) newInitContext.callArgs[0]);
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

    /* loaded from: classes9.dex */
    public final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LocalCache f70679f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            super(localCache, concurrentMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache, concurrentMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((LocalCache) objArr2[0], (ConcurrentMap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70679f = localCache;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Map.Entry entry;
            Object key;
            Object obj2;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = this.f70679f.get(key)) != null && this.f70679f.f70658j.equivalent(entry.getValue(), obj2) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(this.f70679f) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Map.Entry entry;
            Object key;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.f70679f.remove(key, entry.getValue()) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public abstract class h<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f70680e;

        /* renamed from: f  reason: collision with root package name */
        public int f70681f;

        /* renamed from: g  reason: collision with root package name */
        public Segment<K, V> f70682g;

        /* renamed from: h  reason: collision with root package name */
        public AtomicReferenceArray<c.i.d.b.h<K, V>> f70683h;

        /* renamed from: i  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70684i;

        /* renamed from: j  reason: collision with root package name */
        public LocalCache<K, V>.d0 f70685j;
        public LocalCache<K, V>.d0 k;
        public final /* synthetic */ LocalCache l;

        public h(LocalCache localCache) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = localCache;
            this.f70680e = localCache.f70655g.length - 1;
            this.f70681f = -1;
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f70685j = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i2 = this.f70680e;
                if (i2 < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = this.l.f70655g;
                this.f70680e = i2 - 1;
                Segment<K, V> segment = segmentArr[i2];
                this.f70682g = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.f70682g.table;
                    this.f70683h = atomicReferenceArray;
                    this.f70681f = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(c.i.d.b.h<K, V> hVar) {
            boolean z;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) {
                try {
                    long a2 = this.l.t.a();
                    K key = hVar.getKey();
                    Object o = this.l.o(hVar, a2);
                    if (o != null) {
                        this.f70685j = new d0(this.l, key, o);
                        z = true;
                    } else {
                        z = false;
                    }
                    return z;
                } finally {
                    this.f70682g.postReadCleanup();
                }
            }
            return invokeL.booleanValue;
        }

        public LocalCache<K, V>.d0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                LocalCache<K, V>.d0 d0Var = this.f70685j;
                if (d0Var != null) {
                    this.k = d0Var;
                    a();
                    return this.k;
                }
                throw new NoSuchElementException();
            }
            return (d0) invokeV.objValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
                return invokeV.booleanValue;
            }
            c.i.d.b.h<K, V> hVar = this.f70684i;
            if (hVar == null) {
                return false;
            }
            while (true) {
                this.f70684i = hVar.getNext();
                c.i.d.b.h<K, V> hVar2 = this.f70684i;
                if (hVar2 == null) {
                    return false;
                }
                if (b(hVar2)) {
                    return true;
                }
                hVar = this.f70684i;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
                return invokeV.booleanValue;
            }
            while (true) {
                int i2 = this.f70681f;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.f70683h;
                this.f70681f = i2 - 1;
                c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(i2);
                this.f70684i = hVar;
                if (hVar != null && (b(hVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70685j != null : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                c.i.d.a.n.w(this.k != null);
                this.l.remove(this.k.getKey());
                this.k = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class i extends LocalCache<K, V>.h<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(LocalCache localCache) {
            super(localCache);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LocalCache) newInitContext.callArgs[0]);
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

    /* loaded from: classes9.dex */
    public final class j extends LocalCache<K, V>.c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LocalCache f70686f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            super(localCache, concurrentMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache, concurrentMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((LocalCache) objArr2[0], (ConcurrentMap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70686f = localCache;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.f70667e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new i(this.f70686f) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.f70667e.remove(obj) != null : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class k<K, V> implements s<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile s<K, V> f70687e;

        /* renamed from: f  reason: collision with root package name */
        public final SettableFuture<V> f70688f;

        /* renamed from: g  reason: collision with root package name */
        public final c.i.d.a.p f70689g;

        /* loaded from: classes9.dex */
        public class a implements c.i.d.a.g<V, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f70690e;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70690e = kVar;
            }

            @Override // c.i.d.a.g
            public V apply(V v) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                    this.f70690e.k(v);
                    return v;
                }
                return (V) invokeL.objValue;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public k() {
            this(LocalCache.K());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((s) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public c.i.d.b.h<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                if (v != null) {
                    k(v);
                } else {
                    this.f70687e = LocalCache.K();
                }
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70687e.c() : invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() throws ExecutionException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (V) Uninterruptibles.getUninterruptibly(this.f70688f) : (V) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, referenceQueue, v, hVar)) == null) ? this : (s) invokeLLL.objValue;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70689g.e(TimeUnit.NANOSECONDS) : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f70687e.get() : (V) invokeV.objValue;
        }

        public final ListenableFuture<V> h(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th)) == null) ? Futures.immediateFailedFuture(th) : (ListenableFuture) invokeL.objValue;
        }

        public s<K, V> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f70687e : (s) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f70687e.isActive() : invokeV.booleanValue;
        }

        public ListenableFuture<V> j(K k, CacheLoader<? super K, V> cacheLoader) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, cacheLoader)) == null) {
                try {
                    this.f70689g.h();
                    V v = this.f70687e.get();
                    if (v == null) {
                        V load = cacheLoader.load(k);
                        return k(load) ? this.f70688f : Futures.immediateFuture(load);
                    }
                    ListenableFuture<V> reload = cacheLoader.reload(k, v);
                    if (reload == null) {
                        return Futures.immediateFuture(null);
                    }
                    return Futures.transform(reload, new a(this), MoreExecutors.directExecutor());
                } catch (Throwable th) {
                    ListenableFuture<V> h2 = l(th) ? this.f70688f : h(th);
                    if (th instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    return h2;
                }
            }
            return (ListenableFuture) invokeLL.objValue;
        }

        public boolean k(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, v)) == null) ? this.f70688f.set(v) : invokeL.booleanValue;
        }

        public boolean l(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, th)) == null) ? this.f70688f.setException(th) : invokeL.booleanValue;
        }

        public k(s<K, V> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f70688f = SettableFuture.create();
            this.f70689g = c.i.d.a.p.d();
            this.f70687e = sVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class l<K, V> extends SoftReference<V> implements s<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.i.d.b.h<K, V> f70691e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            super(v, referenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, v, hVar};
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
            this.f70691e = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public c.i.d.b.h<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70691e : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? get() : (V) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, referenceQueue, v, hVar)) == null) ? new l(referenceQueue, v, hVar) : (s) invokeLLL.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<K, V> extends o<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public volatile long f70692i;

        /* renamed from: j  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70693j;
        public c.i.d.b.h<K, V> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(k, i2, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], ((Integer) objArr2[1]).intValue(), (c.i.d.b.h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70692i = Long.MAX_VALUE;
            this.f70693j = LocalCache.w();
            this.k = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70692i : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70693j : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f70692i = j2;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                this.f70693j = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                this.k = hVar;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class n<K, V> extends o<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public volatile long f70694i;

        /* renamed from: j  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70695j;
        public c.i.d.b.h<K, V> k;
        public volatile long l;
        public c.i.d.b.h<K, V> m;
        public c.i.d.b.h<K, V> n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(k, i2, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], ((Integer) objArr2[1]).intValue(), (c.i.d.b.h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70694i = Long.MAX_VALUE;
            this.f70695j = LocalCache.w();
            this.k = LocalCache.w();
            this.l = Long.MAX_VALUE;
            this.m = LocalCache.w();
            this.n = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70694i : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70695j : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
                this.f70694i = j2;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                this.f70695j = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                this.m = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                this.k = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                this.n = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
                this.l = j2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class o<K, V> extends d<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f70696e;

        /* renamed from: f  reason: collision with root package name */
        public final int f70697f;

        /* renamed from: g  reason: collision with root package name */
        public final c.i.d.b.h<K, V> f70698g;

        /* renamed from: h  reason: collision with root package name */
        public volatile s<K, V> f70699h;

        public o(K k, int i2, c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70699h = LocalCache.K();
            this.f70696e = k;
            this.f70697f = i2;
            this.f70698g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70697f : invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70696e : (K) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70698g : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public s<K, V> getValueReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70699h : (s) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setValueReference(s<K, V> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sVar) == null) {
                this.f70699h = sVar;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class p<K, V> implements s<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final V f70700e;

        public p(V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70700e = v;
        }

        @Override // com.google.common.cache.LocalCache.s
        public c.i.d.b.h<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? get() : (V) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, referenceQueue, v, hVar)) == null) ? this : (s) invokeLLL.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70700e : (V) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class q<K, V> extends o<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public volatile long f70701i;

        /* renamed from: j  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70702j;
        public c.i.d.b.h<K, V> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(k, i2, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], ((Integer) objArr2[1]).intValue(), (c.i.d.b.h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70701i = Long.MAX_VALUE;
            this.f70702j = LocalCache.w();
            this.k = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70702j : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70701i : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
                this.f70702j = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                this.k = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.d, c.i.d.b.h
        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.f70701i = j2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class r extends LocalCache<K, V>.h<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(LocalCache localCache) {
            super(localCache);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LocalCache) newInitContext.callArgs[0]);
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

    /* loaded from: classes9.dex */
    public interface s<K, V> {
        c.i.d.b.h<K, V> a();

        void b(V v);

        int c();

        V d() throws ExecutionException;

        boolean e();

        s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar);

        V get();

        boolean isActive();
    }

    /* loaded from: classes9.dex */
    public final class t extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentMap<?, ?> f70703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LocalCache f70704f;

        public t(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache, concurrentMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70704f = localCache;
            this.f70703e = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70703e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f70703e.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70703e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new r(this.f70704f) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70703e.size() : invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? LocalCache.J(this).toArray() : (Object[]) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eArr)) == null) ? (E[]) LocalCache.J(this).toArray(eArr) : (E[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class u<K, V> extends w<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f70705h;

        /* renamed from: i  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70706i;

        /* renamed from: j  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70707j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(ReferenceQueue<K> referenceQueue, K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(referenceQueue, k, i2, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], ((Integer) objArr2[2]).intValue(), (c.i.d.b.h) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70705h = Long.MAX_VALUE;
            this.f70706i = LocalCache.w();
            this.f70707j = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70705h : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70706i : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70707j : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f70705h = j2;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                this.f70706i = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                this.f70707j = hVar;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class v<K, V> extends w<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f70708h;

        /* renamed from: i  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70709i;

        /* renamed from: j  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70710j;
        public volatile long k;
        public c.i.d.b.h<K, V> l;
        public c.i.d.b.h<K, V> m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ReferenceQueue<K> referenceQueue, K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(referenceQueue, k, i2, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], ((Integer) objArr2[2]).intValue(), (c.i.d.b.h) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70708h = Long.MAX_VALUE;
            this.f70709i = LocalCache.w();
            this.f70710j = LocalCache.w();
            this.k = Long.MAX_VALUE;
            this.l = LocalCache.w();
            this.m = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70708h : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70709i : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70710j : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
                this.f70708h = j2;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                this.f70709i = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                this.l = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                this.f70710j = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                this.m = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
                this.k = j2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class w<K, V> extends WeakReference<K> implements c.i.d.b.h<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f70711e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.d.b.h<K, V> f70712f;

        /* renamed from: g  reason: collision with root package name */
        public volatile s<K, V> f70713g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(ReferenceQueue<K> referenceQueue, K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(k, referenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k, Integer.valueOf(i2), hVar};
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
            this.f70713g = LocalCache.K();
            this.f70711e = i2;
            this.f70712f = hVar;
        }

        public long getAccessTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        @Override // c.i.d.b.h
        public int getHash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70711e : invokeV.intValue;
        }

        @Override // c.i.d.b.h
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() : (K) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public c.i.d.b.h<K, V> getNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70712f : (c.i.d.b.h) invokeV.objValue;
        }

        public c.i.d.b.h<K, V> getNextInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        public c.i.d.b.h<K, V> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        public c.i.d.b.h<K, V> getPreviousInAccessQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        @Override // c.i.d.b.h
        public s<K, V> getValueReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f70713g : (s) invokeV.objValue;
        }

        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        public void setAccessTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void setNextInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void setPreviousInAccessQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.b.h
        public void setValueReference(s<K, V> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, sVar) == null) {
                this.f70713g = sVar;
            }
        }

        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class x<K, V> extends WeakReference<V> implements s<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.i.d.b.h<K, V> f70714e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            super(v, referenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, v, hVar};
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
            this.f70714e = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public c.i.d.b.h<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70714e : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? get() : (V) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, referenceQueue, v, hVar)) == null) ? new x(referenceQueue, v, hVar) : (s) invokeLLL.objValue;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class y<K, V> extends w<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f70715h;

        /* renamed from: i  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70716i;

        /* renamed from: j  reason: collision with root package name */
        public c.i.d.b.h<K, V> f70717j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(ReferenceQueue<K> referenceQueue, K k, int i2, c.i.d.b.h<K, V> hVar) {
            super(referenceQueue, k, i2, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, k, Integer.valueOf(i2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], ((Integer) objArr2[2]).intValue(), (c.i.d.b.h) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70715h = Long.MAX_VALUE;
            this.f70716i = LocalCache.w();
            this.f70717j = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getNextInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70716i : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public c.i.d.b.h<K, V> getPreviousInWriteQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70717j : (c.i.d.b.h) invokeV.objValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public long getWriteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70715h : invokeV.longValue;
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setNextInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
                this.f70716i = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setPreviousInWriteQueue(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                this.f70717j = hVar;
            }
        }

        @Override // com.google.common.cache.LocalCache.w, c.i.d.b.h
        public void setWriteTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.f70715h = j2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class z<K, V> extends l<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f70718f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar, int i2) {
            super(referenceQueue, v, hVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {referenceQueue, v, hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ReferenceQueue) objArr2[0], objArr2[1], (c.i.d.b.h) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70718f = i2;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70718f : invokeV.intValue;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public s<K, V> f(ReferenceQueue<V> referenceQueue, V v, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, referenceQueue, v, hVar)) == null) ? new z(referenceQueue, v, hVar, this.f70718f) : (s) invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2093419345, "Lcom/google/common/cache/LocalCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2093419345, "Lcom/google/common/cache/LocalCache;");
                return;
            }
        }
        A = Logger.getLogger(LocalCache.class.getName());
        B = new a();
        C = new b();
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cacheBuilder, cacheLoader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70656h = Math.min(cacheBuilder.h(), 65536);
        this.k = cacheBuilder.m();
        this.l = cacheBuilder.t();
        this.f70657i = cacheBuilder.l();
        this.f70658j = cacheBuilder.s();
        this.m = cacheBuilder.n();
        this.n = (c.i.d.b.j<K, V>) cacheBuilder.u();
        this.o = cacheBuilder.i();
        this.p = cacheBuilder.j();
        this.q = cacheBuilder.o();
        c.i.d.b.i<K, V> iVar = (c.i.d.b.i<K, V>) cacheBuilder.p();
        this.s = iVar;
        this.r = iVar == CacheBuilder.NullListener.INSTANCE ? g() : new ConcurrentLinkedQueue<>();
        this.t = cacheBuilder.r(D());
        this.u = EntryFactory.getFactory(this.k, L(), P());
        this.v = cacheBuilder.q().get();
        this.w = cacheLoader;
        int min = Math.min(cacheBuilder.k(), 1073741824);
        if (h() && !f()) {
            min = (int) Math.min(min, this.m);
        }
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.f70656h && (!h() || i6 * 20 <= this.m)) {
            i7++;
            i6 <<= 1;
        }
        this.f70654f = 32 - i7;
        this.f70653e = i6 - 1;
        this.f70655g = v(i6);
        int i8 = min / i6;
        while (i5 < (i8 * i6 < min ? i8 + 1 : i8)) {
            i5 <<= 1;
        }
        if (h()) {
            long j2 = this.m;
            long j3 = i6;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (i4 < this.f70655g.length) {
                if (i4 == j5) {
                    j4--;
                }
                this.f70655g[i4] = e(i5, j4, cacheBuilder.q().get());
                i4++;
            }
            return;
        }
        while (true) {
            Segment<K, V>[] segmentArr = this.f70655g;
            if (i4 >= segmentArr.length) {
                return;
            }
            segmentArr[i4] = e(i5, -1L, cacheBuilder.q().get());
            i4++;
        }
    }

    public static int H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            int i3 = i2 + ((i2 << 15) ^ (-12931));
            int i4 = i3 ^ (i3 >>> 10);
            int i5 = i4 + (i4 << 3);
            int i6 = i5 ^ (i5 >>> 6);
            int i7 = i6 + (i6 << 2) + (i6 << 14);
            return i7 ^ (i7 >>> 16);
        }
        return invokeI.intValue;
    }

    public static <E> ArrayList<E> J(Collection<E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, collection)) == null) {
            ArrayList<E> arrayList = new ArrayList<>(collection.size());
            Iterators.a(arrayList, collection.iterator());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static <K, V> s<K, V> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (s<K, V>) B : (s) invokeV.objValue;
    }

    public static <K, V> void c(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, hVar, hVar2) == null) {
            hVar.setNextInAccessQueue(hVar2);
            hVar2.setPreviousInAccessQueue(hVar);
        }
    }

    public static <K, V> void d(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hVar, hVar2) == null) {
            hVar.setNextInWriteQueue(hVar2);
            hVar2.setPreviousInWriteQueue(hVar);
        }
    }

    public static <E> Queue<E> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? (Queue<E>) C : (Queue) invokeV.objValue;
    }

    public static <K, V> c.i.d.b.h<K, V> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? NullEntry.INSTANCE : (c.i.d.b.h) invokeV.objValue;
    }

    public static <K, V> void x(c.i.d.b.h<K, V> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, hVar) == null) {
            c.i.d.b.h<K, V> w2 = w();
            hVar.setNextInAccessQueue(w2);
            hVar.setPreviousInAccessQueue(w2);
        }
    }

    public static <K, V> void y(c.i.d.b.h<K, V> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, hVar) == null) {
            c.i.d.b.h<K, V> w2 = w();
            hVar.setNextInWriteQueue(w2);
            hVar.setPreviousInWriteQueue(w2);
        }
    }

    public void A(c.i.d.b.h<K, V> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            int hash = hVar.getHash();
            I(hash).reclaimKey(hVar, hash);
        }
    }

    public void B(s<K, V> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) {
            c.i.d.b.h<K, V> a2 = sVar.a();
            int hash = a2.getHash();
            I(hash).reclaimValue(a2.getKey(), hash, sVar);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? i() : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? E() || C() : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? j() || G() : invokeV.booleanValue;
    }

    public void F(K k2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, k2) == null) {
            c.i.d.a.n.p(k2);
            int q2 = q(k2);
            I(q2).refresh(k2, q2, this.w, false);
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q > 0 : invokeV.booleanValue;
    }

    public Segment<K, V> I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f70655g[(i2 >>> this.f70654f) & this.f70653e] : (Segment) invokeI.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? M() || C() : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? i() || h() : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k != Strength.STRONG : invokeV.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l != Strength.STRONG : invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Q() || E() : invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? j() : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Segment<K, V> segment : this.f70655g) {
                segment.cleanUp();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Segment<K, V> segment : this.f70655g) {
                segment.clear();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            int q2 = q(obj);
            return I(q2).containsKey(obj, q2);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            long a2 = this.t.a();
            Segment<K, V>[] segmentArr = this.f70655g;
            long j2 = -1;
            int i2 = 0;
            while (i2 < 3) {
                long j3 = 0;
                int length = segmentArr.length;
                int i3 = 0;
                while (i3 < length) {
                    Segment<K, V> segment = segmentArr[i3];
                    int i4 = segment.count;
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = segment.table;
                    for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                        c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(i5);
                        while (hVar != null) {
                            Segment<K, V>[] segmentArr2 = segmentArr;
                            V liveValue = segment.getLiveValue(hVar, a2);
                            long j4 = a2;
                            if (liveValue != null && this.f70658j.equivalent(obj, liveValue)) {
                                return true;
                            }
                            hVar = hVar.getNext();
                            segmentArr = segmentArr2;
                            a2 = j4;
                        }
                    }
                    j3 += segment.modCount;
                    i3++;
                    a2 = a2;
                }
                long j5 = a2;
                Segment<K, V>[] segmentArr3 = segmentArr;
                if (j3 == j2) {
                    return false;
                }
                i2++;
                j2 = j3;
                segmentArr = segmentArr3;
                a2 = j5;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Segment<K, V> e(int i2, long j2, c.i.d.b.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), bVar})) == null) ? new Segment<>(this, i2, j2, bVar) : (Segment) invokeCommon.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Set<Map.Entry<K, V>> set = this.z;
            if (set != null) {
                return set;
            }
            g gVar = new g(this, this);
            this.z = gVar;
            return gVar;
        }
        return (Set) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n != CacheBuilder.OneWeigher.INSTANCE : invokeV.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            int q2 = q(obj);
            return I(q2).get(obj, q2);
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object obj, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, obj, v2)) == null) {
            V v3 = get(obj);
            return v3 != null ? v3 : v2;
        }
        return (V) invokeLL.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m >= 0 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o > 0 : invokeV.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Segment<K, V>[] segmentArr = this.f70655g;
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

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p > 0 : invokeV.booleanValue;
    }

    public V k(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, k2, cacheLoader)) == null) {
            c.i.d.a.n.p(k2);
            int q2 = q(k2);
            return I(q2).get(k2, q2, cacheLoader);
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Set<K> set = this.x;
            if (set != null) {
                return set;
            }
            j jVar = new j(this, this);
            this.x = jVar;
            return jVar;
        }
        return (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> l(Iterable<? extends K> iterable) throws ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, iterable)) == null) {
            LinkedHashMap v2 = Maps.v();
            LinkedHashSet i2 = Sets.i();
            int i3 = 0;
            int i4 = 0;
            for (K k2 : iterable) {
                Object obj = get(k2);
                if (!v2.containsKey(k2)) {
                    v2.put(k2, obj);
                    if (obj == null) {
                        i4++;
                        i2.add(k2);
                    } else {
                        i3++;
                    }
                }
            }
            try {
                if (!i2.isEmpty()) {
                    try {
                        Map t2 = t(i2, this.w);
                        for (Object obj2 : i2) {
                            Object obj3 = t2.get(obj2);
                            if (obj3 != null) {
                                v2.put(obj2, obj3);
                            } else {
                                throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                            }
                        }
                    } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                        for (Object obj4 : i2) {
                            i4--;
                            v2.put(obj4, k(obj4, this.w));
                        }
                    }
                }
                return ImmutableMap.copyOf((Map) v2);
            } finally {
                this.v.a(i3);
                this.v.d(i4);
            }
        }
        return (ImmutableMap) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> m(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, iterable)) == null) {
            LinkedHashMap v2 = Maps.v();
            int i2 = 0;
            int i3 = 0;
            for (Object obj : iterable) {
                V v3 = get(obj);
                if (v3 == null) {
                    i3++;
                } else {
                    v2.put(obj, v3);
                    i2++;
                }
            }
            this.v.a(i2);
            this.v.d(i3);
            return ImmutableMap.copyOf((Map) v2);
        }
        return (ImmutableMap) invokeL.objValue;
    }

    public V n(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            c.i.d.a.n.p(obj);
            int q2 = q(obj);
            V v2 = I(q2).get(obj, q2);
            if (v2 == null) {
                this.v.d(1);
            } else {
                this.v.a(1);
            }
            return v2;
        }
        return (V) invokeL.objValue;
    }

    public V o(c.i.d.b.h<K, V> hVar, long j2) {
        InterceptResult invokeLJ;
        V v2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048608, this, hVar, j2)) == null) {
            if (hVar.getKey() == null || (v2 = hVar.getValueReference().get()) == null || s(hVar, j2)) {
                return null;
            }
            return v2;
        }
        return (V) invokeLJ.objValue;
    }

    public V p(K k2) throws ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, k2)) == null) ? k(k2, this.w) : (V) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, k2, v2)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v2);
            int q2 = q(k2);
            return I(q2).put(k2, q2, v2, false);
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, map) == null) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, k2, v2)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v2);
            int q2 = q(k2);
            return I(q2).put(k2, q2, v2, true);
        }
        return (V) invokeLL.objValue;
    }

    public int q(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, obj)) == null) ? H(this.f70657i.hash(obj)) : invokeL.intValue;
    }

    public void r(Iterable<?> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, iterable) == null) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            int q2 = q(obj);
            return I(q2).remove(obj, q2);
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, V v2, V v3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048618, this, k2, v2, v3)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v3);
            if (v2 == null) {
                return false;
            }
            int q2 = q(k2);
            return I(q2).replace(k2, q2, v2, v3);
        }
        return invokeLLL.booleanValue;
    }

    public boolean s(c.i.d.b.h<K, V> hVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048619, this, hVar, j2)) == null) {
            c.i.d.a.n.p(hVar);
            if (!i() || j2 - hVar.getAccessTime() < this.o) {
                return j() && j2 - hVar.getWriteTime() >= this.p;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? Ints.j(u()) : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<K, V> t(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, set, cacheLoader)) == null) {
            c.i.d.a.n.p(cacheLoader);
            c.i.d.a.n.p(set);
            c.i.d.a.p c2 = c.i.d.a.p.c();
            boolean z2 = true;
            boolean z3 = false;
            try {
                try {
                    try {
                        try {
                            try {
                                Map map = (Map<? super K, V>) cacheLoader.loadAll(set);
                                if (map != null) {
                                    c2.i();
                                    for (Map.Entry<K, V> entry : map.entrySet()) {
                                        K key = entry.getKey();
                                        V value = entry.getValue();
                                        if (key == null || value == null) {
                                            z3 = true;
                                        } else {
                                            put(key, value);
                                        }
                                    }
                                    if (!z3) {
                                        this.v.c(c2.e(TimeUnit.NANOSECONDS));
                                        return map;
                                    }
                                    this.v.e(c2.e(TimeUnit.NANOSECONDS));
                                    throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
                                }
                                this.v.e(c2.e(TimeUnit.NANOSECONDS));
                                throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
                            } catch (RuntimeException e2) {
                                throw new UncheckedExecutionException(e2);
                            }
                        } catch (InterruptedException e3) {
                            Thread.currentThread().interrupt();
                            throw new ExecutionException(e3);
                        }
                    } catch (Error e4) {
                        throw new ExecutionError(e4);
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException e5) {
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        if (!z2) {
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    throw new ExecutionException(e6);
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = false;
                if (!z2) {
                    this.v.e(c2.e(TimeUnit.NANOSECONDS));
                }
                throw th;
            }
        }
        return (Map) invokeLL.objValue;
    }

    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            long j2 = 0;
            for (Segment<K, V> segment : this.f70655g) {
                j2 += Math.max(0, segment.count);
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public final Segment<K, V>[] v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) ? new Segment[i2] : (Segment[]) invokeI.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Collection<V> collection = this.y;
            if (collection != null) {
                return collection;
            }
            t tVar = new t(this, this);
            this.y = tVar;
            return tVar;
        }
        return (Collection) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048625, this) != null) {
            return;
        }
        while (true) {
            RemovalNotification<K, V> poll = this.r.poll();
            if (poll == null) {
                return;
            }
            try {
                this.s.onRemoval(poll);
            } catch (Throwable th) {
                A.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, obj, obj2)) == null) {
            if (obj == null || obj2 == null) {
                return false;
            }
            int q2 = q(obj);
            return I(q2).remove(obj, q2, obj2);
        }
        return invokeLL.booleanValue;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, k2, v2)) == null) {
            c.i.d.a.n.p(k2);
            c.i.d.a.n.p(v2);
            int q2 = q(k2);
            return I(q2).replace(k2, q2, v2);
        }
        return (V) invokeLL.objValue;
    }

    /* loaded from: classes9.dex */
    public static class Segment<K, V> extends ReentrantLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<c.i.d.b.h<K, V>> accessQueue;
        public volatile int count;
        public final ReferenceQueue<K> keyReferenceQueue;
        public final LocalCache<K, V> map;
        public final long maxSegmentWeight;
        public int modCount;
        public final AtomicInteger readCount;
        public final Queue<c.i.d.b.h<K, V>> recencyQueue;
        public final c.i.d.b.b statsCounter;
        public volatile AtomicReferenceArray<c.i.d.b.h<K, V>> table;
        public int threshold;
        public long totalWeight;
        public final ReferenceQueue<V> valueReferenceQueue;
        public final Queue<c.i.d.b.h<K, V>> writeQueue;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f70660e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f70661f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f70662g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ListenableFuture f70663h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Segment f70664i;

            public a(Segment segment, Object obj, int i2, k kVar, ListenableFuture listenableFuture) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {segment, obj, Integer.valueOf(i2), kVar, listenableFuture};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70664i = segment;
                this.f70660e = obj;
                this.f70661f = i2;
                this.f70662g = kVar;
                this.f70663h = listenableFuture;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.cache.LocalCache$Segment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f70664i.getAndRecordStats(this.f70660e, this.f70661f, this.f70662g, this.f70663h);
                    } catch (Throwable th) {
                        LocalCache.A.log(Level.WARNING, "Exception thrown during refresh", th);
                        this.f70662g.l(th);
                    }
                }
            }
        }

        public Segment(LocalCache<K, V> localCache, int i2, long j2, c.i.d.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localCache, Integer.valueOf(i2), Long.valueOf(j2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.readCount = new AtomicInteger();
            this.map = localCache;
            this.maxSegmentWeight = j2;
            c.i.d.a.n.p(bVar);
            this.statsCounter = bVar;
            initTable(newEntryArray(i2));
            this.keyReferenceQueue = localCache.N() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.O() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.M() ? new ConcurrentLinkedQueue<>() : LocalCache.g();
            this.writeQueue = localCache.Q() ? new c0<>() : LocalCache.g();
            this.accessQueue = localCache.M() ? new e<>() : LocalCache.g();
        }

        public void cleanUp() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                runLockedCleanup(this.map.t.a());
                runUnlockedCleanup();
            }
        }

        public void clear() {
            RemovalCause removalCause;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.count == 0) {
                return;
            }
            lock();
            try {
                preWriteCleanup(this.map.t.a());
                AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                    for (c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(i2); hVar != null; hVar = hVar.getNext()) {
                        if (hVar.getValueReference().isActive()) {
                            K key = hVar.getKey();
                            V v = hVar.getValueReference().get();
                            if (key != null && v != null) {
                                removalCause = RemovalCause.EXPLICIT;
                                enqueueNotification(key, hVar.getHash(), v, hVar.getValueReference().c(), removalCause);
                            }
                            removalCause = RemovalCause.COLLECTED;
                            enqueueNotification(key, hVar.getHash(), v, hVar.getValueReference().c(), removalCause);
                        }
                    }
                }
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    atomicReferenceArray.set(i3, null);
                }
                clearReferenceQueues();
                this.writeQueue.clear();
                this.accessQueue.clear();
                this.readCount.set(0);
                this.modCount++;
                this.count = 0;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void clearKeyReferenceQueue() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                do {
                } while (this.keyReferenceQueue.poll() != null);
            }
        }

        public void clearReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.map.N()) {
                    clearKeyReferenceQueue();
                }
                if (this.map.O()) {
                    clearValueReferenceQueue();
                }
            }
        }

        public void clearValueReferenceQueue() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                do {
                } while (this.valueReferenceQueue.poll() != null);
            }
        }

        public boolean containsKey(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, obj, i2)) == null) {
                try {
                    if (this.count != 0) {
                        c.i.d.b.h<K, V> liveEntry = getLiveEntry(obj, i2, this.map.t.a());
                        if (liveEntry == null) {
                            return false;
                        }
                        return liveEntry.getValueReference().get() != null;
                    }
                    return false;
                } finally {
                    postReadCleanup();
                }
            }
            return invokeLI.booleanValue;
        }

        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                try {
                    if (this.count != 0) {
                        long a2 = this.map.t.a();
                        AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                        int length = atomicReferenceArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            for (c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(i2); hVar != null; hVar = hVar.getNext()) {
                                V liveValue = getLiveValue(hVar, a2);
                                if (liveValue != null && this.map.f70658j.equivalent(obj, liveValue)) {
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

        public c.i.d.b.h<K, V> copyEntry(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, hVar, hVar2)) == null) {
                if (hVar.getKey() == null) {
                    return null;
                }
                s<K, V> valueReference = hVar.getValueReference();
                V v = valueReference.get();
                if (v == null && valueReference.isActive()) {
                    return null;
                }
                c.i.d.b.h<K, V> copyEntry = this.map.u.copyEntry(this, hVar, hVar2);
                copyEntry.setValueReference(valueReference.f(this.valueReferenceQueue, v, copyEntry));
                return copyEntry;
            }
            return (c.i.d.b.h) invokeLL.objValue;
        }

        public void drainKeyReferenceQueue() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                int i2 = 0;
                do {
                    Reference<? extends K> poll = this.keyReferenceQueue.poll();
                    if (poll == null) {
                        return;
                    }
                    this.map.A((c.i.d.b.h) poll);
                    i2++;
                } while (i2 != 16);
            }
        }

        public void drainRecencyQueue() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
                return;
            }
            while (true) {
                c.i.d.b.h<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        public void drainReferenceQueues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.map.N()) {
                    drainKeyReferenceQueue();
                }
                if (this.map.O()) {
                    drainValueReferenceQueue();
                }
            }
        }

        public void drainValueReferenceQueue() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                int i2 = 0;
                do {
                    Reference<? extends V> poll = this.valueReferenceQueue.poll();
                    if (poll == null) {
                        return;
                    }
                    this.map.B((s) poll);
                    i2++;
                } while (i2 != 16);
            }
        }

        public void enqueueNotification(K k, int i2, V v, int i3, RemovalCause removalCause) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{k, Integer.valueOf(i2), v, Integer.valueOf(i3), removalCause}) == null) {
                this.totalWeight -= i3;
                if (removalCause.wasEvicted()) {
                    this.statsCounter.b();
                }
                if (this.map.r != LocalCache.C) {
                    this.map.r.offer(RemovalNotification.create(k, v, removalCause));
                }
            }
        }

        public void evictEntries(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) && this.map.h()) {
                drainRecencyQueue();
                if (hVar.getValueReference().c() > this.maxSegmentWeight && !removeEntry(hVar, hVar.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    c.i.d.b.h<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        public void expand() {
            AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray;
            int length;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (length = (atomicReferenceArray = this.table).length()) >= 1073741824) {
                return;
            }
            int i2 = this.count;
            AtomicReferenceArray<c.i.d.b.h<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i3 = 0; i3 < length; i3++) {
                c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(i3);
                if (hVar != null) {
                    c.i.d.b.h<K, V> next = hVar.getNext();
                    int hash = hVar.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, hVar);
                    } else {
                        c.i.d.b.h<K, V> hVar2 = hVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, hVar2);
                        while (hVar != hVar2) {
                            int hash3 = hVar.getHash() & length2;
                            c.i.d.b.h<K, V> copyEntry = copyEntry(hVar, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(hVar);
                                i2--;
                            }
                            hVar = hVar.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i2;
        }

        public void expireEntries(long j2) {
            c.i.d.b.h<K, V> peek;
            c.i.d.b.h<K, V> peek2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
                drainRecencyQueue();
                do {
                    peek = this.writeQueue.peek();
                    if (peek == null || !this.map.s(peek, j2)) {
                        do {
                            peek2 = this.accessQueue.peek();
                            if (peek2 == null || !this.map.s(peek2, j2)) {
                                return;
                            }
                        } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                        throw new AssertionError();
                    }
                } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        }

        public V get(K k, int i2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            InterceptResult invokeLIL;
            c.i.d.b.h<K, V> entry;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048593, this, k, i2, cacheLoader)) == null) {
                c.i.d.a.n.p(k);
                c.i.d.a.n.p(cacheLoader);
                try {
                    try {
                        if (this.count != 0 && (entry = getEntry(k, i2)) != null) {
                            long a2 = this.map.t.a();
                            V liveValue = getLiveValue(entry, a2);
                            if (liveValue != null) {
                                recordRead(entry, a2);
                                this.statsCounter.a(1);
                                return scheduleRefresh(entry, k, i2, liveValue, a2, cacheLoader);
                            }
                            s<K, V> valueReference = entry.getValueReference();
                            if (valueReference.e()) {
                                return waitForLoadingValue(entry, k, valueReference);
                            }
                        }
                        return lockedGetOrLoad(k, i2, cacheLoader);
                    } catch (ExecutionException e2) {
                        Throwable cause = e2.getCause();
                        if (!(cause instanceof Error)) {
                            if (cause instanceof RuntimeException) {
                                throw new UncheckedExecutionException(cause);
                            }
                            throw e2;
                        }
                        throw new ExecutionError((Error) cause);
                    }
                } finally {
                    postReadCleanup();
                }
            }
            return (V) invokeLIL.objValue;
        }

        public V getAndRecordStats(K k, int i2, k<K, V> kVar, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v;
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048594, this, k, i2, kVar, listenableFuture)) == null) {
                try {
                    v = (V) Uninterruptibles.getUninterruptibly(listenableFuture);
                } catch (Throwable th) {
                    th = th;
                    v = null;
                }
                try {
                    if (v != null) {
                        this.statsCounter.c(kVar.g());
                        storeLoadedValue(k, i2, kVar, v);
                        if (v == null) {
                            this.statsCounter.e(kVar.g());
                            removeLoadingValue(k, i2, kVar);
                        }
                        return v;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } catch (Throwable th2) {
                    th = th2;
                    if (v == null) {
                        this.statsCounter.e(kVar.g());
                        removeLoadingValue(k, i2, kVar);
                    }
                    throw th;
                }
            }
            return (V) invokeLILL.objValue;
        }

        public c.i.d.b.h<K, V> getEntry(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, obj, i2)) == null) {
                for (c.i.d.b.h<K, V> first = getFirst(i2); first != null; first = first.getNext()) {
                    if (first.getHash() == i2) {
                        K key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.f70657i.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
                return null;
            }
            return (c.i.d.b.h) invokeLI.objValue;
        }

        public c.i.d.b.h<K, V> getFirst(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
                AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                return atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
            }
            return (c.i.d.b.h) invokeI.objValue;
        }

        public c.i.d.b.h<K, V> getLiveEntry(Object obj, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{obj, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                c.i.d.b.h<K, V> entry = getEntry(obj, i2);
                if (entry == null) {
                    return null;
                }
                if (this.map.s(entry, j2)) {
                    tryExpireEntries(j2);
                    return null;
                }
                return entry;
            }
            return (c.i.d.b.h) invokeCommon.objValue;
        }

        public V getLiveValue(c.i.d.b.h<K, V> hVar, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048598, this, hVar, j2)) == null) {
                if (hVar.getKey() == null) {
                    tryDrainReferenceQueues();
                    return null;
                }
                V v = hVar.getValueReference().get();
                if (v == null) {
                    tryDrainReferenceQueues();
                    return null;
                } else if (this.map.s(hVar, j2)) {
                    tryExpireEntries(j2);
                    return null;
                } else {
                    return v;
                }
            }
            return (V) invokeLJ.objValue;
        }

        public c.i.d.b.h<K, V> getNextEvictable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                for (c.i.d.b.h<K, V> hVar : this.accessQueue) {
                    if (hVar.getValueReference().c() > 0) {
                        return hVar;
                    }
                }
                throw new AssertionError();
            }
            return (c.i.d.b.h) invokeV.objValue;
        }

        public void initTable(AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, atomicReferenceArray) == null) {
                this.threshold = (atomicReferenceArray.length() * 3) / 4;
                if (!this.map.f()) {
                    int i2 = this.threshold;
                    if (i2 == this.maxSegmentWeight) {
                        this.threshold = i2 + 1;
                    }
                }
                this.table = atomicReferenceArray;
            }
        }

        public k<K, V> insertLoadingValueReference(K k, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{k, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                lock();
                try {
                    long a2 = this.map.t.a();
                    preWriteCleanup(a2);
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    for (c.i.d.b.h<K, V> hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            if (!valueReference.e() && (!z || a2 - hVar2.getWriteTime() >= this.map.q)) {
                                this.modCount++;
                                k<K, V> kVar = new k<>(valueReference);
                                hVar2.setValueReference(kVar);
                                return kVar;
                            }
                            return null;
                        }
                    }
                    this.modCount++;
                    k<K, V> kVar2 = new k<>();
                    c.i.d.b.h<K, V> newEntry = newEntry(k, i2, hVar);
                    newEntry.setValueReference(kVar2);
                    atomicReferenceArray.set(length, newEntry);
                    return kVar2;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return (k) invokeCommon.objValue;
        }

        public ListenableFuture<V> loadAsync(K k, int i2, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048602, this, k, i2, kVar, cacheLoader)) == null) {
                ListenableFuture<V> j2 = kVar.j(k, cacheLoader);
                j2.addListener(new a(this, k, i2, kVar, j2), MoreExecutors.directExecutor());
                return j2;
            }
            return (ListenableFuture) invokeLILL.objValue;
        }

        public V loadSync(K k, int i2, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048603, this, k, i2, kVar, cacheLoader)) == null) ? getAndRecordStats(k, i2, kVar, kVar.j(k, cacheLoader)) : (V) invokeLILL.objValue;
        }

        public V lockedGetOrLoad(K k, int i2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            InterceptResult invokeLIL;
            k<K, V> kVar;
            s<K, V> sVar;
            boolean z;
            V loadSync;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048604, this, k, i2, cacheLoader)) == null) {
                lock();
                try {
                    long a2 = this.map.t.a();
                    preWriteCleanup(a2);
                    int i3 = this.count - 1;
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = i2 & (atomicReferenceArray.length() - 1);
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        kVar = null;
                        if (hVar2 == null) {
                            sVar = null;
                            break;
                        }
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            if (valueReference.e()) {
                                z = false;
                                sVar = valueReference;
                            } else {
                                V v = valueReference.get();
                                if (v == null) {
                                    enqueueNotification(key, i2, v, valueReference.c(), RemovalCause.COLLECTED);
                                } else if (this.map.s(hVar2, a2)) {
                                    enqueueNotification(key, i2, v, valueReference.c(), RemovalCause.EXPIRED);
                                } else {
                                    recordLockedRead(hVar2, a2);
                                    this.statsCounter.a(1);
                                    return v;
                                }
                                this.writeQueue.remove(hVar2);
                                this.accessQueue.remove(hVar2);
                                this.count = i3;
                                sVar = valueReference;
                            }
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    }
                    z = true;
                    if (z) {
                        kVar = new k<>();
                        if (hVar2 == null) {
                            hVar2 = newEntry(k, i2, hVar);
                            hVar2.setValueReference(kVar);
                            atomicReferenceArray.set(length, hVar2);
                        } else {
                            hVar2.setValueReference(kVar);
                        }
                    }
                    if (z) {
                        try {
                            synchronized (hVar2) {
                                loadSync = loadSync(k, i2, kVar, cacheLoader);
                            }
                            return loadSync;
                        } finally {
                            this.statsCounter.d(1);
                        }
                    }
                    return waitForLoadingValue(hVar2, k, sVar);
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return (V) invokeLIL.objValue;
        }

        public c.i.d.b.h<K, V> newEntry(K k, int i2, c.i.d.b.h<K, V> hVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048605, this, k, i2, hVar)) == null) {
                EntryFactory entryFactory = this.map.u;
                c.i.d.a.n.p(k);
                return entryFactory.newEntry(this, k, i2, hVar);
            }
            return (c.i.d.b.h) invokeLIL.objValue;
        }

        public AtomicReferenceArray<c.i.d.b.h<K, V>> newEntryArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) ? new AtomicReferenceArray<>(i2) : (AtomicReferenceArray) invokeI.objValue;
        }

        public void postReadCleanup() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
                runUnlockedCleanup();
            }
        }

        public void preWriteCleanup(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
                runLockedCleanup(j2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V put(K k, int i2, V v, boolean z) {
            InterceptResult invokeCommon;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{k, Integer.valueOf(i2), v, Boolean.valueOf(z)})) != null) {
                return (V) invokeCommon.objValue;
            }
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                c.i.d.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 != null) {
                                if (z) {
                                    recordLockedRead(hVar2, a2);
                                } else {
                                    this.modCount++;
                                    enqueueNotification(k, i2, v2, valueReference.c(), RemovalCause.REPLACED);
                                    setValue(hVar2, k, v, a2);
                                    evictEntries(hVar2);
                                }
                                return v2;
                            }
                            this.modCount++;
                            if (valueReference.isActive()) {
                                enqueueNotification(k, i2, v2, valueReference.c(), RemovalCause.COLLECTED);
                                setValue(hVar2, k, v, a2);
                                i3 = this.count;
                            } else {
                                setValue(hVar2, k, v, a2);
                                i3 = this.count + 1;
                            }
                            this.count = i3;
                            evictEntries(hVar2);
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        c.i.d.b.h<K, V> newEntry = newEntry(k, i2, hVar);
                        setValue(newEntry, k, v, a2);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(c.i.d.b.h<K, V> hVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048611, this, hVar, i2)) == null) {
                lock();
                try {
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    c.i.d.b.h<K, V> hVar2 = atomicReferenceArray.get(length);
                    for (c.i.d.b.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                        if (hVar3 == hVar) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i2, hVar3.getValueReference().get(), hVar3.getValueReference(), RemovalCause.COLLECTED));
                            this.count--;
                            return true;
                        }
                    }
                    return false;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return invokeLI.booleanValue;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE]}, finally: {[INVOKE, INVOKE, INVOKE, IF] complete} */
        public boolean reclaimValue(K k, int i2, s<K, V> sVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048612, this, k, i2, sVar)) == null) {
                lock();
                try {
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    for (c.i.d.b.h<K, V> hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(k, key)) {
                            if (hVar2.getValueReference() == sVar) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeValueFromChain(hVar, hVar2, key, i2, sVar.get(), sVar, RemovalCause.COLLECTED));
                                this.count--;
                                return true;
                            }
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                    }
                    unlock();
                    if (!isHeldByCurrentThread()) {
                        postWriteCleanup();
                    }
                    return false;
                } finally {
                    unlock();
                    if (!isHeldByCurrentThread()) {
                        postWriteCleanup();
                    }
                }
            }
            return invokeLIL.booleanValue;
        }

        public void recordLockedRead(c.i.d.b.h<K, V> hVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048613, this, hVar, j2) == null) {
                if (this.map.C()) {
                    hVar.setAccessTime(j2);
                }
                this.accessQueue.add(hVar);
            }
        }

        public void recordRead(c.i.d.b.h<K, V> hVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048614, this, hVar, j2) == null) {
                if (this.map.C()) {
                    hVar.setAccessTime(j2);
                }
                this.recencyQueue.add(hVar);
            }
        }

        public void recordWrite(c.i.d.b.h<K, V> hVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{hVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                drainRecencyQueue();
                this.totalWeight += i2;
                if (this.map.C()) {
                    hVar.setAccessTime(j2);
                }
                if (this.map.E()) {
                    hVar.setWriteTime(j2);
                }
                this.accessQueue.add(hVar);
                this.writeQueue.add(hVar);
            }
        }

        public V refresh(K k, int i2, CacheLoader<? super K, V> cacheLoader, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{k, Integer.valueOf(i2), cacheLoader, Boolean.valueOf(z)})) == null) {
                k<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i2, z);
                if (insertLoadingValueReference == null) {
                    return null;
                }
                ListenableFuture<V> loadAsync = loadAsync(k, i2, insertLoadingValueReference, cacheLoader);
                if (loadAsync.isDone()) {
                    try {
                        return (V) Uninterruptibles.getUninterruptibly(loadAsync);
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            return (V) invokeCommon.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
            if (r12 == null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
            if (r9.isActive() == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
            r11.modCount++;
            r0.set(r1, removeValueFromChain(r4, r5, r6, r13, r12, r9, r10));
            r11.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
            return r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V remove(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048617, this, obj, i2)) == null) {
                lock();
                try {
                    preWriteCleanup(this.map.t.a());
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        if (hVar2 == null) {
                            break;
                        }
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(obj, key)) {
                            break;
                        }
                        hVar2 = hVar2.getNext();
                    }
                    return null;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return (V) invokeLI.objValue;
        }

        public void removeCollectedEntry(c.i.d.b.h<K, V> hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048619, this, hVar) == null) {
                enqueueNotification(hVar.getKey(), hVar.getHash(), hVar.getValueReference().get(), hVar.getValueReference().c(), RemovalCause.COLLECTED);
                this.writeQueue.remove(hVar);
                this.accessQueue.remove(hVar);
            }
        }

        public boolean removeEntry(c.i.d.b.h<K, V> hVar, int i2, RemovalCause removalCause) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048620, this, hVar, i2, removalCause)) == null) {
                AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                c.i.d.b.h<K, V> hVar2 = atomicReferenceArray.get(length);
                for (c.i.d.b.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                    if (hVar3 == hVar) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i2, hVar3.getValueReference().get(), hVar3.getValueReference(), removalCause));
                        this.count--;
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }

        public c.i.d.b.h<K, V> removeEntryFromChain(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, hVar, hVar2)) == null) {
                int i2 = this.count;
                c.i.d.b.h<K, V> next = hVar2.getNext();
                while (hVar != hVar2) {
                    c.i.d.b.h<K, V> copyEntry = copyEntry(hVar, next);
                    if (copyEntry != null) {
                        next = copyEntry;
                    } else {
                        removeCollectedEntry(hVar);
                        i2--;
                    }
                    hVar = hVar.getNext();
                }
                this.count = i2;
                return next;
            }
            return (c.i.d.b.h) invokeLL.objValue;
        }

        public boolean removeLoadingValue(K k, int i2, k<K, V> kVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048622, this, k, i2, kVar)) == null) {
                lock();
                try {
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        if (hVar2 == null) {
                            break;
                        }
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(k, key)) {
                            if (hVar2.getValueReference() == kVar) {
                                if (kVar.isActive()) {
                                    hVar2.setValueReference(kVar.i());
                                } else {
                                    atomicReferenceArray.set(length, removeEntryFromChain(hVar, hVar2));
                                }
                                return true;
                            }
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    }
                    return false;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return invokeLIL.booleanValue;
        }

        public c.i.d.b.h<K, V> removeValueFromChain(c.i.d.b.h<K, V> hVar, c.i.d.b.h<K, V> hVar2, K k, int i2, V v, s<K, V> sVar, RemovalCause removalCause) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{hVar, hVar2, k, Integer.valueOf(i2), v, sVar, removalCause})) == null) {
                enqueueNotification(k, i2, v, sVar.c(), removalCause);
                this.writeQueue.remove(hVar2);
                this.accessQueue.remove(hVar2);
                if (sVar.e()) {
                    sVar.b(null);
                    return hVar;
                }
                return removeEntryFromChain(hVar, hVar2);
            }
            return (c.i.d.b.h) invokeCommon.objValue;
        }

        public boolean replace(K k, int i2, V v, V v2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048625, this, k, i2, v, v2)) == null) {
                lock();
                try {
                    long a2 = this.map.t.a();
                    preWriteCleanup(a2);
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = i2 & (atomicReferenceArray.length() - 1);
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        if (hVar2 == null) {
                            break;
                        }
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null) {
                            if (this.map.f70657i.equivalent(k, key)) {
                                s<K, V> valueReference = hVar2.getValueReference();
                                V v3 = valueReference.get();
                                if (v3 == null) {
                                    if (valueReference.isActive()) {
                                        this.modCount++;
                                        atomicReferenceArray.set(length, removeValueFromChain(hVar, hVar2, key, i2, v3, valueReference, RemovalCause.COLLECTED));
                                        this.count--;
                                    }
                                } else if (this.map.f70658j.equivalent(v, v3)) {
                                    this.modCount++;
                                    enqueueNotification(k, i2, v3, valueReference.c(), RemovalCause.REPLACED);
                                    setValue(hVar2, k, v2, a2);
                                    evictEntries(hVar2);
                                    return true;
                                } else {
                                    recordLockedRead(hVar2, a2);
                                }
                            }
                        }
                        hVar2 = hVar2.getNext();
                    }
                    return false;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return invokeLILL.booleanValue;
        }

        public void runLockedCleanup(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048626, this, j2) == null) && tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j2);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || isHeldByCurrentThread()) {
                return;
            }
            this.map.z();
        }

        public V scheduleRefresh(c.i.d.b.h<K, V> hVar, K k, int i2, V v, long j2, CacheLoader<? super K, V> cacheLoader) {
            InterceptResult invokeCommon;
            V refresh;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{hVar, k, Integer.valueOf(i2), v, Long.valueOf(j2), cacheLoader})) == null) ? (!this.map.G() || j2 - hVar.getWriteTime() <= this.map.q || hVar.getValueReference().e() || (refresh = refresh(k, i2, cacheLoader, true)) == null) ? v : refresh : (V) invokeCommon.objValue;
        }

        public void setValue(c.i.d.b.h<K, V> hVar, K k, V v, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{hVar, k, v, Long.valueOf(j2)}) == null) {
                s<K, V> valueReference = hVar.getValueReference();
                int weigh = this.map.n.weigh(k, v);
                c.i.d.a.n.x(weigh >= 0, "Weights must be non-negative");
                hVar.setValueReference(this.map.l.referenceValue(this, hVar, v, weigh));
                recordWrite(hVar, weigh, j2);
                valueReference.b(v);
            }
        }

        public boolean storeLoadedValue(K k, int i2, k<K, V> kVar, V v) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048630, this, k, i2, kVar, v)) == null) {
                lock();
                try {
                    long a2 = this.map.t.a();
                    preWriteCleanup(a2);
                    int i3 = this.count + 1;
                    if (i3 > this.threshold) {
                        expand();
                        i3 = this.count + 1;
                    }
                    int i4 = i3;
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = i2 & (atomicReferenceArray.length() - 1);
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        if (hVar2 != null) {
                            K key = hVar2.getKey();
                            if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(k, key)) {
                                s<K, V> valueReference = hVar2.getValueReference();
                                V v2 = valueReference.get();
                                if (kVar != valueReference && (v2 != null || valueReference == LocalCache.B)) {
                                    enqueueNotification(k, i2, v, 0, RemovalCause.REPLACED);
                                    return false;
                                }
                                this.modCount++;
                                if (kVar.isActive()) {
                                    enqueueNotification(k, i2, v2, kVar.c(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                    i4--;
                                }
                                setValue(hVar2, k, v, a2);
                                this.count = i4;
                                evictEntries(hVar2);
                            } else {
                                hVar2 = hVar2.getNext();
                            }
                        } else {
                            this.modCount++;
                            c.i.d.b.h<K, V> newEntry = newEntry(k, i2, hVar);
                            setValue(newEntry, k, v, a2);
                            atomicReferenceArray.set(length, newEntry);
                            this.count = i4;
                            evictEntries(newEntry);
                            break;
                        }
                    }
                    return true;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return invokeLILL.booleanValue;
        }

        public void tryDrainReferenceQueues() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048632, this, j2) == null) && tryLock()) {
                try {
                    expireEntries(j2);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(c.i.d.b.h<K, V> hVar, K k, s<K, V> sVar) throws ExecutionException {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048633, this, hVar, k, sVar)) == null) {
                if (sVar.e()) {
                    c.i.d.a.n.A(!Thread.holdsLock(hVar), "Recursive load of: %s", k);
                    try {
                        V d2 = sVar.d();
                        if (d2 != null) {
                            recordRead(hVar, this.map.t.a());
                            return d2;
                        }
                        throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                    } finally {
                        this.statsCounter.d(1);
                    }
                }
                throw new AssertionError();
            }
            return (V) invokeLLL.objValue;
        }

        public V get(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, obj, i2)) == null) {
                try {
                    if (this.count != 0) {
                        long a2 = this.map.t.a();
                        c.i.d.b.h<K, V> liveEntry = getLiveEntry(obj, i2, a2);
                        if (liveEntry == null) {
                            return null;
                        }
                        V v = liveEntry.getValueReference().get();
                        if (v != null) {
                            recordRead(liveEntry, a2);
                            return scheduleRefresh(liveEntry, liveEntry.getKey(), i2, v, a2, this.map.w);
                        }
                        tryDrainReferenceQueues();
                    }
                    return null;
                } finally {
                    postReadCleanup();
                }
            }
            return (V) invokeLI.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
            if (r12.map.f70658j.equivalent(r15, r9) == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
            if (r9 != null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
            if (r10.isActive() == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
            r12.modCount++;
            r0.set(r1, removeValueFromChain(r5, r6, r7, r14, r9, r10, r13));
            r12.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(Object obj, int i2, Object obj2) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048618, this, obj, i2, obj2)) == null) {
                lock();
                try {
                    preWriteCleanup(this.map.t.a());
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    boolean z = true;
                    int length = (atomicReferenceArray.length() - 1) & i2;
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        if (hVar2 == null) {
                            break;
                        }
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null && this.map.f70657i.equivalent(obj, key)) {
                            break;
                        }
                        hVar2 = hVar2.getNext();
                    }
                    return false;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return invokeLIL.booleanValue;
        }

        public V replace(K k, int i2, V v) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048624, this, k, i2, v)) == null) {
                lock();
                try {
                    long a2 = this.map.t.a();
                    preWriteCleanup(a2);
                    AtomicReferenceArray<c.i.d.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = i2 & (atomicReferenceArray.length() - 1);
                    c.i.d.b.h<K, V> hVar = atomicReferenceArray.get(length);
                    c.i.d.b.h<K, V> hVar2 = hVar;
                    while (true) {
                        if (hVar2 == null) {
                            break;
                        }
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i2 && key != null) {
                            if (this.map.f70657i.equivalent(k, key)) {
                                s<K, V> valueReference = hVar2.getValueReference();
                                V v2 = valueReference.get();
                                if (v2 == null) {
                                    if (valueReference.isActive()) {
                                        this.modCount++;
                                        atomicReferenceArray.set(length, removeValueFromChain(hVar, hVar2, key, i2, v2, valueReference, RemovalCause.COLLECTED));
                                        this.count--;
                                    }
                                } else {
                                    this.modCount++;
                                    enqueueNotification(k, i2, v2, valueReference.c(), RemovalCause.REPLACED);
                                    setValue(hVar2, k, v, a2);
                                    evictEntries(hVar2);
                                    return v2;
                                }
                            }
                        }
                        hVar2 = hVar2.getNext();
                    }
                    return null;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
            return (V) invokeLIL.objValue;
        }
    }
}
