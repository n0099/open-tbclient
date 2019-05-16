package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult kkQ;
    private final f kkR;
    private final Matcher kkS;
    private final CharSequence kkT;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.k(matcher, "matcher");
        kotlin.jvm.internal.p.k(charSequence, "input");
        this.kkS = matcher;
        this.kkT = charSequence;
        this.kkQ = this.kkS.toMatchResult();
        this.kkR = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cKk() {
        kotlin.b.c a2;
        MatchResult matchResult = this.kkQ;
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
            return i.this.kkQ.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e DX(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.kkQ;
            kotlin.jvm.internal.p.j(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cKf().intValue() >= 0) {
                String group = i.this.kkQ.group(i);
                kotlin.jvm.internal.p.j(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cKl() {
        h a2;
        int end = (this.kkQ.end() == this.kkQ.start() ? 1 : 0) + this.kkQ.end();
        if (end <= this.kkT.length()) {
            a2 = j.a(this.kkS, end, this.kkT);
            return a2;
        }
        return null;
    }
}
