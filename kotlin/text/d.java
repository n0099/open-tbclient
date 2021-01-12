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
    private final CharSequence qkb;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> qkc;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.qkb = charSequence;
        this.bJW = i;
        this.limit = i2;
        this.qkc = cVar;
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int qjQ = -1;
        private int qkd;
        private int qke;
        private kotlin.b.h qkf;
        private int qkg;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.qkd = kotlin.b.l.aq(d.this.bJW, 0, d.this.qkb.length());
            this.qke = this.qkd;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.qkg < r7.qkh.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eJm() {
            if (this.qke >= 0) {
                if (d.this.limit > 0) {
                    this.qkg++;
                }
                if (this.qke <= d.this.qkb.length()) {
                    Pair pair = (Pair) d.this.qkc.invoke(d.this.qkb, Integer.valueOf(this.qke));
                    if (pair == null) {
                        this.qkf = new kotlin.b.h(this.qkd, l.B(d.this.qkb));
                        this.qke = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.qkf = new kotlin.b.h(this.qkd, intValue - 1);
                        this.qkd = intValue + intValue2;
                        this.qke = (intValue2 == 0 ? 1 : 0) + this.qkd;
                    }
                    this.qjQ = 1;
                    return;
                }
                this.qkf = new kotlin.b.h(this.qkd, l.B(d.this.qkb));
                this.qke = -1;
                this.qjQ = 1;
                return;
            }
            this.qjQ = 0;
            this.qkf = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eJn */
        public kotlin.b.h next() {
            if (this.qjQ == -1) {
                eJm();
            }
            if (this.qjQ == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.qkf;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.qkf = null;
            this.qjQ = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qjQ == -1) {
                eJm();
            }
            return this.qjQ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
