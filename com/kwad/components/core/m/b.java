package com.kwad.components.core.m;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static volatile b IP;
    public com.kwad.sdk.utils.h IL;
    public List<WeakReference<h.a>> IM = new ArrayList();
    public boolean IN = false;
    public boolean IO = false;

    public b(@NonNull Context context) {
        init(context);
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.IO = true;
        return true;
    }

    public static b at(@NonNull Context context) {
        if (IP == null) {
            synchronized (b.class) {
                if (IP == null) {
                    IP = new b(context.getApplicationContext());
                }
            }
        }
        return IP;
    }

    private void init(Context context) {
        this.IN = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.IL = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.m.b.1
            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                h.a aVar;
                Iterator it = b.this.IM.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.bk();
                    }
                }
                b.a(b.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                h.a aVar;
                Iterator it = b.this.IM.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (h.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.bl();
                    }
                }
            }
        });
    }

    public final void a(h.a aVar) {
        this.IM.add(new WeakReference<>(aVar));
    }

    public final boolean ay(boolean z) {
        if (this.IL == null) {
            return false;
        }
        if (z || !this.IN) {
            this.IN = true;
            this.IO = false;
            return this.IL.zi();
        }
        return false;
    }

    public final void b(h.a aVar) {
        Iterator<WeakReference<h.a>> it = this.IM.iterator();
        while (it.hasNext()) {
            WeakReference<h.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }

    public final boolean ov() {
        return this.IO;
    }

    public final boolean ow() {
        return this.IN;
    }
}
