package d.b.i0.a1.g;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.a1.g.h.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f52656a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f52657b;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f52659d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f52660e;

    /* renamed from: f  reason: collision with root package name */
    public d f52661f;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f52658c = new LongSparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f52662g = new a(2921030);

    /* renamed from: h  reason: collision with root package name */
    public final d.b.c.c.g.a f52663h = new C1152b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    public final CustomMessageListener i = new c(2921031);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
            long f2 = d.b.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.b.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            if (f2 == 0 || f3 == 0) {
                return;
            }
            d.b.c.e.m.e.a().removeCallbacks(b.this.f52661f);
            b bVar = b.this;
            bVar.f52661f = new d(f3, f2);
            d.b.c.e.m.e.a().postDelayed(b.this.f52661f, 500L);
        }
    }

    /* renamed from: d.b.i0.a1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1152b extends d.b.c.c.g.a {
        public C1152b(b bVar, int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
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
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (StringUtils.isNull(str) || ListUtils.isEmpty(b.this.f52656a) || ListUtils.isEmpty(b.this.f52659d)) {
                return;
            }
            Iterator it = b.this.f52656a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) it.next();
                if (nVar instanceof d.b.i0.x.e0.b) {
                    d.b.i0.x.e0.b bVar = (d.b.i0.x.e0.b) nVar;
                    if (bVar.n() != null && bVar.n().w1() != null && bVar.n().w1().equals(str)) {
                        it.remove();
                        d.b.i0.a1.g.k.b.b(b.this.f52656a);
                        b.this.f52657b.z(new ArrayList(b.this.f52656a));
                        break;
                    }
                }
            }
            long f2 = d.b.c.e.m.b.f(str, 0L);
            Iterator it2 = b.this.f52659d.iterator();
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
        public long f52666e;

        /* renamed from: f  reason: collision with root package name */
        public long f52667f;

        public d(long j, long j2) {
            this.f52666e = j;
            this.f52667f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.f52660e);
            requestGetMyPostNetMessage.setParams(this.f52666e, this.f52667f, 0L, k, i, f2, i2);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public b(List<n> list, b0 b0Var) {
        this.f52656a = list;
        this.f52657b = b0Var;
    }

    public void g(List<ThreadInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f52658c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        if (this.f52661f != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f52661f);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f52660e = bdUniqueId;
        this.f52662g.setTag(bdUniqueId);
        this.f52662g.setSelfListener(false);
        this.f52663h.setTag(bdUniqueId);
        this.f52663h.getHttpMessageListener().setSelfListener(true);
        this.f52663h.getSocketMessageListener().setSelfListener(true);
        this.i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f52662g);
        MessageManager.getInstance().registerListener(this.f52663h);
        MessageManager.getInstance().registerListener(this.i);
    }

    public void j(List<ThreadInfo> list) {
        this.f52659d = list;
    }
}
