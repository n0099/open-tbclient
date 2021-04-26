package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087@\u0018\u0000 i2\u00020\u0001:\u0001iB\u0014\b\u0001\u0012\u0006\u0010d\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bh\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\bJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ\u001b\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010!J\u0016\u0010#\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0014J\u0016\u0010%\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0014J\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\bJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\fJ\u001b\u0010'\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u001aJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0012J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b+\u0010\u0004J\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\bJ\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\fJ\u001b\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u001aJ\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0012J\u001b\u00105\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\bJ\u001b\u00107\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\fJ\u001b\u00107\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u001aJ\u001b\u00107\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0012J\u001b\u0010<\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\bJ\u001b\u0010<\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\fJ\u001b\u0010<\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u001aJ\u001b\u0010<\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0012J\u0010\u0010B\u001a\u00020@H\u0087\b¢\u0006\u0004\bA\u0010\u0014J\u0010\u0010F\u001a\u00020CH\u0087\b¢\u0006\u0004\bD\u0010EJ\u0010\u0010J\u001a\u00020GH\u0087\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010M\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010Q\u001a\u00020NH\u0087\b¢\u0006\u0004\bO\u0010PJ\u0010\u0010U\u001a\u00020RH\u0087\b¢\u0006\u0004\bS\u0010TJ\u000f\u0010Y\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u0016\u0010[\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bZ\u0010\u0014J\u0016\u0010]\u001a\u00020\nH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\\\u0010LJ\u0016\u0010_\u001a\u00020\rH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010PJ\u0016\u0010a\u001a\u00020\u0010H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010TJ\u001b\u0010c\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bb\u0010\u0004R\u001c\u0010d\u001a\u00020@8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\bd\u0010e\u0012\u0004\bf\u0010gø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006j"}, d2 = {"Lkotlin/UByte;", "Ljava/lang/Comparable;", "other", "and-7apg3OU", "(BB)B", "and", "", "compareTo-7apg3OU", "(BB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec-w2LRezQ", "(B)B", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "inc-w2LRezQ", "inc", "inv-w2LRezQ", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or-7apg3OU", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "toByte", "", "toDouble-impl", "(B)D", "toDouble", "", "toFloat-impl", "(B)F", "toFloat", "toInt-impl", "(B)I", "toInt", "", "toLong-impl", "(B)J", "toLong", "", "toShort-impl", "(B)S", "toShort", "", "toString-impl", "(B)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-7apg3OU", "xor", "data", "B", "getData$annotations", "()V", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    public final byte data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lkotlin/UByte$Companion;", "Lkotlin/UByte;", "MAX_VALUE", "B", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
    public static final byte m647and7apg3OU(byte b2, byte b3) {
        return m654constructorimpl((byte) (b2 & b3));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m648boximpl(byte b2) {
        return new UByte(b2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m649compareTo7apg3OU(byte b2) {
        return m650compareTo7apg3OU(this.data, b2);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m651compareToVKZWuLQ(byte b2, long j) {
        return UnsignedKt.ulongCompare(ULong.m792constructorimpl(b2 & 255), j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m652compareToWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.uintCompare(UInt.m722constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m653compareToxj2QHRw(byte b2, short s) {
        return Intrinsics.compare(b2 & 255, s & UShort.MAX_VALUE);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m654constructorimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    public static final byte m655decw2LRezQ(byte b2) {
        return m654constructorimpl((byte) (b2 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m656div7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m951uintDivideJ1ME1BU(UInt.m722constructorimpl(b2 & 255), UInt.m722constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m657divVKZWuLQ(byte b2, long j) {
        return UnsignedKt.m953ulongDivideeb3DHEI(ULong.m792constructorimpl(b2 & 255), j);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m658divWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.m951uintDivideJ1ME1BU(UInt.m722constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m659divxj2QHRw(byte b2, short s) {
        return UnsignedKt.m951uintDivideJ1ME1BU(UInt.m722constructorimpl(b2 & 255), UInt.m722constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m660equalsimpl(byte b2, Object obj) {
        return (obj instanceof UByte) && b2 == ((UByte) obj).m695unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m661equalsimpl0(byte b2, byte b3) {
        return b2 == b3;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m662hashCodeimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    public static final byte m663incw2LRezQ(byte b2) {
        return m654constructorimpl((byte) (b2 + 1));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    public static final byte m664invw2LRezQ(byte b2) {
        return m654constructorimpl((byte) (~b2));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m665minus7apg3OU(byte b2, byte b3) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) - UInt.m722constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m666minusVKZWuLQ(byte b2, long j) {
        return ULong.m792constructorimpl(ULong.m792constructorimpl(b2 & 255) - j);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m667minusWZ4Q5Ns(byte b2, int i2) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) - i2);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m668minusxj2QHRw(byte b2, short s) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) - UInt.m722constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU  reason: not valid java name */
    public static final byte m669or7apg3OU(byte b2, byte b3) {
        return m654constructorimpl((byte) (b2 | b3));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m670plus7apg3OU(byte b2, byte b3) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) + UInt.m722constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m671plusVKZWuLQ(byte b2, long j) {
        return ULong.m792constructorimpl(ULong.m792constructorimpl(b2 & 255) + j);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m672plusWZ4Q5Ns(byte b2, int i2) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) + i2);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m673plusxj2QHRw(byte b2, short s) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) + UInt.m722constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    public static final UIntRange m674rangeTo7apg3OU(byte b2, byte b3) {
        return new UIntRange(UInt.m722constructorimpl(b2 & 255), UInt.m722constructorimpl(b3 & 255), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m675rem7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m952uintRemainderJ1ME1BU(UInt.m722constructorimpl(b2 & 255), UInt.m722constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m676remVKZWuLQ(byte b2, long j) {
        return UnsignedKt.m954ulongRemaindereb3DHEI(ULong.m792constructorimpl(b2 & 255), j);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m677remWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.m952uintRemainderJ1ME1BU(UInt.m722constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m678remxj2QHRw(byte b2, short s) {
        return UnsignedKt.m952uintRemainderJ1ME1BU(UInt.m722constructorimpl(b2 & 255), UInt.m722constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m679times7apg3OU(byte b2, byte b3) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) * UInt.m722constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m680timesVKZWuLQ(byte b2, long j) {
        return ULong.m792constructorimpl(ULong.m792constructorimpl(b2 & 255) * j);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m681timesWZ4Q5Ns(byte b2, int i2) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) * i2);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m682timesxj2QHRw(byte b2, short s) {
        return UInt.m722constructorimpl(UInt.m722constructorimpl(b2 & 255) * UInt.m722constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m683toByteimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m684toDoubleimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m685toFloatimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m686toIntimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m687toLongimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m688toShortimpl(byte b2) {
        return (short) (b2 & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m689toStringimpl(byte b2) {
        return String.valueOf(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m690toUBytew2LRezQ(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m691toUIntpVg5ArA(byte b2) {
        return UInt.m722constructorimpl(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m692toULongsVKNKU(byte b2) {
        return ULong.m792constructorimpl(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m693toUShortMh2AYeg(byte b2) {
        return UShort.m890constructorimpl((short) (b2 & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU  reason: not valid java name */
    public static final byte m694xor7apg3OU(byte b2, byte b3) {
        return m654constructorimpl((byte) (b2 ^ b3));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m649compareTo7apg3OU(uByte.m695unboximpl());
    }

    public boolean equals(Object obj) {
        return m660equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m662hashCodeimpl(this.data);
    }

    public String toString() {
        return m689toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m695unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static int m650compareTo7apg3OU(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255);
    }
}
