package d.a.k0.j2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.play.PlayStatisticsResponseMessage;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
/* loaded from: classes5.dex */
public class h {
    static {
        c();
        b();
    }

    public static void a(HttpMessage httpMessage, o oVar) {
        if (httpMessage == null || oVar == null) {
            return;
        }
        httpMessage.addParam("tid", oVar.f56720c);
        httpMessage.addParam("fid", oVar.f56721d);
        httpMessage.addParam(TiebaStatic.Params.OBJ_TO, oVar.f56724g);
        httpMessage.addParam("obj_id", oVar.k);
        httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM3, oVar.f56725h);
        httpMessage.addParam("obj_source", oVar.f56723f);
        httpMessage.addParam("obj_locate", oVar.f56718a);
        httpMessage.addParam("obj_param1", oVar.f56726i);
        if (!StringUtils.isNull(oVar.n)) {
            httpMessage.addParam("topic_type", oVar.n);
        }
        if (StringUtils.isNull(oVar.p)) {
            return;
        }
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, oVar.p);
    }

    public static void b() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void c() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void d(long j, String str, o oVar, String str2, long j2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
        httpMessage.addParam(TiebaStatic.Params.OBJ_DURATION, j);
        httpMessage.addParam("obj_type", str);
        httpMessage.addParam("playduration", j2);
        if (oVar != null) {
            httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, oVar.m);
        }
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
        a(httpMessage, oVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void e(String str, String str2, String str3, o oVar, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, str);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
        httpMessage.addParam("obj_type", str3);
        if (TbSingleton.getInstance().getPcdnConfigData() != null && TbSingleton.getInstance().getPcdnConfigData().c()) {
            httpMessage.addParam("pcdn_state", i2);
        }
        a(httpMessage, oVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
