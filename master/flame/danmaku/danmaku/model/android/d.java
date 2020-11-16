package master.flame.danmaku.danmaku.model.android;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes6.dex */
public class d implements l {
    private Object mLockObject;
    private int mSize;
    private int mSortType;
    public Collection<master.flame.danmaku.danmaku.model.d> pZL;
    private d pZM;
    private master.flame.danmaku.danmaku.model.d pZN;
    private master.flame.danmaku.danmaku.model.d pZO;
    private master.flame.danmaku.danmaku.model.d pZP;
    private master.flame.danmaku.danmaku.model.d pZQ;
    private l.a pZR;
    private boolean pZS;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.mLockObject = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.pZL = new LinkedList();
        } else {
            this.pZS = z;
            aVar.Bh(z);
            this.pZL = new TreeSet(aVar);
            this.pZR = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.mLockObject = new Object();
        s(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void s(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.pZS && this.mSortType != 4) {
            this.pZL.clear();
            this.pZL.addAll(collection);
            collection = this.pZL;
        } else {
            this.pZL = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pZL != null) {
            try {
                if (this.pZL.add(dVar)) {
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
        if (dVar.eDg()) {
            dVar.setVisibility(false);
        }
        if (this.pZL.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> U(long j, long j2) {
        if (this.mSortType == 4 || this.pZL == null || this.pZL.size() == 0) {
            return null;
        }
        if (this.pZM == null) {
            this.pZM = new d(this.pZS);
            this.pZM.mLockObject = this.mLockObject;
        }
        if (this.pZQ == null) {
            this.pZQ = ZG("start");
        }
        if (this.pZP == null) {
            this.pZP = ZG("end");
        }
        this.pZQ.setTime(j);
        this.pZP.setTime(j2);
        return ((SortedSet) this.pZL).subSet(this.pZQ, this.pZP);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l R(long j, long j2) {
        Collection<master.flame.danmaku.danmaku.model.d> U = U(j, j2);
        if (U == null || U.isEmpty()) {
            return null;
        }
        return new d(new LinkedList(U));
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l S(long j, long j2) {
        if (this.pZL == null || this.pZL.size() == 0) {
            return null;
        }
        if (this.pZM == null) {
            if (this.mSortType == 4) {
                this.pZM = new d(4);
                this.pZM.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.pZM.s(this.pZL);
                }
            } else {
                this.pZM = new d(this.pZS);
                this.pZM.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.pZM;
        }
        if (this.pZN == null) {
            this.pZN = ZG("start");
        }
        if (this.pZO == null) {
            this.pZO = ZG("end");
        }
        if (this.pZM != null && j - this.pZN.eDp() >= 0 && j2 <= this.pZO.eDp()) {
            return this.pZM;
        }
        this.pZN.setTime(j);
        this.pZO.setTime(j2);
        synchronized (this.mLockObject) {
            this.pZM.s(((SortedSet) this.pZL).subSet(this.pZN, this.pZO));
        }
        return this.pZM;
    }

    private master.flame.danmaku.danmaku.model.d ZG(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.pZL != null) {
            this.pZL.clear();
            this.mSize = 0;
        }
        if (this.pZM != null) {
            this.pZM = null;
            this.pZN = ZG("start");
            this.pZO = ZG("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d eDx() {
        if (this.pZL != null && !this.pZL.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.pZL).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.pZL).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d eDy() {
        if (this.pZL != null && !this.pZL.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.pZL).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.pZL).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.pZL != null && this.pZL.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.pZL == null || this.pZL.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.eDz();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.pZL.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bY = bVar.bY(next);
                if (bY == 1) {
                    break;
                } else if (bY == 2) {
                    it.remove();
                } else if (bY == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.eDA();
    }
}
