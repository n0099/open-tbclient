package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult irI;
    private final f irJ;
    private final Matcher irK;
    private final CharSequence irL;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.h((Object) matcher, "matcher");
        kotlin.jvm.internal.p.h((Object) charSequence, "input");
        this.irK = matcher;
        this.irL = charSequence;
        this.irI = this.irK.toMatchResult();
        this.irJ = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c bZT() {
        kotlin.b.c a2;
        MatchResult matchResult = this.irI;
        kotlin.jvm.internal.p.g(matchResult, "matchResult");
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
            return i.this.irI.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e yF(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.irI;
            kotlin.jvm.internal.p.g(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.bZO().intValue() >= 0) {
                String group = i.this.irI.group(i);
                kotlin.jvm.internal.p.g(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h bZU() {
        h a2;
        int end = (this.irI.end() == this.irI.start() ? 1 : 0) + this.irI.end();
        if (end <= this.irL.length()) {
            a2 = j.a(this.irK, end, this.irL);
            return a2;
        }
        return null;
    }
}
