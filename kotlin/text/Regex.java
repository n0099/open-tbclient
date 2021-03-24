package kotlin.text;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 72\u00020\u0001:\u000278B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020\u0014¢\u0006\u0004\b1\u00102B\u0019\b\u0016\u0012\u0006\u00100\u001a\u00020\u0014\u0012\u0006\u00103\u001a\u00020'¢\u0006\u0004\b1\u00104B\u001f\b\u0016\u0012\u0006\u00100\u001a\u00020\u0014\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b1\u00105B\u0011\b\u0001\u0012\u0006\u0010*\u001a\u00020\u001e¢\u0006\u0004\b1\u00106J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004¢\u0006\u0004\b\u0011\u0010\u0006J)\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0019\u0010.\u001a\b\u0012\u0004\u0012\u00020'0&8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0013\u00100\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b/\u0010\"¨\u00069"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "", Config.INPUT_PART, "", "containsMatchIn", "(Ljava/lang/CharSequence;)Z", "", "startIndex", "Lkotlin/text/MatchResult;", "find", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "Lkotlin/sequences/Sequence;", "findAll", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "matchEntire", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "matches", "Lkotlin/Function1;", "transform", "", "replace", "(Ljava/lang/CharSequence;Lkotlin/Function1;)Ljava/lang/String;", "replacement", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "replaceFirst", Constants.EXTRA_CONFIG_LIMIT, "", "split", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "Ljava/util/regex/Pattern;", "toPattern", "()Ljava/util/regex/Pattern;", "toString", "()Ljava/lang/String;", "", "writeReplace", "()Ljava/lang/Object;", "", "Lkotlin/text/RegexOption;", "_options", "Ljava/util/Set;", "nativePattern", "Ljava/util/regex/Pattern;", "getOptions", "()Ljava/util/Set;", "options", "getPattern", "pattern", "<init>", "(Ljava/lang/String;)V", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "(Ljava/lang/String;Ljava/util/Set;)V", "(Ljava/util/regex/Pattern;)V", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class Regex implements Serializable {
    public static final Companion Companion = new Companion(null);
    public Set<? extends RegexOption> _options;
    public final Pattern nativePattern;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "flags", "ensureUnicodeCase", "(I)I", "", "literal", "escape", "(Ljava/lang/String;)Ljava/lang/String;", "escapeReplacement", "Lkotlin/text/Regex;", "fromLiteral", "(Ljava/lang/String;)Lkotlin/text/Regex;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int ensureUnicodeCase(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        public final String escape(String str) {
            String quote = Pattern.quote(str);
            Intrinsics.checkExpressionValueIsNotNull(quote, "Pattern.quote(literal)");
            return quote;
        }

        public final String escapeReplacement(String str) {
            String quoteReplacement = Matcher.quoteReplacement(str);
            Intrinsics.checkExpressionValueIsNotNull(quoteReplacement, "Matcher.quoteReplacement(literal)");
            return quoteReplacement;
        }

        public final Regex fromLiteral(String str) {
            return new Regex(str, RegexOption.LITERAL);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "", "flags", "I", "getFlags", "()I", "", "pattern", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        public static final long serialVersionUID = 0;
        public final int flags;
        public final String pattern;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes7.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(String str, int i) {
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    @PublishedApi
    public Regex(Pattern pattern) {
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkExpressionValueIsNotNull(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).find();
    }

    public final MatchResult find(CharSequence charSequence, int i) {
        Matcher matcher = this.nativePattern.matcher(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "nativePattern.matcher(input)");
        return RegexKt.access$findNext(matcher, i, charSequence);
    }

    public final Sequence<MatchResult> findAll(CharSequence charSequence, int i) {
        return SequencesKt__SequencesKt.generateSequence((Function0) new Regex$findAll$1(this, charSequence, i), (Function1) Regex$findAll$2.INSTANCE);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Set<? extends kotlin.text.RegexOption>, java.util.Set<kotlin.text.RegexOption> */
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        CollectionsKt__MutableCollectionsKt.retainAll(allOf, new Regex$fromInt$$inlined$apply$lambda$1(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkExpressionValueIsNotNull(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final MatchResult matchEntire(CharSequence charSequence) {
        Matcher matcher = this.nativePattern.matcher(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "nativePattern.matcher(input)");
        return RegexKt.access$matchEntire(matcher, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, String str) {
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        Intrinsics.checkExpressionValueIsNotNull(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        Intrinsics.checkExpressionValueIsNotNull(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i) {
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (matcher.find() && i != 1) {
                ArrayList arrayList = new ArrayList(i > 0 ? RangesKt___RangesKt.coerceAtMost(i, 10) : 10);
                int i3 = i - 1;
                do {
                    arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                    i2 = matcher.end();
                    if (i3 >= 0 && arrayList.size() == i3) {
                        break;
                    }
                } while (matcher.find());
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
            return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + IStringUtil.EXTENSION_SEPARATOR).toString());
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkExpressionValueIsNotNull(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str) {
        this(r2);
        Pattern compile = Pattern.compile(str);
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern)");
    }

    public final String replace(CharSequence charSequence, Function1<? super MatchResult, ? extends CharSequence> function1) {
        int i = 0;
        MatchResult find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default != null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            do {
                if (find$default == null) {
                    Intrinsics.throwNpe();
                }
                sb.append(charSequence, i, find$default.getRange().getStart().intValue());
                sb.append(function1.invoke(find$default));
                i = find$default.getRange().getEndInclusive().intValue() + 1;
                find$default = find$default.next();
                if (i >= length) {
                    break;
                }
            } while (find$default != null);
            if (i < length) {
                sb.append(charSequence, i, length);
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            return sb2;
        }
        return charSequence.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str, RegexOption regexOption) {
        this(r2);
        Pattern compile = Pattern.compile(str, Companion.ensureUnicodeCase(regexOption.getValue()));
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern,…nicodeCase(option.value))");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str, Set<? extends RegexOption> set) {
        this(r2);
        Pattern compile = Pattern.compile(str, Companion.ensureUnicodeCase(RegexKt.access$toInt(set)));
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
    }
}
