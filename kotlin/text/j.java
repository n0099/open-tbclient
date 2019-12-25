package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j implements i {
    private final CharSequence mZD;
    private final MatchResult mZL;
    private final g mZM;
    private final Matcher mZN;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.j(matcher, "matcher");
        kotlin.jvm.internal.p.j(charSequence, Config.INPUT_PART);
        this.mZN = matcher;
        this.mZD = charSequence;
        this.mZL = this.mZN.toMatchResult();
        this.mZM = new a();
    }

    @Override // kotlin.text.i
    public kotlin.b.c dFd() {
        kotlin.b.c a2;
        MatchResult matchResult = this.mZL;
        kotlin.jvm.internal.p.i(matchResult, "matchResult");
        a2 = k.a(matchResult);
        return a2;
    }

    /* loaded from: classes4.dex */
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
            return j.this.mZL.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.h(kotlin.collections.n.k(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f MQ(int i) {
            kotlin.b.c a;
            MatchResult matchResult = j.this.mZL;
            kotlin.jvm.internal.p.i(matchResult, "matchResult");
            a = k.a(matchResult, i);
            if (a.dEX().intValue() >= 0) {
                String group = j.this.mZL.group(i);
                kotlin.jvm.internal.p.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dFe() {
        i a2;
        int end = (this.mZL.end() == this.mZL.start() ? 1 : 0) + this.mZL.end();
        if (end <= this.mZD.length()) {
            a2 = k.a(this.mZN, end, this.mZD);
            return a2;
        }
        return null;
    }
}
