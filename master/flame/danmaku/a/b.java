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
    public final Exception oan = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> oao = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> oap = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] oaq = new e[0];
    e<?>[] oar = new e[0];

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
        final List<Integer> oaD = Collections.synchronizedList(new ArrayList());

        public void v(Integer num) {
            if (!this.oaD.contains(num)) {
                this.oaD.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oaD.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.obZ |= 1;
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
            this.oaD.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int oaA = -1;
        protected master.flame.danmaku.danmaku.model.d oaB = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oaA <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.oaB == null || this.oaB.isTimeOut()) {
                this.oaB = dVar;
                return false;
            }
            long dVE = dVar.dVE() - this.oaB.dVE();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.odS.odY;
            if ((dVE < 0 || gVar == null || ((float) dVE) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.oaA) {
                this.oaB = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.obZ |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: t */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.oaA) {
                this.oaA = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.oaA;
            }
        }

        public synchronized void reset() {
            this.oaB = null;
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
                    if (dVar.dVv()) {
                        if (master.flame.danmaku.danmaku.c.c.dWB() - fVar.ocf >= this.dBp) {
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
                dVar.obZ |= 4;
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
        public List<Integer> oaC = new ArrayList();

        private void u(Integer num) {
            if (!this.oaC.contains(num)) {
                this.oaC.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.oaC.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.obZ |= 8;
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
            this.oaC.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> oaE = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bN(T t) {
            if (!this.oaE.contains(t)) {
                this.oaE.add(t);
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
            this.oaE.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oaE.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.obZ |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oaE.contains(dVar.obX);
            if (z2) {
                dVar.obZ |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean oax = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.oax.booleanValue() && dVar.obY;
            if (z2) {
                dVar.obZ |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Boolean bool) {
            this.oax = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0917b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l oas = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> oat = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l oau = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dWB();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dWB() - this.startTime > j) {
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
            long dWB = master.flame.danmaku.danmaku.c.c.dWB();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dWB() - dWB > i) {
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
                a(this.oas, 2L);
                a(this.oau, 2L);
                a(this.oat, 3);
                if (!this.oas.m(dVar) || dVar.dVv()) {
                    if (this.oau.m(dVar)) {
                        z2 = false;
                    } else if (this.oat.containsKey(dVar.text)) {
                        this.oat.put(String.valueOf(dVar.text), dVar);
                        this.oas.l(dVar);
                        this.oas.k(dVar);
                    } else {
                        this.oat.put(String.valueOf(dVar.text), dVar);
                        this.oau.k(dVar);
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
                dVar.obZ |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.oau.clear();
            this.oas.clear();
            this.oat.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> oay;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oay != null) {
                Integer num = this.oay.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.obZ |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.oay = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> oaz;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oaz != null) {
                Boolean bool = this.oaz.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.obZ |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.oaz = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oaq) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.oca = danmakuContext.odQ.ocp;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oar) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.oca = danmakuContext.odQ.ocp;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aZ(String str, boolean z) {
        e<?> eVar = z ? this.oao.get(str) : this.oap.get(str);
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
            dUS();
            return null;
        }
        e<?> eVar = this.oao.get(str);
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
                dUS();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.oao.put(str, jVar);
                this.oaq = (e[]) this.oao.values().toArray(this.oaq);
            } else {
                this.oap.put(str, jVar);
                this.oar = (e[]) this.oap.values().toArray(this.oar);
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
        e<?> remove = z ? this.oao.remove(str) : this.oap.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.oaq = (e[]) this.oao.values().toArray(this.oaq);
            } else {
                this.oar = (e[]) this.oap.values().toArray(this.oar);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.oaq) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.oar) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dUS() {
        try {
            throw this.oan;
        } catch (Exception e2) {
        }
    }
}
