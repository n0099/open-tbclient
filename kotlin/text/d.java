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
    private final int bfa;
    private final int limit;
    private final CharSequence ntO;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> ntP;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.ntO = charSequence;
        this.bfa = i;
        this.limit = i2;
        this.ntP = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int ntB = -1;
        private int ntQ;
        private int ntR;
        private kotlin.b.h ntS;
        private int ntT;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.ntQ = kotlin.b.l.ap(d.this.bfa, 0, d.this.ntO.length());
            this.ntR = this.ntQ;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.ntT < r6.ntU.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dMf() {
            if (this.ntR >= 0) {
                if (d.this.limit > 0) {
                    this.ntT++;
                }
                if (this.ntR <= d.this.ntO.length()) {
                    Pair pair = (Pair) d.this.ntP.invoke(d.this.ntO, Integer.valueOf(this.ntR));
                    if (pair == null) {
                        this.ntS = new kotlin.b.h(this.ntQ, l.t(d.this.ntO));
                        this.ntR = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.ntS = kotlin.b.l.dO(this.ntQ, intValue);
                        this.ntQ = intValue + intValue2;
                        this.ntR = (intValue2 == 0 ? 1 : 0) + this.ntQ;
                    }
                    this.ntB = 1;
                    return;
                }
                this.ntS = new kotlin.b.h(this.ntQ, l.t(d.this.ntO));
                this.ntR = -1;
                this.ntB = 1;
                return;
            }
            this.ntB = 0;
            this.ntS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dMg */
        public kotlin.b.h next() {
            if (this.ntB == -1) {
                dMf();
            }
            if (this.ntB == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.ntS;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.ntS = null;
            this.ntB = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ntB == -1) {
                dMf();
            }
            return this.ntB == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
