package d.a.c.e.l;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.l.b;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f38696c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f38697d;

    /* renamed from: e  reason: collision with root package name */
    public static BdAsyncTaskParallel f38698e;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f38699a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<e<?>> f38700b;

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f38701a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38702b;

        /* renamed from: c  reason: collision with root package name */
        public int f38703c;

        /* renamed from: d  reason: collision with root package name */
        public int f38704d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38705e;

        /* renamed from: f  reason: collision with root package name */
        public Object[] f38706f;

        /* renamed from: g  reason: collision with root package name */
        public int f38707g = 2;

        /* renamed from: i  reason: collision with root package name */
        public final Map<c<T>, BdUniqueId> f38709i = new HashMap();
        public final b j = new b();

        /* renamed from: h  reason: collision with root package name */
        public long f38708h = System.currentTimeMillis();

        public a(String str, int i2, int i3, int i4, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.f38703c = 0;
            this.f38704d = 0;
            this.f38705e = false;
            this.f38706f = null;
            this.f38701a = str;
            this.f38702b = i2;
            this.f38703c = i3;
            this.f38704d = i4;
            this.f38705e = z;
            this.f38706f = objArr;
            b(cVar, bdUniqueId);
        }

        public void b(c<T> cVar, BdUniqueId bdUniqueId) {
            l.d();
            if (this.f38709i.containsKey(cVar)) {
                return;
            }
            this.f38709i.put(cVar, bdUniqueId);
        }

        public void c(BdUniqueId bdUniqueId) {
            l.d();
            if (this.f38709i.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.f38709i.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.f38709i.size() == 0) {
                cancel();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            b.a aVar;
            super.cancel();
            b bVar = this.j;
            if (bVar != null && (aVar = bVar.f38695a) != null) {
                aVar.cancel();
            }
            if (this.f38709i.size() == 0) {
                return;
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.f38709i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.f38701a);
                }
            }
            this.f38709i.clear();
        }

        public void d(BdUniqueId bdUniqueId, c<T> cVar) {
            l.d();
            if (this.f38709i.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.f38709i.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<c<T>, BdUniqueId> next = it.next();
                c<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == cVar) {
                    it.remove();
                }
            }
            if (this.f38709i.size() == 0) {
                cancel();
            }
        }

        public void e(c<T> cVar) {
            l.d();
            this.f38709i.remove(cVar);
            if (cVar != null) {
                cVar.onCancelled(this.f38701a);
            }
            if (this.f38709i.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public T doInBackground(String... strArr) {
            T t;
            d.a.c.e.l.a.m(true, System.currentTimeMillis() - this.f38708h);
            e eVar = (e) d.this.f38700b.get(this.f38702b);
            if (eVar == null) {
                return null;
            }
            String key = getKey();
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                t = null;
            }
            if (isCancelled()) {
                return null;
            }
            T t2 = (T) eVar.getFromLocal(this.f38701a, key, this.f38703c, this.f38704d, this.j, this.f38706f);
            if (t2 != null) {
                return t2;
            }
            t = t2;
            if (isCancelled() || this.f38705e) {
                return null;
            }
            this.f38707g = 3;
            try {
                return (T) eVar.getFromRemote(this.f38701a, key, this.f38703c, this.f38704d, this.j, this.f38706f);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                return t;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.f38700b.get(this.f38702b)) != null) {
                eVar.updateMemory(d.this.g(this.f38701a, this.f38702b), t, this.f38703c, this.f38704d, this.f38706f);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.f38709i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.f38701a, this.f38707g);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.f38709i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }
    }

    public d() {
        this.f38700b = null;
        BdUniqueId gen = BdUniqueId.gen();
        f38697d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        f38698e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.f38700b = new SparseArray<>();
    }

    public static d h() {
        if (f38696c == null) {
            synchronized (d.class) {
                if (f38696c == null) {
                    f38696c = new d();
                }
            }
        }
        return f38696c;
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.f38699a);
        if (searchAllTask == null || searchAllTask.size() == 0) {
            return;
        }
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof a)) {
                ((a) next).c(bdUniqueId);
            }
        }
    }

    public void c(String str, int i2) {
        a p = p(g(str, i2));
        if (p == null) {
            return;
        }
        p.cancel();
    }

    public <T> void d(String str, int i2, c<T> cVar) {
        a<T> p = p(g(str, i2));
        if (p == null) {
            return;
        }
        p.e(cVar);
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f38699a);
        if (searchWaitingTask == null || searchWaitingTask.size() == 0) {
            return;
        }
        Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof a)) {
                ((a) next).c(bdUniqueId);
            }
        }
    }

    public <T> void f(BdUniqueId bdUniqueId, c<T> cVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f38699a);
        if (searchWaitingTask == null || searchWaitingTask.size() == 0) {
            return;
        }
        Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof a)) {
                ((a) next).d(bdUniqueId, cVar);
            }
        }
    }

    public String g(String str, int i2) {
        if (str == null) {
            str = "";
        }
        return str + i2;
    }

    public e i(int i2) {
        SparseArray<e<?>> sparseArray = this.f38700b;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i2);
    }

    public boolean j(int i2) {
        e<?> eVar = this.f38700b.get(i2);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i2);
            return false;
        }
        return eVar.isNeedLoad();
    }

    public <T> Object k(String str, int i2, c<T> cVar, int i3, int i4, BdUniqueId bdUniqueId, Object... objArr) {
        return l(str, i2, cVar, i3, i4, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: d.a.c.e.l.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object l(String str, int i2, c<T> cVar, int i3, int i4, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        e<?> eVar;
        int i5;
        int i6;
        a<T> p;
        boolean H;
        int asyncTaskPriority;
        Object fromMemory;
        if (TextUtils.isEmpty(str) || (eVar = this.f38700b.get(i2)) == null) {
            return null;
        }
        if (i3 < 0 || i4 < 0) {
            i5 = 0;
            i6 = 0;
        } else {
            i5 = i3;
            i6 = i4;
        }
        String g2 = g(str, i2);
        try {
            fromMemory = eVar.getFromMemory(g2, str, i5, i6, true, objArr);
        } catch (Exception e2) {
            e = e2;
        }
        if (fromMemory != null) {
            if (cVar != 0) {
                try {
                    cVar.onLoaded(fromMemory, str, 1);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    p = p(g2);
                    if (p == null) {
                    }
                    H = j.H();
                    boolean v = j.v();
                    a aVar = new a(str, i2, i5, i6, bdUniqueId, cVar, z, objArr);
                    aVar.setKey(g2);
                    aVar.setTag(this.f38699a);
                    asyncTaskPriority = eVar.getAsyncTaskPriority();
                    if (asyncTaskPriority == 0) {
                    }
                    aVar.setPriority(asyncTaskPriority);
                    if (H) {
                    }
                    if (eVar.getAsyncTaskParallel() != null) {
                    }
                    aVar.execute(new String[0]);
                    return null;
                }
            }
            return fromMemory;
        }
        p = p(g2);
        if (p == null && p.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            p.b(cVar, bdUniqueId);
            return null;
        }
        H = j.H();
        boolean v2 = j.v();
        a aVar2 = new a(str, i2, i5, i6, bdUniqueId, cVar, z, objArr);
        aVar2.setKey(g2);
        aVar2.setTag(this.f38699a);
        asyncTaskPriority = eVar.getAsyncTaskPriority();
        if (asyncTaskPriority == 0) {
            asyncTaskPriority = 1;
        }
        aVar2.setPriority(asyncTaskPriority);
        if (H && !v2) {
            aVar2.setParallel(f38697d);
        } else if (eVar.getAsyncTaskParallel() != null) {
            aVar2.setParallel(f38698e);
        } else {
            aVar2.setParallel(eVar.getAsyncTaskParallel());
        }
        aVar2.execute(new String[0]);
        return null;
    }

    public <T> Object m(String str, int i2, c<T> cVar, BdUniqueId bdUniqueId) {
        return k(str, i2, cVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public Object n(String str, int i2, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.f38700b.get(i2);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i2);
            return null;
        }
        return eVar.getFromMemory(g(str, i2), str, 0, 0, false, objArr);
    }

    public synchronized <T> void o(int i2, e<T> eVar) {
        if (eVar != null) {
            if (this.f38700b.get(i2) == null) {
                this.f38700b.put(i2, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i2);
            }
        }
    }

    public final <T> a<T> p(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null) {
            return null;
        }
        if (!(searchTask instanceof a)) {
            BdLog.e("BdAsyncTask has encountered repeat key");
            return null;
        }
        try {
            return (a) searchTask;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }
}
