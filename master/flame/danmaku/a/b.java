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
    public final Exception pVU = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> pVV = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> pVW = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] pVX = new e[0];
    e<?>[] pVY = new e[0];

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
        final List<Integer> pWk = Collections.synchronizedList(new ArrayList());

        public void y(Integer num) {
            if (!this.pWk.contains(num)) {
                this.pWk.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pWk.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.pXF |= 1;
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
            this.pWk.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int pWh = -1;
        protected master.flame.danmaku.danmaku.model.d pWi = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pWh <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.pWi == null || this.pWi.eDf()) {
                this.pWi = dVar;
                return false;
            }
            long eDp = dVar.eDp() - this.pWi.eDp();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.pZw.pZC;
            if ((eDp < 0 || gVar == null || ((float) eDp) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.pWh) {
                this.pWi = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.pXF |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: w */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.pWh) {
                this.pWh = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.pWh;
            }
        }

        public synchronized void reset() {
            this.pWi = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long elp = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.eDg()) {
                        if (master.flame.danmaku.danmaku.c.c.eEm() - fVar.pXL >= this.elp) {
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
                dVar.pXF |= 4;
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
        public List<Integer> pWj = new ArrayList();

        private void x(Integer num) {
            if (!this.pWj.contains(num)) {
                this.pWj.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.pWj.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.pXF |= 8;
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
            this.pWj.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> pWl = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bZ(T t) {
            if (!this.pWl.contains(t)) {
                this.pWl.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bZ(t);
                }
            }
        }

        public void reset() {
            this.pWl.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pWl.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.pXF |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pWl.contains(dVar.pXD);
            if (z2) {
                dVar.pXF |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean pWe = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.pWe.booleanValue() && dVar.pXE;
            if (z2) {
                dVar.pXF |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: y */
        public void setData(Boolean bool) {
            this.pWe = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1085b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l pVZ = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> pWa = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l pWb = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.eEm();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.eEm() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.eDf() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long eEm = master.flame.danmaku.danmaku.c.c.eEm();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().eDf()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.eEm() - eEm > i) {
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
                a(this.pVZ, 2L);
                a(this.pWb, 2L);
                a(this.pWa, 3);
                if (!this.pVZ.m(dVar) || dVar.eDg()) {
                    if (this.pWb.m(dVar)) {
                        z2 = false;
                    } else if (this.pWa.containsKey(dVar.text)) {
                        this.pWa.put(String.valueOf(dVar.text), dVar);
                        this.pVZ.l(dVar);
                        this.pVZ.k(dVar);
                    } else {
                        this.pWa.put(String.valueOf(dVar.text), dVar);
                        this.pWb.k(dVar);
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
                dVar.pXF |= 128;
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.pWb.clear();
            this.pVZ.clear();
            this.pWa.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> pWf;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pWf != null) {
                Integer num = this.pWf.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.pXF |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.pWf = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> pWg;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pWg != null) {
                Boolean bool = this.pWg.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.pXF |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.pWg = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.pVX) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.pXG = danmakuContext.pZu.pXV;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.pVY) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.pXG = danmakuContext.pZu.pXV;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bq(String str, boolean z) {
        e<?> eVar = z ? this.pVV.get(str) : this.pVW.get(str);
        if (eVar == null) {
            return br(str, z);
        }
        return eVar;
    }

    public e<?> ZE(String str) {
        return br(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> br(String str, boolean z) {
        j jVar;
        if (str == null) {
            eCC();
            return null;
        }
        e<?> eVar = this.pVV.get(str);
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
                jVar = new C1085b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                eCC();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.pVV.put(str, jVar);
                this.pVX = (e[]) this.pVV.values().toArray(this.pVX);
            } else {
                this.pVW.put(str, jVar);
                this.pVY = (e[]) this.pVW.values().toArray(this.pVY);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void ZF(String str) {
        bs(str, true);
    }

    public void bs(String str, boolean z) {
        e<?> remove = z ? this.pVV.remove(str) : this.pVW.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.pVX = (e[]) this.pVV.values().toArray(this.pVX);
            } else {
                this.pVY = (e[]) this.pVW.values().toArray(this.pVY);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.pVX) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.pVY) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void eCC() {
        try {
            throw this.pVU;
        } catch (Exception e2) {
        }
    }
}
