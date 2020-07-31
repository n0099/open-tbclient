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
    private final CharSequence nZx;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nZy;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.nZx = charSequence;
        this.bkF = i;
        this.limit = i2;
        this.nZy = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nZA;
        private kotlin.b.h nZB;
        private int nZC;
        private int nZk = -1;
        private int nZz;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nZz = kotlin.b.l.am(d.this.bkF, 0, d.this.nZx.length());
            this.nZA = this.nZz;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nZC < r6.nZD.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dUz() {
            if (this.nZA >= 0) {
                if (d.this.limit > 0) {
                    this.nZC++;
                }
                if (this.nZA <= d.this.nZx.length()) {
                    Pair pair = (Pair) d.this.nZy.invoke(d.this.nZx, Integer.valueOf(this.nZA));
                    if (pair == null) {
                        this.nZB = new kotlin.b.h(this.nZz, l.x(d.this.nZx));
                        this.nZA = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nZB = kotlin.b.l.dZ(this.nZz, intValue);
                        this.nZz = intValue + intValue2;
                        this.nZA = (intValue2 == 0 ? 1 : 0) + this.nZz;
                    }
                    this.nZk = 1;
                    return;
                }
                this.nZB = new kotlin.b.h(this.nZz, l.x(d.this.nZx));
                this.nZA = -1;
                this.nZk = 1;
                return;
            }
            this.nZk = 0;
            this.nZB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dUA */
        public kotlin.b.h next() {
            if (this.nZk == -1) {
                dUz();
            }
            if (this.nZk == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nZB;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nZB = null;
            this.nZk = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nZk == -1) {
                dUz();
            }
            return this.nZk == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
