package com.kwad.sdk.utils;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f37147e;

    /* renamed from: a  reason: collision with root package name */
    public g f37148a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<g.a>> f37149b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37150c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37151d = false;

    public b() {
        a(KsAdSDKImpl.get().getContext());
    }

    public static b a() {
        if (f37147e == null) {
            synchronized (b.class) {
                if (f37147e == null) {
                    f37147e = new b();
                }
            }
        }
        return f37147e;
    }

    private void a(Context context) {
        this.f37150c = false;
        g gVar = new g(context);
        this.f37148a = gVar;
        gVar.a(new g.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                g.a aVar;
                Iterator it = b.this.f37149b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (g.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.f37151d = true;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                g.a aVar;
                Iterator it = b.this.f37149b.iterator();
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
        this.f37149b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.f37148a == null) {
            return;
        }
        if (z || !this.f37150c) {
            this.f37148a.a();
            this.f37150c = true;
            this.f37151d = false;
        }
    }

    public void b(g.a aVar) {
        Iterator<WeakReference<g.a>> it = this.f37149b.iterator();
        while (it.hasNext()) {
            WeakReference<g.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.f37151d;
    }
}
