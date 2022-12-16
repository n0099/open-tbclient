package com.google.zxing.pdf417.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class BarcodeValue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, Integer> values;

    public BarcodeValue() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.values = new HashMap();
    }

    public Integer getConfidence(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.values.get(Integer.valueOf(i));
        }
        return (Integer) invokeI.objValue;
    }

    public int[] getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int i = -1;
            for (Map.Entry<Integer, Integer> entry : this.values.entrySet()) {
                if (entry.getValue().intValue() > i) {
                    i = entry.getValue().intValue();
                    arrayList.clear();
                    arrayList.add(entry.getKey());
                } else if (entry.getValue().intValue() == i) {
                    arrayList.add(entry.getKey());
                }
            }
            return PDF417Common.toIntArray(arrayList);
        }
        return (int[]) invokeV.objValue;
    }

    public void setValue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Integer num = this.values.get(Integer.valueOf(i));
            if (num == null) {
                num = 0;
            }
            this.values.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
        }
    }
}
