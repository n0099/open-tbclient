package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public final class j implements i {
    private final CharSequence oSL;
    private final g oST;
    private final Matcher oSU;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.n(matcher, "matcher");
        kotlin.jvm.internal.q.n(charSequence, Config.INPUT_PART);
        this.oSU = matcher;
        this.oSL = charSequence;
        this.oST = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult eoz() {
        return this.oSU;
    }

    @Override // kotlin.text.i
    public kotlin.b.h eox() {
        kotlin.b.h a2;
        a2 = k.a(eoz());
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
            return j.this.eoz().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.i(kotlin.collections.o.o(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f Pk(int i) {
            kotlin.b.h a2;
            a2 = k.a(j.this.eoz(), i);
            if (a2.eoo().intValue() >= 0) {
                String group = j.this.eoz().group(i);
                kotlin.jvm.internal.q.m(group, "matchResult.group(index)");
                return new f(group, a2);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i eoy() {
        i a2;
        int end = (eoz().end() == eoz().start() ? 1 : 0) + eoz().end();
        if (end <= this.oSL.length()) {
            Matcher matcher = this.oSU.pattern().matcher(this.oSL);
            kotlin.jvm.internal.q.m(matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.oSL);
            return a2;
        }
        return null;
    }
}
