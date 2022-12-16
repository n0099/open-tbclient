package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\t\u0010\r\u001a\u00020\u0001H\u0087\b\u001a\u0013\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "ConsoleKt")
/* loaded from: classes9.dex */
public final class ConsoleKt {
    @InlineOnly
    public static final void print(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    @InlineOnly
    public static final void println(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    @InlineOnly
    public static final void print(char c) {
        System.out.print(c);
    }

    @InlineOnly
    public static final void println(char c) {
        System.out.println(c);
    }

    @InlineOnly
    public static final void print(double d) {
        System.out.print(d);
    }

    @InlineOnly
    public static final void println(double d) {
        System.out.println(d);
    }

    @InlineOnly
    public static final void print(float f) {
        System.out.print(f);
    }

    @InlineOnly
    public static final void println(float f) {
        System.out.println(f);
    }

    @InlineOnly
    public static final void print(int i) {
        System.out.print(i);
    }

    @InlineOnly
    public static final void println(int i) {
        System.out.println(i);
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
    public static final void print(Object obj) {
        System.out.print(obj);
    }

    @InlineOnly
    public static final void println(Object obj) {
        System.out.println(obj);
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
    public static final void print(boolean z) {
        System.out.print(z);
    }

    @InlineOnly
    public static final void println(boolean z) {
        System.out.println(z);
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

    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "System.`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "Charset.defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }
}
