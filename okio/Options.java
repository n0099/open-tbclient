package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes9.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteString[] byteStrings;
    public final int[] trie;

    public Options(ByteString[] byteStringArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteStringArr, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static void buildTrieRecursive(long j2, Buffer buffer, int i2, List<ByteString> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        int i7;
        Buffer buffer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), buffer, Integer.valueOf(i2), list, Integer.valueOf(i3), Integer.valueOf(i4), list2}) == null) {
            int i8 = i3;
            if (i8 < i4) {
                for (int i9 = i8; i9 < i4; i9++) {
                    if (list.get(i9).size() < i2) {
                        throw new AssertionError();
                    }
                }
                ByteString byteString = list.get(i3);
                ByteString byteString2 = list.get(i4 - 1);
                int i10 = -1;
                if (i2 == byteString.size()) {
                    i10 = list2.get(i8).intValue();
                    i8++;
                    byteString = list.get(i8);
                }
                int i11 = i8;
                if (byteString.getByte(i2) != byteString2.getByte(i2)) {
                    int i12 = 1;
                    for (int i13 = i11 + 1; i13 < i4; i13++) {
                        if (list.get(i13 - 1).getByte(i2) != list.get(i13).getByte(i2)) {
                            i12++;
                        }
                    }
                    long intCount = j2 + intCount(buffer) + 2 + (i12 * 2);
                    buffer.writeInt(i12);
                    buffer.writeInt(i10);
                    for (int i14 = i11; i14 < i4; i14++) {
                        byte b2 = list.get(i14).getByte(i2);
                        if (i14 == i11 || b2 != list.get(i14 - 1).getByte(i2)) {
                            buffer.writeInt(b2 & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    int i15 = i11;
                    while (i15 < i4) {
                        byte b3 = list.get(i15).getByte(i2);
                        int i16 = i15 + 1;
                        int i17 = i16;
                        while (true) {
                            if (i17 >= i4) {
                                i6 = i4;
                                break;
                            } else if (b3 != list.get(i17).getByte(i2)) {
                                i6 = i17;
                                break;
                            } else {
                                i17++;
                            }
                        }
                        if (i16 == i6 && i2 + 1 == list.get(i15).size()) {
                            buffer.writeInt(list2.get(i15).intValue());
                            i7 = i6;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                            i7 = i6;
                            buffer2 = buffer3;
                            buildTrieRecursive(intCount, buffer3, i2 + 1, list, i15, i6, list2);
                        }
                        buffer3 = buffer2;
                        i15 = i7;
                    }
                    Buffer buffer4 = buffer3;
                    buffer.write(buffer4, buffer4.size());
                    return;
                }
                int i18 = 0;
                int min = Math.min(byteString.size(), byteString2.size());
                for (int i19 = i2; i19 < min && byteString.getByte(i19) == byteString2.getByte(i19); i19++) {
                    i18++;
                }
                long intCount2 = 1 + j2 + intCount(buffer) + 2 + i18;
                buffer.writeInt(-i18);
                buffer.writeInt(i10);
                int i20 = i2;
                while (true) {
                    i5 = i2 + i18;
                    if (i20 >= i5) {
                        break;
                    }
                    buffer.writeInt(byteString.getByte(i20) & 255);
                    i20++;
                }
                if (i11 + 1 == i4) {
                    if (i5 == list.get(i11).size()) {
                        buffer.writeInt(list2.get(i11).intValue());
                        return;
                    }
                    throw new AssertionError();
                }
                Buffer buffer5 = new Buffer();
                buffer.writeInt((int) ((intCount(buffer5) + intCount2) * (-1)));
                buildTrieRecursive(intCount2, buffer5, i5, list, i11, i4, list2);
                buffer.write(buffer5, buffer5.size());
                return;
            }
            throw new AssertionError();
        }
    }

    public static int intCount(Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, buffer)) == null) ? (int) (buffer.size() / 4) : invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Options of(ByteString... byteStringArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteStringArr)) == null) {
            if (byteStringArr.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1});
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
            Collections.sort(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(-1);
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i3]), Integer.valueOf(i3));
            }
            if (((ByteString) arrayList.get(0)).size() != 0) {
                int i4 = 0;
                while (i4 < arrayList.size()) {
                    ByteString byteString = (ByteString) arrayList.get(i4);
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (i6 < arrayList.size()) {
                        ByteString byteString2 = (ByteString) arrayList.get(i6);
                        if (!byteString2.startsWith(byteString)) {
                            break;
                        } else if (byteString2.size() != byteString.size()) {
                            if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                                arrayList.remove(i6);
                                arrayList2.remove(i6);
                            } else {
                                i6++;
                            }
                        } else {
                            throw new IllegalArgumentException("duplicate option: " + byteString2);
                        }
                    }
                    i4 = i5;
                }
                Buffer buffer = new Buffer();
                buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
                int intCount = intCount(buffer);
                int[] iArr = new int[intCount];
                for (int i7 = 0; i7 < intCount; i7++) {
                    iArr[i7] = buffer.readInt();
                }
                if (buffer.exhausted()) {
                    return new Options((ByteString[]) byteStringArr.clone(), iArr);
                }
                throw new AssertionError();
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        return (Options) invokeL.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.byteStrings.length : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.byteStrings[i2] : (ByteString) invokeI.objValue;
    }
}
