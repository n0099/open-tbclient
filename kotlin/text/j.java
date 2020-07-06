package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence nQO;
    private final g nQW;
    private final Matcher nQX;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.m(matcher, "matcher");
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        this.nQX = matcher;
        this.nQO = charSequence;
        this.nQW = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dRh() {
        return this.nQX;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dRf() {
        kotlin.b.h a2;
        a2 = k.a(dRh());
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
            return j.this.dRh().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.i(kotlin.collections.o.m(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Lc(int i) {
            kotlin.b.h a;
            a = k.a(j.this.dRh(), i);
            if (a.dQW().intValue() >= 0) {
                String group = j.this.dRh().group(i);
                kotlin.jvm.internal.q.l((Object) group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dRg() {
        i a2;
        int end = (dRh().end() == dRh().start() ? 1 : 0) + dRh().end();
        if (end <= this.nQO.length()) {
            Matcher matcher = this.nQX.pattern().matcher(this.nQO);
            kotlin.jvm.internal.q.l((Object) matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nQO);
            return a2;
        }
        return null;
    }
}
