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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        Buffer buffer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), buffer, Integer.valueOf(i), list, Integer.valueOf(i2), Integer.valueOf(i3), list2}) == null) {
            int i7 = i2;
            if (i7 < i3) {
                for (int i8 = i7; i8 < i3; i8++) {
                    if (list.get(i8).size() < i) {
                        throw new AssertionError();
                    }
                }
                ByteString byteString = list.get(i2);
                ByteString byteString2 = list.get(i3 - 1);
                int i9 = -1;
                if (i == byteString.size()) {
                    i9 = list2.get(i7).intValue();
                    i7++;
                    byteString = list.get(i7);
                }
                int i10 = i7;
                if (byteString.getByte(i) != byteString2.getByte(i)) {
                    int i11 = 1;
                    for (int i12 = i10 + 1; i12 < i3; i12++) {
                        if (list.get(i12 - 1).getByte(i) != list.get(i12).getByte(i)) {
                            i11++;
                        }
                    }
                    long intCount = j + intCount(buffer) + 2 + (i11 * 2);
                    buffer.writeInt(i11);
                    buffer.writeInt(i9);
                    for (int i13 = i10; i13 < i3; i13++) {
                        byte b = list.get(i13).getByte(i);
                        if (i13 == i10 || b != list.get(i13 - 1).getByte(i)) {
                            buffer.writeInt(b & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    int i14 = i10;
                    while (i14 < i3) {
                        byte b2 = list.get(i14).getByte(i);
                        int i15 = i14 + 1;
                        int i16 = i15;
                        while (true) {
                            if (i16 < i3) {
                                if (b2 != list.get(i16).getByte(i)) {
                                    i5 = i16;
                                    break;
                                }
                                i16++;
                            } else {
                                i5 = i3;
                                break;
                            }
                        }
                        if (i15 == i5 && i + 1 == list.get(i14).size()) {
                            buffer.writeInt(list2.get(i14).intValue());
                            i6 = i5;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                            i6 = i5;
                            buffer2 = buffer3;
                            buildTrieRecursive(intCount, buffer3, i + 1, list, i14, i5, list2);
                        }
                        buffer3 = buffer2;
                        i14 = i6;
                    }
                    Buffer buffer4 = buffer3;
                    buffer.write(buffer4, buffer4.size());
                    return;
                }
                int i17 = 0;
                int min = Math.min(byteString.size(), byteString2.size());
                for (int i18 = i; i18 < min && byteString.getByte(i18) == byteString2.getByte(i18); i18++) {
                    i17++;
                }
                long intCount2 = 1 + j + intCount(buffer) + 2 + i17;
                buffer.writeInt(-i17);
                buffer.writeInt(i9);
                int i19 = i;
                while (true) {
                    i4 = i + i17;
                    if (i19 >= i4) {
                        break;
                    }
                    buffer.writeInt(byteString.getByte(i19) & 255);
                    i19++;
                }
                if (i10 + 1 == i3) {
                    if (i4 == list.get(i10).size()) {
                        buffer.writeInt(list2.get(i10).intValue());
                        return;
                    }
                    throw new AssertionError();
                }
                Buffer buffer5 = new Buffer();
                buffer.writeInt((int) ((intCount(buffer5) + intCount2) * (-1)));
                buildTrieRecursive(intCount2, buffer5, i4, list, i10, i3, list2);
                buffer.write(buffer5, buffer5.size());
                return;
            }
            throw new AssertionError();
        }
    }

    public static int intCount(Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, buffer)) == null) {
            return (int) (buffer.size() / 4);
        }
        return invokeL.intValue;
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
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(-1);
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
            }
            if (((ByteString) arrayList.get(0)).size() != 0) {
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    ByteString byteString = (ByteString) arrayList.get(i3);
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (i5 < arrayList.size()) {
                        ByteString byteString2 = (ByteString) arrayList.get(i5);
                        if (!byteString2.startsWith(byteString)) {
                            break;
                        } else if (byteString2.size() != byteString.size()) {
                            if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                                arrayList.remove(i5);
                                arrayList2.remove(i5);
                            } else {
                                i5++;
                            }
                        } else {
                            throw new IllegalArgumentException("duplicate option: " + byteString2);
                        }
                    }
                    i3 = i4;
                }
                Buffer buffer = new Buffer();
                buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
                int intCount = intCount(buffer);
                int[] iArr = new int[intCount];
                for (int i6 = 0; i6 < intCount; i6++) {
                    iArr[i6] = buffer.readInt();
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.byteStrings[i];
        }
        return (ByteString) invokeI.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.byteStrings.length;
        }
        return invokeV.intValue;
    }
}
