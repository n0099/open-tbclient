package d.b.i0.z0.f.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.i0.z0.f.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.b.i0.z0.f.a {

    /* renamed from: a  reason: collision with root package name */
    public String f63010a;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.c.g.a f63012c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63013d;

    /* renamed from: e  reason: collision with root package name */
    public b f63014e;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63011b = null;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f63015f = new HashMap<>();

    /* renamed from: d.b.i0.z0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1696a extends d.b.b.c.g.a {
        public C1696a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f63013d = false;
            if (a.this.f63014e == null) {
                return;
            }
            if (!(responsedMessage instanceof d.b.i0.z0.f.e.a)) {
                a.this.f63014e.b(-1);
            } else if (responsedMessage.getOrginalMessage() == null || a.this.f63011b != responsedMessage.getOrginalMessage().getTag()) {
                a.this.f63014e.b(-1);
            } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a.this.f63014e.b(responsedMessage.getError());
            } else {
                d.b.i0.z0.f.e.a aVar = (d.b.i0.z0.f.e.a) responsedMessage;
                if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                    a.this.f63014e.b(-1);
                    return;
                }
                if (!StringUtils.isNull(a.this.f63010a)) {
                    a.this.f63015f.put(a.this.f63010a, aVar.getDataList());
                }
                a.this.f63014e.a(responsedMessage.getError(), aVar);
            }
        }
    }

    public a(b bVar) {
        this.f63014e = bVar;
        g();
    }

    @Override // d.b.i0.z0.f.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            if (this.f63013d) {
                return false;
            }
            String str4 = this.f63010a;
            if (str4 != null && str4.equals(str) && this.f63015f.size() > 0) {
                this.f63014e.setData(this.f63015f.get(str));
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
            this.f63013d = sendMessage;
            return sendMessage;
        }
        b bVar = this.f63014e;
        if (bVar != null) {
            bVar.b(-1);
        }
        return false;
    }

    public final void g() {
        this.f63012c = new C1696a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        MessageManager.getInstance().registerListener(this.f63012c);
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f63010a = str;
    }

    public void j(String str) {
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f63011b = bdUniqueId;
    }
}
