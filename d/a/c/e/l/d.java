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
    public static d f42349c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f42350d;

    /* renamed from: e  reason: collision with root package name */
    public static BdAsyncTaskParallel f42351e;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f42352a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<e<?>> f42353b;

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f42354a;

        /* renamed from: b  reason: collision with root package name */
        public final int f42355b;

        /* renamed from: c  reason: collision with root package name */
        public int f42356c;

        /* renamed from: d  reason: collision with root package name */
        public int f42357d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42358e;

        /* renamed from: f  reason: collision with root package name */
        public Object[] f42359f;

        /* renamed from: g  reason: collision with root package name */
        public int f42360g = 2;

        /* renamed from: i  reason: collision with root package name */
        public final Map<c<T>, BdUniqueId> f42362i = new HashMap();
        public final b j = new b();

        /* renamed from: h  reason: collision with root package name */
        public long f42361h = System.currentTimeMillis();

        public a(String str, int i2, int i3, int i4, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.f42356c = 0;
            this.f42357d = 0;
            this.f42358e = false;
            this.f42359f = null;
            this.f42354a = str;
            this.f42355b = i2;
            this.f42356c = i3;
            this.f42357d = i4;
            this.f42358e = z;
            this.f42359f = objArr;
            b(cVar, bdUniqueId);
        }

        public void b(c<T> cVar, BdUniqueId bdUniqueId) {
            l.d();
            if (this.f42362i.containsKey(cVar)) {
                return;
            }
            this.f42362i.put(cVar, bdUniqueId);
        }

        public void c(BdUniqueId bdUniqueId) {
            l.d();
            if (this.f42362i.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.f42362i.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.f42362i.size() == 0) {
                cancel();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            b.a aVar;
            super.cancel();
            b bVar = this.j;
            if (bVar != null && (aVar = bVar.f42348a) != null) {
                aVar.cancel();
            }
            if (this.f42362i.size() == 0) {
                return;
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.f42362i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.f42354a);
                }
            }
            this.f42362i.clear();
        }

        public void d(BdUniqueId bdUniqueId, c<T> cVar) {
            l.d();
            if (this.f42362i.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.f42362i.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<c<T>, BdUniqueId> next = it.next();
                c<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == cVar) {
                    it.remove();
                }
            }
            if (this.f42362i.size() == 0) {
                cancel();
            }
        }

        public void e(c<T> cVar) {
            l.d();
            this.f42362i.remove(cVar);
            if (cVar != null) {
                cVar.onCancelled(this.f42354a);
            }
            if (this.f42362i.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public T doInBackground(String... strArr) {
            T t;
            d.a.c.e.l.a.m(true, System.currentTimeMillis() - this.f42361h);
            e eVar = (e) d.this.f42353b.get(this.f42355b);
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
            T t2 = (T) eVar.getFromLocal(this.f42354a, key, this.f42356c, this.f42357d, this.j, this.f42359f);
            if (t2 != null) {
                return t2;
            }
            t = t2;
            if (isCancelled() || this.f42358e) {
                return null;
            }
            this.f42360g = 3;
            try {
                return (T) eVar.getFromRemote(this.f42354a, key, this.f42356c, this.f42357d, this.j, this.f42359f);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                return t;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.f42353b.get(this.f42355b)) != null) {
                eVar.updateMemory(d.this.g(this.f42354a, this.f42355b), t, this.f42356c, this.f42357d, this.f42359f);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.f42362i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.f42354a, this.f42360g);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.f42362i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }
    }

    public d() {
        this.f42353b = null;
        BdUniqueId gen = BdUniqueId.gen();
        f42350d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        f42351e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.f42353b = new SparseArray<>();
    }

    public static d h() {
        if (f42349c == null) {
            synchronized (d.class) {
                if (f42349c == null) {
                    f42349c = new d();
                }
            }
        }
        return f42349c;
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.f42352a);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f42352a);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f42352a);
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
        SparseArray<e<?>> sparseArray = this.f42353b;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i2);
    }

    public boolean j(int i2) {
        e<?> eVar = this.f42353b.get(i2);
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
        if (TextUtils.isEmpty(str) || (eVar = this.f42353b.get(i2)) == null) {
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
                    aVar.setTag(this.f42352a);
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
        aVar2.setTag(this.f42352a);
        asyncTaskPriority = eVar.getAsyncTaskPriority();
        if (asyncTaskPriority == 0) {
            asyncTaskPriority = 1;
        }
        aVar2.setPriority(asyncTaskPriority);
        if (H && !v2) {
            aVar2.setParallel(f42350d);
        } else if (eVar.getAsyncTaskParallel() != null) {
            aVar2.setParallel(f42351e);
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
        e<?> eVar = this.f42353b.get(i2);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i2);
            return null;
        }
        return eVar.getFromMemory(g(str, i2), str, 0, 0, false, objArr);
    }

    public synchronized <T> void o(int i2, e<T> eVar) {
        if (eVar != null) {
            if (this.f42353b.get(i2) == null) {
                this.f42353b.put(i2, eVar);
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
