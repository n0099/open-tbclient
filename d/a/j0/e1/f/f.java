package d.a.j0.e1.f;

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
    public TbPageContext<MsglistActivity<?>> f53465a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f53466b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f53467c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f53468d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f53469e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f53470f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f53471g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f53472h;

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
            if (aVar.f17757b == null || aVar.f17756a == null) {
                return;
            }
            f.this.f53471g.addAll(aVar.f17757b);
            f.this.f53467c.a(new ArrayList(f.this.f53471g));
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public List<ChatMessage> c() {
        return this.f53466b;
    }

    public final void d() {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f53465a, ChatMessage.TYPE_MSG_LEFT);
        this.f53468d = msgLeftViewItemAdapter;
        msgLeftViewItemAdapter.i0(true);
        this.f53468d.j0(true);
        MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f53465a, ChatMessage.TYPE_MSG_RIGHT);
        this.f53469e = msgRightViewItemAdapter;
        msgRightViewItemAdapter.i0(true);
        this.f53469e.j0(true);
        this.f53470f = new MsgMidViewItemAdapter(this.f53465a, ChatMessage.TYPE_MSG_MID);
        this.f53471g.add(this.f53468d);
        this.f53471g.add(this.f53469e);
        this.f53471g.add(this.f53470f);
        e();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.f17757b = new ArrayList();
        aVar.f17756a = this.f53465a;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    public final void e() {
        this.f53472h.setPriority(Integer.MAX_VALUE);
        this.f53465a.registerListener(this.f53472h);
    }

    public void f(ChatMessage chatMessage) {
        if (this.f53467c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f53467c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        if (this.f53467c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f53467c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        if (this.f53467c.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f53467c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        if (this.f53472h != null) {
            MessageManager.getInstance().unRegisterListener(this.f53472h);
            this.f53472h = null;
        }
    }

    public void j(List<ChatMessage> list) {
        this.f53466b = list;
        ArrayList arrayList = new ArrayList();
        if (this.f53466b != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    if (list.get(i2).getCacheData() == null) {
                        list.get(i2).setCacheData(new MsgCacheData());
                    }
                    list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                }
            }
            arrayList.addAll(this.f53466b);
        }
        this.f53467c.setData(arrayList);
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter = this.f53469e;
        if (msgRightViewItemAdapter != null) {
            msgRightViewItemAdapter.r0(z);
        }
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f53468d;
        if (msgLeftViewItemAdapter != null) {
            msgLeftViewItemAdapter.r0(z);
        }
    }

    public void m(d.a.c.e.h.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f53471g) {
            if (msgCommonItemAdapter.f0()) {
                msgCommonItemAdapter.m0(aVar);
            }
        }
    }

    public void n(d.a.c.e.h.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.f53471g) {
            if (msgCommonItemAdapter.g0()) {
                msgCommonItemAdapter.n0(bVar);
            }
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i2) {
        this.f53466b = null;
        this.f53471g = new ArrayList();
        this.f53472h = new a(2001275);
        this.f53465a = tbPageContext;
        this.f53467c = bdTypeListView;
        d();
        this.f53468d.p0(i2);
        this.f53469e.p0(i2);
    }
}
