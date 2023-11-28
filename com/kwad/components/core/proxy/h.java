package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.utils.bn;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class h {
    public static volatile h QL;
    public final List<i> mListeners = new CopyOnWriteArrayList();

    public static h pV() {
        if (QL == null) {
            synchronized (h.class) {
                if (QL == null) {
                    QL = new h();
                }
            }
        }
        return QL;
    }

    private void c(final com.kwad.sdk.g.a<i> aVar) {
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.proxy.h.5
            @Override // java.lang.Runnable
            public final void run() {
                for (i iVar : h.this.mListeners) {
                    if (iVar != null) {
                        try {
                            aVar.accept(iVar);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                }
            }
        });
    }

    public final void e(final c cVar) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.d(cVar);
            }
        });
    }

    public final void f(final c cVar) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.c(cVar);
            }
        });
    }

    public final void g(final c cVar) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.4
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(i iVar) {
            }
        });
    }

    public final void a(final c cVar, final Bundle bundle) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(i iVar) {
            }
        });
    }

    public final void a(i iVar) {
        this.mListeners.add(iVar);
    }
}
