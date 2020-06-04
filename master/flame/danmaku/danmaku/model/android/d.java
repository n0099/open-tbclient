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
    private Object mLockObject;
    private int mSize;
    private int mSortType;
    public Collection<master.flame.danmaku.danmaku.model.d> nzJ;
    private d nzK;
    private master.flame.danmaku.danmaku.model.d nzL;
    private master.flame.danmaku.danmaku.model.d nzM;
    private master.flame.danmaku.danmaku.model.d nzN;
    private master.flame.danmaku.danmaku.model.d nzO;
    private l.a nzP;
    private boolean nzQ;

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
            this.nzJ = new LinkedList();
        } else {
            this.nzQ = z;
            aVar.wY(z);
            this.nzJ = new TreeSet(aVar);
            this.nzP = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.mLockObject = new Object();
        q(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void q(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.nzQ && this.mSortType != 4) {
            this.nzJ.clear();
            this.nzJ.addAll(collection);
            collection = this.nzJ;
        } else {
            this.nzJ = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nzJ != null) {
            try {
                if (this.nzJ.add(dVar)) {
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
        if (dVar.dNp()) {
            dVar.setVisibility(false);
        }
        if (this.nzJ.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> S(long j, long j2) {
        if (this.mSortType == 4 || this.nzJ == null || this.nzJ.size() == 0) {
            return null;
        }
        if (this.nzK == null) {
            this.nzK = new d(this.nzQ);
            this.nzK.mLockObject = this.mLockObject;
        }
        if (this.nzO == null) {
            this.nzO = RM("start");
        }
        if (this.nzN == null) {
            this.nzN = RM("end");
        }
        this.nzO.setTime(j);
        this.nzN.setTime(j2);
        return ((SortedSet) this.nzJ).subSet(this.nzO, this.nzN);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l P(long j, long j2) {
        Collection<master.flame.danmaku.danmaku.model.d> S = S(j, j2);
        if (S == null || S.isEmpty()) {
            return null;
        }
        return new d(new LinkedList(S));
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l Q(long j, long j2) {
        if (this.nzJ == null || this.nzJ.size() == 0) {
            return null;
        }
        if (this.nzK == null) {
            if (this.mSortType == 4) {
                this.nzK = new d(4);
                this.nzK.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.nzK.q(this.nzJ);
                }
            } else {
                this.nzK = new d(this.nzQ);
                this.nzK.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.nzK;
        }
        if (this.nzL == null) {
            this.nzL = RM("start");
        }
        if (this.nzM == null) {
            this.nzM = RM("end");
        }
        if (this.nzK != null && j - this.nzL.dNy() >= 0 && j2 <= this.nzM.dNy()) {
            return this.nzK;
        }
        this.nzL.setTime(j);
        this.nzM.setTime(j2);
        synchronized (this.mLockObject) {
            this.nzK.q(((SortedSet) this.nzJ).subSet(this.nzL, this.nzM));
        }
        return this.nzK;
    }

    private master.flame.danmaku.danmaku.model.d RM(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nzJ != null) {
            this.nzJ.clear();
            this.mSize = 0;
        }
        if (this.nzK != null) {
            this.nzK = null;
            this.nzL = RM("start");
            this.nzM = RM("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dNG() {
        if (this.nzJ != null && !this.nzJ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nzJ).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nzJ).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dNH() {
        if (this.nzJ != null && !this.nzJ.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nzJ).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nzJ).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nzJ != null && this.nzJ.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nzJ == null || this.nzJ.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dNI();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nzJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bL = bVar.bL(next);
                if (bL == 1) {
                    break;
                } else if (bL == 2) {
                    it.remove();
                } else if (bL == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.dNJ();
    }
}
