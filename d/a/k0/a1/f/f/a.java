package d.a.k0.a1.f.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.k0.a1.f.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.a.k0.a1.f.a {

    /* renamed from: a  reason: collision with root package name */
    public String f51453a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f51455c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51456d;

    /* renamed from: e  reason: collision with root package name */
    public b f51457e;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f51454b = null;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f51458f = new HashMap<>();

    /* renamed from: d.a.k0.a1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1183a extends d.a.c.c.g.a {
        public C1183a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f51456d = false;
            if (a.this.f51457e == null) {
                return;
            }
            if (!(responsedMessage instanceof d.a.k0.a1.f.e.a)) {
                a.this.f51457e.c(-1);
            } else if (responsedMessage.getOrginalMessage() == null || a.this.f51454b != responsedMessage.getOrginalMessage().getTag()) {
                a.this.f51457e.c(-1);
            } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a.this.f51457e.c(responsedMessage.getError());
            } else {
                d.a.k0.a1.f.e.a aVar = (d.a.k0.a1.f.e.a) responsedMessage;
                if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                    a.this.f51457e.c(-1);
                    return;
                }
                if (!StringUtils.isNull(a.this.f51453a)) {
                    a.this.f51458f.put(a.this.f51453a, aVar.getDataList());
                }
                a.this.f51457e.b(responsedMessage.getError(), aVar);
            }
        }
    }

    public a(b bVar) {
        this.f51457e = bVar;
        g();
    }

    @Override // d.a.k0.a1.f.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            if (this.f51456d) {
                return false;
            }
            String str4 = this.f51453a;
            if (str4 != null && str4.equals(str) && this.f51458f.size() > 0) {
                this.f51457e.setData(this.f51458f.get(str));
                return true;
            }
            k(bdUniqueId);
            i(str);
            h(str2);
            j(str3);
            MoreTreasureTroveReqMsg moreTreasureTroveReqMsg = new MoreTreasureTroveReqMsg();
            moreTreasureTroveReqMsg.setTag(bdUniqueId);
            moreTreasureTroveReqMsg.setTabCode(str);
            moreTreasureTroveReqMsg.setLfUser(str2);
            moreTreasureTroveReqMsg.setTaskId(str3);
            boolean sendMessage = MessageManager.getInstance().sendMessage(moreTreasureTroveReqMsg);
            this.f51456d = sendMessage;
            return sendMessage;
        }
        b bVar = this.f51457e;
        if (bVar != null) {
            bVar.c(-1);
        }
        return false;
    }

    public final void g() {
        this.f51455c = new C1183a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        MessageManager.getInstance().registerListener(this.f51455c);
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f51453a = str;
    }

    public void j(String str) {
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f51454b = bdUniqueId;
    }
}
