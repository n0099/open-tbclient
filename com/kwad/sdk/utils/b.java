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
    public static volatile b f37618e;

    /* renamed from: a  reason: collision with root package name */
    public g f37619a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<g.a>> f37620b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37621c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37622d = false;

    public b() {
        a(KsAdSDKImpl.get().getContext());
    }

    public static b a() {
        if (f37618e == null) {
            synchronized (b.class) {
                if (f37618e == null) {
                    f37618e = new b();
                }
            }
        }
        return f37618e;
    }

    private void a(Context context) {
        this.f37621c = false;
        g gVar = new g(context);
        this.f37619a = gVar;
        gVar.a(new g.a() { // from class: com.kwad.sdk.utils.b.1
            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                g.a aVar;
                Iterator it = b.this.f37620b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (aVar = (g.a) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        aVar.a();
                    }
                }
                b.this.f37622d = true;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                g.a aVar;
                Iterator it = b.this.f37620b.iterator();
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
        this.f37620b.add(new WeakReference<>(aVar));
    }

    public void a(boolean z) {
        if (this.f37619a == null) {
            return;
        }
        if (z || !this.f37621c) {
            this.f37619a.a();
            this.f37621c = true;
            this.f37622d = false;
        }
    }

    public void b(g.a aVar) {
        Iterator<WeakReference<g.a>> it = this.f37620b.iterator();
        while (it.hasNext()) {
            WeakReference<g.a> next = it.next();
            if (next == null || next.get() == aVar) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.f37622d;
    }
}
