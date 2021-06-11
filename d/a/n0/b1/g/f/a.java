package d.a.n0.b1.g.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.n0.b1.g.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.a.n0.b1.g.a {

    /* renamed from: a  reason: collision with root package name */
    public String f55301a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f55303c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55304d;

    /* renamed from: e  reason: collision with root package name */
    public b f55305e;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55302b = null;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f55306f = new HashMap<>();

    /* renamed from: d.a.n0.b1.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1256a extends d.a.c.c.g.a {
        public C1256a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f55304d = false;
            if (a.this.f55305e == null) {
                return;
            }
            if (!(responsedMessage instanceof d.a.n0.b1.g.e.a)) {
                a.this.f55305e.c(-1);
            } else if (responsedMessage.getOrginalMessage() == null || a.this.f55302b != responsedMessage.getOrginalMessage().getTag()) {
                a.this.f55305e.c(-1);
            } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a.this.f55305e.c(responsedMessage.getError());
            } else {
                d.a.n0.b1.g.e.a aVar = (d.a.n0.b1.g.e.a) responsedMessage;
                if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                    a.this.f55305e.c(-1);
                    return;
                }
                if (!StringUtils.isNull(a.this.f55301a)) {
                    a.this.f55306f.put(a.this.f55301a, aVar.getDataList());
                }
                a.this.f55305e.b(responsedMessage.getError(), aVar);
            }
        }
    }

    public a(b bVar) {
        this.f55305e = bVar;
        g();
    }

    @Override // d.a.n0.b1.g.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            if (this.f55304d) {
                return false;
            }
            String str4 = this.f55301a;
            if (str4 != null && str4.equals(str) && this.f55306f.size() > 0) {
                this.f55305e.setData(this.f55306f.get(str));
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
            this.f55304d = sendMessage;
            return sendMessage;
        }
        b bVar = this.f55305e;
        if (bVar != null) {
            bVar.c(-1);
        }
        return false;
    }

    public final void g() {
        this.f55303c = new C1256a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        MessageManager.getInstance().registerListener(this.f55303c);
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f55301a = str;
    }

    public void j(String str) {
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f55302b = bdUniqueId;
    }
}
