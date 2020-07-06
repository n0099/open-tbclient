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
    private master.flame.danmaku.danmaku.model.d nVA;
    private master.flame.danmaku.danmaku.model.d nVB;
    private master.flame.danmaku.danmaku.model.d nVC;
    private l.a nVD;
    private boolean nVE;
    public Collection<master.flame.danmaku.danmaku.model.d> nVx;
    private d nVy;
    private master.flame.danmaku.danmaku.model.d nVz;

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
            this.nVx = new LinkedList();
        } else {
            this.nVE = z;
            aVar.xt(z);
            this.nVx = new TreeSet(aVar);
            this.nVD = aVar;
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
        if (this.nVE && this.mSortType != 4) {
            this.nVx.clear();
            this.nVx.addAll(collection);
            collection = this.nVx;
        } else {
            this.nVx = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nVx != null) {
            try {
                if (this.nVx.add(dVar)) {
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
        if (dVar.dRZ()) {
            dVar.setVisibility(false);
        }
        if (this.nVx.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> T(long j, long j2) {
        if (this.mSortType == 4 || this.nVx == null || this.nVx.size() == 0) {
            return null;
        }
        if (this.nVy == null) {
            this.nVy = new d(this.nVE);
            this.nVy.mLockObject = this.mLockObject;
        }
        if (this.nVC == null) {
            this.nVC = Sz("start");
        }
        if (this.nVB == null) {
            this.nVB = Sz("end");
        }
        this.nVC.setTime(j);
        this.nVB.setTime(j2);
        return ((SortedSet) this.nVx).subSet(this.nVC, this.nVB);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l Q(long j, long j2) {
        Collection<master.flame.danmaku.danmaku.model.d> T = T(j, j2);
        if (T == null || T.isEmpty()) {
            return null;
        }
        return new d(new LinkedList(T));
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l R(long j, long j2) {
        if (this.nVx == null || this.nVx.size() == 0) {
            return null;
        }
        if (this.nVy == null) {
            if (this.mSortType == 4) {
                this.nVy = new d(4);
                this.nVy.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.nVy.q(this.nVx);
                }
            } else {
                this.nVy = new d(this.nVE);
                this.nVy.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.nVy;
        }
        if (this.nVz == null) {
            this.nVz = Sz("start");
        }
        if (this.nVA == null) {
            this.nVA = Sz("end");
        }
        if (this.nVy != null && j - this.nVz.dSi() >= 0 && j2 <= this.nVA.dSi()) {
            return this.nVy;
        }
        this.nVz.setTime(j);
        this.nVA.setTime(j2);
        synchronized (this.mLockObject) {
            this.nVy.q(((SortedSet) this.nVx).subSet(this.nVz, this.nVA));
        }
        return this.nVy;
    }

    private master.flame.danmaku.danmaku.model.d Sz(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nVx != null) {
            this.nVx.clear();
            this.mSize = 0;
        }
        if (this.nVy != null) {
            this.nVy = null;
            this.nVz = Sz("start");
            this.nVA = Sz("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dSq() {
        if (this.nVx != null && !this.nVx.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nVx).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nVx).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dSr() {
        if (this.nVx != null && !this.nVx.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nVx).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nVx).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nVx != null && this.nVx.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nVx == null || this.nVx.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dSs();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nVx.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bM = bVar.bM(next);
                if (bM == 1) {
                    break;
                } else if (bM == 2) {
                    it.remove();
                } else if (bM == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.dSt();
    }
}
