package kotlin;

import com.baidu.tbadk.browser.SearchJsBridge;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0012J\u001b\u0010H\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0012J\u001b\u0010M\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\rH\u0087\b¢\u0006\u0004\b]\u0010-J\u0010\u0010^\u001a\u00020_H\u0087\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bk\u0010\u0005J\u0016\u0010l\u001a\u00020\u0010H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0013H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010aJ\u0016\u0010p\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bq\u0010eJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", SearchJsBridge.COOKIE_MOD, "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes3.dex */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    public final byte data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
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
    public static final byte m713and7apg3OU(byte b2, byte b3) {
        return m720constructorimpl((byte) (b2 & b3));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m714boximpl(byte b2) {
        return new UByte(b2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m715compareTo7apg3OU(byte b2) {
        return m716compareTo7apg3OU(this.data, b2);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m717compareToVKZWuLQ(byte b2, long j2) {
        return UnsignedKt.ulongCompare(ULong.m874constructorimpl(b2 & 255), j2);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static final int m718compareToWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.uintCompare(UInt.m796constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m719compareToxj2QHRw(byte b2, short s) {
        return Intrinsics.compare(b2 & 255, s & UShort.MAX_VALUE);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m720constructorimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    public static final byte m721decw2LRezQ(byte b2) {
        return m720constructorimpl((byte) (b2 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m722div7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m1049uintDivideJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m723divVKZWuLQ(byte b2, long j2) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(ULong.m874constructorimpl(b2 & 255), j2);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m724divWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.m1049uintDivideJ1ME1BU(UInt.m796constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m725divxj2QHRw(byte b2, short s) {
        return UnsignedKt.m1049uintDivideJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m726equalsimpl(byte b2, Object obj) {
        return (obj instanceof UByte) && b2 == ((UByte) obj).m769unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m727equalsimpl0(byte b2, byte b3) {
        return b2 == b3;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    public static final int m728floorDiv7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m1049uintDivideJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    public static final long m729floorDivVKZWuLQ(byte b2, long j2) {
        return UnsignedKt.m1051ulongDivideeb3DHEI(ULong.m874constructorimpl(b2 & 255), j2);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    public static final int m730floorDivWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.m1049uintDivideJ1ME1BU(UInt.m796constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    public static final int m731floorDivxj2QHRw(byte b2, short s) {
        return UnsignedKt.m1049uintDivideJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(s & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m732hashCodeimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    public static final byte m733incw2LRezQ(byte b2) {
        return m720constructorimpl((byte) (b2 + 1));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    public static final byte m734invw2LRezQ(byte b2) {
        return m720constructorimpl((byte) (~b2));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m735minus7apg3OU(byte b2, byte b3) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) - UInt.m796constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m736minusVKZWuLQ(byte b2, long j2) {
        return ULong.m874constructorimpl(ULong.m874constructorimpl(b2 & 255) - j2);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m737minusWZ4Q5Ns(byte b2, int i2) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) - i2);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m738minusxj2QHRw(byte b2, short s) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) - UInt.m796constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    public static final byte m739mod7apg3OU(byte b2, byte b3) {
        return m720constructorimpl((byte) UnsignedKt.m1050uintRemainderJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(b3 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    public static final long m740modVKZWuLQ(byte b2, long j2) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(ULong.m874constructorimpl(b2 & 255), j2);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    public static final int m741modWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.m1050uintRemainderJ1ME1BU(UInt.m796constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    public static final short m742modxj2QHRw(byte b2, short s) {
        return UShort.m980constructorimpl((short) UnsignedKt.m1050uintRemainderJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(s & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU  reason: not valid java name */
    public static final byte m743or7apg3OU(byte b2, byte b3) {
        return m720constructorimpl((byte) (b2 | b3));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m744plus7apg3OU(byte b2, byte b3) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) + UInt.m796constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m745plusVKZWuLQ(byte b2, long j2) {
        return ULong.m874constructorimpl(ULong.m874constructorimpl(b2 & 255) + j2);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m746plusWZ4Q5Ns(byte b2, int i2) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) + i2);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m747plusxj2QHRw(byte b2, short s) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) + UInt.m796constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    public static final UIntRange m748rangeTo7apg3OU(byte b2, byte b3) {
        return new UIntRange(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(b3 & 255), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m749rem7apg3OU(byte b2, byte b3) {
        return UnsignedKt.m1050uintRemainderJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m750remVKZWuLQ(byte b2, long j2) {
        return UnsignedKt.m1052ulongRemaindereb3DHEI(ULong.m874constructorimpl(b2 & 255), j2);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m751remWZ4Q5Ns(byte b2, int i2) {
        return UnsignedKt.m1050uintRemainderJ1ME1BU(UInt.m796constructorimpl(b2 & 255), i2);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m752remxj2QHRw(byte b2, short s) {
        return UnsignedKt.m1050uintRemainderJ1ME1BU(UInt.m796constructorimpl(b2 & 255), UInt.m796constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m753times7apg3OU(byte b2, byte b3) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) * UInt.m796constructorimpl(b3 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m754timesVKZWuLQ(byte b2, long j2) {
        return ULong.m874constructorimpl(ULong.m874constructorimpl(b2 & 255) * j2);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m755timesWZ4Q5Ns(byte b2, int i2) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) * i2);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m756timesxj2QHRw(byte b2, short s) {
        return UInt.m796constructorimpl(UInt.m796constructorimpl(b2 & 255) * UInt.m796constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m757toByteimpl(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m758toDoubleimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m759toFloatimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m760toIntimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m761toLongimpl(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m762toShortimpl(byte b2) {
        return (short) (b2 & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m763toStringimpl(byte b2) {
        return String.valueOf(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m764toUBytew2LRezQ(byte b2) {
        return b2;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m765toUIntpVg5ArA(byte b2) {
        return UInt.m796constructorimpl(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m766toULongsVKNKU(byte b2) {
        return ULong.m874constructorimpl(b2 & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m767toUShortMh2AYeg(byte b2) {
        return UShort.m980constructorimpl((short) (b2 & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU  reason: not valid java name */
    public static final byte m768xor7apg3OU(byte b2, byte b3) {
        return m720constructorimpl((byte) (b2 ^ b3));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m715compareTo7apg3OU(uByte.m769unboximpl());
    }

    public boolean equals(Object obj) {
        return m726equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m732hashCodeimpl(this.data);
    }

    public String toString() {
        return m763toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m769unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static int m716compareTo7apg3OU(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255);
    }
}
