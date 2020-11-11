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
    private final int bGx;
    private final int limit;
    private final CharSequence pTB;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> pTC;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.n(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.n(mVar, "getNextMatch");
        this.pTB = charSequence;
        this.bGx = i;
        this.limit = i2;
        this.pTC = mVar;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int pTD;
        private int pTE;
        private kotlin.b.h pTF;
        private int pTG;
        private int pTo = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.pTD = kotlin.b.l.aq(d.this.bGx, 0, d.this.pTB.length());
            this.pTE = this.pTD;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.pTG < r6.pTH.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eCi() {
            if (this.pTE >= 0) {
                if (d.this.limit > 0) {
                    this.pTG++;
                }
                if (this.pTE <= d.this.pTB.length()) {
                    Pair pair = (Pair) d.this.pTC.invoke(d.this.pTB, Integer.valueOf(this.pTE));
                    if (pair == null) {
                        this.pTF = new kotlin.b.h(this.pTD, l.z(d.this.pTB));
                        this.pTE = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.pTF = kotlin.b.l.ew(this.pTD, intValue);
                        this.pTD = intValue + intValue2;
                        this.pTE = (intValue2 == 0 ? 1 : 0) + this.pTD;
                    }
                    this.pTo = 1;
                    return;
                }
                this.pTF = new kotlin.b.h(this.pTD, l.z(d.this.pTB));
                this.pTE = -1;
                this.pTo = 1;
                return;
            }
            this.pTo = 0;
            this.pTF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eCj */
        public kotlin.b.h next() {
            if (this.pTo == -1) {
                eCi();
            }
            if (this.pTo == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.pTF;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.pTF = null;
            this.pTo = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pTo == -1) {
                eCi();
            }
            return this.pTo == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
