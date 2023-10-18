package com.kwad.components.core.webview.b.c;

import com.kwad.components.core.webview.b.d.b;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class a {
    public final Set<b> mw;

    /* renamed from: com.kwad.components.core.webview.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0633a {
        public static final a Os = new a((byte) 0);
    }

    public a() {
        this.mw = new HashSet();
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str) {
        if (this.mw.size() == 0) {
            return;
        }
        for (b bVar : this.mw) {
            bVar.u(str);
        }
    }

    public static a pR() {
        return C0633a.Os;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.mw.add(bVar);
        }
    }

    public final void aK(final String str) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.b.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aJ(str);
            }
        });
    }

    public final void b(b bVar) {
        this.mw.remove(bVar);
    }
}
