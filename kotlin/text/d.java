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
    private final int aXG;
    private final int limit;
    private final CharSequence mYM;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> mYN;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.mYM = charSequence;
        this.aXG = i;
        this.limit = i2;
        this.mYN = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int mYO;
        private int mYP;
        private kotlin.b.h mYQ;
        private int mYR;
        private int mYz = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.mYO = kotlin.b.l.ap(d.this.aXG, 0, d.this.mYM.length());
            this.mYP = this.mYO;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.mYR < r6.mYS.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dEk() {
            if (this.mYP >= 0) {
                if (d.this.limit > 0) {
                    this.mYR++;
                }
                if (this.mYP <= d.this.mYM.length()) {
                    Pair pair = (Pair) d.this.mYN.invoke(d.this.mYM, Integer.valueOf(this.mYP));
                    if (pair == null) {
                        this.mYQ = new kotlin.b.h(this.mYO, l.s(d.this.mYM));
                        this.mYP = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.mYQ = kotlin.b.l.dJ(this.mYO, intValue);
                        this.mYO = intValue + intValue2;
                        this.mYP = (intValue2 == 0 ? 1 : 0) + this.mYO;
                    }
                    this.mYz = 1;
                    return;
                }
                this.mYQ = new kotlin.b.h(this.mYO, l.s(d.this.mYM));
                this.mYP = -1;
                this.mYz = 1;
                return;
            }
            this.mYz = 0;
            this.mYQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dEl */
        public kotlin.b.h next() {
            if (this.mYz == -1) {
                dEk();
            }
            if (this.mYz == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.mYQ;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.mYQ = null;
            this.mYz = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mYz == -1) {
                dEk();
            }
            return this.mYz == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
