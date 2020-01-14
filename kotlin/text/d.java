package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class d implements kotlin.sequences.c<kotlin.b.c> {
    private final int azm;
    private final int limit;
    private final CharSequence nCr;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nCs;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.nCr = charSequence;
        this.azm = i;
        this.limit = i2;
        this.nCs = mVar;
    }

    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.c> {
        private int nCe = -1;
        private int nCt;
        private int nCu;
        private kotlin.b.c nCv;
        private int nCw;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nCt = kotlin.b.d.av(d.this.azm, 0, d.this.nCr.length());
            this.nCu = this.nCt;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nCw < r6.nCx.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dJz() {
            if (this.nCu >= 0) {
                if (d.this.limit > 0) {
                    this.nCw++;
                }
                if (this.nCu <= d.this.nCr.length()) {
                    Pair pair = (Pair) d.this.nCs.invoke(d.this.nCr, Integer.valueOf(this.nCu));
                    if (pair == null) {
                        this.nCv = new kotlin.b.c(this.nCt, l.t(d.this.nCr));
                        this.nCu = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nCv = kotlin.b.d.eu(this.nCt, intValue);
                        this.nCt = intValue + intValue2;
                        this.nCu = (intValue2 == 0 ? 1 : 0) + this.nCt;
                    }
                    this.nCe = 1;
                    return;
                }
                this.nCv = new kotlin.b.c(this.nCt, l.t(d.this.nCr));
                this.nCu = -1;
                this.nCe = 1;
                return;
            }
            this.nCe = 0;
            this.nCv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dJA */
        public kotlin.b.c next() {
            if (this.nCe == -1) {
                dJz();
            }
            if (this.nCe == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.c cVar = this.nCv;
            if (cVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nCv = null;
            this.nCe = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nCe == -1) {
                dJz();
            }
            return this.nCe == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.c> iterator() {
        return new a();
    }
}
