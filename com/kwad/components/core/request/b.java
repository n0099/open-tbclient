package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class b {
    public final List<a> Rf;

    /* loaded from: classes10.dex */
    public interface a {
        void qe();
    }

    /* renamed from: com.kwad.components.core.request.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0660b {
        public static final b Rg = new b((byte) 0);
    }

    public b() {
        this.Rf = new CopyOnWriteArrayList();
    }

    public static b qc() {
        return C0660b.Rg;
    }

    public final void qd() {
        for (a aVar : this.Rf) {
            if (aVar != null) {
                try {
                    aVar.qe();
                } catch (Throwable th) {
                    ServiceProvider.b(th);
                }
            }
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public final void a(a aVar) {
        this.Rf.add(aVar);
    }

    public final void b(a aVar) {
        this.Rf.remove(aVar);
    }
}
