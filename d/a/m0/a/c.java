package d.a.m0.a;

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
import d.a.m0.a.d0.d;
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
    public final ScheduledExecutorService f48632a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<d.a.m0.a.b>> f48633b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d.a.m0.a.b> f48634c;

    /* renamed from: d  reason: collision with root package name */
    public f f48635d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f48636e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48637f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48638g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f48639h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.a.d0.d f48640i;
    public d.a.m0.a.b0.c j;
    public d.a.m0.a.c0.b k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public d.a.m0.a.b0.a<d.a.m0.a.b0.b> t;
    public d.a.m0.m.b u;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.f48637f = true;
            if (c.this.f48634c.isEmpty()) {
                return;
            }
            Iterator it = c.this.f48634c.iterator();
            while (it.hasNext()) {
                c.this.m((d.a.m0.a.b) it.next());
            }
            c.this.f48634c.clear();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
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

    /* renamed from: d.a.m0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1096c extends CustomMessageListener {
        public C1096c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            c.this.f48638g = true;
            c.this.q();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.b0.a<d.a.m0.a.b0.b> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.b0.a
        /* renamed from: b */
        public void a(d.a.m0.a.b0.b bVar) {
            ActiveCenterData activeCenterData;
            if (bVar == null || (activeCenterData = bVar.f48626g) == null || activeCenterData.mission == null) {
                return;
            }
            d.a.m0.a.b bVar2 = new d.a.m0.a.b();
            bVar2.O(bVar.f48626g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar2);
            c.this.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.a
        /* renamed from: c */
        public void onSuccess(d.a.m0.a.b0.b bVar) {
            if (bVar != null) {
                c.this.n(bVar.b());
            }
        }

        @Override // d.a.m0.m.a
        public void onError(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.m.b<d.a.m0.a.b> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.b
        /* renamed from: b */
        public void a(d.a.m0.a.b bVar) {
            if (bVar == null) {
                return;
            }
            d.a.m0.a.b w = c.this.w(bVar);
            if (w != null && w.z) {
                w.R();
                c.this.S(w);
                return;
            }
            o.b().h(w);
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
    public class g extends BdAsyncTask<d.a.m0.a.b, Integer, Void> {
        public g(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.m0.a.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            d.a.m0.a.a.g().a(bVarArr[0]);
            return null;
        }

        public /* synthetic */ g(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<List<d.a.m0.a.b>, Integer, Void> {
        public h(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<d.a.m0.a.b>... listArr) {
            if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                return null;
            }
            d.a.m0.a.a.g().b(listArr[0]);
            return null;
        }

        public /* synthetic */ h(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<d.a.m0.a.b, Integer, Void> {
        public i(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.m0.a.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            d.a.m0.a.a.g().e(bVarArr[0]);
            return null;
        }

        public /* synthetic */ i(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<Pair<d.a.m0.a.b, d.a.m0.a.b>, Integer, Pair<d.a.m0.a.b, d.a.m0.a.b>> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<d.a.m0.a.b, d.a.m0.a.b> doInBackground(Pair<d.a.m0.a.b, d.a.m0.a.b>... pairArr) {
            if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                return null;
            }
            Pair<d.a.m0.a.b, d.a.m0.a.b> pair = pairArr[0];
            d.a.m0.a.b bVar = (d.a.m0.a.b) pair.first;
            d.a.m0.a.b bVar2 = (d.a.m0.a.b) pair.second;
            if (bVar2 != null) {
                d.a.m0.a.a.g().e(bVar2);
            }
            if (bVar != null) {
                d.a.m0.a.a.g().a(bVar);
                return pair;
            }
            return pair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<d.a.m0.a.b, d.a.m0.a.b> pair) {
            if (pair != null) {
                d.a.m0.a.b bVar = (d.a.m0.a.b) pair.first;
                d.a.m0.a.b bVar2 = (d.a.m0.a.b) pair.second;
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
    public class k extends BdAsyncTask<Void, Integer, LinkedList<d.a.m0.a.b>> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<d.a.m0.a.b> doInBackground(Void... voidArr) {
            LinkedList<d.a.m0.a.b> linkedList = new LinkedList<>();
            linkedList.addAll(d.a.m0.a.a.g().f());
            Iterator<d.a.m0.a.b> it = linkedList.iterator();
            while (it.hasNext()) {
                d.a.m0.a.b next = it.next();
                if (next != null && next.M()) {
                    d.a.m0.a.a.g().e(next);
                    it.remove();
                } else if (next.x() == 7) {
                    next.n0();
                    d.a.m0.a.a.g().i(next);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<d.a.m0.a.b> linkedList) {
            super.onPostExecute(linkedList);
            if (linkedList == null) {
                return;
            }
            if (!linkedList.isEmpty()) {
                Iterator<d.a.m0.a.b> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.a.m0.a.b next = it.next();
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
        public static final c f48653a = new c(null);
    }

    /* loaded from: classes3.dex */
    public class m extends BdAsyncTask<d.a.m0.a.b, Integer, d.a.m0.a.b> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.m0.a.b doInBackground(d.a.m0.a.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            d.a.m0.a.b bVar = bVarArr[0];
            d.a.m0.a.a.g().i(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.m0.a.b bVar) {
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
        return l.f48653a;
    }

    public boolean A() {
        return !s();
    }

    public final boolean B() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public final boolean C(d.a.m0.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] h2 = bVar.h();
        if (h2 == null) {
            return true;
        }
        for (int i2 : h2) {
            List<d.a.m0.a.b> list = this.f48633b.get(i2);
            if (list == null) {
                return false;
            }
            for (d.a.m0.a.b bVar2 : list) {
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
        this.f48636e.compareAndSet(true, false);
        this.f48635d.f(0);
        this.f48635d.h(0L);
        this.f48635d.g(0L);
        d.a.m0.a.d0.d dVar = this.f48640i;
        if (dVar != null) {
            dVar.m();
        }
    }

    public void F() {
        List<d.a.m0.a.b> list = this.f48633b.get(d.a.m0.a.b.V);
        if (ListUtils.isEmpty(list)) {
            return;
        }
        boolean z = false;
        for (d.a.m0.a.b bVar : list) {
            Iterator<d.a.m0.a.i> it = bVar.n().iterator();
            while (it.hasNext()) {
                d.a.m0.a.i next = it.next();
                if (next instanceof d.a.m0.a.m) {
                    d.a.m0.a.m mVar = (d.a.m0.a.m) next;
                    if (!next.e()) {
                        mVar.i();
                        z = true;
                    }
                }
            }
        }
        if (!z || this.f48636e.get()) {
            return;
        }
        this.f48635d.f(d.a.m0.a.b.V);
        this.f48636e.compareAndSet(false, true);
        synchronized (this.f48636e) {
            this.f48636e.notify();
        }
    }

    public final void G(d.a.m0.a.b bVar) {
        v(bVar);
        new i(this, null).execute(bVar);
    }

    public final void H(d.a.m0.a.b bVar, d.a.m0.a.b bVar2) {
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

    public final void J(d.a.m0.a.b bVar) {
        int[] h2;
        for (int i2 : bVar.h()) {
            List<d.a.m0.a.b> list = this.f48633b.get(i2);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.f48633b.put(i2, linkedList);
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
        List<d.a.m0.a.b> list;
        if (B() && this.f48637f && (list = this.f48633b.get((i2 = d.a.m0.a.b.V))) != null && !list.isEmpty()) {
            boolean z = false;
            for (d.a.m0.a.b bVar : list) {
                if (bVar.x() == 8) {
                    Iterator<d.a.m0.a.i> it = bVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.m0.a.i next = it.next();
                        d.a.m0.a.b c2 = next.c();
                        if (c2 != null && (next instanceof d.a.m0.a.m) && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                            ((d.a.m0.a.m) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.m0.a.m mVar = new d.a.m0.a.m(bVar);
                        mVar.g(0L);
                        mVar.f(false);
                        bVar.a(mVar);
                    }
                }
            }
            this.f48635d.f(i2);
            this.f48636e.compareAndSet(false, true);
            synchronized (this.f48636e) {
                this.f48636e.notify();
            }
        }
    }

    public void N(int i2) {
        if (B() && i2 != 0 && this.f48637f) {
            this.l = i2;
            List<d.a.m0.a.b> list = this.f48633b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.a.m0.a.b bVar : list) {
                if (bVar.x() == 4) {
                    Iterator<d.a.m0.a.i> it = bVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.m0.a.i next = it.next();
                        if ((next instanceof d.a.m0.a.j) && next.c().d() == bVar.d() && next.c().q() == bVar.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.m0.a.j jVar = new d.a.m0.a.j(bVar);
                        jVar.g(0L);
                        jVar.f(false);
                        bVar.a(jVar);
                    }
                }
            }
            this.f48635d.f(i2);
            this.f48636e.compareAndSet(false, true);
            synchronized (this.f48636e) {
                this.f48636e.notify();
            }
        }
    }

    public void O(int i2, long j2) {
        if (B() && i2 != 0 && j2 != 0 && this.f48637f) {
            this.l = i2;
            List<d.a.m0.a.b> list = this.f48633b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.a.m0.a.b bVar : list) {
                if (bVar.x() == 2) {
                    Iterator<d.a.m0.a.i> it = bVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.m0.a.i next = it.next();
                        if ((next instanceof d.a.m0.a.k) && next.c().d() == bVar.d() && next.c().q() == bVar.q() && ((d.a.m0.a.k) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.m0.a.k kVar = new d.a.m0.a.k(bVar, j2);
                        kVar.g(0L);
                        kVar.f(false);
                        kVar.h(bVar.w());
                        bVar.a(kVar);
                    }
                }
            }
            this.f48635d.f(i2);
            this.f48635d.g(j2);
            this.f48636e.compareAndSet(false, true);
            synchronized (this.f48636e) {
                this.f48636e.notify();
            }
        }
    }

    public void P(int i2, long j2) {
        if (B() && i2 != 0 && j2 != 0 && this.f48637f) {
            this.l = i2;
            List<d.a.m0.a.b> list = this.f48633b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (d.a.m0.a.b bVar : list) {
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
            this.f48635d.f(i2);
            this.f48635d.h(j2);
            this.m = j2;
            this.f48636e.compareAndSet(false, true);
            synchronized (this.f48636e) {
                this.f48636e.notify();
            }
        }
    }

    public final void Q() {
        this.f48632a.scheduleWithFixedDelay(this.f48635d, 0L, 1L, TimeUnit.SECONDS);
    }

    public void R(int i2, long j2) {
        d.a.m0.a.l lVar;
        d.a.m0.a.b c2;
        List<d.a.m0.a.b> list = this.f48633b.get(i2);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.a.m0.a.b bVar : list) {
            if (bVar.x() == 7) {
                Iterator<d.a.m0.a.i> it = bVar.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.a.m0.a.i next = it.next();
                        if ((next instanceof d.a.m0.a.l) && (c2 = (lVar = (d.a.m0.a.l) next).c()) != null && lVar.i() == j2 && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(d.a.m0.a.b bVar) {
        T(bVar);
        new m(this, null).execute(bVar);
    }

    public final void T(d.a.m0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        int x = bVar.x();
        Iterator<d.a.m0.a.i> it = bVar.n().iterator();
        while (it.hasNext()) {
            d.a.m0.a.i next = it.next();
            if (next != null && next.c() != null) {
                d.a.m0.a.b c2 = next.c();
                if (c2.d() == bVar.d() && c2.q() == bVar.q()) {
                    if (x == 7 && (next instanceof d.a.m0.a.l)) {
                        ((d.a.m0.a.l) next).f(true);
                    } else if (x == 1 && (next instanceof n)) {
                        ((n) next).f(true);
                    }
                }
            }
        }
        bVar.c0(false);
    }

    public void m(d.a.m0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.x() == 9) {
            q.c().f(bVar);
        } else if (!this.f48637f) {
            this.f48634c.add(bVar);
        } else if (C(bVar)) {
        } else {
            J(bVar);
            new g(this, null).execute(bVar);
        }
    }

    public void n(List<d.a.m0.a.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f48637f) {
            this.f48634c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.m0.a.b bVar : list) {
            if (bVar != null) {
                if (bVar.x() == 9) {
                    q.c().f(bVar);
                } else if (!C(bVar)) {
                    J(bVar);
                    arrayList.add(bVar);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(d.a.m0.a.b bVar, long j2) {
        boolean z;
        d.a.m0.a.l lVar;
        d.a.m0.a.b c2;
        Iterator<d.a.m0.a.i> it = bVar.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d.a.m0.a.i next = it.next();
            if ((next instanceof d.a.m0.a.l) && (c2 = (lVar = (d.a.m0.a.l) next).c()) != null && lVar.i() == j2 && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        d.a.m0.a.l lVar2 = new d.a.m0.a.l(bVar, j2);
        lVar2.g(0L);
        lVar2.f(false);
        lVar2.h(bVar.w());
        bVar.a(lVar2);
    }

    public final void p(d.a.m0.a.b bVar, long j2) {
        boolean z;
        n nVar;
        d.a.m0.a.b c2;
        Iterator<d.a.m0.a.i> it = bVar.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d.a.m0.a.i next = it.next();
            if ((next instanceof n) && (c2 = (nVar = (n) next).c()) != null && nVar.i() == j2 && c2.d() == bVar.d() && c2.q() == bVar.q()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        n nVar2 = new n(bVar, j2);
        nVar2.g(0L);
        nVar2.f(false);
        nVar2.h(bVar.w());
        bVar.a(nVar2);
    }

    public void q() {
        if (this.j != null && B() && this.f48638g && !t()) {
            this.j.f(A(), D(), 0);
        }
    }

    public void r() {
        if (this.k != null && B()) {
            this.k.d();
        }
    }

    public boolean s() {
        return UtilHelper.isSameDay(d.a.m0.r.d0.b.j().l("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean t() {
        return UtilHelper.isSameDay(z(), System.currentTimeMillis());
    }

    public boolean u() {
        return UtilHelper.isSameDay(d.a.m0.r.d0.b.j().l("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    public final void v(d.a.m0.a.b bVar) {
        if (bVar == null) {
            return;
        }
        Iterator<d.a.m0.a.i> it = bVar.n().iterator();
        while (it.hasNext()) {
            d.a.m0.a.i next = it.next();
            if (next != null && next.c() != null) {
                d.a.m0.a.b c2 = next.c();
                if (c2.d() == bVar.d() && c2.q() == bVar.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.f48633b.size(); i2++) {
            List<d.a.m0.a.b> valueAt = this.f48633b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<d.a.m0.a.b> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    d.a.m0.a.b next2 = it2.next();
                    if (next2 != null && next2.d() == bVar.d() && next2.q() == bVar.q()) {
                        it2.remove();
                    }
                }
            }
        }
    }

    public final d.a.m0.a.b w(d.a.m0.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f48633b.size(); i2++) {
            List<d.a.m0.a.b> valueAt = this.f48633b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (d.a.m0.a.b bVar2 : valueAt) {
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
        long l2 = d.a.m0.r.d0.b.j().l("pref_key_active_config_info", 0L);
        this.o = l2;
        return l2;
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public volatile int f48646e;

        /* renamed from: f  reason: collision with root package name */
        public volatile long f48647f;

        /* renamed from: g  reason: collision with root package name */
        public volatile long f48648g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f48649h;

        public f() {
            this.f48649h = false;
        }

        public final void a(d.a.m0.a.b bVar, d.C1098d c1098d) {
            ArrayList<d.a.m0.a.i> n;
            if (bVar == null || c1098d == null || (n = bVar.n()) == null) {
                return;
            }
            Iterator<d.a.m0.a.i> it = n.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                d.a.m0.a.i next = it.next();
                if (next instanceof n) {
                    n nVar = (n) next;
                    if (this.f48647f != 0 && nVar.i() == this.f48647f && !next.e()) {
                        this.f48649h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                c1098d.b(next);
                            }
                        }
                        c1098d.c(bVar);
                    }
                } else if (next instanceof d.a.m0.a.l) {
                    d.a.m0.a.l lVar = (d.a.m0.a.l) next;
                    if (!bVar.L() && lVar.d() == bVar.w()) {
                        if (this.f48647f != 0 && lVar.i() == this.f48647f && !next.e()) {
                            this.f48649h = false;
                            next.a(1);
                        }
                        i2 = (int) (i2 + next.b());
                        if (this.f48647f != 0 && lVar.i() == this.f48647f && !next.e()) {
                            if (next.b() >= bVar.f()) {
                                next.f(true);
                                bVar.I();
                            }
                            c1098d.c(bVar);
                        }
                        int l = bVar.l();
                        int A = bVar.A();
                        if (i2 >= bVar.f() * bVar.A() && l >= A) {
                            c1098d.a(bVar);
                            bVar.c0(true);
                        }
                    }
                } else if (next instanceof d.a.m0.a.k) {
                    if (this.f48648g != 0 && ((d.a.m0.a.k) next).i() == this.f48648g && !next.e()) {
                        this.f48649h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                c1098d.b(next);
                            }
                        }
                    }
                } else if ((next instanceof d.a.m0.a.j) && !next.e()) {
                    this.f48649h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1098d.b(next);
                    }
                }
            }
        }

        public final void b(d.a.m0.a.b bVar, d.C1098d c1098d) {
            ArrayList<d.a.m0.a.i> n;
            if (bVar == null || c1098d == null || (n = bVar.n()) == null) {
                return;
            }
            Iterator<d.a.m0.a.i> it = n.iterator();
            while (it.hasNext()) {
                d.a.m0.a.i next = it.next();
                if ((next instanceof d.a.m0.a.m) && !((d.a.m0.a.m) next).j() && !next.e()) {
                    this.f48649h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1098d.a(bVar);
                    }
                    c1098d.c(bVar);
                }
            }
        }

        public final void c() {
            this.f48649h = true;
            List<d.a.m0.a.b> list = (List) c.this.f48633b.get(d.a.m0.a.b.V);
            List<d.a.m0.a.b> list2 = (List) c.this.f48633b.get(this.f48646e);
            if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                c.this.f48636e.compareAndSet(true, false);
                return;
            }
            d.C1098d c1098d = new d.C1098d();
            c1098d.f48699a = new LinkedList();
            c1098d.f48700b = new LinkedList();
            c1098d.f48701c = new LinkedList();
            d(list, c1098d);
            e(list2, c1098d);
            if (this.f48649h) {
                c.this.f48636e.compareAndSet(true, false);
            }
            if (!ListUtils.isEmpty(c1098d.f48701c)) {
                d.a.m0.a.a.g().k(c1098d.f48701c);
            }
            if (ListUtils.isEmpty(c1098d.f48699a) && ListUtils.isEmpty(c1098d.f48700b)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, c1098d));
        }

        public final void d(List<d.a.m0.a.b> list, d.C1098d c1098d) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.m0.a.b bVar : list) {
                b(bVar, c1098d);
            }
        }

        public final void e(List<d.a.m0.a.b> list, d.C1098d c1098d) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.m0.a.b bVar : list) {
                a(bVar, c1098d);
            }
        }

        public synchronized void f(int i2) {
            this.f48646e = i2;
        }

        public synchronized void g(long j) {
            this.f48648g = j;
        }

        public synchronized void h(long j) {
            this.f48647f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f48646e == 0 || !c.this.f48636e.get()) {
                synchronized (c.this.f48636e) {
                    try {
                        c.this.f48636e.wait();
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
        this.f48632a = Executors.newSingleThreadScheduledExecutor();
        this.f48633b = new SparseArray<>();
        this.f48634c = new LinkedList<>();
        this.f48635d = new f(this, null);
        this.f48636e = new AtomicBoolean(false);
        this.f48637f = false;
        this.f48638g = false;
        this.p = false;
        this.q = new a(2921391);
        this.r = new b(2001011);
        this.s = new C1096c(2001371);
        this.t = new d();
        this.u = new e();
        BdUniqueId gen = BdUniqueId.gen();
        this.f48639h = gen;
        d.a.m0.a.d0.d dVar = new d.a.m0.a.d0.d(gen);
        this.f48640i = dVar;
        dVar.w(this.u);
        d.a.m0.a.b0.c cVar = new d.a.m0.a.b0.c(this.f48639h);
        this.j = cVar;
        cVar.g(this.t);
        this.k = new d.a.m0.a.c0.b(this.f48639h);
        this.s.setTag(this.f48639h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.f48639h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.f48639h);
        MessageManager.getInstance().registerListener(this.q);
        d.a.m0.r.c0.a.e().f();
        q.c().d(this.f48639h);
        Q();
        if (B()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
