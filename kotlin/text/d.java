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
    private final int aDE;
    private final int limit;
    private final CharSequence nDx;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> nDy;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.j(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.j(mVar, "getNextMatch");
        this.nDx = charSequence;
        this.aDE = i;
        this.limit = i2;
        this.nDy = mVar;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int nDA;
        private kotlin.b.h nDB;
        private int nDC;
        private int nDk = -1;
        private int nDz;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.nDz = kotlin.b.l.aw(d.this.aDE, 0, d.this.nDx.length());
            this.nDA = this.nDz;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.nDC < r6.nDD.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void dKP() {
            if (this.nDA >= 0) {
                if (d.this.limit > 0) {
                    this.nDC++;
                }
                if (this.nDA <= d.this.nDx.length()) {
                    Pair pair = (Pair) d.this.nDy.invoke(d.this.nDx, Integer.valueOf(this.nDA));
                    if (pair == null) {
                        this.nDB = new kotlin.b.h(this.nDz, l.t(d.this.nDx));
                        this.nDA = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.nDB = kotlin.b.l.ex(this.nDz, intValue);
                        this.nDz = intValue + intValue2;
                        this.nDA = (intValue2 == 0 ? 1 : 0) + this.nDz;
                    }
                    this.nDk = 1;
                    return;
                }
                this.nDB = new kotlin.b.h(this.nDz, l.t(d.this.nDx));
                this.nDA = -1;
                this.nDk = 1;
                return;
            }
            this.nDk = 0;
            this.nDB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: dKQ */
        public kotlin.b.h next() {
            if (this.nDk == -1) {
                dKP();
            }
            if (this.nDk == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.nDB;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nDB = null;
            this.nDk = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nDk == -1) {
                dKP();
            }
            return this.nDk == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
