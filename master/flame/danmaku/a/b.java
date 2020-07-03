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
    public final Exception nRB = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> nRC = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> nRD = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] nRE = new e[0];
    e<?>[] nRF = new e[0];

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
        final List<Integer> nRR = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.nRR.contains(num)) {
                this.nRR.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nRR.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nTn |= 1;
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
            this.nRR.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends a<Integer> {
        protected int nRO = -1;
        protected master.flame.danmaku.danmaku.model.d nRP = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nRO <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.nRP == null || this.nRP.isTimeOut()) {
                this.nRP = dVar;
                return false;
            }
            long dSe = dVar.dSe() - this.nRP.dSe();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nVf.nVl;
            if ((dSe < 0 || gVar == null || ((float) dSe) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.nRO) {
                this.nRP = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nTn |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.nRO) {
                this.nRO = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.nRO;
            }
        }

        public synchronized void reset() {
            this.nRP = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a<Object> {
        long dvz = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dRV()) {
                        if (master.flame.danmaku.danmaku.c.c.dTb() - fVar.nTt >= this.dvz) {
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
                dVar.nTn |= 4;
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
        public List<Integer> nRQ = new ArrayList();

        private void v(Integer num) {
            if (!this.nRQ.contains(num)) {
                this.nRQ.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.nRQ.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nTn |= 8;
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
            this.nRQ.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> nRS = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bN(T t) {
            if (!this.nRS.contains(t)) {
                this.nRS.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bN(t);
                }
            }
        }

        public void reset() {
            this.nRS.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nRS.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nTn |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nRS.contains(dVar.nTl);
            if (z2) {
                dVar.nTn |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends a<Boolean> {
        private Boolean nRL = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.nRL.booleanValue() && dVar.nTm;
            if (z2) {
                dVar.nTn |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: s */
        public void setData(Boolean bool) {
            this.nRL = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0901b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l nRG = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> nRH = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l nRI = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dTb();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dTb() - this.startTime > j) {
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
            long dTb = master.flame.danmaku.danmaku.c.c.dTb();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dTb() - dTb > i) {
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
                a(this.nRG, 2L);
                a(this.nRI, 2L);
                a(this.nRH, 3);
                if (!this.nRG.m(dVar) || dVar.dRV()) {
                    if (this.nRI.m(dVar)) {
                        z2 = false;
                    } else if (this.nRH.containsKey(dVar.text)) {
                        this.nRH.put(String.valueOf(dVar.text), dVar);
                        this.nRG.l(dVar);
                        this.nRG.k(dVar);
                    } else {
                        this.nRH.put(String.valueOf(dVar.text), dVar);
                        this.nRI.k(dVar);
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
                dVar.nTn |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.nRI.clear();
            this.nRG.clear();
            this.nRH.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> nRM;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nRM != null) {
                Integer num = this.nRM.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nTn |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.nRM = map;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> nRN;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nRN != null) {
                Boolean bool = this.nRN.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nTn |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.nRN = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nRE) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nTo = danmakuContext.nVd.nTD;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nRF) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nTo = danmakuContext.nVd.nTD;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bc(String str, boolean z) {
        e<?> eVar = z ? this.nRC.get(str) : this.nRD.get(str);
        if (eVar == null) {
            return bd(str, z);
        }
        return eVar;
    }

    public e<?> Sw(String str) {
        return bd(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> bd(String str, boolean z) {
        j jVar;
        if (str == null) {
            dRs();
            return null;
        }
        e<?> eVar = this.nRC.get(str);
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
                jVar = new C0901b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dRs();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.nRC.put(str, jVar);
                this.nRE = (e[]) this.nRC.values().toArray(this.nRE);
            } else {
                this.nRD.put(str, jVar);
                this.nRF = (e[]) this.nRD.values().toArray(this.nRF);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Sx(String str) {
        be(str, true);
    }

    public void be(String str, boolean z) {
        e<?> remove = z ? this.nRC.remove(str) : this.nRD.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.nRE = (e[]) this.nRC.values().toArray(this.nRE);
            } else {
                this.nRF = (e[]) this.nRD.values().toArray(this.nRF);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.nRE) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.nRF) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dRs() {
        try {
            throw this.nRB;
        } catch (Exception e2) {
        }
    }
}
