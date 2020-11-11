package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public final class j implements i {
    private final CharSequence pTB;
    private final g pTJ;
    private final Matcher pTK;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.n(matcher, "matcher");
        kotlin.jvm.internal.q.n(charSequence, Config.INPUT_PART);
        this.pTK = matcher;
        this.pTB = charSequence;
        this.pTJ = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult eCm() {
        return this.pTK;
    }

    @Override // kotlin.text.i
    public kotlin.b.h eCk() {
        kotlin.b.h a2;
        a2 = k.a(eCm());
        return a2;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
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
            return j.this.eCm().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.i(kotlin.collections.o.o(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Rw(int i) {
            kotlin.b.h a2;
            a2 = k.a(j.this.eCm(), i);
            if (a2.eCb().intValue() >= 0) {
                String group = j.this.eCm().group(i);
                kotlin.jvm.internal.q.m(group, "matchResult.group(index)");
                return new f(group, a2);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i eCl() {
        i a2;
        int end = (eCm().end() == eCm().start() ? 1 : 0) + eCm().end();
        if (end <= this.pTB.length()) {
            Matcher matcher = this.pTK.pattern().matcher(this.pTB);
            kotlin.jvm.internal.q.m(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.pTB);
            return a2;
        }
        return null;
    }
}
