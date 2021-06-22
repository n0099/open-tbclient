package d.a.o0.r0.s1.a.c;

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
import d.a.c.k.e.n;
import d.a.o0.r0.s1.a.c.a;
import d.a.o0.r0.s1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements d.a.o0.r0.s1.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f63428a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63429b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.r0.s1.a.d.b f63430c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f63431d;
    public long j;
    public d.a.o0.r0.s1.a.c.a l;

    /* renamed from: f  reason: collision with root package name */
    public int f63433f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63434g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f63435h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63436i = false;
    public Handler k = new Handler();
    public a.c m = new a();
    public d.a.c.c.g.a n = new C1611b(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.a.o0.r0.s1.a.a.c> f63432e = new HashMap<>();

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.a.o0.r0.s1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            if (b.this.f63431d == null || b.this.f63430c == null) {
                return;
            }
            b.this.f63430c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.a.o0.r0.s1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1611b extends d.a.c.c.g.a {
        public C1611b(int i2, int i3) {
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
            d.a.o0.r0.s1.a.a.a aVar;
            if (responsedMessage == null) {
                return;
            }
            b.this.f63436i = false;
            if (responsedMessage.hasError()) {
                if (b.this.f63430c != null) {
                    b.this.f63430c.b(b.this.f63433f, b.this.f63434g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (b.this.f63431d == null) {
                    b.this.f63431d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (b.this.f63431d == null) {
                    b.this.f63431d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = b.this.f63433f;
            int i4 = b.this.f63434g;
            if (b.this.f63433f == 0 && b.this.f63434g == 0 && !ListUtils.isEmpty(b.this.f63431d) && (eVar = (e) b.this.f63431d.get(0)) != null) {
                i3 = eVar.f63448a;
                Object obj = eVar.f63450c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f63412a;
                    }
                }
            }
            String p = b.this.p(i3, i4);
            d.a.o0.r0.s1.a.a.c cVar = (d.a.o0.r0.s1.a.a.c) b.this.f63432e.get(p);
            if (cVar == null) {
                cVar = new d.a.o0.r0.s1.a.a.c();
                b.this.f63432e.put(p, cVar);
                b.this.f63432e.put(p, cVar);
            }
            cVar.f63421e = hasMore;
            cVar.f63422f = b.this.f63435h;
            if (!ListUtils.isEmpty(threadList)) {
                if (b.this.f63435h == 0) {
                    if (ListUtils.isEmpty(cVar.f63420d)) {
                        cVar.f63420d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (b.this.f63430c == null) {
                            b.this.f63430c.a(b.this.f63433f, b.this.f63434g, cVar.f63420d, b.this.f63431d, cVar.f63421e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f63420d.addAll(threadList);
                }
            }
            i2 = -1;
            if (b.this.f63430c == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63439e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63440f;

        public c(int i2, int i3) {
            this.f63439e = i2;
            this.f63440f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f63439e, this.f63440f);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63442e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63443f;

        public d(int i2, int i3) {
            this.f63442e = i2;
            this.f63443f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c(this.f63442e, this.f63443f);
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.j = 0L;
        this.f63428a = context;
        this.f63429b = bdUniqueId;
        this.j = j;
        d.a.o0.r0.s1.a.c.a aVar = new d.a.o0.r0.s1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        d.a.o0.e3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.a.o0.e3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // d.a.o0.r0.s1.a.d.a
    public e a(int i2) {
        if (ListUtils.isEmpty(this.f63431d)) {
            return null;
        }
        for (e eVar : this.f63431d) {
            if (eVar != null && eVar.f63448a == i2) {
                return eVar;
            }
        }
        return null;
    }

    @Override // d.a.o0.r0.s1.a.d.a
    public void b(int i2, int i3) {
        if (this.f63436i) {
            this.k.postDelayed(new c(i2, i3), 1000L);
            return;
        }
        this.f63433f = i2;
        this.f63434g = i3;
        if (i2 == 0 && i3 == 0) {
            this.l.c(String.valueOf(this.j));
        } else {
            String p = p(i2, i3);
            d.a.o0.r0.s1.a.a.c cVar = this.f63432e.get(p);
            if (cVar == null) {
                cVar = new d.a.o0.r0.s1.a.a.c();
                this.f63432e.put(p, cVar);
            }
            cVar.f63417a = p;
            cVar.f63418b = this.f63433f;
            cVar.f63419c = this.f63434g;
            cVar.f63422f = 0;
            cVar.f63421e = true;
        }
        this.f63435h = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f63433f, this.f63434g);
        frsGameStrategyRequestMessage.setTag(this.f63429b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.f63436i = true;
    }

    @Override // d.a.o0.r0.s1.a.d.a
    public void c(int i2, int i3) {
        d.a.o0.r0.s1.a.a.a aVar;
        if (this.f63436i) {
            this.k.postDelayed(new d(i2, i3), 1000L);
            return;
        }
        this.f63433f = i2;
        if (i2 == 0 && i3 == 0) {
            e o = o(i2);
            if (o != null) {
                Object obj = o.f63450c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        this.f63434g = aVar.f63412a;
                    }
                }
            }
        } else {
            this.f63434g = i3;
        }
        String p = p(i2, i3);
        d.a.o0.r0.s1.a.a.c cVar = this.f63432e.get(p);
        if (cVar == null) {
            cVar = new d.a.o0.r0.s1.a.a.c();
            this.f63432e.put(p, cVar);
            cVar.f63421e = true;
            this.f63432e.put(p, cVar);
        }
        int i4 = cVar.f63422f + 1;
        this.f63435h = i4;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f63433f, this.f63434g);
        frsGameStrategyRequestMessage.setTag(this.f63429b);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.f63436i = true;
    }

    @Override // d.a.o0.r0.s1.a.d.a
    public boolean d(int i2, int i3) {
        d.a.o0.r0.s1.a.a.c q = q(i2, i3);
        if (q == null || ListUtils.isEmpty(q.f63420d)) {
            return false;
        }
        d.a.o0.r0.s1.a.d.b bVar = this.f63430c;
        if (bVar != null) {
            bVar.a(i2, i3, q.f63420d, this.f63431d, q.f63421e, false, -1);
            return true;
        }
        return true;
    }

    @Override // d.a.o0.r0.s1.a.d.a
    public String i() {
        return String.valueOf(this.j);
    }

    public final e o(int i2) {
        if (ListUtils.isEmpty(this.f63431d)) {
            return null;
        }
        for (e eVar : this.f63431d) {
            if (eVar != null && eVar.f63448a == i2) {
                return eVar;
            }
        }
        return null;
    }

    public final String p(int i2, int i3) {
        return i2 + "_" + i3;
    }

    public d.a.o0.r0.s1.a.a.c q(int i2, int i3) {
        return this.f63432e.get(p(i2, i3));
    }

    public void r() {
        this.k.removeCallbacksAndMessages(null);
    }

    public final void s() {
        this.n.setTag(this.f63429b);
        MessageManager.getInstance().registerListener(this.n);
    }

    public void u(d.a.o0.r0.s1.a.d.b bVar) {
        this.f63430c = bVar;
    }
}
