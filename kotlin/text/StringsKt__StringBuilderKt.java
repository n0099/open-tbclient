package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a5\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u001b\u0010\u0007\u001a\u0017\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0002\b\u0006H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\t\u001a\u00020\b2\u001b\u0010\u0007\u001a\u0017\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0002\b\u0006H\u0087\b¢\u0006\u0004\b\t\u0010\u000b\u001a7\u0010\u0012\u001a\u00028\u0000\"\f\b\u0000\u0010\u000e*\u00060\fj\u0002`\r*\u00028\u00002\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u000f\"\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0015\u001a1\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u000f\"\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0016\u001a;\u0010\u0019\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000e*\u00060\fj\u0002`\r2\u0006\u0010\u0017\u001a\u00028\u00002\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "capacity", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "buildString", "(ILkotlin/Function1;)Ljava/lang/String;", "(Lkotlin/Function1;)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "value", "append", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "element", "transform", "appendElement", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes7.dex */
public class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    public static final <T extends Appendable> T append(T t, CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    public static final <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) {
        if (function1 != null) {
            appendable.append(function1.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    @InlineOnly
    public static final String buildString(Function1<? super StringBuilder, Unit> function1) {
        StringBuilder sb = new StringBuilder();
        function1.invoke(sb);
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String buildString(int i, Function1<? super StringBuilder, Unit> function1) {
        StringBuilder sb = new StringBuilder(i);
        function1.invoke(sb);
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final StringBuilder append(StringBuilder sb, String... strArr) {
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    public static final StringBuilder append(StringBuilder sb, Object... objArr) {
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }
}
