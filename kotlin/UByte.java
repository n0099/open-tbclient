package kotlin;

import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0012J\u001b\u0010H\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0012J\u001b\u0010M\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\rH\u0087\b¢\u0006\u0004\b]\u0010-J\u0010\u0010^\u001a\u00020_H\u0087\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bk\u0010\u0005J\u0016\u0010l\u001a\u00020\u0010H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0013H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010aJ\u0016\u0010p\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bq\u0010eJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", ImageViewerConfig.FROM_OTHER, "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", TtmlNode.TAG_DIV, "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", SearchJsBridge.COOKIE_MOD, "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes8.dex */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    public final byte data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes8.dex */
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
    public /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    @InlineOnly
    /* renamed from: and-7apg3OU  reason: not valid java name */
    public static final byte m1647and7apg3OU(byte b, byte b2) {
        return m1654constructorimpl((byte) (b & b2));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m1648boximpl(byte b) {
        return new UByte(b);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m1649compareTo7apg3OU(byte b) {
        return m1650compareTo7apg3OU(this.data, b);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m1651compareToVKZWuLQ(byte b, long j) {
        return UnsignedKt.ulongCompare(ULong.m1808constructorimpl(b & 255), j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m1652compareToWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.uintCompare(UInt.m1730constructorimpl(b & 255), i);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m1653compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & UShort.MAX_VALUE);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m1654constructorimpl(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    public static final byte m1655decw2LRezQ(byte b) {
        return m1654constructorimpl((byte) (b - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m1656div7apg3OU(byte b, byte b2) {
        return UnsignedKt.m1983uintDivideJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m1657divVKZWuLQ(byte b, long j) {
        return UnsignedKt.m1985ulongDivideeb3DHEI(ULong.m1808constructorimpl(b & 255), j);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m1658divWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m1983uintDivideJ1ME1BU(UInt.m1730constructorimpl(b & 255), i);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m1659divxj2QHRw(byte b, short s) {
        return UnsignedKt.m1983uintDivideJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1660equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m1703unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1661equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    public static final int m1662floorDiv7apg3OU(byte b, byte b2) {
        return UnsignedKt.m1983uintDivideJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    public static final long m1663floorDivVKZWuLQ(byte b, long j) {
        return UnsignedKt.m1985ulongDivideeb3DHEI(ULong.m1808constructorimpl(b & 255), j);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    public static final int m1664floorDivWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m1983uintDivideJ1ME1BU(UInt.m1730constructorimpl(b & 255), i);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    public static final int m1665floorDivxj2QHRw(byte b, short s) {
        return UnsignedKt.m1983uintDivideJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(s & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1666hashCodeimpl(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    public static final byte m1667incw2LRezQ(byte b) {
        return m1654constructorimpl((byte) (b + 1));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    public static final byte m1668invw2LRezQ(byte b) {
        return m1654constructorimpl((byte) (~b));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m1669minus7apg3OU(byte b, byte b2) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) - UInt.m1730constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m1670minusVKZWuLQ(byte b, long j) {
        return ULong.m1808constructorimpl(ULong.m1808constructorimpl(b & 255) - j);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m1671minusWZ4Q5Ns(byte b, int i) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) - i);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m1672minusxj2QHRw(byte b, short s) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) - UInt.m1730constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    public static final byte m1673mod7apg3OU(byte b, byte b2) {
        return m1654constructorimpl((byte) UnsignedKt.m1984uintRemainderJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(b2 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    public static final long m1674modVKZWuLQ(byte b, long j) {
        return UnsignedKt.m1986ulongRemaindereb3DHEI(ULong.m1808constructorimpl(b & 255), j);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    public static final int m1675modWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m1984uintRemainderJ1ME1BU(UInt.m1730constructorimpl(b & 255), i);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    public static final short m1676modxj2QHRw(byte b, short s) {
        return UShort.m1914constructorimpl((short) UnsignedKt.m1984uintRemainderJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(s & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU  reason: not valid java name */
    public static final byte m1677or7apg3OU(byte b, byte b2) {
        return m1654constructorimpl((byte) (b | b2));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m1678plus7apg3OU(byte b, byte b2) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) + UInt.m1730constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m1679plusVKZWuLQ(byte b, long j) {
        return ULong.m1808constructorimpl(ULong.m1808constructorimpl(b & 255) + j);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m1680plusWZ4Q5Ns(byte b, int i) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) + i);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m1681plusxj2QHRw(byte b, short s) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) + UInt.m1730constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    public static final UIntRange m1682rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(b2 & 255), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m1683rem7apg3OU(byte b, byte b2) {
        return UnsignedKt.m1984uintRemainderJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m1684remVKZWuLQ(byte b, long j) {
        return UnsignedKt.m1986ulongRemaindereb3DHEI(ULong.m1808constructorimpl(b & 255), j);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m1685remWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m1984uintRemainderJ1ME1BU(UInt.m1730constructorimpl(b & 255), i);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m1686remxj2QHRw(byte b, short s) {
        return UnsignedKt.m1984uintRemainderJ1ME1BU(UInt.m1730constructorimpl(b & 255), UInt.m1730constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m1687times7apg3OU(byte b, byte b2) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) * UInt.m1730constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m1688timesVKZWuLQ(byte b, long j) {
        return ULong.m1808constructorimpl(ULong.m1808constructorimpl(b & 255) * j);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m1689timesWZ4Q5Ns(byte b, int i) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) * i);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m1690timesxj2QHRw(byte b, short s) {
        return UInt.m1730constructorimpl(UInt.m1730constructorimpl(b & 255) * UInt.m1730constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m1691toByteimpl(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m1692toDoubleimpl(byte b) {
        return b & 255;
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m1693toFloatimpl(byte b) {
        return b & 255;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m1694toIntimpl(byte b) {
        return b & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m1695toLongimpl(byte b) {
        return b & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m1696toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1697toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m1698toUBytew2LRezQ(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m1699toUIntpVg5ArA(byte b) {
        return UInt.m1730constructorimpl(b & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m1700toULongsVKNKU(byte b) {
        return ULong.m1808constructorimpl(b & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m1701toUShortMh2AYeg(byte b) {
        return UShort.m1914constructorimpl((short) (b & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU  reason: not valid java name */
    public static final byte m1702xor7apg3OU(byte b, byte b2) {
        return m1654constructorimpl((byte) (b ^ b2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m1649compareTo7apg3OU(uByte.m1703unboximpl());
    }

    public boolean equals(Object obj) {
        return m1660equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m1666hashCodeimpl(this.data);
    }

    public String toString() {
        return m1697toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m1703unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static int m1650compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }
}
