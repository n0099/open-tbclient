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
    public Collection<master.flame.danmaku.danmaku.model.d> oXs;
    private d oXt;
    private master.flame.danmaku.danmaku.model.d oXu;
    private master.flame.danmaku.danmaku.model.d oXv;
    private master.flame.danmaku.danmaku.model.d oXw;
    private master.flame.danmaku.danmaku.model.d oXx;
    private l.a oXy;
    private boolean oXz;

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
            this.oXs = new LinkedList();
        } else {
            this.oXz = z;
            aVar.zH(z);
            this.oXs = new TreeSet(aVar);
            this.oXy = aVar;
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
        if (this.oXz && this.mSortType != 4) {
            this.oXs.clear();
            this.oXs.addAll(collection);
            collection = this.oXs;
        } else {
            this.oXs = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oXs != null) {
            try {
                if (this.oXs.add(dVar)) {
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
        if (dVar.eps()) {
            dVar.setVisibility(false);
        }
        if (this.oXs.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> S(long j, long j2) {
        if (this.mSortType == 4 || this.oXs == null || this.oXs.size() == 0) {
            return null;
        }
        if (this.oXt == null) {
            this.oXt = new d(this.oXz);
            this.oXt.mLockObject = this.mLockObject;
        }
        if (this.oXx == null) {
            this.oXx = XE("start");
        }
        if (this.oXw == null) {
            this.oXw = XE("end");
        }
        this.oXx.setTime(j);
        this.oXw.setTime(j2);
        return ((SortedSet) this.oXs).subSet(this.oXx, this.oXw);
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
        if (this.oXs == null || this.oXs.size() == 0) {
            return null;
        }
        if (this.oXt == null) {
            if (this.mSortType == 4) {
                this.oXt = new d(4);
                this.oXt.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.oXt.s(this.oXs);
                }
            } else {
                this.oXt = new d(this.oXz);
                this.oXt.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.oXt;
        }
        if (this.oXu == null) {
            this.oXu = XE("start");
        }
        if (this.oXv == null) {
            this.oXv = XE("end");
        }
        if (this.oXt != null && j - this.oXu.epB() >= 0 && j2 <= this.oXv.epB()) {
            return this.oXt;
        }
        this.oXu.setTime(j);
        this.oXv.setTime(j2);
        synchronized (this.mLockObject) {
            this.oXt.s(((SortedSet) this.oXs).subSet(this.oXu, this.oXv));
        }
        return this.oXt;
    }

    private master.flame.danmaku.danmaku.model.d XE(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.oXs != null) {
            this.oXs.clear();
            this.mSize = 0;
        }
        if (this.oXt != null) {
            this.oXt = null;
            this.oXu = XE("start");
            this.oXv = XE("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d epJ() {
        if (this.oXs != null && !this.oXs.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oXs).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oXs).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d epK() {
        if (this.oXs != null && !this.oXs.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oXs).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oXs).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.oXs != null && this.oXs.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.oXs == null || this.oXs.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.epL();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.oXs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bT = bVar.bT(next);
                if (bT == 1) {
                    break;
                } else if (bT == 2) {
                    it.remove();
                } else if (bT == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.epM();
    }
}
