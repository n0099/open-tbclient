package com.kwad.components.core.webview.tachikoma.d;

import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes10.dex */
public final class b {
    public final Set<e> aaJ;

    /* loaded from: classes10.dex */
    public static class a {
        public static final b aaP = new b((byte) 0);
    }

    public b() {
        this.aaJ = new CopyOnWriteArraySet();
    }

    public static b sS() {
        return a.aaP;
    }

    public final void sT() {
        this.aaJ.clear();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.aaJ.add(eVar);
        }
    }

    public final void b(e eVar) {
        this.aaJ.remove(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, long j2, long j3) {
        if (this.aaJ.size() == 0) {
            return;
        }
        for (e eVar : new HashSet(this.aaJ)) {
            eVar.a(str, j, j2, j3);
        }
    }

    public final void c(final String str, final long j, final long j2, final long j3) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.d.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(str, j, j2, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2) {
        if (this.aaJ.size() == 0) {
            return;
        }
        for (e eVar : new HashSet(this.aaJ)) {
            eVar.q(str2);
        }
    }

    public final void p(final String str, final String str2) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.d.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.this.o(str, str2);
            }
        });
    }
}
