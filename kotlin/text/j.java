package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence mYM;
    private final g mYU;
    private final Matcher mYV;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.j(matcher, "matcher");
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        this.mYV = matcher;
        this.mYM = charSequence;
        this.mYU = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dEp() {
        return this.mYV;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dEn() {
        kotlin.b.h a2;
        a2 = k.a(dEp());
        return a2;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a extends kotlin.collections.a<f> implements h {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        public boolean a(f fVar) {
            return super.contains(fVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj != null ? obj instanceof f : true) {
                return a((f) obj);
            }
            return false;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return j.this.dEp().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.i(kotlin.collections.o.k(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Ji(int i) {
            kotlin.b.h a;
            a = k.a(j.this.dEp(), i);
            if (a.dEe().intValue() >= 0) {
                String group = j.this.dEp().group(i);
                kotlin.jvm.internal.q.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dEo() {
        i a2;
        int end = (dEp().end() == dEp().start() ? 1 : 0) + dEp().end();
        if (end <= this.mYM.length()) {
            Matcher matcher = this.mYV.pattern().matcher(this.mYM);
            kotlin.jvm.internal.q.i(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.mYM);
            return a2;
        }
        return null;
    }
}
