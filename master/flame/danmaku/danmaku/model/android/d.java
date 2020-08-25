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
    public Collection<master.flame.danmaku.danmaku.model.d> oyg;
    private d oyh;
    private master.flame.danmaku.danmaku.model.d oyi;
    private master.flame.danmaku.danmaku.model.d oyj;
    private master.flame.danmaku.danmaku.model.d oyk;
    private master.flame.danmaku.danmaku.model.d oyl;
    private l.a oym;
    private boolean oyn;

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
            this.oyg = new LinkedList();
        } else {
            this.oyn = z;
            aVar.yQ(z);
            this.oyg = new TreeSet(aVar);
            this.oym = aVar;
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
        if (this.oyn && this.mSortType != 4) {
            this.oyg.clear();
            this.oyg.addAll(collection);
            collection = this.oyg;
        } else {
            this.oyg = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oyg != null) {
            try {
                if (this.oyg.add(dVar)) {
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
        if (dVar.ehz()) {
            dVar.setVisibility(false);
        }
        if (this.oyg.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> V(long j, long j2) {
        if (this.mSortType == 4 || this.oyg == null || this.oyg.size() == 0) {
            return null;
        }
        if (this.oyh == null) {
            this.oyh = new d(this.oyn);
            this.oyh.mLockObject = this.mLockObject;
        }
        if (this.oyl == null) {
            this.oyl = Wo("start");
        }
        if (this.oyk == null) {
            this.oyk = Wo("end");
        }
        this.oyl.setTime(j);
        this.oyk.setTime(j2);
        return ((SortedSet) this.oyg).subSet(this.oyl, this.oyk);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l S(long j, long j2) {
        Collection<master.flame.danmaku.danmaku.model.d> V = V(j, j2);
        if (V == null || V.isEmpty()) {
            return null;
        }
        return new d(new LinkedList(V));
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l T(long j, long j2) {
        if (this.oyg == null || this.oyg.size() == 0) {
            return null;
        }
        if (this.oyh == null) {
            if (this.mSortType == 4) {
                this.oyh = new d(4);
                this.oyh.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.oyh.s(this.oyg);
                }
            } else {
                this.oyh = new d(this.oyn);
                this.oyh.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.oyh;
        }
        if (this.oyi == null) {
            this.oyi = Wo("start");
        }
        if (this.oyj == null) {
            this.oyj = Wo("end");
        }
        if (this.oyh != null && j - this.oyi.ehI() >= 0 && j2 <= this.oyj.ehI()) {
            return this.oyh;
        }
        this.oyi.setTime(j);
        this.oyj.setTime(j2);
        synchronized (this.mLockObject) {
            this.oyh.s(((SortedSet) this.oyg).subSet(this.oyi, this.oyj));
        }
        return this.oyh;
    }

    private master.flame.danmaku.danmaku.model.d Wo(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.oyg != null) {
            this.oyg.clear();
            this.mSize = 0;
        }
        if (this.oyh != null) {
            this.oyh = null;
            this.oyi = Wo("start");
            this.oyj = Wo("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d ehQ() {
        if (this.oyg != null && !this.oyg.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oyg).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oyg).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d ehR() {
        if (this.oyg != null && !this.oyg.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oyg).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oyg).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.oyg != null && this.oyg.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.oyg == null || this.oyg.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.ehS();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.oyg.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bO = bVar.bO(next);
                if (bO == 1) {
                    break;
                } else if (bO == 2) {
                    it.remove();
                } else if (bO == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.ehT();
    }
}
