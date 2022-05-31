package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class d28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<jn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jn jnVar = list.get(i);
            if (jnVar instanceof hz4) {
                hz4 hz4Var = (hz4) jnVar;
                if (!hz4Var.e()) {
                    jSONArray.put(hz4Var.a());
                }
            }
        }
        jSONArray.put(str);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
        httpMessage.addParam("pic_list", jSONArray.toString());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void b(hz4 hz4Var, List<jn> list) {
        hz4 hz4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, hz4Var, list) == null) || hz4Var == null || ListUtils.isEmpty(list) || StringUtils.isNull(hz4Var.a())) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jn jnVar = list.get(i);
            if ((jnVar instanceof hz4) && (hz4Var2 = (hz4) jnVar) != hz4Var && !hz4Var2.e()) {
                jSONArray.put(hz4Var2.a());
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
        httpMessage.addParam("pic_list", jSONArray.toString());
        if (jSONArray.length() <= 0) {
            httpMessage.addParam("truncat", 1);
        } else {
            httpMessage.addParam("truncat", 0);
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static String c(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, str)) == null) {
            if (tbPageContext == null || StringUtils.isNull(str)) {
                return null;
            }
            if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
                return "http://tb.himg.baidu.com/sys/portraith/item/" + str;
            }
            return "http://tb.himg.baidu.com/sys/portraitl/item/" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static void d(hz4 hz4Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, hz4Var, bdUniqueId) == null) || hz4Var == null || StringUtils.isNull(hz4Var.a()) || !ListUtils.isEmpty(MessageManager.getInstance().findMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT, bdUniqueId))) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        httpMessage.addParam("pic_url", hz4Var.a());
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
