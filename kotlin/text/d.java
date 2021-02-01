package kotlin.text;

import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes6.dex */
public final class d implements kotlin.sequences.c<kotlin.b.h> {
    private final int bNG;
    private final int limit;
    private final CharSequence qug;
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> quh;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.p.o(charSequence, Config.INPUT_PART);
        kotlin.jvm.internal.p.o(cVar, "getNextMatch");
        this.qug = charSequence;
        this.bNG = i;
        this.limit = i2;
        this.quh = cVar;
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a implements Iterator<kotlin.b.h> {
        private int counter;
        private int qtV = -1;
        private int qui;
        private int quj;
        private kotlin.b.h quk;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.qui = kotlin.b.l.ao(d.this.bNG, 0, d.this.qug.length());
            this.quj = this.qui;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r7.counter < r7.qul.limit) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void eLC() {
            if (this.quj >= 0) {
                if (d.this.limit > 0) {
                    this.counter++;
                }
                if (this.quj <= d.this.qug.length()) {
                    Pair pair = (Pair) d.this.quh.invoke(d.this.qug, Integer.valueOf(this.quj));
                    if (pair == null) {
                        this.quk = new kotlin.b.h(this.qui, l.C(d.this.qug));
                        this.quj = -1;
                    } else {
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        this.quk = new kotlin.b.h(this.qui, intValue - 1);
                        this.qui = intValue + intValue2;
                        this.quj = (intValue2 == 0 ? 1 : 0) + this.qui;
                    }
                    this.qtV = 1;
                    return;
                }
                this.quk = new kotlin.b.h(this.qui, l.C(d.this.qug));
                this.quj = -1;
                this.qtV = 1;
                return;
            }
            this.qtV = 0;
            this.quk = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: eLD */
        public kotlin.b.h next() {
            if (this.qtV == -1) {
                eLC();
            }
            if (this.qtV == 0) {
                throw new NoSuchElementException();
            }
            kotlin.b.h hVar = this.quk;
            if (hVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.quk = null;
            this.qtV = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qtV == -1) {
                eLC();
            }
            return this.qtV == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<kotlin.b.h> iterator() {
        return new a();
    }
}
