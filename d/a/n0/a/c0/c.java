package d.a.n0.a.c0;

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
import d.a.n0.a.p;
import d.a.n0.a.s;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.c0.a<b> f52410a;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f52412c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52411b = false;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f52413d = new a(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f52411b = false;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || c.this.d() != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                if (c.this.f52410a != null) {
                    c.this.f52410a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
                d.a.n0.r.d0.b.j().w("pref_key_active_config_info", System.currentTimeMillis());
            }
            if (bVar != null && bVar.f52409g != null) {
                if (c.this.f52410a != null) {
                    c.this.f52410a.a(bVar);
                }
                if (bVar.f52409g.is_first_up != 1) {
                    s.g().q(bVar.f52409g);
                }
            }
            if (bVar == null || !c.this.c()) {
                return;
            }
            d.a.n0.r.d0.b.j().w("pref_key_last_register_mission", System.currentTimeMillis());
            p.b().i(bVar);
            d.a.n0.r.c0.a.e().j(bVar);
            if (c.this.f52410a != null) {
                c.this.f52410a.onSuccess(bVar);
            }
        }
    }

    public c(BdUniqueId bdUniqueId) {
        this.f52412c = bdUniqueId;
        e();
        this.f52413d.setTag(d());
        MessageManager.getInstance().registerListener(this.f52413d);
    }

    public boolean c() {
        return !UtilHelper.isSameDay(d.a.n0.r.d0.b.j().l("pref_key_last_register_mission", 0L), System.currentTimeMillis());
    }

    public BdUniqueId d() {
        return this.f52412c;
    }

    public final void e() {
        d.a.o0.e3.d0.a.h(309637, ActiveConfigSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, d.a.o0.e3.d0.a.a(TbConfig.URL_ACTIVE_CONFIG, 309637));
        tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void f(boolean z, boolean z2, int i2) {
        if (this.f52411b) {
            return;
        }
        if (!z) {
            this.f52411b = true;
        }
        d.a.n0.r.d0.b.j().w("pref_key_last_active_config", System.currentTimeMillis());
        ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
        activeConfigReqMsg.setFirstUp(z);
        activeConfigReqMsg.setSchemaUp(z2);
        activeConfigReqMsg.launtchType = i2;
        activeConfigReqMsg.setTag(d());
        MessageManager.getInstance().sendMessage(activeConfigReqMsg);
    }

    public void g(d.a.n0.a.c0.a<b> aVar) {
        this.f52410a = aVar;
    }
}
