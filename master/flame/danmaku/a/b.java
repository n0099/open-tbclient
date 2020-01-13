package master.flame.danmaku.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes4.dex */
public class b {
    public final Exception nDb = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> nDc = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> nDd = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] nDe = new e[0];
    e<?>[] nDf = new e[0];

    /* loaded from: classes4.dex */
    public interface e<T> {
        boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext);

        void clear();

        void setData(T t);
    }

    /* loaded from: classes4.dex */
    public static abstract class a<T> implements e<T> {
        @Override // master.flame.danmaku.a.b.e
        public void clear() {
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends a<List<Integer>> {
        final List<Integer> nDs = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.nDs.contains(num)) {
                this.nDs.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nDs.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nEO |= 1;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    w(num);
                }
            }
        }

        public void reset() {
            this.nDs.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends a<Integer> {
        protected int nDo = -1;
        protected master.flame.danmaku.danmaku.model.d nDp = null;
        private float nDq = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nDo <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.nDp == null || this.nDp.isTimeOut()) {
                this.nDp = dVar;
                return false;
            }
            long dKB = dVar.dKB() - this.nDp.dKB();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nGF.nGL;
            if ((dKB < 0 || gVar == null || ((float) dKB) >= ((float) gVar.value) * this.nDq) && i <= this.nDo) {
                this.nDp = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nEO |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.nDo) {
                this.nDo = num.intValue() + (num.intValue() / 5);
                this.nDq = 1.0f / this.nDo;
            }
        }

        public synchronized void reset() {
            this.nDp = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends a<Object> {
        long cBD = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dKs()) {
                        if (master.flame.danmaku.danmaku.c.c.dLy() - fVar.nEU >= this.cBD) {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean a = a(dVar, i, i2, fVar, z);
            if (a) {
                dVar.nEO |= 4;
            }
            return a;
        }

        @Override // master.flame.danmaku.a.b.e
        public void setData(Object obj) {
            reset();
        }

        public synchronized void reset() {
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends a<List<Integer>> {
        public List<Integer> nDr = new ArrayList();

        private void v(Integer num) {
            if (!this.nDr.contains(num)) {
                this.nDr.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.nDr.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nEO |= 8;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    v(num);
                }
            }
        }

        public void reset() {
            this.nDr.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> nDt = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bV(T t) {
            if (!this.nDt.contains(t)) {
                this.nDt.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bV(t);
                }
            }
        }

        public void reset() {
            this.nDt.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nDt.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nEO |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nDt.contains(dVar.nEM);
            if (z2) {
                dVar.nEO |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends a<Boolean> {
        private Boolean nDl = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.nDl.booleanValue() && dVar.nEN;
            if (z2) {
                dVar.nEO |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Boolean bool) {
            this.nDl = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0766b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l nDg = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> nDh = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l nDi = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dLy();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dLy() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.isTimeOut() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long dLy = master.flame.danmaku.danmaku.c.c.dLy();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dLy() - dLy > i) {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    return;
                }
            }
        }

        public synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = true;
            synchronized (this) {
                a(this.nDg, 2L);
                a(this.nDi, 2L);
                a(this.nDh, 3);
                if (!this.nDg.m(dVar) || dVar.dKs()) {
                    if (this.nDi.m(dVar)) {
                        z2 = false;
                    } else if (this.nDh.containsKey(dVar.text)) {
                        this.nDh.put(String.valueOf(dVar.text), dVar);
                        this.nDg.l(dVar);
                        this.nDg.k(dVar);
                    } else {
                        this.nDh.put(String.valueOf(dVar.text), dVar);
                        this.nDi.k(dVar);
                        z2 = false;
                    }
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean a = a(dVar, i, i2, fVar, z);
            if (a) {
                dVar.nEO |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.nDi.clear();
            this.nDg.clear();
            this.nDh.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> nDm;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nDm != null) {
                Integer num = this.nDm.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nEO |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.nDm = map;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> nDn;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nDn != null) {
                Boolean bool = this.nDn.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nEO |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.nDn = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nDe) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nEP = danmakuContext.nGD.nFd;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nDf) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nEP = danmakuContext.nGD.nFd;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aR(String str, boolean z) {
        e<?> eVar = z ? this.nDc.get(str) : this.nDd.get(str);
        if (eVar == null) {
            return aS(str, z);
        }
        return eVar;
    }

    public e<?> RZ(String str) {
        return aS(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> aS(String str, boolean z) {
        j jVar;
        if (str == null) {
            dJP();
            return null;
        }
        e<?> eVar = this.nDc.get(str);
        if (eVar == null) {
            if ("1010_Filter".equals(str)) {
                jVar = new j();
            } else if ("1011_Filter".equals(str)) {
                jVar = new h();
            } else if ("1012_Filter".equals(str)) {
                jVar = new c();
            } else if ("1013_Filter".equals(str)) {
                jVar = new i();
            } else if ("1014_Filter".equals(str)) {
                jVar = new m();
            } else if ("1015_Filter".equals(str)) {
                jVar = new l();
            } else if ("1016_Filter".equals(str)) {
                jVar = new d();
            } else if ("1017_Filter".equals(str)) {
                jVar = new C0766b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dJP();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.nDc.put(str, jVar);
                this.nDe = (e[]) this.nDc.values().toArray(this.nDe);
            } else {
                this.nDd.put(str, jVar);
                this.nDf = (e[]) this.nDd.values().toArray(this.nDf);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Sa(String str) {
        aT(str, true);
    }

    public void aT(String str, boolean z) {
        e<?> remove = z ? this.nDc.remove(str) : this.nDd.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.nDe = (e[]) this.nDc.values().toArray(this.nDe);
            } else {
                this.nDf = (e[]) this.nDd.values().toArray(this.nDf);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.nDe) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.nDf) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dJP() {
        try {
            throw this.nDb;
        } catch (Exception e2) {
        }
    }
}
