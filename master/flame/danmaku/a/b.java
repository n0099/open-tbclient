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
    public final Exception oap = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> oaq = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> oar = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] oas = new e[0];
    e<?>[] oat = new e[0];

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
        final List<Integer> oaF = Collections.synchronizedList(new ArrayList());

        public void v(Integer num) {
            if (!this.oaF.contains(num)) {
                this.oaF.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oaF.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.ocb |= 1;
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
            this.oaF.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int oaC = -1;
        protected master.flame.danmaku.danmaku.model.d oaD = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oaC <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.oaD == null || this.oaD.isTimeOut()) {
                this.oaD = dVar;
                return false;
            }
            long dVF = dVar.dVF() - this.oaD.dVF();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.odU.oea;
            if ((dVF < 0 || gVar == null || ((float) dVF) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.oaC) {
                this.oaD = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.ocb |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: t */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.oaC) {
                this.oaC = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.oaC;
            }
        }

        public synchronized void reset() {
            this.oaD = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long dBp = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dVw()) {
                        if (master.flame.danmaku.danmaku.c.c.dWC() - fVar.och >= this.dBp) {
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
                dVar.ocb |= 4;
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

    /* loaded from: classes6.dex */
    public static class i extends a<List<Integer>> {
        public List<Integer> oaE = new ArrayList();

        private void u(Integer num) {
            if (!this.oaE.contains(num)) {
                this.oaE.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.oaE.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.ocb |= 8;
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
            this.oaE.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> oaG = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bN(T t) {
            if (!this.oaG.contains(t)) {
                this.oaG.add(t);
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
            this.oaG.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oaG.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.ocb |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oaG.contains(dVar.obZ);
            if (z2) {
                dVar.ocb |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean oaz = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.oaz.booleanValue() && dVar.oca;
            if (z2) {
                dVar.ocb |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Boolean bool) {
            this.oaz = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0917b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l oau = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> oav = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l oaw = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dWC();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dWC() - this.startTime > j) {
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
            long dWC = master.flame.danmaku.danmaku.c.c.dWC();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dWC() - dWC > i) {
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
                a(this.oau, 2L);
                a(this.oaw, 2L);
                a(this.oav, 3);
                if (!this.oau.m(dVar) || dVar.dVw()) {
                    if (this.oaw.m(dVar)) {
                        z2 = false;
                    } else if (this.oav.containsKey(dVar.text)) {
                        this.oav.put(String.valueOf(dVar.text), dVar);
                        this.oau.l(dVar);
                        this.oau.k(dVar);
                    } else {
                        this.oav.put(String.valueOf(dVar.text), dVar);
                        this.oaw.k(dVar);
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
                dVar.ocb |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.oaw.clear();
            this.oau.clear();
            this.oav.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> oaA;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oaA != null) {
                Integer num = this.oaA.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.ocb |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.oaA = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> oaB;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oaB != null) {
                Boolean bool = this.oaB.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.ocb |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.oaB = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oas) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.occ = danmakuContext.odS.ocs;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oat) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.occ = danmakuContext.odS.ocs;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aZ(String str, boolean z) {
        e<?> eVar = z ? this.oaq.get(str) : this.oar.get(str);
        if (eVar == null) {
            return ba(str, z);
        }
        return eVar;
    }

    public e<?> Ti(String str) {
        return ba(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> ba(String str, boolean z) {
        j jVar;
        if (str == null) {
            dUT();
            return null;
        }
        e<?> eVar = this.oaq.get(str);
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
                jVar = new C0917b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dUT();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.oaq.put(str, jVar);
                this.oas = (e[]) this.oaq.values().toArray(this.oas);
            } else {
                this.oar.put(str, jVar);
                this.oat = (e[]) this.oar.values().toArray(this.oat);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Tj(String str) {
        bb(str, true);
    }

    public void bb(String str, boolean z) {
        e<?> remove = z ? this.oaq.remove(str) : this.oar.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.oas = (e[]) this.oaq.values().toArray(this.oas);
            } else {
                this.oat = (e[]) this.oar.values().toArray(this.oat);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.oas) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.oat) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dUT() {
        try {
            throw this.oap;
        } catch (Exception e2) {
        }
    }
}
