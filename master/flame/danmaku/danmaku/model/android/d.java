package master.flame.danmaku.danmaku.model.android;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes4.dex */
public class d implements l {
    private int mSize;
    private int mSortType;
    public Collection<master.flame.danmaku.danmaku.model.d> nGU;
    private d nGV;
    private master.flame.danmaku.danmaku.model.d nGW;
    private master.flame.danmaku.danmaku.model.d nGX;
    private master.flame.danmaku.danmaku.model.d nGY;
    private master.flame.danmaku.danmaku.model.d nGZ;
    private l.a nHa;
    private boolean nHb;
    private Object nHc;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nHc = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.nGU = new LinkedList();
        } else {
            this.nHb = z;
            aVar.wI(z);
            this.nGU = new TreeSet(aVar);
            this.nHa = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nHc = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nHb && this.mSortType != 4) {
            this.nGU.clear();
            this.nGU.addAll(collection);
            collection = this.nGU;
        } else {
            this.nGU = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nGU != null) {
            try {
                if (this.nGU.add(dVar)) {
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
        if (dVar.dKs()) {
            dVar.setVisibility(false);
        }
        if (this.nGU.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> aj(long j, long j2) {
        if (this.mSortType == 4 || this.nGU == null || this.nGU.size() == 0) {
            return null;
        }
        if (this.nGV == null) {
            this.nGV = new d(this.nHb);
            this.nGV.nHc = this.nHc;
        }
        if (this.nGZ == null) {
            this.nGZ = Sb("start");
        }
        if (this.nGY == null) {
            this.nGY = Sb("end");
        }
        this.nGZ.setTime(j);
        this.nGY.setTime(j2);
        return ((SortedSet) this.nGU).subSet(this.nGZ, this.nGY);
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
        if (this.nGU == null || this.nGU.size() == 0) {
            return null;
        }
        if (this.nGV == null) {
            if (this.mSortType == 4) {
                this.nGV = new d(4);
                this.nGV.nHc = this.nHc;
                synchronized (this.nHc) {
                    this.nGV.o(this.nGU);
                }
            } else {
                this.nGV = new d(this.nHb);
                this.nGV.nHc = this.nHc;
            }
        }
        if (this.mSortType == 4) {
            return this.nGV;
        }
        if (this.nGW == null) {
            this.nGW = Sb("start");
        }
        if (this.nGX == null) {
            this.nGX = Sb("end");
        }
        if (this.nGV != null && j - this.nGW.dKB() >= 0 && j2 <= this.nGX.dKB()) {
            return this.nGV;
        }
        this.nGW.setTime(j);
        this.nGX.setTime(j2);
        synchronized (this.nHc) {
            this.nGV.o(((SortedSet) this.nGU).subSet(this.nGW, this.nGX));
        }
        return this.nGV;
    }

    private master.flame.danmaku.danmaku.model.d Sb(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nGU != null) {
            this.nGU.clear();
            this.mSize = 0;
        }
        if (this.nGV != null) {
            this.nGV = null;
            this.nGW = Sb("start");
            this.nGX = Sb("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dKJ() {
        if (this.nGU != null && !this.nGU.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nGU).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nGU).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dKK() {
        if (this.nGU != null && !this.nGU.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nGU).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nGU).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nGU != null && this.nGU.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nGU == null || this.nGU.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.nHc) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dKL();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nGU.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bU = bVar.bU(next);
                if (bU == 1) {
                    break;
                } else if (bU == 2) {
                    it.remove();
                } else if (bU == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.dKM();
    }
}
