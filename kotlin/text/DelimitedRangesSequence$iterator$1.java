package kotlin.text;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\"\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "calcNext", "()V", "", "hasNext", "()Z", "Lkotlin/ranges/IntRange;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Lkotlin/ranges/IntRange;", "", "counter", "I", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "Lkotlin/ranges/IntRange;", "getNextItem", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    public int counter;
    public int currentStartIndex;
    public IntRange nextItem;
    public int nextSearchIndex;
    public int nextState = -1;
    public final /* synthetic */ DelimitedRangesSequence this$0;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i2;
        CharSequence charSequence;
        this.this$0 = delimitedRangesSequence;
        i2 = delimitedRangesSequence.startIndex;
        charSequence = delimitedRangesSequence.input;
        int coerceIn = RangesKt___RangesKt.coerceIn(i2, 0, charSequence.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r0 < r4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calcNext() {
        int i2;
        CharSequence charSequence;
        Function2 function2;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i3;
        if (this.nextSearchIndex >= 0) {
            i2 = this.this$0.limit;
            if (i2 > 0) {
                int i4 = this.counter + 1;
                this.counter = i4;
                i3 = this.this$0.limit;
            }
            int i5 = this.nextSearchIndex;
            charSequence = this.this$0.input;
            if (i5 <= charSequence.length()) {
                function2 = this.this$0.getNextMatch;
                charSequence2 = this.this$0.input;
                Pair pair = (Pair) function2.invoke(charSequence2, Integer.valueOf(this.nextSearchIndex));
                if (pair == null) {
                    int i6 = this.currentStartIndex;
                    charSequence3 = this.this$0.input;
                    this.nextItem = new IntRange(i6, StringsKt__StringsKt.getLastIndex(charSequence3));
                    this.nextSearchIndex = -1;
                } else {
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    this.nextItem = RangesKt___RangesKt.until(this.currentStartIndex, intValue);
                    int i7 = intValue + intValue2;
                    this.currentStartIndex = i7;
                    this.nextSearchIndex = i7 + (intValue2 == 0 ? 1 : 0);
                }
                this.nextState = 1;
                return;
            }
            int i8 = this.currentStartIndex;
            charSequence4 = this.this$0.input;
            this.nextItem = new IntRange(i8, StringsKt__StringsKt.getLastIndex(charSequence4));
            this.nextSearchIndex = -1;
            this.nextState = 1;
            return;
        }
        this.nextState = 0;
        this.nextItem = null;
    }

    public final int getCounter() {
        return this.counter;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    public final IntRange getNextItem() {
        return this.nextItem;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCounter(int i2) {
        this.counter = i2;
    }

    public final void setCurrentStartIndex(int i2) {
        this.currentStartIndex = i2;
    }

    public final void setNextItem(IntRange intRange) {
        this.nextItem = intRange;
    }

    public final void setNextSearchIndex(int i2) {
        this.nextSearchIndex = i2;
    }

    public final void setNextState(int i2) {
        this.nextState = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    public IntRange next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            IntRange intRange = this.nextItem;
            if (intRange != null) {
                this.nextItem = null;
                this.nextState = -1;
                return intRange;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }
}
