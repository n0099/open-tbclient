package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult ipY;
    private final f ipZ;
    private final Matcher iqa;
    private final CharSequence iqb;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.i(matcher, "matcher");
        kotlin.jvm.internal.p.i(charSequence, "input");
        this.iqa = matcher;
        this.iqb = charSequence;
        this.ipY = this.iqa.toMatchResult();
        this.ipZ = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c caw() {
        kotlin.b.c a2;
        MatchResult matchResult = this.ipY;
        kotlin.jvm.internal.p.h((Object) matchResult, "matchResult");
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
            return i.this.ipY.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.f(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e ym(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.ipY;
            kotlin.jvm.internal.p.h((Object) matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.car().intValue() >= 0) {
                String group = i.this.ipY.group(i);
                kotlin.jvm.internal.p.h((Object) group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cax() {
        h a2;
        int end = (this.ipY.end() == this.ipY.start() ? 1 : 0) + this.ipY.end();
        if (end <= this.iqb.length()) {
            a2 = j.a(this.iqa, end, this.iqb);
            return a2;
        }
        return null;
    }
}
