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
    public final Exception pUr = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> pUs = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> pUt = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] pUu = new e[0];
    e<?>[] pUv = new e[0];

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
        final List<Integer> pUH = Collections.synchronizedList(new ArrayList());

        public void y(Integer num) {
            if (!this.pUH.contains(num)) {
                this.pUH.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pUH.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.pWc |= 1;
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
            this.pUH.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int pUE = -1;
        protected master.flame.danmaku.danmaku.model.d pUF = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pUE <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.pUF == null || this.pUF.eDe()) {
                this.pUF = dVar;
                return false;
            }
            long eDo = dVar.eDo() - this.pUF.eDo();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.pXT.pXZ;
            if ((eDo < 0 || gVar == null || ((float) eDo) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.pUE) {
                this.pUF = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.pWc |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: w */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.pUE) {
                this.pUE = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.pUE;
            }
        }

        public synchronized void reset() {
            this.pUF = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long emW = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.eDf()) {
                        if (master.flame.danmaku.danmaku.c.c.eEl() - fVar.pWi >= this.emW) {
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
                dVar.pWc |= 4;
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
        public List<Integer> pUG = new ArrayList();

        private void x(Integer num) {
            if (!this.pUG.contains(num)) {
                this.pUG.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.pUG.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.pWc |= 8;
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
            this.pUG.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> pUI = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bY(T t) {
            if (!this.pUI.contains(t)) {
                this.pUI.add(t);
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
            this.pUI.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pUI.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.pWc |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.pUI.contains(dVar.pWa);
            if (z2) {
                dVar.pWc |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean pUB = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.pUB.booleanValue() && dVar.pWb;
            if (z2) {
                dVar.pWc |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: y */
        public void setData(Boolean bool) {
            this.pUB = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1082b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l pUw = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> pUx = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l pUy = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.eEl();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.eEl() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.eDe() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long eEl = master.flame.danmaku.danmaku.c.c.eEl();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().eDe()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.eEl() - eEl > i) {
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
                a(this.pUw, 2L);
                a(this.pUy, 2L);
                a(this.pUx, 3);
                if (!this.pUw.m(dVar) || dVar.eDf()) {
                    if (this.pUy.m(dVar)) {
                        z2 = false;
                    } else if (this.pUx.containsKey(dVar.text)) {
                        this.pUx.put(String.valueOf(dVar.text), dVar);
                        this.pUw.l(dVar);
                        this.pUw.k(dVar);
                    } else {
                        this.pUx.put(String.valueOf(dVar.text), dVar);
                        this.pUy.k(dVar);
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
                dVar.pWc |= 128;
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.pUy.clear();
            this.pUw.clear();
            this.pUx.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> pUC;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pUC != null) {
                Integer num = this.pUC.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.pWc |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.pUC = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> pUD;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.pUD != null) {
                Boolean bool = this.pUD.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.pWc |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.pUD = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.pUu) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.pWd = danmakuContext.pXR.pWs;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.pUv) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.pWd = danmakuContext.pXR.pWs;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bq(String str, boolean z) {
        e<?> eVar = z ? this.pUs.get(str) : this.pUt.get(str);
        if (eVar == null) {
            return br(str, z);
        }
        return eVar;
    }

    public e<?> ZT(String str) {
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
            eCB();
            return null;
        }
        e<?> eVar = this.pUs.get(str);
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
                jVar = new C1082b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                eCB();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.pUs.put(str, jVar);
                this.pUu = (e[]) this.pUs.values().toArray(this.pUu);
            } else {
                this.pUt.put(str, jVar);
                this.pUv = (e[]) this.pUt.values().toArray(this.pUv);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void ZU(String str) {
        bs(str, true);
    }

    public void bs(String str, boolean z) {
        e<?> remove = z ? this.pUs.remove(str) : this.pUt.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.pUu = (e[]) this.pUs.values().toArray(this.pUu);
            } else {
                this.pUv = (e[]) this.pUt.values().toArray(this.pUv);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.pUu) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.pUv) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void eCB() {
        try {
            throw this.pUr;
        } catch (Exception e2) {
        }
    }
}
