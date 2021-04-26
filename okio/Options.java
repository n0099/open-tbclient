package okio;

import java.util.AbstractList;
import java.util.RandomAccess;
/* loaded from: classes7.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final ByteString[] byteStrings;

    public Options(ByteString[] byteStringArr) {
        this.byteStrings = byteStringArr;
    }

    public static Options of(ByteString... byteStringArr) {
        return new Options((ByteString[]) byteStringArr.clone());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.byteStrings.length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i2) {
        return this.byteStrings[i2];
    }
}
