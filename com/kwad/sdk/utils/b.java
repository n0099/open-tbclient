package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static volatile b e;
    public j a;
    public List<WeakReference<j.a>> b = new ArrayList();
    public boolean c = false;
    public boolean d = false;

    public b(@NonNull Context context) {
        b(context);
    }

    public static b a(@NonNull Context context) {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b(context.getApplicationContext());
                }
            }
        }
        return e;
    }

    private void b(Context context) {
        this.c = false;
        j jVar = new j(context);
        this.a = jVar;
        jVar.a(new j.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                j.a aVar;
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (j.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.d = true;
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                j.a aVar;
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (j.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.b();
                    }
                }
            }
        });
    }

    public void a(j.a aVar) {
        this.b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.a == null) {
            return;
        }
        if (z || !this.c) {
            this.a.a();
            this.c = true;
            this.d = false;
        }
    }

    public boolean a() {
        return this.d;
    }

    public void b(j.a aVar) {
        Iterator<WeakReference<j.a>> it = this.b.iterator();
        while (it.hasNext()) {
            WeakReference<j.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }
}
