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
    public Collection<master.flame.danmaku.danmaku.model.d> nId;
    private d nIe;
    private master.flame.danmaku.danmaku.model.d nIf;
    private master.flame.danmaku.danmaku.model.d nIg;
    private master.flame.danmaku.danmaku.model.d nIh;
    private master.flame.danmaku.danmaku.model.d nIi;
    private l.a nIj;
    private boolean nIk;
    private Object nIl;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nIl = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.nId = new LinkedList();
        } else {
            this.nIk = z;
            aVar.wL(z);
            this.nId = new TreeSet(aVar);
            this.nIj = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nIl = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nIk && this.mSortType != 4) {
            this.nId.clear();
            this.nId.addAll(collection);
            collection = this.nId;
        } else {
            this.nId = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nId != null) {
            try {
                if (this.nId.add(dVar)) {
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
        if (dVar.dLK()) {
            dVar.setVisibility(false);
        }
        if (this.nId.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> aj(long j, long j2) {
        if (this.mSortType == 4 || this.nId == null || this.nId.size() == 0) {
            return null;
        }
        if (this.nIe == null) {
            this.nIe = new d(this.nIk);
            this.nIe.nIl = this.nIl;
        }
        if (this.nIi == null) {
            this.nIi = Sn("start");
        }
        if (this.nIh == null) {
            this.nIh = Sn("end");
        }
        this.nIi.setTime(j);
        this.nIh.setTime(j2);
        return ((SortedSet) this.nId).subSet(this.nIi, this.nIh);
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
        if (this.nId == null || this.nId.size() == 0) {
            return null;
        }
        if (this.nIe == null) {
            if (this.mSortType == 4) {
                this.nIe = new d(4);
                this.nIe.nIl = this.nIl;
                synchronized (this.nIl) {
                    this.nIe.o(this.nId);
                }
            } else {
                this.nIe = new d(this.nIk);
                this.nIe.nIl = this.nIl;
            }
        }
        if (this.mSortType == 4) {
            return this.nIe;
        }
        if (this.nIf == null) {
            this.nIf = Sn("start");
        }
        if (this.nIg == null) {
            this.nIg = Sn("end");
        }
        if (this.nIe != null && j - this.nIf.dLT() >= 0 && j2 <= this.nIg.dLT()) {
            return this.nIe;
        }
        this.nIf.setTime(j);
        this.nIg.setTime(j2);
        synchronized (this.nIl) {
            this.nIe.o(((SortedSet) this.nId).subSet(this.nIf, this.nIg));
        }
        return this.nIe;
    }

    private master.flame.danmaku.danmaku.model.d Sn(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nId != null) {
            this.nId.clear();
            this.mSize = 0;
        }
        if (this.nIe != null) {
            this.nIe = null;
            this.nIf = Sn("start");
            this.nIg = Sn("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dMb() {
        if (this.nId != null && !this.nId.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nId).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nId).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dMc() {
        if (this.nId != null && !this.nId.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nId).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nId).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nId != null && this.nId.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nId == null || this.nId.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.nIl) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dMd();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nId.iterator();
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
        bVar.dMe();
    }
}
