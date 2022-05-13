package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? TbadkCoreApplication.getCurrentAccount() : (String) invokeV.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        qe<String> i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if ((TbadkCoreApplication.isLogin() || !StringUtils.isNull(str)) && TextUtils.equals(a(), str2) && (i = mr4.i("tb.novel_thread_read_record", a(), str)) != null && !StringUtils.isNull(i.get(str))) {
                return i.get(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void c(String str, ReadRecordsData readRecordsData) {
        qe<String> i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, readRecordsData) == null) {
            if ((!TbadkCoreApplication.isLogin() && StringUtils.isNull(str)) || (i = mr4.i("tb.novel_thread_read_record", a(), str)) == null || readRecordsData == null) {
                return;
            }
            i.g(str, OrmObject.jsonStrWithObject(readRecordsData));
        }
    }

    public static String d(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return str;
            }
            String queryParameter = parse.getQueryParameter(str2);
            if (li.isEmpty(queryParameter)) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(queryParameter);
                jSONObject.put("cid", str3);
                int indexOf = str.indexOf("&data");
                if (indexOf > 0) {
                    String substring = str.substring(0, indexOf);
                    return substring + "&data=" + jSONObject.toString();
                }
                return null;
            } catch (Exception e) {
                va9.g(e);
                return str;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
