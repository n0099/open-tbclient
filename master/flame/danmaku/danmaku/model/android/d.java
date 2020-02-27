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
    public Collection<master.flame.danmaku.danmaku.model.d> nHQ;
    private d nHR;
    private master.flame.danmaku.danmaku.model.d nHS;
    private master.flame.danmaku.danmaku.model.d nHT;
    private master.flame.danmaku.danmaku.model.d nHU;
    private master.flame.danmaku.danmaku.model.d nHV;
    private l.a nHW;
    private boolean nHX;
    private Object nHY;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nHY = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.nHQ = new LinkedList();
        } else {
            this.nHX = z;
            aVar.wL(z);
            this.nHQ = new TreeSet(aVar);
            this.nHW = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nHY = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nHX && this.mSortType != 4) {
            this.nHQ.clear();
            this.nHQ.addAll(collection);
            collection = this.nHQ;
        } else {
            this.nHQ = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nHQ != null) {
            try {
                if (this.nHQ.add(dVar)) {
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
        if (dVar.dLH()) {
            dVar.setVisibility(false);
        }
        if (this.nHQ.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> aj(long j, long j2) {
        if (this.mSortType == 4 || this.nHQ == null || this.nHQ.size() == 0) {
            return null;
        }
        if (this.nHR == null) {
            this.nHR = new d(this.nHX);
            this.nHR.nHY = this.nHY;
        }
        if (this.nHV == null) {
            this.nHV = Sm("start");
        }
        if (this.nHU == null) {
            this.nHU = Sm("end");
        }
        this.nHV.setTime(j);
        this.nHU.setTime(j2);
        return ((SortedSet) this.nHQ).subSet(this.nHV, this.nHU);
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
        if (this.nHQ == null || this.nHQ.size() == 0) {
            return null;
        }
        if (this.nHR == null) {
            if (this.mSortType == 4) {
                this.nHR = new d(4);
                this.nHR.nHY = this.nHY;
                synchronized (this.nHY) {
                    this.nHR.o(this.nHQ);
                }
            } else {
                this.nHR = new d(this.nHX);
                this.nHR.nHY = this.nHY;
            }
        }
        if (this.mSortType == 4) {
            return this.nHR;
        }
        if (this.nHS == null) {
            this.nHS = Sm("start");
        }
        if (this.nHT == null) {
            this.nHT = Sm("end");
        }
        if (this.nHR != null && j - this.nHS.dLQ() >= 0 && j2 <= this.nHT.dLQ()) {
            return this.nHR;
        }
        this.nHS.setTime(j);
        this.nHT.setTime(j2);
        synchronized (this.nHY) {
            this.nHR.o(((SortedSet) this.nHQ).subSet(this.nHS, this.nHT));
        }
        return this.nHR;
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
        if (this.nHQ != null) {
            this.nHQ.clear();
            this.mSize = 0;
        }
        if (this.nHR != null) {
            this.nHR = null;
            this.nHS = Sm("start");
            this.nHT = Sm("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dLY() {
        if (this.nHQ != null && !this.nHQ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nHQ).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nHQ).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dLZ() {
        if (this.nHQ != null && !this.nHQ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nHQ).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nHQ).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nHQ != null && this.nHQ.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nHQ == null || this.nHQ.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.nHY) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dMa();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nHQ.iterator();
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
        bVar.dMb();
    }
}
