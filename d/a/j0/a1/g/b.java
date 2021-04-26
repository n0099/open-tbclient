package d.a.j0.a1.g;

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
import d.a.j0.a1.g.h.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f50783a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f50784b;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f50786d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f50787e;

    /* renamed from: f  reason: collision with root package name */
    public d f50788f;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f50785c = new LongSparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f50789g = new a(2921030);

    /* renamed from: h  reason: collision with root package name */
    public final d.a.c.c.g.a f50790h = new C1114b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f50791i = new c(2921031);

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
            d.a.c.e.m.e.a().removeCallbacks(b.this.f50788f);
            b bVar = b.this;
            bVar.f50788f = new d(f3, f2);
            d.a.c.e.m.e.a().postDelayed(b.this.f50788f, 500L);
        }
    }

    /* renamed from: d.a.j0.a1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1114b extends d.a.c.c.g.a {
        public C1114b(b bVar, int i2, int i3) {
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
            if (StringUtils.isNull(str) || ListUtils.isEmpty(b.this.f50783a) || ListUtils.isEmpty(b.this.f50786d)) {
                return;
            }
            Iterator it = b.this.f50783a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n nVar = (n) it.next();
                if (nVar instanceof d.a.j0.x.e0.b) {
                    d.a.j0.x.e0.b bVar = (d.a.j0.x.e0.b) nVar;
                    if (bVar.m() != null && bVar.m().w1() != null && bVar.m().w1().equals(str)) {
                        it.remove();
                        d.a.j0.a1.g.k.b.b(b.this.f50783a);
                        b.this.f50784b.z(new ArrayList(b.this.f50783a));
                        break;
                    }
                }
            }
            long f2 = d.a.c.e.m.b.f(str, 0L);
            Iterator it2 = b.this.f50786d.iterator();
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
        public long f50794e;

        /* renamed from: f  reason: collision with root package name */
        public long f50795f;

        public d(long j, long j2) {
            this.f50794e = j;
            this.f50795f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.f50787e);
            requestGetMyPostNetMessage.setParams(this.f50794e, this.f50795f, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public b(List<n> list, b0 b0Var) {
        this.f50783a = list;
        this.f50784b = b0Var;
    }

    public void g(List<ThreadInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f50785c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        if (this.f50788f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f50788f);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f50787e = bdUniqueId;
        this.f50789g.setTag(bdUniqueId);
        this.f50789g.setSelfListener(false);
        this.f50790h.setTag(bdUniqueId);
        this.f50790h.getHttpMessageListener().setSelfListener(true);
        this.f50790h.getSocketMessageListener().setSelfListener(true);
        this.f50791i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f50789g);
        MessageManager.getInstance().registerListener(this.f50790h);
        MessageManager.getInstance().registerListener(this.f50791i);
    }

    public void j(List<ThreadInfo> list) {
        this.f50786d = list;
    }
}
