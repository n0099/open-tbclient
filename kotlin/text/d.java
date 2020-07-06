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
    private final int bkl;
    private final int limit;
    private final CharSequence nQO;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nQP;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.nQO = charSequence;
        this.bkl = i;
        this.limit = i2;
        this.nQP = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nQB = -1;
        private int nQQ;
        private int nQR;
        private kotlin.b.h nQS;
        private int nQT;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nQQ = kotlin.b.l.ap(d.this.bkl, 0, d.this.nQO.length());
            this.nQR = this.nQQ;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nQT < r6.nQU.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dRd() {
            if (this.nQR >= 0) {
                if (d.this.limit > 0) {
                    this.nQT++;
                }
                if (this.nQR <= d.this.nQO.length()) {
                    Pair pair = (Pair) d.this.nQP.invoke(d.this.nQO, Integer.valueOf(this.nQR));
                    if (pair == null) {
                        this.nQS = new kotlin.b.h(this.nQQ, l.x(d.this.nQO));
                        this.nQR = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nQS = kotlin.b.l.dX(this.nQQ, intValue);
                        this.nQQ = intValue + intValue2;
                        this.nQR = (intValue2 == 0 ? 1 : 0) + this.nQQ;
                    }
                    this.nQB = 1;
                    return;
                }
                this.nQS = new kotlin.b.h(this.nQQ, l.x(d.this.nQO));
                this.nQR = -1;
                this.nQB = 1;
                return;
            }
            this.nQB = 0;
            this.nQS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dRe */
        public kotlin.b.h next() {
            if (this.nQB == -1) {
                dRd();
            }
            if (this.nQB == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nQS;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nQS = null;
            this.nQB = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nQB == -1) {
                dRd();
            }
            return this.nQB == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
