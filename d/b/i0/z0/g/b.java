package d.b.i0.z0.g;

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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.z0.g.h.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f63037a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f63038b;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f63040d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f63041e;

    /* renamed from: f  reason: collision with root package name */
    public d f63042f;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f63039c = new LongSparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f63043g = new a(2921030);

    /* renamed from: h  reason: collision with root package name */
    public final d.b.b.c.g.a f63044h = new C1700b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    public final CustomMessageListener i = new c(2921031);

    /* loaded from: classes3.dex */
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
            long f2 = d.b.b.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.b.b.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            if (f2 == 0 || f3 == 0) {
                return;
            }
            d.b.b.e.m.e.a().removeCallbacks(b.this.f63042f);
            b bVar = b.this;
            bVar.f63042f = new d(f3, f2);
            d.b.b.e.m.e.a().postDelayed(b.this.f63042f, 500L);
        }
    }

    /* renamed from: d.b.i0.z0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1700b extends d.b.b.c.g.a {
        public C1700b(b bVar, int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (StringUtils.isNull(str) || ListUtils.isEmpty(b.this.f63037a) || ListUtils.isEmpty(b.this.f63040d)) {
                return;
            }
            Iterator it = b.this.f63037a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) it.next();
                if (nVar instanceof d.b.i0.x.e0.b) {
                    d.b.i0.x.e0.b bVar = (d.b.i0.x.e0.b) nVar;
                    if (bVar.n() != null && bVar.n().w1() != null && bVar.n().w1().equals(str)) {
                        it.remove();
                        d.b.i0.z0.g.k.b.b(b.this.f63037a);
                        b.this.f63038b.z(new ArrayList(b.this.f63037a));
                        break;
                    }
                }
            }
            long f2 = d.b.b.e.m.b.f(str, 0L);
            Iterator it2 = b.this.f63040d.iterator();
            while (it2.hasNext()) {
                ThreadInfo threadInfo = (ThreadInfo) it2.next();
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                    it2.remove();
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f63047e;

        /* renamed from: f  reason: collision with root package name */
        public long f63048f;

        public d(long j, long j2) {
            this.f63047e = j;
            this.f63048f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.f63041e);
            requestGetMyPostNetMessage.setParams(this.f63047e, this.f63048f, 0L, k, i, f2, i2);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public b(List<n> list, b0 b0Var) {
        this.f63037a = list;
        this.f63038b = b0Var;
    }

    public void g(List<ThreadInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f63039c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        if (this.f63042f != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f63042f);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f63041e = bdUniqueId;
        this.f63043g.setTag(bdUniqueId);
        this.f63043g.setSelfListener(false);
        this.f63044h.setTag(bdUniqueId);
        this.f63044h.getHttpMessageListener().setSelfListener(true);
        this.f63044h.getSocketMessageListener().setSelfListener(true);
        this.i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f63043g);
        MessageManager.getInstance().registerListener(this.f63044h);
        MessageManager.getInstance().registerListener(this.i);
    }

    public void j(List<ThreadInfo> list) {
        this.f63040d = list;
    }
}
