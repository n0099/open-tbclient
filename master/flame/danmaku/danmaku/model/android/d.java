package master.flame.danmaku.danmaku.model.android;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes5.dex */
public class d implements l {
    private int mSize;
    private int mSortType;
    public Collection<master.flame.danmaku.danmaku.model.d> nHS;
    private d nHT;
    private master.flame.danmaku.danmaku.model.d nHU;
    private master.flame.danmaku.danmaku.model.d nHV;
    private master.flame.danmaku.danmaku.model.d nHW;
    private master.flame.danmaku.danmaku.model.d nHX;
    private l.a nHY;
    private boolean nHZ;
    private Object nIa;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nIa = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.nHS = new LinkedList();
        } else {
            this.nHZ = z;
            aVar.wL(z);
            this.nHS = new TreeSet(aVar);
            this.nHY = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nIa = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nHZ && this.mSortType != 4) {
            this.nHS.clear();
            this.nHS.addAll(collection);
            collection = this.nHS;
        } else {
            this.nHS = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nHS != null) {
            try {
                if (this.nHS.add(dVar)) {
                    this.mSize++;
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean l(master.flame.danmaku.danmaku.model.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar.dLJ()) {
            dVar.setVisibility(false);
        }
        if (this.nHS.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> aj(long j, long j2) {
        if (this.mSortType == 4 || this.nHS == null || this.nHS.size() == 0) {
            return null;
        }
        if (this.nHT == null) {
            this.nHT = new d(this.nHZ);
            this.nHT.nIa = this.nIa;
        }
        if (this.nHX == null) {
            this.nHX = Sm("start");
        }
        if (this.nHW == null) {
            this.nHW = Sm("end");
        }
        this.nHX.setTime(j);
        this.nHW.setTime(j2);
        return ((SortedSet) this.nHS).subSet(this.nHX, this.nHW);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l ag(long j, long j2) {
        Collection<master.flame.danmaku.danmaku.model.d> aj = aj(j, j2);
        if (aj == null || aj.isEmpty()) {
            return null;
        }
        return new d(new LinkedList(aj));
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l ah(long j, long j2) {
        if (this.nHS == null || this.nHS.size() == 0) {
            return null;
        }
        if (this.nHT == null) {
            if (this.mSortType == 4) {
                this.nHT = new d(4);
                this.nHT.nIa = this.nIa;
                synchronized (this.nIa) {
                    this.nHT.o(this.nHS);
                }
            } else {
                this.nHT = new d(this.nHZ);
                this.nHT.nIa = this.nIa;
            }
        }
        if (this.mSortType == 4) {
            return this.nHT;
        }
        if (this.nHU == null) {
            this.nHU = Sm("start");
        }
        if (this.nHV == null) {
            this.nHV = Sm("end");
        }
        if (this.nHT != null && j - this.nHU.dLS() >= 0 && j2 <= this.nHV.dLS()) {
            return this.nHT;
        }
        this.nHU.setTime(j);
        this.nHV.setTime(j2);
        synchronized (this.nIa) {
            this.nHT.o(((SortedSet) this.nHS).subSet(this.nHU, this.nHV));
        }
        return this.nHT;
    }

    private master.flame.danmaku.danmaku.model.d Sm(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nHS != null) {
            this.nHS.clear();
            this.mSize = 0;
        }
        if (this.nHT != null) {
            this.nHT = null;
            this.nHU = Sm("start");
            this.nHV = Sm("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dMa() {
        if (this.nHS != null && !this.nHS.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nHS).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nHS).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dMb() {
        if (this.nHS != null && !this.nHS.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nHS).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nHS).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nHS != null && this.nHS.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nHS == null || this.nHS.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.nIa) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dMc();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nHS.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bV = bVar.bV(next);
                if (bV == 1) {
                    break;
                } else if (bV == 2) {
                    it.remove();
                } else if (bV == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.dMd();
    }
}
