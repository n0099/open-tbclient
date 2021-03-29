package d.b.h0.a.a0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.backUser.BackUserHTTPResMsg;
import com.baidu.tbadk.BdToken.backUser.BackUserReqMsg;
import com.baidu.tbadk.BdToken.backUser.BackUserSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f49500a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.c.g.a f49501b = new a(CmdConfigHttp.CMD_BACK_USER, 309689);

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || b.this.b() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            d.b.h0.a.a0.a aVar = null;
            if (responsedMessage instanceof BackUserHTTPResMsg) {
                aVar = ((BackUserHTTPResMsg) responsedMessage).getData();
            } else if (responsedMessage instanceof BackUserSocketResMsg) {
                aVar = ((BackUserSocketResMsg) responsedMessage).getData();
            }
            if (aVar == null || !aVar.f49499a) {
                return;
            }
            d.b.h0.r.d0.b.i().v(d.b.h0.r.d0.b.m("pref_key_last_request_mission"), System.currentTimeMillis());
            d.b.h0.r.c0.a.e().i();
        }
    }

    public b(BdUniqueId bdUniqueId) {
        this.f49500a = bdUniqueId;
        c();
        this.f49501b.setTag(this.f49500a);
        MessageManager.getInstance().registerListener(this.f49501b);
    }

    public final boolean a() {
        return !UtilHelper.isSameDay(d.b.h0.r.d0.b.i().k(d.b.h0.r.d0.b.m("pref_key_last_request_mission"), 0L), System.currentTimeMillis());
    }

    public BdUniqueId b() {
        return this.f49500a;
    }

    public final void c() {
        d.b.i0.c3.d0.a.h(309689, BackUserSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BACK_USER, d.b.i0.c3.d0.a.a(TbConfig.URL_BACK_USER, 309689));
        tbHttpMessageTask.setResponsedClass(BackUserHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void d() {
        if (a()) {
            BackUserReqMsg backUserReqMsg = new BackUserReqMsg();
            backUserReqMsg.setTag(this.f49500a);
            MessageManager.getInstance().sendMessage(backUserReqMsg);
        }
    }
}
