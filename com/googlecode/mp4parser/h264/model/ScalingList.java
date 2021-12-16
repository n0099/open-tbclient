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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ScalingList read(CAVLCReader cAVLCReader, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, cAVLCReader, i2)) == null) {
            ScalingList scalingList = new ScalingList();
            scalingList.scalingList = new int[i2];
            int i3 = 8;
            int i4 = 8;
            int i5 = 0;
            while (i5 < i2) {
                if (i3 != 0) {
                    i3 = ((cAVLCReader.readSE("deltaScale") + i4) + 256) % 256;
                    scalingList.useDefaultScalingMatrixFlag = i5 == 0 && i3 == 0;
                }
                int[] iArr = scalingList.scalingList;
                if (i3 != 0) {
                    i4 = i3;
                }
                iArr[i5] = i4;
                i4 = scalingList.scalingList[i5];
                i5++;
            }
            return scalingList;
        }
        return (ScalingList) invokeLI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ScalingList{scalingList=" + this.scalingList + ", useDefaultScalingMatrixFlag=" + this.useDefaultScalingMatrixFlag + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public void write(CAVLCWriter cAVLCWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cAVLCWriter) != null) {
            return;
        }
        int i2 = 0;
        if (this.useDefaultScalingMatrixFlag) {
            cAVLCWriter.writeSE(0, "SPS: ");
            return;
        }
        int i3 = 8;
        while (true) {
            int[] iArr = this.scalingList;
            if (i2 >= iArr.length) {
                return;
            }
            cAVLCWriter.writeSE((iArr[i2] - i3) - 256, "SPS: ");
            i3 = this.scalingList[i2];
            i2++;
        }
    }
}
