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
    public Collection<master.flame.danmaku.danmaku.model.d> oej;
    private d oek;
    private master.flame.danmaku.danmaku.model.d oel;
    private master.flame.danmaku.danmaku.model.d oem;
    private master.flame.danmaku.danmaku.model.d oen;
    private master.flame.danmaku.danmaku.model.d oeo;
    private l.a oep;
    private boolean oeq;

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
            this.oej = new LinkedList();
        } else {
            this.oeq = z;
            aVar.xY(z);
            this.oej = new TreeSet(aVar);
            this.oep = aVar;
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
        if (this.oeq && this.mSortType != 4) {
            this.oej.clear();
            this.oej.addAll(collection);
            collection = this.oej;
        } else {
            this.oej = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oej != null) {
            try {
                if (this.oej.add(dVar)) {
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
        if (dVar.dVw()) {
            dVar.setVisibility(false);
        }
        if (this.oej.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> V(long j, long j2) {
        if (this.mSortType == 4 || this.oej == null || this.oej.size() == 0) {
            return null;
        }
        if (this.oek == null) {
            this.oek = new d(this.oeq);
            this.oek.mLockObject = this.mLockObject;
        }
        if (this.oeo == null) {
            this.oeo = Tk("start");
        }
        if (this.oen == null) {
            this.oen = Tk("end");
        }
        this.oeo.setTime(j);
        this.oen.setTime(j2);
        return ((SortedSet) this.oej).subSet(this.oeo, this.oen);
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
        if (this.oej == null || this.oej.size() == 0) {
            return null;
        }
        if (this.oek == null) {
            if (this.mSortType == 4) {
                this.oek = new d(4);
                this.oek.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.oek.q(this.oej);
                }
            } else {
                this.oek = new d(this.oeq);
                this.oek.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.oek;
        }
        if (this.oel == null) {
            this.oel = Tk("start");
        }
        if (this.oem == null) {
            this.oem = Tk("end");
        }
        if (this.oek != null && j - this.oel.dVF() >= 0 && j2 <= this.oem.dVF()) {
            return this.oek;
        }
        this.oel.setTime(j);
        this.oem.setTime(j2);
        synchronized (this.mLockObject) {
            this.oek.q(((SortedSet) this.oej).subSet(this.oel, this.oem));
        }
        return this.oek;
    }

    private master.flame.danmaku.danmaku.model.d Tk(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void clear() {
        if (this.oej != null) {
            this.oej.clear();
            this.mSize = 0;
        }
        if (this.oek != null) {
            this.oek = null;
            this.oel = Tk("start");
            this.oem = Tk("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dVN() {
        if (this.oej != null && !this.oej.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oej).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oej).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dVO() {
        if (this.oej != null && !this.oej.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oej).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oej).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.oej != null && this.oej.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.oej == null || this.oej.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dVP();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.oej.iterator();
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
        bVar.dVQ();
    }
}
