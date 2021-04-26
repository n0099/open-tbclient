package kotlin.collections.builders;

import androidx.lifecycle.SavedStateHandle;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u0089\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u0004:\f\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\n\b\u0016¢\u0006\u0005\b\u0086\u0001\u0010\u0012B\u0013\b\u0016\u0012\u0007\u0010\u0087\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0086\u0001\u0010*BJ\b\u0002\u0012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u000f\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n\u0012\u0006\u0010z\u001a\u00020h\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010y\u001a\u00020\u0006\u0012\u0006\u0010x\u001a\u00020\u0006¢\u0006\u0006\b\u0086\u0001\u0010\u0088\u0001J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00182\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010 \u001a\u00020\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0004\b$\u0010\"J\u001f\u0010&\u001a\u00020\u00182\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010*J\u001b\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-H\u0000¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u000101H\u0096\u0002¢\u0006\u0004\b2\u0010\"J\u0017\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b3\u0010\bJ\u0017\u00104\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u0001H\u0002¢\u0006\u0004\b4\u0010\bJ\u001a\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b7\u0010\bJ\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0018H\u0016¢\u0006\u0004\b:\u0010;J\u001b\u0010?\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<H\u0000¢\u0006\u0004\b=\u0010>J!\u0010@\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0004\b@\u0010AJ%\u0010C\u001a\u00020\u00102\u0014\u0010B\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\bC\u0010DJ)\u0010E\u001a\u00020\u00182\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c0\u0016H\u0002¢\u0006\u0004\bE\u0010\u001aJ#\u0010F\u001a\u00020\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002¢\u0006\u0004\bF\u0010\u001fJ\u0017\u0010H\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010*J\u0019\u0010L\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\bL\u00106J#\u0010N\u001a\u00020\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0000¢\u0006\u0004\bM\u0010\u001fJ\u0017\u0010P\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010*J\u0017\u0010R\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0000¢\u0006\u0004\bQ\u0010\bJ\u0017\u0010T\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u0010*J\u0017\u0010W\u001a\u00020\u00182\u0006\u0010U\u001a\u00028\u0001H\u0000¢\u0006\u0004\bV\u0010\"J\u000f\u0010Y\u001a\u00020XH\u0016¢\u0006\u0004\bY\u0010ZJ\u001b\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010[H\u0000¢\u0006\u0004\b\\\u0010]R\u0016\u0010(\u001a\u00020\u00068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u00109R(\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010a0`8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR$\u0010f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020\u00068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u00109R\u0016\u0010o\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00028\u00000`8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010cR\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u001e\u0010v\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010lR\u0016\u0010y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010lR\u0016\u0010z\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010jR$\u0010|\u001a\u00020\u00062\u0006\u0010{\u001a\u00020\u00068\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b|\u0010l\u001a\u0004\b}\u00109R\u001e\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010~8V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010tR\"\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u008f\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "Ljava/util/Map;", "Lkotlin/jvm/internal/markers/KMutableMap;", "key", "", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "addKey", "", "allocateValuesArray", "()[Ljava/lang/Object;", "", "build", "()Ljava/util/Map;", "", "checkIsMutable$kotlin_stdlib", "()V", "checkIsMutable", "clear", "compact", "", "m", "", "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "containsAllEntries", "", "entry", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "other", "contentEquals", "(Ljava/util/Map;)Z", "capacity", "ensureCapacity", "(I)V", "n", "ensureExtraCapacity", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator", "", "equals", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "()I", "isEmpty", "()Z", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "from", "putAll", "(Ljava/util/Map;)V", "putAllEntries", "putEntry", "i", "putRehash", "(I)Z", "newHashSize", "rehash", "remove", "removeEntry$kotlin_stdlib", "removeEntry", "removedHash", "removeHashAt", "removeKey$kotlin_stdlib", "removeKey", "index", "removeKeyAt", "element", "removeValue$kotlin_stdlib", "removeValue", "", "toString", "()Ljava/lang/String;", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator", "getCapacity", "", "", "getEntries", "()Ljava/util/Set;", "entries", "Lkotlin/collections/builders/MapBuilderEntries;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "", "hashArray", "[I", "hashShift", "I", "getHashSize", "hashSize", "isReadOnly", "Z", "getKeys", SavedStateHandle.KEYS, "keysArray", "[Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilderKeys;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", CloudStabilityUBCUtils.KEY_LENGTH, "maxProbeDistance", "presenceArray", "<set-?>", "size", "getSize", "", "getValues", "()Ljava/util/Collection;", SavedStateHandle.VALUES, "valuesArray", "Lkotlin/collections/builders/MapBuilderValues;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "<init>", "initialCapacity", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class MapBuilder<K, V> implements Map<K, V>, KMutableMap {
    public static final Companion Companion = new Companion(null);
    public static final int INITIAL_CAPACITY = 8;
    public static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    public static final int MAGIC = -1640531527;
    public static final int TOMBSTONE = -1;
    public MapBuilderEntries<K, V> entriesView;
    public int[] hashArray;
    public int hashShift;
    public boolean isReadOnly;
    public K[] keysArray;
    public MapBuilderKeys<K> keysView;
    public int length;
    public int maxProbeDistance;
    public int[] presenceArray;
    public int size;
    public V[] valuesArray;
    public MapBuilderValues<V> valuesView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0082\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "capacity", "computeHashSize", "(I)I", "hashSize", "computeShift", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeHashSize(int i2) {
            return Integer.highestOneBit(RangesKt___RangesKt.coerceAtLeast(i2, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeShift(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001b\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMutableIterator;", "kotlin/collections/builders/MapBuilder$Itr", "Lkotlin/collections/builders/MapBuilder$EntryRef;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Lkotlin/collections/builders/MapBuilder$EntryRef;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "nextAppendString", "(Ljava/lang/StringBuilder;)V", "", "nextHashCode$kotlin_stdlib", "()I", "nextHashCode", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().keysArray[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj, getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append(a.f1873h);
                Object[] objArr = getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj2, getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                initNext$kotlin_stdlib();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().keysArray[getLastIndex$kotlin_stdlib()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                initNext$kotlin_stdlib();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u00032\u00020\u0004B#\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0018\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00028\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00028\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016¨\u0006\u001f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "java/util/Map$Entry", "kotlin/jvm/internal/markers/KMutableMap$Entry", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "index", "I", "getKey", "()Ljava/lang/Object;", "key", "Lkotlin/collections/builders/MapBuilder;", "map", "Lkotlin/collections/builders/MapBuilder;", "getValue", "value", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final int index;
        public final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> map, int i2) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.map.keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.map.valuesArray;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.map.allocateValuesArray();
            int i2 = this.index;
            V v2 = (V) allocateValuesArray[i2];
            allocateValuesArray[i2] = v;
            return v2;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: K : 0x0005: INVOKE  (r1v0 K A[REMOVE]) = (r2v0 'this' kotlin.collections.builders.MapBuilder$EntryRef<K, V> A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: kotlin.collections.builders.MapBuilder.EntryRef.getKey():java.lang.Object), (wrap: char : ?: SGET   com.alipay.sdk.encrypt.a.h char), (wrap: V : 0x0011: INVOKE  (r1v2 V A[REMOVE]) = (r2v0 'this' kotlin.collections.builders.MapBuilder$EntryRef<K, V> A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: kotlin.collections.builders.MapBuilder.EntryRef.getValue():java.lang.Object)] */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append(a.f1873h);
            sb.append(getValue());
            return sb.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u0002B\u001b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bR\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00158\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "hasNext", "()Z", "", "initNext$kotlin_stdlib", "()V", "initNext", "remove", "", "index", "I", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "Lkotlin/collections/builders/MapBuilder;", "map", "Lkotlin/collections/builders/MapBuilder;", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static class Itr<K, V> {
        public int index;
        public int lastIndex;
        public final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            return this.index < this.map.length;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < this.map.length) {
                int[] iArr = this.map.presenceArray;
                int i2 = this.index;
                if (iArr[i2] >= 0) {
                    return;
                }
                this.index = i2 + 1;
            }
        }

        public final void remove() {
            this.map.checkIsMutable$kotlin_stdlib();
            this.map.removeKeyAt(this.lastIndex);
            this.lastIndex = -1;
        }

        public final void setIndex$kotlin_stdlib(int i2) {
            this.index = i2;
        }

        public final void setLastIndex$kotlin_stdlib(int i2) {
            this.lastIndex = i2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMutableIterator;", "kotlin/collections/builders/MapBuilder$Itr", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                K k = (K) getMap$kotlin_stdlib().keysArray[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMutableIterator;", "kotlin/collections/builders/MapBuilder$Itr", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object[] objArr = getMap$kotlin_stdlib().valuesArray;
                Intrinsics.checkNotNull(objArr);
                V v = (V) objArr[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    public MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i2;
        this.length = i3;
        this.hashShift = Companion.computeShift(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i2;
        V[] vArr = this.valuesArray;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.length;
            if (i3 >= i2) {
                break;
            }
            if (this.presenceArray[i3] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        ListBuilderKt.resetRange(this.keysArray, i4, i2);
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, i4, this.length);
        }
        this.length = i4;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i2) {
        if (i2 > getCapacity()) {
            int capacity = (getCapacity() * 3) / 2;
            if (i2 <= capacity) {
                i2 = capacity;
            }
            this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, i2);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) ListBuilderKt.copyOfUninitializedElements(vArr, i2) : null;
            int[] copyOf = Arrays.copyOf(this.presenceArray, i2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.presenceArray = copyOf;
            int computeHashSize = Companion.computeHashSize(i2);
            if (computeHashSize > getHashSize()) {
                rehash(computeHashSize);
            }
        } else if ((this.length + i2) - size() > getCapacity()) {
            rehash(getHashSize());
        }
    }

    private final void ensureExtraCapacity(int i2) {
        ensureCapacity(this.length + i2);
    }

    private final int findKey(K k) {
        int hash = hash(k);
        int i2 = this.maxProbeDistance;
        while (true) {
            int i3 = this.hashArray[hash];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (Intrinsics.areEqual(this.keysArray[i4], k)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v) {
        int i2 = this.length;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.presenceArray[i2] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (putEntry(entry)) {
                z = true;
            }
        }
        return z;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i2 = (-addKey$kotlin_stdlib) - 1;
        if (!Intrinsics.areEqual(entry.getValue(), allocateValuesArray[i2])) {
            allocateValuesArray[i2] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean putRehash(int i2) {
        int hash = hash(this.keysArray[i2]);
        int i3 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i2 + 1;
                this.presenceArray[i2] = hash;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i2) {
        if (this.length > size()) {
            compact();
        }
        int i3 = 0;
        if (i2 != getHashSize()) {
            this.hashArray = new int[i2];
            this.hashShift = Companion.computeShift(i2);
        } else {
            ArraysKt___ArraysJvmKt.fill(this.hashArray, 0, 0, getHashSize());
        }
        while (i3 < this.length) {
            int i4 = i3 + 1;
            if (!putRehash(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    private final void removeHashAt(int i2) {
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int i3 = 0;
        int i4 = i2;
        do {
            i2 = i2 == 0 ? getHashSize() - 1 : i2 - 1;
            i3++;
            if (i3 > this.maxProbeDistance) {
                this.hashArray[i4] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i5 = iArr[i2];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((hash(this.keysArray[i6]) - i2) & (getHashSize() - 1)) >= i3) {
                    this.hashArray[i4] = i5;
                    this.presenceArray[i6] = i4;
                }
                coerceAtMost--;
            }
            i4 = i2;
            i3 = 0;
            coerceAtMost--;
        } while (coerceAtMost >= 0);
        this.hashArray[i4] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i2) {
        ListBuilderKt.resetAt(this.keysArray, i2);
        removeHashAt(this.presenceArray[i2]);
        this.presenceArray[i2] = -1;
        this.size = size() - 1;
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k);
            int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.hashArray[hash];
                if (i3 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i4 = this.length;
                        int i5 = i4 + 1;
                        this.length = i5;
                        this.keysArray[i4] = k;
                        this.presenceArray[i4] = hash;
                        this.hashArray[hash] = i5;
                        this.size = size() + 1;
                        if (i2 > this.maxProbeDistance) {
                            this.maxProbeDistance = i2;
                        }
                        return i4;
                    }
                } else if (Intrinsics.areEqual(this.keysArray[i3 - 1], k)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > coerceAtMost) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i2 = this.length - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.hashArray[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[findKey], entry.getValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[findKey];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries == null) {
            MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
            this.entriesView = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys == null) {
            MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
            this.keysView = mapBuilderKeys2;
            return mapBuilderKeys2;
        }
        return mapBuilderKeys;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues == null) {
            MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
            this.valuesView = mapBuilderValues2;
            return mapBuilderValues2;
        }
        return mapBuilderValues;
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i2 += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i2 = (-addKey$kotlin_stdlib) - 1;
            V v2 = allocateValuesArray[i2];
            allocateValuesArray[i2] = v;
            return v2;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual(vArr[findKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append(StringUtil.ARRAY_START);
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i2 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb);
            i2++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i2) {
        this(ListBuilderKt.arrayOfUninitializedElements(i2), null, new int[i2], new int[Companion.computeHashSize(i2)], 2, 0);
    }
}
