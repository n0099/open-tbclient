package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes20.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bqn;
    private final int limit;
    private final CharSequence otP;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> otQ;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.otP = charSequence;
        this.bqn = i;
        this.limit = i2;
        this.otQ = mVar;
    }

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int otC = -1;
        private int otR;
        private int otS;
        private kotlin.b.h otT;
        private int otU;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.otR = kotlin.b.l.am(d.this.bqn, 0, d.this.otP.length());
            this.otS = this.otR;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.otU < r6.otV.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void egL() {
            if (this.otS >= 0) {
                if (d.this.limit > 0) {
                    this.otU++;
                }
                if (this.otS <= d.this.otP.length()) {
                    Pair pair = (Pair) d.this.otQ.invoke(d.this.otP, Integer.valueOf(this.otS));
                    if (pair == null) {
                        this.otT = new kotlin.b.h(this.otR, l.x(d.this.otP));
                        this.otS = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.otT = kotlin.b.l.eh(this.otR, intValue);
                        this.otR = intValue + intValue2;
                        this.otS = (intValue2 == 0 ? 1 : 0) + this.otR;
                    }
                    this.otC = 1;
                    return;
                }
                this.otT = new kotlin.b.h(this.otR, l.x(d.this.otP));
                this.otS = -1;
                this.otC = 1;
                return;
            }
            this.otC = 0;
            this.otT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: egM */
        public kotlin.b.h next() {
            if (this.otC == -1) {
                egL();
            }
            if (this.otC == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.otT;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.otT = null;
            this.otC = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.otC == -1) {
                egL();
            }
            return this.otC == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
