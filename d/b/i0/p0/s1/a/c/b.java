package d.b.i0.p0.s1.a.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import d.b.b.j.e.n;
import d.b.i0.p0.s1.a.c.a;
import d.b.i0.p0.s1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements d.b.i0.p0.s1.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f58535a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f58536b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.p0.s1.a.d.b f58537c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f58538d;
    public long j;
    public d.b.i0.p0.s1.a.c.a l;

    /* renamed from: f  reason: collision with root package name */
    public int f58540f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f58541g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f58542h = 0;
    public boolean i = false;
    public Handler k = new Handler();
    public a.c m = new a();
    public d.b.b.c.g.a n = new C1439b(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.b.i0.p0.s1.a.a.c> f58539e = new HashMap<>();

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.b.i0.p0.s1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            if (b.this.f58538d == null || b.this.f58537c == null) {
                return;
            }
            b.this.f58537c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.b.i0.p0.s1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1439b extends d.b.b.c.g.a {
        public C1439b(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        @Override // d.b.b.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i;
            e eVar;
            d.b.i0.p0.s1.a.a.a aVar;
            if (responsedMessage == null) {
                return;
            }
            b.this.i = false;
            if (responsedMessage.hasError()) {
                if (b.this.f58537c != null) {
                    b.this.f58537c.b(b.this.f58540f, b.this.f58541g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (b.this.f58538d == null) {
                    b.this.f58538d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (b.this.f58538d == null) {
                    b.this.f58538d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i2 = b.this.f58540f;
            int i3 = b.this.f58541g;
            if (b.this.f58540f == 0 && b.this.f58541g == 0 && !ListUtils.isEmpty(b.this.f58538d) && (eVar = (e) b.this.f58538d.get(0)) != null) {
                i2 = eVar.f58553a;
                Object obj = eVar.f58555c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i3 = aVar.f58519a;
                    }
                }
            }
            String p = b.this.p(i2, i3);
            d.b.i0.p0.s1.a.a.c cVar = (d.b.i0.p0.s1.a.a.c) b.this.f58539e.get(p);
            if (cVar == null) {
                cVar = new d.b.i0.p0.s1.a.a.c();
                b.this.f58539e.put(p, cVar);
                b.this.f58539e.put(p, cVar);
            }
            cVar.f58528e = hasMore;
            cVar.f58529f = b.this.f58542h;
            if (!ListUtils.isEmpty(threadList)) {
                if (b.this.f58542h == 0) {
                    if (ListUtils.isEmpty(cVar.f58527d)) {
                        cVar.f58527d = threadList;
                    } else {
                        i = cVar.a(threadList);
                        if (b.this.f58537c == null) {
                            b.this.f58537c.a(b.this.f58540f, b.this.f58541g, cVar.f58527d, b.this.f58538d, cVar.f58528e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f58527d.addAll(threadList);
                }
            }
            i = -1;
            if (b.this.f58537c == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58545e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58546f;

        public c(int i, int i2) {
            this.f58545e = i;
            this.f58546f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f58545e, this.f58546f);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58549f;

        public d(int i, int i2) {
            this.f58548e = i;
            this.f58549f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d(this.f58548e, this.f58549f);
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.j = 0L;
        this.f58535a = context;
        this.f58536b = bdUniqueId;
        this.j = j;
        d.b.i0.p0.s1.a.c.a aVar = new d.b.i0.p0.s1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        d.b.i0.c3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.b.i0.c3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // d.b.i0.p0.s1.a.d.a
    public e a(int i) {
        if (ListUtils.isEmpty(this.f58538d)) {
            return null;
        }
        for (e eVar : this.f58538d) {
            if (eVar != null && eVar.f58553a == i) {
                return eVar;
            }
        }
        return null;
    }

    @Override // d.b.i0.p0.s1.a.d.a
    public void b(int i, int i2) {
        if (this.i) {
            this.k.postDelayed(new c(i, i2), 1000L);
            return;
        }
        this.f58540f = i;
        this.f58541g = i2;
        if (i == 0 && i2 == 0) {
            this.l.c(String.valueOf(this.j));
        } else {
            String p = p(i, i2);
            d.b.i0.p0.s1.a.a.c cVar = this.f58539e.get(p);
            if (cVar == null) {
                cVar = new d.b.i0.p0.s1.a.a.c();
                this.f58539e.put(p, cVar);
            }
            cVar.f58524a = p;
            cVar.f58525b = this.f58540f;
            cVar.f58526c = this.f58541g;
            cVar.f58529f = 0;
            cVar.f58528e = true;
        }
        this.f58542h = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f58540f, this.f58541g);
        frsGameStrategyRequestMessage.setTag(this.f58536b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.i = true;
    }

    @Override // d.b.i0.p0.s1.a.d.a
    public boolean c(int i, int i2) {
        d.b.i0.p0.s1.a.a.c q = q(i, i2);
        if (q == null || ListUtils.isEmpty(q.f58527d)) {
            return false;
        }
        d.b.i0.p0.s1.a.d.b bVar = this.f58537c;
        if (bVar != null) {
            bVar.a(i, i2, q.f58527d, this.f58538d, q.f58528e, false, -1);
            return true;
        }
        return true;
    }

    @Override // d.b.i0.p0.s1.a.d.a
    public void d(int i, int i2) {
        d.b.i0.p0.s1.a.a.a aVar;
        if (this.i) {
            this.k.postDelayed(new d(i, i2), 1000L);
            return;
        }
        this.f58540f = i;
        if (i == 0 && i2 == 0) {
            e o = o(i);
            if (o != null) {
                Object obj = o.f58555c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        this.f58541g = aVar.f58519a;
                    }
                }
            }
        } else {
            this.f58541g = i2;
        }
        String p = p(i, i2);
        d.b.i0.p0.s1.a.a.c cVar = this.f58539e.get(p);
        if (cVar == null) {
            cVar = new d.b.i0.p0.s1.a.a.c();
            this.f58539e.put(p, cVar);
            cVar.f58528e = true;
            this.f58539e.put(p, cVar);
        }
        int i3 = cVar.f58529f + 1;
        this.f58542h = i3;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f58540f, this.f58541g);
        frsGameStrategyRequestMessage.setTag(this.f58536b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.i = true;
    }

    @Override // d.b.i0.p0.s1.a.d.a
    public String h() {
        return String.valueOf(this.j);
    }

    public final e o(int i) {
        if (ListUtils.isEmpty(this.f58538d)) {
            return null;
        }
        for (e eVar : this.f58538d) {
            if (eVar != null && eVar.f58553a == i) {
                return eVar;
            }
        }
        return null;
    }

    public final String p(int i, int i2) {
        return i + "_" + i2;
    }

    public d.b.i0.p0.s1.a.a.c q(int i, int i2) {
        return this.f58539e.get(p(i, i2));
    }

    public void r() {
        this.k.removeCallbacksAndMessages(null);
    }

    public final void s() {
        this.n.setTag(this.f58536b);
        MessageManager.getInstance().registerListener(this.n);
    }

    public void u(d.b.i0.p0.s1.a.d.b bVar) {
        this.f58537c = bVar;
    }
}
