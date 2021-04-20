package d.b.h0.a;

import android.util.Pair;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import d.b.h0.a.b0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f49925a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<d.b.h0.a.b>> f49926b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d.b.h0.a.b> f49927c;

    /* renamed from: d  reason: collision with root package name */
    public f f49928d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f49929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49930f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49931g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f49932h;
    public d.b.h0.a.b0.d i;
    public d.b.h0.a.z.c j;
    public d.b.h0.a.a0.b k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public d.b.h0.a.z.a<d.b.h0.a.z.b> t;
    public d.b.h0.m.b u;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.f49930f = true;
            if (c.this.f49927c.isEmpty()) {
                return;
            }
            Iterator it = c.this.f49927c.iterator();
            while (it.hasNext()) {
                c.this.m((d.b.h0.a.b) it.next());
            }
            c.this.f49927c.clear();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                c.this.q();
            }
        }
    }

    /* renamed from: d.b.h0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1053c extends CustomMessageListener {
        public C1053c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            c.this.f49931g = true;
            c.this.q();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.h0.a.z.a<d.b.h0.a.z.b> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.z.a
        /* renamed from: b */
        public void a(d.b.h0.a.z.b bVar) {
            ActiveCenterData activeCenterData;
            if (bVar == null || (activeCenterData = bVar.f50059g) == null || activeCenterData.mission == null) {
                return;
            }
            d.b.h0.a.b bVar2 = new d.b.h0.a.b();
            bVar2.O(bVar.f50059g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar2);
            c.this.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.a
        /* renamed from: c */
        public void onSuccess(d.b.h0.a.z.b bVar) {
            if (bVar != null) {
                c.this.n(bVar.b());
            }
        }

        @Override // d.b.h0.m.a
        public void onError(int i, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.h0.m.b<d.b.h0.a.b> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.b
        /* renamed from: b */
        public void a(d.b.h0.a.b bVar) {
            if (bVar == null) {
                return;
            }
            d.b.h0.a.b w = c.this.w(bVar);
            if (w != null && w.z) {
                w.R();
                c.this.S(w);
                return;
            }
            n.b().h(w);
            if (w != null && w.x() == 7) {
                w.H();
                int F = w.F();
                int w2 = w.w();
                if (F <= 1 || F <= w2) {
                    c.this.G(w);
                } else {
                    c.this.S(w);
                }
            } else if (w == null || w.x() != 8) {
                c.this.G(bVar);
            } else {
                c.this.G(w);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BdAsyncTask<d.b.h0.a.b, Integer, Void> {
        public g(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.b.h0.a.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            d.b.h0.a.a.g().a(bVarArr[0]);
            return null;
        }

        public /* synthetic */ g(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<List<d.b.h0.a.b>, Integer, Void> {
        public h(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<d.b.h0.a.b>... listArr) {
            if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                return null;
            }
            d.b.h0.a.a.g().b(listArr[0]);
            return null;
        }

        public /* synthetic */ h(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<d.b.h0.a.b, Integer, Void> {
        public i(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.b.h0.a.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            d.b.h0.a.a.g().e(bVarArr[0]);
            return null;
        }

        public /* synthetic */ i(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<Pair<d.b.h0.a.b, d.b.h0.a.b>, Integer, Pair<d.b.h0.a.b, d.b.h0.a.b>> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<d.b.h0.a.b, d.b.h0.a.b> doInBackground(Pair<d.b.h0.a.b, d.b.h0.a.b>... pairArr) {
            if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                return null;
            }
            Pair<d.b.h0.a.b, d.b.h0.a.b> pair = pairArr[0];
            d.b.h0.a.b bVar = (d.b.h0.a.b) pair.first;
            d.b.h0.a.b bVar2 = (d.b.h0.a.b) pair.second;
            if (bVar2 != null) {
                d.b.h0.a.a.g().e(bVar2);
            }
            if (bVar != null) {
                d.b.h0.a.a.g().a(bVar);
                return pair;
            }
            return pair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<d.b.h0.a.b, d.b.h0.a.b> pair) {
            if (pair != null) {
                d.b.h0.a.b bVar = (d.b.h0.a.b) pair.first;
                d.b.h0.a.b bVar2 = (d.b.h0.a.b) pair.second;
                if (bVar2 != null) {
                    c.this.v(bVar2);
                }
                if (bVar != null) {
                    c.this.J(bVar);
                }
            }
        }

        public /* synthetic */ j(c cVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<d.b.h0.a.b>> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<d.b.h0.a.b> doInBackground(Void... voidArr) {
            LinkedList<d.b.h0.a.b> linkedList = new LinkedList<>();
            linkedList.addAll(d.b.h0.a.a.g().f());
            Iterator<d.b.h0.a.b> it = linkedList.iterator();
            while (it.hasNext()) {
                d.b.h0.a.b next = it.next();
                if (next != null && next.M()) {
                    d.b.h0.a.a.g().e(next);
                    it.remove();
                } else if (next.x() == 7) {
                    next.n0();
                    d.b.h0.a.a.g().i(next);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<d.b.h0.a.b> linkedList) {
            super.onPostExecute(linkedList);
            if (linkedList == null) {
                return;
            }
            if (!linkedList.isEmpty()) {
                Iterator<d.b.h0.a.b> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.b.h0.a.b next = it.next();
                    if (next.h() != null) {
                        c.this.J(next);
                    }
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
        }

        public /* synthetic */ k(c cVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f49944a = new c(null);
    }

    /* loaded from: classes3.dex */
    public class m extends BdAsyncTask<d.b.h0.a.b, Integer, d.b.h0.a.b> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.b.h0.a.b doInBackground(d.b.h0.a.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            d.b.h0.a.b bVar = bVarArr[0];
            d.b.h0.a.a.g().i(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.b.h0.a.b bVar) {
            if (bVar == null || !bVar.z) {
                return;
            }
            bVar.z = false;
            c cVar = c.this;
            cVar.P(cVar.l, c.this.m);
        }

        public /* synthetic */ m(c cVar, a aVar) {
            this();
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static final c y() {
        return l.f49944a;
    }

    public boolean A() {
        return !s();
    }

    public final boolean B() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public final boolean C(d.b.h0.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] h2 = bVar.h();
        if (h2 == null) {
            return true;
        }
        for (int i2 : h2) {
            List<d.b.h0.a.b> list = this.f49926b.get(i2);
            if (list == null) {
                return false;
            }
            for (d.b.h0.a.b bVar2 : list) {
                if (bVar2 != null && bVar2.d() == bVar.d() && bVar2.q() == bVar.q()) {
                    if (bVar2.M()) {
                        H(bVar, bVar2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean D() {
        return this.p;
    }

    public void E() {
        this.f49929e.compareAndSet(true, false);
        this.f49928d.f(0);
        this.f49928d.h(0L);
        this.f49928d.g(0L);
        d.b.h0.a.b0.d dVar = this.i;
        if (dVar != null) {
            dVar.m();
        }
    }

    public void F() {
        List<d.b.h0.a.b> list = this.f49926b.get(d.b.h0.a.b.V);
        if (ListUtils.isEmpty(list)) {
            return;
        }
        boolean z = false;
        for (d.b.h0.a.b bVar : list) {
            Iterator<d.b.h0.a.h> it = bVar.n().iterator();
            while (it.hasNext()) {
                d.b.h0.a.h next = it.next();
                if (next instanceof d.b.h0.a.l) {
                    d.b.h0.a.l lVar = (d.b.h0.a.l) next;
                    if (!next.e()) {
                        lVar.i();
                        z = true;
                    }
                }
            }
        }
        if (!z || this.f49929e.get()) {
            return;
        }
        this.f49928d.f(d.b.h0.a.b.V);
        this.f49929e.compareAndSet(false, true);
        synchronized (this.f49929e) {
            this.f49929e.notify();
        }
    }

    public final void G(d.b.h0.a.b bVar) {
        v(bVar);
        new i(this, null).execute(bVar);
    }

    public final void H(d.b.h0.a.b bVar, d.b.h0.a.b bVar2) {
        v(bVar2);
        new j(this, null).execute(new Pair(bVar, bVar2));
    }

    public boolean I() {
        if (this.j != null && B()) {
            this.j.f(A(), D(), 1);
            return true;
        }
        return false;
    }

    public final void J(d.b.h0.a.b bVar) {
        int[] h2;
        for (int i2 : bVar.h()) {
            List<d.b.h0.a.b> list = this.f49926b.get(i2);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.f49926b.put(i2, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    public void K(int i2, long j2) {
        if (B()) {
            this.n = i2;
            long j3 = this.m;
            if (j3 > 0 && this.l > 0 && (j2 == 0 || j2 != j3)) {
                R(this.l, this.m);
                this.m = 0L;
                this.l = 0;
            }
            M();
        }
    }

    public void L(boolean z) {
        this.p = z;
    }

    public void M() {
        int i2;
        List<d.b.h0.a.b> list;
        if (B() && this.f49930f && (list = this.f49926b.get((i2 = d.b.h0.a.b.V))) != null && !list.isEmpty()) {
            boolean z = false;
            for (d.b.h0.a.b bVar : list) {
                if (bVar.x() == 8) {
                    Iterator<d.b.h0.a.h> it = bVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.b.h0.a.h next = it.next();
                        d.b.h0.a.b c2 = next.c();
                        if (c2 != null && (next instanceof d.b.h0.a.l) && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                            ((d.b.h0.a.l) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.b.h0.a.l lVar = new d.b.h0.a.l(bVar);
                        lVar.g(0L);
                        lVar.f(false);
                        bVar.a(lVar);
                    }
                }
            }
            this.f49928d.f(i2);
            this.f49929e.compareAndSet(false, true);
            synchronized (this.f49929e) {
                this.f49929e.notify();
            }
        }
    }

    public void N(int i2) {
        if (B() && i2 != 0 && this.f49930f) {
            this.l = i2;
            List<d.b.h0.a.b> list = this.f49926b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.b.h0.a.b bVar : list) {
                if (bVar.x() == 4) {
                    Iterator<d.b.h0.a.h> it = bVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.b.h0.a.h next = it.next();
                        if ((next instanceof d.b.h0.a.i) && next.c().d() == bVar.d() && next.c().q() == bVar.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.b.h0.a.i iVar = new d.b.h0.a.i(bVar);
                        iVar.g(0L);
                        iVar.f(false);
                        bVar.a(iVar);
                    }
                }
            }
            this.f49928d.f(i2);
            this.f49929e.compareAndSet(false, true);
            synchronized (this.f49929e) {
                this.f49929e.notify();
            }
        }
    }

    public void O(int i2, long j2) {
        if (B() && i2 != 0 && j2 != 0 && this.f49930f) {
            this.l = i2;
            List<d.b.h0.a.b> list = this.f49926b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.b.h0.a.b bVar : list) {
                if (bVar.x() == 2) {
                    Iterator<d.b.h0.a.h> it = bVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.b.h0.a.h next = it.next();
                        if ((next instanceof d.b.h0.a.j) && next.c().d() == bVar.d() && next.c().q() == bVar.q() && ((d.b.h0.a.j) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.b.h0.a.j jVar = new d.b.h0.a.j(bVar, j2);
                        jVar.g(0L);
                        jVar.f(false);
                        jVar.h(bVar.w());
                        bVar.a(jVar);
                    }
                }
            }
            this.f49928d.f(i2);
            this.f49928d.g(j2);
            this.f49929e.compareAndSet(false, true);
            synchronized (this.f49929e) {
                this.f49929e.notify();
            }
        }
    }

    public void P(int i2, long j2) {
        if (B() && i2 != 0 && j2 != 0 && this.f49930f) {
            this.l = i2;
            List<d.b.h0.a.b> list = this.f49926b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (d.b.h0.a.b bVar : list) {
                if (bVar.x() == 1) {
                    p(bVar, j2);
                } else if (bVar.x() != 7) {
                    continue;
                } else if (bVar.J(j2)) {
                    break;
                } else {
                    o(bVar, j2);
                }
            }
            this.f49928d.f(i2);
            this.f49928d.h(j2);
            this.m = j2;
            this.f49929e.compareAndSet(false, true);
            synchronized (this.f49929e) {
                this.f49929e.notify();
            }
        }
    }

    public final void Q() {
        this.f49925a.scheduleWithFixedDelay(this.f49928d, 0L, 1L, TimeUnit.SECONDS);
    }

    public void R(int i2, long j2) {
        d.b.h0.a.k kVar;
        d.b.h0.a.b c2;
        List<d.b.h0.a.b> list = this.f49926b.get(i2);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.b.h0.a.b bVar : list) {
            if (bVar.x() == 7) {
                Iterator<d.b.h0.a.h> it = bVar.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.b.h0.a.h next = it.next();
                        if ((next instanceof d.b.h0.a.k) && (c2 = (kVar = (d.b.h0.a.k) next).c()) != null && kVar.i() == j2 && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(d.b.h0.a.b bVar) {
        T(bVar);
        new m(this, null).execute(bVar);
    }

    public final void T(d.b.h0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        int x = bVar.x();
        Iterator<d.b.h0.a.h> it = bVar.n().iterator();
        while (it.hasNext()) {
            d.b.h0.a.h next = it.next();
            if (next != null && next.c() != null) {
                d.b.h0.a.b c2 = next.c();
                if (c2.d() == bVar.d() && c2.q() == bVar.q()) {
                    if (x == 7 && (next instanceof d.b.h0.a.k)) {
                        ((d.b.h0.a.k) next).f(true);
                    } else if (x == 1 && (next instanceof d.b.h0.a.m)) {
                        ((d.b.h0.a.m) next).f(true);
                    }
                }
            }
        }
        bVar.c0(false);
    }

    public void m(d.b.h0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.x() == 9) {
            p.c().f(bVar);
        } else if (!this.f49930f) {
            this.f49927c.add(bVar);
        } else if (C(bVar)) {
        } else {
            J(bVar);
            new g(this, null).execute(bVar);
        }
    }

    public void n(List<d.b.h0.a.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f49930f) {
            this.f49927c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.b.h0.a.b bVar : list) {
            if (bVar != null) {
                if (bVar.x() == 9) {
                    p.c().f(bVar);
                } else if (!C(bVar)) {
                    J(bVar);
                    arrayList.add(bVar);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(d.b.h0.a.b bVar, long j2) {
        boolean z;
        d.b.h0.a.k kVar;
        d.b.h0.a.b c2;
        Iterator<d.b.h0.a.h> it = bVar.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d.b.h0.a.h next = it.next();
            if ((next instanceof d.b.h0.a.k) && (c2 = (kVar = (d.b.h0.a.k) next).c()) != null && kVar.i() == j2 && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        d.b.h0.a.k kVar2 = new d.b.h0.a.k(bVar, j2);
        kVar2.g(0L);
        kVar2.f(false);
        kVar2.h(bVar.w());
        bVar.a(kVar2);
    }

    public final void p(d.b.h0.a.b bVar, long j2) {
        boolean z;
        d.b.h0.a.m mVar;
        d.b.h0.a.b c2;
        Iterator<d.b.h0.a.h> it = bVar.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d.b.h0.a.h next = it.next();
            if ((next instanceof d.b.h0.a.m) && (c2 = (mVar = (d.b.h0.a.m) next).c()) != null && mVar.i() == j2 && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        d.b.h0.a.m mVar2 = new d.b.h0.a.m(bVar, j2);
        mVar2.g(0L);
        mVar2.f(false);
        mVar2.h(bVar.w());
        bVar.a(mVar2);
    }

    public void q() {
        if (this.j != null && B() && this.f49931g && !t()) {
            this.j.f(A(), D(), 0);
        }
    }

    public void r() {
        if (this.k != null && B()) {
            this.k.d();
        }
    }

    public boolean s() {
        return UtilHelper.isSameDay(d.b.h0.r.d0.b.j().l("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean t() {
        return UtilHelper.isSameDay(z(), System.currentTimeMillis());
    }

    public boolean u() {
        return UtilHelper.isSameDay(d.b.h0.r.d0.b.j().l("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    public final void v(d.b.h0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        Iterator<d.b.h0.a.h> it = bVar.n().iterator();
        while (it.hasNext()) {
            d.b.h0.a.h next = it.next();
            if (next != null && next.c() != null) {
                d.b.h0.a.b c2 = next.c();
                if (c2.d() == bVar.d() && c2.q() == bVar.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.f49926b.size(); i2++) {
            List<d.b.h0.a.b> valueAt = this.f49926b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<d.b.h0.a.b> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    d.b.h0.a.b next2 = it2.next();
                    if (next2 != null && next2.d() == bVar.d() && next2.q() == bVar.q()) {
                        it2.remove();
                    }
                }
            }
        }
    }

    public final d.b.h0.a.b w(d.b.h0.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f49926b.size(); i2++) {
            List<d.b.h0.a.b> valueAt = this.f49926b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (d.b.h0.a.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.d() == bVar.d() && bVar2.q() == bVar.q()) {
                        return bVar2;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public int x() {
        return this.n;
    }

    public final long z() {
        long l2 = d.b.h0.r.d0.b.j().l("pref_key_active_config_info", 0L);
        this.o = l2;
        return l2;
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public volatile int f49938e;

        /* renamed from: f  reason: collision with root package name */
        public volatile long f49939f;

        /* renamed from: g  reason: collision with root package name */
        public volatile long f49940g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f49941h;

        public f() {
            this.f49941h = false;
        }

        public final void a(d.b.h0.a.b bVar, d.C1052d c1052d) {
            ArrayList<d.b.h0.a.h> n;
            if (bVar == null || c1052d == null || (n = bVar.n()) == null) {
                return;
            }
            Iterator<d.b.h0.a.h> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                d.b.h0.a.h next = it.next();
                if (next instanceof d.b.h0.a.m) {
                    d.b.h0.a.m mVar = (d.b.h0.a.m) next;
                    if (this.f49939f != 0 && mVar.i() == this.f49939f && !next.e()) {
                        this.f49941h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                c1052d.b(next);
                            }
                        }
                        c1052d.c(bVar);
                    }
                } else if (next instanceof d.b.h0.a.k) {
                    d.b.h0.a.k kVar = (d.b.h0.a.k) next;
                    if (!bVar.L() && kVar.d() == bVar.w()) {
                        if (this.f49939f != 0 && kVar.i() == this.f49939f && !next.e()) {
                            this.f49941h = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.f49939f != 0 && kVar.i() == this.f49939f && !next.e()) {
                            if (next.b() >= bVar.f()) {
                                next.f(true);
                                bVar.I();
                            }
                            c1052d.c(bVar);
                        }
                        int l = bVar.l();
                        int A = bVar.A();
                        if (i >= bVar.f() * bVar.A() && l >= A) {
                            c1052d.a(bVar);
                            bVar.c0(true);
                        }
                    }
                } else if (next instanceof d.b.h0.a.j) {
                    if (this.f49940g != 0 && ((d.b.h0.a.j) next).i() == this.f49940g && !next.e()) {
                        this.f49941h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                c1052d.b(next);
                            }
                        }
                    }
                } else if ((next instanceof d.b.h0.a.i) && !next.e()) {
                    this.f49941h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1052d.b(next);
                    }
                }
            }
        }

        public final void b(d.b.h0.a.b bVar, d.C1052d c1052d) {
            ArrayList<d.b.h0.a.h> n;
            if (bVar == null || c1052d == null || (n = bVar.n()) == null) {
                return;
            }
            Iterator<d.b.h0.a.h> it = n.iterator();
            while (it.hasNext()) {
                d.b.h0.a.h next = it.next();
                if ((next instanceof d.b.h0.a.l) && !((d.b.h0.a.l) next).j() && !next.e()) {
                    this.f49941h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1052d.a(bVar);
                    }
                    c1052d.c(bVar);
                }
            }
        }

        public final void c() {
            this.f49941h = true;
            List<d.b.h0.a.b> list = (List) c.this.f49926b.get(d.b.h0.a.b.V);
            List<d.b.h0.a.b> list2 = (List) c.this.f49926b.get(this.f49938e);
            if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                c.this.f49929e.compareAndSet(true, false);
                return;
            }
            d.C1052d c1052d = new d.C1052d();
            c1052d.f49919a = new LinkedList();
            c1052d.f49920b = new LinkedList();
            c1052d.f49921c = new LinkedList();
            d(list, c1052d);
            e(list2, c1052d);
            if (this.f49941h) {
                c.this.f49929e.compareAndSet(true, false);
            }
            if (!ListUtils.isEmpty(c1052d.f49921c)) {
                d.b.h0.a.a.g().k(c1052d.f49921c);
            }
            if (ListUtils.isEmpty(c1052d.f49919a) && ListUtils.isEmpty(c1052d.f49920b)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, c1052d));
        }

        public final void d(List<d.b.h0.a.b> list, d.C1052d c1052d) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (d.b.h0.a.b bVar : list) {
                b(bVar, c1052d);
            }
        }

        public final void e(List<d.b.h0.a.b> list, d.C1052d c1052d) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (d.b.h0.a.b bVar : list) {
                a(bVar, c1052d);
            }
        }

        public synchronized void f(int i) {
            this.f49938e = i;
        }

        public synchronized void g(long j) {
            this.f49940g = j;
        }

        public synchronized void h(long j) {
            this.f49939f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f49938e == 0 || !c.this.f49929e.get()) {
                synchronized (c.this.f49929e) {
                    try {
                        c.this.f49929e.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            c();
        }

        public /* synthetic */ f(c cVar, a aVar) {
            this();
        }
    }

    public c() {
        this.f49925a = Executors.newSingleThreadScheduledExecutor();
        this.f49926b = new SparseArray<>();
        this.f49927c = new LinkedList<>();
        this.f49928d = new f(this, null);
        this.f49929e = new AtomicBoolean(false);
        this.f49930f = false;
        this.f49931g = false;
        this.p = false;
        this.q = new a(2921391);
        this.r = new b(2001011);
        this.s = new C1053c(2001371);
        this.t = new d();
        this.u = new e();
        BdUniqueId gen = BdUniqueId.gen();
        this.f49932h = gen;
        d.b.h0.a.b0.d dVar = new d.b.h0.a.b0.d(gen);
        this.i = dVar;
        dVar.w(this.u);
        d.b.h0.a.z.c cVar = new d.b.h0.a.z.c(this.f49932h);
        this.j = cVar;
        cVar.g(this.t);
        this.k = new d.b.h0.a.a0.b(this.f49932h);
        this.s.setTag(this.f49932h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.f49932h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.f49932h);
        MessageManager.getInstance().registerListener(this.q);
        d.b.h0.r.c0.a.e().f();
        p.c().d(this.f49932h);
        Q();
        if (B()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
