package com.facebook.imagepipeline.image;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class EncodedImageOrigin {
    public static final /* synthetic */ EncodedImageOrigin[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EncodedImageOrigin DISK;
    public static final EncodedImageOrigin ENCODED_MEM_CACHE;
    public static final EncodedImageOrigin NETWORK;
    public static final EncodedImageOrigin NOT_SET;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mOrigin;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-126010989, "Lcom/facebook/imagepipeline/image/EncodedImageOrigin;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-126010989, "Lcom/facebook/imagepipeline/image/EncodedImageOrigin;");
                return;
            }
        }
        NOT_SET = new EncodedImageOrigin("NOT_SET", 0, "not_set");
        NETWORK = new EncodedImageOrigin("NETWORK", 1, "network");
        DISK = new EncodedImageOrigin("DISK", 2, "disk");
        EncodedImageOrigin encodedImageOrigin = new EncodedImageOrigin("ENCODED_MEM_CACHE", 3, "encoded_mem_cache");
        ENCODED_MEM_CACHE = encodedImageOrigin;
        $VALUES = new EncodedImageOrigin[]{NOT_SET, NETWORK, DISK, encodedImageOrigin};
    }

    public EncodedImageOrigin(String str, int i, String str2) {
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
        this.mOrigin = str2;
    }

    public static EncodedImageOrigin valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EncodedImageOrigin) Enum.valueOf(EncodedImageOrigin.class, str) : (EncodedImageOrigin) invokeL.objValue;
    }

    public static EncodedImageOrigin[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EncodedImageOrigin[]) $VALUES.clone() : (EncodedImageOrigin[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOrigin : (String) invokeV.objValue;
    }
}
