package com.googlecode.mp4parser.h264.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class ChromaFormat {
    public static /* synthetic */ Interceptable $ic;
    public static ChromaFormat MONOCHROME;
    public static ChromaFormat YUV_420;
    public static ChromaFormat YUV_422;
    public static ChromaFormat YUV_444;
    public transient /* synthetic */ FieldHolder $fh;
    public int id;
    public int subHeight;
    public int subWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-916494641, "Lcom/googlecode/mp4parser/h264/model/ChromaFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-916494641, "Lcom/googlecode/mp4parser/h264/model/ChromaFormat;");
                return;
            }
        }
        MONOCHROME = new ChromaFormat(0, 0, 0);
        YUV_420 = new ChromaFormat(1, 2, 2);
        YUV_422 = new ChromaFormat(2, 2, 1);
        YUV_444 = new ChromaFormat(3, 1, 1);
    }

    public ChromaFormat(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.id = i2;
        this.subWidth = i3;
        this.subHeight = i4;
    }

    public static ChromaFormat fromId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            ChromaFormat chromaFormat = MONOCHROME;
            if (i2 == chromaFormat.id) {
                return chromaFormat;
            }
            ChromaFormat chromaFormat2 = YUV_420;
            if (i2 == chromaFormat2.id) {
                return chromaFormat2;
            }
            ChromaFormat chromaFormat3 = YUV_422;
            if (i2 == chromaFormat3.id) {
                return chromaFormat3;
            }
            ChromaFormat chromaFormat4 = YUV_444;
            if (i2 == chromaFormat4.id) {
                return chromaFormat4;
            }
            return null;
        }
        return (ChromaFormat) invokeI.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.intValue;
    }

    public int getSubHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.subHeight : invokeV.intValue;
    }

    public int getSubWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.subWidth : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ChromaFormat{\nid=" + this.id + ",\n subWidth=" + this.subWidth + ",\n subHeight=" + this.subHeight + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
