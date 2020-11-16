package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes9.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bEM;
    private final int limit;
    private final CharSequence pVe;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> pVf;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.n(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.n(mVar, "getNextMatch");
        this.pVe = charSequence;
        this.bEM = i;
        this.limit = i2;
        this.pVf = mVar;
    }

    @kotlin.h
    /* loaded from: classes9.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int pUR = -1;
        private int pVg;
        private int pVh;
        private kotlin.b.h pVi;
        private int pVj;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.pVg = kotlin.b.l.at(d.this.bEM, 0, d.this.pVe.length());
            this.pVh = this.pVg;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.pVj < r6.pVk.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eCj() {
            if (this.pVh >= 0) {
                if (d.this.limit > 0) {
                    this.pVj++;
                }
                if (this.pVh <= d.this.pVe.length()) {
                    Pair pair = (Pair) d.this.pVf.invoke(d.this.pVe, Integer.valueOf(this.pVh));
                    if (pair == null) {
                        this.pVi = new kotlin.b.h(this.pVg, l.A(d.this.pVe));
                        this.pVh = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.pVi = kotlin.b.l.ex(this.pVg, intValue);
                        this.pVg = intValue + intValue2;
                        this.pVh = (intValue2 == 0 ? 1 : 0) + this.pVg;
                    }
                    this.pUR = 1;
                    return;
                }
                this.pVi = new kotlin.b.h(this.pVg, l.A(d.this.pVe));
                this.pVh = -1;
                this.pUR = 1;
                return;
            }
            this.pUR = 0;
            this.pVi = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eCk */
        public kotlin.b.h next() {
            if (this.pUR == -1) {
                eCj();
            }
            if (this.pUR == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.pVi;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.pVi = null;
            this.pUR = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pUR == -1) {
                eCj();
            }
            return this.pUR == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
