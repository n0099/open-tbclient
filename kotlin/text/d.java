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
    private final int aDD;
    private final int limit;
    private final CharSequence nDm;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nDn;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.nDm = charSequence;
        this.aDD = i;
        this.limit = i2;
        this.nDn = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nCZ = -1;
        private int nDo;
        private int nDp;
        private kotlin.b.h nDq;
        private int nDr;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nDo = kotlin.b.l.aw(d.this.aDD, 0, d.this.nDm.length());
            this.nDp = this.nDo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nDr < r6.nDs.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dKO() {
            if (this.nDp >= 0) {
                if (d.this.limit > 0) {
                    this.nDr++;
                }
                if (this.nDp <= d.this.nDm.length()) {
                    Pair pair = (Pair) d.this.nDn.invoke(d.this.nDm, Integer.valueOf(this.nDp));
                    if (pair == null) {
                        this.nDq = new kotlin.b.h(this.nDo, l.t(d.this.nDm));
                        this.nDp = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nDq = kotlin.b.l.ex(this.nDo, intValue);
                        this.nDo = intValue + intValue2;
                        this.nDp = (intValue2 == 0 ? 1 : 0) + this.nDo;
                    }
                    this.nCZ = 1;
                    return;
                }
                this.nDq = new kotlin.b.h(this.nDo, l.t(d.this.nDm));
                this.nDp = -1;
                this.nCZ = 1;
                return;
            }
            this.nCZ = 0;
            this.nDq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dKP */
        public kotlin.b.h next() {
            if (this.nCZ == -1) {
                dKO();
            }
            if (this.nCZ == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nDq;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nDq = null;
            this.nCZ = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nCZ == -1) {
                dKO();
            }
            return this.nCZ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
