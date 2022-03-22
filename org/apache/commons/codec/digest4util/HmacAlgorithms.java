package org.apache.commons.codec.digest4util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class HmacAlgorithms {
    public static final /* synthetic */ HmacAlgorithms[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HmacAlgorithms HMAC_MD5;
    public static final HmacAlgorithms HMAC_SHA_1;
    public static final HmacAlgorithms HMAC_SHA_224;
    public static final HmacAlgorithms HMAC_SHA_256;
    public static final HmacAlgorithms HMAC_SHA_384;
    public static final HmacAlgorithms HMAC_SHA_512;
    public transient /* synthetic */ FieldHolder $fh;
    public final String name;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(679229161, "Lorg/apache/commons/codec/digest4util/HmacAlgorithms;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(679229161, "Lorg/apache/commons/codec/digest4util/HmacAlgorithms;");
                return;
            }
        }
        HMAC_MD5 = new HmacAlgorithms("HMAC_MD5", 0, "HmacMD5");
        HMAC_SHA_1 = new HmacAlgorithms("HMAC_SHA_1", 1, "HmacSHA1");
        HMAC_SHA_224 = new HmacAlgorithms("HMAC_SHA_224", 2, "HmacSHA224");
        HMAC_SHA_256 = new HmacAlgorithms("HMAC_SHA_256", 3, "HmacSHA256");
        HMAC_SHA_384 = new HmacAlgorithms("HMAC_SHA_384", 4, "HmacSHA384");
        HmacAlgorithms hmacAlgorithms = new HmacAlgorithms("HMAC_SHA_512", 5, "HmacSHA512");
        HMAC_SHA_512 = hmacAlgorithms;
        $VALUES = new HmacAlgorithms[]{HMAC_MD5, HMAC_SHA_1, HMAC_SHA_224, HMAC_SHA_256, HMAC_SHA_384, hmacAlgorithms};
    }

    public HmacAlgorithms(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = str2;
    }

    public static HmacAlgorithms valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HmacAlgorithms) Enum.valueOf(HmacAlgorithms.class, str) : (HmacAlgorithms) invokeL.objValue;
    }

    public static HmacAlgorithms[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HmacAlgorithms[]) $VALUES.clone() : (HmacAlgorithms[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }
}
