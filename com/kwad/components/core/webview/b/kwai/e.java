package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public abstract class e implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c ND;
    @NonNull
    public CopyOnWriteArrayList<com.kwad.sdk.core.response.kwai.a> NE = new CopyOnWriteArrayList<>();

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.ND = cVar;
        if (this.NE.size() > 0) {
            Iterator<com.kwad.sdk.core.response.kwai.a> it = this.NE.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.response.kwai.a next = it.next();
                b(next);
                this.NE.remove(next);
            }
        }
    }

    public final void b(final com.kwad.sdk.core.response.kwai.a aVar) {
        if (this.ND != null) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.b.kwai.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.ND != null) {
                        e.this.ND.a(aVar);
                    }
                }
            });
        } else {
            this.NE.add(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.ND = null;
    }
}
