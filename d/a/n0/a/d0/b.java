package d.a.n0.a.d0;

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
    public BdUniqueId f52439a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.c.g.a f52440b = new a(CmdConfigHttp.CMD_BACK_USER, 309689);

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
            d.a.n0.a.d0.a aVar = null;
            if (responsedMessage instanceof BackUserHTTPResMsg) {
                aVar = ((BackUserHTTPResMsg) responsedMessage).getData();
            } else if (responsedMessage instanceof BackUserSocketResMsg) {
                aVar = ((BackUserSocketResMsg) responsedMessage).getData();
            }
            if (aVar == null || !aVar.f52438a) {
                return;
            }
            d.a.n0.r.d0.b.j().w(d.a.n0.r.d0.b.n("pref_key_last_request_mission"), System.currentTimeMillis());
            d.a.n0.r.c0.a.e().i();
        }
    }

    public b(BdUniqueId bdUniqueId) {
        this.f52439a = bdUniqueId;
        c();
        this.f52440b.setTag(this.f52439a);
        MessageManager.getInstance().registerListener(this.f52440b);
    }

    public final boolean a() {
        return !UtilHelper.isSameDay(d.a.n0.r.d0.b.j().l(d.a.n0.r.d0.b.n("pref_key_last_request_mission"), 0L), System.currentTimeMillis());
    }

    public BdUniqueId b() {
        return this.f52439a;
    }

    public final void c() {
        d.a.o0.e3.d0.a.h(309689, BackUserSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BACK_USER, d.a.o0.e3.d0.a.a(TbConfig.URL_BACK_USER, 309689));
        tbHttpMessageTask.setResponsedClass(BackUserHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void d() {
        if (a()) {
            BackUserReqMsg backUserReqMsg = new BackUserReqMsg();
            backUserReqMsg.setTag(this.f52439a);
            MessageManager.getInstance().sendMessage(backUserReqMsg);
        }
    }
}
