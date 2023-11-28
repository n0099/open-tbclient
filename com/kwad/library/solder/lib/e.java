package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    public final com.kwad.library.solder.lib.ext.c aiI;
    public final com.kwad.library.solder.lib.a.c aiK;
    public final com.kwad.library.solder.lib.a.f aiL;
    public final com.kwad.library.solder.lib.a.b aiM;
    public final com.kwad.library.solder.lib.ext.a aiN;
    public Map<String, b> aiO;

    /* loaded from: classes10.dex */
    public static abstract class a {
        public final com.kwad.library.solder.lib.a.d aiS;

        public abstract void h(com.kwad.library.solder.lib.a.e eVar);

        /* renamed from: com.kwad.library.solder.lib.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0689a extends a {
            public C0689a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void h(com.kwad.library.solder.lib.a.e eVar) {
                this.aiS.wP().d(eVar);
            }
        }

        /* loaded from: classes10.dex */
        public static class b extends a {
            public b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void h(com.kwad.library.solder.lib.a.e eVar) {
                this.aiS.wQ().i(eVar);
            }
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.aiS = dVar;
        }

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i) {
            if (i != 1) {
                return new C0689a(dVar);
            }
            return new b(dVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public final com.kwad.library.solder.lib.a.e aiT;
        public final Future<com.kwad.library.solder.lib.a.e> aiU;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.aiT = eVar;
            this.aiU = future;
        }

        public final void cancel() {
            this.aiT.cancel();
            this.aiU.cancel(true);
        }
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.aiK = cVar;
        this.aiL = fVar;
        this.aiM = bVar;
        this.aiI = cVar2;
        this.aiN = aVar;
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> c = c(this.aiO);
        this.aiO = c;
        if (str != null) {
            c.put(str, bVar);
        }
    }

    private b b(@NonNull final com.kwad.library.solder.lib.a.e eVar, @NonNull final a aVar) {
        b bA = bA(eVar.xf());
        if (bA != null) {
            bA.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.aiI.xx().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: wT */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.xf(), bVar);
        return bVar;
    }

    @Nullable
    private synchronized b bA(String str) {
        Map<String, b> c = c(this.aiO);
        this.aiO = c;
        if (str != null) {
            return c.get(str);
        }
        return null;
    }

    public static Map<String, b> c(Map<String, b> map) {
        if (map == null || map == Collections.EMPTY_MAP) {
            return new HashMap();
        }
        return map;
    }

    public final void g(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        b bA = bA(eVar.xf());
        if (bA != null) {
            bA.cancel();
        }
        a(eVar.xf(), (b) null);
    }

    public final com.kwad.library.solder.lib.a.e a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        if (eVar.xb() == null) {
            eVar.a(this);
        }
        StringBuilder sb = new StringBuilder("request pluginId:");
        sb.append(eVar.xf());
        sb.append(", state: ");
        sb.append(eVar.xc());
        aVar.h(eVar);
        return eVar;
    }

    public final b a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull int i) {
        return b(eVar, a.a(this, 16));
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c wO() {
        return this.aiI;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c wP() {
        return this.aiK;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f wQ() {
        return this.aiL;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b wR() {
        return this.aiM;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a wS() {
        return this.aiN;
    }
}
