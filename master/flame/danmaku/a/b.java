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
/* loaded from: classes4.dex */
public class b {
    public final Exception nDg = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> nDh = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> nDi = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] nDj = new e[0];
    e<?>[] nDk = new e[0];

    /* loaded from: classes4.dex */
    public interface e<T> {
        boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext);

        void clear();

        void setData(T t);
    }

    /* loaded from: classes4.dex */
    public static abstract class a<T> implements e<T> {
        @Override // master.flame.danmaku.a.b.e
        public void clear() {
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends a<List<Integer>> {
        final List<Integer> nDx = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.nDx.contains(num)) {
                this.nDx.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nDx.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.nET |= 1;
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
            this.nDx.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends a<Integer> {
        protected int nDt = -1;
        protected master.flame.danmaku.danmaku.model.d nDu = null;
        private float nDv = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nDt <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.nDu == null || this.nDu.isTimeOut()) {
                this.nDu = dVar;
                return false;
            }
            long dKD = dVar.dKD() - this.nDu.dKD();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.nGK.nGQ;
            if ((dKD < 0 || gVar == null || ((float) dKD) >= ((float) gVar.value) * this.nDv) && i <= this.nDt) {
                this.nDu = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.nET |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.nDt) {
                this.nDt = num.intValue() + (num.intValue() / 5);
                this.nDv = 1.0f / this.nDt;
            }
        }

        public synchronized void reset() {
            this.nDu = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends a<Object> {
        long cBD = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.dKu()) {
                        if (master.flame.danmaku.danmaku.c.c.dLA() - fVar.nEZ >= this.cBD) {
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
                dVar.nET |= 4;
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

    /* loaded from: classes4.dex */
    public static class i extends a<List<Integer>> {
        public List<Integer> nDw = new ArrayList();

        private void v(Integer num) {
            if (!this.nDw.contains(num)) {
                this.nDw.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.nDw.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.nET |= 8;
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
            this.nDw.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> nDy = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bV(T t) {
            if (!this.nDy.contains(t)) {
                this.nDy.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bV(t);
                }
            }
        }

        public void reset() {
            this.nDy.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nDy.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.nET |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.nDy.contains(dVar.nER);
            if (z2) {
                dVar.nET |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends a<Boolean> {
        private Boolean nDq = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.nDq.booleanValue() && dVar.nES;
            if (z2) {
                dVar.nET |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Boolean bool) {
            this.nDq = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0766b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l nDl = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> nDm = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l nDn = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.dLA();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.dLA() - this.startTime > j) {
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
            long dLA = master.flame.danmaku.danmaku.c.c.dLA();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().isTimeOut()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.dLA() - dLA > i) {
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
                a(this.nDl, 2L);
                a(this.nDn, 2L);
                a(this.nDm, 3);
                if (!this.nDl.m(dVar) || dVar.dKu()) {
                    if (this.nDn.m(dVar)) {
                        z2 = false;
                    } else if (this.nDm.containsKey(dVar.text)) {
                        this.nDm.put(String.valueOf(dVar.text), dVar);
                        this.nDl.l(dVar);
                        this.nDl.k(dVar);
                    } else {
                        this.nDm.put(String.valueOf(dVar.text), dVar);
                        this.nDn.k(dVar);
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
                dVar.nET |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.nDn.clear();
            this.nDl.clear();
            this.nDm.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> nDr;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nDr != null) {
                Integer num = this.nDr.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.nET |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.nDr = map;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> nDs;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.nDs != null) {
                Boolean bool = this.nDs.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.nET |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.nDs = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nDj) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nEU = danmakuContext.nGI.nFi;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.nDk) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.nEU = danmakuContext.nGI.nFi;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> aR(String str, boolean z) {
        e<?> eVar = z ? this.nDh.get(str) : this.nDi.get(str);
        if (eVar == null) {
            return aS(str, z);
        }
        return eVar;
    }

    public e<?> RZ(String str) {
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
            dJR();
            return null;
        }
        e<?> eVar = this.nDh.get(str);
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
                jVar = new C0766b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                dJR();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.nDh.put(str, jVar);
                this.nDj = (e[]) this.nDh.values().toArray(this.nDj);
            } else {
                this.nDi.put(str, jVar);
                this.nDk = (e[]) this.nDi.values().toArray(this.nDk);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Sa(String str) {
        aT(str, true);
    }

    public void aT(String str, boolean z) {
        e<?> remove = z ? this.nDh.remove(str) : this.nDi.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.nDj = (e[]) this.nDh.values().toArray(this.nDj);
            } else {
                this.nDk = (e[]) this.nDi.values().toArray(this.nDk);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.nDj) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.nDk) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void dJR() {
        try {
            throw this.nDg;
        } catch (Exception e2) {
        }
    }
}
