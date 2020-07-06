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
    public final Exception nRE = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> nRF = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> nRG = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] nRH = new e[0];
    e<?>[] nRI = new e[0];

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
        final List<Integer> nRU = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.nRU.contains(num)) {
                this.nRU.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nRU.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nTq |= 1;
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
            this.nRU.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends a<Integer> {
        protected int nRR = -1;
        protected master.flame.danmaku.danmaku.model.d nRS = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nRR <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.nRS == null || this.nRS.isTimeOut()) {
                this.nRS = dVar;
                return false;
            }
            long dSi = dVar.dSi() - this.nRS.dSi();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nVi.nVo;
            if ((dSi < 0 || gVar == null || ((float) dSi) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.nRR) {
                this.nRS = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nTq |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.nRR) {
                this.nRR = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.nRR;
            }
        }

        public synchronized void reset() {
            this.nRS = null;
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
                    if (dVar.dRZ()) {
                        if (master.flame.danmaku.danmaku.c.c.dTf() - fVar.nTw >= this.dvz) {
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
                dVar.nTq |= 4;
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
        public List<Integer> nRT = new ArrayList();

        private void v(Integer num) {
            if (!this.nRT.contains(num)) {
                this.nRT.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.nRT.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nTq |= 8;
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
            this.nRT.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> nRV = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bN(T t) {
            if (!this.nRV.contains(t)) {
                this.nRV.add(t);
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
            this.nRV.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nRV.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nTq |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nRV.contains(dVar.nTo);
            if (z2) {
                dVar.nTq |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends a<Boolean> {
        private Boolean nRO = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.nRO.booleanValue() && dVar.nTp;
            if (z2) {
                dVar.nTq |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: s */
        public void setData(Boolean bool) {
            this.nRO = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0902b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l nRJ = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> nRK = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l nRL = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dTf();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dTf() - this.startTime > j) {
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
            long dTf = master.flame.danmaku.danmaku.c.c.dTf();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dTf() - dTf > i) {
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
                a(this.nRJ, 2L);
                a(this.nRL, 2L);
                a(this.nRK, 3);
                if (!this.nRJ.m(dVar) || dVar.dRZ()) {
                    if (this.nRL.m(dVar)) {
                        z2 = false;
                    } else if (this.nRK.containsKey(dVar.text)) {
                        this.nRK.put(String.valueOf(dVar.text), dVar);
                        this.nRJ.l(dVar);
                        this.nRJ.k(dVar);
                    } else {
                        this.nRK.put(String.valueOf(dVar.text), dVar);
                        this.nRL.k(dVar);
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
                dVar.nTq |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.nRL.clear();
            this.nRJ.clear();
            this.nRK.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> nRP;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nRP != null) {
                Integer num = this.nRP.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nTq |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.nRP = map;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> nRQ;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nRQ != null) {
                Boolean bool = this.nRQ.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nTq |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.nRQ = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nRH) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nTr = danmakuContext.nVg.nTG;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nRI) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nTr = danmakuContext.nVg.nTG;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bc(String str, boolean z) {
        e<?> eVar = z ? this.nRF.get(str) : this.nRG.get(str);
        if (eVar == null) {
            return bd(str, z);
        }
        return eVar;
    }

    public e<?> Sx(String str) {
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
            dRw();
            return null;
        }
        e<?> eVar = this.nRF.get(str);
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
                jVar = new C0902b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dRw();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.nRF.put(str, jVar);
                this.nRH = (e[]) this.nRF.values().toArray(this.nRH);
            } else {
                this.nRG.put(str, jVar);
                this.nRI = (e[]) this.nRG.values().toArray(this.nRI);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Sy(String str) {
        be(str, true);
    }

    public void be(String str, boolean z) {
        e<?> remove = z ? this.nRF.remove(str) : this.nRG.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.nRH = (e[]) this.nRF.values().toArray(this.nRH);
            } else {
                this.nRI = (e[]) this.nRG.values().toArray(this.nRI);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.nRH) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.nRI) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dRw() {
        try {
            throw this.nRE;
        } catch (Exception e2) {
        }
    }
}
