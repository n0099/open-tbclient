package f.a.t;

import f.a.x.i.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a implements b, f.a.x.a.a {

    /* renamed from: e  reason: collision with root package name */
    public g<b> f67471e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f67472f;

    @Override // f.a.x.a.a
    public boolean a(b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // f.a.x.a.a
    public boolean b(b bVar) {
        f.a.x.b.a.b(bVar, "d is null");
        if (!this.f67472f) {
            synchronized (this) {
                if (!this.f67472f) {
                    g<b> gVar = this.f67471e;
                    if (gVar == null) {
                        gVar = new g<>();
                        this.f67471e = gVar;
                    }
                    gVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // f.a.x.a.a
    public boolean c(b bVar) {
        f.a.x.b.a.b(bVar, "Disposable item is null");
        if (this.f67472f) {
            return false;
        }
        synchronized (this) {
            if (this.f67472f) {
                return false;
            }
            g<b> gVar = this.f67471e;
            if (gVar != null && gVar.e(bVar)) {
                return true;
            }
            return false;
        }
    }

    public void d(g<b> gVar) {
        Object[] b2;
        if (gVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : gVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    f.a.u.a.a(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.c((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.f67472f) {
            return;
        }
        synchronized (this) {
            if (this.f67472f) {
                return;
            }
            this.f67472f = true;
            g<b> gVar = this.f67471e;
            this.f67471e = null;
            d(gVar);
        }
    }

    public int e() {
        if (this.f67472f) {
            return 0;
        }
        synchronized (this) {
            if (this.f67472f) {
                return 0;
            }
            g<b> gVar = this.f67471e;
            return gVar != null ? gVar.g() : 0;
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f67472f;
    }
}
