package d.a.k0.t.i.c;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabRequestMessage;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabResponseMessage;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.k0.q0.c1;
import d.a.k0.q0.p0;
import d.a.k0.q0.t0;
import d.a.k0.q0.z0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements p0 {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f61695e;

    /* renamed from: f  reason: collision with root package name */
    public int f61696f;

    /* renamed from: g  reason: collision with root package name */
    public c1 f61697g;

    /* renamed from: i  reason: collision with root package name */
    public t0 f61699i;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f61698h = new ArrayList<>();
    public d.a.c.c.g.a j = new C1645a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
    public HttpMessageListener k = new b(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);

    /* renamed from: d.a.k0.t.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1645a extends d.a.c.c.g.a {
        public C1645a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a2 a2Var;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.f61695e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(a.this.f61698h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = a.this.f61698h.size() - 1; size >= 0; size--) {
                    if (a.this.f61698h.get(size).getType() == a2.g3 && (a2Var = (a2) a.this.f61698h.get(size)) != null && a2Var.q1() != null && closedIds.contains(Long.valueOf(a2Var.q1().live_id))) {
                        a.this.f61698h.remove(size);
                        z = true;
                    }
                }
                if (!z || a.this.f61699i == null) {
                    return;
                }
                a.this.f61699i.a(49, a.this.f61696f, a.this.f61697g, a.this.f61698h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1021038) {
                return;
            }
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                a.this.f61699i.a(49, a.this.f61696f, null, null);
                return;
            }
            FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
            if (frsPageAlaTabResponseMessage.errCode != 0) {
                if (a.this.f61699i != null) {
                    a.this.f61699i.a(49, a.this.f61696f, null, null);
                    return;
                }
                return;
            }
            ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
            ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
            c1 c1Var = frsPageAlaTabResponseMessage.pageInfo;
            int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
            a.this.f61697g = c1Var;
            if (c1Var.f59730c == 1) {
                a.this.f61698h.clear();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
            if (a.this.f61699i != null) {
                if (arrayList != null && arrayList.size() > 0) {
                    a.this.f61698h.addAll(arrayList);
                    a.this.f61699i.a(49, a.this.f61696f, c1Var, a.this.f61698h);
                    return;
                }
                a2 a2Var = new a2();
                a2Var.n4(51);
                if (a.this.f61698h.size() == 0 || (a.this.f61698h.size() > 0 && ((a2) a.this.f61698h.get(0)).t1() != 51)) {
                    a.this.f61698h.add(0, a2Var);
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    a2Var.b1 = true;
                    if (arrayList2.get(0) != null) {
                        ((a2) arrayList2.get(0)).a1 = true;
                    }
                    a.this.f61698h.addAll(arrayList2);
                }
                a.this.f61699i.a(49, a.this.f61696f, c1Var, a.this.f61698h);
            }
        }
    }

    @Override // d.a.k0.q0.p0
    public void e() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        i();
    }

    public final void g() {
        BdUniqueId bdUniqueId = this.f61695e;
        if (bdUniqueId != null) {
            this.k.setTag(bdUniqueId);
            this.j.setTag(this.f61695e);
        }
        MessageManager.getInstance().registerListener(this.j);
        MessageManager.getInstance().registerListener(this.k);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f61695e = bdUniqueId;
    }

    public final void i() {
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    @Override // d.a.k0.q0.p0
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        g();
    }

    @Override // d.a.k0.q0.p0
    public void m(int i2, int i3, z0 z0Var) {
        this.f61696f = i3;
        if (z0Var != null && !TextUtils.isEmpty(z0Var.f59728a) && !TextUtils.isEmpty(z0Var.f59729b)) {
            if (z0Var.f59730c <= 0) {
                z0Var.f59730c = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, z0Var.f59728a, z0Var.f59729b, z0Var.f59730c));
            return;
        }
        this.f61699i.a(49, this.f61696f, null, null);
    }

    @Override // d.a.k0.q0.p0
    public void p(t0 t0Var) {
        this.f61699i = t0Var;
    }
}
