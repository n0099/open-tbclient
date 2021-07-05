package com.kuaishou.aegon.httpdns;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class ResolvedIP implements Comparable<ResolvedIP> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mExpiredDate;
    public final String mHost;
    public final String mIP;
    public String mResolver;
    public long mRtt;
    public final long mTtl;

    @Keep
    public ResolvedIP(String str, String str2, String str3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHost = str;
        this.mIP = str2;
        this.mResolver = str3;
        this.mRtt = j2;
        this.mExpiredDate = System.currentTimeMillis() + j;
        this.mTtl = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull ResolvedIP resolvedIP) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resolvedIP)) == null) ? (int) (this.mRtt - resolvedIP.mRtt) : invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof ResolvedIP) && this.mIP.equals(((ResolvedIP) obj).mIP) : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIP.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "{\n\thost = " + this.mHost + "\n\tip = " + this.mIP + "\n\ttype = " + this.mResolver + "\n\trtt = " + this.mRtt + "\n\tttl = " + this.mTtl + "\n\texpired = " + this.mExpiredDate + "\n}\n";
        }
        return (String) invokeV.objValue;
    }
}
