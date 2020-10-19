package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bxk;
    private final int limit;
    private final CharSequence oSL;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> oSM;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.n(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.n(mVar, "getNextMatch");
        this.oSL = charSequence;
        this.bxk = i;
        this.limit = i2;
        this.oSM = mVar;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int oSN;
        private int oSO;
        private kotlin.b.h oSP;
        private int oSQ;
        private int oSy = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.oSN = kotlin.b.l.ap(d.this.bxk, 0, d.this.oSL.length());
            this.oSO = this.oSN;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.oSQ < r6.oSR.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eov() {
            if (this.oSO >= 0) {
                if (d.this.limit > 0) {
                    this.oSQ++;
                }
                if (this.oSO <= d.this.oSL.length()) {
                    Pair pair = (Pair) d.this.oSM.invoke(d.this.oSL, Integer.valueOf(this.oSO));
                    if (pair == null) {
                        this.oSP = new kotlin.b.h(this.oSN, l.w(d.this.oSL));
                        this.oSO = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.oSP = kotlin.b.l.el(this.oSN, intValue);
                        this.oSN = intValue + intValue2;
                        this.oSO = (intValue2 == 0 ? 1 : 0) + this.oSN;
                    }
                    this.oSy = 1;
                    return;
                }
                this.oSP = new kotlin.b.h(this.oSN, l.w(d.this.oSL));
                this.oSO = -1;
                this.oSy = 1;
                return;
            }
            this.oSy = 0;
            this.oSP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eow */
        public kotlin.b.h next() {
            if (this.oSy == -1) {
                eov();
            }
            if (this.oSy == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.oSP;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.oSP = null;
            this.oSy = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.oSy == -1) {
                eov();
            }
            return this.oSy == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
