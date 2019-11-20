package kotlin.text;

import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.mobstat.Config;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(Pattern pattern) {
        kotlin.jvm.internal.p.i(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str) {
        this(r0);
        kotlin.jvm.internal.p.i(str, "pattern");
        Pattern compile = Pattern.compile(str);
        kotlin.jvm.internal.p.h(compile, "Pattern.compile(pattern)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str, RegexOption regexOption) {
        this(r0);
        kotlin.jvm.internal.p.i(str, "pattern");
        kotlin.jvm.internal.p.i(regexOption, "option");
        Pattern compile = Pattern.compile(str, Companion.Dj(regexOption.getValue()));
        kotlin.jvm.internal.p.h(compile, "Pattern.compile(pattern,…nicodeCase(option.value))");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str, Set<? extends RegexOption> set) {
        this(r0);
        int e;
        kotlin.jvm.internal.p.i(str, "pattern");
        kotlin.jvm.internal.p.i(set, "options");
        a aVar = Companion;
        e = j.e(set);
        Pattern compile = Pattern.compile(str, aVar.Dj(e));
        kotlin.jvm.internal.p.h(compile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.p.h(pattern, "nativePattern.pattern()");
        return pattern;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Set<? extends kotlin.text.RegexOption>, java.util.Set<kotlin.text.RegexOption> */
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        kotlin.collections.n.a(allOf, new Regex$fromInt$$inlined$apply$lambda$1(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        kotlin.jvm.internal.p.h(unmodifiableSet, "Collections.unmodifiable… == it.value }\n        })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final boolean matches(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        return this.nativePattern.matcher(charSequence).find();
    }

    public static /* synthetic */ h find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final h find(CharSequence charSequence, int i) {
        h a2;
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.p.h(matcher, "nativePattern.matcher(input)");
        a2 = j.a(matcher, i, charSequence);
        return a2;
    }

    public static /* synthetic */ kotlin.sequences.c findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final kotlin.sequences.c<h> findAll(CharSequence charSequence, int i) {
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        return kotlin.sequences.d.a(new Regex$findAll$1(this, charSequence, i), Regex$findAll$2.INSTANCE);
    }

    public final h matchEntire(CharSequence charSequence) {
        h a2;
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.p.h(matcher, "nativePattern.matcher(input)");
        a2 = j.a(matcher, charSequence);
        return a2;
    }

    public final String replace(CharSequence charSequence, String str) {
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.i(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        kotlin.jvm.internal.p.h(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replace(CharSequence charSequence, kotlin.jvm.a.b<? super h, ? extends CharSequence> bVar) {
        int i = 0;
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.i(bVar, "transform");
        h find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            if (find$default == null) {
                kotlin.jvm.internal.p.cMW();
            }
            sb.append(charSequence, i, find$default.cNh().cNc().intValue());
            sb.append(bVar.invoke(find$default));
            i = find$default.cNh().cNd().intValue() + 1;
            find$default = find$default.cNi();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.p.h(sb2, "sb.toString()");
        return sb2;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.i(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        kotlin.jvm.internal.p.h(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final List<String> split(CharSequence charSequence, int i) {
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        if (i >= 0) {
            Pattern pattern = this.nativePattern;
            if (i == 0) {
                i = -1;
            }
            String[] split = pattern.split(charSequence, i);
            kotlin.jvm.internal.p.h(split, "nativePattern.split(inpu…imit == 0) -1 else limit)");
            return kotlin.collections.f.asList(split);
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + BdFileHelper.EXTENSION_SEPARATOR).toString());
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.p.h(pattern, "nativePattern.toString()");
        return pattern;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.p.h(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    /* loaded from: classes2.dex */
    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
                this();
            }
        }

        public Serialized(String str, int i) {
            kotlin.jvm.internal.p.i(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.p.h(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int Dj(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }
    }
}
