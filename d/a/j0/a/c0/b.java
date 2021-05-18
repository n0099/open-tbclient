package d.a.j0.a.c0;

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
    public BdUniqueId f48634a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.c.g.a f48635b = new a(CmdConfigHttp.CMD_BACK_USER, 309689);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || b.this.b() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            d.a.j0.a.c0.a aVar = null;
            if (responsedMessage instanceof BackUserHTTPResMsg) {
                aVar = ((BackUserHTTPResMsg) responsedMessage).getData();
            } else if (responsedMessage instanceof BackUserSocketResMsg) {
                aVar = ((BackUserSocketResMsg) responsedMessage).getData();
            }
            if (aVar == null || !aVar.f48633a) {
                return;
            }
            d.a.j0.r.d0.b.j().w(d.a.j0.r.d0.b.n("pref_key_last_request_mission"), System.currentTimeMillis());
            d.a.j0.r.c0.a.e().i();
        }
    }

    public b(BdUniqueId bdUniqueId) {
        this.f48634a = bdUniqueId;
        c();
        this.f48635b.setTag(this.f48634a);
        MessageManager.getInstance().registerListener(this.f48635b);
    }

    public final boolean a() {
        return !UtilHelper.isSameDay(d.a.j0.r.d0.b.j().l(d.a.j0.r.d0.b.n("pref_key_last_request_mission"), 0L), System.currentTimeMillis());
    }

    public BdUniqueId b() {
        return this.f48634a;
    }

    public final void c() {
        d.a.k0.d3.d0.a.h(309689, BackUserSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BACK_USER, d.a.k0.d3.d0.a.a(TbConfig.URL_BACK_USER, 309689));
        tbHttpMessageTask.setResponsedClass(BackUserHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void d() {
        if (a()) {
            BackUserReqMsg backUserReqMsg = new BackUserReqMsg();
            backUserReqMsg.setTag(this.f48634a);
            MessageManager.getInstance().sendMessage(backUserReqMsg);
        }
    }
}
