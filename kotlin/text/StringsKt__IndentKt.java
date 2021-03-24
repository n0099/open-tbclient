package kotlin.text;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\u001a#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\t\u001a\u00020\u0006*\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aL\u0010\u0012\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010\r\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002H\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u000b\u001a%\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"", "indent", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "(Ljava/lang/String;)Lkotlin/Function1;", "getIndentFunction", "", "indentWidth$StringsKt__IndentKt", "(Ljava/lang/String;)I", "indentWidth", "prependIndent", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "(Ljava/util/List;ILkotlin/Function1;Lkotlin/Function1;)Ljava/lang/String;", "reindent", "newIndent", "replaceIndent", "marginPrefix", "replaceIndentByMargin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "trimIndent", "(Ljava/lang/String;)Ljava/lang/String;", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__IndentKt {
    public static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String str) {
        return str.length() == 0 ? StringsKt__IndentKt$getIndentFunction$1.INSTANCE : new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    public static final int indentWidth$StringsKt__IndentKt(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!CharsKt__CharJVMKt.isWhitespace(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    public static final String prependIndent(String str, String str2) {
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.map(StringsKt__StringsKt.lineSequence(str), new StringsKt__IndentKt$prependIndent$1(str2)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    public static final String reindent$StringsKt__IndentKt(List<String> list, int i, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        Appendable joinTo;
        String invoke;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if ((i2 == 0 || i2 == lastIndex) && StringsKt__StringsJVMKt.isBlank(str)) {
                str = null;
            } else {
                String invoke2 = function12.invoke(str);
                if (invoke2 != null && (invoke = function1.invoke(invoke2)) != null) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        joinTo = CollectionsKt___CollectionsKt.joinTo(arrayList, new StringBuilder(i), (r14 & 2) != 0 ? StringUtil.ARRAY_ELEMENT_SEPARATOR : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? StringHelper.STRING_MORE : null, (r14 & 64) != 0 ? null : null);
        String sb = ((StringBuilder) joinTo).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static final String replaceIndent(String str, String str2) {
        Appendable joinTo;
        String invoke;
        List<String> lines = StringsKt__StringsKt.lines(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : lines) {
            if (!StringsKt__StringsJVMKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String str3 : arrayList) {
            arrayList2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(str3)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.min((Iterable<? extends Comparable>) arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(str2);
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : lines) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == lastIndex) && StringsKt__StringsJVMKt.isBlank(str4)) {
                str4 = null;
            } else {
                String drop = StringsKt___StringsKt.drop(str4, intValue);
                if (drop != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) != null) {
                    str4 = invoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        joinTo = CollectionsKt___CollectionsKt.joinTo(arrayList3, new StringBuilder(length), (r14 & 2) != 0 ? StringUtil.ARRAY_ELEMENT_SEPARATOR : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? StringHelper.STRING_MORE : null, (r14 & 64) != 0 ? null : null);
        String sb = ((StringBuilder) joinTo).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    public static final String replaceIndentByMargin(String str, String str2, String str3) {
        Appendable joinTo;
        int i;
        String invoke;
        if (!StringsKt__StringsJVMKt.isBlank(str3)) {
            List<String> lines = StringsKt__StringsKt.lines(str);
            int length = str.length() + (str2.length() * lines.size());
            Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(str2);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : lines) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str4 = (String) obj;
                String str5 = null;
                if ((i2 == 0 || i2 == lastIndex) && StringsKt__StringsJVMKt.isBlank(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i = -1;
                            break;
                        } else if (!CharsKt__CharJVMKt.isWhitespace(str4.charAt(i4))) {
                            i = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i != -1 && StringsKt__StringsJVMKt.startsWith$default(str4, str3, i, false, 4, null)) {
                        int length3 = i + str3.length();
                        if (str4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        str5 = str4.substring(length3);
                        Intrinsics.checkExpressionValueIsNotNull(str5, "(this as java.lang.String).substring(startIndex)");
                    }
                    if (str5 != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(str5)) != null) {
                        str4 = invoke;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i2 = i3;
            }
            joinTo = CollectionsKt___CollectionsKt.joinTo(arrayList, new StringBuilder(length), (r14 & 2) != 0 ? StringUtil.ARRAY_ELEMENT_SEPARATOR : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? StringHelper.STRING_MORE : null, (r14 & 64) != 0 ? null : null);
            String sb = ((StringBuilder) joinTo).toString();
            Intrinsics.checkExpressionValueIsNotNull(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = FieldBuilder.SE;
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    public static final String trimIndent(String str) {
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String str2) {
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = FieldBuilder.SE;
        }
        return trimMargin(str, str2);
    }
}
