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
    private final CharSequence nuZ;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nva;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.nuZ = charSequence;
        this.bfa = i;
        this.limit = i2;
        this.nva = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nuM = -1;
        private int nvb;
        private int nvc;
        private kotlin.b.h nvd;
        private int nve;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nvb = kotlin.b.l.ap(d.this.bfa, 0, d.this.nuZ.length());
            this.nvc = this.nvb;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nve < r6.nvf.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dMt() {
            if (this.nvc >= 0) {
                if (d.this.limit > 0) {
                    this.nve++;
                }
                if (this.nvc <= d.this.nuZ.length()) {
                    Pair pair = (Pair) d.this.nva.invoke(d.this.nuZ, Integer.valueOf(this.nvc));
                    if (pair == null) {
                        this.nvd = new kotlin.b.h(this.nvb, l.t(d.this.nuZ));
                        this.nvc = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nvd = kotlin.b.l.dO(this.nvb, intValue);
                        this.nvb = intValue + intValue2;
                        this.nvc = (intValue2 == 0 ? 1 : 0) + this.nvb;
                    }
                    this.nuM = 1;
                    return;
                }
                this.nvd = new kotlin.b.h(this.nvb, l.t(d.this.nuZ));
                this.nvc = -1;
                this.nuM = 1;
                return;
            }
            this.nuM = 0;
            this.nvd = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dMu */
        public kotlin.b.h next() {
            if (this.nuM == -1) {
                dMt();
            }
            if (this.nuM == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nvd;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nvd = null;
            this.nuM = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nuM == -1) {
                dMt();
            }
            return this.nuM == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
