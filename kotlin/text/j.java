package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class j implements i {
    private final Matcher nCA;
    private final CharSequence nCr;
    private final g nCz;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.j(matcher, "matcher");
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        this.nCA = matcher;
        this.nCr = charSequence;
        this.nCz = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dJD() {
        return this.nCA;
    }

    @Override // kotlin.text.i
    public kotlin.b.c dJB() {
        kotlin.b.c a2;
        a2 = k.a(dJD());
        return a2;
    }

    /* loaded from: classes5.dex */
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
            return j.this.dJD().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.h(kotlin.collections.o.k(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f NF(int i) {
            kotlin.b.c a;
            a = k.a(j.this.dJD(), i);
            if (a.dJv().intValue() >= 0) {
                String group = j.this.dJD().group(i);
                kotlin.jvm.internal.q.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dJC() {
        i a2;
        int end = (dJD().end() == dJD().start() ? 1 : 0) + dJD().end();
        if (end <= this.nCr.length()) {
            Matcher matcher = this.nCA.pattern().matcher(this.nCr);
            kotlin.jvm.internal.q.i(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nCr);
            return a2;
        }
        return null;
    }
}
