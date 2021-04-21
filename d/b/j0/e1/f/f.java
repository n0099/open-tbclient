package d.b.j0.e1.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.MsgLeftViewItemAdapter;
import com.baidu.tieba.im.chat.MsgMidViewItemAdapter;
import com.baidu.tieba.im.chat.MsgRightViewItemAdapter;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<MsglistActivity<?>> f55615a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f55616b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f55617c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f55618d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f55619e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f55620f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f55621g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f55622h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f17448b == null || aVar.f17447a == null) {
                return;
            }
            f.this.f55621g.addAll(aVar.f17448b);
            f.this.f55617c.a(new ArrayList(f.this.f55621g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f55616b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f55615a, ChatMessage.TYPE_MSG_LEFT);
        this.f55618d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.m0(true);
        this.f55618d.n0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f55615a, ChatMessage.TYPE_MSG_RIGHT);
        this.f55619e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.m0(true);
        this.f55619e.n0(true);
        this.f55620f = new MsgMidViewItemAdapter(this.f55615a, ChatMessage.TYPE_MSG_MID);
        this.f55621g.add(this.f55618d);
        this.f55621g.add(this.f55619e);
        this.f55621g.add(this.f55620f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17448b = new ArrayList();
        aVar.f17447a = this.f55615a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f55622h.setPriority(Integer.MAX_VALUE);
        this.f55615a.registerListener(this.f55622h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f55617c.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f55617c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f55617c.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f55617c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f55617c.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f55617c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f55622h != null) {
            MessageManager.getInstance().unRegisterListener(this.f55622h);
            this.f55622h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f55616b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f55616b != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.f55616b);
        }
        this.f55617c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f55619e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f55618d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.b.c.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f55621g) {
            if (msgCommonItemAdapter.i0()) {
                msgCommonItemAdapter.o0(aVar);
            }
        }
    }

    public void n(d.b.c.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f55621g) {
            if (msgCommonItemAdapter.j0()) {
                msgCommonItemAdapter.p0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.f55616b = null;
        this.f55621g = new ArrayList();
        this.f55622h = new a(2001275);
        this.f55615a = tbPageContext;
        this.f55617c = bdTypeListView;
        d();
        this.f55618d.q0(i);
        this.f55619e.q0(i);
    }
}
