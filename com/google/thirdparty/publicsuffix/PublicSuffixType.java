package com.google.thirdparty.publicsuffix;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class PublicSuffixType {
    public static final /* synthetic */ PublicSuffixType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PublicSuffixType PRIVATE;
    public static final PublicSuffixType REGISTRY;
    public transient /* synthetic */ FieldHolder $fh;
    public final char innerNodeCode;
    public final char leafNodeCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-820931514, "Lcom/google/thirdparty/publicsuffix/PublicSuffixType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-820931514, "Lcom/google/thirdparty/publicsuffix/PublicSuffixType;");
                return;
            }
        }
        PRIVATE = new PublicSuffixType("PRIVATE", 0, ':', ',');
        PublicSuffixType publicSuffixType = new PublicSuffixType("REGISTRY", 1, '!', '?');
        REGISTRY = publicSuffixType;
        $VALUES = new PublicSuffixType[]{PRIVATE, publicSuffixType};
    }

    public PublicSuffixType(String str, int i2, char c2, char c3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Character.valueOf(c2), Character.valueOf(c3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.innerNodeCode = c2;
        this.leafNodeCode = c3;
    }

    public static PublicSuffixType fromCode(char c2) {
        InterceptResult invokeCommon;
        PublicSuffixType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) {
            for (PublicSuffixType publicSuffixType : values()) {
                if (publicSuffixType.getInnerNodeCode() == c2 || publicSuffixType.getLeafNodeCode() == c2) {
                    return publicSuffixType;
                }
            }
            throw new IllegalArgumentException("No enum corresponding to given code: " + c2);
        }
        return (PublicSuffixType) invokeCommon.objValue;
    }

    public static PublicSuffixType fromIsPrivate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) ? z ? PRIVATE : REGISTRY : (PublicSuffixType) invokeZ.objValue;
    }

    public static PublicSuffixType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (PublicSuffixType) Enum.valueOf(PublicSuffixType.class, str) : (PublicSuffixType) invokeL.objValue;
    }

    public static PublicSuffixType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (PublicSuffixType[]) $VALUES.clone() : (PublicSuffixType[]) invokeV.objValue;
    }

    public char getInnerNodeCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.innerNodeCode : invokeV.charValue;
    }

    public char getLeafNodeCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.leafNodeCode : invokeV.charValue;
    }
}
