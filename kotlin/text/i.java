package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult jTg;
    private final f jTh;
    private final Matcher jTi;
    private final CharSequence jTj;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.k(matcher, "matcher");
        kotlin.jvm.internal.p.k(charSequence, "input");
        this.jTi = matcher;
        this.jTj = charSequence;
        this.jTg = this.jTi.toMatchResult();
        this.jTh = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cCP() {
        kotlin.b.c a2;
        MatchResult matchResult = this.jTg;
        kotlin.jvm.internal.p.j(matchResult, "matchResult");
        a2 = j.a(matchResult);
        return a2;
    }

    /* loaded from: classes2.dex */
    public static final class a extends kotlin.collections.a<e> implements g {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        public boolean a(e eVar) {
            return super.contains(eVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj != null ? obj instanceof e : true) {
                return a((e) obj);
            }
            return false;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return i.this.jTg.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e De(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.jTg;
            kotlin.jvm.internal.p.j(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cCK().intValue() >= 0) {
                String group = i.this.jTg.group(i);
                kotlin.jvm.internal.p.j(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cCQ() {
        h a2;
        int end = (this.jTg.end() == this.jTg.start() ? 1 : 0) + this.jTg.end();
        if (end <= this.jTj.length()) {
            a2 = j.a(this.jTi, end, this.jTj);
            return a2;
        }
        return null;
    }
}
