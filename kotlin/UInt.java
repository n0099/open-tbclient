package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087@\u0018\u0000 m2\u00020\u0001:\u0001mB\u0014\b\u0001\u0012\u0006\u0010h\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bl\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\tJ\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0004J\u001b\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\"\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0013J\u0016\u0010$\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0013J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b%\u0010\tJ\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b'\u0010\u0004J\u001b\u0010&\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u0019J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u0011J\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b*\u0010\u0004J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\tJ\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u0004J\u001b\u0010-\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0019J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001b\u00104\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\tJ\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u0004J\u001b\u00106\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019J\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u0011J\u001e\u0010<\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0007H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010\u0004J\u001e\u0010>\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0007H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010\u0004J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\tJ\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0004J\u001b\u0010@\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0019J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0011J\u0010\u0010G\u001a\u00020DH\u0087\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010K\u001a\u00020HH\u0087\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010O\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010Q\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\bP\u0010\u0013J\u0010\u0010U\u001a\u00020RH\u0087\b¢\u0006\u0004\bS\u0010TJ\u0010\u0010Y\u001a\u00020VH\u0087\b¢\u0006\u0004\bW\u0010XJ\u000f\u0010]\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u0016\u0010_\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010FJ\u0016\u0010a\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010\u0013J\u0016\u0010c\u001a\u00020\fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bb\u0010TJ\u0016\u0010e\u001a\u00020\u000fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bd\u0010XJ\u001b\u0010g\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bf\u0010\u0004R\u001c\u0010h\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\bh\u0010i\u0012\u0004\bj\u0010kø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006n"}, d2 = {"Lkotlin/UInt;", "Ljava/lang/Comparable;", "other", "and-WZ4Q5Ns", "(II)I", "and", "Lkotlin/UByte;", "", "compareTo-7apg3OU", "(IB)I", "compareTo", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec-pVg5ArA", "(I)I", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "inc-pVg5ArA", "inc", "inv-pVg5ArA", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or-WZ4Q5Ns", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "bitCount", "shl-pVg5ArA", "shl", "shr-pVg5ArA", "shr", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "(I)B", "toByte", "", "toDouble-impl", "(I)D", "toDouble", "", "toFloat-impl", "(I)F", "toFloat", "toInt-impl", "toInt", "", "toLong-impl", "(I)J", "toLong", "", "toShort-impl", "(I)S", "toShort", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-WZ4Q5Ns", "xor", "data", "I", "getData$annotations", "()V", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes10.dex */
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    public final int data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UInt$Companion;", "Lkotlin/UInt;", "MAX_VALUE", "I", "MIN_VALUE", "", "SIZE_BITS", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.UInt.box-impl(int):kotlin.UInt] */
    @PublishedApi
    public /* synthetic */ UInt(int i2) {
        this.data = i2;
    }

    @InlineOnly
    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    public static final int m728andWZ4Q5Ns(int i2, int i3) {
        return m735constructorimpl(i2 & i3);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m729boximpl(int i2) {
        return new UInt(i2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m730compareTo7apg3OU(int i2, byte b2) {
        return UnsignedKt.uintCompare(i2, m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m731compareToVKZWuLQ(int i2, long j) {
        return UnsignedKt.ulongCompare(ULong.m805constructorimpl(i2 & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m732compareToWZ4Q5Ns(int i2) {
        return m733compareToWZ4Q5Ns(this.data, i2);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m734compareToxj2QHRw(int i2, short s) {
        return UnsignedKt.uintCompare(i2, m735constructorimpl(s & UShort.MAX_VALUE));
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m735constructorimpl(int i2) {
        return i2;
    }

    @InlineOnly
    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    public static final int m736decpVg5ArA(int i2) {
        return m735constructorimpl(i2 - 1);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m737div7apg3OU(int i2, byte b2) {
        return UnsignedKt.m964uintDivideJ1ME1BU(i2, m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m738divVKZWuLQ(int i2, long j) {
        return UnsignedKt.m966ulongDivideeb3DHEI(ULong.m805constructorimpl(i2 & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m739divWZ4Q5Ns(int i2, int i3) {
        return UnsignedKt.m964uintDivideJ1ME1BU(i2, i3);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m740divxj2QHRw(int i2, short s) {
        return UnsignedKt.m964uintDivideJ1ME1BU(i2, m735constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m741equalsimpl(int i2, Object obj) {
        return (obj instanceof UInt) && i2 == ((UInt) obj).m778unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m742equalsimpl0(int i2, int i3) {
        return i2 == i3;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m743hashCodeimpl(int i2) {
        return i2;
    }

    @InlineOnly
    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    public static final int m744incpVg5ArA(int i2) {
        return m735constructorimpl(i2 + 1);
    }

    @InlineOnly
    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    public static final int m745invpVg5ArA(int i2) {
        return m735constructorimpl(~i2);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m746minus7apg3OU(int i2, byte b2) {
        return m735constructorimpl(i2 - m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m747minusVKZWuLQ(int i2, long j) {
        return ULong.m805constructorimpl(ULong.m805constructorimpl(i2 & 4294967295L) - j);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m748minusWZ4Q5Ns(int i2, int i3) {
        return m735constructorimpl(i2 - i3);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m749minusxj2QHRw(int i2, short s) {
        return m735constructorimpl(i2 - m735constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    public static final int m750orWZ4Q5Ns(int i2, int i3) {
        return m735constructorimpl(i2 | i3);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m751plus7apg3OU(int i2, byte b2) {
        return m735constructorimpl(i2 + m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m752plusVKZWuLQ(int i2, long j) {
        return ULong.m805constructorimpl(ULong.m805constructorimpl(i2 & 4294967295L) + j);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m753plusWZ4Q5Ns(int i2, int i3) {
        return m735constructorimpl(i2 + i3);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m754plusxj2QHRw(int i2, short s) {
        return m735constructorimpl(i2 + m735constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    public static final UIntRange m755rangeToWZ4Q5Ns(int i2, int i3) {
        return new UIntRange(i2, i3, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m756rem7apg3OU(int i2, byte b2) {
        return UnsignedKt.m965uintRemainderJ1ME1BU(i2, m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m757remVKZWuLQ(int i2, long j) {
        return UnsignedKt.m967ulongRemaindereb3DHEI(ULong.m805constructorimpl(i2 & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m758remWZ4Q5Ns(int i2, int i3) {
        return UnsignedKt.m965uintRemainderJ1ME1BU(i2, i3);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m759remxj2QHRw(int i2, short s) {
        return UnsignedKt.m965uintRemainderJ1ME1BU(i2, m735constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    public static final int m760shlpVg5ArA(int i2, int i3) {
        return m735constructorimpl(i2 << i3);
    }

    @InlineOnly
    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    public static final int m761shrpVg5ArA(int i2, int i3) {
        return m735constructorimpl(i2 >>> i3);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m762times7apg3OU(int i2, byte b2) {
        return m735constructorimpl(i2 * m735constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m763timesVKZWuLQ(int i2, long j) {
        return ULong.m805constructorimpl(ULong.m805constructorimpl(i2 & 4294967295L) * j);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m764timesWZ4Q5Ns(int i2, int i3) {
        return m735constructorimpl(i2 * i3);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m765timesxj2QHRw(int i2, short s) {
        return m735constructorimpl(i2 * m735constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m766toByteimpl(int i2) {
        return (byte) i2;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m767toDoubleimpl(int i2) {
        return UnsignedKt.uintToDouble(i2);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m768toFloatimpl(int i2) {
        return (float) UnsignedKt.uintToDouble(i2);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m769toIntimpl(int i2) {
        return i2;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m770toLongimpl(int i2) {
        return i2 & 4294967295L;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m771toShortimpl(int i2) {
        return (short) i2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m772toStringimpl(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m773toUBytew2LRezQ(int i2) {
        return UByte.m667constructorimpl((byte) i2);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m774toUIntpVg5ArA(int i2) {
        return i2;
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m775toULongsVKNKU(int i2) {
        return ULong.m805constructorimpl(i2 & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m776toUShortMh2AYeg(int i2) {
        return UShort.m903constructorimpl((short) i2);
    }

    @InlineOnly
    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    public static final int m777xorWZ4Q5Ns(int i2, int i3) {
        return m735constructorimpl(i2 ^ i3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return m732compareToWZ4Q5Ns(uInt.m778unboximpl());
    }

    public boolean equals(Object obj) {
        return m741equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m743hashCodeimpl(this.data);
    }

    public String toString() {
        return m772toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m778unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static int m733compareToWZ4Q5Ns(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3);
    }
}
