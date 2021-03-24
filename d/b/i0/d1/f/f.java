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
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<MsglistActivity<?>> f53671a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f53672b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f53673c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f53674d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f53675e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f53676f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f53677g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f53678h;

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
            if (aVar.f17762b == null || aVar.f17761a == null) {
                return;
            }
            f.this.f53677g.addAll(aVar.f17762b);
            f.this.f53673c.a(new ArrayList(f.this.f53677g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f53672b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f53671a, ChatMessage.TYPE_MSG_LEFT);
        this.f53674d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.m0(true);
        this.f53674d.n0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f53671a, ChatMessage.TYPE_MSG_RIGHT);
        this.f53675e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.m0(true);
        this.f53675e.n0(true);
        this.f53676f = new MsgMidViewItemAdapter(this.f53671a, ChatMessage.TYPE_MSG_MID);
        this.f53677g.add(this.f53674d);
        this.f53677g.add(this.f53675e);
        this.f53677g.add(this.f53676f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17762b = new ArrayList();
        aVar.f17761a = this.f53671a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f53678h.setPriority(Integer.MAX_VALUE);
        this.f53671a.registerListener(this.f53678h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f53673c.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f53673c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f53673c.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f53673c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f53673c.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f53673c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f53678h != null) {
            MessageManager.getInstance().unRegisterListener(this.f53678h);
            this.f53678h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f53672b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f53672b != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.f53672b);
        }
        this.f53673c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f53675e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f53674d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.b.b.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f53677g) {
            if (msgCommonItemAdapter.i0()) {
                msgCommonItemAdapter.o0(aVar);
            }
        }
    }

    public void n(d.b.b.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f53677g) {
            if (msgCommonItemAdapter.j0()) {
                msgCommonItemAdapter.p0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.f53672b = null;
        this.f53677g = new ArrayList();
        this.f53678h = new a(2001275);
        this.f53671a = tbPageContext;
        this.f53673c = bdTypeListView;
        d();
        this.f53674d.q0(i);
        this.f53675e.q0(i);
    }
}
