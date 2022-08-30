package com.google.android.exoplayer2.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class TrackGroupArray {
    public static /* synthetic */ Interceptable $ic;
    public static final TrackGroupArray EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public int hashCode;
    public final int length;
    public final TrackGroup[] trackGroups;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-418545460, "Lcom/google/android/exoplayer2/source/TrackGroupArray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-418545460, "Lcom/google/android/exoplayer2/source/TrackGroupArray;");
                return;
            }
        }
        EMPTY = new TrackGroupArray(new TrackGroup[0]);
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackGroupArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackGroupArray.class != obj.getClass()) {
                return false;
            }
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            return this.length == trackGroupArray.length && Arrays.equals(this.trackGroups, trackGroupArray.trackGroups);
        }
        return invokeL.booleanValue;
    }

    public TrackGroup get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.trackGroups[i] : (TrackGroup) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.hashCode == 0) {
                this.hashCode = Arrays.hashCode(this.trackGroups);
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }

    public int indexOf(TrackGroup trackGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, trackGroup)) == null) {
            for (int i = 0; i < this.length; i++) {
                if (this.trackGroups[i] == trackGroup) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
