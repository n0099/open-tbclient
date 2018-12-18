package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult iyS;
    private final f iyT;
    private final Matcher iyU;
    private final CharSequence iyV;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.h((Object) matcher, "matcher");
        kotlin.jvm.internal.p.h((Object) charSequence, "input");
        this.iyU = matcher;
        this.iyV = charSequence;
        this.iyS = this.iyU.toMatchResult();
        this.iyT = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cbY() {
        kotlin.b.c a2;
        MatchResult matchResult = this.iyS;
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
            return i.this.iyS.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e zc(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.iyS;
            kotlin.jvm.internal.p.g(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cbT().intValue() >= 0) {
                String group = i.this.iyS.group(i);
                kotlin.jvm.internal.p.g(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cbZ() {
        h a2;
        int end = (this.iyS.end() == this.iyS.start() ? 1 : 0) + this.iyS.end();
        if (end <= this.iyV.length()) {
            a2 = j.a(this.iyU, end, this.iyV);
            return a2;
        }
        return null;
    }
}
