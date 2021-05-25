package d.a.n0.r0.s1.a.c;

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
import d.a.c.j.e.n;
import d.a.n0.r0.s1.a.c.a;
import d.a.n0.r0.s1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements d.a.n0.r0.s1.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f59612a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f59613b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r0.s1.a.d.b f59614c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f59615d;
    public long j;
    public d.a.n0.r0.s1.a.c.a l;

    /* renamed from: f  reason: collision with root package name */
    public int f59617f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f59618g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f59619h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59620i = false;
    public Handler k = new Handler();
    public a.c m = new a();
    public d.a.c.c.g.a n = new C1551b(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.a.n0.r0.s1.a.a.c> f59616e = new HashMap<>();

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.a.n0.r0.s1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            if (b.this.f59615d == null || b.this.f59614c == null) {
                return;
            }
            b.this.f59614c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.a.n0.r0.s1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1551b extends d.a.c.c.g.a {
        public C1551b(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i2;
            e eVar;
            d.a.n0.r0.s1.a.a.a aVar;
            if (responsedMessage == null) {
                return;
            }
            b.this.f59620i = false;
            if (responsedMessage.hasError()) {
                if (b.this.f59614c != null) {
                    b.this.f59614c.b(b.this.f59617f, b.this.f59618g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (b.this.f59615d == null) {
                    b.this.f59615d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (b.this.f59615d == null) {
                    b.this.f59615d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = b.this.f59617f;
            int i4 = b.this.f59618g;
            if (b.this.f59617f == 0 && b.this.f59618g == 0 && !ListUtils.isEmpty(b.this.f59615d) && (eVar = (e) b.this.f59615d.get(0)) != null) {
                i3 = eVar.f59632a;
                Object obj = eVar.f59634c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f59596a;
                    }
                }
            }
            String p = b.this.p(i3, i4);
            d.a.n0.r0.s1.a.a.c cVar = (d.a.n0.r0.s1.a.a.c) b.this.f59616e.get(p);
            if (cVar == null) {
                cVar = new d.a.n0.r0.s1.a.a.c();
                b.this.f59616e.put(p, cVar);
                b.this.f59616e.put(p, cVar);
            }
            cVar.f59605e = hasMore;
            cVar.f59606f = b.this.f59619h;
            if (!ListUtils.isEmpty(threadList)) {
                if (b.this.f59619h == 0) {
                    if (ListUtils.isEmpty(cVar.f59604d)) {
                        cVar.f59604d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (b.this.f59614c == null) {
                            b.this.f59614c.a(b.this.f59617f, b.this.f59618g, cVar.f59604d, b.this.f59615d, cVar.f59605e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f59604d.addAll(threadList);
                }
            }
            i2 = -1;
            if (b.this.f59614c == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59624f;

        public c(int i2, int i3) {
            this.f59623e = i2;
            this.f59624f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f59623e, this.f59624f);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59627f;

        public d(int i2, int i3) {
            this.f59626e = i2;
            this.f59627f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c(this.f59626e, this.f59627f);
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.j = 0L;
        this.f59612a = context;
        this.f59613b = bdUniqueId;
        this.j = j;
        d.a.n0.r0.s1.a.c.a aVar = new d.a.n0.r0.s1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        d.a.n0.e3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.a.n0.e3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // d.a.n0.r0.s1.a.d.a
    public e a(int i2) {
        if (ListUtils.isEmpty(this.f59615d)) {
            return null;
        }
        for (e eVar : this.f59615d) {
            if (eVar != null && eVar.f59632a == i2) {
                return eVar;
            }
        }
        return null;
    }

    @Override // d.a.n0.r0.s1.a.d.a
    public void b(int i2, int i3) {
        if (this.f59620i) {
            this.k.postDelayed(new c(i2, i3), 1000L);
            return;
        }
        this.f59617f = i2;
        this.f59618g = i3;
        if (i2 == 0 && i3 == 0) {
            this.l.c(String.valueOf(this.j));
        } else {
            String p = p(i2, i3);
            d.a.n0.r0.s1.a.a.c cVar = this.f59616e.get(p);
            if (cVar == null) {
                cVar = new d.a.n0.r0.s1.a.a.c();
                this.f59616e.put(p, cVar);
            }
            cVar.f59601a = p;
            cVar.f59602b = this.f59617f;
            cVar.f59603c = this.f59618g;
            cVar.f59606f = 0;
            cVar.f59605e = true;
        }
        this.f59619h = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f59617f, this.f59618g);
        frsGameStrategyRequestMessage.setTag(this.f59613b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.f59620i = true;
    }

    @Override // d.a.n0.r0.s1.a.d.a
    public void c(int i2, int i3) {
        d.a.n0.r0.s1.a.a.a aVar;
        if (this.f59620i) {
            this.k.postDelayed(new d(i2, i3), 1000L);
            return;
        }
        this.f59617f = i2;
        if (i2 == 0 && i3 == 0) {
            e o = o(i2);
            if (o != null) {
                Object obj = o.f59634c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        this.f59618g = aVar.f59596a;
                    }
                }
            }
        } else {
            this.f59618g = i3;
        }
        String p = p(i2, i3);
        d.a.n0.r0.s1.a.a.c cVar = this.f59616e.get(p);
        if (cVar == null) {
            cVar = new d.a.n0.r0.s1.a.a.c();
            this.f59616e.put(p, cVar);
            cVar.f59605e = true;
            this.f59616e.put(p, cVar);
        }
        int i4 = cVar.f59606f + 1;
        this.f59619h = i4;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f59617f, this.f59618g);
        frsGameStrategyRequestMessage.setTag(this.f59613b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.f59620i = true;
    }

    @Override // d.a.n0.r0.s1.a.d.a
    public boolean d(int i2, int i3) {
        d.a.n0.r0.s1.a.a.c q = q(i2, i3);
        if (q == null || ListUtils.isEmpty(q.f59604d)) {
            return false;
        }
        d.a.n0.r0.s1.a.d.b bVar = this.f59614c;
        if (bVar != null) {
            bVar.a(i2, i3, q.f59604d, this.f59615d, q.f59605e, false, -1);
            return true;
        }
        return true;
    }

    @Override // d.a.n0.r0.s1.a.d.a
    public String h() {
        return String.valueOf(this.j);
    }

    public final e o(int i2) {
        if (ListUtils.isEmpty(this.f59615d)) {
            return null;
        }
        for (e eVar : this.f59615d) {
            if (eVar != null && eVar.f59632a == i2) {
                return eVar;
            }
        }
        return null;
    }

    public final String p(int i2, int i3) {
        return i2 + "_" + i3;
    }

    public d.a.n0.r0.s1.a.a.c q(int i2, int i3) {
        return this.f59616e.get(p(i2, i3));
    }

    public void r() {
        this.k.removeCallbacksAndMessages(null);
    }

    public final void s() {
        this.n.setTag(this.f59613b);
        MessageManager.getInstance().registerListener(this.n);
    }

    public void u(d.a.n0.r0.s1.a.d.b bVar) {
        this.f59614c = bVar;
    }
}
