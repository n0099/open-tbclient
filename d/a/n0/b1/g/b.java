package d.a.n0.b1.g;

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
import d.a.c.j.e.n;
import d.a.n0.b1.g.h.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f51645a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f51646b;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f51648d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f51649e;

    /* renamed from: f  reason: collision with root package name */
    public d f51650f;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f51647c = new LongSparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f51651g = new a(2921030);

    /* renamed from: h  reason: collision with root package name */
    public final d.a.c.c.g.a f51652h = new C1203b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f51653i = new c(2921031);

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
            d.a.c.e.m.e.a().removeCallbacks(b.this.f51650f);
            b bVar = b.this;
            bVar.f51650f = new d(f3, f2);
            d.a.c.e.m.e.a().postDelayed(b.this.f51650f, 500L);
        }
    }

    /* renamed from: d.a.n0.b1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1203b extends d.a.c.c.g.a {
        public C1203b(b bVar, int i2, int i3) {
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
            if (StringUtils.isNull(str) || ListUtils.isEmpty(b.this.f51645a) || ListUtils.isEmpty(b.this.f51648d)) {
                return;
            }
            Iterator it = b.this.f51645a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) it.next();
                if (nVar instanceof d.a.n0.z.e0.b) {
                    d.a.n0.z.e0.b bVar = (d.a.n0.z.e0.b) nVar;
                    if (bVar.m() != null && bVar.m().y1() != null && bVar.m().y1().equals(str)) {
                        it.remove();
                        d.a.n0.b1.g.k.b.b(b.this.f51645a);
                        b.this.f51646b.z(new ArrayList(b.this.f51645a));
                        break;
                    }
                }
            }
            long f2 = d.a.c.e.m.b.f(str, 0L);
            Iterator it2 = b.this.f51648d.iterator();
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
        public long f51656e;

        /* renamed from: f  reason: collision with root package name */
        public long f51657f;

        public d(long j, long j2) {
            this.f51656e = j;
            this.f51657f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.f51649e);
            requestGetMyPostNetMessage.setParams(this.f51656e, this.f51657f, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public b(List<n> list, c0 c0Var) {
        this.f51645a = list;
        this.f51646b = c0Var;
    }

    public void g(List<ThreadInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f51647c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        if (this.f51650f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f51650f);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f51649e = bdUniqueId;
        this.f51651g.setTag(bdUniqueId);
        this.f51651g.setSelfListener(false);
        this.f51652h.setTag(bdUniqueId);
        this.f51652h.getHttpMessageListener().setSelfListener(true);
        this.f51652h.getSocketMessageListener().setSelfListener(true);
        this.f51653i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f51651g);
        MessageManager.getInstance().registerListener(this.f51652h);
        MessageManager.getInstance().registerListener(this.f51653i);
    }

    public void j(List<ThreadInfo> list) {
        this.f51648d = list;
    }
}
