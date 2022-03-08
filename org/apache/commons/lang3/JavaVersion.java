package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.math.NumberUtils;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class JavaVersion {
    public static final /* synthetic */ JavaVersion[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final JavaVersion JAVA_0_9;
    public static final JavaVersion JAVA_1_1;
    public static final JavaVersion JAVA_1_2;
    public static final JavaVersion JAVA_1_3;
    public static final JavaVersion JAVA_1_4;
    public static final JavaVersion JAVA_1_5;
    public static final JavaVersion JAVA_1_6;
    public static final JavaVersion JAVA_1_7;
    public static final JavaVersion JAVA_1_8;
    public static final JavaVersion JAVA_1_9;
    public static final JavaVersion JAVA_9;
    public static final JavaVersion JAVA_RECENT;
    public transient /* synthetic */ FieldHolder $fh;
    public final String name;
    public final float value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1510116928, "Lorg/apache/commons/lang3/JavaVersion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1510116928, "Lorg/apache/commons/lang3/JavaVersion;");
                return;
            }
        }
        JAVA_0_9 = new JavaVersion("JAVA_0_9", 0, 1.5f, "0.9");
        JAVA_1_1 = new JavaVersion("JAVA_1_1", 1, 1.1f, "1.1");
        JAVA_1_2 = new JavaVersion("JAVA_1_2", 2, 1.2f, "1.2");
        JAVA_1_3 = new JavaVersion("JAVA_1_3", 3, 1.3f, "1.3");
        JAVA_1_4 = new JavaVersion("JAVA_1_4", 4, 1.4f, "1.4");
        JAVA_1_5 = new JavaVersion("JAVA_1_5", 5, 1.5f, "1.5");
        JAVA_1_6 = new JavaVersion("JAVA_1_6", 6, 1.6f, "1.6");
        JAVA_1_7 = new JavaVersion("JAVA_1_7", 7, 1.7f, "1.7");
        JAVA_1_8 = new JavaVersion("JAVA_1_8", 8, 1.8f, "1.8");
        JAVA_1_9 = new JavaVersion("JAVA_1_9", 9, 9.0f, "9");
        JAVA_9 = new JavaVersion("JAVA_9", 10, 9.0f, "9");
        JavaVersion javaVersion = new JavaVersion("JAVA_RECENT", 11, maxVersion(), Float.toString(maxVersion()));
        JAVA_RECENT = javaVersion;
        $VALUES = new JavaVersion[]{JAVA_0_9, JAVA_1_1, JAVA_1_2, JAVA_1_3, JAVA_1_4, JAVA_1_5, JAVA_1_6, JAVA_1_7, JAVA_1_8, JAVA_1_9, JAVA_9, javaVersion};
    }

    public JavaVersion(String str, int i2, float f2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Float.valueOf(f2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = f2;
        this.name = str2;
    }

    public static JavaVersion get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if ("0.9".equals(str)) {
                return JAVA_0_9;
            }
            if ("1.1".equals(str)) {
                return JAVA_1_1;
            }
            if ("1.2".equals(str)) {
                return JAVA_1_2;
            }
            if ("1.3".equals(str)) {
                return JAVA_1_3;
            }
            if ("1.4".equals(str)) {
                return JAVA_1_4;
            }
            if ("1.5".equals(str)) {
                return JAVA_1_5;
            }
            if ("1.6".equals(str)) {
                return JAVA_1_6;
            }
            if ("1.7".equals(str)) {
                return JAVA_1_7;
            }
            if ("1.8".equals(str)) {
                return JAVA_1_8;
            }
            if ("9".equals(str)) {
                return JAVA_9;
            }
            if (str != null && toFloatVersion(str) - 1.0d < 1.0d) {
                int max = Math.max(str.indexOf(46), str.indexOf(44));
                if (Float.parseFloat(str.substring(max + 1, Math.max(str.length(), str.indexOf(44, max)))) > 0.9f) {
                    return JAVA_RECENT;
                }
            }
            return null;
        }
        return (JavaVersion) invokeL.objValue;
    }

    public static JavaVersion getJavaVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? get(str) : (JavaVersion) invokeL.objValue;
    }

    public static float maxVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            float floatVersion = toFloatVersion(System.getProperty("java.specification.version", "99.0"));
            if (floatVersion > 0.0f) {
                return floatVersion;
            }
            return 99.0f;
        }
        return invokeV.floatValue;
    }

    public static float toFloatVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str.contains(".")) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split.length >= 2) {
                    return NumberUtils.toFloat(split[0] + '.' + split[1], -1.0f);
                }
                return -1.0f;
            }
            return NumberUtils.toFloat(str, -1.0f);
        }
        return invokeL.floatValue;
    }

    public static JavaVersion valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? (JavaVersion) Enum.valueOf(JavaVersion.class, str) : (JavaVersion) invokeL.objValue;
    }

    public static JavaVersion[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (JavaVersion[]) $VALUES.clone() : (JavaVersion[]) invokeV.objValue;
    }

    public boolean atLeast(JavaVersion javaVersion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, javaVersion)) == null) ? this.value >= javaVersion.value : invokeL.booleanValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }
}
