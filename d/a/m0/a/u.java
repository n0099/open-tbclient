package d.a.m0.a;

import android.os.Build;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.BdToken.NewUserGetMoneyResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.m0.z0.n0;
/* loaded from: classes3.dex */
public class u {
    public u() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NEW_USER_GET_MONEY, TbConfig.NEW_USER_GET_MONEY_URL);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(NewUserGetMoneyResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void a() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEW_USER_GET_MONEY);
        httpMessage.addParam("brand", Build.BRAND);
        httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addParam("client_version", TbConfig.getVersion());
        httpMessage.addParam("client_type", "Android");
        httpMessage.addParam("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
        httpMessage.addParam("ua", n0.e());
        httpMessage.addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
