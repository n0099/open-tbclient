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
    private d nyA;
    private master.flame.danmaku.danmaku.model.d nyB;
    private master.flame.danmaku.danmaku.model.d nyC;
    private master.flame.danmaku.danmaku.model.d nyD;
    private master.flame.danmaku.danmaku.model.d nyE;
    private l.a nyF;
    private boolean nyG;
    public Collection<master.flame.danmaku.danmaku.model.d> nyz;

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
            this.nyz = new LinkedList();
        } else {
            this.nyG = z;
            aVar.wW(z);
            this.nyz = new TreeSet(aVar);
            this.nyF = aVar;
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
        if (this.nyG && this.mSortType != 4) {
            this.nyz.clear();
            this.nyz.addAll(collection);
            collection = this.nyz;
        } else {
            this.nyz = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nyz != null) {
            try {
                if (this.nyz.add(dVar)) {
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
        if (dVar.dNb()) {
            dVar.setVisibility(false);
        }
        if (this.nyz.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> S(long j, long j2) {
        if (this.mSortType == 4 || this.nyz == null || this.nyz.size() == 0) {
            return null;
        }
        if (this.nyA == null) {
            this.nyA = new d(this.nyG);
            this.nyA.mLockObject = this.mLockObject;
        }
        if (this.nyE == null) {
            this.nyE = RL("start");
        }
        if (this.nyD == null) {
            this.nyD = RL("end");
        }
        this.nyE.setTime(j);
        this.nyD.setTime(j2);
        return ((SortedSet) this.nyz).subSet(this.nyE, this.nyD);
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
        if (this.nyz == null || this.nyz.size() == 0) {
            return null;
        }
        if (this.nyA == null) {
            if (this.mSortType == 4) {
                this.nyA = new d(4);
                this.nyA.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.nyA.q(this.nyz);
                }
            } else {
                this.nyA = new d(this.nyG);
                this.nyA.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.nyA;
        }
        if (this.nyB == null) {
            this.nyB = RL("start");
        }
        if (this.nyC == null) {
            this.nyC = RL("end");
        }
        if (this.nyA != null && j - this.nyB.dNk() >= 0 && j2 <= this.nyC.dNk()) {
            return this.nyA;
        }
        this.nyB.setTime(j);
        this.nyC.setTime(j2);
        synchronized (this.mLockObject) {
            this.nyA.q(((SortedSet) this.nyz).subSet(this.nyB, this.nyC));
        }
        return this.nyA;
    }

    private master.flame.danmaku.danmaku.model.d RL(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.nyz != null) {
            this.nyz.clear();
            this.mSize = 0;
        }
        if (this.nyA != null) {
            this.nyA = null;
            this.nyB = RL("start");
            this.nyC = RL("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dNs() {
        if (this.nyz != null && !this.nyz.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nyz).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nyz).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dNt() {
        if (this.nyz != null && !this.nyz.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.nyz).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.nyz).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.nyz != null && this.nyz.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.nyz == null || this.nyz.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dNu();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.nyz.iterator();
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
        bVar.dNv();
    }
}
