package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence nFk;
    private final g nFs;
    private final Matcher nFt;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.j(matcher, "matcher");
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        this.nFt = matcher;
        this.nFk = charSequence;
        this.nFs = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dLt() {
        return this.nFt;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dLr() {
        kotlin.b.h a2;
        a2 = k.a(dLt());
        return a2;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
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
            return j.this.dLt().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.h(kotlin.collections.o.k(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f NO(int i) {
            kotlin.b.h a;
            a = k.a(j.this.dLt(), i);
            if (a.dLi().intValue() >= 0) {
                String group = j.this.dLt().group(i);
                kotlin.jvm.internal.q.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dLs() {
        i a2;
        int end = (dLt().end() == dLt().start() ? 1 : 0) + dLt().end();
        if (end <= this.nFk.length()) {
            Matcher matcher = this.nFt.pattern().matcher(this.nFk);
            kotlin.jvm.internal.q.i(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nFk);
            return a2;
        }
        return null;
    }
}
