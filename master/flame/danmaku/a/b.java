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
/* loaded from: classes6.dex */
public class b {
    public final Exception pKX = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> pKY = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> pKZ = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] pLa = new e[0];
    e<?>[] pLb = new e[0];

    /* loaded from: classes6.dex */
    public interface e<T> {
        boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext);

        void clear();

        void setData(T t);
    }

    /* loaded from: classes6.dex */
    public static abstract class a<T> implements e<T> {
        @Override // master.flame.danmaku.a.b.e
        public void clear() {
        }
    }

    /* loaded from: classes6.dex */
    public static class j extends a<List<Integer>> {
        final List<Integer> pLn = Collections.synchronizedList(new ArrayList());

        public void y(Integer num) {
            if (!this.pLn.contains(num)) {
                this.pLn.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pLn.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.pMI |= 1;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    y(num);
                }
            }
        }

        public void reset() {
            this.pLn.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int pLk = -1;
        protected master.flame.danmaku.danmaku.model.d pLl = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pLk <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.pLl == null || this.pLl.ezp()) {
                this.pLl = dVar;
                return false;
            }
            long ezz = dVar.ezz() - this.pLl.ezz();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.pOz.pOF;
            if ((ezz < 0 || gVar == null || ((float) ezz) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.pLk) {
                this.pLl = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.pMI |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: w */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.pLk) {
                this.pLk = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.pLk;
            }
        }

        public synchronized void reset() {
            this.pLl = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long ehf = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.ezq()) {
                        if (master.flame.danmaku.danmaku.c.c.eAw() - fVar.pMO >= this.ehf) {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean a2 = a(dVar, i, i2, fVar, z);
            if (a2) {
                dVar.pMI |= 4;
            }
            return a2;
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

    /* loaded from: classes6.dex */
    public static class i extends a<List<Integer>> {
        public List<Integer> pLm = new ArrayList();

        private void x(Integer num) {
            if (!this.pLm.contains(num)) {
                this.pLm.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.pLm.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.pMI |= 8;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    x(num);
                }
            }
        }

        public void reset() {
            this.pLm.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> pLo = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bY(T t) {
            if (!this.pLo.contains(t)) {
                this.pLo.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bY(t);
                }
            }
        }

        public void reset() {
            this.pLo.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pLo.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.pMI |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pLo.contains(dVar.pMG);
            if (z2) {
                dVar.pMI |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean pLh = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.pLh.booleanValue() && dVar.pMH;
            if (z2) {
                dVar.pMI |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: y */
        public void setData(Boolean bool) {
            this.pLh = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1062b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l pLc = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> pLd = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l pLe = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.eAw();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.eAw() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.ezp() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long eAw = master.flame.danmaku.danmaku.c.c.eAw();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().ezp()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.eAw() - eAw > i) {
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
                a(this.pLc, 2L);
                a(this.pLe, 2L);
                a(this.pLd, 3);
                if (!this.pLc.m(dVar) || dVar.ezq()) {
                    if (this.pLe.m(dVar)) {
                        z2 = false;
                    } else if (this.pLd.containsKey(dVar.text)) {
                        this.pLd.put(String.valueOf(dVar.text), dVar);
                        this.pLc.l(dVar);
                        this.pLc.k(dVar);
                    } else {
                        this.pLd.put(String.valueOf(dVar.text), dVar);
                        this.pLe.k(dVar);
                        z2 = false;
                    }
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean a2 = a(dVar, i, i2, fVar, z);
            if (a2) {
                dVar.pMI |= 128;
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.pLe.clear();
            this.pLc.clear();
            this.pLd.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> pLi;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pLi != null) {
                Integer num = this.pLi.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.pMI |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.pLi = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> pLj;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pLj != null) {
                Boolean bool = this.pLj.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.pMI |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.pLj = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.pLa) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.pMJ = danmakuContext.pOx.pMY;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.pLb) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.pMJ = danmakuContext.pOx.pMY;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bo(String str, boolean z) {
        e<?> eVar = z ? this.pKY.get(str) : this.pKZ.get(str);
        if (eVar == null) {
            return bp(str, z);
        }
        return eVar;
    }

    public e<?> Zp(String str) {
        return bp(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> bp(String str, boolean z) {
        j jVar;
        if (str == null) {
            eyM();
            return null;
        }
        e<?> eVar = this.pKY.get(str);
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
                jVar = new C1062b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                eyM();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.pKY.put(str, jVar);
                this.pLa = (e[]) this.pKY.values().toArray(this.pLa);
            } else {
                this.pKZ.put(str, jVar);
                this.pLb = (e[]) this.pKZ.values().toArray(this.pLb);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Zq(String str) {
        bq(str, true);
    }

    public void bq(String str, boolean z) {
        e<?> remove = z ? this.pKY.remove(str) : this.pKZ.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.pLa = (e[]) this.pKY.values().toArray(this.pLa);
            } else {
                this.pLb = (e[]) this.pKZ.values().toArray(this.pLb);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.pLa) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.pLb) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void eyM() {
        try {
            throw this.pKX;
        } catch (Exception e2) {
        }
    }
}
