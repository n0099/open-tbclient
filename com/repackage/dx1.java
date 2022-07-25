package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes5.dex */
public class dx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final long b;
    public final String c;
    public final Map<String, String> d;

    public dx1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashMap();
        this.b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.c = Long.toHexString(a(this.a + "#" + this.b));
        this.d.put("timestamp", Long.toString(this.a));
        this.d.put("delta", Long.toString(this.b));
        this.d.put("rasign", this.c);
    }

    public static dx1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new dx1(0L) : (dx1) invokeV.objValue;
    }

    public final long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            CRC32 crc32 = new CRC32();
            crc32.reset();
            crc32.update(str.getBytes());
            return crc32.getValue();
        }
        return invokeL.longValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return Long.toHexString(a(j + "#smartapp_formid"));
        }
        return (String) invokeJ.objValue;
    }

    public String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            return Long.toHexString(a(j + "#payid"));
        }
        return (String) invokeJ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return super.toString() + " serverTime:" + this.a + " delta:" + this.b + " rasign:" + this.c;
        }
        return (String) invokeV.objValue;
    }
}
