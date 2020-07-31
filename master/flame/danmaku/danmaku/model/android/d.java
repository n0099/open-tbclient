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
    public Collection<master.flame.danmaku.danmaku.model.d> oeh;
    private d oei;
    private master.flame.danmaku.danmaku.model.d oej;
    private master.flame.danmaku.danmaku.model.d oek;
    private master.flame.danmaku.danmaku.model.d oel;
    private master.flame.danmaku.danmaku.model.d oem;
    private l.a oen;
    private boolean oeo;

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
            this.oeh = new LinkedList();
        } else {
            this.oeo = z;
            aVar.xY(z);
            this.oeh = new TreeSet(aVar);
            this.oen = aVar;
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
        if (this.oeo && this.mSortType != 4) {
            this.oeh.clear();
            this.oeh.addAll(collection);
            collection = this.oeh;
        } else {
            this.oeh = collection;
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean k(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oeh != null) {
            try {
                if (this.oeh.add(dVar)) {
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
        if (dVar.dVv()) {
            dVar.setVisibility(false);
        }
        if (this.oeh.remove(dVar)) {
            this.mSize--;
            return true;
        }
        return false;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> V(long j, long j2) {
        if (this.mSortType == 4 || this.oeh == null || this.oeh.size() == 0) {
            return null;
        }
        if (this.oei == null) {
            this.oei = new d(this.oeo);
            this.oei.mLockObject = this.mLockObject;
        }
        if (this.oem == null) {
            this.oem = Tk("start");
        }
        if (this.oel == null) {
            this.oel = Tk("end");
        }
        this.oem.setTime(j);
        this.oel.setTime(j2);
        return ((SortedSet) this.oeh).subSet(this.oem, this.oel);
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
        if (this.oeh == null || this.oeh.size() == 0) {
            return null;
        }
        if (this.oei == null) {
            if (this.mSortType == 4) {
                this.oei = new d(4);
                this.oei.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.oei.q(this.oeh);
                }
            } else {
                this.oei = new d(this.oeo);
                this.oei.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.oei;
        }
        if (this.oej == null) {
            this.oej = Tk("start");
        }
        if (this.oek == null) {
            this.oek = Tk("end");
        }
        if (this.oei != null && j - this.oej.dVE() >= 0 && j2 <= this.oek.dVE()) {
            return this.oei;
        }
        this.oej.setTime(j);
        this.oek.setTime(j2);
        synchronized (this.mLockObject) {
            this.oei.q(((SortedSet) this.oeh).subSet(this.oej, this.oek));
        }
        return this.oei;
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
        if (this.oeh != null) {
            this.oeh.clear();
            this.mSize = 0;
        }
        if (this.oei != null) {
            this.oei = null;
            this.oej = Tk("start");
            this.oek = Tk("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dVM() {
        if (this.oeh != null && !this.oeh.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oeh).peek();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oeh).first();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public master.flame.danmaku.danmaku.model.d dVN() {
        if (this.oeh != null && !this.oeh.isEmpty()) {
            if (this.mSortType == 4) {
                return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.oeh).peekLast();
            }
            return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.oeh).last();
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean m(master.flame.danmaku.danmaku.model.d dVar) {
        return this.oeh != null && this.oeh.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public boolean isEmpty() {
        return this.oeh == null || this.oeh.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void a(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.mLockObject) {
            b(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.l
    public void b(l.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.dVO();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.oeh.iterator();
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
        bVar.dVP();
    }
}
