package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int aDC;
    private final int limit;
    private final CharSequence nDk;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nDl;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.nDk = charSequence;
        this.aDC = i;
        this.limit = i2;
        this.nDl = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nCX = -1;
        private int nDm;
        private int nDn;
        private kotlin.b.h nDo;
        private int nDp;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nDm = kotlin.b.l.aw(d.this.aDC, 0, d.this.nDk.length());
            this.nDn = this.nDm;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nDp < r6.nDq.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dKM() {
            if (this.nDn >= 0) {
                if (d.this.limit > 0) {
                    this.nDp++;
                }
                if (this.nDn <= d.this.nDk.length()) {
                    Pair pair = (Pair) d.this.nDl.invoke(d.this.nDk, Integer.valueOf(this.nDn));
                    if (pair == null) {
                        this.nDo = new kotlin.b.h(this.nDm, l.t(d.this.nDk));
                        this.nDn = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nDo = kotlin.b.l.ex(this.nDm, intValue);
                        this.nDm = intValue + intValue2;
                        this.nDn = (intValue2 == 0 ? 1 : 0) + this.nDm;
                    }
                    this.nCX = 1;
                    return;
                }
                this.nDo = new kotlin.b.h(this.nDm, l.t(d.this.nDk));
                this.nDn = -1;
                this.nCX = 1;
                return;
            }
            this.nCX = 0;
            this.nDo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dKN */
        public kotlin.b.h next() {
            if (this.nCX == -1) {
                dKM();
            }
            if (this.nCX == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nDo;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nDo = null;
            this.nCX = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nCX == -1) {
                dKM();
            }
            return this.nCX == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
