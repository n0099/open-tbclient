package kotlin.jvm.internal;

import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0002*\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lkotlin/jvm/internal/IntSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "value", "", "add", "(I)V", "", "toArray", "()[I", "getSize", "([I)I", SavedStateHandle.VALUES, "[I", "size", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class IntSpreadBuilder extends PrimitiveSpreadBuilder<int[]> {
    public final int[] values;

    public IntSpreadBuilder(int i2) {
        super(i2);
        this.values = new int[i2];
    }

    public final void add(int i2) {
        int[] iArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        iArr[position] = i2;
    }

    public final int[] toArray() {
        return toArray(this.values, new int[size()]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(int[] getSize) {
        Intrinsics.checkNotNullParameter(getSize, "$this$getSize");
        return getSize.length;
    }
}
