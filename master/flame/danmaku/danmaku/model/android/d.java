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
    private l.a nVA;
    private boolean nVB;
    public Collection<master.flame.danmaku.danmaku.model.d> nVu;
    private d nVv;
    private master.flame.danmaku.danmaku.model.d nVw;
    private master.flame.danmaku.danmaku.model.d nVx;
    private master.flame.danmaku.danmaku.model.d nVy;
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
            this.nVu = new LinkedList();
        } else {
            this.nVB = z;
            aVar.xt(z);
            this.nVu = new TreeSet(aVar);
            this.nVA = aVar;
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
        if (this.nVB && this.mSortType != 4) {
            this.nVu.clear();
            this.nVu.addAll(collection);
            collection = this.nVu;
        } else {
            this.nVu = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nVu != null) {
            try {
                if (this.nVu.add(dVar)) {
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
        if (dVar.dRV()) {
            dVar.setVisibility(false);
        }
        if (this.nVu.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> T(long j, long j2) {
        if (this.mSortType == 4 || this.nVu == null || this.nVu.size() == 0) {
            return null;
        }
        if (this.nVv == null) {
            this.nVv = new d(this.nVB);
            this.nVv.mLockObject = this.mLockObject;
        }
        if (this.nVz == null) {
            this.nVz = Sy("start");
        }
        if (this.nVy == null) {
            this.nVy = Sy("end");
        }
        this.nVz.setTime(j);
        this.nVy.setTime(j2);
        return ((SortedSet) this.nVu).subSet(this.nVz, this.nVy);
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
        if (this.nVu == null || this.nVu.size() == 0) {
            return null;
        }
        if (this.nVv == null) {
            if (this.mSortType == 4) {
                this.nVv = new d(4);
                this.nVv.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.nVv.q(this.nVu);
                }
            } else {
                this.nVv = new d(this.nVB);
                this.nVv.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.nVv;
        }
        if (this.nVw == null) {
            this.nVw = Sy("start");
        }
        if (this.nVx == null) {
            this.nVx = Sy("end");
        }
        if (this.nVv != null && j - this.nVw.dSe() >= 0 && j2 <= this.nVx.dSe()) {
            return this.nVv;
        }
        this.nVw.setTime(j);
        this.nVx.setTime(j2);
        synchronized (this.mLockObject) {
            this.nVv.q(((SortedSet) this.nVu).subSet(this.nVw, this.nVx));
        }
        return this.nVv;
    }

    private master.flame.danmaku.danmaku.model.d Sy(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nVu != null) {
            this.nVu.clear();
            this.mSize = 0;
        }
        if (this.nVv != null) {
            this.nVv = null;
            this.nVw = Sy("start");
            this.nVx = Sy("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dSm() {
        if (this.nVu != null && !this.nVu.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nVu).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nVu).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dSn() {
        if (this.nVu != null && !this.nVu.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nVu).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nVu).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nVu != null && this.nVu.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nVu == null || this.nVu.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dSo();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nVu.iterator();
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
        bVar.dSp();
    }
}
