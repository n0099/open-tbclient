package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087@\u0018\u0000 p2\u00020\u0001:\u0001pB\u0014\b\u0001\u0012\u0006\u0010k\u001a\u00020Vø\u0001\u0000¢\u0006\u0004\bo\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0004J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b$\u0010\u0014J\u0013\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u0014J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u0017J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u001aJ\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0004J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001dJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b-\u0010\u0004J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u001aJ\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0004J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001dJ\u001b\u00107\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\u0017J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u001aJ\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0004J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001dJ\u001b\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0007H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u001aJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0007H\u0087\fø\u0001\u0000¢\u0006\u0004\b@\u0010\u001aJ\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0017J\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001aJ\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u0004J\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001dJ\u0010\u0010J\u001a\u00020GH\u0087\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010N\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010R\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010U\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\bS\u0010TJ\u0010\u0010X\u001a\u00020VH\u0087\b¢\u0006\u0004\bW\u0010\u0014J\u0010\u0010\\\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u000f\u0010`\u001a\u00020]H\u0016¢\u0006\u0004\b^\u0010_J\u0013\u0010b\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010IJ\u0013\u0010d\u001a\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010TJ\u0013\u0010f\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\be\u0010\u0014J\u0013\u0010h\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\bg\u0010[J\u001b\u0010j\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bi\u0010\u0004R\u001c\u0010k\u001a\u00020V8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\bk\u0010l\u0012\u0004\bm\u0010nø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006q"}, d2 = {"Lkotlin/ULong;", "Ljava/lang/Comparable;", "other", "and-VKZWuLQ", "(JJ)J", "and", "Lkotlin/UByte;", "", "compareTo-7apg3OU", "(JB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec-impl", "(J)J", "dec", "div-7apg3OU", "(JB)J", "div", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "inc-impl", "inc", "inv-impl", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or-VKZWuLQ", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "bitCount", "shl-impl", "shl", "shr-impl", "shr", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "(J)B", "toByte", "", "toDouble-impl", "(J)D", "toDouble", "", "toFloat-impl", "(J)F", "toFloat", "toInt-impl", "(J)I", "toInt", "", "toLong-impl", "toLong", "", "toShort-impl", "(J)S", "toShort", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "toUByte-impl", "toUByte", "toUInt-impl", "toUInt", "toULong-impl", "toULong", "toUShort-impl", "toUShort", "xor-VKZWuLQ", "xor", "data", "J", "data$annotations", "()V", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    public final long data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlin/ULong$Companion;", "Lkotlin/ULong;", "MAX_VALUE", "J", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
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
    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    @InlineOnly
    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    public static final long m779andVKZWuLQ(long j, long j2) {
        return m786constructorimpl(j & j2);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m780boximpl(long j) {
        return new ULong(j);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m781compareTo7apg3OU(long j, byte b2) {
        return UnsignedKt.ulongCompare(j, m786constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m782compareToVKZWuLQ(long j) {
        return m783compareToVKZWuLQ(this.data, j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m784compareToWZ4Q5Ns(long j, int i) {
        return UnsignedKt.ulongCompare(j, m786constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m785compareToxj2QHRw(long j, short s) {
        return UnsignedKt.ulongCompare(j, m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m786constructorimpl(long j) {
        return j;
    }

    @PublishedApi
    public static /* synthetic */ void data$annotations() {
    }

    @InlineOnly
    /* renamed from: dec-impl  reason: not valid java name */
    public static final long m787decimpl(long j) {
        return m786constructorimpl(j - 1);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final long m788div7apg3OU(long j, byte b2) {
        return UnsignedKt.m945ulongDivideeb3DHEI(j, m786constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m789divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m945ulongDivideeb3DHEI(j, j2);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final long m790divWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m945ulongDivideeb3DHEI(j, m786constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final long m791divxj2QHRw(long j, short s) {
        return UnsignedKt.m945ulongDivideeb3DHEI(j, m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m792equalsimpl(long j, Object obj) {
        if (obj instanceof ULong) {
            if (j == ((ULong) obj).m829unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m793equalsimpl0(long j, long j2) {
        throw null;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m794hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @InlineOnly
    /* renamed from: inc-impl  reason: not valid java name */
    public static final long m795incimpl(long j) {
        return m786constructorimpl(j + 1);
    }

    @InlineOnly
    /* renamed from: inv-impl  reason: not valid java name */
    public static final long m796invimpl(long j) {
        return m786constructorimpl(~j);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final long m797minus7apg3OU(long j, byte b2) {
        return m786constructorimpl(j - m786constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m798minusVKZWuLQ(long j, long j2) {
        return m786constructorimpl(j - j2);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final long m799minusWZ4Q5Ns(long j, int i) {
        return m786constructorimpl(j - m786constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final long m800minusxj2QHRw(long j, short s) {
        return m786constructorimpl(j - m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    public static final long m801orVKZWuLQ(long j, long j2) {
        return m786constructorimpl(j | j2);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final long m802plus7apg3OU(long j, byte b2) {
        return m786constructorimpl(j + m786constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m803plusVKZWuLQ(long j, long j2) {
        return m786constructorimpl(j + j2);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final long m804plusWZ4Q5Ns(long j, int i) {
        return m786constructorimpl(j + m786constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final long m805plusxj2QHRw(long j, short s) {
        return m786constructorimpl(j + m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    public static final ULongRange m806rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final long m807rem7apg3OU(long j, byte b2) {
        return UnsignedKt.m946ulongRemaindereb3DHEI(j, m786constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m808remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m946ulongRemaindereb3DHEI(j, j2);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final long m809remWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m946ulongRemaindereb3DHEI(j, m786constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final long m810remxj2QHRw(long j, short s) {
        return UnsignedKt.m946ulongRemaindereb3DHEI(j, m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: shl-impl  reason: not valid java name */
    public static final long m811shlimpl(long j, int i) {
        return m786constructorimpl(j << i);
    }

    @InlineOnly
    /* renamed from: shr-impl  reason: not valid java name */
    public static final long m812shrimpl(long j, int i) {
        return m786constructorimpl(j >>> i);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final long m813times7apg3OU(long j, byte b2) {
        return m786constructorimpl(j * m786constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m814timesVKZWuLQ(long j, long j2) {
        return m786constructorimpl(j * j2);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final long m815timesWZ4Q5Ns(long j, int i) {
        return m786constructorimpl(j * m786constructorimpl(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final long m816timesxj2QHRw(long j, short s) {
        return m786constructorimpl(j * m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m817toByteimpl(long j) {
        return (byte) j;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m818toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m819toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m820toIntimpl(long j) {
        return (int) j;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m821toLongimpl(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m822toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m823toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    @InlineOnly
    /* renamed from: toUByte-impl  reason: not valid java name */
    public static final byte m824toUByteimpl(long j) {
        return UByte.m650constructorimpl((byte) j);
    }

    @InlineOnly
    /* renamed from: toUInt-impl  reason: not valid java name */
    public static final int m825toUIntimpl(long j) {
        return UInt.m717constructorimpl((int) j);
    }

    @InlineOnly
    /* renamed from: toULong-impl  reason: not valid java name */
    public static final long m826toULongimpl(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: toUShort-impl  reason: not valid java name */
    public static final short m827toUShortimpl(long j) {
        return UShort.m883constructorimpl((short) j);
    }

    @InlineOnly
    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    public static final long m828xorVKZWuLQ(long j, long j2) {
        return m786constructorimpl(j ^ j2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return m782compareToVKZWuLQ(uLong.m829unboximpl());
    }

    public boolean equals(Object obj) {
        return m792equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m794hashCodeimpl(this.data);
    }

    public String toString() {
        return m823toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m829unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static int m783compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }
}
