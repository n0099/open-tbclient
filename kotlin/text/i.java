package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult iDj;
    private final f iDk;
    private final Matcher iDl;
    private final CharSequence iDm;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.j(matcher, "matcher");
        kotlin.jvm.internal.p.j(charSequence, "input");
        this.iDl = matcher;
        this.iDm = charSequence;
        this.iDj = this.iDl.toMatchResult();
        this.iDk = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cdx() {
        kotlin.b.c a2;
        MatchResult matchResult = this.iDj;
        kotlin.jvm.internal.p.i(matchResult, "matchResult");
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
            return i.this.iDj.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e zr(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.iDj;
            kotlin.jvm.internal.p.i(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cds().intValue() >= 0) {
                String group = i.this.iDj.group(i);
                kotlin.jvm.internal.p.i(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cdy() {
        h a2;
        int end = (this.iDj.end() == this.iDj.start() ? 1 : 0) + this.iDj.end();
        if (end <= this.iDm.length()) {
            a2 = j.a(this.iDl, end, this.iDm);
            return a2;
        }
        return null;
    }
}
