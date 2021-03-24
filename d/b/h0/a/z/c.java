package d.b.h0.a.z;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigHTTPResMsg;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigReqMsg;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.b.h0.a.n;
import d.b.h0.a.q;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.z.a<b> f49667a;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f49669c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49668b = false;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b.c.g.a f49670d = new a(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f49668b = false;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || c.this.d() != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                if (c.this.f49667a != null) {
                    c.this.f49667a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            b bVar = null;
            if (responsedMessage instanceof ActiveConfigSocketResMsg) {
                bVar = ((ActiveConfigSocketResMsg) responsedMessage).getData();
            } else if (responsedMessage instanceof ActiveConfigHTTPResMsg) {
                bVar = ((ActiveConfigHTTPResMsg) responsedMessage).getData();
            }
            if ((responsedMessage.getOrginalMessage().getExtra() instanceof ActiveConfigReqMsg) && ((ActiveConfigReqMsg) responsedMessage.getOrginalMessage().getExtra()).launtchType == 0) {
                d.b.h0.r.d0.b.i().v("pref_key_active_config_info", System.currentTimeMillis());
            }
            if (bVar != null && bVar.f49666g != null) {
                if (c.this.f49667a != null) {
                    c.this.f49667a.a(bVar);
                }
                if (bVar.f49666g.is_first_up != 1) {
                    q.g().q(bVar.f49666g);
                }
            }
            if (bVar == null || !c.this.c()) {
                return;
            }
            d.b.h0.r.d0.b.i().v("pref_key_last_register_mission", System.currentTimeMillis());
            n.b().i(bVar);
            d.b.h0.r.c0.a.e().j(bVar);
            if (c.this.f49667a != null) {
                c.this.f49667a.onSuccess(bVar);
            }
        }
    }

    public c(BdUniqueId bdUniqueId) {
        this.f49669c = bdUniqueId;
        e();
        this.f49670d.setTag(d());
        MessageManager.getInstance().registerListener(this.f49670d);
    }

    public boolean c() {
        return !UtilHelper.isSameDay(d.b.h0.r.d0.b.i().k("pref_key_last_register_mission", 0L), System.currentTimeMillis());
    }

    public BdUniqueId d() {
        return this.f49669c;
    }

    public final void e() {
        d.b.i0.c3.d0.a.h(309637, ActiveConfigSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, d.b.i0.c3.d0.a.a(TbConfig.URL_ACTIVE_CONFIG, 309637));
        tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void f(boolean z, boolean z2, int i) {
        if (this.f49668b) {
            return;
        }
        if (!z) {
            this.f49668b = true;
        }
        d.b.h0.r.d0.b.i().v("pref_key_last_active_config", System.currentTimeMillis());
        ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
        activeConfigReqMsg.setFirstUp(z);
        activeConfigReqMsg.setSchemaUp(z2);
        activeConfigReqMsg.launtchType = i;
        activeConfigReqMsg.setTag(d());
        MessageManager.getInstance().sendMessage(activeConfigReqMsg);
    }

    public void g(d.b.h0.a.z.a<b> aVar) {
        this.f49667a = aVar;
    }
}
