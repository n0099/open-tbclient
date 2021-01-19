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
    private final int bJW;
    private final int limit;
    private final CharSequence qkc;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> qkd;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.qkc = charSequence;
        this.bJW = i;
        this.limit = i2;
        this.qkd = cVar;
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int qjR = -1;
        private int qke;
        private int qkf;
        private kotlin.b.h qkg;
        private int qkh;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.qke = kotlin.b.l.aq(d.this.bJW, 0, d.this.qkc.length());
            this.qkf = this.qke;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.qkh < r7.qki.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eJm() {
            if (this.qkf >= 0) {
                if (d.this.limit > 0) {
                    this.qkh++;
                }
                if (this.qkf <= d.this.qkc.length()) {
                    Pair pair = (Pair) d.this.qkd.invoke(d.this.qkc, Integer.valueOf(this.qkf));
                    if (pair == null) {
                        this.qkg = new kotlin.b.h(this.qke, l.B(d.this.qkc));
                        this.qkf = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.qkg = new kotlin.b.h(this.qke, intValue - 1);
                        this.qke = intValue + intValue2;
                        this.qkf = (intValue2 == 0 ? 1 : 0) + this.qke;
                    }
                    this.qjR = 1;
                    return;
                }
                this.qkg = new kotlin.b.h(this.qke, l.B(d.this.qkc));
                this.qkf = -1;
                this.qjR = 1;
                return;
            }
            this.qjR = 0;
            this.qkg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eJn */
        public kotlin.b.h next() {
            if (this.qjR == -1) {
                eJm();
            }
            if (this.qjR == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.qkg;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.qkg = null;
            this.qjR = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qjR == -1) {
                eJm();
            }
            return this.qjR == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
