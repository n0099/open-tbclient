package d.b.i0.d1.f;

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
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<MsglistActivity<?>> f53672a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f53673b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f53674c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f53675d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f53676e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f53677f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f53678g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f53679h;

    /* loaded from: classes3.dex */
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
            if (aVar.f17763b == null || aVar.f17762a == null) {
                return;
            }
            f.this.f53678g.addAll(aVar.f17763b);
            f.this.f53674c.a(new ArrayList(f.this.f53678g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f53673b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f53672a, ChatMessage.TYPE_MSG_LEFT);
        this.f53675d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.m0(true);
        this.f53675d.n0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f53672a, ChatMessage.TYPE_MSG_RIGHT);
        this.f53676e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.m0(true);
        this.f53676e.n0(true);
        this.f53677f = new MsgMidViewItemAdapter(this.f53672a, ChatMessage.TYPE_MSG_MID);
        this.f53678g.add(this.f53675d);
        this.f53678g.add(this.f53676e);
        this.f53678g.add(this.f53677f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17763b = new ArrayList();
        aVar.f17762a = this.f53672a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f53679h.setPriority(Integer.MAX_VALUE);
        this.f53672a.registerListener(this.f53679h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f53674c.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f53674c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f53674c.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f53674c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f53674c.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f53674c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f53679h != null) {
            MessageManager.getInstance().unRegisterListener(this.f53679h);
            this.f53679h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f53673b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f53673b != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.f53673b);
        }
        this.f53674c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f53676e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f53675d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.b.b.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f53678g) {
            if (msgCommonItemAdapter.i0()) {
                msgCommonItemAdapter.o0(aVar);
            }
        }
    }

    public void n(d.b.b.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f53678g) {
            if (msgCommonItemAdapter.j0()) {
                msgCommonItemAdapter.p0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.f53673b = null;
        this.f53678g = new ArrayList();
        this.f53679h = new a(2001275);
        this.f53672a = tbPageContext;
        this.f53674c = bdTypeListView;
        d();
        this.f53675d.q0(i);
        this.f53676e.q0(i);
    }
}
