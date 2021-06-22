package d.a.n0.a;

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
import d.a.n0.a.e0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f52415a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<d.a.n0.a.c>> f52416b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d.a.n0.a.c> f52417c;

    /* renamed from: d  reason: collision with root package name */
    public f f52418d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f52419e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52420f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52421g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f52422h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.a.e0.d f52423i;
    public d.a.n0.a.c0.c j;
    public d.a.n0.a.d0.b k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public d.a.n0.a.c0.a<d.a.n0.a.c0.b> t;
    public d.a.n0.m.b u;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.f52420f = true;
            if (d.this.f52417c.isEmpty()) {
                return;
            }
            Iterator it = d.this.f52417c.iterator();
            while (it.hasNext()) {
                d.this.m((d.a.n0.a.c) it.next());
            }
            d.this.f52417c.clear();
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
                d.this.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            d.this.f52421g = true;
            d.this.q();
        }
    }

    /* renamed from: d.a.n0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1155d implements d.a.n0.a.c0.a<d.a.n0.a.c0.b> {
        public C1155d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.c0.a
        /* renamed from: b */
        public void a(d.a.n0.a.c0.b bVar) {
            ActiveCenterData activeCenterData;
            if (bVar == null || (activeCenterData = bVar.f52409g) == null || activeCenterData.mission == null) {
                return;
            }
            d.a.n0.a.c cVar = new d.a.n0.a.c();
            cVar.O(bVar.f52409g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            d.this.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.a
        /* renamed from: c */
        public void onSuccess(d.a.n0.a.c0.b bVar) {
            if (bVar != null) {
                d.this.n(bVar.b());
            }
        }

        @Override // d.a.n0.m.a
        public void onError(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.n0.m.b<d.a.n0.a.c> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.b
        /* renamed from: b */
        public void a(d.a.n0.a.c cVar) {
            if (cVar == null) {
                return;
            }
            d.a.n0.a.c w = d.this.w(cVar);
            if (w != null && w.z) {
                w.R();
                d.this.S(w);
                return;
            }
            p.b().h(w);
            if (w != null && w.x() == 7) {
                w.H();
                int F = w.F();
                int w2 = w.w();
                if (F <= 1 || F <= w2) {
                    d.this.G(w);
                } else {
                    d.this.S(w);
                }
            } else if (w == null || w.x() != 8) {
                d.this.G(cVar);
            } else {
                d.this.G(w);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BdAsyncTask<d.a.n0.a.c, Integer, Void> {
        public g(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.n0.a.c... cVarArr) {
            if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                return null;
            }
            d.a.n0.a.a.g().a(cVarArr[0]);
            return null;
        }

        public /* synthetic */ g(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<List<d.a.n0.a.c>, Integer, Void> {
        public h(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<d.a.n0.a.c>... listArr) {
            if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                return null;
            }
            d.a.n0.a.a.g().b(listArr[0]);
            return null;
        }

        public /* synthetic */ h(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<d.a.n0.a.c, Integer, Void> {
        public i(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.n0.a.c... cVarArr) {
            if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                return null;
            }
            d.a.n0.a.a.g().e(cVarArr[0]);
            return null;
        }

        public /* synthetic */ i(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<Pair<d.a.n0.a.c, d.a.n0.a.c>, Integer, Pair<d.a.n0.a.c, d.a.n0.a.c>> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<d.a.n0.a.c, d.a.n0.a.c> doInBackground(Pair<d.a.n0.a.c, d.a.n0.a.c>... pairArr) {
            if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                return null;
            }
            Pair<d.a.n0.a.c, d.a.n0.a.c> pair = pairArr[0];
            d.a.n0.a.c cVar = (d.a.n0.a.c) pair.first;
            d.a.n0.a.c cVar2 = (d.a.n0.a.c) pair.second;
            if (cVar2 != null) {
                d.a.n0.a.a.g().e(cVar2);
            }
            if (cVar != null) {
                d.a.n0.a.a.g().a(cVar);
                return pair;
            }
            return pair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<d.a.n0.a.c, d.a.n0.a.c> pair) {
            if (pair != null) {
                d.a.n0.a.c cVar = (d.a.n0.a.c) pair.first;
                d.a.n0.a.c cVar2 = (d.a.n0.a.c) pair.second;
                if (cVar2 != null) {
                    d.this.v(cVar2);
                }
                if (cVar != null) {
                    d.this.J(cVar);
                }
            }
        }

        public /* synthetic */ j(d dVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<d.a.n0.a.c>> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<d.a.n0.a.c> doInBackground(Void... voidArr) {
            LinkedList<d.a.n0.a.c> linkedList = new LinkedList<>();
            linkedList.addAll(d.a.n0.a.a.g().f());
            Iterator<d.a.n0.a.c> it = linkedList.iterator();
            while (it.hasNext()) {
                d.a.n0.a.c next = it.next();
                if (next != null && next.M()) {
                    d.a.n0.a.a.g().e(next);
                    it.remove();
                } else if (next != null && next.x() == 7) {
                    next.n0();
                    d.a.n0.a.a.g().i(next);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<d.a.n0.a.c> linkedList) {
            super.onPostExecute(linkedList);
            if (linkedList == null) {
                return;
            }
            if (!linkedList.isEmpty()) {
                Iterator<d.a.n0.a.c> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.a.n0.a.c next = it.next();
                    if (next.h() != null) {
                        d.this.J(next);
                    }
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
        }

        public /* synthetic */ k(d dVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f52436a = new d(null);
    }

    /* loaded from: classes3.dex */
    public class m extends BdAsyncTask<d.a.n0.a.c, Integer, d.a.n0.a.c> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.n0.a.c doInBackground(d.a.n0.a.c... cVarArr) {
            if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                return null;
            }
            d.a.n0.a.c cVar = cVarArr[0];
            d.a.n0.a.a.g().i(cVar);
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.n0.a.c cVar) {
            if (cVar == null || !cVar.z) {
                return;
            }
            cVar.z = false;
            d dVar = d.this;
            dVar.P(dVar.l, d.this.m);
        }

        public /* synthetic */ m(d dVar, a aVar) {
            this();
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static final d y() {
        return l.f52436a;
    }

    public boolean A() {
        return !s();
    }

    public final boolean B() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public final boolean C(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        int[] h2 = cVar.h();
        if (h2 == null) {
            return true;
        }
        for (int i2 : h2) {
            List<d.a.n0.a.c> list = this.f52416b.get(i2);
            if (list == null) {
                return false;
            }
            for (d.a.n0.a.c cVar2 : list) {
                if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                    if (cVar2.M()) {
                        H(cVar, cVar2);
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
        this.f52419e.compareAndSet(true, false);
        this.f52418d.f(0);
        this.f52418d.h(0L);
        this.f52418d.g(0L);
        d.a.n0.a.e0.d dVar = this.f52423i;
        if (dVar != null) {
            dVar.m();
        }
    }

    public void F() {
        List<d.a.n0.a.c> list = this.f52416b.get(d.a.n0.a.c.V);
        if (ListUtils.isEmpty(list)) {
            return;
        }
        boolean z = false;
        for (d.a.n0.a.c cVar : list) {
            Iterator<d.a.n0.a.j> it = cVar.n().iterator();
            while (it.hasNext()) {
                d.a.n0.a.j next = it.next();
                if (next instanceof n) {
                    n nVar = (n) next;
                    if (!next.e()) {
                        nVar.i();
                        z = true;
                    }
                }
            }
        }
        if (!z || this.f52419e.get()) {
            return;
        }
        this.f52418d.f(d.a.n0.a.c.V);
        this.f52419e.compareAndSet(false, true);
        synchronized (this.f52419e) {
            this.f52419e.notify();
        }
    }

    public final void G(d.a.n0.a.c cVar) {
        v(cVar);
        new i(this, null).execute(cVar);
    }

    public final void H(d.a.n0.a.c cVar, d.a.n0.a.c cVar2) {
        v(cVar2);
        new j(this, null).execute(new Pair(cVar, cVar2));
    }

    public boolean I() {
        if (this.j != null && B()) {
            this.j.f(A(), D(), 1);
            return true;
        }
        return false;
    }

    public final void J(d.a.n0.a.c cVar) {
        int[] h2;
        for (int i2 : cVar.h()) {
            List<d.a.n0.a.c> list = this.f52416b.get(i2);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(cVar);
                this.f52416b.put(i2, linkedList);
            } else {
                list.add(cVar);
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
        List<d.a.n0.a.c> list;
        if (B() && this.f52420f && (list = this.f52416b.get((i2 = d.a.n0.a.c.V))) != null && !list.isEmpty()) {
            boolean z = false;
            for (d.a.n0.a.c cVar : list) {
                if (cVar.x() == 8) {
                    Iterator<d.a.n0.a.j> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.n0.a.j next = it.next();
                        d.a.n0.a.c c2 = next.c();
                        if (c2 != null && (next instanceof n) && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            ((n) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        n nVar = new n(cVar);
                        nVar.g(0L);
                        nVar.f(false);
                        cVar.a(nVar);
                    }
                }
            }
            this.f52418d.f(i2);
            this.f52419e.compareAndSet(false, true);
            synchronized (this.f52419e) {
                this.f52419e.notify();
            }
        }
    }

    public void N(int i2) {
        if (B() && i2 != 0 && this.f52420f) {
            this.l = i2;
            List<d.a.n0.a.c> list = this.f52416b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.a.n0.a.c cVar : list) {
                if (cVar.x() == 4) {
                    Iterator<d.a.n0.a.j> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.n0.a.j next = it.next();
                        if ((next instanceof d.a.n0.a.k) && next.c().d() == cVar.d() && next.c().q() == cVar.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.n0.a.k kVar = new d.a.n0.a.k(cVar);
                        kVar.g(0L);
                        kVar.f(false);
                        cVar.a(kVar);
                    }
                }
            }
            this.f52418d.f(i2);
            this.f52419e.compareAndSet(false, true);
            synchronized (this.f52419e) {
                this.f52419e.notify();
            }
        }
    }

    public void O(int i2, long j2) {
        if (B() && i2 != 0 && j2 != 0 && this.f52420f) {
            this.l = i2;
            List<d.a.n0.a.c> list = this.f52416b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.a.n0.a.c cVar : list) {
                if (cVar.x() == 2) {
                    Iterator<d.a.n0.a.j> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.n0.a.j next = it.next();
                        if ((next instanceof d.a.n0.a.l) && next.c().d() == cVar.d() && next.c().q() == cVar.q() && ((d.a.n0.a.l) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.n0.a.l lVar = new d.a.n0.a.l(cVar, j2);
                        lVar.g(0L);
                        lVar.f(false);
                        lVar.h(cVar.w());
                        cVar.a(lVar);
                    }
                }
            }
            this.f52418d.f(i2);
            this.f52418d.g(j2);
            this.f52419e.compareAndSet(false, true);
            synchronized (this.f52419e) {
                this.f52419e.notify();
            }
        }
    }

    public void P(int i2, long j2) {
        if (B() && i2 != 0 && j2 != 0 && this.f52420f) {
            this.l = i2;
            List<d.a.n0.a.c> list = this.f52416b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (d.a.n0.a.c cVar : list) {
                if (cVar.x() == 1) {
                    p(cVar, j2);
                } else if (cVar.x() == 7 && !cVar.J(j2)) {
                    o(cVar, j2);
                }
            }
            this.f52418d.f(i2);
            this.f52418d.h(j2);
            this.m = j2;
            this.f52419e.compareAndSet(false, true);
            synchronized (this.f52419e) {
                this.f52419e.notify();
            }
        }
    }

    public final void Q() {
        this.f52415a.scheduleWithFixedDelay(this.f52418d, 0L, 1L, TimeUnit.SECONDS);
    }

    public void R(int i2, long j2) {
        d.a.n0.a.m mVar;
        d.a.n0.a.c c2;
        List<d.a.n0.a.c> list = this.f52416b.get(i2);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.a.n0.a.c cVar : list) {
            if (cVar.x() == 7) {
                Iterator<d.a.n0.a.j> it = cVar.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.a.n0.a.j next = it.next();
                        if ((next instanceof d.a.n0.a.m) && (c2 = (mVar = (d.a.n0.a.m) next).c()) != null && mVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(d.a.n0.a.c cVar) {
        T(cVar);
        new m(this, null).execute(cVar);
    }

    public final void T(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return;
        }
        int x = cVar.x();
        Iterator<d.a.n0.a.j> it = cVar.n().iterator();
        while (it.hasNext()) {
            d.a.n0.a.j next = it.next();
            if (next != null && next.c() != null) {
                d.a.n0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    if (x == 7 && (next instanceof d.a.n0.a.m)) {
                        ((d.a.n0.a.m) next).f(true);
                    } else if (x == 1 && (next instanceof o)) {
                        ((o) next).f(true);
                    }
                }
            }
        }
        cVar.c0(false);
    }

    public void m(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return;
        }
        if (cVar.x() == 9) {
            r.c().f(cVar);
        } else if (!this.f52420f) {
            this.f52417c.add(cVar);
        } else if (C(cVar)) {
        } else {
            J(cVar);
            new g(this, null).execute(cVar);
        }
    }

    public void n(List<d.a.n0.a.c> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f52420f) {
            this.f52417c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.n0.a.c cVar : list) {
            if (cVar != null) {
                if (cVar.x() == 9) {
                    r.c().f(cVar);
                } else if (!C(cVar)) {
                    J(cVar);
                    arrayList.add(cVar);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(d.a.n0.a.c cVar, long j2) {
        boolean z;
        d.a.n0.a.m mVar;
        d.a.n0.a.c c2;
        Iterator<d.a.n0.a.j> it = cVar.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d.a.n0.a.j next = it.next();
            if ((next instanceof d.a.n0.a.m) && (c2 = (mVar = (d.a.n0.a.m) next).c()) != null && mVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        d.a.n0.a.m mVar2 = new d.a.n0.a.m(cVar, j2);
        mVar2.g(0L);
        mVar2.f(false);
        mVar2.h(cVar.w());
        cVar.a(mVar2);
    }

    public final void p(d.a.n0.a.c cVar, long j2) {
        boolean z;
        o oVar;
        d.a.n0.a.c c2;
        Iterator<d.a.n0.a.j> it = cVar.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d.a.n0.a.j next = it.next();
            if ((next instanceof o) && (c2 = (oVar = (o) next).c()) != null && oVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        o oVar2 = new o(cVar, j2);
        oVar2.g(0L);
        oVar2.f(false);
        oVar2.h(cVar.w());
        cVar.a(oVar2);
    }

    public void q() {
        if (this.j != null && B() && this.f52421g && !t()) {
            this.j.f(A(), D(), 0);
        }
    }

    public void r() {
        if (this.k != null && B()) {
            this.k.d();
        }
    }

    public boolean s() {
        return UtilHelper.isSameDay(d.a.n0.r.d0.b.j().l("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean t() {
        return UtilHelper.isSameDay(z(), System.currentTimeMillis());
    }

    public boolean u() {
        return UtilHelper.isSameDay(d.a.n0.r.d0.b.j().l("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    public final void v(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator<d.a.n0.a.j> it = cVar.n().iterator();
        while (it.hasNext()) {
            d.a.n0.a.j next = it.next();
            if (next != null && next.c() != null) {
                d.a.n0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.f52416b.size(); i2++) {
            List<d.a.n0.a.c> valueAt = this.f52416b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<d.a.n0.a.c> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    d.a.n0.a.c next2 = it2.next();
                    if (next2 != null && next2.d() == cVar.d() && next2.q() == cVar.q()) {
                        it2.remove();
                    }
                }
            }
        }
        d.a.n0.a.b.a("deleteActivityMissionInfoDataInMemory-->activityId=" + cVar.d() + ",missionId=" + cVar.q());
    }

    public final d.a.n0.a.c w(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f52416b.size(); i2++) {
            List<d.a.n0.a.c> valueAt = this.f52416b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (d.a.n0.a.c cVar2 : valueAt) {
                    if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                        return cVar2;
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
        long l2 = d.a.n0.r.d0.b.j().l("pref_key_active_config_info", 0L);
        this.o = l2;
        return l2;
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public volatile int f52429e;

        /* renamed from: f  reason: collision with root package name */
        public volatile long f52430f;

        /* renamed from: g  reason: collision with root package name */
        public volatile long f52431g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f52432h;

        public f() {
            this.f52432h = false;
        }

        public final void a(d.a.n0.a.c cVar, d.C1157d c1157d) {
            ArrayList<d.a.n0.a.j> n;
            if (cVar == null || c1157d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<d.a.n0.a.j> it = n.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                d.a.n0.a.j next = it.next();
                if (next instanceof o) {
                    o oVar = (o) next;
                    if (this.f52430f != 0 && oVar.i() == this.f52430f && !next.e()) {
                        this.f52432h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                c1157d.b(next);
                            }
                        }
                        c1157d.c(cVar);
                    }
                } else if (next instanceof d.a.n0.a.m) {
                    d.a.n0.a.m mVar = (d.a.n0.a.m) next;
                    if (!cVar.L() && mVar.d() == cVar.w()) {
                        if (this.f52430f != 0 && mVar.i() == this.f52430f && !next.e()) {
                            this.f52432h = false;
                            next.a(1);
                        }
                        i2 = (int) (i2 + next.b());
                        if (this.f52430f != 0 && mVar.i() == this.f52430f && !next.e()) {
                            if (next.b() >= cVar.f()) {
                                next.f(true);
                                cVar.I();
                            }
                            c1157d.c(cVar);
                        }
                        int l = cVar.l();
                        int A = cVar.A();
                        long f2 = cVar.f() * cVar.A();
                        if (this.f52430f != 0 && mVar.i() == this.f52430f) {
                            next.e();
                        }
                        if (i2 >= f2 && l >= A) {
                            c1157d.a(cVar);
                            cVar.c0(true);
                        }
                    }
                } else if (next instanceof d.a.n0.a.l) {
                    if (this.f52431g != 0 && ((d.a.n0.a.l) next).i() == this.f52431g && !next.e()) {
                        this.f52432h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                c1157d.b(next);
                            }
                        }
                    }
                } else if ((next instanceof d.a.n0.a.k) && !next.e()) {
                    this.f52432h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1157d.b(next);
                    }
                }
            }
        }

        public final void b(d.a.n0.a.c cVar, d.C1157d c1157d) {
            ArrayList<d.a.n0.a.j> n;
            if (cVar == null || c1157d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<d.a.n0.a.j> it = n.iterator();
            while (it.hasNext()) {
                d.a.n0.a.j next = it.next();
                if ((next instanceof n) && !((n) next).j() && !next.e()) {
                    this.f52432h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1157d.a(cVar);
                    }
                    c1157d.c(cVar);
                }
            }
        }

        public final void c() {
            this.f52432h = true;
            List<d.a.n0.a.c> list = (List) d.this.f52416b.get(d.a.n0.a.c.V);
            List<d.a.n0.a.c> list2 = (List) d.this.f52416b.get(this.f52429e);
            if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                d.this.f52419e.compareAndSet(true, false);
                return;
            }
            d.C1157d c1157d = new d.C1157d();
            c1157d.f52482a = new LinkedList();
            c1157d.f52483b = new LinkedList();
            c1157d.f52484c = new LinkedList();
            d(list, c1157d);
            e(list2, c1157d);
            if (this.f52432h) {
                d.this.f52419e.compareAndSet(true, false);
            }
            if (!ListUtils.isEmpty(c1157d.f52484c)) {
                d.a.n0.a.a.g().k(c1157d.f52484c);
            }
            if (ListUtils.isEmpty(c1157d.f52482a) && ListUtils.isEmpty(c1157d.f52483b)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, c1157d));
        }

        public final void d(List<d.a.n0.a.c> list, d.C1157d c1157d) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.n0.a.c cVar : list) {
                b(cVar, c1157d);
            }
        }

        public final void e(List<d.a.n0.a.c> list, d.C1157d c1157d) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.n0.a.c cVar : list) {
                a(cVar, c1157d);
            }
        }

        public synchronized void f(int i2) {
            this.f52429e = i2;
        }

        public synchronized void g(long j) {
            this.f52431g = j;
        }

        public synchronized void h(long j) {
            this.f52430f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f52429e == 0 || !d.this.f52419e.get()) {
                synchronized (d.this.f52419e) {
                    try {
                        d.this.f52419e.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            c();
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        this.f52415a = Executors.newSingleThreadScheduledExecutor();
        this.f52416b = new SparseArray<>();
        this.f52417c = new LinkedList<>();
        this.f52418d = new f(this, null);
        this.f52419e = new AtomicBoolean(false);
        this.f52420f = false;
        this.f52421g = false;
        this.p = false;
        this.q = new a(2921391);
        this.r = new b(2001011);
        this.s = new c(2001371);
        this.t = new C1155d();
        this.u = new e();
        BdUniqueId gen = BdUniqueId.gen();
        this.f52422h = gen;
        d.a.n0.a.e0.d dVar = new d.a.n0.a.e0.d(gen);
        this.f52423i = dVar;
        dVar.w(this.u);
        d.a.n0.a.c0.c cVar = new d.a.n0.a.c0.c(this.f52422h);
        this.j = cVar;
        cVar.g(this.t);
        this.k = new d.a.n0.a.d0.b(this.f52422h);
        this.s.setTag(this.f52422h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.f52422h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.f52422h);
        MessageManager.getInstance().registerListener(this.q);
        d.a.n0.r.c0.a.e().f();
        r.c().d(this.f52422h);
        Q();
        if (B()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
