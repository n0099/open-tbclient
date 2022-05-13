package com.repackage;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class in {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.contains(".so")) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                StringBuilder sb = new StringBuilder();
                sb.append(ai.a() ? "so_64_cache" : "so_cache");
                sb.append(File.separator);
                sb.append(split[0]);
                str2 = sb.toString();
            } else {
                str2 = str.contains(".mp3") ? "mp3_cache" : "res_cache";
            }
            return BdBaseApplication.getInst().getFilesDir() + File.separator + str2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            return a(str) + File.separator + str;
        }
        return (String) invokeL.objValue;
    }
}
