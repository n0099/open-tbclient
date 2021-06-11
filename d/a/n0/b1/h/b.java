package d.a.n0.b1.h;

import androidx.collection.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.b1.h.h.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f55328a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f55329b;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f55331d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f55332e;

    /* renamed from: f  reason: collision with root package name */
    public d f55333f;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f55330c = new LongSparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f55334g = new a(2921030);

    /* renamed from: h  reason: collision with root package name */
    public final d.a.c.c.g.a f55335h = new C1259b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f55336i = new c(2921031);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
            long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            if (f2 == 0 || f3 == 0) {
                return;
            }
            d.a.c.e.m.e.a().removeCallbacks(b.this.f55333f);
            b bVar = b.this;
            bVar.f55333f = new d(f3, f2);
            d.a.c.e.m.e.a().postDelayed(b.this.f55333f, 500L);
        }
    }

    /* renamed from: d.a.n0.b1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1259b extends d.a.c.c.g.a {
        public C1259b(b bVar, int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str) || ListUtils.isEmpty(b.this.f55328a) || ListUtils.isEmpty(b.this.f55331d)) {
                return;
            }
            Iterator it = b.this.f55328a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) it.next();
                if (nVar instanceof d.a.n0.z.e0.b) {
                    d.a.n0.z.e0.b bVar = (d.a.n0.z.e0.b) nVar;
                    if (bVar.i() != null && bVar.i().z1() != null && bVar.i().z1().equals(str)) {
                        it.remove();
                        d.a.n0.b1.h.k.b.b(b.this.f55328a);
                        b.this.f55329b.z(new ArrayList(b.this.f55328a));
                        break;
                    }
                }
            }
            long f2 = d.a.c.e.m.b.f(str, 0L);
            Iterator it2 = b.this.f55331d.iterator();
            while (it2.hasNext()) {
                ThreadInfo threadInfo = (ThreadInfo) it2.next();
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                    it2.remove();
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f55339e;

        /* renamed from: f  reason: collision with root package name */
        public long f55340f;

        public d(long j, long j2) {
            this.f55339e = j;
            this.f55340f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.f55332e);
            requestGetMyPostNetMessage.setParams(this.f55339e, this.f55340f, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public b(List<n> list, c0 c0Var) {
        this.f55328a = list;
        this.f55329b = c0Var;
    }

    public void g(List<ThreadInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f55330c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        if (this.f55333f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f55333f);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f55332e = bdUniqueId;
        this.f55334g.setTag(bdUniqueId);
        this.f55334g.setSelfListener(false);
        this.f55335h.setTag(bdUniqueId);
        this.f55335h.getHttpMessageListener().setSelfListener(true);
        this.f55335h.getSocketMessageListener().setSelfListener(true);
        this.f55336i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55334g);
        MessageManager.getInstance().registerListener(this.f55335h);
        MessageManager.getInstance().registerListener(this.f55336i);
    }

    public void j(List<ThreadInfo> list) {
        this.f55331d = list;
    }
}
