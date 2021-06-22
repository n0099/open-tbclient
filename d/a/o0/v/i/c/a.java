package d.a.o0.v.i.c;

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
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.r0.c1;
import d.a.o0.r0.p0;
import d.a.o0.r0.t0;
import d.a.o0.r0.z0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements p0 {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f65823e;

    /* renamed from: f  reason: collision with root package name */
    public int f65824f;

    /* renamed from: g  reason: collision with root package name */
    public c1 f65825g;

    /* renamed from: i  reason: collision with root package name */
    public t0 f65827i;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f65826h = new ArrayList<>();
    public d.a.c.c.g.a j = new C1726a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
    public HttpMessageListener k = new b(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);

    /* renamed from: d.a.o0.v.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1726a extends d.a.c.c.g.a {
        public C1726a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a2 a2Var;
            if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == a.this.f65823e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(a.this.f65826h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = a.this.f65826h.size() - 1; size >= 0; size--) {
                    if (a.this.f65826h.get(size).getType() == a2.k3 && (a2Var = (a2) a.this.f65826h.get(size)) != null && a2Var.s1() != null && closedIds.contains(Long.valueOf(a2Var.s1().live_id))) {
                        a.this.f65826h.remove(size);
                        z = true;
                    }
                }
                if (!z || a.this.f65827i == null) {
                    return;
                }
                a.this.f65827i.a(49, a.this.f65824f, a.this.f65825g, a.this.f65826h);
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
                a.this.f65827i.a(49, a.this.f65824f, null, null);
                return;
            }
            FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
            if (frsPageAlaTabResponseMessage.errCode != 0) {
                if (a.this.f65827i != null) {
                    a.this.f65827i.a(49, a.this.f65824f, null, null);
                    return;
                }
                return;
            }
            ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
            ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
            c1 c1Var = frsPageAlaTabResponseMessage.pageInfo;
            int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
            a.this.f65825g = c1Var;
            if (c1Var.f63687c == 1) {
                a.this.f65826h.clear();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
            if (a.this.f65827i != null) {
                if (arrayList != null && arrayList.size() > 0) {
                    a.this.f65826h.addAll(arrayList);
                    a.this.f65827i.a(49, a.this.f65824f, c1Var, a.this.f65826h);
                    return;
                }
                a2 a2Var = new a2();
                a2Var.p4(51);
                if (a.this.f65826h.size() == 0 || (a.this.f65826h.size() > 0 && ((a2) a.this.f65826h.get(0)).v1() != 51)) {
                    a.this.f65826h.add(0, a2Var);
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    a2Var.d1 = true;
                    if (arrayList2.get(0) != null) {
                        ((a2) arrayList2.get(0)).c1 = true;
                    }
                    a.this.f65826h.addAll(arrayList2);
                }
                a.this.f65827i.a(49, a.this.f65824f, c1Var, a.this.f65826h);
            }
        }
    }

    public final void f() {
        BdUniqueId bdUniqueId = this.f65823e;
        if (bdUniqueId != null) {
            this.k.setTag(bdUniqueId);
            this.j.setTag(this.f65823e);
        }
        MessageManager.getInstance().registerListener(this.j);
        MessageManager.getInstance().registerListener(this.k);
    }

    @Override // d.a.o0.r0.p0
    public void g() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
        i();
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f65823e = bdUniqueId;
    }

    public final void i() {
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    @Override // d.a.o0.r0.p0
    public void init() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        f();
    }

    @Override // d.a.o0.r0.p0
    public void q(int i2, int i3, z0 z0Var) {
        this.f65824f = i3;
        if (z0Var != null && !TextUtils.isEmpty(z0Var.f63685a) && !TextUtils.isEmpty(z0Var.f63686b)) {
            if (z0Var.f63687c <= 0) {
                z0Var.f63687c = 1;
            }
            MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, z0Var.f63685a, z0Var.f63686b, z0Var.f63687c));
            return;
        }
        this.f65827i.a(49, this.f65824f, null, null);
    }

    @Override // d.a.o0.r0.p0
    public void t(t0 t0Var) {
        this.f65827i = t0Var;
    }
}
