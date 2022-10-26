package com.google.android.exoplayer2.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class TrackGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Format[] formats;
    public int hashCode;
    public final int length;

    public TrackGroup(Format... formatArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {formatArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (formatArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackGroup.class != obj.getClass()) {
                return false;
            }
            TrackGroup trackGroup = (TrackGroup) obj;
            if (this.length == trackGroup.length && Arrays.equals(this.formats, trackGroup.formats)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Format getFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.formats[i];
        }
        return (Format) invokeI.objValue;
    }

    public int indexOf(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, format)) == null) {
            int i = 0;
            while (true) {
                Format[] formatArr = this.formats;
                if (i < formatArr.length) {
                    if (format == formatArr[i]) {
                        return i;
                    }
                    i++;
                } else {
                    return -1;
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.hashCode == 0) {
                this.hashCode = 527 + Arrays.hashCode(this.formats);
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }
}
