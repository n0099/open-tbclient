package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.internal.Symbol;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*:\u0003&'(B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u000eR&\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "weakRefQueue", "<init>", "(Z)V", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", DownloadStatisticConstants.UBC_VALUE_CLEAR, "()V", "decrementSize", "key", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", SavedStateHandle.KEYS, "", "getSize", "()I", "size", "Ljava/lang/ref/ReferenceQueue;", "Ljava/lang/ref/ReferenceQueue;", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core", "Lkotlin/collections/AbstractMutableMap;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    public volatile /* synthetic */ int _size;
    public volatile /* synthetic */ Object core;
    public final ReferenceQueue<K> weakRefQueue;

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0018:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u0013\"\u0004\b\u0002\u0010\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010 R\u0014\u0010!\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakRef", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "key", "getImpl", "(Ljava/lang/Object;)Ljava/lang/Object;", SapiOptions.KEY_CACHE_MODULE_HASH, "index", "(I)I", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function2;", "factory", "", "keyValueIterator", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "value", "weakKey0", "", "putImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "rehash", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "removeCleanedAt", "(I)V", "I", "shift", "threshold", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class Core {
        public static final /* synthetic */ AtomicIntegerFieldUpdater load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        public final int allocated;
        public /* synthetic */ AtomicReferenceArray keys;
        public volatile /* synthetic */ int load = 0;
        public final int shift;
        public final int threshold;
        public /* synthetic */ AtomicReferenceArray values;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00028\u0001X\u0082.¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", ExifInterface.LONGITUDE_EAST, "", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", "", "key", "Ljava/lang/Object;", "value", "findNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            public final Function2<K, V, E> factory;
            public int index = -1;
            public K key;
            public V value;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> */
            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(Function2<? super K, ? super V, ? extends E> function2) {
                this.factory = function2;
                findNext();
            }

            private final void findNext() {
                K k;
                while (true) {
                    int i = this.index + 1;
                    this.index = i;
                    if (i < Core.this.allocated) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.keys.get(this.index);
                        if (hashedWeakRef == null) {
                            k = null;
                        } else {
                            k = (K) hashedWeakRef.get();
                        }
                        if (k != null) {
                            this.key = k;
                            V v = (V) Core.this.values.get(this.index);
                            if (v instanceof Marked) {
                                v = (V) ((Marked) v).ref;
                            }
                            if (v != null) {
                                this.value = v;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < Core.this.allocated) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index < Core.this.allocated) {
                    Function2<K, V, E> function2 = this.factory;
                    K k = this.key;
                    if (k == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("key");
                        k = (K) Unit.INSTANCE;
                    }
                    V v = this.value;
                    if (v == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("value");
                        v = (V) Unit.INSTANCE;
                    }
                    E invoke = function2.invoke(k, v);
                    findNext();
                    return invoke;
                }
                throw new NoSuchElementException();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            public Void remove() {
                ConcurrentWeakMapKt.noImpl();
                throw new KotlinNothingValueException();
            }
        }

        public Core(int i) {
            this.allocated = i;
            this.shift = Integer.numberOfLeadingZeros(i) + 1;
            this.threshold = (this.allocated * 2) / 3;
            this.keys = new AtomicReferenceArray(this.allocated);
            this.values = new AtomicReferenceArray(this.allocated);
        }

        private final int index(int i) {
            return (i * (-1640531527)) >>> this.shift;
        }

        private final void removeCleanedAt(int i) {
            Object obj;
            do {
                obj = this.values.get(i);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!this.values.compareAndSet(i, obj, null));
            ConcurrentWeakMap.this.decrementSize();
        }

        public final void cleanWeakRef(HashedWeakRef<?> hashedWeakRef) {
            int index = index(hashedWeakRef.hash);
            while (true) {
                HashedWeakRef<?> hashedWeakRef2 = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef2 == null) {
                    return;
                }
                if (hashedWeakRef2 == hashedWeakRef) {
                    removeCleanedAt(index);
                    return;
                }
                if (index == 0) {
                    index = this.allocated;
                }
                index--;
            }
        }

        public final <E> Iterator<E> keyValueIterator(Function2<? super K, ? super V, ? extends E> function2) {
            return new KeyValueIterator(function2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$Core */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object putImpl$default(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i, Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.putImpl(obj, obj2, hashedWeakRef);
        }

        public final V getImpl(K k) {
            int index = index(k.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t = hashedWeakRef.get();
                if (Intrinsics.areEqual(k, t)) {
                    V v = (V) this.values.get(index);
                    if (v instanceof Marked) {
                        return (V) ((Marked) v).ref;
                    }
                    return v;
                }
                if (t == 0) {
                    removeCleanedAt(index);
                }
                if (index == 0) {
                    index = this.allocated;
                }
                index--;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
            r6 = r5.values.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
            if ((r6 instanceof kotlinx.coroutines.debug.internal.Marked) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
            r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.REHASH;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r5.values.compareAndSet(r0, r6, r7) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
            return r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object putImpl(K k, V v, HashedWeakRef<K> hashedWeakRef) {
            int i;
            Symbol symbol;
            int index = index(k.hashCode());
            boolean z = false;
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef2 == null) {
                    if (v == null) {
                        return null;
                    }
                    if (!z) {
                        do {
                            i = this.load;
                            if (i >= this.threshold) {
                                symbol = ConcurrentWeakMapKt.REHASH;
                                return symbol;
                            }
                        } while (!load$FU.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (hashedWeakRef == null) {
                        hashedWeakRef = new HashedWeakRef<>(k, ConcurrentWeakMap.this.weakRefQueue);
                    }
                    if (this.keys.compareAndSet(index, null, hashedWeakRef)) {
                        break;
                    }
                } else {
                    T t = hashedWeakRef2.get();
                    if (Intrinsics.areEqual(k, t)) {
                        if (z) {
                            load$FU.decrementAndGet(this);
                        }
                    } else {
                        if (t == 0) {
                            removeCleanedAt(index);
                        }
                        if (index == 0) {
                            index = this.allocated;
                        }
                        index--;
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V>$Core */
        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.Core rehash() {
            Object obj;
            Object obj2;
            Symbol symbol;
            boolean z;
            Marked mark;
            while (true) {
                ConcurrentWeakMap<K, V>.Core core = (ConcurrentWeakMap<K, V>.Core) new Core(Integer.highestOneBit(RangesKt___RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = this.allocated;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(i2);
                    if (hashedWeakRef == null) {
                        obj = null;
                    } else {
                        obj = hashedWeakRef.get();
                    }
                    if (hashedWeakRef != null && obj == null) {
                        removeCleanedAt(i2);
                    }
                    while (true) {
                        obj2 = this.values.get(i2);
                        if (obj2 instanceof Marked) {
                            obj2 = ((Marked) obj2).ref;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.values;
                        mark = ConcurrentWeakMapKt.mark(obj2);
                        if (atomicReferenceArray.compareAndSet(i2, obj2, mark)) {
                            break;
                        }
                    }
                    if (obj != null && obj2 != null) {
                        Object putImpl = core.putImpl(obj, obj2, hashedWeakRef);
                        symbol = ConcurrentWeakMapKt.REHASH;
                        if (putImpl == symbol) {
                            break;
                        }
                        if (putImpl == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (_Assertions.ENABLED && !z) {
                            throw new AssertionError("Assertion failed");
                        }
                    }
                    i2 = i3;
                }
                return core;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final K key;
        public final V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class KeyValueSet<E> extends AbstractMutableSet<E> {
        public final Function2<K, V, E> factory;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> */
        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(Function2<? super K, ? super V, ? extends E> function2) {
            this.factory = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.this.core).keyValueIterator(this.factory);
        }
    }

    public ConcurrentWeakMap(boolean z) {
        ReferenceQueue<K> referenceQueue;
        this._size = 0;
        this.core = new Core(16);
        if (z) {
            referenceQueue = new ReferenceQueue<>();
        } else {
            referenceQueue = null;
        }
        this.weakRefQueue = referenceQueue;
    }

    private final void cleanWeakRef(HashedWeakRef<?> hashedWeakRef) {
        ((Core) this.core).cleanWeakRef(hashedWeakRef);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((Core) this.core).getImpl(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Symbol symbol;
        if (obj == 0) {
            return null;
        }
        V v = (V) Core.putImpl$default((Core) this.core, obj, null, null, 4, null);
        symbol = ConcurrentWeakMapKt.REHASH;
        if (v == symbol) {
            v = putSynchronized(obj, null);
        }
        if (v != null) {
            _size$FU.decrementAndGet(this);
        }
        return v;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k : keySet()) {
            remove(k);
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new KeyValueSet(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Map.Entry<K, V> invoke(K k, V v) {
                return new ConcurrentWeakMap.Entry(k, v);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new KeyValueSet(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            public final K invoke(K k, V v) {
                return k;
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this._size;
    }

    private final synchronized V putSynchronized(K k, V v) {
        V v2;
        Symbol symbol;
        Core core = (Core) this.core;
        while (true) {
            v2 = (V) Core.putImpl$default(core, k, v, null, 4, null);
            symbol = ConcurrentWeakMapKt.REHASH;
            if (v2 == symbol) {
                core = core.rehash();
                this.core = core;
            }
        }
        return v2;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Symbol symbol;
        V v2 = (V) Core.putImpl$default((Core) this.core, k, v, null, 4, null);
        symbol = ConcurrentWeakMapKt.REHASH;
        if (v2 == symbol) {
            v2 = putSynchronized(k, v);
        }
        if (v2 == null) {
            _size$FU.incrementAndGet(this);
        }
        return v2;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        boolean z;
        if (this.weakRefQueue != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            while (true) {
                try {
                    Reference<? extends K> remove = this.weakRefQueue.remove();
                    if (remove == null) {
                        break;
                    }
                    cleanWeakRef((HashedWeakRef) remove);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }
}
