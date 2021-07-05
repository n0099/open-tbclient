package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.base.CharEncoding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0013\u0010\n\u001a\u00020\u00018G@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\f\u001a\u00020\u00018G@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u000e\u001a\u00020\u00018G@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003¨\u0006\u0015"}, d2 = {"Lkotlin/text/Charsets;", "Ljava/nio/charset/Charset;", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF32_BE", "UTF_32BE", "UTF32_LE", "UTF_32LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class Charsets {
    public static final Charsets INSTANCE = new Charsets();
    @JvmField
    public static final Charset ISO_8859_1;
    @JvmField
    public static final Charset US_ASCII;
    @JvmField
    public static final Charset UTF_16;
    @JvmField
    public static final Charset UTF_16BE;
    @JvmField
    public static final Charset UTF_16LE;
    @JvmField
    public static final Charset UTF_8;
    public static Charset utf_32;
    public static Charset utf_32be;
    public static Charset utf_32le;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-8\")");
        UTF_8 = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(forName2, "Charset.forName(\"UTF-16\")");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName(CharEncoding.UTF_16BE);
        Intrinsics.checkNotNullExpressionValue(forName3, "Charset.forName(\"UTF-16BE\")");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName(CharEncoding.UTF_16LE);
        Intrinsics.checkNotNullExpressionValue(forName4, "Charset.forName(\"UTF-16LE\")");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(forName5, "Charset.forName(\"US-ASCII\")");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(forName6, "Charset.forName(\"ISO-8859-1\")");
        ISO_8859_1 = forName6;
    }

    @JvmName(name = "UTF32")
    public final Charset UTF32() {
        Charset charset = utf_32;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-32\")");
        utf_32 = forName;
        return forName;
    }

    @JvmName(name = "UTF32_BE")
    public final Charset UTF32_BE() {
        Charset charset = utf_32be;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-32BE\")");
        utf_32be = forName;
        return forName;
    }

    @JvmName(name = "UTF32_LE")
    public final Charset UTF32_LE() {
        Charset charset = utf_32le;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-32LE\")");
        utf_32le = forName;
        return forName;
    }
}
