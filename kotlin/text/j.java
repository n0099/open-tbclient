package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public final class j implements i {
    private final CharSequence qmV;
    private final MatchResult qnd;
    private final g qne;
    private final Matcher qnf;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.o(matcher, "matcher");
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        this.qnf = matcher;
        this.qmV = charSequence;
        this.qnd = this.qnf.toMatchResult();
        this.qne = new a();
    }

    @Override // kotlin.text.i
    public kotlin.b.h eMA() {
        kotlin.b.h a2;
        MatchResult matchResult = this.qnd;
        kotlin.jvm.internal.p.n(matchResult, "matchResult");
        a2 = k.a(matchResult);
        return a2;
    }

    @kotlin.e
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
            return j.this.qnd.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.i(kotlin.collections.n.n(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Tq(int i) {
            kotlin.b.h a2;
            MatchResult matchResult = j.this.qnd;
            kotlin.jvm.internal.p.n(matchResult, "matchResult");
            a2 = k.a(matchResult, i);
            if (a2.eMr().intValue() >= 0) {
                String group = j.this.qnd.group(i);
                kotlin.jvm.internal.p.n(group, "matchResult.group(index)");
                return new f(group, a2);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i eMB() {
        i a2;
        int end = (this.qnd.end() == this.qnd.start() ? 1 : 0) + this.qnd.end();
        if (end <= this.qmV.length()) {
            a2 = k.a(this.qnf, end, this.qmV);
            return a2;
        }
        return null;
    }
}
