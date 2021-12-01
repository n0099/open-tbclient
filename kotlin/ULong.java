package kotlin;

import com.baidu.tbadk.browser.SearchJsBridge;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\u0087\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\u0087\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\u0087\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", SearchJsBridge.COOKIE_MOD, "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes3.dex */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    public final long data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.ULong.box-impl(long):kotlin.ULong] */
    @PublishedApi
    public /* synthetic */ ULong(long j2) {
        this.data = j2;
    }

    @InlineOnly
    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    public static final long m867andVKZWuLQ(long j2, long j3) {
        return m874constructorimpl(j2 & j3);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m868boximpl(long j2) {
        return new ULong(j2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m869compareTo7apg3OU(long j2, byte b2) {
        return UnsignedKt.ulongCompare(j2, m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m870compareToVKZWuLQ(long j2) {
        return m871compareToVKZWuLQ(this.data, j2);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m872compareToWZ4Q5Ns(long j2, int i2) {
        return UnsignedKt.ulongCompare(j2, m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m873compareToxj2QHRw(long j2, short s) {
        return UnsignedKt.ulongCompare(j2, m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m874constructorimpl(long j2) {
        return j2;
    }

    @InlineOnly
    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    public static final long m875decsVKNKU(long j2) {
        return m874constructorimpl(j2 - 1);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final long m876div7apg3OU(long j2, byte b2) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m877divVKZWuLQ(long j2, long j3) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, j3);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final long m878divWZ4Q5Ns(long j2, int i2) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final long m879divxj2QHRw(long j2, short s) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m880equalsimpl(long j2, Object obj) {
        return (obj instanceof ULong) && j2 == ((ULong) obj).m925unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m881equalsimpl0(long j2, long j3) {
        return j2 == j3;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    public static final long m882floorDiv7apg3OU(long j2, byte b2) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    public static final long m883floorDivVKZWuLQ(long j2, long j3) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, j3);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    public static final long m884floorDivWZ4Q5Ns(long j2, int i2) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    public static final long m885floorDivxj2QHRw(long j2, short s) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(j2, m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m886hashCodeimpl(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    @InlineOnly
    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    public static final long m887incsVKNKU(long j2) {
        return m874constructorimpl(j2 + 1);
    }

    @InlineOnly
    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    public static final long m888invsVKNKU(long j2) {
        return m874constructorimpl(~j2);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final long m889minus7apg3OU(long j2, byte b2) {
        return m874constructorimpl(j2 - m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m890minusVKZWuLQ(long j2, long j3) {
        return m874constructorimpl(j2 - j3);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final long m891minusWZ4Q5Ns(long j2, int i2) {
        return m874constructorimpl(j2 - m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final long m892minusxj2QHRw(long j2, short s) {
        return m874constructorimpl(j2 - m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    public static final byte m893mod7apg3OU(long j2, byte b2) {
        return UByte.m720constructorimpl((byte) UnsignedKt.m1052ulongRemaindereb3DHEI(j2, m874constructorimpl(b2 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    public static final long m894modVKZWuLQ(long j2, long j3) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(j2, j3);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    public static final int m895modWZ4Q5Ns(long j2, int i2) {
        return UInt.m796constructorimpl((int) UnsignedKt.m1052ulongRemaindereb3DHEI(j2, m874constructorimpl(i2 & 4294967295L)));
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    public static final short m896modxj2QHRw(long j2, short s) {
        return UShort.m980constructorimpl((short) UnsignedKt.m1052ulongRemaindereb3DHEI(j2, m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    @InlineOnly
    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    public static final long m897orVKZWuLQ(long j2, long j3) {
        return m874constructorimpl(j2 | j3);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final long m898plus7apg3OU(long j2, byte b2) {
        return m874constructorimpl(j2 + m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m899plusVKZWuLQ(long j2, long j3) {
        return m874constructorimpl(j2 + j3);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final long m900plusWZ4Q5Ns(long j2, int i2) {
        return m874constructorimpl(j2 + m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final long m901plusxj2QHRw(long j2, short s) {
        return m874constructorimpl(j2 + m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    public static final ULongRange m902rangeToVKZWuLQ(long j2, long j3) {
        return new ULongRange(j2, j3, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final long m903rem7apg3OU(long j2, byte b2) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(j2, m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m904remVKZWuLQ(long j2, long j3) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(j2, j3);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final long m905remWZ4Q5Ns(long j2, int i2) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(j2, m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final long m906remxj2QHRw(long j2, short s) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(j2, m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    public static final long m907shlsVKNKU(long j2, int i2) {
        return m874constructorimpl(j2 << i2);
    }

    @InlineOnly
    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    public static final long m908shrsVKNKU(long j2, int i2) {
        return m874constructorimpl(j2 >>> i2);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final long m909times7apg3OU(long j2, byte b2) {
        return m874constructorimpl(j2 * m874constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m910timesVKZWuLQ(long j2, long j3) {
        return m874constructorimpl(j2 * j3);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final long m911timesWZ4Q5Ns(long j2, int i2) {
        return m874constructorimpl(j2 * m874constructorimpl(i2 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final long m912timesxj2QHRw(long j2, short s) {
        return m874constructorimpl(j2 * m874constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m913toByteimpl(long j2) {
        return (byte) j2;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m914toDoubleimpl(long j2) {
        return UnsignedKt.ulongToDouble(j2);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m915toFloatimpl(long j2) {
        return (float) UnsignedKt.ulongToDouble(j2);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m916toIntimpl(long j2) {
        return (int) j2;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m917toLongimpl(long j2) {
        return j2;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m918toShortimpl(long j2) {
        return (short) j2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m919toStringimpl(long j2) {
        return UnsignedKt.ulongToString(j2);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m920toUBytew2LRezQ(long j2) {
        return UByte.m720constructorimpl((byte) j2);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m921toUIntpVg5ArA(long j2) {
        return UInt.m796constructorimpl((int) j2);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m922toULongsVKNKU(long j2) {
        return j2;
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m923toUShortMh2AYeg(long j2) {
        return UShort.m980constructorimpl((short) j2);
    }

    @InlineOnly
    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    public static final long m924xorVKZWuLQ(long j2, long j3) {
        return m874constructorimpl(j2 ^ j3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return m870compareToVKZWuLQ(uLong.m925unboximpl());
    }

    public boolean equals(Object obj) {
        return m880equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m886hashCodeimpl(this.data);
    }

    public String toString() {
        return m919toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m925unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static int m871compareToVKZWuLQ(long j2, long j3) {
        return UnsignedKt.ulongCompare(j2, j3);
    }
}
