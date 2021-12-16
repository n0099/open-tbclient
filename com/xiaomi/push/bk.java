package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
/* loaded from: classes4.dex */
public class bk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return String.valueOf(bj.a(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", e2);
                throw new IllegalStateException("failed to SHA1");
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2, Map<String, String> map, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, map, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                throw new InvalidParameterException("security is not nullable");
            }
            ArrayList<String> arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            boolean z = true;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str3);
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                if (!z) {
                    sb.append(Typography.amp);
                }
                sb.append(str4);
                z = false;
            }
            return a(sb.toString());
        }
        return (String) invokeLLLL.objValue;
    }
}
