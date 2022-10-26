package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.UriUtil;
/* loaded from: classes7.dex */
public final class RangedUri {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int hashCode;
    public final long length;
    public final String referenceUri;
    public final long start;

    public RangedUri(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.referenceUri = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    public RangedUri attemptMerge(RangedUri rangedUri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rangedUri, str)) == null) {
            String resolveUriString = resolveUriString(str);
            if (rangedUri != null && resolveUriString.equals(rangedUri.resolveUriString(str))) {
                long j = this.length;
                long j2 = -1;
                if (j != -1) {
                    long j3 = this.start;
                    if (j3 + j == rangedUri.start) {
                        long j4 = rangedUri.length;
                        if (j4 != -1) {
                            j2 = j + j4;
                        }
                        return new RangedUri(resolveUriString, j3, j2);
                    }
                }
                long j5 = rangedUri.length;
                if (j5 != -1) {
                    long j6 = rangedUri.start;
                    if (j6 + j5 == this.start) {
                        long j7 = this.length;
                        if (j7 != -1) {
                            j2 = j5 + j7;
                        }
                        return new RangedUri(resolveUriString, j6, j2);
                    }
                }
            }
            return null;
        }
        return (RangedUri) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || RangedUri.class != obj.getClass()) {
                return false;
            }
            RangedUri rangedUri = (RangedUri) obj;
            if (this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.hashCode == 0) {
                this.hashCode = ((((527 + ((int) this.start)) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }

    public Uri resolveUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return UriUtil.resolveToUri(str, this.referenceUri);
        }
        return (Uri) invokeL.objValue;
    }

    public String resolveUriString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return UriUtil.resolve(str, this.referenceUri);
        }
        return (String) invokeL.objValue;
    }
}
