package d.a.n0.f1.f;

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
    public TbPageContext<MsglistActivity<?>> f58051a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f58052b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f58053c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f58054d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f58055e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f58056f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f58057g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f58058h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f17058b == null || aVar.f17057a == null) {
                return;
            }
            f.this.f58057g.addAll(aVar.f17058b);
            f.this.f58053c.a(new ArrayList(f.this.f58057g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f58052b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f58051a, ChatMessage.TYPE_MSG_LEFT);
        this.f58054d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.j0(true);
        this.f58054d.k0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f58051a, ChatMessage.TYPE_MSG_RIGHT);
        this.f58055e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.j0(true);
        this.f58055e.k0(true);
        this.f58056f = new MsgMidViewItemAdapter(this.f58051a, ChatMessage.TYPE_MSG_MID);
        this.f58057g.add(this.f58054d);
        this.f58057g.add(this.f58055e);
        this.f58057g.add(this.f58056f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17058b = new ArrayList();
        aVar.f17057a = this.f58051a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f58058h.setPriority(Integer.MAX_VALUE);
        this.f58051a.registerListener(this.f58058h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f58053c.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f58053c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f58053c.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f58053c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f58053c.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f58053c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f58058h != null) {
            MessageManager.getInstance().unRegisterListener(this.f58058h);
            this.f58058h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f58052b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f58052b != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    if (list.get(i2).getCacheData() == null) {
                        list.get(i2).setCacheData(new MsgCacheData());
                    }
                    list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                }
            }
            arrayList.addAll(this.f58052b);
        }
        this.f58053c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f58055e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f58054d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.a.c.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f58057g) {
            if (msgCommonItemAdapter.g0()) {
                msgCommonItemAdapter.l0(aVar);
            }
        }
    }

    public void n(d.a.c.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f58057g) {
            if (msgCommonItemAdapter.h0()) {
                msgCommonItemAdapter.m0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i2) {
        this.f58052b = null;
        this.f58057g = new ArrayList();
        this.f58058h = new a(2001275);
        this.f58051a = tbPageContext;
        this.f58053c = bdTypeListView;
        d();
        this.f58054d.p0(i2);
        this.f58055e.p0(i2);
    }
}
