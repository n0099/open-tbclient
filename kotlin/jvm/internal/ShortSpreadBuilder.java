package kotlin.jvm.internal;

import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/jvm/internal/ShortSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "value", "", "add", "(S)V", "", "toArray", "()[S", "", "getSize", "([S)I", SavedStateHandle.VALUES, "[S", "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ShortSpreadBuilder extends PrimitiveSpreadBuilder<short[]> {
    public final short[] values;

    public ShortSpreadBuilder(int i2) {
        super(i2);
        this.values = new short[i2];
    }

    public final void add(short s) {
        short[] sArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        sArr[position] = s;
    }

    public final short[] toArray() {
        return toArray(this.values, new short[size()]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(short[] getSize) {
        Intrinsics.checkNotNullParameter(getSize, "$this$getSize");
        return getSize.length;
    }
}
