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
    public Collection<master.flame.danmaku.danmaku.model.d> pYi;
    private d pYj;
    private master.flame.danmaku.danmaku.model.d pYk;
    private master.flame.danmaku.danmaku.model.d pYl;
    private master.flame.danmaku.danmaku.model.d pYm;
    private master.flame.danmaku.danmaku.model.d pYn;
    private l.a pYo;
    private boolean pYp;

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
            this.pYi = new LinkedList();
        } else {
            this.pYp = z;
            aVar.Ba(z);
            this.pYi = new TreeSet(aVar);
            this.pYo = aVar;
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
        if (this.pYp && this.mSortType != 4) {
            this.pYi.clear();
            this.pYi.addAll(collection);
            collection = this.pYi;
        } else {
            this.pYi = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pYi != null) {
            try {
                if (this.pYi.add(dVar)) {
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
        if (dVar.eDf()) {
            dVar.setVisibility(false);
        }
        if (this.pYi.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> U(long j, long j2) {
        if (this.mSortType == 4 || this.pYi == null || this.pYi.size() == 0) {
            return null;
        }
        if (this.pYj == null) {
            this.pYj = new d(this.pYp);
            this.pYj.mLockObject = this.mLockObject;
        }
        if (this.pYn == null) {
            this.pYn = ZV("start");
        }
        if (this.pYm == null) {
            this.pYm = ZV("end");
        }
        this.pYn.setTime(j);
        this.pYm.setTime(j2);
        return ((SortedSet) this.pYi).subSet(this.pYn, this.pYm);
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
        if (this.pYi == null || this.pYi.size() == 0) {
            return null;
        }
        if (this.pYj == null) {
            if (this.mSortType == 4) {
                this.pYj = new d(4);
                this.pYj.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.pYj.s(this.pYi);
                }
            } else {
                this.pYj = new d(this.pYp);
                this.pYj.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.pYj;
        }
        if (this.pYk == null) {
            this.pYk = ZV("start");
        }
        if (this.pYl == null) {
            this.pYl = ZV("end");
        }
        if (this.pYj != null && j - this.pYk.eDo() >= 0 && j2 <= this.pYl.eDo()) {
            return this.pYj;
        }
        this.pYk.setTime(j);
        this.pYl.setTime(j2);
        synchronized (this.mLockObject) {
            this.pYj.s(((SortedSet) this.pYi).subSet(this.pYk, this.pYl));
        }
        return this.pYj;
    }

    private master.flame.danmaku.danmaku.model.d ZV(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.pYi != null) {
            this.pYi.clear();
            this.mSize = 0;
        }
        if (this.pYj != null) {
            this.pYj = null;
            this.pYk = ZV("start");
            this.pYl = ZV("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d eDw() {
        if (this.pYi != null && !this.pYi.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.pYi).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.pYi).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d eDx() {
        if (this.pYi != null && !this.pYi.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.pYi).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.pYi).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.pYi != null && this.pYi.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.pYi == null || this.pYi.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.eDy();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.pYi.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bX = bVar.bX(next);
                if (bX == 1) {
                    break;
                } else if (bX == 2) {
                    it.remove();
                } else if (bX == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.eDz();
    }
}
