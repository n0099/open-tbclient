package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence nDk;
    private final g nDs;
    private final Matcher nDt;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.j(matcher, "matcher");
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        this.nDt = matcher;
        this.nDk = charSequence;
        this.nDs = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dKQ() {
        return this.nDt;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dKO() {
        kotlin.b.h a2;
        a2 = k.a(dKQ());
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
            return j.this.dKQ().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.h(kotlin.collections.o.k(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f NI(int i) {
            kotlin.b.h a;
            a = k.a(j.this.dKQ(), i);
            if (a.dKF().intValue() >= 0) {
                String group = j.this.dKQ().group(i);
                kotlin.jvm.internal.q.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dKP() {
        i a2;
        int end = (dKQ().end() == dKQ().start() ? 1 : 0) + dKQ().end();
        if (end <= this.nDk.length()) {
            Matcher matcher = this.nDt.pattern().matcher(this.nDk);
            kotlin.jvm.internal.q.i(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nDk);
            return a2;
        }
        return null;
    }
}
