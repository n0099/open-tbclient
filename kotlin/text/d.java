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
    private final CharSequence nCm;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nCn;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.nCm = charSequence;
        this.azm = i;
        this.limit = i2;
        this.nCn = mVar;
    }

    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.c> {
        private int nBZ = -1;
        private int nCo;
        private int nCp;
        private kotlin.b.c nCq;
        private int nCr;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nCo = kotlin.b.d.av(d.this.azm, 0, d.this.nCm.length());
            this.nCp = this.nCo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nCr < r6.nCs.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dJx() {
            if (this.nCp >= 0) {
                if (d.this.limit > 0) {
                    this.nCr++;
                }
                if (this.nCp <= d.this.nCm.length()) {
                    Pair pair = (Pair) d.this.nCn.invoke(d.this.nCm, Integer.valueOf(this.nCp));
                    if (pair == null) {
                        this.nCq = new kotlin.b.c(this.nCo, l.t(d.this.nCm));
                        this.nCp = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nCq = kotlin.b.d.eu(this.nCo, intValue);
                        this.nCo = intValue + intValue2;
                        this.nCp = (intValue2 == 0 ? 1 : 0) + this.nCo;
                    }
                    this.nBZ = 1;
                    return;
                }
                this.nCq = new kotlin.b.c(this.nCo, l.t(d.this.nCm));
                this.nCp = -1;
                this.nBZ = 1;
                return;
            }
            this.nBZ = 0;
            this.nCq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dJy */
        public kotlin.b.c next() {
            if (this.nBZ == -1) {
                dJx();
            }
            if (this.nBZ == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.c cVar = this.nCq;
            if (cVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nCq = null;
            this.nBZ = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nBZ == -1) {
                dJx();
            }
            return this.nBZ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.c> iterator() {
        return new a();
    }
}
