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
    public TbPageContext<MsglistActivity<?>> f54362a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f54363b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f54364c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f54365d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f54366e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f54367f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f54368g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f54369h;

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
            if (aVar.f16982b == null || aVar.f16981a == null) {
                return;
            }
            f.this.f54368g.addAll(aVar.f16982b);
            f.this.f54364c.a(new ArrayList(f.this.f54368g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f54363b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f54362a, ChatMessage.TYPE_MSG_LEFT);
        this.f54365d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.i0(true);
        this.f54365d.j0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f54362a, ChatMessage.TYPE_MSG_RIGHT);
        this.f54366e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.i0(true);
        this.f54366e.j0(true);
        this.f54367f = new MsgMidViewItemAdapter(this.f54362a, ChatMessage.TYPE_MSG_MID);
        this.f54368g.add(this.f54365d);
        this.f54368g.add(this.f54366e);
        this.f54368g.add(this.f54367f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f16982b = new ArrayList();
        aVar.f16981a = this.f54362a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f54369h.setPriority(Integer.MAX_VALUE);
        this.f54362a.registerListener(this.f54369h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f54364c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f54364c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f54364c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f54364c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f54364c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f54364c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f54369h != null) {
            MessageManager.getInstance().unRegisterListener(this.f54369h);
            this.f54369h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f54363b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f54363b != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    if (list.get(i2).getCacheData() == null) {
                        list.get(i2).setCacheData(new MsgCacheData());
                    }
                    list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                }
            }
            arrayList.addAll(this.f54363b);
        }
        this.f54364c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f54366e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.s0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f54365d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.s0(z);
        }
    }

    public void m(d.a.c.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f54368g) {
            if (msgCommonItemAdapter.f0()) {
                msgCommonItemAdapter.m0(aVar);
            }
        }
    }

    public void n(d.a.c.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f54368g) {
            if (msgCommonItemAdapter.g0()) {
                msgCommonItemAdapter.n0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i2) {
        this.f54363b = null;
        this.f54368g = new ArrayList();
        this.f54369h = new a(2001275);
        this.f54362a = tbPageContext;
        this.f54364c = bdTypeListView;
        d();
        this.f54365d.p0(i2);
        this.f54366e.p0(i2);
    }
}
