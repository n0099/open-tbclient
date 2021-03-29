package d.b.i0.z0.g.k;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RealTimeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RealTimeRequest;
import com.baidu.tieba.homepage.personalize.data.RealTimeSocketResponse;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f63214a = null;

    public void a(BdUniqueId bdUniqueId) {
        this.f63214a = bdUniqueId;
        b();
        c();
    }

    public final void b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REPORT_HOME_PIC_CLICK, d.b.i0.c3.d0.a.a(TbConfig.HOME_REALTIME_ADDRESS, 309277));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RealTimeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void c() {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309277);
        bVar.setResponsedClass(RealTimeSocketResponse.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void d(NetMessage netMessage) {
        if (netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.f63214a);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void e(long j, String str, String str2, int i, String str3, int i2, String str4, BaijiahaoData baijiahaoData) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3)) {
            return;
        }
        RealTimeRequest realTimeRequest = new RealTimeRequest();
        realTimeRequest.setTid(j);
        realTimeRequest.setWeight(str);
        realTimeRequest.setSource(str2);
        realTimeRequest.setLocation(i);
        realTimeRequest.setAbtest_tag(str3);
        realTimeRequest.setType(i2);
        realTimeRequest.setPage(str4);
        if (baijiahaoData != null && i2 != d.b.b.e.m.b.d("2", 0)) {
            realTimeRequest.setOriUgcNid(baijiahaoData.oriUgcNid);
            realTimeRequest.setOriUgcTid(baijiahaoData.oriUgcTid);
            realTimeRequest.setOriUgcType(Integer.toString(baijiahaoData.oriUgcType));
            realTimeRequest.setOriUgcVid(baijiahaoData.oriUgcVid);
        }
        d(realTimeRequest);
    }
}
