package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes20.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bqk;
    private final int limit;
    private final CharSequence otx;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> oty;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.q.m(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.q.m(mVar, "getNextMatch");
        this.otx = charSequence;
        this.bqk = i;
        this.limit = i2;
        this.oty = mVar;
    }

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int otA;
        private kotlin.b.h otB;
        private int otC;
        private int otk = -1;
        private int otz;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.otz = kotlin.b.l.am(d.this.bqk, 0, d.this.otx.length());
            this.otA = this.otz;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r6.otC < r6.otD.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void egC() {
            if (this.otA >= 0) {
                if (d.this.limit > 0) {
                    this.otC++;
                }
                if (this.otA <= d.this.otx.length()) {
                    Pair pair = (Pair) d.this.oty.invoke(d.this.otx, Integer.valueOf(this.otA));
                    if (pair == null) {
                        this.otB = new kotlin.b.h(this.otz, l.x(d.this.otx));
                        this.otA = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.otB = kotlin.b.l.eh(this.otz, intValue);
                        this.otz = intValue + intValue2;
                        this.otA = (intValue2 == 0 ? 1 : 0) + this.otz;
                    }
                    this.otk = 1;
                    return;
                }
                this.otB = new kotlin.b.h(this.otz, l.x(d.this.otx));
                this.otA = -1;
                this.otk = 1;
                return;
            }
            this.otk = 0;
            this.otB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: egD */
        public kotlin.b.h next() {
            if (this.otk == -1) {
                egC();
            }
            if (this.otk == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.otB;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.otB = null;
            this.otk = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.otk == -1) {
                egC();
            }
            return this.otk == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
