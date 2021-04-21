package d.b.c.e.l;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.l.b;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f42586c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f42587d;

    /* renamed from: e  reason: collision with root package name */
    public static BdAsyncTaskParallel f42588e;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f42589a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<e<?>> f42590b;

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f42591a;

        /* renamed from: b  reason: collision with root package name */
        public final int f42592b;

        /* renamed from: c  reason: collision with root package name */
        public int f42593c;

        /* renamed from: d  reason: collision with root package name */
        public int f42594d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42595e;

        /* renamed from: f  reason: collision with root package name */
        public Object[] f42596f;

        /* renamed from: g  reason: collision with root package name */
        public int f42597g = 2;
        public final Map<c<T>, BdUniqueId> i = new HashMap();
        public final b j = new b();

        /* renamed from: h  reason: collision with root package name */
        public long f42598h = System.currentTimeMillis();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.f42593c = 0;
            this.f42594d = 0;
            this.f42595e = false;
            this.f42596f = null;
            this.f42591a = str;
            this.f42592b = i;
            this.f42593c = i2;
            this.f42594d = i3;
            this.f42595e = z;
            this.f42596f = objArr;
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
            if (bVar != null && (aVar = bVar.f42585a) != null) {
                aVar.cancel();
            }
            if (this.i.size() == 0) {
                return;
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.f42591a);
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
                cVar.onCancelled(this.f42591a);
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
            d.b.c.e.l.a.m(true, System.currentTimeMillis() - this.f42598h);
            e eVar = (e) d.this.f42590b.get(this.f42592b);
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
            T t2 = (T) eVar.getFromLocal(this.f42591a, key, this.f42593c, this.f42594d, this.j, this.f42596f);
            if (t2 != null) {
                return t2;
            }
            t = t2;
            if (isCancelled() || this.f42595e) {
                return null;
            }
            this.f42597g = 3;
            try {
                return (T) eVar.getFromRemote(this.f42591a, key, this.f42593c, this.f42594d, this.j, this.f42596f);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                return t;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.f42590b.get(this.f42592b)) != null) {
                eVar.updateMemory(d.this.g(this.f42591a, this.f42592b), t, this.f42593c, this.f42594d, this.f42596f);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.f42591a, this.f42597g);
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
        this.f42590b = null;
        BdUniqueId gen = BdUniqueId.gen();
        f42587d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        f42588e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.f42590b = new SparseArray<>();
    }

    public static d h() {
        if (f42586c == null) {
            synchronized (d.class) {
                if (f42586c == null) {
                    f42586c = new d();
                }
            }
        }
        return f42586c;
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.f42589a);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f42589a);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.f42589a);
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
        SparseArray<e<?>> sparseArray = this.f42590b;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public boolean j(int i) {
        e<?> eVar = this.f42590b.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.isNeedLoad();
    }

    public <T> Object k(String str, int i, c<T> cVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return l(str, i, cVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: d.b.c.e.l.c<T> */
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
        if (TextUtils.isEmpty(str) || (eVar = this.f42590b.get(i)) == null) {
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
                    aVar.setTag(this.f42589a);
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
        aVar2.setTag(this.f42589a);
        asyncTaskPriority = eVar.getAsyncTaskPriority();
        if (asyncTaskPriority == 0) {
            asyncTaskPriority = 1;
        }
        aVar2.setPriority(asyncTaskPriority);
        if (H && !v2) {
            aVar2.setParallel(f42587d);
        } else if (eVar.getAsyncTaskParallel() != null) {
            aVar2.setParallel(f42588e);
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
        e<?> eVar = this.f42590b.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.getFromMemory(g(str, i), str, 0, 0, false, objArr);
    }

    public synchronized <T> void o(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.f42590b.get(i) == null) {
                this.f42590b.put(i, eVar);
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
