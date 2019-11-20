package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements h {
    private final MatchResult kvJ;
    private final f kvK;
    private final Matcher kvL;
    private final CharSequence kvM;

    public i(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.p.i(matcher, "matcher");
        kotlin.jvm.internal.p.i(charSequence, Config.INPUT_PART);
        this.kvL = matcher;
        this.kvM = charSequence;
        this.kvJ = this.kvL.toMatchResult();
        this.kvK = new a();
    }

    @Override // kotlin.text.h
    public kotlin.b.c cNh() {
        kotlin.b.c a2;
        MatchResult matchResult = this.kvJ;
        kotlin.jvm.internal.p.h(matchResult, "matchResult");
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
            return i.this.kvJ.groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return kotlin.sequences.d.c(kotlin.collections.n.d(kotlin.collections.n.g(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public e Di(int i) {
            kotlin.b.c a;
            MatchResult matchResult = i.this.kvJ;
            kotlin.jvm.internal.p.h(matchResult, "matchResult");
            a = j.a(matchResult, i);
            if (a.cNc().intValue() >= 0) {
                String group = i.this.kvJ.group(i);
                kotlin.jvm.internal.p.h(group, "matchResult.group(index)");
                return new e(group, a);
            }
            return null;
        }
    }

    @Override // kotlin.text.h
    public h cNi() {
        h a2;
        int end = (this.kvJ.end() == this.kvJ.start() ? 1 : 0) + this.kvJ.end();
        if (end <= this.kvM.length()) {
            a2 = j.a(this.kvL, end, this.kvM);
            return a2;
        }
        return null;
    }
}
