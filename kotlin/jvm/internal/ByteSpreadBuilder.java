package kotlin.jvm.internal;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.upload.action.IMTrack;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/jvm/internal/ByteSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "value", "", IMTrack.DbBuilder.ACTION_ADD, "(B)V", "", "toArray", "()[B", "", "getSize", "([B)I", SavedStateHandle.VALUES, "[B", "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ByteSpreadBuilder extends PrimitiveSpreadBuilder<byte[]> {
    public final byte[] values;

    public ByteSpreadBuilder(int i2) {
        super(i2);
        this.values = new byte[i2];
    }

    public final void add(byte b2) {
        byte[] bArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        bArr[position] = b2;
    }

    public final byte[] toArray() {
        return toArray(this.values, new byte[size()]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(byte[] getSize) {
        Intrinsics.checkNotNullParameter(getSize, "$this$getSize");
        return getSize.length;
    }
}
