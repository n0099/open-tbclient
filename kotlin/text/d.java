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
    private final CharSequence pLs;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> pLt;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.pLs = charSequence;
        this.bJV = i;
        this.limit = i2;
        this.pLt = cVar;
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int pLh = -1;
        private int pLu;
        private int pLv;
        private kotlin.b.h pLw;
        private int pLx;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.pLu = kotlin.b.l.an(d.this.bJV, 0, d.this.pLs.length());
            this.pLv = this.pLu;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.pLx < r7.pLy.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eEq() {
            if (this.pLv >= 0) {
                if (d.this.limit > 0) {
                    this.pLx++;
                }
                if (this.pLv <= d.this.pLs.length()) {
                    Pair pair = (Pair) d.this.pLt.invoke(d.this.pLs, Integer.valueOf(this.pLv));
                    if (pair == null) {
                        this.pLw = new kotlin.b.h(this.pLu, l.B(d.this.pLs));
                        this.pLv = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.pLw = new kotlin.b.h(this.pLu, intValue - 1);
                        this.pLu = intValue + intValue2;
                        this.pLv = (intValue2 == 0 ? 1 : 0) + this.pLu;
                    }
                    this.pLh = 1;
                    return;
                }
                this.pLw = new kotlin.b.h(this.pLu, l.B(d.this.pLs));
                this.pLv = -1;
                this.pLh = 1;
                return;
            }
            this.pLh = 0;
            this.pLw = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eEr */
        public kotlin.b.h next() {
            if (this.pLh == -1) {
                eEq();
            }
            if (this.pLh == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.pLw;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.pLw = null;
            this.pLh = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pLh == -1) {
                eEq();
            }
            return this.pLh == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
