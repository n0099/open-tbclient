package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0003\u0010\b\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\u0003\u0010\f\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0003\u0010\u000e\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0012\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0014\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0004\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0006\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0017\u0010\b\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0017\u0010\n\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\u0017\u0010\f\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0017\u0010\u000e\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0012\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"", "message", "", "print", "(Ljava/lang/Object;)V", "", "(Z)V", "", "(B)V", "", "(C)V", "", "([C)V", "", "(D)V", "", "(F)V", "", "(I)V", "", "(J)V", "", "(S)V", "println", "()V", "", "readLine", "()Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "ConsoleKt")
/* loaded from: classes10.dex */
public final class ConsoleKt {
    @InlineOnly
    public static final void print(Object obj) {
        System.out.print(obj);
    }

    @InlineOnly
    public static final void println(Object obj) {
        System.out.println(obj);
    }

    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "System.`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "Charset.defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }

    @InlineOnly
    public static final void print(int i2) {
        System.out.print(i2);
    }

    @InlineOnly
    public static final void println(int i2) {
        System.out.println(i2);
    }

    @InlineOnly
    public static final void print(long j) {
        System.out.print(j);
    }

    @InlineOnly
    public static final void println(long j) {
        System.out.println(j);
    }

    @InlineOnly
    public static final void print(byte b2) {
        System.out.print(Byte.valueOf(b2));
    }

    @InlineOnly
    public static final void println(byte b2) {
        System.out.println(Byte.valueOf(b2));
    }

    @InlineOnly
    public static final void print(short s) {
        System.out.print(Short.valueOf(s));
    }

    @InlineOnly
    public static final void println(short s) {
        System.out.println(Short.valueOf(s));
    }

    @InlineOnly
    public static final void print(char c2) {
        System.out.print(c2);
    }

    @InlineOnly
    public static final void println(char c2) {
        System.out.println(c2);
    }

    @InlineOnly
    public static final void print(boolean z) {
        System.out.print(z);
    }

    @InlineOnly
    public static final void println(boolean z) {
        System.out.println(z);
    }

    @InlineOnly
    public static final void print(float f2) {
        System.out.print(f2);
    }

    @InlineOnly
    public static final void println(float f2) {
        System.out.println(f2);
    }

    @InlineOnly
    public static final void print(double d2) {
        System.out.print(d2);
    }

    @InlineOnly
    public static final void println(double d2) {
        System.out.println(d2);
    }

    @InlineOnly
    public static final void print(char[] cArr) {
        System.out.print(cArr);
    }

    @InlineOnly
    public static final void println(char[] cArr) {
        System.out.println(cArr);
    }

    @InlineOnly
    public static final void println() {
        System.out.println();
    }
}
