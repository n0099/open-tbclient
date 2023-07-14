package kotlin;

import com.baidu.tbadk.browser.SearchJsBridge;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u000fJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010F\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u001dJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0016J\u001e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bM\u0010\u000bJ\u001e\u0010N\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000fJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u001dJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bT\u0010\u0016J\u0010\u0010U\u001a\u00020VH\u0087\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020ZH\u0087\b¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^H\u0087\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\rH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bp\u0010XJ\u0016\u0010q\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010\u0005J\u0016\u0010s\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010fJ\u0016\u0010u\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010jJ\u001b\u0010w\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bx\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006z"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", TtmlNode.TAG_DIV, "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", SearchJsBridge.COOKIE_MOD, "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes10.dex */
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    public final int data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m934boximpl(int i) {
        return new UInt(i);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m940constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m946equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m991unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m947equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m952hashCodeimpl(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m979toByteimpl(int i) {
        return (byte) i;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m982toIntimpl(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m983toLongimpl(int i) {
        return i & 4294967295L;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m984toShortimpl(int i) {
        return (short) i;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    public static final int m987toUIntpVg5ArA(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m946equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m952hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m991unboximpl() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.UInt.box-impl(int):kotlin.UInt] */
    @PublishedApi
    public /* synthetic */ UInt(int i) {
        this.data = i;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m937compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m991unboximpl(), i);
    }

    @InlineOnly
    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    public static final int m941decpVg5ArA(int i) {
        return m940constructorimpl(i - 1);
    }

    @InlineOnly
    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    public static final int m953incpVg5ArA(int i) {
        return m940constructorimpl(i + 1);
    }

    @InlineOnly
    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    public static final int m954invpVg5ArA(int i) {
        return m940constructorimpl(~i);
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m980toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m981toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m985toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    public static final byte m986toUBytew2LRezQ(int i) {
        return UByte.m864constructorimpl((byte) i);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    public static final long m988toULongsVKNKU(int i) {
        return ULong.m1018constructorimpl(i & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    public static final short m989toUShortMh2AYeg(int i) {
        return UShort.m1124constructorimpl((short) i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(m991unboximpl(), uInt.m991unboximpl());
    }

    @InlineOnly
    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    public static final int m933andWZ4Q5Ns(int i, int i2) {
        return m940constructorimpl(i & i2);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    public static final int m935compareTo7apg3OU(int i, byte b) {
        return UnsignedKt.uintCompare(i, m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    public static final int m936compareToVKZWuLQ(int i, long j) {
        return UnsignedKt.ulongCompare(ULong.m1018constructorimpl(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    public static int m938compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    public static final int m939compareToxj2QHRw(int i, short s) {
        return UnsignedKt.uintCompare(i, m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    public static final int m942div7apg3OU(int i, byte b) {
        return UnsignedKt.m1193uintDivideJ1ME1BU(i, m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    public static final long m943divVKZWuLQ(int i, long j) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(ULong.m1018constructorimpl(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    public static final int m944divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1193uintDivideJ1ME1BU(i, i2);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    public static final int m945divxj2QHRw(int i, short s) {
        return UnsignedKt.m1193uintDivideJ1ME1BU(i, m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    public static final int m948floorDiv7apg3OU(int i, byte b) {
        return UnsignedKt.m1193uintDivideJ1ME1BU(i, m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    public static final long m949floorDivVKZWuLQ(int i, long j) {
        return UnsignedKt.m1195ulongDivideeb3DHEI(ULong.m1018constructorimpl(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    public static final int m950floorDivWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1193uintDivideJ1ME1BU(i, i2);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    public static final int m951floorDivxj2QHRw(int i, short s) {
        return UnsignedKt.m1193uintDivideJ1ME1BU(i, m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    public static final int m955minus7apg3OU(int i, byte b) {
        return m940constructorimpl(i - m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    public static final long m956minusVKZWuLQ(int i, long j) {
        return ULong.m1018constructorimpl(ULong.m1018constructorimpl(i & 4294967295L) - j);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    public static final int m957minusWZ4Q5Ns(int i, int i2) {
        return m940constructorimpl(i - i2);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    public static final int m958minusxj2QHRw(int i, short s) {
        return m940constructorimpl(i - m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    public static final byte m959mod7apg3OU(int i, byte b) {
        return UByte.m864constructorimpl((byte) UnsignedKt.m1194uintRemainderJ1ME1BU(i, m940constructorimpl(b & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    public static final long m960modVKZWuLQ(int i, long j) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(ULong.m1018constructorimpl(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    public static final int m961modWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1194uintRemainderJ1ME1BU(i, i2);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    public static final short m962modxj2QHRw(int i, short s) {
        return UShort.m1124constructorimpl((short) UnsignedKt.m1194uintRemainderJ1ME1BU(i, m940constructorimpl(s & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    public static final int m963orWZ4Q5Ns(int i, int i2) {
        return m940constructorimpl(i | i2);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    public static final int m964plus7apg3OU(int i, byte b) {
        return m940constructorimpl(i + m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    public static final long m965plusVKZWuLQ(int i, long j) {
        return ULong.m1018constructorimpl(ULong.m1018constructorimpl(i & 4294967295L) + j);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    public static final int m966plusWZ4Q5Ns(int i, int i2) {
        return m940constructorimpl(i + i2);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    public static final int m967plusxj2QHRw(int i, short s) {
        return m940constructorimpl(i + m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    public static final UIntRange m968rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    public static final int m969rem7apg3OU(int i, byte b) {
        return UnsignedKt.m1194uintRemainderJ1ME1BU(i, m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    public static final long m970remVKZWuLQ(int i, long j) {
        return UnsignedKt.m1196ulongRemaindereb3DHEI(ULong.m1018constructorimpl(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    public static final int m971remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1194uintRemainderJ1ME1BU(i, i2);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    public static final int m972remxj2QHRw(int i, short s) {
        return UnsignedKt.m1194uintRemainderJ1ME1BU(i, m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    public static final int m973shlpVg5ArA(int i, int i2) {
        return m940constructorimpl(i << i2);
    }

    @InlineOnly
    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    public static final int m974shrpVg5ArA(int i, int i2) {
        return m940constructorimpl(i >>> i2);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    public static final int m975times7apg3OU(int i, byte b) {
        return m940constructorimpl(i * m940constructorimpl(b & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    public static final long m976timesVKZWuLQ(int i, long j) {
        return ULong.m1018constructorimpl(ULong.m1018constructorimpl(i & 4294967295L) * j);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    public static final int m977timesWZ4Q5Ns(int i, int i2) {
        return m940constructorimpl(i * i2);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    public static final int m978timesxj2QHRw(int i, short s) {
        return m940constructorimpl(i * m940constructorimpl(s & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    public static final int m990xorWZ4Q5Ns(int i, int i2) {
        return m940constructorimpl(i ^ i2);
    }

    public String toString() {
        return m985toStringimpl(this.data);
    }
}
