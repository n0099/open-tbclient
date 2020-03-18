package io.reactivex.internal.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b implements io.reactivex.disposables.b, a {
    volatile boolean disposed;
    List<io.reactivex.disposables.b> nxU;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    this.disposed = true;
                    List<io.reactivex.disposables.b> list = this.nxU;
                    this.nxU = null;
                    ft(list);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean a(io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.h(bVar, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    List list = this.nxU;
                    if (list == null) {
                        list = new LinkedList();
                        this.nxU = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(io.reactivex.disposables.b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(io.reactivex.disposables.b bVar) {
        boolean z = false;
        io.reactivex.internal.functions.a.h(bVar, "Disposable item is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    List<io.reactivex.disposables.b> list = this.nxU;
                    if (list != null && list.remove(bVar)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    void ft(List<io.reactivex.disposables.b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (io.reactivex.disposables.b bVar : list) {
                try {
                    bVar.dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(th);
                    arrayList = arrayList2;
                }
            }
            if (arrayList != null) {
                if (arrayList.size() == 1) {
                    throw ExceptionHelper.J((Throwable) arrayList.get(0));
                }
                throw new CompositeException(arrayList);
            }
        }
    }
}
