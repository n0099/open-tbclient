package d.a.j0.i2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.i0.t.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class j {
    public static void a(String str, List<n> list) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = list.get(i2);
            if (nVar instanceof o) {
                o oVar = (o) nVar;
                if (!oVar.f()) {
                    jSONArray.put(oVar.c());
                }
            }
        }
        jSONArray.put(str);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
        httpMessage.addParam("pic_list", jSONArray.toString());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void b(o oVar, List<n> list) {
        o oVar2;
        if (oVar == null || ListUtils.isEmpty(list) || StringUtils.isNull(oVar.c())) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = list.get(i2);
            if ((nVar instanceof o) && (oVar2 = (o) nVar) != oVar && !oVar2.f()) {
                jSONArray.put(oVar2.c());
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
        if (tbPageContext == null || StringUtils.isNull(str)) {
            return null;
        }
        if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
            return "http://tb.himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://tb.himg.baidu.com/sys/portraitl/item/" + str;
    }

    public static void d(o oVar, BdUniqueId bdUniqueId) {
        if (oVar == null || StringUtils.isNull(oVar.c()) || !ListUtils.isEmpty(MessageManager.getInstance().findMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT, bdUniqueId))) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        httpMessage.addParam("pic_url", oVar.c());
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
