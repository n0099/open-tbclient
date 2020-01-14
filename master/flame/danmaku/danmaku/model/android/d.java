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
    public Collection<master.flame.danmaku.danmaku.model.d> nGZ;
    private d nHa;
    private master.flame.danmaku.danmaku.model.d nHb;
    private master.flame.danmaku.danmaku.model.d nHc;
    private master.flame.danmaku.danmaku.model.d nHd;
    private master.flame.danmaku.danmaku.model.d nHe;
    private l.a nHf;
    private boolean nHg;
    private Object nHh;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nHh = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.nGZ = new LinkedList();
        } else {
            this.nHg = z;
            aVar.wI(z);
            this.nGZ = new TreeSet(aVar);
            this.nHf = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nHh = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nHg && this.mSortType != 4) {
            this.nGZ.clear();
            this.nGZ.addAll(collection);
            collection = this.nGZ;
        } else {
            this.nGZ = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nGZ != null) {
            try {
                if (this.nGZ.add(dVar)) {
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
        if (dVar.dKu()) {
            dVar.setVisibility(false);
        }
        if (this.nGZ.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> aj(long j, long j2) {
        if (this.mSortType == 4 || this.nGZ == null || this.nGZ.size() == 0) {
            return null;
        }
        if (this.nHa == null) {
            this.nHa = new d(this.nHg);
            this.nHa.nHh = this.nHh;
        }
        if (this.nHe == null) {
            this.nHe = Sb("start");
        }
        if (this.nHd == null) {
            this.nHd = Sb("end");
        }
        this.nHe.setTime(j);
        this.nHd.setTime(j2);
        return ((SortedSet) this.nGZ).subSet(this.nHe, this.nHd);
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
        if (this.nGZ == null || this.nGZ.size() == 0) {
            return null;
        }
        if (this.nHa == null) {
            if (this.mSortType == 4) {
                this.nHa = new d(4);
                this.nHa.nHh = this.nHh;
                synchronized (this.nHh) {
                    this.nHa.o(this.nGZ);
                }
            } else {
                this.nHa = new d(this.nHg);
                this.nHa.nHh = this.nHh;
            }
        }
        if (this.mSortType == 4) {
            return this.nHa;
        }
        if (this.nHb == null) {
            this.nHb = Sb("start");
        }
        if (this.nHc == null) {
            this.nHc = Sb("end");
        }
        if (this.nHa != null && j - this.nHb.dKD() >= 0 && j2 <= this.nHc.dKD()) {
            return this.nHa;
        }
        this.nHb.setTime(j);
        this.nHc.setTime(j2);
        synchronized (this.nHh) {
            this.nHa.o(((SortedSet) this.nGZ).subSet(this.nHb, this.nHc));
        }
        return this.nHa;
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
        if (this.nGZ != null) {
            this.nGZ.clear();
            this.mSize = 0;
        }
        if (this.nHa != null) {
            this.nHa = null;
            this.nHb = Sb("start");
            this.nHc = Sb("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dKL() {
        if (this.nGZ != null && !this.nGZ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nGZ).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nGZ).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dKM() {
        if (this.nGZ != null && !this.nGZ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nGZ).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nGZ).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nGZ != null && this.nGZ.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nGZ == null || this.nGZ.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.nHh) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dKN();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nGZ.iterator();
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
        bVar.dKO();
    }
}
