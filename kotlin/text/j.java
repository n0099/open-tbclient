package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class j implements i {
    private final CharSequence ntO;
    private final g ntW;
    private final Matcher ntX;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.q.m(matcher, "matcher");
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        this.ntX = matcher;
        this.ntO = charSequence;
        this.ntW = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult dMj() {
        return this.ntX;
    }

    @Override // kotlin.text.i
    public kotlin.b.h dMh() {
        kotlin.b.h a2;
        a2 = k.a(dMj());
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
            return j.this.dMj().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.sequences.e.c(kotlin.collections.o.i(kotlin.collections.o.m(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f JT(int i) {
            kotlin.b.h a;
            a = k.a(j.this.dMj(), i);
            if (a.dLY().intValue() >= 0) {
                String group = j.this.dMj().group(i);
                kotlin.jvm.internal.q.l((Object) group, "matchResult.group(index)");
                return new f(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.i
    public i dMi() {
        i a2;
        int end = (dMj().end() == dMj().start() ? 1 : 0) + dMj().end();
        if (end <= this.ntO.length()) {
            Matcher matcher = this.ntX.pattern().matcher(this.ntO);
            kotlin.jvm.internal.q.l((Object) matcher, "matcher.pattern().matcher(input)");
            a2 = k.a(matcher, end, this.ntO);
            return a2;
        }
        return null;
    }
}
