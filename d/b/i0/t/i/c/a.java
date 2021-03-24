package d.b.i0.t.i.c;

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
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.p0.c1;
import d.b.i0.p0.p0;
import d.b.i0.p0.t0;
import d.b.i0.p0.z0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements p0 {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f60788e;

    /* renamed from: f  reason: collision with root package name */
    public int f60789f;

    /* renamed from: g  reason: collision with root package name */
    public c1 f60790g;
    public t0 i;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f60791h = new ArrayList<>();
    public d.b.b.c.g.a j = new C1563a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
    public HttpMessageListener k = new b(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);

    /* renamed from: d.b.i0.t.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1563a extends d.b.b.c.g.a {
        public C1563a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a2 a2Var;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.f60788e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(a.this.f60791h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = a.this.f60791h.size() - 1; size >= 0; size--) {
                    if (a.this.f60791h.get(size).getType() == a2.f3 && (a2Var = (a2) a.this.f60791h.get(size)) != null && a2Var.q1() != null && closedIds.contains(Long.valueOf(a2Var.q1().live_id))) {
                        a.this.f60791h.remove(size);
                        z = true;
                    }
                }
                if (!z || a.this.i == null) {
                    return;
                }
                a.this.i.a(49, a.this.f60789f, a.this.f60790g, a.this.f60791h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1021038) {
                return;
            }
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                a.this.i.a(49, a.this.f60789f, null, null);
                return;
            }
            FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
            if (frsPageAlaTabResponseMessage.errCode != 0) {
                if (a.this.i != null) {
                    a.this.i.a(49, a.this.f60789f, null, null);
                    return;
                }
                return;
            }
            ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
            ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
            c1 c1Var = frsPageAlaTabResponseMessage.pageInfo;
            int i = frsPageAlaTabResponseMessage.alaLiveCount;
            a.this.f60790g = c1Var;
            if (c1Var.f58780c == 1) {
                a.this.f60791h.clear();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i)));
            if (a.this.i != null) {
                if (arrayList != null && arrayList.size() > 0) {
                    a.this.f60791h.addAll(arrayList);
                    a.this.i.a(49, a.this.f60789f, c1Var, a.this.f60791h);
                    return;
                }
                a2 a2Var = new a2();
                a2Var.k4(51);
                if (a.this.f60791h.size() == 0 || (a.this.f60791h.size() > 0 && ((a2) a.this.f60791h.get(0)).s1() != 51)) {
                    a.this.f60791h.add(0, a2Var);
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    a2Var.b1 = true;
                    if (arrayList2.get(0) != null) {
                        ((a2) arrayList2.get(0)).a1 = true;
                    }
                    a.this.f60791h.addAll(arrayList2);
                }
                a.this.i.a(49, a.this.f60789f, c1Var, a.this.f60791h);
            }
        }
    }

    public final void f() {
        BdUniqueId bdUniqueId = this.f60788e;
        if (bdUniqueId != null) {
            this.k.setTag(bdUniqueId);
            this.j.setTag(this.f60788e);
        }
        MessageManager.getInstance().registerListener(this.j);
        MessageManager.getInstance().registerListener(this.k);
    }

    @Override // d.b.i0.p0.p0
    public void g(int i, int i2, z0 z0Var) {
        this.f60789f = i2;
        if (z0Var != null && !TextUtils.isEmpty(z0Var.f58778a) && !TextUtils.isEmpty(z0Var.f58779b)) {
            if (z0Var.f58780c <= 0) {
                z0Var.f58780c = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, z0Var.f58778a, z0Var.f58779b, z0Var.f58780c));
            return;
        }
        this.i.a(49, this.f60789f, null, null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f60788e = bdUniqueId;
    }

    public final void i() {
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    @Override // d.b.i0.p0.p0
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        f();
    }

    @Override // d.b.i0.p0.p0
    public void j() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        i();
    }

    @Override // d.b.i0.p0.p0
    public void o(t0 t0Var) {
        this.i = t0Var;
    }
}
