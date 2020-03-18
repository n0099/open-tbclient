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
    private final int aDS;
    private final int limit;
    private final CharSequence nFk;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nFl;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.nFk = charSequence;
        this.aDS = i;
        this.limit = i2;
        this.nFl = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nEX = -1;
        private int nFm;
        private int nFn;
        private kotlin.b.h nFo;
        private int nFp;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nFm = kotlin.b.l.aw(d.this.aDS, 0, d.this.nFk.length());
            this.nFn = this.nFm;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nFp < r6.nFq.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dLp() {
            if (this.nFn >= 0) {
                if (d.this.limit > 0) {
                    this.nFp++;
                }
                if (this.nFn <= d.this.nFk.length()) {
                    Pair pair = (Pair) d.this.nFl.invoke(d.this.nFk, Integer.valueOf(this.nFn));
                    if (pair == null) {
                        this.nFo = new kotlin.b.h(this.nFm, l.t(d.this.nFk));
                        this.nFn = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nFo = kotlin.b.l.ey(this.nFm, intValue);
                        this.nFm = intValue + intValue2;
                        this.nFn = (intValue2 == 0 ? 1 : 0) + this.nFm;
                    }
                    this.nEX = 1;
                    return;
                }
                this.nFo = new kotlin.b.h(this.nFm, l.t(d.this.nFk));
                this.nFn = -1;
                this.nEX = 1;
                return;
            }
            this.nEX = 0;
            this.nFo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dLq */
        public kotlin.b.h next() {
            if (this.nEX == -1) {
                dLp();
            }
            if (this.nEX == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nFo;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nFo = null;
            this.nEX = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nEX == -1) {
                dLp();
            }
            return this.nEX == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
