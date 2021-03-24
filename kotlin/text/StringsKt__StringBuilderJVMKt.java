package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a$\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0006\u001a&\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007H\u0087\b¢\u0006\u0004\b\u0002\u0010\b\u001a\u0019\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\u000b\u001a&\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0087\b¢\u0006\u0004\b\u0002\u0010\r\u001a&\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0087\b¢\u0006\u0004\b\u0002\u0010\u000f\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0011\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0013\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0014\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0016\u001a&\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0017\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0019\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\b¢\u0006\u0004\b\u0002\u0010\u001b\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u001cH\u0087\b¢\u0006\u0004\b\u0002\u0010\u001d\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u001eH\u0087\b¢\u0006\u0004\b\u0002\u0010\u001f\u001a$\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020 H\u0087\b¢\u0006\u0004\b\u0002\u0010!\u001a&\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\"H\u0087\b¢\u0006\u0004\b\u0002\u0010#\u001a,\u0010\u0002\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\n2\u000e\u0010\u0005\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0087\b¢\u0006\u0004\b\u0002\u0010$\u001a\u001b\u0010%\u001a\u00060\tj\u0002`\n*\u00060\tj\u0002`\nH\u0007¢\u0006\u0004\b%\u0010\u000b\u001a(\u0010(\u001a\u00020'*\u00060\tj\u0002`\n2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0087\n¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "appendln", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "value", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "Ljava/lang/StringBuffer;", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuffer;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;B)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;D)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;F)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;I)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;J)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;S)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "clear", "index", "", "set", "(Ljava/lang/StringBuilder;IC)V", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public static final Appendable appendln(Appendable appendable) {
        Appendable append = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @SinceKotlin(version = "1.3")
    public static final StringBuilder clear(StringBuilder sb) {
        sb.setLength(0);
        return sb;
    }

    @InlineOnly
    public static final void set(StringBuilder sb, int i, char c2) {
        sb.setCharAt(i, c2);
    }

    @InlineOnly
    public static final Appendable appendln(Appendable appendable, CharSequence charSequence) {
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return appendln(append);
    }

    @InlineOnly
    public static final Appendable appendln(Appendable appendable, char c2) {
        Appendable append = appendable.append(c2);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return appendln(append);
    }

    public static final StringBuilder appendln(StringBuilder sb) {
        sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, String str) {
        sb.append(str);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, Object obj) {
        sb.append(obj);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, char c2) {
        sb.append(c2);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, boolean z) {
        sb.append(z);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, int i) {
        sb.append(i);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, short s) {
        sb.append((int) s);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value.toInt())");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, byte b2) {
        sb.append((int) b2);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value.toInt())");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, long j) {
        sb.append(j);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, float f2) {
        sb.append(f2);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }

    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, double d2) {
        sb.append(d2);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return appendln(sb);
    }
}
