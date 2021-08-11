package com.google.zxing.oned.rss.expanded;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
import java.util.List;
/* loaded from: classes10.dex */
public final class BitArrayBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitArrayBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BitArray buildBitArray(List<ExpandedPair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int size = (list.size() << 1) - 1;
            if (list.get(list.size() - 1).getRightChar() == null) {
                size--;
            }
            BitArray bitArray = new BitArray(size * 12);
            int i2 = 0;
            int value = list.get(0).getRightChar().getValue();
            for (int i3 = 11; i3 >= 0; i3--) {
                if (((1 << i3) & value) != 0) {
                    bitArray.set(i2);
                }
                i2++;
            }
            for (int i4 = 1; i4 < list.size(); i4++) {
                ExpandedPair expandedPair = list.get(i4);
                int value2 = expandedPair.getLeftChar().getValue();
                for (int i5 = 11; i5 >= 0; i5--) {
                    if (((1 << i5) & value2) != 0) {
                        bitArray.set(i2);
                    }
                    i2++;
                }
                if (expandedPair.getRightChar() != null) {
                    int value3 = expandedPair.getRightChar().getValue();
                    for (int i6 = 11; i6 >= 0; i6--) {
                        if (((1 << i6) & value3) != 0) {
                            bitArray.set(i2);
                        }
                        i2++;
                    }
                }
            }
            return bitArray;
        }
        return (BitArray) invokeL.objValue;
    }
}
