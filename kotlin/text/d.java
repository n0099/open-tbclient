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
    private final int bkF;
    private final int limit;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nZA;
    private final CharSequence nZz;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.nZz = charSequence;
        this.bkF = i;
        this.limit = i2;
        this.nZA = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nZB;
        private int nZC;
        private kotlin.b.h nZD;
        private int nZE;
        private int nZm = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nZB = kotlin.b.l.am(d.this.bkF, 0, d.this.nZz.length());
            this.nZC = this.nZB;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nZE < r6.nZF.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dUA() {
            if (this.nZC >= 0) {
                if (d.this.limit > 0) {
                    this.nZE++;
                }
                if (this.nZC <= d.this.nZz.length()) {
                    Pair pair = (Pair) d.this.nZA.invoke(d.this.nZz, Integer.valueOf(this.nZC));
                    if (pair == null) {
                        this.nZD = new kotlin.b.h(this.nZB, l.x(d.this.nZz));
                        this.nZC = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nZD = kotlin.b.l.dZ(this.nZB, intValue);
                        this.nZB = intValue + intValue2;
                        this.nZC = (intValue2 == 0 ? 1 : 0) + this.nZB;
                    }
                    this.nZm = 1;
                    return;
                }
                this.nZD = new kotlin.b.h(this.nZB, l.x(d.this.nZz));
                this.nZC = -1;
                this.nZm = 1;
                return;
            }
            this.nZm = 0;
            this.nZD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dUB */
        public kotlin.b.h next() {
            if (this.nZm == -1) {
                dUA();
            }
            if (this.nZm == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nZD;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nZD = null;
            this.nZm = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nZm == -1) {
                dUA();
            }
            return this.nZm == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
