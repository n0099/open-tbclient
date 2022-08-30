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
                if (j != -1) {
                    long j2 = this.start;
                    if (j2 + j == rangedUri.start) {
                        long j3 = rangedUri.length;
                        return new RangedUri(resolveUriString, j2, j3 != -1 ? j + j3 : -1L);
                    }
                }
                long j4 = rangedUri.length;
                if (j4 != -1) {
                    long j5 = rangedUri.start;
                    if (j5 + j4 == this.start) {
                        long j6 = this.length;
                        return new RangedUri(resolveUriString, j5, j6 != -1 ? j4 + j6 : -1L);
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
            return this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? UriUtil.resolveToUri(str, this.referenceUri) : (Uri) invokeL.objValue;
    }

    public String resolveUriString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? UriUtil.resolve(str, this.referenceUri) : (String) invokeL.objValue;
    }
}
