package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.g;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a implements b, io.reactivex.internal.disposables.a {
    volatile boolean disposed;
    g<b> qdr;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    this.disposed = true;
                    g<b> gVar = this.qdr;
                    this.qdr = null;
                    a(gVar);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean a(b bVar) {
        io.reactivex.internal.functions.a.m(bVar, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    g<b> gVar = this.qdr;
                    if (gVar == null) {
                        gVar = new g<>();
                        this.qdr = gVar;
                    }
                    gVar.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(b bVar) {
        boolean z = false;
        io.reactivex.internal.functions.a.m(bVar, "Disposable item is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    g<b> gVar = this.qdr;
                    if (gVar != null && gVar.remove(bVar)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int size() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    g<b> gVar = this.qdr;
                    r0 = gVar != null ? gVar.size() : 0;
                }
            }
        }
        return r0;
    }

    void a(g<b> gVar) {
        Object[] eIp;
        if (gVar != null) {
            ArrayList arrayList = null;
            for (Object obj : gVar.eIp()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.O(th);
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(th);
                        arrayList = arrayList2;
                    }
                }
            }
            if (arrayList != null) {
                if (arrayList.size() == 1) {
                    throw ExceptionHelper.Q((Throwable) arrayList.get(0));
                }
                throw new CompositeException(arrayList);
            }
        }
    }
}
