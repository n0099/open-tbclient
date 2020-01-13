package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class j implements i {
    private final CharSequence nCm;
    private final g nCu;
    private final Matcher nCv;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.j(matcher, "matcher");
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        this.nCv = matcher;
        this.nCm = charSequence;
        this.nCu = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dJB() {
        return this.nCv;
    }

    @Override // kotlin.text.i
    public kotlin.b.c dJz() {
        kotlin.b.c a2;
        a2 = k.a(dJB());
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
            return j.this.dJB().groupCount() + 1;
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
            a = k.a(j.this.dJB(), i);
            if (a.dJt().intValue() >= 0) {
                String group = j.this.dJB().group(i);
                kotlin.jvm.internal.q.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dJA() {
        i a2;
        int end = (dJB().end() == dJB().start() ? 1 : 0) + dJB().end();
        if (end <= this.nCm.length()) {
            Matcher matcher = this.nCv.pattern().matcher(this.nCm);
            kotlin.jvm.internal.q.i(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nCm);
            return a2;
        }
        return null;
    }
}
