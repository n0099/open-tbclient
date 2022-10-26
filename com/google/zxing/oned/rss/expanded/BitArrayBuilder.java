package com.google.zxing.oned.rss.expanded;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
import java.util.List;
/* loaded from: classes7.dex */
public final class BitArrayBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitArrayBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BitArray buildBitArray(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int size = (list.size() << 1) - 1;
            if (((ExpandedPair) list.get(list.size() - 1)).getRightChar() == null) {
                size--;
            }
            BitArray bitArray = new BitArray(size * 12);
            int i = 0;
            int value = ((ExpandedPair) list.get(0)).getRightChar().getValue();
            for (int i2 = 11; i2 >= 0; i2--) {
                if (((1 << i2) & value) != 0) {
                    bitArray.set(i);
                }
                i++;
            }
            for (int i3 = 1; i3 < list.size(); i3++) {
                ExpandedPair expandedPair = (ExpandedPair) list.get(i3);
                int value2 = expandedPair.getLeftChar().getValue();
                for (int i4 = 11; i4 >= 0; i4--) {
                    if (((1 << i4) & value2) != 0) {
                        bitArray.set(i);
                    }
                    i++;
                }
                if (expandedPair.getRightChar() != null) {
                    int value3 = expandedPair.getRightChar().getValue();
                    for (int i5 = 11; i5 >= 0; i5--) {
                        if (((1 << i5) & value3) != 0) {
                            bitArray.set(i);
                        }
                        i++;
                    }
                }
            }
            return bitArray;
        }
        return (BitArray) invokeL.objValue;
    }
}
