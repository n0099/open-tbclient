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
    public Collection<master.flame.danmaku.danmaku.model.d> pOO;
    private d pOP;
    private master.flame.danmaku.danmaku.model.d pOQ;
    private master.flame.danmaku.danmaku.model.d pOR;
    private master.flame.danmaku.danmaku.model.d pOS;
    private master.flame.danmaku.danmaku.model.d pOT;
    private l.a pOU;
    private boolean pOV;

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
            this.pOO = new LinkedList();
        } else {
            this.pOV = z;
            aVar.AP(z);
            this.pOO = new TreeSet(aVar);
            this.pOU = aVar;
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
        if (this.pOV && this.mSortType != 4) {
            this.pOO.clear();
            this.pOO.addAll(collection);
            collection = this.pOO;
        } else {
            this.pOO = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pOO != null) {
            try {
                if (this.pOO.add(dVar)) {
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
        if (dVar.ezq()) {
            dVar.setVisibility(false);
        }
        if (this.pOO.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> T(long j, long j2) {
        if (this.mSortType == 4 || this.pOO == null || this.pOO.size() == 0) {
            return null;
        }
        if (this.pOP == null) {
            this.pOP = new d(this.pOV);
            this.pOP.mLockObject = this.mLockObject;
        }
        if (this.pOT == null) {
            this.pOT = Zr("start");
        }
        if (this.pOS == null) {
            this.pOS = Zr("end");
        }
        this.pOT.setTime(j);
        this.pOS.setTime(j2);
        return ((SortedSet) this.pOO).subSet(this.pOT, this.pOS);
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
        if (this.pOO == null || this.pOO.size() == 0) {
            return null;
        }
        if (this.pOP == null) {
            if (this.mSortType == 4) {
                this.pOP = new d(4);
                this.pOP.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.pOP.s(this.pOO);
                }
            } else {
                this.pOP = new d(this.pOV);
                this.pOP.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.pOP;
        }
        if (this.pOQ == null) {
            this.pOQ = Zr("start");
        }
        if (this.pOR == null) {
            this.pOR = Zr("end");
        }
        if (this.pOP != null && j - this.pOQ.ezz() >= 0 && j2 <= this.pOR.ezz()) {
            return this.pOP;
        }
        this.pOQ.setTime(j);
        this.pOR.setTime(j2);
        synchronized (this.mLockObject) {
            this.pOP.s(((SortedSet) this.pOO).subSet(this.pOQ, this.pOR));
        }
        return this.pOP;
    }

    private master.flame.danmaku.danmaku.model.d Zr(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.pOO != null) {
            this.pOO.clear();
            this.mSize = 0;
        }
        if (this.pOP != null) {
            this.pOP = null;
            this.pOQ = Zr("start");
            this.pOR = Zr("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d ezH() {
        if (this.pOO != null && !this.pOO.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.pOO).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.pOO).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d ezI() {
        if (this.pOO != null && !this.pOO.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.pOO).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.pOO).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.pOO != null && this.pOO.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.pOO == null || this.pOO.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.ezJ();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.pOO.iterator();
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
        bVar.ezK();
    }
}
