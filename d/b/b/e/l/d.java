package d.b.b.e.l;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.l.b;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f41849c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f41850d;

    /* renamed from: e  reason: collision with root package name */
    public static BdAsyncTaskParallel f41851e;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f41852a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<e<?>> f41853b;

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f41854a;

        /* renamed from: b  reason: collision with root package name */
        public final int f41855b;

        /* renamed from: c  reason: collision with root package name */
        public int f41856c;

        /* renamed from: d  reason: collision with root package name */
        public int f41857d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41858e;

        /* renamed from: f  reason: collision with root package name */
        public Object[] f41859f;

        /* renamed from: g  reason: collision with root package name */
        public int f41860g = 2;
        public final Map<c<T>, BdUniqueId> i = new HashMap();
        public final b j = new b();

        /* renamed from: h  reason: collision with root package name */
        public long f41861h = System.currentTimeMillis();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.f41856c = 0;
            this.f41857d = 0;
            this.f41858e = false;
            this.f41859f = null;
            this.f41854a = str;
            this.f41855b = i;
            this.f41856c = i2;
            this.f41857d = i3;
            this.f41858e = z;
            this.f41859f = objArr;
            b(cVar, bdUniqueId);
        }

        public void b(c<T> cVar, BdUniqueId bdUniqueId) {
            l.d();
            if (this.i.containsKey(cVar)) {
                return;
            }
            this.i.put(cVar, bdUniqueId);
        }

        public void c(BdUniqueId bdUniqueId) {
            l.d();
            if (this.i.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.i.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.i.size() == 0) {
                cancel();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            b.a aVar;
            super.cancel();
            b bVar = this.j;
            if (bVar != null && (aVar = bVar.f41848a) != null) {
                aVar.cancel();
            }
            if (this.i.size() == 0) {
                return;
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.f41854a);
                }
            }
            this.i.clear();
        }

        public void d(BdUniqueId bdUniqueId, c<T> cVar) {
            l.d();
            if (this.i.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.i.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<c<T>, BdUniqueId> next = it.next();
                c<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == cVar) {
                    it.remove();
                }
            }
            if (this.i.size() == 0) {
                cancel();
            }
        }

        public void e(c<T> cVar) {
            l.d();
            this.i.remove(cVar);
            if (cVar != null) {
                cVar.onCancelled(this.f41854a);
            }
            if (this.i.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public T doInBackground(String... strArr) {
            T t;
            d.b.b.e.l.a.m(true, System.currentTimeMillis() - this.f41861h);
            e eVar = (e) d.this.f41853b.get(this.f41855b);
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
            T t2 = (T) eVar.getFromLocal(this.f41854a, key, this.f41856c, this.f41857d, this.j, this.f41859f);
            if (t2 != null) {
                return t2;
            }
            t = t2;
            if (isCancelled() || this.f41858e) {
                return null;
            }
            this.f41860g = 3;
            try {
                return (T) eVar.getFromRemote(this.f41854a, key, this.f41856c, this.f41857d, this.j, this.f41859f);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                return t;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.f41853b.get(this.f41855b)) != null) {
                eVar.updateMemory(d.this.g(this.f41854a, this.f41855b), t, this.f41856c, this.f41857d, this.f41859f);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.f41854a, this.f41860g);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }
    }

    public d() {
        this.f41853b = null;
        BdUniqueId gen = BdUniqueId.gen();
        f41850d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        f41851e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.f41853b = new SparseArray<>();
    }

    public static d h() {
        if (f41849c == null) {
            synchronized (d.class) {
                if (f41849c == null) {
                    f41849c = new d();
                }
            }
        }
        return f41849c;
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.f41852a);
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

    public void c(String str, int i) {
        a p = p(g(str, i));
        if (p == null) {
            return;
        }
        p.cancel();
    }

    public <T> void d(String str, int i, c<T> cVar) {
        a<T> p = p(g(str, i));
        if (p == null) {
            return;
        }
        p.e(cVar);
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f41852a);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f41852a);
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

    public String g(String str, int i) {
        if (str == null) {
            str = "";
        }
        return str + i;
    }

    public e i(int i) {
        SparseArray<e<?>> sparseArray = this.f41853b;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public boolean j(int i) {
        e<?> eVar = this.f41853b.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.isNeedLoad();
    }

    public <T> Object k(String str, int i, c<T> cVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return l(str, i, cVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: d.b.b.e.l.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object l(String str, int i, c<T> cVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        e<?> eVar;
        int i4;
        int i5;
        a<T> p;
        boolean H;
        int asyncTaskPriority;
        Object fromMemory;
        if (TextUtils.isEmpty(str) || (eVar = this.f41853b.get(i)) == null) {
            return null;
        }
        if (i2 < 0 || i3 < 0) {
            i4 = 0;
            i5 = 0;
        } else {
            i4 = i2;
            i5 = i3;
        }
        String g2 = g(str, i);
        try {
            fromMemory = eVar.getFromMemory(g2, str, i4, i5, true, objArr);
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
                    a aVar = new a(str, i, i4, i5, bdUniqueId, cVar, z, objArr);
                    aVar.setKey(g2);
                    aVar.setTag(this.f41852a);
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
        a aVar2 = new a(str, i, i4, i5, bdUniqueId, cVar, z, objArr);
        aVar2.setKey(g2);
        aVar2.setTag(this.f41852a);
        asyncTaskPriority = eVar.getAsyncTaskPriority();
        if (asyncTaskPriority == 0) {
            asyncTaskPriority = 1;
        }
        aVar2.setPriority(asyncTaskPriority);
        if (H && !v2) {
            aVar2.setParallel(f41850d);
        } else if (eVar.getAsyncTaskParallel() != null) {
            aVar2.setParallel(f41851e);
        } else {
            aVar2.setParallel(eVar.getAsyncTaskParallel());
        }
        aVar2.execute(new String[0]);
        return null;
    }

    public <T> Object m(String str, int i, c<T> cVar, BdUniqueId bdUniqueId) {
        return k(str, i, cVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public Object n(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.f41853b.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.getFromMemory(g(str, i), str, 0, 0, false, objArr);
    }

    public synchronized <T> void o(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.f41853b.get(i) == null) {
                this.f41853b.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
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
