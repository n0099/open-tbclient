package d.b.i0.e1.f;

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
    public TbPageContext<MsglistActivity<?>> f55194a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f55195b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f55196c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f55197d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f55198e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f55199f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f55200g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f55201h;

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
            if (aVar.f17440b == null || aVar.f17439a == null) {
                return;
            }
            f.this.f55200g.addAll(aVar.f17440b);
            f.this.f55196c.a(new ArrayList(f.this.f55200g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f55195b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f55194a, ChatMessage.TYPE_MSG_LEFT);
        this.f55197d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.m0(true);
        this.f55197d.n0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f55194a, ChatMessage.TYPE_MSG_RIGHT);
        this.f55198e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.m0(true);
        this.f55198e.n0(true);
        this.f55199f = new MsgMidViewItemAdapter(this.f55194a, ChatMessage.TYPE_MSG_MID);
        this.f55200g.add(this.f55197d);
        this.f55200g.add(this.f55198e);
        this.f55200g.add(this.f55199f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17440b = new ArrayList();
        aVar.f17439a = this.f55194a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f55201h.setPriority(Integer.MAX_VALUE);
        this.f55194a.registerListener(this.f55201h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f55196c.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f55196c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f55196c.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f55196c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f55196c.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f55196c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f55201h != null) {
            MessageManager.getInstance().unRegisterListener(this.f55201h);
            this.f55201h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f55195b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f55195b != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.f55195b);
        }
        this.f55196c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f55198e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f55197d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.b.c.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f55200g) {
            if (msgCommonItemAdapter.i0()) {
                msgCommonItemAdapter.o0(aVar);
            }
        }
    }

    public void n(d.b.c.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f55200g) {
            if (msgCommonItemAdapter.j0()) {
                msgCommonItemAdapter.p0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.f55195b = null;
        this.f55200g = new ArrayList();
        this.f55201h = new a(2001275);
        this.f55194a = tbPageContext;
        this.f55196c = bdTypeListView;
        d();
        this.f55197d.q0(i);
        this.f55198e.q0(i);
    }
}
