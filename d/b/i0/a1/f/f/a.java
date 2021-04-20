package d.b.i0.a1.f.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.i0.a1.f.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.b.i0.a1.f.a {

    /* renamed from: a  reason: collision with root package name */
    public String f52630a;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.c.g.a f52632c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52633d;

    /* renamed from: e  reason: collision with root package name */
    public b f52634e;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f52631b = null;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f52635f = new HashMap<>();

    /* renamed from: d.b.i0.a1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1149a extends d.b.c.c.g.a {
        public C1149a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f52633d = false;
            if (a.this.f52634e == null) {
                return;
            }
            if (!(responsedMessage instanceof d.b.i0.a1.f.e.a)) {
                a.this.f52634e.b(-1);
            } else if (responsedMessage.getOrginalMessage() == null || a.this.f52631b != responsedMessage.getOrginalMessage().getTag()) {
                a.this.f52634e.b(-1);
            } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a.this.f52634e.b(responsedMessage.getError());
            } else {
                d.b.i0.a1.f.e.a aVar = (d.b.i0.a1.f.e.a) responsedMessage;
                if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                    a.this.f52634e.b(-1);
                    return;
                }
                if (!StringUtils.isNull(a.this.f52630a)) {
                    a.this.f52635f.put(a.this.f52630a, aVar.getDataList());
                }
                a.this.f52634e.a(responsedMessage.getError(), aVar);
            }
        }
    }

    public a(b bVar) {
        this.f52634e = bVar;
        g();
    }

    @Override // d.b.i0.a1.f.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            if (this.f52633d) {
                return false;
            }
            String str4 = this.f52630a;
            if (str4 != null && str4.equals(str) && this.f52635f.size() > 0) {
                this.f52634e.setData(this.f52635f.get(str));
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
            this.f52633d = sendMessage;
            return sendMessage;
        }
        b bVar = this.f52634e;
        if (bVar != null) {
            bVar.b(-1);
        }
        return false;
    }

    public final void g() {
        this.f52632c = new C1149a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        MessageManager.getInstance().registerListener(this.f52632c);
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f52630a = str;
    }

    public void j(String str) {
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f52631b = bdUniqueId;
    }
}
