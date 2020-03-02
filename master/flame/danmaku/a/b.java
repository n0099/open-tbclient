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
/* loaded from: classes5.dex */
public class b {
    public final Exception nEb = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> nEc = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> nEd = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] nEe = new e[0];
    e<?>[] nEf = new e[0];

    /* loaded from: classes5.dex */
    public interface e<T> {
        boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext);

        void clear();

        void setData(T t);
    }

    /* loaded from: classes5.dex */
    public static abstract class a<T> implements e<T> {
        @Override // master.flame.danmaku.a.b.e
        public void clear() {
        }
    }

    /* loaded from: classes5.dex */
    public static class j extends a<List<Integer>> {
        final List<Integer> nEr = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.nEr.contains(num)) {
                this.nEr.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nEr.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nFN |= 1;
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
            this.nEr.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends a<Integer> {
        protected int nEo = -1;
        protected master.flame.danmaku.danmaku.model.d nEp = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nEo <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.nEp == null || this.nEp.isTimeOut()) {
                this.nEp = dVar;
                return false;
            }
            long dLS = dVar.dLS() - this.nEp.dLS();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nHD.nHJ;
            if ((dLS < 0 || gVar == null || ((float) dLS) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.nEo) {
                this.nEp = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nFN |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.nEo) {
                this.nEo = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.nEo;
            }
        }

        public synchronized void reset() {
            this.nEp = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a<Object> {
        long cFC = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dLJ()) {
                        if (master.flame.danmaku.danmaku.c.c.dMP() - fVar.nFT >= this.cFC) {
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
                dVar.nFN |= 4;
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

    /* loaded from: classes5.dex */
    public static class i extends a<List<Integer>> {
        public List<Integer> nEq = new ArrayList();

        private void v(Integer num) {
            if (!this.nEq.contains(num)) {
                this.nEq.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.nEq.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nFN |= 8;
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
            this.nEq.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> nEs = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bW(T t) {
            if (!this.nEs.contains(t)) {
                this.nEs.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bW(t);
                }
            }
        }

        public void reset() {
            this.nEs.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nEs.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nFN |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nEs.contains(dVar.nFL);
            if (z2) {
                dVar.nFN |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends a<Boolean> {
        private Boolean nEl = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.nEl.booleanValue() && dVar.nFM;
            if (z2) {
                dVar.nFN |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Boolean bool) {
            this.nEl = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0774b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l nEg = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> nEh = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l nEi = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dMP();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dMP() - this.startTime > j) {
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
            long dMP = master.flame.danmaku.danmaku.c.c.dMP();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dMP() - dMP > i) {
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
                a(this.nEg, 2L);
                a(this.nEi, 2L);
                a(this.nEh, 3);
                if (!this.nEg.m(dVar) || dVar.dLJ()) {
                    if (this.nEi.m(dVar)) {
                        z2 = false;
                    } else if (this.nEh.containsKey(dVar.text)) {
                        this.nEh.put(String.valueOf(dVar.text), dVar);
                        this.nEg.l(dVar);
                        this.nEg.k(dVar);
                    } else {
                        this.nEh.put(String.valueOf(dVar.text), dVar);
                        this.nEi.k(dVar);
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
                dVar.nFN |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.nEi.clear();
            this.nEg.clear();
            this.nEh.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> nEm;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nEm != null) {
                Integer num = this.nEm.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nFN |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.nEm = map;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> nEn;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nEn != null) {
                Boolean bool = this.nEn.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nFN |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.nEn = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nEe) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nFO = danmakuContext.nHB.nGc;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nEf) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nFO = danmakuContext.nHB.nGc;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aR(String str, boolean z) {
        e<?> eVar = z ? this.nEc.get(str) : this.nEd.get(str);
        if (eVar == null) {
            return aS(str, z);
        }
        return eVar;
    }

    public e<?> Sk(String str) {
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
            dLg();
            return null;
        }
        e<?> eVar = this.nEc.get(str);
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
                jVar = new C0774b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dLg();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.nEc.put(str, jVar);
                this.nEe = (e[]) this.nEc.values().toArray(this.nEe);
            } else {
                this.nEd.put(str, jVar);
                this.nEf = (e[]) this.nEd.values().toArray(this.nEf);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Sl(String str) {
        aT(str, true);
    }

    public void aT(String str, boolean z) {
        e<?> remove = z ? this.nEc.remove(str) : this.nEd.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.nEe = (e[]) this.nEc.values().toArray(this.nEe);
            } else {
                this.nEf = (e[]) this.nEd.values().toArray(this.nEf);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.nEe) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.nEf) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dLg() {
        try {
            throw this.nEb;
        } catch (Exception e2) {
        }
    }
}
