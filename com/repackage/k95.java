package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, str, str2, i)) == null) {
            JSONObject params = SchemeActionHelper.getParams(Uri.parse(str), "data");
            String str3 = null;
            try {
                params.put(str2, i);
                int indexOf = str.indexOf("data");
                if (indexOf > 0) {
                    str3 = str.substring(0, indexOf) + "data=" + params;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return TextUtils.isEmpty(str3) ? str : str3;
        }
        return (String) invokeLLI.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? TbadkCoreApplication.getCurrentAccount() : (String) invokeV.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        ue<String> i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if ((TbadkCoreApplication.isLogin() || !StringUtils.isNull(str)) && TextUtils.equals(b(), str2) && (i = tr4.i("tb.novel_thread_read_record", b(), str)) != null && !StringUtils.isNull(i.get(str))) {
                return i.get(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921697, Boolean.TRUE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
        }
    }

    public static void e(String str, ReadRecordsData readRecordsData) {
        ue<String> i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, readRecordsData) == null) {
            if ((!TbadkCoreApplication.isLogin() && StringUtils.isNull(str)) || (i = tr4.i("tb.novel_thread_read_record", b(), str)) == null || readRecordsData == null) {
                return;
            }
            i.g(str, OrmObject.jsonStrWithObject(readRecordsData));
        }
    }

    public static String f(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, str, str2, str3, str4)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return str;
            }
            String queryParameter = parse.getQueryParameter(str2);
            if (pi.isEmpty(queryParameter)) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(queryParameter);
                jSONObject.put(str3, str4);
                int indexOf = str.indexOf("&data");
                if (indexOf > 0) {
                    String substring = str.substring(0, indexOf);
                    return substring + "&data=" + jSONObject.toString();
                }
                return null;
            } catch (Exception e) {
                rb9.g(e);
                return str;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return CommonUrlParamManager.getInstance().processUrl(str) + "&ctv=2&cen=ua_ut_uid";
        }
        return (String) invokeL.objValue;
    }
}
