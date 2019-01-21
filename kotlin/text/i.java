package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult iDk;
    private final f iDl;
    private final Matcher iDm;
    private final CharSequence iDn;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.j(matcher, "matcher");
        kotlin.jvm.internal.p.j(charSequence, "input");
        this.iDm = matcher;
        this.iDn = charSequence;
        this.iDk = this.iDm.toMatchResult();
        this.iDl = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cdx() {
        kotlin.b.c a2;
        MatchResult matchResult = this.iDk;
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
            return i.this.iDk.groupCount() + 1;
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
            MatchResult matchResult = i.this.iDk;
            kotlin.jvm.internal.p.i(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cds().intValue() >= 0) {
                String group = i.this.iDk.group(i);
                kotlin.jvm.internal.p.i(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cdy() {
        h a2;
        int end = (this.iDk.end() == this.iDk.start() ? 1 : 0) + this.iDk.end();
        if (end <= this.iDn.length()) {
            a2 = j.a(this.iDm, end, this.iDn);
            return a2;
        }
        return null;
    }
}
