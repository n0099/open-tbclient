package com.kwad.components.ad.h;

import com.kwad.components.core.proxy.h;
import com.kwad.components.core.proxy.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes10.dex */
public class b implements com.kwad.components.core.internal.api.b {
    public static final Object nE = new Object();
    public static volatile b nF;
    public Set<Integer> nG = new HashSet();
    public List<c> nH = new ArrayList();
    public Map<com.kwad.components.core.internal.api.a, Object> nI = new WeakHashMap();
    public Map<com.kwad.components.core.proxy.c, Object> nJ = new WeakHashMap();
    public i nK = new i() { // from class: com.kwad.components.ad.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            b.this.nJ.put(cVar, b.nE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            b.this.nJ.remove(cVar);
            if (!b.this.nJ.isEmpty()) {
                return;
            }
            b.this.eI();
        }
    };

    public static b eH() {
        if (nF == null) {
            synchronized (b.class) {
                if (nF == null) {
                    nF = new b();
                }
            }
        }
        return nF;
    }

    public final synchronized boolean eJ() {
        for (com.kwad.components.core.internal.api.a aVar : this.nI.keySet()) {
            if (A(aVar.getAdTemplate())) {
                return false;
            }
        }
        return this.nJ.isEmpty();
    }

    public b() {
        h.pV().a(this.nK);
        this.nG.add(2);
        this.nG.add(3);
        this.nG.add(13);
        this.nG.add(6);
    }

    private boolean A(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.nG.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.nI.put(aVar, nE);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.eL();
            this.nH.add(cVar);
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.nI.remove(aVar);
        for (c cVar : this.nH) {
            cVar.d(aVar);
        }
        if (A(aVar.getAdTemplate())) {
            eI();
        }
    }

    public static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (!aVar.ag()) {
            return false;
        }
        return com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.dP(aVar.getAdTemplate()));
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eI() {
        boolean eJ = eJ();
        com.kwad.sdk.core.e.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + eJ);
        if (eJ) {
            for (c cVar : this.nH) {
                cVar.eN();
            }
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.nH.remove(cVar);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
