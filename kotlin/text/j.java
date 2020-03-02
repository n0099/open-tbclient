package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence nDm;
    private final g nDu;
    private final Matcher nDv;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.j(matcher, "matcher");
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        this.nDv = matcher;
        this.nDm = charSequence;
        this.nDu = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dKS() {
        return this.nDv;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dKQ() {
        kotlin.b.h a2;
        a2 = k.a(dKS());
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
            return j.this.dKS().groupCount() + 1;
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
            a = k.a(j.this.dKS(), i);
            if (a.dKH().intValue() >= 0) {
                String group = j.this.dKS().group(i);
                kotlin.jvm.internal.q.i(group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dKR() {
        i a2;
        int end = (dKS().end() == dKS().start() ? 1 : 0) + dKS().end();
        if (end <= this.nDm.length()) {
            Matcher matcher = this.nDv.pattern().matcher(this.nDm);
            kotlin.jvm.internal.q.i(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.nDm);
            return a2;
        }
        return null;
    }
}
