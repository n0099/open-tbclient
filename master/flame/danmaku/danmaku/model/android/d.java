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
    private int mSize;
    private int mSortType;
    private master.flame.danmaku.danmaku.model.d ndA;
    private master.flame.danmaku.danmaku.model.d ndB;
    private l.a ndC;
    private boolean ndD;
    private Object ndE;
    public Collection<master.flame.danmaku.danmaku.model.d> ndw;
    private d ndx;
    private master.flame.danmaku.danmaku.model.d ndy;
    private master.flame.danmaku.danmaku.model.d ndz;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.ndE = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.ndw = new LinkedList();
        } else {
            this.ndD = z;
            aVar.wy(z);
            this.ndw = new TreeSet(aVar);
            this.ndC = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.ndE = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.ndD && this.mSortType != 4) {
            this.ndw.clear();
            this.ndw.addAll(collection);
            collection = this.ndw;
        } else {
            this.ndw = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ndw != null) {
            try {
                if (this.ndw.add(dVar)) {
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
        if (dVar.dFh()) {
            dVar.setVisibility(false);
        }
        if (this.ndw.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> R(long j, long j2) {
        if (this.mSortType == 4 || this.ndw == null || this.ndw.size() == 0) {
            return null;
        }
        if (this.ndx == null) {
            this.ndx = new d(this.ndD);
            this.ndx.ndE = this.ndE;
        }
        if (this.ndB == null) {
            this.ndB = PF("start");
        }
        if (this.ndA == null) {
            this.ndA = PF("end");
        }
        this.ndB.setTime(j);
        this.ndA.setTime(j2);
        return ((SortedSet) this.ndw).subSet(this.ndB, this.ndA);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l O(long j, long j2) {
        Collection<master.flame.danmaku.danmaku.model.d> R = R(j, j2);
        if (R == null || R.isEmpty()) {
            return null;
        }
        return new d(new LinkedList(R));
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public l P(long j, long j2) {
        if (this.ndw == null || this.ndw.size() == 0) {
            return null;
        }
        if (this.ndx == null) {
            if (this.mSortType == 4) {
                this.ndx = new d(4);
                this.ndx.ndE = this.ndE;
                synchronized (this.ndE) {
                    this.ndx.o(this.ndw);
                }
            } else {
                this.ndx = new d(this.ndD);
                this.ndx.ndE = this.ndE;
            }
        }
        if (this.mSortType == 4) {
            return this.ndx;
        }
        if (this.ndy == null) {
            this.ndy = PF("start");
        }
        if (this.ndz == null) {
            this.ndz = PF("end");
        }
        if (this.ndx != null && j - this.ndy.dFq() >= 0 && j2 <= this.ndz.dFq()) {
            return this.ndx;
        }
        this.ndy.setTime(j);
        this.ndz.setTime(j2);
        synchronized (this.ndE) {
            this.ndx.o(((SortedSet) this.ndw).subSet(this.ndy, this.ndz));
        }
        return this.ndx;
    }

    private master.flame.danmaku.danmaku.model.d PF(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.ndw != null) {
            this.ndw.clear();
            this.mSize = 0;
        }
        if (this.ndx != null) {
            this.ndx = null;
            this.ndy = PF("start");
            this.ndz = PF("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dFy() {
        if (this.ndw != null && !this.ndw.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.ndw).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.ndw).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dFz() {
        if (this.ndw != null && !this.ndw.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.ndw).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.ndw).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.ndw != null && this.ndw.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.ndw == null || this.ndw.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.ndE) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dFA();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.ndw.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bF = bVar.bF(next);
                if (bF == 1) {
                    break;
                } else if (bF == 2) {
                    it.remove();
                } else if (bF == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.dFB();
    }
}
