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
    private master.flame.danmaku.danmaku.model.d oyA;
    private master.flame.danmaku.danmaku.model.d oyB;
    private master.flame.danmaku.danmaku.model.d oyC;
    private master.flame.danmaku.danmaku.model.d oyD;
    private l.a oyE;
    private boolean oyF;
    public Collection<master.flame.danmaku.danmaku.model.d> oyy;
    private d oyz;

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
            this.oyy = new LinkedList();
        } else {
            this.oyF = z;
            aVar.yS(z);
            this.oyy = new TreeSet(aVar);
            this.oyE = aVar;
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
        if (this.oyF && this.mSortType != 4) {
            this.oyy.clear();
            this.oyy.addAll(collection);
            collection = this.oyy;
        } else {
            this.oyy = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oyy != null) {
            try {
                if (this.oyy.add(dVar)) {
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
        if (dVar.ehI()) {
            dVar.setVisibility(false);
        }
        if (this.oyy.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> V(long j, long j2) {
        if (this.mSortType == 4 || this.oyy == null || this.oyy.size() == 0) {
            return null;
        }
        if (this.oyz == null) {
            this.oyz = new d(this.oyF);
            this.oyz.mLockObject = this.mLockObject;
        }
        if (this.oyD == null) {
            this.oyD = Wo("start");
        }
        if (this.oyC == null) {
            this.oyC = Wo("end");
        }
        this.oyD.setTime(j);
        this.oyC.setTime(j2);
        return ((SortedSet) this.oyy).subSet(this.oyD, this.oyC);
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
        if (this.oyy == null || this.oyy.size() == 0) {
            return null;
        }
        if (this.oyz == null) {
            if (this.mSortType == 4) {
                this.oyz = new d(4);
                this.oyz.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.oyz.s(this.oyy);
                }
            } else {
                this.oyz = new d(this.oyF);
                this.oyz.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.oyz;
        }
        if (this.oyA == null) {
            this.oyA = Wo("start");
        }
        if (this.oyB == null) {
            this.oyB = Wo("end");
        }
        if (this.oyz != null && j - this.oyA.ehR() >= 0 && j2 <= this.oyB.ehR()) {
            return this.oyz;
        }
        this.oyA.setTime(j);
        this.oyB.setTime(j2);
        synchronized (this.mLockObject) {
            this.oyz.s(((SortedSet) this.oyy).subSet(this.oyA, this.oyB));
        }
        return this.oyz;
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
        if (this.oyy != null) {
            this.oyy.clear();
            this.mSize = 0;
        }
        if (this.oyz != null) {
            this.oyz = null;
            this.oyA = Wo("start");
            this.oyB = Wo("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d ehZ() {
        if (this.oyy != null && !this.oyy.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oyy).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oyy).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d eia() {
        if (this.oyy != null && !this.oyy.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oyy).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oyy).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.oyy != null && this.oyy.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.oyy == null || this.oyy.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.eib();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.oyy.iterator();
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
        bVar.eic();
    }
}
