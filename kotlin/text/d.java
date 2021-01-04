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
    private final CharSequence qmV;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> qmW;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.qmV = charSequence;
        this.bOI = i;
        this.limit = i2;
        this.qmW = cVar;
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int qmK = -1;
        private int qmX;
        private int qmY;
        private kotlin.b.h qmZ;
        private int qna;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.qmX = kotlin.b.l.ap(d.this.bOI, 0, d.this.qmV.length());
            this.qmY = this.qmX;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.qna < r7.qnb.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eMy() {
            if (this.qmY >= 0) {
                if (d.this.limit > 0) {
                    this.qna++;
                }
                if (this.qmY <= d.this.qmV.length()) {
                    Pair pair = (Pair) d.this.qmW.invoke(d.this.qmV, Integer.valueOf(this.qmY));
                    if (pair == null) {
                        this.qmZ = new kotlin.b.h(this.qmX, l.B(d.this.qmV));
                        this.qmY = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.qmZ = new kotlin.b.h(this.qmX, intValue - 1);
                        this.qmX = intValue + intValue2;
                        this.qmY = (intValue2 == 0 ? 1 : 0) + this.qmX;
                    }
                    this.qmK = 1;
                    return;
                }
                this.qmZ = new kotlin.b.h(this.qmX, l.B(d.this.qmV));
                this.qmY = -1;
                this.qmK = 1;
                return;
            }
            this.qmK = 0;
            this.qmZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eMz */
        public kotlin.b.h next() {
            if (this.qmK == -1) {
                eMy();
            }
            if (this.qmK == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.qmZ;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.qmZ = null;
            this.qmK = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qmK == -1) {
                eMy();
            }
            return this.qmK == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
