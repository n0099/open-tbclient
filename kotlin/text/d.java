package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes17.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bJV;
    private final int limit;
    private final CharSequence pLq;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> pLr;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.pLq = charSequence;
        this.bJV = i;
        this.limit = i2;
        this.pLr = cVar;
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int pLf = -1;
        private int pLs;
        private int pLt;
        private kotlin.b.h pLu;
        private int pLv;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.pLs = kotlin.b.l.an(d.this.bJV, 0, d.this.pLq.length());
            this.pLt = this.pLs;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.pLv < r7.pLw.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eEp() {
            if (this.pLt >= 0) {
                if (d.this.limit > 0) {
                    this.pLv++;
                }
                if (this.pLt <= d.this.pLq.length()) {
                    Pair pair = (Pair) d.this.pLr.invoke(d.this.pLq, Integer.valueOf(this.pLt));
                    if (pair == null) {
                        this.pLu = new kotlin.b.h(this.pLs, l.B(d.this.pLq));
                        this.pLt = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.pLu = new kotlin.b.h(this.pLs, intValue - 1);
                        this.pLs = intValue + intValue2;
                        this.pLt = (intValue2 == 0 ? 1 : 0) + this.pLs;
                    }
                    this.pLf = 1;
                    return;
                }
                this.pLu = new kotlin.b.h(this.pLs, l.B(d.this.pLq));
                this.pLt = -1;
                this.pLf = 1;
                return;
            }
            this.pLf = 0;
            this.pLu = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eEq */
        public kotlin.b.h next() {
            if (this.pLf == -1) {
                eEp();
            }
            if (this.pLf == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.pLu;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.pLu = null;
            this.pLf = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pLf == -1) {
                eEp();
            }
            return this.pLf == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
