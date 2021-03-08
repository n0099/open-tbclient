package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes14.dex */
public final class j implements i {
    private final CharSequence qvi;
    private final MatchResult qvp;
    private final g qvq;
    private final Matcher qvr;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.p(matcher, "matcher");
        kotlin.jvm.internal.p.p(charSequence, Config.INPUT_PART);
        this.qvr = matcher;
        this.qvi = charSequence;
        this.qvp = this.qvr.toMatchResult();
        this.qvq = new a();
    }

    @Override // kotlin.text.i
    public kotlin.b.h eLu() {
        kotlin.b.h a2;
        MatchResult matchResult = this.qvp;
        kotlin.jvm.internal.p.o(matchResult, "matchResult");
        a2 = k.a(matchResult);
        return a2;
    }

    @kotlin.e
    /* loaded from: classes14.dex */
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
            return j.this.qvp.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.i(kotlin.collections.n.o(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Su(int i) {
            kotlin.b.h a2;
            MatchResult matchResult = j.this.qvp;
            kotlin.jvm.internal.p.o(matchResult, "matchResult");
            a2 = k.a(matchResult, i);
            if (a2.eLl().intValue() >= 0) {
                String group = j.this.qvp.group(i);
                kotlin.jvm.internal.p.o(group, "matchResult.group(index)");
                return new f(group, a2);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i eLv() {
        i a2;
        int end = (this.qvp.end() == this.qvp.start() ? 1 : 0) + this.qvp.end();
        if (end <= this.qvi.length()) {
            a2 = k.a(this.qvr, end, this.qvi);
            return a2;
        }
        return null;
    }
}
