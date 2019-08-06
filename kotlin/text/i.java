package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final f ktA;
    private final Matcher ktB;
    private final CharSequence ktC;
    private final MatchResult ktz;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.k(matcher, "matcher");
        kotlin.jvm.internal.p.k(charSequence, Config.INPUT_PART);
        this.ktB = matcher;
        this.ktC = charSequence;
        this.ktz = this.ktB.toMatchResult();
        this.ktA = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cOq() {
        kotlin.b.c a2;
        MatchResult matchResult = this.ktz;
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
            return i.this.ktz.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e EI(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.ktz;
            kotlin.jvm.internal.p.j(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cOl().intValue() >= 0) {
                String group = i.this.ktz.group(i);
                kotlin.jvm.internal.p.j(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cOr() {
        h a2;
        int end = (this.ktz.end() == this.ktz.start() ? 1 : 0) + this.ktz.end();
        if (end <= this.ktC.length()) {
            a2 = j.a(this.ktB, end, this.ktC);
            return a2;
        }
        return null;
    }
}
