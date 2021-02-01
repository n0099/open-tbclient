package com.kwad.sdk.utils;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private static volatile b e;

    /* renamed from: a  reason: collision with root package name */
    private g f10815a;

    /* renamed from: b  reason: collision with root package name */
    private List<WeakReference<g.a>> f10816b = new ArrayList();
    private boolean c = false;
    private boolean d = false;

    private b() {
        a(KsAdSDKImpl.get().getContext());
    }

    public static b a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    private void a(Context context) {
        this.c = false;
        this.f10815a = new g(context);
        this.f10815a.a(new g.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                Iterator it = b.this.f10816b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        g.a aVar = (g.a) weakReference.get();
                        if (aVar != null) {
                            aVar.a();
                        } else {
                            it.remove();
                        }
                    }
                }
                b.this.d = true;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                Iterator it = b.this.f10816b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        g.a aVar = (g.a) weakReference.get();
                        if (aVar != null) {
                            aVar.b();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public void a(g.a aVar) {
        this.f10816b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.f10815a == null) {
            return;
        }
        if (z || !this.c) {
            this.f10815a.a();
            this.c = true;
            this.d = false;
        }
    }

    public void b(g.a aVar) {
        Iterator<WeakReference<g.a>> it = this.f10816b.iterator();
        while (it.hasNext()) {
            WeakReference<g.a> next = it.next();
            if (next == null) {
                it.remove();
            } else if (next.get() == aVar) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.d;
    }
}
