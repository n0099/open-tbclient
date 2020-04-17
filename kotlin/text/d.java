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
    private final int aXB;
    private final int limit;
    private final CharSequence mYJ;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> mYK;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.mYJ = charSequence;
        this.aXB = i;
        this.limit = i2;
        this.mYK = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int mYL;
        private int mYM;
        private kotlin.b.h mYN;
        private int mYO;
        private int mYw = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.mYL = kotlin.b.l.ap(d.this.aXB, 0, d.this.mYJ.length());
            this.mYM = this.mYL;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.mYO < r6.mYP.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dEo() {
            if (this.mYM >= 0) {
                if (d.this.limit > 0) {
                    this.mYO++;
                }
                if (this.mYM <= d.this.mYJ.length()) {
                    Pair pair = (Pair) d.this.mYK.invoke(d.this.mYJ, Integer.valueOf(this.mYM));
                    if (pair == null) {
                        this.mYN = new kotlin.b.h(this.mYL, l.s(d.this.mYJ));
                        this.mYM = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.mYN = kotlin.b.l.dJ(this.mYL, intValue);
                        this.mYL = intValue + intValue2;
                        this.mYM = (intValue2 == 0 ? 1 : 0) + this.mYL;
                    }
                    this.mYw = 1;
                    return;
                }
                this.mYN = new kotlin.b.h(this.mYL, l.s(d.this.mYJ));
                this.mYM = -1;
                this.mYw = 1;
                return;
            }
            this.mYw = 0;
            this.mYN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dEp */
        public kotlin.b.h next() {
            if (this.mYw == -1) {
                dEo();
            }
            if (this.mYw == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.mYN;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.mYN = null;
            this.mYw = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mYw == -1) {
                dEo();
            }
            return this.mYw == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
