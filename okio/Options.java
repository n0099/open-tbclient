package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes4.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ByteString byteString = (ByteString) arrayList.get(i3);
            int i4 = i3 + 1;
            while (true) {
                int i5 = i4;
                if (i5 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i5);
                    if (!byteString2.startsWith(byteString)) {
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else {
                        if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                            arrayList.remove(i5);
                            arrayList2.remove(i5);
                            i4 = i5;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                }
            }
        }
        Buffer buffer = new Buffer();
        buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int[] iArr = new int[intCount(buffer)];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = buffer.readInt();
        }
        if (!buffer.exhausted()) {
            throw new AssertionError();
        }
        return new Options((ByteString[]) byteStringArr.clone(), iArr);
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        ByteString byteString;
        int i4;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i5 = i2; i5 < i3; i5++) {
            if (list.get(i5).size() < i) {
                throw new AssertionError();
            }
        }
        ByteString byteString2 = list.get(i2);
        ByteString byteString3 = list.get(i3 - 1);
        int i6 = -1;
        if (i == byteString2.size()) {
            i6 = list2.get(i2).intValue();
            i4 = i2 + 1;
            byteString = list.get(i4);
        } else {
            byteString = byteString2;
            i4 = i2;
        }
        if (byteString.getByte(i) != byteString3.getByte(i)) {
            int i7 = 1;
            int i8 = i4 + 1;
            while (i8 < i3) {
                int i9 = list.get(i8 + (-1)).getByte(i) != list.get(i8).getByte(i) ? i7 + 1 : i7;
                i8++;
                i7 = i9;
            }
            long intCount = intCount(buffer) + j + 2 + (i7 * 2);
            buffer.writeInt(i7);
            buffer.writeInt(i6);
            for (int i10 = i4; i10 < i3; i10++) {
                byte b2 = list.get(i10).getByte(i);
                if (i10 == i4 || b2 != list.get(i10 - 1).getByte(i)) {
                    buffer.writeInt(b2 & 255);
                }
            }
            Buffer buffer2 = new Buffer();
            while (i4 < i3) {
                byte b3 = list.get(i4).getByte(i);
                int i11 = i4 + 1;
                while (true) {
                    if (i11 >= i3) {
                        i11 = i3;
                        break;
                    } else if (b3 != list.get(i11).getByte(i)) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i4 + 1 == i11 && i + 1 == list.get(i4).size()) {
                    buffer.writeInt(list2.get(i4).intValue());
                } else {
                    buffer.writeInt((int) ((-1) * (intCount(buffer2) + intCount)));
                    buildTrieRecursive(intCount, buffer2, i + 1, list, i4, i11, list2);
                }
                i4 = i11;
            }
            buffer.write(buffer2, buffer2.size());
            return;
        }
        int i12 = 0;
        int min = Math.min(byteString.size(), byteString3.size());
        for (int i13 = i; i13 < min && byteString.getByte(i13) == byteString3.getByte(i13); i13++) {
            i12++;
        }
        long intCount2 = intCount(buffer) + j + 2 + i12 + 1;
        buffer.writeInt(-i12);
        buffer.writeInt(i6);
        for (int i14 = i; i14 < i + i12; i14++) {
            buffer.writeInt(byteString.getByte(i14) & 255);
        }
        if (i4 + 1 == i3) {
            if (i + i12 != list.get(i4).size()) {
                throw new AssertionError();
            }
            buffer.writeInt(list2.get(i4).intValue());
            return;
        }
        Buffer buffer3 = new Buffer();
        buffer.writeInt((int) ((-1) * (intCount(buffer3) + intCount2)));
        buildTrieRecursive(intCount2, buffer3, i + i12, list, i4, i3, list2);
        buffer.write(buffer3, buffer3.size());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
