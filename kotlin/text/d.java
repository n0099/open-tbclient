package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d implements kotlin.sequences.c<kotlin.b.c> {
    private final int ayD;
    private final int limit;
    private final CharSequence mZD;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> mZE;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.j(cVar, "getNextMatch");
        this.mZD = charSequence;
        this.ayD = i;
        this.limit = i2;
        this.mZE = cVar;
    }

    /* loaded from: classes4.dex */
    public static final class a implements Iterator<kotlin.b.c> {
        private int mZF;
        private int mZG;
        private kotlin.b.c mZH;
        private int mZI;
        private int mZs = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.mZF = kotlin.b.d.av(d.this.ayD, 0, d.this.mZD.length());
            this.mZG = this.mZF;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.mZI < r7.mZJ.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dFb() {
            if (this.mZG >= 0) {
                if (d.this.limit > 0) {
                    this.mZI++;
                }
                if (this.mZG <= d.this.mZD.length()) {
                    Pair pair = (Pair) d.this.mZE.invoke(d.this.mZD, Integer.valueOf(this.mZG));
                    if (pair == null) {
                        this.mZH = new kotlin.b.c(this.mZF, l.t(d.this.mZD));
                        this.mZG = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.mZH = new kotlin.b.c(this.mZF, intValue - 1);
                        this.mZF = intValue + intValue2;
                        this.mZG = (intValue2 == 0 ? 1 : 0) + this.mZF;
                    }
                    this.mZs = 1;
                    return;
                }
                this.mZH = new kotlin.b.c(this.mZF, l.t(d.this.mZD));
                this.mZG = -1;
                this.mZs = 1;
                return;
            }
            this.mZs = 0;
            this.mZH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dFc */
        public kotlin.b.c next() {
            if (this.mZs == -1) {
                dFb();
            }
            if (this.mZs == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.c cVar = this.mZH;
            if (cVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.mZH = null;
            this.mZs = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mZs == -1) {
                dFb();
            }
            return this.mZs == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.c> iterator() {
        return new a();
    }
}
