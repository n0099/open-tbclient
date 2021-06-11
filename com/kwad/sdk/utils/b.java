package com.kwad.sdk.utils;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f37520e;

    /* renamed from: a  reason: collision with root package name */
    public g f37521a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<g.a>> f37522b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37523c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37524d = false;

    public b() {
        a(KsAdSDKImpl.get().getContext());
    }

    public static b a() {
        if (f37520e == null) {
            synchronized (b.class) {
                if (f37520e == null) {
                    f37520e = new b();
                }
            }
        }
        return f37520e;
    }

    private void a(Context context) {
        this.f37523c = false;
        g gVar = new g(context);
        this.f37521a = gVar;
        gVar.a(new g.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                g.a aVar;
                Iterator it = b.this.f37522b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (g.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.f37524d = true;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                g.a aVar;
                Iterator it = b.this.f37522b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (g.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.b();
                    }
                }
            }
        });
    }

    public void a(g.a aVar) {
        this.f37522b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.f37521a == null) {
            return;
        }
        if (z || !this.f37523c) {
            this.f37521a.a();
            this.f37523c = true;
            this.f37524d = false;
        }
    }

    public void b(g.a aVar) {
        Iterator<WeakReference<g.a>> it = this.f37522b.iterator();
        while (it.hasNext()) {
            WeakReference<g.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.f37524d;
    }
}
