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
    public static volatile b f37052e;

    /* renamed from: a  reason: collision with root package name */
    public g f37053a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<g.a>> f37054b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37055c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37056d = false;

    public b() {
        a(KsAdSDKImpl.get().getContext());
    }

    public static b a() {
        if (f37052e == null) {
            synchronized (b.class) {
                if (f37052e == null) {
                    f37052e = new b();
                }
            }
        }
        return f37052e;
    }

    private void a(Context context) {
        this.f37055c = false;
        g gVar = new g(context);
        this.f37053a = gVar;
        gVar.a(new g.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                g.a aVar;
                Iterator it = b.this.f37054b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (g.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.f37056d = true;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                g.a aVar;
                Iterator it = b.this.f37054b.iterator();
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
        this.f37054b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.f37053a == null) {
            return;
        }
        if (z || !this.f37055c) {
            this.f37053a.a();
            this.f37055c = true;
            this.f37056d = false;
        }
    }

    public void b(g.a aVar) {
        Iterator<WeakReference<g.a>> it = this.f37054b.iterator();
        while (it.hasNext()) {
            WeakReference<g.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.f37056d;
    }
}
