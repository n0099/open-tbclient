package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ljava/util/regex/Pattern;", "Lkotlin/text/Regex;", "toRegex", "(Ljava/util/regex/Pattern;)Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes10.dex */
public class StringsKt__RegexExtensionsJVMKt extends StringsKt__IndentKt {
    @InlineOnly
    public static final Regex toRegex(Pattern pattern) {
        return new Regex(pattern);
    }
}
