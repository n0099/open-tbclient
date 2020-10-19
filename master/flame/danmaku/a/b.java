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
    public final Exception oTB = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> oTC = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> oTD = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] oTE = new e[0];
    e<?>[] oTF = new e[0];

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
        final List<Integer> oTR = Collections.synchronizedList(new ArrayList());

        public void y(Integer num) {
            if (!this.oTR.contains(num)) {
                this.oTR.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oTR.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.oVm |= 1;
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
            this.oTR.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int oTO = -1;
        protected master.flame.danmaku.danmaku.model.d oTP = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oTO <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.oTP == null || this.oTP.epr()) {
                this.oTP = dVar;
                return false;
            }
            long epB = dVar.epB() - this.oTP.epB();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.oXd.oXj;
            if ((epB < 0 || gVar == null || ((float) epB) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.oTO) {
                this.oTP = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.oVm |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: w */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.oTO) {
                this.oTO = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.oTO;
            }
        }

        public synchronized void reset() {
            this.oTP = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long dYI = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.eps()) {
                        if (master.flame.danmaku.danmaku.c.c.eqy() - fVar.oVs >= this.dYI) {
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
                dVar.oVm |= 4;
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
        public List<Integer> oTQ = new ArrayList();

        private void x(Integer num) {
            if (!this.oTQ.contains(num)) {
                this.oTQ.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.oTQ.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.oVm |= 8;
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
            this.oTQ.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> oTS = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bU(T t) {
            if (!this.oTS.contains(t)) {
                this.oTS.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bU(t);
                }
            }
        }

        public void reset() {
            this.oTS.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oTS.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.oVm |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oTS.contains(dVar.oVk);
            if (z2) {
                dVar.oVm |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean oTL = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.oTL.booleanValue() && dVar.oVl;
            if (z2) {
                dVar.oVm |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: y */
        public void setData(Boolean bool) {
            this.oTL = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0990b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l oTG = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> oTH = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l oTI = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.eqy();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.eqy() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.epr() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long eqy = master.flame.danmaku.danmaku.c.c.eqy();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().epr()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.eqy() - eqy > i) {
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
                a(this.oTG, 2L);
                a(this.oTI, 2L);
                a(this.oTH, 3);
                if (!this.oTG.m(dVar) || dVar.eps()) {
                    if (this.oTI.m(dVar)) {
                        z2 = false;
                    } else if (this.oTH.containsKey(dVar.text)) {
                        this.oTH.put(String.valueOf(dVar.text), dVar);
                        this.oTG.l(dVar);
                        this.oTG.k(dVar);
                    } else {
                        this.oTH.put(String.valueOf(dVar.text), dVar);
                        this.oTI.k(dVar);
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
                dVar.oVm |= 128;
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.oTI.clear();
            this.oTG.clear();
            this.oTH.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> oTM;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oTM != null) {
                Integer num = this.oTM.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.oVm |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.oTM = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> oTN;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oTN != null) {
                Boolean bool = this.oTN.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.oVm |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.oTN = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oTE) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.oVn = danmakuContext.oXb.oVC;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oTF) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.oVn = danmakuContext.oXb.oVC;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bi(String str, boolean z) {
        e<?> eVar = z ? this.oTC.get(str) : this.oTD.get(str);
        if (eVar == null) {
            return bj(str, z);
        }
        return eVar;
    }

    public e<?> XC(String str) {
        return bj(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> bj(String str, boolean z) {
        j jVar;
        if (str == null) {
            eoO();
            return null;
        }
        e<?> eVar = this.oTC.get(str);
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
                jVar = new C0990b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                eoO();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.oTC.put(str, jVar);
                this.oTE = (e[]) this.oTC.values().toArray(this.oTE);
            } else {
                this.oTD.put(str, jVar);
                this.oTF = (e[]) this.oTD.values().toArray(this.oTF);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void XD(String str) {
        bk(str, true);
    }

    public void bk(String str, boolean z) {
        e<?> remove = z ? this.oTC.remove(str) : this.oTD.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.oTE = (e[]) this.oTC.values().toArray(this.oTE);
            } else {
                this.oTF = (e[]) this.oTD.values().toArray(this.oTF);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.oTE) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.oTF) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void eoO() {
        try {
            throw this.oTB;
        } catch (Exception e2) {
        }
    }
}
