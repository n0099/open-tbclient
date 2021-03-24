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
    public static volatile b f36762e;

    /* renamed from: a  reason: collision with root package name */
    public g f36763a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<g.a>> f36764b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f36765c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36766d = false;

    public b() {
        a(KsAdSDKImpl.get().getContext());
    }

    public static b a() {
        if (f36762e == null) {
            synchronized (b.class) {
                if (f36762e == null) {
                    f36762e = new b();
                }
            }
        }
        return f36762e;
    }

    private void a(Context context) {
        this.f36765c = false;
        g gVar = new g(context);
        this.f36763a = gVar;
        gVar.a(new g.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                g.a aVar;
                Iterator it = b.this.f36764b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (g.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.f36766d = true;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                g.a aVar;
                Iterator it = b.this.f36764b.iterator();
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
        this.f36764b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.f36763a == null) {
            return;
        }
        if (z || !this.f36765c) {
            this.f36763a.a();
            this.f36765c = true;
            this.f36766d = false;
        }
    }

    public void b(g.a aVar) {
        Iterator<WeakReference<g.a>> it = this.f36764b.iterator();
        while (it.hasNext()) {
            WeakReference<g.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.f36766d;
    }
}
