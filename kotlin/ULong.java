package kotlin;

import com.baidu.tbadk.browser.SearchJsBridge;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\u0087\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\u0087\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\u0087\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", TtmlNode.TAG_DIV, "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", SearchJsBridge.COOKIE_MOD, "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes10.dex */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    public final long data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m1012boximpl(long j) {
        return new ULong(j);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1018constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1024equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m1069unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1025equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1030hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m1057toByteimpl(long j) {
        return (byte) j;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m1060toIntimpl(long j) {
        return (int) j;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m1061toLongimpl(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m1062toShortimpl(long j) {
        return (short) j;
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m1066toULongsVKNKU(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m1024equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m1030hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1069unboximpl() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.ULong.box-impl(long):kotlin.ULong] */
    @PublishedApi
    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m1014compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(m1069unboximpl(), j);
    }

    @InlineOnly
    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    public static final long m1019decsVKNKU(long j) {
        return m1018constructorimpl(j - 1);
    }

    @InlineOnly
    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    public static final long m1031incsVKNKU(long j) {
        return m1018constructorimpl(j + 1);
    }

    @InlineOnly
    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    public static final long m1032invsVKNKU(long j) {
        return m1018constructorimpl(~j);
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m1058toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m1059toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1063toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m1064toUBytew2LRezQ(long j) {
        return UByte.m864constructorimpl((byte) j);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m1065toUIntpVg5ArA(long j) {
        return UInt.m940constructorimpl((int) j);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m1067toUShortMh2AYeg(long j) {
        return UShort.m1124constructorimpl((short) j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(m1069unboximpl(), uLong.m1069unboximpl());
    }

    @InlineOnly
    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    public static final long m1011andVKZWuLQ(long j, long j2) {
        return m1018constructorimpl(j & j2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m1013compareTo7apg3OU(long j, byte b) {
        return UnsignedKt.ulongCompare(j, m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static int m1015compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m1016compareToWZ4Q5Ns(long j, int i) {
        return UnsignedKt.ulongCompare(j, m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m1017compareToxj2QHRw(long j, short s) {
        return UnsignedKt.ulongCompare(j, m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final long m1020div7apg3OU(long j, byte b) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m1021divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, j2);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final long m1022divWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final long m1023divxj2QHRw(long j, short s) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    public static final long m1026floorDiv7apg3OU(long j, byte b) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    public static final long m1027floorDivVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, j2);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    public static final long m1028floorDivWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    public static final long m1029floorDivxj2QHRw(long j, short s) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(j, m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final long m1033minus7apg3OU(long j, byte b) {
        return m1018constructorimpl(j - m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m1034minusVKZWuLQ(long j, long j2) {
        return m1018constructorimpl(j - j2);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final long m1035minusWZ4Q5Ns(long j, int i) {
        return m1018constructorimpl(j - m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final long m1036minusxj2QHRw(long j, short s) {
        return m1018constructorimpl(j - m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    public static final byte m1037mod7apg3OU(long j, byte b) {
        return UByte.m864constructorimpl((byte) UnsignedKt.m1196ulongRemaindereb3DHEI(j, m1018constructorimpl(b & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    public static final long m1038modVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(j, j2);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    public static final int m1039modWZ4Q5Ns(long j, int i) {
        return UInt.m940constructorimpl((int) UnsignedKt.m1196ulongRemaindereb3DHEI(j, m1018constructorimpl(i & 4294967295L)));
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    public static final short m1040modxj2QHRw(long j, short s) {
        return UShort.m1124constructorimpl((short) UnsignedKt.m1196ulongRemaindereb3DHEI(j, m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    @InlineOnly
    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    public static final long m1041orVKZWuLQ(long j, long j2) {
        return m1018constructorimpl(j | j2);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final long m1042plus7apg3OU(long j, byte b) {
        return m1018constructorimpl(j + m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m1043plusVKZWuLQ(long j, long j2) {
        return m1018constructorimpl(j + j2);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final long m1044plusWZ4Q5Ns(long j, int i) {
        return m1018constructorimpl(j + m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final long m1045plusxj2QHRw(long j, short s) {
        return m1018constructorimpl(j + m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    public static final ULongRange m1046rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final long m1047rem7apg3OU(long j, byte b) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(j, m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m1048remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(j, j2);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final long m1049remWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(j, m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final long m1050remxj2QHRw(long j, short s) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(j, m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    public static final long m1051shlsVKNKU(long j, int i) {
        return m1018constructorimpl(j << i);
    }

    @InlineOnly
    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    public static final long m1052shrsVKNKU(long j, int i) {
        return m1018constructorimpl(j >>> i);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final long m1053times7apg3OU(long j, byte b) {
        return m1018constructorimpl(j * m1018constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m1054timesVKZWuLQ(long j, long j2) {
        return m1018constructorimpl(j * j2);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final long m1055timesWZ4Q5Ns(long j, int i) {
        return m1018constructorimpl(j * m1018constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final long m1056timesxj2QHRw(long j, short s) {
        return m1018constructorimpl(j * m1018constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    public static final long m1068xorVKZWuLQ(long j, long j2) {
        return m1018constructorimpl(j ^ j2);
    }

    public String toString() {
        return m1063toStringimpl(this.data);
    }
}
