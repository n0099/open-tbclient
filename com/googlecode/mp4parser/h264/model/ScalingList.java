package com.googlecode.mp4parser.h264.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;
/* loaded from: classes7.dex */
public class ScalingList {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public ScalingList() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ScalingList{scalingList=" + this.scalingList + ", useDefaultScalingMatrixFlag=" + this.useDefaultScalingMatrixFlag + '}';
        }
        return (String) invokeV.objValue;
    }

    public static ScalingList read(CAVLCReader cAVLCReader, int i) throws IOException {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, cAVLCReader, i)) == null) {
            ScalingList scalingList = new ScalingList();
            scalingList.scalingList = new int[i];
            int i2 = 8;
            int i3 = 8;
            for (int i4 = 0; i4 < i; i4++) {
                if (i2 != 0) {
                    i2 = ((cAVLCReader.readSE("deltaScale") + i3) + 256) % 256;
                    if (i4 == 0 && i2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    scalingList.useDefaultScalingMatrixFlag = z;
                }
                int[] iArr = scalingList.scalingList;
                if (i2 != 0) {
                    i3 = i2;
                }
                iArr[i4] = i3;
                i3 = scalingList.scalingList[i4];
            }
            return scalingList;
        }
        return (ScalingList) invokeLI.objValue;
    }

    public void write(CAVLCWriter cAVLCWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cAVLCWriter) == null) {
            int i = 0;
            if (this.useDefaultScalingMatrixFlag) {
                cAVLCWriter.writeSE(0, "SPS: ");
                return;
            }
            int i2 = 8;
            while (true) {
                int[] iArr = this.scalingList;
                if (i >= iArr.length) {
                    return;
                }
                cAVLCWriter.writeSE((iArr[i] - i2) - 256, "SPS: ");
                i2 = this.scalingList[i];
                i++;
            }
        }
    }
}
