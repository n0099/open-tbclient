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
    public final Exception nDZ = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> nEa = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> nEb = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] nEc = new e[0];
    e<?>[] nEd = new e[0];

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
        final List<Integer> nEp = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.nEp.contains(num)) {
                this.nEp.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nEp.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nFL |= 1;
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
            this.nEp.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends a<Integer> {
        protected int nEm = -1;
        protected master.flame.danmaku.danmaku.model.d nEn = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nEm <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.nEn == null || this.nEn.isTimeOut()) {
                this.nEn = dVar;
                return false;
            }
            long dLQ = dVar.dLQ() - this.nEn.dLQ();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nHB.nHH;
            if ((dLQ < 0 || gVar == null || ((float) dLQ) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.nEm) {
                this.nEn = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nFL |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.nEm) {
                this.nEm = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.nEm;
            }
        }

        public synchronized void reset() {
            this.nEn = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a<Object> {
        long cFB = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dLH()) {
                        if (master.flame.danmaku.danmaku.c.c.dMN() - fVar.nFR >= this.cFB) {
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
                dVar.nFL |= 4;
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
        public List<Integer> nEo = new ArrayList();

        private void v(Integer num) {
            if (!this.nEo.contains(num)) {
                this.nEo.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.nEo.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nFL |= 8;
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
            this.nEo.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> nEq = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bW(T t) {
            if (!this.nEq.contains(t)) {
                this.nEq.add(t);
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
            this.nEq.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nEq.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nFL |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nEq.contains(dVar.nFJ);
            if (z2) {
                dVar.nFL |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends a<Boolean> {
        private Boolean nEj = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.nEj.booleanValue() && dVar.nFK;
            if (z2) {
                dVar.nFL |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Boolean bool) {
            this.nEj = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0774b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l nEe = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> nEf = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l nEg = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dMN();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dMN() - this.startTime > j) {
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
            long dMN = master.flame.danmaku.danmaku.c.c.dMN();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dMN() - dMN > i) {
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
                a(this.nEe, 2L);
                a(this.nEg, 2L);
                a(this.nEf, 3);
                if (!this.nEe.m(dVar) || dVar.dLH()) {
                    if (this.nEg.m(dVar)) {
                        z2 = false;
                    } else if (this.nEf.containsKey(dVar.text)) {
                        this.nEf.put(String.valueOf(dVar.text), dVar);
                        this.nEe.l(dVar);
                        this.nEe.k(dVar);
                    } else {
                        this.nEf.put(String.valueOf(dVar.text), dVar);
                        this.nEg.k(dVar);
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
                dVar.nFL |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.nEg.clear();
            this.nEe.clear();
            this.nEf.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> nEk;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nEk != null) {
                Integer num = this.nEk.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nFL |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.nEk = map;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> nEl;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nEl != null) {
                Boolean bool = this.nEl.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nFL |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.nEl = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nEc) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nFM = danmakuContext.nHz.nGa;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nEd) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nFM = danmakuContext.nHz.nGa;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aR(String str, boolean z) {
        e<?> eVar = z ? this.nEa.get(str) : this.nEb.get(str);
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
            dLe();
            return null;
        }
        e<?> eVar = this.nEa.get(str);
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
                dLe();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.nEa.put(str, jVar);
                this.nEc = (e[]) this.nEa.values().toArray(this.nEc);
            } else {
                this.nEb.put(str, jVar);
                this.nEd = (e[]) this.nEb.values().toArray(this.nEd);
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
        e<?> remove = z ? this.nEa.remove(str) : this.nEb.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.nEc = (e[]) this.nEa.values().toArray(this.nEc);
            } else {
                this.nEd = (e[]) this.nEb.values().toArray(this.nEd);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.nEc) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.nEd) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dLe() {
        try {
            throw this.nDZ;
        } catch (Exception e2) {
        }
    }
}
