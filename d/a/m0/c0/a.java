package d.a.m0.c0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.lcs.LCSStatisticsResponseMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.m0.r.d0.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f52891a = false;

    static {
        boolean z = b.j().k("key_lcs_log_switch", 0) == 1;
        f52891a = z;
        if (z) {
            a();
        }
    }

    public static void a() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_LCS_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.LCS_STATISTICS_URL);
        tbHttpMessageTask.setResponsedClass(LCSStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void b(int i2, int i3, int i4, int i5, int i6) {
        c(i2, i3, i4, i5, i6, 0);
    }

    public static void c(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (f52891a) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_LCS_STATISTICS);
            httpMessage.addParam("cmd", i2);
            httpMessage.addParam("lcs_status", i3);
            httpMessage.addParam("online_status", i4);
            httpMessage.addParam("status_change_name", i5);
            httpMessage.addParam("status_change_trigger", i6);
            httpMessage.addParam("lcs_vailable", i7);
            MessageManager.getInstance().sendMessageFromBackground(httpMessage);
        }
    }
}
