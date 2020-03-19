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
    public Collection<master.flame.danmaku.danmaku.model.d> nJQ;
    private d nJR;
    private master.flame.danmaku.danmaku.model.d nJS;
    private master.flame.danmaku.danmaku.model.d nJT;
    private master.flame.danmaku.danmaku.model.d nJU;
    private master.flame.danmaku.danmaku.model.d nJV;
    private l.a nJW;
    private boolean nJX;
    private Object nJY;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nJY = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.nJQ = new LinkedList();
        } else {
            this.nJX = z;
            aVar.wT(z);
            this.nJQ = new TreeSet(aVar);
            this.nJW = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.nJY = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nJX && this.mSortType != 4) {
            this.nJQ.clear();
            this.nJQ.addAll(collection);
            collection = this.nJQ;
        } else {
            this.nJQ = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nJQ != null) {
            try {
                if (this.nJQ.add(dVar)) {
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
        if (dVar.dMk()) {
            dVar.setVisibility(false);
        }
        if (this.nJQ.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> aj(long j, long j2) {
        if (this.mSortType == 4 || this.nJQ == null || this.nJQ.size() == 0) {
            return null;
        }
        if (this.nJR == null) {
            this.nJR = new d(this.nJX);
            this.nJR.nJY = this.nJY;
        }
        if (this.nJV == null) {
            this.nJV = Sn("start");
        }
        if (this.nJU == null) {
            this.nJU = Sn("end");
        }
        this.nJV.setTime(j);
        this.nJU.setTime(j2);
        return ((SortedSet) this.nJQ).subSet(this.nJV, this.nJU);
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
        if (this.nJQ == null || this.nJQ.size() == 0) {
            return null;
        }
        if (this.nJR == null) {
            if (this.mSortType == 4) {
                this.nJR = new d(4);
                this.nJR.nJY = this.nJY;
                synchronized (this.nJY) {
                    this.nJR.o(this.nJQ);
                }
            } else {
                this.nJR = new d(this.nJX);
                this.nJR.nJY = this.nJY;
            }
        }
        if (this.mSortType == 4) {
            return this.nJR;
        }
        if (this.nJS == null) {
            this.nJS = Sn("start");
        }
        if (this.nJT == null) {
            this.nJT = Sn("end");
        }
        if (this.nJR != null && j - this.nJS.dMt() >= 0 && j2 <= this.nJT.dMt()) {
            return this.nJR;
        }
        this.nJS.setTime(j);
        this.nJT.setTime(j2);
        synchronized (this.nJY) {
            this.nJR.o(((SortedSet) this.nJQ).subSet(this.nJS, this.nJT));
        }
        return this.nJR;
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
        if (this.nJQ != null) {
            this.nJQ.clear();
            this.mSize = 0;
        }
        if (this.nJR != null) {
            this.nJR = null;
            this.nJS = Sn("start");
            this.nJT = Sn("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dMB() {
        if (this.nJQ != null && !this.nJQ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nJQ).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nJQ).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dMC() {
        if (this.nJQ != null && !this.nJQ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nJQ).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nJQ).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nJQ != null && this.nJQ.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nJQ == null || this.nJQ.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.nJY) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dMD();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nJQ.iterator();
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
        bVar.dME();
    }
}
