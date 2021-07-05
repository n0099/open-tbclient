package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import okhttp3.internal.ws.WebSocketProtocol;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087@\u0018\u0000 i2\u00020\u0001:\u0001iB\u0014\b\u0001\u0012\u0006\u0010d\u001a\u00020Sø\u0001\u0000¢\u0006\u0004\bh\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\rJ\u001b\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b \u0010!J\u0016\u0010#\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0014J\u0016\u0010%\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0014J\u001b\u0010'\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\tJ\u001b\u0010'\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u001b\u0010'\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u001aJ\u001b\u0010'\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0012J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b+\u0010\u0004J\u001b\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\tJ\u001b\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\rJ\u001b\u0010.\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u001aJ\u001b\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0012J\u001b\u00105\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\tJ\u001b\u00107\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\rJ\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u001aJ\u001b\u00107\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0012J\u001b\u0010<\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\tJ\u001b\u0010<\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\rJ\u001b\u0010<\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u001aJ\u001b\u0010<\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0012J\u0010\u0010C\u001a\u00020@H\u0087\b¢\u0006\u0004\bA\u0010BJ\u0010\u0010G\u001a\u00020DH\u0087\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010K\u001a\u00020HH\u0087\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010N\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010R\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010U\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010\u0014J\u000f\u0010Y\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u0016\u0010[\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bZ\u0010BJ\u0016\u0010]\u001a\u00020\u000bH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\\\u0010MJ\u0016\u0010_\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010QJ\u0016\u0010a\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010\u0014J\u001b\u0010c\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bb\u0010\u0004R\u001c\u0010d\u001a\u00020S8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\bd\u0010e\u0012\u0004\bf\u0010gø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006j"}, d2 = {"Lkotlin/UShort;", "Ljava/lang/Comparable;", "other", "and-xj2QHRw", "(SS)S", "and", "Lkotlin/UByte;", "", "compareTo-7apg3OU", "(SB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec-Mh2AYeg", "(S)S", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "inc-Mh2AYeg", "inc", "inv-Mh2AYeg", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or-xj2QHRw", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "(S)B", "toByte", "", "toDouble-impl", "(S)D", "toDouble", "", "toFloat-impl", "(S)F", "toFloat", "toInt-impl", "(S)I", "toInt", "", "toLong-impl", "(S)J", "toLong", "", "toShort-impl", "toShort", "", "toString-impl", "(S)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-xj2QHRw", "xor", "data", "S", "getData$annotations", "()V", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes10.dex */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    public final short data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lkotlin/UShort$Companion;", "Lkotlin/UShort;", "MAX_VALUE", "S", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.UShort.box-impl(short):kotlin.UShort] */
    @PublishedApi
    public /* synthetic */ UShort(short s) {
        this.data = s;
    }

    @InlineOnly
    /* renamed from: and-xj2QHRw  reason: not valid java name */
    public static final short m896andxj2QHRw(short s, short s2) {
        return m903constructorimpl((short) (s & s2));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m897boximpl(short s) {
        return new UShort(s);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m898compareTo7apg3OU(short s, byte b2) {
        return Intrinsics.compare(s & MAX_VALUE, b2 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m899compareToVKZWuLQ(short s, long j) {
        return UnsignedKt.ulongCompare(ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m900compareToWZ4Q5Ns(short s, int i2) {
        return UnsignedKt.uintCompare(UInt.m735constructorimpl(s & MAX_VALUE), i2);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m901compareToxj2QHRw(short s) {
        return m902compareToxj2QHRw(this.data, s);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m903constructorimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    public static final short m904decMh2AYeg(short s) {
        return m903constructorimpl((short) (s - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m905div7apg3OU(short s, byte b2) {
        return UnsignedKt.m964uintDivideJ1ME1BU(UInt.m735constructorimpl(s & MAX_VALUE), UInt.m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m906divVKZWuLQ(short s, long j) {
        return UnsignedKt.m966ulongDivideeb3DHEI(ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m907divWZ4Q5Ns(short s, int i2) {
        return UnsignedKt.m964uintDivideJ1ME1BU(UInt.m735constructorimpl(s & MAX_VALUE), i2);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m908divxj2QHRw(short s, short s2) {
        return UnsignedKt.m964uintDivideJ1ME1BU(UInt.m735constructorimpl(s & MAX_VALUE), UInt.m735constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m909equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m944unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m910equalsimpl0(short s, short s2) {
        return s == s2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m911hashCodeimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    public static final short m912incMh2AYeg(short s) {
        return m903constructorimpl((short) (s + 1));
    }

    @InlineOnly
    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    public static final short m913invMh2AYeg(short s) {
        return m903constructorimpl((short) (~s));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m914minus7apg3OU(short s, byte b2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) - UInt.m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m915minusVKZWuLQ(short s, long j) {
        return ULong.m805constructorimpl(ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m916minusWZ4Q5Ns(short s, int i2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) - i2);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m917minusxj2QHRw(short s, short s2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) - UInt.m735constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: or-xj2QHRw  reason: not valid java name */
    public static final short m918orxj2QHRw(short s, short s2) {
        return m903constructorimpl((short) (s | s2));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m919plus7apg3OU(short s, byte b2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) + UInt.m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m920plusVKZWuLQ(short s, long j) {
        return ULong.m805constructorimpl(ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m921plusWZ4Q5Ns(short s, int i2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) + i2);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m922plusxj2QHRw(short s, short s2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) + UInt.m735constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    public static final UIntRange m923rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m735constructorimpl(s & MAX_VALUE), UInt.m735constructorimpl(s2 & MAX_VALUE), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m924rem7apg3OU(short s, byte b2) {
        return UnsignedKt.m965uintRemainderJ1ME1BU(UInt.m735constructorimpl(s & MAX_VALUE), UInt.m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m925remVKZWuLQ(short s, long j) {
        return UnsignedKt.m967ulongRemaindereb3DHEI(ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m926remWZ4Q5Ns(short s, int i2) {
        return UnsignedKt.m965uintRemainderJ1ME1BU(UInt.m735constructorimpl(s & MAX_VALUE), i2);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m927remxj2QHRw(short s, short s2) {
        return UnsignedKt.m965uintRemainderJ1ME1BU(UInt.m735constructorimpl(s & MAX_VALUE), UInt.m735constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m928times7apg3OU(short s, byte b2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) * UInt.m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m929timesVKZWuLQ(short s, long j) {
        return ULong.m805constructorimpl(ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m930timesWZ4Q5Ns(short s, int i2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) * i2);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m931timesxj2QHRw(short s, short s2) {
        return UInt.m735constructorimpl(UInt.m735constructorimpl(s & MAX_VALUE) * UInt.m735constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m932toByteimpl(short s) {
        return (byte) s;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m933toDoubleimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m934toFloatimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m935toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m936toLongimpl(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m937toShortimpl(short s) {
        return s;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m938toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m939toUBytew2LRezQ(short s) {
        return UByte.m667constructorimpl((byte) s);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m940toUIntpVg5ArA(short s) {
        return UInt.m735constructorimpl(s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m941toULongsVKNKU(short s) {
        return ULong.m805constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m942toUShortMh2AYeg(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    public static final short m943xorxj2QHRw(short s, short s2) {
        return m903constructorimpl((short) (s ^ s2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return m901compareToxj2QHRw(uShort.m944unboximpl());
    }

    public boolean equals(Object obj) {
        return m909equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m911hashCodeimpl(this.data);
    }

    public String toString() {
        return m938toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m944unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static int m902compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }
}
