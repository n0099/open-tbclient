package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes5.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int btx;
    private final int limit;
    private final CharSequence oDw;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> oDx;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.oDw = charSequence;
        this.btx = i;
        this.limit = i2;
        this.oDx = mVar;
    }

    @kotlin.h
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private kotlin.b.h oDA;
        private int oDB;
        private int oDj = -1;
        private int oDy;
        private int oDz;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.oDy = kotlin.b.l.ap(d.this.btx, 0, d.this.oDw.length());
            this.oDz = this.oDy;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.oDB < r6.oDC.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void ekI() {
            if (this.oDz >= 0) {
                if (d.this.limit > 0) {
                    this.oDB++;
                }
                if (this.oDz <= d.this.oDw.length()) {
                    Pair pair = (Pair) d.this.oDx.invoke(d.this.oDw, Integer.valueOf(this.oDz));
                    if (pair == null) {
                        this.oDA = new kotlin.b.h(this.oDy, l.v(d.this.oDw));
                        this.oDz = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.oDA = kotlin.b.l.el(this.oDy, intValue);
                        this.oDy = intValue + intValue2;
                        this.oDz = (intValue2 == 0 ? 1 : 0) + this.oDy;
                    }
                    this.oDj = 1;
                    return;
                }
                this.oDA = new kotlin.b.h(this.oDy, l.v(d.this.oDw));
                this.oDz = -1;
                this.oDj = 1;
                return;
            }
            this.oDj = 0;
            this.oDA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: ekJ */
        public kotlin.b.h next() {
            if (this.oDj == -1) {
                ekI();
            }
            if (this.oDj == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.oDA;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.oDA = null;
            this.oDj = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.oDj == -1) {
                ekI();
            }
            return this.oDj == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
