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
    private final CharSequence nQL;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nQM;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.nQL = charSequence;
        this.bkl = i;
        this.limit = i2;
        this.nQM = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nQN;
        private int nQO;
        private kotlin.b.h nQP;
        private int nQQ;
        private int nQy = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nQN = kotlin.b.l.ap(d.this.bkl, 0, d.this.nQL.length());
            this.nQO = this.nQN;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nQQ < r6.nQR.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dQZ() {
            if (this.nQO >= 0) {
                if (d.this.limit > 0) {
                    this.nQQ++;
                }
                if (this.nQO <= d.this.nQL.length()) {
                    Pair pair = (Pair) d.this.nQM.invoke(d.this.nQL, Integer.valueOf(this.nQO));
                    if (pair == null) {
                        this.nQP = new kotlin.b.h(this.nQN, l.x(d.this.nQL));
                        this.nQO = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nQP = kotlin.b.l.dX(this.nQN, intValue);
                        this.nQN = intValue + intValue2;
                        this.nQO = (intValue2 == 0 ? 1 : 0) + this.nQN;
                    }
                    this.nQy = 1;
                    return;
                }
                this.nQP = new kotlin.b.h(this.nQN, l.x(d.this.nQL));
                this.nQO = -1;
                this.nQy = 1;
                return;
            }
            this.nQy = 0;
            this.nQP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dRa */
        public kotlin.b.h next() {
            if (this.nQy == -1) {
                dQZ();
            }
            if (this.nQy == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nQP;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nQP = null;
            this.nQy = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nQy == -1) {
                dQZ();
            }
            return this.nQy == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
