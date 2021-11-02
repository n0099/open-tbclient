package kotlin.ranges;

import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "", "hasNext", "()Z", "", "nextChar", "()C", "", "finalElement", "I", "Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, ShaderParams.VALUE_TYPE_STEP, "getStep", "()I", "first", "last", "<init>", "(CCI)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class CharProgressionIterator extends CharIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public CharProgressionIterator(char c2, char c3, int i2) {
        this.step = i2;
        this.finalElement = c3;
        boolean z = true;
        int compare = Intrinsics.compare((int) c2, (int) c3);
        if (i2 <= 0 ? compare < 0 : compare > 0) {
            z = false;
        }
        this.hasNext = z;
        this.next = z ? c2 : this.finalElement;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int i2 = this.next;
        if (i2 == this.finalElement) {
            if (this.hasNext) {
                this.hasNext = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.next = this.step + i2;
        }
        return (char) i2;
    }
}
