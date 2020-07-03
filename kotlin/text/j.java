package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence nQL;
    private final g nQT;
    private final Matcher nQU;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.m(matcher, "matcher");
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        this.nQU = matcher;
        this.nQL = charSequence;
        this.nQT = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dRd() {
        return this.nQU;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dRb() {
        kotlin.b.h a2;
        a2 = k.a(dRd());
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
            return j.this.dRd().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.i(kotlin.collections.o.m(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Lc(int i) {
            kotlin.b.h a;
            a = k.a(j.this.dRd(), i);
            if (a.dQS().intValue() >= 0) {
                String group = j.this.dRd().group(i);
                kotlin.jvm.internal.q.l((Object) group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dRc() {
        i a2;
        int end = (dRd().end() == dRd().start() ? 1 : 0) + dRd().end();
        if (end <= this.nQL.length()) {
            Matcher matcher = this.nQU.pattern().matcher(this.nQL);
            kotlin.jvm.internal.q.l((Object) matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nQL);
            return a2;
        }
        return null;
    }
}
