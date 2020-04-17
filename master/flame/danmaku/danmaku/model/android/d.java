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
    private boolean ndA;
    private Object ndB;
    public Collection<master.flame.danmaku.danmaku.model.d> ndt;
    private d ndu;
    private master.flame.danmaku.danmaku.model.d ndv;
    private master.flame.danmaku.danmaku.model.d ndw;
    private master.flame.danmaku.danmaku.model.d ndx;
    private master.flame.danmaku.danmaku.model.d ndy;
    private l.a ndz;

    public d() {
        this(0, false);
    }

    public d(int i) {
        this(i, false);
    }

    public d(int i, boolean z) {
        this.mSize = 0;
        this.mSortType = 0;
        this.ndB = new Object();
        l.a aVar = null;
        if (i == 0) {
            aVar = new l.d(z);
        } else if (i == 1) {
            aVar = new l.e(z);
        } else if (i == 2) {
            aVar = new l.f(z);
        }
        if (i == 4) {
            this.ndt = new LinkedList();
        } else {
            this.ndA = z;
            aVar.wy(z);
            this.ndt = new TreeSet(aVar);
            this.ndz = aVar;
        }
        this.mSortType = i;
        this.mSize = 0;
    }

    public d(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        this.ndB = new Object();
        o(collection);
    }

    public d(boolean z) {
        this(0, z);
    }

    public void o(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.ndA && this.mSortType != 4) {
            this.ndt.clear();
            this.ndt.addAll(collection);
            collection = this.ndt;
        } else {
            this.ndt = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ndt != null) {
            try {
                if (this.ndt.add(dVar)) {
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
        if (dVar.dFk()) {
            dVar.setVisibility(false);
        }
        if (this.ndt.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> R(long j, long j2) {
        if (this.mSortType == 4 || this.ndt == null || this.ndt.size() == 0) {
            return null;
        }
        if (this.ndu == null) {
            this.ndu = new d(this.ndA);
            this.ndu.ndB = this.ndB;
        }
        if (this.ndy == null) {
            this.ndy = PC("start");
        }
        if (this.ndx == null) {
            this.ndx = PC("end");
        }
        this.ndy.setTime(j);
        this.ndx.setTime(j2);
        return ((SortedSet) this.ndt).subSet(this.ndy, this.ndx);
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
        if (this.ndt == null || this.ndt.size() == 0) {
            return null;
        }
        if (this.ndu == null) {
            if (this.mSortType == 4) {
                this.ndu = new d(4);
                this.ndu.ndB = this.ndB;
                synchronized (this.ndB) {
                    this.ndu.o(this.ndt);
                }
            } else {
                this.ndu = new d(this.ndA);
                this.ndu.ndB = this.ndB;
            }
        }
        if (this.mSortType == 4) {
            return this.ndu;
        }
        if (this.ndv == null) {
            this.ndv = PC("start");
        }
        if (this.ndw == null) {
            this.ndw = PC("end");
        }
        if (this.ndu != null && j - this.ndv.dFt() >= 0 && j2 <= this.ndw.dFt()) {
            return this.ndu;
        }
        this.ndv.setTime(j);
        this.ndw.setTime(j2);
        synchronized (this.ndB) {
            this.ndu.o(((SortedSet) this.ndt).subSet(this.ndv, this.ndw));
        }
        return this.ndu;
    }

    private master.flame.danmaku.danmaku.model.d PC(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.ndt != null) {
            this.ndt.clear();
            this.mSize = 0;
        }
        if (this.ndu != null) {
            this.ndu = null;
            this.ndv = PC("start");
            this.ndw = PC("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dFB() {
        if (this.ndt != null && !this.ndt.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.ndt).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.ndt).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dFC() {
        if (this.ndt != null && !this.ndt.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.ndt).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.ndt).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.ndt != null && this.ndt.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.ndt == null || this.ndt.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.ndB) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dFD();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.ndt.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bE = bVar.bE(next);
                if (bE == 1) {
                    break;
                } else if (bE == 2) {
                    it.remove();
                } else if (bE == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.dFE();
    }
}
