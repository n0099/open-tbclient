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
    public final Exception oEm = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> oEn = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> oEo = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] oEp = new e[0];
    e<?>[] oEq = new e[0];

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
        final List<Integer> oEC = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.oEC.contains(num)) {
                this.oEC.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oEC.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.oFX |= 1;
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
            this.oEC.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int oEz = -1;
        protected master.flame.danmaku.danmaku.model.d oEA = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oEz <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.oEA == null || this.oEA.elE()) {
                this.oEA = dVar;
                return false;
            }
            long elO = dVar.elO() - this.oEA.elO();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.oHO.oHU;
            if ((elO < 0 || gVar == null || ((float) elO) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.oEz) {
                this.oEA = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.oFX |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.oEz) {
                this.oEz = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.oEz;
            }
        }

        public synchronized void reset() {
            this.oEA = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long dMH = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.elF()) {
                        if (master.flame.danmaku.danmaku.c.c.emL() - fVar.oGd >= this.dMH) {
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
                dVar.oFX |= 4;
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
        public List<Integer> oEB = new ArrayList();

        private void v(Integer num) {
            if (!this.oEB.contains(num)) {
                this.oEB.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.oEB.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.oFX |= 8;
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
            this.oEB.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> oED = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bR(T t) {
            if (!this.oED.contains(t)) {
                this.oED.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bR(t);
                }
            }
        }

        public void reset() {
            this.oED.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oED.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.oFX |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.oED.contains(dVar.oFV);
            if (z2) {
                dVar.oFX |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean oEw = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.oEw.booleanValue() && dVar.oFW;
            if (z2) {
                dVar.oFX |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: x */
        public void setData(Boolean bool) {
            this.oEw = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0972b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l oEr = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> oEs = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l oEt = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.emL();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.emL() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.elE() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long emL = master.flame.danmaku.danmaku.c.c.emL();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().elE()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.emL() - emL > i) {
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
                a(this.oEr, 2L);
                a(this.oEt, 2L);
                a(this.oEs, 3);
                if (!this.oEr.m(dVar) || dVar.elF()) {
                    if (this.oEt.m(dVar)) {
                        z2 = false;
                    } else if (this.oEs.containsKey(dVar.text)) {
                        this.oEs.put(String.valueOf(dVar.text), dVar);
                        this.oEr.l(dVar);
                        this.oEr.k(dVar);
                    } else {
                        this.oEs.put(String.valueOf(dVar.text), dVar);
                        this.oEt.k(dVar);
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
                dVar.oFX |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.oEt.clear();
            this.oEr.clear();
            this.oEs.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> oEx;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oEx != null) {
                Integer num = this.oEx.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.oFX |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.oEx = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> oEy;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.oEy != null) {
                Boolean bool = this.oEy.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.oFX |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.oEy = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oEp) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.oFY = danmakuContext.oHM.oGn;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.oEq) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.oFY = danmakuContext.oHM.oGn;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> be(String str, boolean z) {
        e<?> eVar = z ? this.oEn.get(str) : this.oEo.get(str);
        if (eVar == null) {
            return bf(str, z);
        }
        return eVar;
    }

    public e<?> WO(String str) {
        return bf(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> bf(String str, boolean z) {
        j jVar;
        if (str == null) {
            elb();
            return null;
        }
        e<?> eVar = this.oEn.get(str);
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
                jVar = new C0972b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                elb();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.oEn.put(str, jVar);
                this.oEp = (e[]) this.oEn.values().toArray(this.oEp);
            } else {
                this.oEo.put(str, jVar);
                this.oEq = (e[]) this.oEo.values().toArray(this.oEq);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void WP(String str) {
        bg(str, true);
    }

    public void bg(String str, boolean z) {
        e<?> remove = z ? this.oEn.remove(str) : this.oEo.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.oEp = (e[]) this.oEn.values().toArray(this.oEp);
            } else {
                this.oEq = (e[]) this.oEo.values().toArray(this.oEq);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.oEp) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.oEq) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void elb() {
        try {
            throw this.oEm;
        } catch (Exception e2) {
        }
    }
}
