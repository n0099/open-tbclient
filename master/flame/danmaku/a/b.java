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
    public final Exception mZz = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> mZA = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> mZB = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] mZC = new e[0];
    e<?>[] mZD = new e[0];

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
        final List<Integer> mZP = Collections.synchronizedList(new ArrayList());

        public void v(Integer num) {
            if (!this.mZP.contains(num)) {
                this.mZP.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.mZP.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nbm |= 1;
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
            this.mZP.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends a<Integer> {
        protected int mZM = -1;
        protected master.flame.danmaku.danmaku.model.d mZN = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.mZM <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.mZN == null || this.mZN.isTimeOut()) {
                this.mZN = dVar;
                return false;
            }
            long dFt = dVar.dFt() - this.mZN.dFt();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nde.ndk;
            if ((dFt < 0 || gVar == null || ((float) dFt) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.mZM) {
                this.mZN = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nbm |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: t */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.mZM) {
                this.mZM = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.mZM;
            }
        }

        public synchronized void reset() {
            this.mZN = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a<Object> {
        long deP = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dFk()) {
                        if (master.flame.danmaku.danmaku.c.c.dGq() - fVar.nbs >= this.deP) {
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
                dVar.nbm |= 4;
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
        public List<Integer> mZO = new ArrayList();

        private void u(Integer num) {
            if (!this.mZO.contains(num)) {
                this.mZO.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.mZO.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nbm |= 8;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    u(num);
                }
            }
        }

        public void reset() {
            this.mZO.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> mZQ = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bF(T t) {
            if (!this.mZQ.contains(t)) {
                this.mZQ.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bF(t);
                }
            }
        }

        public void reset() {
            this.mZQ.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.mZQ.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nbm |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.mZQ.contains(dVar.nbk);
            if (z2) {
                dVar.nbm |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends a<Boolean> {
        private Boolean mZJ = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.mZJ.booleanValue() && dVar.nbl;
            if (z2) {
                dVar.nbm |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Boolean bool) {
            this.mZJ = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0798b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l mZE = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> mZF = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l mZG = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dGq();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dGq() - this.startTime > j) {
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
            long dGq = master.flame.danmaku.danmaku.c.c.dGq();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dGq() - dGq > i) {
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
                a(this.mZE, 2L);
                a(this.mZG, 2L);
                a(this.mZF, 3);
                if (!this.mZE.m(dVar) || dVar.dFk()) {
                    if (this.mZG.m(dVar)) {
                        z2 = false;
                    } else if (this.mZF.containsKey(dVar.text)) {
                        this.mZF.put(String.valueOf(dVar.text), dVar);
                        this.mZE.l(dVar);
                        this.mZE.k(dVar);
                    } else {
                        this.mZF.put(String.valueOf(dVar.text), dVar);
                        this.mZG.k(dVar);
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
                dVar.nbm |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.mZG.clear();
            this.mZE.clear();
            this.mZF.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> mZK;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.mZK != null) {
                Integer num = this.mZK.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nbm |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.mZK = map;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> mZL;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.mZL != null) {
                Boolean bool = this.mZL.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nbm |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.mZL = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.mZC) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nbn = danmakuContext.ndc.nbC;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.mZD) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nbn = danmakuContext.ndc.nbC;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aN(String str, boolean z) {
        e<?> eVar = z ? this.mZA.get(str) : this.mZB.get(str);
        if (eVar == null) {
            return aO(str, z);
        }
        return eVar;
    }

    public e<?> PA(String str) {
        return aO(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> aO(String str, boolean z) {
        j jVar;
        if (str == null) {
            dEH();
            return null;
        }
        e<?> eVar = this.mZA.get(str);
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
                jVar = new C0798b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dEH();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.mZA.put(str, jVar);
                this.mZC = (e[]) this.mZA.values().toArray(this.mZC);
            } else {
                this.mZB.put(str, jVar);
                this.mZD = (e[]) this.mZB.values().toArray(this.mZD);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void PB(String str) {
        aP(str, true);
    }

    public void aP(String str, boolean z) {
        e<?> remove = z ? this.mZA.remove(str) : this.mZB.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.mZC = (e[]) this.mZA.values().toArray(this.mZC);
            } else {
                this.mZD = (e[]) this.mZB.values().toArray(this.mZD);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.mZC) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.mZD) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dEH() {
        try {
            throw this.mZz;
        } catch (Exception e2) {
        }
    }
}
