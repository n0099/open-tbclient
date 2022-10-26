package kotlin;

import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\u0087\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\u0087\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\u0087\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", ImageViewerConfig.FROM_OTHER, "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", TtmlNode.TAG_DIV, "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", SearchJsBridge.COOKIE_MOD, "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@JvmInline
/* loaded from: classes8.dex */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    public final long data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m864boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m870constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m876equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m921unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m877equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m882hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m909toByteimpl(long j) {
        return (byte) j;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m912toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m913toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m914toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m918toULongsVKNKU(long j) {
        return j;
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m921unboximpl() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.ULong.box-impl(long):kotlin.ULong] */
    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m866compareToVKZWuLQ(long j) {
        return m867compareToVKZWuLQ(this.data, j);
    }

    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    public static final long m871decsVKNKU(long j) {
        return m870constructorimpl(j - 1);
    }

    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    public static final long m883incsVKNKU(long j) {
        return m870constructorimpl(j + 1);
    }

    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    public static final long m884invsVKNKU(long j) {
        return m870constructorimpl(~j);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m910toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m911toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m915toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m916toUBytew2LRezQ(long j) {
        return UByte.m716constructorimpl((byte) j);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m917toUIntpVg5ArA(long j) {
        return UInt.m792constructorimpl((int) j);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m919toUShortMh2AYeg(long j) {
        return UShort.m976constructorimpl((short) j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return m866compareToVKZWuLQ(uLong.m921unboximpl());
    }

    public boolean equals(Object obj) {
        return m876equalsimpl(this.data, obj);
    }

    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    public static final long m863andVKZWuLQ(long j, long j2) {
        return m870constructorimpl(j & j2);
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m865compareTo7apg3OU(long j, byte b) {
        return UnsignedKt.ulongCompare(j, m870constructorimpl(b & 255));
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static int m867compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m868compareToWZ4Q5Ns(long j, int i) {
        return UnsignedKt.ulongCompare(j, m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m869compareToxj2QHRw(long j, short s) {
        return UnsignedKt.ulongCompare(j, m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final long m872div7apg3OU(long j, byte b) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, m870constructorimpl(b & 255));
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m873divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final long m874divWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final long m875divxj2QHRw(long j, short s) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    public static final long m878floorDiv7apg3OU(long j, byte b) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, m870constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    public static final long m879floorDivVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    public static final long m880floorDivWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    public static final long m881floorDivxj2QHRw(long j, short s) {
        return UnsignedKt.m1047ulongDivideeb3DHEI(j, m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final long m885minus7apg3OU(long j, byte b) {
        return m870constructorimpl(j - m870constructorimpl(b & 255));
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m886minusVKZWuLQ(long j, long j2) {
        return m870constructorimpl(j - j2);
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final long m887minusWZ4Q5Ns(long j, int i) {
        return m870constructorimpl(j - m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final long m888minusxj2QHRw(long j, short s) {
        return m870constructorimpl(j - m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    public static final byte m889mod7apg3OU(long j, byte b) {
        return UByte.m716constructorimpl((byte) UnsignedKt.m1048ulongRemaindereb3DHEI(j, m870constructorimpl(b & 255)));
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    public static final long m890modVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1048ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    public static final int m891modWZ4Q5Ns(long j, int i) {
        return UInt.m792constructorimpl((int) UnsignedKt.m1048ulongRemaindereb3DHEI(j, m870constructorimpl(i & 4294967295L)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    public static final short m892modxj2QHRw(long j, short s) {
        return UShort.m976constructorimpl((short) UnsignedKt.m1048ulongRemaindereb3DHEI(j, m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    public static final long m893orVKZWuLQ(long j, long j2) {
        return m870constructorimpl(j | j2);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final long m894plus7apg3OU(long j, byte b) {
        return m870constructorimpl(j + m870constructorimpl(b & 255));
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m895plusVKZWuLQ(long j, long j2) {
        return m870constructorimpl(j + j2);
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final long m896plusWZ4Q5Ns(long j, int i) {
        return m870constructorimpl(j + m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final long m897plusxj2QHRw(long j, short s) {
        return m870constructorimpl(j + m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    public static final ULongRange m898rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final long m899rem7apg3OU(long j, byte b) {
        return UnsignedKt.m1048ulongRemaindereb3DHEI(j, m870constructorimpl(b & 255));
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m900remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m1048ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final long m901remWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m1048ulongRemaindereb3DHEI(j, m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final long m902remxj2QHRw(long j, short s) {
        return UnsignedKt.m1048ulongRemaindereb3DHEI(j, m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    public static final long m903shlsVKNKU(long j, int i) {
        return m870constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    public static final long m904shrsVKNKU(long j, int i) {
        return m870constructorimpl(j >>> i);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final long m905times7apg3OU(long j, byte b) {
        return m870constructorimpl(j * m870constructorimpl(b & 255));
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m906timesVKZWuLQ(long j, long j2) {
        return m870constructorimpl(j * j2);
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final long m907timesWZ4Q5Ns(long j, int i) {
        return m870constructorimpl(j * m870constructorimpl(i & 4294967295L));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final long m908timesxj2QHRw(long j, short s) {
        return m870constructorimpl(j * m870constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    public static final long m920xorVKZWuLQ(long j, long j2) {
        return m870constructorimpl(j ^ j2);
    }

    public int hashCode() {
        return m882hashCodeimpl(this.data);
    }

    public String toString() {
        return m915toStringimpl(this.data);
    }
}
