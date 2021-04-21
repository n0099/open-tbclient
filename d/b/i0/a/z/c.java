package d.b.i0.a.z;

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
import d.b.i0.a.n;
import d.b.i0.a.q;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.a.z.a<b> f50396a;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f50398c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50397b = false;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.c.g.a f50399d = new a(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f50397b = false;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || c.this.d() != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                if (c.this.f50396a != null) {
                    c.this.f50396a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
                d.b.i0.r.d0.b.j().w("pref_key_active_config_info", System.currentTimeMillis());
            }
            if (bVar != null && bVar.f50395g != null) {
                if (c.this.f50396a != null) {
                    c.this.f50396a.a(bVar);
                }
                if (bVar.f50395g.is_first_up != 1) {
                    q.g().q(bVar.f50395g);
                }
            }
            if (bVar == null || !c.this.c()) {
                return;
            }
            d.b.i0.r.d0.b.j().w("pref_key_last_register_mission", System.currentTimeMillis());
            n.b().i(bVar);
            d.b.i0.r.c0.a.e().j(bVar);
            if (c.this.f50396a != null) {
                c.this.f50396a.onSuccess(bVar);
            }
        }
    }

    public c(BdUniqueId bdUniqueId) {
        this.f50398c = bdUniqueId;
        e();
        this.f50399d.setTag(d());
        MessageManager.getInstance().registerListener(this.f50399d);
    }

    public boolean c() {
        return !UtilHelper.isSameDay(d.b.i0.r.d0.b.j().l("pref_key_last_register_mission", 0L), System.currentTimeMillis());
    }

    public BdUniqueId d() {
        return this.f50398c;
    }

    public final void e() {
        d.b.j0.d3.d0.a.h(309637, ActiveConfigSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, d.b.j0.d3.d0.a.a(TbConfig.URL_ACTIVE_CONFIG, 309637));
        tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void f(boolean z, boolean z2, int i) {
        if (this.f50397b) {
            return;
        }
        if (!z) {
            this.f50397b = true;
        }
        d.b.i0.r.d0.b.j().w("pref_key_last_active_config", System.currentTimeMillis());
        ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
        activeConfigReqMsg.setFirstUp(z);
        activeConfigReqMsg.setSchemaUp(z2);
        activeConfigReqMsg.launtchType = i;
        activeConfigReqMsg.setTag(d());
        MessageManager.getInstance().sendMessage(activeConfigReqMsg);
    }

    public void g(d.b.i0.a.z.a<b> aVar) {
        this.f50396a = aVar;
    }
}
