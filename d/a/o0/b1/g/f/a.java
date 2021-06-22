package d.a.o0.b1.g.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.o0.b1.g.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.a.o0.b1.g.a {

    /* renamed from: a  reason: collision with root package name */
    public String f55426a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f55428c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55429d;

    /* renamed from: e  reason: collision with root package name */
    public b f55430e;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55427b = null;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f55431f = new HashMap<>();

    /* renamed from: d.a.o0.b1.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1260a extends d.a.c.c.g.a {
        public C1260a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f55429d = false;
            if (a.this.f55430e == null) {
                return;
            }
            if (!(responsedMessage instanceof d.a.o0.b1.g.e.a)) {
                a.this.f55430e.c(-1);
            } else if (responsedMessage.getOrginalMessage() == null || a.this.f55427b != responsedMessage.getOrginalMessage().getTag()) {
                a.this.f55430e.c(-1);
            } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a.this.f55430e.c(responsedMessage.getError());
            } else {
                d.a.o0.b1.g.e.a aVar = (d.a.o0.b1.g.e.a) responsedMessage;
                if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                    a.this.f55430e.c(-1);
                    return;
                }
                if (!StringUtils.isNull(a.this.f55426a)) {
                    a.this.f55431f.put(a.this.f55426a, aVar.getDataList());
                }
                a.this.f55430e.b(responsedMessage.getError(), aVar);
            }
        }
    }

    public a(b bVar) {
        this.f55430e = bVar;
        g();
    }

    @Override // d.a.o0.b1.g.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            if (this.f55429d) {
                return false;
            }
            String str4 = this.f55426a;
            if (str4 != null && str4.equals(str) && this.f55431f.size() > 0) {
                this.f55430e.setData(this.f55431f.get(str));
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
            this.f55429d = sendMessage;
            return sendMessage;
        }
        b bVar = this.f55430e;
        if (bVar != null) {
            bVar.c(-1);
        }
        return false;
    }

    public final void g() {
        this.f55428c = new C1260a(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        MessageManager.getInstance().registerListener(this.f55428c);
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f55426a = str;
    }

    public void j(String str) {
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f55427b = bdUniqueId;
    }
}
