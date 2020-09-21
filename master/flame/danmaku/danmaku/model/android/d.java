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
    public Collection<master.flame.danmaku.danmaku.model.d> oId;
    private d oIe;
    private master.flame.danmaku.danmaku.model.d oIf;
    private master.flame.danmaku.danmaku.model.d oIg;
    private master.flame.danmaku.danmaku.model.d oIh;
    private master.flame.danmaku.danmaku.model.d oIi;
    private l.a oIj;
    private boolean oIk;

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
            this.oId = new LinkedList();
        } else {
            this.oIk = z;
            aVar.za(z);
            this.oId = new TreeSet(aVar);
            this.oIj = aVar;
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
        if (this.oIk && this.mSortType != 4) {
            this.oId.clear();
            this.oId.addAll(collection);
            collection = this.oId;
        } else {
            this.oId = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oId != null) {
            try {
                if (this.oId.add(dVar)) {
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
        if (dVar.elF()) {
            dVar.setVisibility(false);
        }
        if (this.oId.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> S(long j, long j2) {
        if (this.mSortType == 4 || this.oId == null || this.oId.size() == 0) {
            return null;
        }
        if (this.oIe == null) {
            this.oIe = new d(this.oIk);
            this.oIe.mLockObject = this.mLockObject;
        }
        if (this.oIi == null) {
            this.oIi = WQ("start");
        }
        if (this.oIh == null) {
            this.oIh = WQ("end");
        }
        this.oIi.setTime(j);
        this.oIh.setTime(j2);
        return ((SortedSet) this.oId).subSet(this.oIi, this.oIh);
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
        if (this.oId == null || this.oId.size() == 0) {
            return null;
        }
        if (this.oIe == null) {
            if (this.mSortType == 4) {
                this.oIe = new d(4);
                this.oIe.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.oIe.s(this.oId);
                }
            } else {
                this.oIe = new d(this.oIk);
                this.oIe.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.oIe;
        }
        if (this.oIf == null) {
            this.oIf = WQ("start");
        }
        if (this.oIg == null) {
            this.oIg = WQ("end");
        }
        if (this.oIe != null && j - this.oIf.elO() >= 0 && j2 <= this.oIg.elO()) {
            return this.oIe;
        }
        this.oIf.setTime(j);
        this.oIg.setTime(j2);
        synchronized (this.mLockObject) {
            this.oIe.s(((SortedSet) this.oId).subSet(this.oIf, this.oIg));
        }
        return this.oIe;
    }

    private master.flame.danmaku.danmaku.model.d WQ(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.oId != null) {
            this.oId.clear();
            this.mSize = 0;
        }
        if (this.oIe != null) {
            this.oIe = null;
            this.oIf = WQ("start");
            this.oIg = WQ("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d elW() {
        if (this.oId != null && !this.oId.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oId).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oId).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d elX() {
        if (this.oId != null && !this.oId.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oId).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oId).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.oId != null && this.oId.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.oId == null || this.oId.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.elY();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.oId.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int bQ = bVar.bQ(next);
                if (bQ == 1) {
                    break;
                } else if (bQ == 2) {
                    it.remove();
                } else if (bQ == 3) {
                    it.remove();
                    break;
                }
            }
        }
        bVar.elZ();
    }
}
