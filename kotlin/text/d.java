package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes14.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bPg;
    private final int limit;
    private final CharSequence qvi;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> qvj;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.p(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.p(cVar, "getNextMatch");
        this.qvi = charSequence;
        this.bPg = i;
        this.limit = i2;
        this.qvj = cVar;
    }

    @kotlin.e
    /* loaded from: classes14.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int counter;
        private int quX = -1;
        private int qvk;
        private int qvl;
        private kotlin.b.h qvm;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.qvk = kotlin.b.l.ao(d.this.bPg, 0, d.this.qvi.length());
            this.qvl = this.qvk;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.counter < r7.qvn.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eLs() {
            if (this.qvl >= 0) {
                if (d.this.limit > 0) {
                    this.counter++;
                }
                if (this.qvl <= d.this.qvi.length()) {
                    Pair pair = (Pair) d.this.qvj.invoke(d.this.qvi, Integer.valueOf(this.qvl));
                    if (pair == null) {
                        this.qvm = new kotlin.b.h(this.qvk, l.C(d.this.qvi));
                        this.qvl = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.qvm = new kotlin.b.h(this.qvk, intValue - 1);
                        this.qvk = intValue + intValue2;
                        this.qvl = (intValue2 == 0 ? 1 : 0) + this.qvk;
                    }
                    this.quX = 1;
                    return;
                }
                this.qvm = new kotlin.b.h(this.qvk, l.C(d.this.qvi));
                this.qvl = -1;
                this.quX = 1;
                return;
            }
            this.quX = 0;
            this.qvm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eLt */
        public kotlin.b.h next() {
            if (this.quX == -1) {
                eLs();
            }
            if (this.quX == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.qvm;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.qvm = null;
            this.quX = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.quX == -1) {
                eLs();
            }
            return this.quX == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
