package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c ZF;
    @NonNull
    public CopyOnWriteArrayList<com.kwad.sdk.core.b> ZG = new CopyOnWriteArrayList<>();

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.ZF = null;
    }

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.ZF != null) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.w.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (w.this.ZF != null) {
                        w.this.ZF.a(bVar);
                    }
                }
            });
        } else {
            this.ZG.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ZF = cVar;
        if (this.ZG.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.ZG.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.ZG.remove(next);
            }
        }
    }
}
