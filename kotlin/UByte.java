package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087@\u0018\u0000 i2\u00020\u0001:\u0001iB\u0014\b\u0001\u0012\u0006\u0010d\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bh\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\bJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ\u001b\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010!J\u0013\u0010#\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0014J\u0013\u0010%\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0014J\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\bJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\fJ\u001b\u0010'\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u001aJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0012J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b+\u0010\u0004J\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\bJ\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\fJ\u001b\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u001aJ\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0012J\u001b\u00105\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\bJ\u001b\u00107\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\fJ\u001b\u00107\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u001aJ\u001b\u00107\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0012J\u001b\u0010<\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\bJ\u001b\u0010<\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\fJ\u001b\u0010<\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u001aJ\u001b\u0010<\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0012J\u0010\u0010B\u001a\u00020@H\u0087\b¢\u0006\u0004\bA\u0010\u0014J\u0010\u0010F\u001a\u00020CH\u0087\b¢\u0006\u0004\bD\u0010EJ\u0010\u0010J\u001a\u00020GH\u0087\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010M\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010Q\u001a\u00020NH\u0087\b¢\u0006\u0004\bO\u0010PJ\u0010\u0010U\u001a\u00020RH\u0087\b¢\u0006\u0004\bS\u0010TJ\u000f\u0010Y\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u0013\u0010[\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0014J\u0013\u0010]\u001a\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010LJ\u0013\u0010_\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b^\u0010PJ\u0013\u0010a\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b`\u0010TJ\u001b\u0010c\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bb\u0010\u0004R\u001c\u0010d\u001a\u00020@8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\bd\u0010e\u0012\u0004\bf\u0010gø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006j"}, d2 = {"Lkotlin/UByte;", "Ljava/lang/Comparable;", "other", "and-7apg3OU", "(BB)B", "and", "", "compareTo-7apg3OU", "(BB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec-impl", "(B)B", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "inc-impl", "inc", "inv-impl", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or-7apg3OU", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "toByte", "", "toDouble-impl", "(B)D", "toDouble", "", "toFloat-impl", "(B)F", "toFloat", "toInt-impl", "(B)I", "toInt", "", "toLong-impl", "(B)J", "toLong", "", "toShort-impl", "(B)S", "toShort", "", "toString-impl", "(B)Ljava/lang/String;", "toString", "toUByte-impl", "toUByte", "toUInt-impl", "toUInt", "toULong-impl", "toULong", "toUShort-impl", "toUShort", "xor-7apg3OU", "xor", "data", "B", "data$annotations", "()V", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    public final byte data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlin/UByte$Companion;", "Lkotlin/UByte;", "MAX_VALUE", "B", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.UByte.box-impl(byte):kotlin.UByte] */
    @PublishedApi
    public /* synthetic */ UByte(byte b2) {
        this.data = b2;
    }

    @InlineOnly
    /* renamed from: and-7apg3OU  reason: not valid java name */
    public static final byte m643and7apg3OU(byte b2, byte b3) {
        return m650constructorimpl((byte) (b2 & b3));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m644boximpl(byte b2) {
        return new UByte(b2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m645compareTo7apg3OU(byte b2) {
        return m646compareTo7apg3OU(this.data, b2);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m647compareToVKZWuLQ(byte b2, long j) {
        return UnsignedKt.ulongCompare(ULong.m786constructorimpl(b2 & 255), j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m648compareToWZ4Q5Ns(byte b2, int i) {
        return UnsignedKt.uintCompare(UInt.m717constructorimpl(b2 & 255), i);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m649compareToxj2QHRw(byte b2, short s) {
        return Intrinsics.compare(b2 & 255, s & UShort.MAX_VALUE);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m650constructorimpl(byte b2) {
        return b2;
    }

    @PublishedApi
    public static /* synthetic */ void data$annotations() {
    }

    @InlineOnly
    /* renamed from: dec-impl  reason: not valid java name */
    public static final byte m651decimpl(byte b2) {
        return m650constructorimpl((byte) (b2 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m652div7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m943uintDivideJ1ME1BU(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m653divVKZWuLQ(byte b2, long j) {
        return UnsignedKt.m945ulongDivideeb3DHEI(ULong.m786constructorimpl(b2 & 255), j);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m654divWZ4Q5Ns(byte b2, int i) {
        return UnsignedKt.m943uintDivideJ1ME1BU(UInt.m717constructorimpl(b2 & 255), i);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m655divxj2QHRw(byte b2, short s) {
        return UnsignedKt.m943uintDivideJ1ME1BU(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m656equalsimpl(byte b2, Object obj) {
        if (obj instanceof UByte) {
            if (b2 == ((UByte) obj).m691unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m657equalsimpl0(byte b2, byte b3) {
        throw null;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m658hashCodeimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: inc-impl  reason: not valid java name */
    public static final byte m659incimpl(byte b2) {
        return m650constructorimpl((byte) (b2 + 1));
    }

    @InlineOnly
    /* renamed from: inv-impl  reason: not valid java name */
    public static final byte m660invimpl(byte b2) {
        return m650constructorimpl((byte) (~b2));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m661minus7apg3OU(byte b2, byte b3) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) - UInt.m717constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m662minusVKZWuLQ(byte b2, long j) {
        return ULong.m786constructorimpl(ULong.m786constructorimpl(b2 & 255) - j);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m663minusWZ4Q5Ns(byte b2, int i) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) - i);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m664minusxj2QHRw(byte b2, short s) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) - UInt.m717constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU  reason: not valid java name */
    public static final byte m665or7apg3OU(byte b2, byte b3) {
        return m650constructorimpl((byte) (b2 | b3));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m666plus7apg3OU(byte b2, byte b3) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) + UInt.m717constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m667plusVKZWuLQ(byte b2, long j) {
        return ULong.m786constructorimpl(ULong.m786constructorimpl(b2 & 255) + j);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m668plusWZ4Q5Ns(byte b2, int i) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) + i);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m669plusxj2QHRw(byte b2, short s) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) + UInt.m717constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    public static final UIntRange m670rangeTo7apg3OU(byte b2, byte b3) {
        return new UIntRange(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(b3 & 255), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m671rem7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m944uintRemainderJ1ME1BU(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m672remVKZWuLQ(byte b2, long j) {
        return UnsignedKt.m946ulongRemaindereb3DHEI(ULong.m786constructorimpl(b2 & 255), j);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m673remWZ4Q5Ns(byte b2, int i) {
        return UnsignedKt.m944uintRemainderJ1ME1BU(UInt.m717constructorimpl(b2 & 255), i);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m674remxj2QHRw(byte b2, short s) {
        return UnsignedKt.m944uintRemainderJ1ME1BU(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m675times7apg3OU(byte b2, byte b3) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) * UInt.m717constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m676timesVKZWuLQ(byte b2, long j) {
        return ULong.m786constructorimpl(ULong.m786constructorimpl(b2 & 255) * j);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m677timesWZ4Q5Ns(byte b2, int i) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) * i);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m678timesxj2QHRw(byte b2, short s) {
        return UInt.m717constructorimpl(UInt.m717constructorimpl(b2 & 255) * UInt.m717constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m679toByteimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m680toDoubleimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m681toFloatimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m682toIntimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m683toLongimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m684toShortimpl(byte b2) {
        return (short) (b2 & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m685toStringimpl(byte b2) {
        return String.valueOf(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toUByte-impl  reason: not valid java name */
    public static final byte m686toUByteimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: toUInt-impl  reason: not valid java name */
    public static final int m687toUIntimpl(byte b2) {
        return UInt.m717constructorimpl(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-impl  reason: not valid java name */
    public static final long m688toULongimpl(byte b2) {
        return ULong.m786constructorimpl(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-impl  reason: not valid java name */
    public static final short m689toUShortimpl(byte b2) {
        return UShort.m883constructorimpl((short) (b2 & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU  reason: not valid java name */
    public static final byte m690xor7apg3OU(byte b2, byte b3) {
        return m650constructorimpl((byte) (b2 ^ b3));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m645compareTo7apg3OU(uByte.m691unboximpl());
    }

    public boolean equals(Object obj) {
        return m656equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m658hashCodeimpl(this.data);
    }

    public String toString() {
        return m685toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m691unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static int m646compareTo7apg3OU(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255);
    }
}
