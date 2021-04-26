package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\u001a&\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0007\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u0004\u0010\t\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u0004\u0010\u000b\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0004\u0010\r\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0004\u0010\u000f\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0011\u001a,\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0012\u001a4\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a4\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0019\u001a\u001b\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b*\u00060\u001aj\u0002`\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a$\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b¢\u0006\u0004\b\u001c\u0010\u001f\u001a&\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b*\u00060\u001aj\u0002`\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b¢\u0006\u0004\b\u001c\u0010 \u001a\u001b\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b\u001c\u0010!\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0005\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\b¢\u0006\u0004\b\u001c\u0010#\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020$H\u0087\b¢\u0006\u0004\b\u001c\u0010%\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0007\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b¢\u0006\u0004\b\u001c\u0010&\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b\u001c\u0010'\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b¢\u0006\u0004\b\u001c\u0010(\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u001c\u0010\t\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u001c\u0010\u000b\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u001c\u0010\r\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u001c\u0010\u000f\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0011\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010)H\u0087\b¢\u0006\u0004\b\u001c\u0010*\u001a,\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0012\u001a\u001b\u0010+\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b+\u0010!\u001a$\u0010-\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\r\u001a,\u0010.\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0087\b¢\u0006\u0004\b.\u0010/\u001a<\u00100\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0087\b¢\u0006\u0004\b0\u00101\u001a<\u00100\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0087\b¢\u0006\u0004\b0\u00102\u001a(\u00104\u001a\u000203*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\n¢\u0006\u0004\b4\u00105\u001a4\u00106\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020)H\u0087\b¢\u0006\u0004\b6\u00107\u001a>\u0010:\u001a\u000203*\u00060\u0000j\u0002`\u00012\u0006\u00108\u001a\u00020\u00132\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0087\b¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuffer;", "value", "appendLine", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuffer;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;B)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;D)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;F)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;I)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;J)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;S)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "startIndex", "endIndex", "appendRange", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "appendln", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "clear", "index", "deleteAt", "deleteRange", "(Ljava/lang/StringBuilder;II)Ljava/lang/StringBuilder;", "insertRange", "(Ljava/lang/StringBuilder;I[CII)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;ILjava/lang/CharSequence;II)Ljava/lang/StringBuilder;", "", "set", "(Ljava/lang/StringBuilder;IC)V", "setRange", "(Ljava/lang/StringBuilder;IILjava/lang/String;)Ljava/lang/StringBuilder;", "destination", "destinationOffset", "toCharArray", "(Ljava/lang/StringBuilder;[CIII)V", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes7.dex */
public class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder appendRange(StringBuilder sb, char[] cArr, int i2, int i3) {
        sb.append(cArr, i2, i3 - i2);
        Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, start…x, endIndex - startIndex)");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable appendln) {
        Intrinsics.checkNotNullParameter(appendln, "$this$appendln");
        Appendable append = appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @SinceKotlin(version = "1.3")
    public static final StringBuilder clear(StringBuilder clear) {
        Intrinsics.checkNotNullParameter(clear, "$this$clear");
        clear.setLength(0);
        return clear;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder deleteAt(StringBuilder sb, int i2) {
        StringBuilder deleteCharAt = sb.deleteCharAt(i2);
        Intrinsics.checkNotNullExpressionValue(deleteCharAt, "this.deleteCharAt(index)");
        return deleteCharAt;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder deleteRange(StringBuilder sb, int i2, int i3) {
        StringBuilder delete = sb.delete(i2, i3);
        Intrinsics.checkNotNullExpressionValue(delete, "this.delete(startIndex, endIndex)");
        return delete;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder insertRange(StringBuilder sb, int i2, char[] cArr, int i3, int i4) {
        StringBuilder insert = sb.insert(i2, cArr, i3, i4 - i3);
        Intrinsics.checkNotNullExpressionValue(insert, "this.insert(index, value…x, endIndex - startIndex)");
        return insert;
    }

    @InlineOnly
    public static final void set(StringBuilder set, int i2, char c2) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.setCharAt(i2, c2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder setRange(StringBuilder sb, int i2, int i3, String str) {
        StringBuilder replace = sb.replace(i2, i3, str);
        Intrinsics.checkNotNullExpressionValue(replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final void toCharArray(StringBuilder sb, char[] cArr, int i2, int i3, int i4) {
        sb.getChars(i3, i4, cArr, i2);
    }

    public static /* synthetic */ void toCharArray$default(StringBuilder sb, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sb.length();
        }
        sb.getChars(i3, i4, cArr, i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder appendRange(StringBuilder sb, CharSequence charSequence, int i2, int i3) {
        sb.append(charSequence, i2, i3);
        Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final Appendable appendln(Appendable appendable, CharSequence charSequence) {
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final StringBuilder insertRange(StringBuilder sb, int i2, CharSequence charSequence, int i3, int i4) {
        StringBuilder insert = sb.insert(i2, charSequence, i3, i4);
        Intrinsics.checkNotNullExpressionValue(insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, int i2) {
        sb.append(i2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final Appendable appendln(Appendable appendable, char c2) {
        Appendable append = appendable.append(c2);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, short s) {
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value.toInt())");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder appendln(StringBuilder appendln) {
        Intrinsics.checkNotNullParameter(appendln, "$this$appendln");
        appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(appendln, "append(SystemProperties.LINE_SEPARATOR)");
        return appendln;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, byte b2) {
        sb.append((int) b2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value.toInt())");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, long j) {
        sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, float f2) {
        sb.append(f2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, String str) {
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final StringBuilder appendLine(StringBuilder sb, double d2) {
        sb.append(d2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, Object obj) {
        sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, char c2) {
        sb.append(c2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, boolean z) {
        sb.append(z);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, int i2) {
        sb.append(i2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, short s) {
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value.toInt())");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, byte b2) {
        sb.append((int) b2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value.toInt())");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, long j) {
        sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, float f2) {
        sb.append(f2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    public static final StringBuilder appendln(StringBuilder sb, double d2) {
        sb.append(d2);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        return appendln(sb);
    }
}
