package d.b.j0.q0.s1.a.c;

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
import d.b.c.j.e.n;
import d.b.j0.q0.s1.a.c.a;
import d.b.j0.q0.s1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements d.b.j0.q0.s1.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f60624a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f60625b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.q0.s1.a.d.b f60626c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f60627d;
    public long j;
    public d.b.j0.q0.s1.a.c.a l;

    /* renamed from: f  reason: collision with root package name */
    public int f60629f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f60630g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f60631h = 0;
    public boolean i = false;
    public Handler k = new Handler();
    public a.c m = new a();
    public d.b.c.c.g.a n = new C1525b(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.b.j0.q0.s1.a.a.c> f60628e = new HashMap<>();

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.b.j0.q0.s1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            if (b.this.f60627d == null || b.this.f60626c == null) {
                return;
            }
            b.this.f60626c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.b.j0.q0.s1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1525b extends d.b.c.c.g.a {
        public C1525b(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        @Override // d.b.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i;
            e eVar;
            d.b.j0.q0.s1.a.a.a aVar;
            if (responsedMessage == null) {
                return;
            }
            b.this.i = false;
            if (responsedMessage.hasError()) {
                if (b.this.f60626c != null) {
                    b.this.f60626c.b(b.this.f60629f, b.this.f60630g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (b.this.f60627d == null) {
                    b.this.f60627d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (b.this.f60627d == null) {
                    b.this.f60627d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i2 = b.this.f60629f;
            int i3 = b.this.f60630g;
            if (b.this.f60629f == 0 && b.this.f60630g == 0 && !ListUtils.isEmpty(b.this.f60627d) && (eVar = (e) b.this.f60627d.get(0)) != null) {
                i2 = eVar.f60642a;
                Object obj = eVar.f60644c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i3 = aVar.f60608a;
                    }
                }
            }
            String p = b.this.p(i2, i3);
            d.b.j0.q0.s1.a.a.c cVar = (d.b.j0.q0.s1.a.a.c) b.this.f60628e.get(p);
            if (cVar == null) {
                cVar = new d.b.j0.q0.s1.a.a.c();
                b.this.f60628e.put(p, cVar);
                b.this.f60628e.put(p, cVar);
            }
            cVar.f60617e = hasMore;
            cVar.f60618f = b.this.f60631h;
            if (!ListUtils.isEmpty(threadList)) {
                if (b.this.f60631h == 0) {
                    if (ListUtils.isEmpty(cVar.f60616d)) {
                        cVar.f60616d = threadList;
                    } else {
                        i = cVar.a(threadList);
                        if (b.this.f60626c == null) {
                            b.this.f60626c.a(b.this.f60629f, b.this.f60630g, cVar.f60616d, b.this.f60627d, cVar.f60617e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f60616d.addAll(threadList);
                }
            }
            i = -1;
            if (b.this.f60626c == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f60635f;

        public c(int i, int i2) {
            this.f60634e = i;
            this.f60635f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f60634e, this.f60635f);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f60638f;

        public d(int i, int i2) {
            this.f60637e = i;
            this.f60638f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d(this.f60637e, this.f60638f);
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.j = 0L;
        this.f60624a = context;
        this.f60625b = bdUniqueId;
        this.j = j;
        d.b.j0.q0.s1.a.c.a aVar = new d.b.j0.q0.s1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        d.b.j0.d3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.b.j0.d3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // d.b.j0.q0.s1.a.d.a
    public e a(int i) {
        if (ListUtils.isEmpty(this.f60627d)) {
            return null;
        }
        for (e eVar : this.f60627d) {
            if (eVar != null && eVar.f60642a == i) {
                return eVar;
            }
        }
        return null;
    }

    @Override // d.b.j0.q0.s1.a.d.a
    public void b(int i, int i2) {
        if (this.i) {
            this.k.postDelayed(new c(i, i2), 1000L);
            return;
        }
        this.f60629f = i;
        this.f60630g = i2;
        if (i == 0 && i2 == 0) {
            this.l.c(String.valueOf(this.j));
        } else {
            String p = p(i, i2);
            d.b.j0.q0.s1.a.a.c cVar = this.f60628e.get(p);
            if (cVar == null) {
                cVar = new d.b.j0.q0.s1.a.a.c();
                this.f60628e.put(p, cVar);
            }
            cVar.f60613a = p;
            cVar.f60614b = this.f60629f;
            cVar.f60615c = this.f60630g;
            cVar.f60618f = 0;
            cVar.f60617e = true;
        }
        this.f60631h = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f60629f, this.f60630g);
        frsGameStrategyRequestMessage.setTag(this.f60625b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.i = true;
    }

    @Override // d.b.j0.q0.s1.a.d.a
    public boolean c(int i, int i2) {
        d.b.j0.q0.s1.a.a.c q = q(i, i2);
        if (q == null || ListUtils.isEmpty(q.f60616d)) {
            return false;
        }
        d.b.j0.q0.s1.a.d.b bVar = this.f60626c;
        if (bVar != null) {
            bVar.a(i, i2, q.f60616d, this.f60627d, q.f60617e, false, -1);
            return true;
        }
        return true;
    }

    @Override // d.b.j0.q0.s1.a.d.a
    public void d(int i, int i2) {
        d.b.j0.q0.s1.a.a.a aVar;
        if (this.i) {
            this.k.postDelayed(new d(i, i2), 1000L);
            return;
        }
        this.f60629f = i;
        if (i == 0 && i2 == 0) {
            e o = o(i);
            if (o != null) {
                Object obj = o.f60644c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        this.f60630g = aVar.f60608a;
                    }
                }
            }
        } else {
            this.f60630g = i2;
        }
        String p = p(i, i2);
        d.b.j0.q0.s1.a.a.c cVar = this.f60628e.get(p);
        if (cVar == null) {
            cVar = new d.b.j0.q0.s1.a.a.c();
            this.f60628e.put(p, cVar);
            cVar.f60617e = true;
            this.f60628e.put(p, cVar);
        }
        int i3 = cVar.f60618f + 1;
        this.f60631h = i3;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f60629f, this.f60630g);
        frsGameStrategyRequestMessage.setTag(this.f60625b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.i = true;
    }

    @Override // d.b.j0.q0.s1.a.d.a
    public String h() {
        return String.valueOf(this.j);
    }

    public final e o(int i) {
        if (ListUtils.isEmpty(this.f60627d)) {
            return null;
        }
        for (e eVar : this.f60627d) {
            if (eVar != null && eVar.f60642a == i) {
                return eVar;
            }
        }
        return null;
    }

    public final String p(int i, int i2) {
        return i + "_" + i2;
    }

    public d.b.j0.q0.s1.a.a.c q(int i, int i2) {
        return this.f60628e.get(p(i, i2));
    }

    public void r() {
        this.k.removeCallbacksAndMessages(null);
    }

    public final void s() {
        this.n.setTag(this.f60625b);
        MessageManager.getInstance().registerListener(this.n);
    }

    public void u(d.b.j0.q0.s1.a.d.b bVar) {
        this.f60626c = bVar;
    }
}
