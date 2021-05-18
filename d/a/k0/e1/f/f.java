package d.a.k0.e1.f;

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
    public TbPageContext<MsglistActivity<?>> f54172a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f54173b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f54174c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f54175d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f54176e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f54177f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f54178g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f54179h;

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
            if (aVar.f17072b == null || aVar.f17071a == null) {
                return;
            }
            f.this.f54178g.addAll(aVar.f17072b);
            f.this.f54174c.a(new ArrayList(f.this.f54178g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f54173b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f54172a, ChatMessage.TYPE_MSG_LEFT);
        this.f54175d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.i0(true);
        this.f54175d.j0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f54172a, ChatMessage.TYPE_MSG_RIGHT);
        this.f54176e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.i0(true);
        this.f54176e.j0(true);
        this.f54177f = new MsgMidViewItemAdapter(this.f54172a, ChatMessage.TYPE_MSG_MID);
        this.f54178g.add(this.f54175d);
        this.f54178g.add(this.f54176e);
        this.f54178g.add(this.f54177f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17072b = new ArrayList();
        aVar.f17071a = this.f54172a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f54179h.setPriority(Integer.MAX_VALUE);
        this.f54172a.registerListener(this.f54179h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f54174c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f54174c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f54174c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f54174c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f54174c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f54174c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f54179h != null) {
            MessageManager.getInstance().unRegisterListener(this.f54179h);
            this.f54179h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f54173b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f54173b != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    if (list.get(i2).getCacheData() == null) {
                        list.get(i2).setCacheData(new MsgCacheData());
                    }
                    list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                }
            }
            arrayList.addAll(this.f54173b);
        }
        this.f54174c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f54176e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f54175d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.a.c.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f54178g) {
            if (msgCommonItemAdapter.f0()) {
                msgCommonItemAdapter.m0(aVar);
            }
        }
    }

    public void n(d.a.c.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f54178g) {
            if (msgCommonItemAdapter.g0()) {
                msgCommonItemAdapter.n0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i2) {
        this.f54173b = null;
        this.f54178g = new ArrayList();
        this.f54179h = new a(2001275);
        this.f54172a = tbPageContext;
        this.f54174c = bdTypeListView;
        d();
        this.f54175d.p0(i2);
        this.f54176e.p0(i2);
    }
}
