package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult kvS;
    private final f kvT;
    private final Matcher kvU;
    private final CharSequence kvV;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.k(matcher, "matcher");
        kotlin.jvm.internal.p.k(charSequence, Config.INPUT_PART);
        this.kvU = matcher;
        this.kvV = charSequence;
        this.kvS = this.kvU.toMatchResult();
        this.kvT = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cPc() {
        kotlin.b.c a2;
        MatchResult matchResult = this.kvS;
        kotlin.jvm.internal.p.j(matchResult, "matchResult");
        a2 = j.a(matchResult);
        return a2;
    }

    /* loaded from: classes2.dex */
    public static final class a extends kotlin.collections.a<e> implements g {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        public boolean a(e eVar) {
            return super.contains(eVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj != null ? obj instanceof e : true) {
                return a((e) obj);
            }
            return false;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return i.this.kvS.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.i(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e EM(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.kvS;
            kotlin.jvm.internal.p.j(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cOX().intValue() >= 0) {
                String group = i.this.kvS.group(i);
                kotlin.jvm.internal.p.j(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cPd() {
        h a2;
        int end = (this.kvS.end() == this.kvS.start() ? 1 : 0) + this.kvS.end();
        if (end <= this.kvV.length()) {
            a2 = j.a(this.kvU, end, this.kvV);
            return a2;
        }
        return null;
    }
}
