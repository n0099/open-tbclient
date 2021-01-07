package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bOI;
    private final int limit;
    private final CharSequence qoD;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> qoE;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.qoD = charSequence;
        this.bOI = i;
        this.limit = i2;
        this.qoE = cVar;
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int qoF;
        private int qoG;
        private kotlin.b.h qoH;
        private int qoI;
        private int qos = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.qoF = kotlin.b.l.aq(d.this.bOI, 0, d.this.qoD.length());
            this.qoG = this.qoF;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.qoI < r7.qoJ.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eNc() {
            if (this.qoG >= 0) {
                if (d.this.limit > 0) {
                    this.qoI++;
                }
                if (this.qoG <= d.this.qoD.length()) {
                    Pair pair = (Pair) d.this.qoE.invoke(d.this.qoD, Integer.valueOf(this.qoG));
                    if (pair == null) {
                        this.qoH = new kotlin.b.h(this.qoF, l.B(d.this.qoD));
                        this.qoG = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.qoH = new kotlin.b.h(this.qoF, intValue - 1);
                        this.qoF = intValue + intValue2;
                        this.qoG = (intValue2 == 0 ? 1 : 0) + this.qoF;
                    }
                    this.qos = 1;
                    return;
                }
                this.qoH = new kotlin.b.h(this.qoF, l.B(d.this.qoD));
                this.qoG = -1;
                this.qos = 1;
                return;
            }
            this.qos = 0;
            this.qoH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eNd */
        public kotlin.b.h next() {
            if (this.qos == -1) {
                eNc();
            }
            if (this.qos == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.qoH;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.qoH = null;
            this.qos = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qos == -1) {
                eNc();
            }
            return this.qos == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
