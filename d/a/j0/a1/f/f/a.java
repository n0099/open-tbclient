package d.a.j0.a1.f.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.j0.a1.f.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.a.j0.a1.f.a {

    /* renamed from: a  reason: collision with root package name */
    public String f50756a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f50758c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50759d;

    /* renamed from: e  reason: collision with root package name */
    public b f50760e;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f50757b = null;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f50761f = new HashMap<>();

    /* renamed from: d.a.j0.a1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1111a extends d.a.c.c.g.a {
        public C1111a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f50759d = false;
            if (a.this.f50760e == null) {
                return;
            }
            if (!(responsedMessage instanceof d.a.j0.a1.f.e.a)) {
                a.this.f50760e.c(-1);
            } else if (responsedMessage.getOrginalMessage() == null || a.this.f50757b != responsedMessage.getOrginalMessage().getTag()) {
                a.this.f50760e.c(-1);
            } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a.this.f50760e.c(responsedMessage.getError());
            } else {
                d.a.j0.a1.f.e.a aVar = (d.a.j0.a1.f.e.a) responsedMessage;
                if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                    a.this.f50760e.c(-1);
                    return;
                }
                if (!StringUtils.isNull(a.this.f50756a)) {
                    a.this.f50761f.put(a.this.f50756a, aVar.getDataList());
                }
                a.this.f50760e.b(responsedMessage.getError(), aVar);
            }
        }
    }

    public a(b bVar) {
        this.f50760e = bVar;
        g();
    }

    @Override // d.a.j0.a1.f.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            if (this.f50759d) {
                return false;
            }
            String str4 = this.f50756a;
            if (str4 != null && str4.equals(str) && this.f50761f.size() > 0) {
                this.f50760e.setData(this.f50761f.get(str));
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
            this.f50759d = sendMessage;
            return sendMessage;
        }
        b bVar = this.f50760e;
        if (bVar != null) {
            bVar.c(-1);
        }
        return false;
    }

    public final void g() {
        this.f50758c = new C1111a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        MessageManager.getInstance().registerListener(this.f50758c);
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f50756a = str;
    }

    public void j(String str) {
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f50757b = bdUniqueId;
    }
}
