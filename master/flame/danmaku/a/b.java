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
    public final Exception oun = new Exception("not suuport this filter tag");
    private final Map<String, e<?>> ouo = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, e<?>> oup = Collections.synchronizedSortedMap(new TreeMap());
    e<?>[] ouq = new e[0];
    e<?>[] our = new e[0];

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
        final List<Integer> ouE = Collections.synchronizedList(new ArrayList());

        public void w(Integer num) {
            if (!this.ouE.contains(num)) {
                this.ouE.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.ouE.contains(Integer.valueOf(dVar.getType()));
            if (z2) {
                dVar.ovZ |= 1;
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
            this.ouE.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends a<Integer> {
        protected int ouB = -1;
        protected master.flame.danmaku.danmaku.model.d ouC = null;
        private float mFilterFactor = 1.0f;

        private boolean d(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.ouB <= 0 || dVar.getType() != 1) {
                return false;
            }
            if (this.ouC == null || this.ouC.ehy()) {
                this.ouC = dVar;
                return false;
            }
            long ehI = dVar.ehI() - this.ouC.ehI();
            master.flame.danmaku.danmaku.model.g gVar = danmakuContext.oxR.oxX;
            if ((ehI < 0 || gVar == null || ((float) ehI) >= ((float) gVar.value) * this.mFilterFactor) && i <= this.ouB) {
                this.ouC = dVar;
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.a.b.e
        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean d;
            d = d(dVar, i, i2, fVar, z, danmakuContext);
            if (d) {
                dVar.ovZ |= 2;
            }
            return d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: u */
        public void setData(Integer num) {
            reset();
            if (num != null && num.intValue() != this.ouB) {
                this.ouB = num.intValue() + (num.intValue() / 5);
                this.mFilterFactor = 1.0f / this.ouB;
            }
        }

        public synchronized void reset() {
            this.ouC = null;
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a<Object> {
        long dKA = 20;

        private synchronized boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                if (fVar != null) {
                    if (dVar.ehz()) {
                        if (master.flame.danmaku.danmaku.c.c.eiF() - fVar.owf >= this.dKA) {
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
                dVar.ovZ |= 4;
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
        public List<Integer> ouD = new ArrayList();

        private void v(Integer num) {
            if (!this.ouD.contains(num)) {
                this.ouD.add(num);
            }
        }

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (dVar == null || this.ouD.contains(Integer.valueOf(dVar.textColor))) ? false : true;
            if (z2) {
                dVar.ovZ |= 8;
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
            this.ouD.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class k<T> extends a<List<T>> {
        public List<T> ouF = new ArrayList();

        @Override // master.flame.danmaku.a.b.e
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        private void bP(T t) {
            if (!this.ouF.contains(t)) {
                this.ouF.add(t);
            }
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    bP(t);
                }
            }
        }

        public void reset() {
            this.ouF.clear();
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.ouF.contains(Integer.valueOf(dVar.userId));
            if (z2) {
                dVar.ovZ |= 16;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = dVar != null && this.ouF.contains(dVar.ovX);
            if (z2) {
                dVar.ovZ |= 32;
            }
            return z2;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a<Boolean> {
        private Boolean ouy = false;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.ouy.booleanValue() && dVar.ovY;
            if (z2) {
                dVar.ovZ |= 64;
            }
            return z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: w */
        public void setData(Boolean bool) {
            this.ouy = bool;
        }
    }

    /* renamed from: master.flame.danmaku.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0975b extends a<Void> {
        protected final master.flame.danmaku.danmaku.model.l ous = new master.flame.danmaku.danmaku.model.android.d(4);
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> ouu = new LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.l ouv = new master.flame.danmaku.danmaku.model.android.d(4);

        private final void a(master.flame.danmaku.danmaku.model.l lVar, final long j) {
            lVar.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.b.b.1
                long startTime = master.flame.danmaku.danmaku.c.c.eiF();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                    try {
                        if (master.flame.danmaku.danmaku.c.c.eiF() - this.startTime > j) {
                            return 1;
                        }
                        return dVar.ehy() ? 2 : 1;
                    } catch (Exception e) {
                        return 1;
                    }
                }
            });
        }

        private void a(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long eiF = master.flame.danmaku.danmaku.c.c.eiF();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().ehy()) {
                        it.remove();
                        if (master.flame.danmaku.danmaku.c.c.eiF() - eiF > i) {
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
                a(this.ous, 2L);
                a(this.ouv, 2L);
                a(this.ouu, 3);
                if (!this.ous.m(dVar) || dVar.ehz()) {
                    if (this.ouv.m(dVar)) {
                        z2 = false;
                    } else if (this.ouu.containsKey(dVar.text)) {
                        this.ouu.put(String.valueOf(dVar.text), dVar);
                        this.ous.l(dVar);
                        this.ous.k(dVar);
                    } else {
                        this.ouu.put(String.valueOf(dVar.text), dVar);
                        this.ouv.k(dVar);
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
                dVar.ovZ |= 128;
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        /* renamed from: b */
        public void setData(Void r1) {
        }

        public synchronized void reset() {
            this.ouv.clear();
            this.ous.clear();
            this.ouu.clear();
        }

        @Override // master.flame.danmaku.a.b.a, master.flame.danmaku.a.b.e
        public void clear() {
            reset();
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a<Map<Integer, Integer>> {
        private Map<Integer, Integer> ouz;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.ouz != null) {
                Integer num = this.ouz.get(Integer.valueOf(dVar.getType()));
                boolean z2 = num != null && i >= num.intValue();
                if (z2) {
                    dVar.ovZ |= 256;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Integer> map) {
            this.ouz = map;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends a<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> ouA;

        @Override // master.flame.danmaku.a.b.e
        public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i, int i2, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
            if (this.ouA != null) {
                Boolean bool = this.ouA.get(Integer.valueOf(dVar.getType()));
                boolean z2 = bool != null && bool.booleanValue() && z;
                if (z2) {
                    dVar.ovZ |= 512;
                    return z2;
                }
                return z2;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.a.b.e
        public void setData(Map<Integer, Boolean> map) {
            this.ouA = map;
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.ouq) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.owa = danmakuContext.oxP.owp;
                if (c2) {
                    return;
                }
            }
        }
    }

    public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i2, int i3, master.flame.danmaku.danmaku.model.f fVar, boolean z, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.our) {
            if (eVar != null) {
                boolean c2 = eVar.c(dVar, i2, i3, fVar, z, danmakuContext);
                dVar.owa = danmakuContext.oxP.owp;
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> bd(String str, boolean z) {
        e<?> eVar = z ? this.ouo.get(str) : this.oup.get(str);
        if (eVar == null) {
            return be(str, z);
        }
        return eVar;
    }

    public e<?> Wm(String str) {
        return be(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e<?> be(String str, boolean z) {
        j jVar;
        if (str == null) {
            egV();
            return null;
        }
        e<?> eVar = this.ouo.get(str);
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
                jVar = new C0975b();
            } else if ("1018_Filter".equals(str)) {
                jVar = new f();
            } else if ("1019_Filter".equals(str)) {
                jVar = new g();
            }
            if (jVar != null) {
                egV();
                return null;
            }
            jVar.setData(null);
            if (z) {
                this.ouo.put(str, jVar);
                this.ouq = (e[]) this.ouo.values().toArray(this.ouq);
            } else {
                this.oup.put(str, jVar);
                this.our = (e[]) this.oup.values().toArray(this.our);
            }
            return jVar;
        }
        jVar = eVar;
        if (jVar != null) {
        }
    }

    public void Wn(String str) {
        bf(str, true);
    }

    public void bf(String str, boolean z) {
        e<?> remove = z ? this.ouo.remove(str) : this.oup.remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.ouq = (e[]) this.ouo.values().toArray(this.ouq);
            } else {
                this.our = (e[]) this.oup.values().toArray(this.our);
            }
        }
    }

    public void clear() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.ouq) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.our) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    private void egV() {
        try {
            throw this.oun;
        } catch (Exception e2) {
        }
    }
}
