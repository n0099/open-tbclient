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
    private final int bAm;
    private final int limit;
    private final CharSequence pKh;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> pKi;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.n(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.n(mVar, "getNextMatch");
        this.pKh = charSequence;
        this.bAm = i;
        this.limit = i2;
        this.pKi = mVar;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int pJU = -1;
        private int pKj;
        private int pKk;
        private kotlin.b.h pKl;
        private int pKm;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.pKj = kotlin.b.l.aq(d.this.bAm, 0, d.this.pKh.length());
            this.pKk = this.pKj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.pKm < r6.pKn.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eyt() {
            if (this.pKk >= 0) {
                if (d.this.limit > 0) {
                    this.pKm++;
                }
                if (this.pKk <= d.this.pKh.length()) {
                    Pair pair = (Pair) d.this.pKi.invoke(d.this.pKh, Integer.valueOf(this.pKk));
                    if (pair == null) {
                        this.pKl = new kotlin.b.h(this.pKj, l.z(d.this.pKh));
                        this.pKk = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.pKl = kotlin.b.l.et(this.pKj, intValue);
                        this.pKj = intValue + intValue2;
                        this.pKk = (intValue2 == 0 ? 1 : 0) + this.pKj;
                    }
                    this.pJU = 1;
                    return;
                }
                this.pKl = new kotlin.b.h(this.pKj, l.z(d.this.pKh));
                this.pKk = -1;
                this.pJU = 1;
                return;
            }
            this.pJU = 0;
            this.pKl = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eyu */
        public kotlin.b.h next() {
            if (this.pJU == -1) {
                eyt();
            }
            if (this.pJU == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.pKl;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.pKl = null;
            this.pJU = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pJU == -1) {
                eyt();
            }
            return this.pJU == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
