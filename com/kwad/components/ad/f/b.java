package com.kwad.components.ad.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class b {
    public com.kwad.sdk.core.g.d eg;
    public CopyOnWriteArrayList<C0585b> md = new CopyOnWriteArrayList<>();
    public int me;

    /* loaded from: classes10.dex */
    public interface c {
        void f(double d);
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static final b mh = new b();
    }

    /* renamed from: com.kwad.components.ad.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0585b {
        public final c mi;
        public final WeakReference<View> mj;

        public C0585b(c cVar, View view2) {
            this.mj = new WeakReference<>(view2);
            this.mi = cVar;
        }
    }

    public static b ek() {
        return a.mh;
    }

    private void a(float f, Context context) {
        this.eg = new com.kwad.sdk.core.g.d(f);
        this.md = new CopyOnWriteArrayList<>();
        this.eg.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.f.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                if (b.this.md == null) {
                    return;
                }
                b.this.e(d);
                bn.a(new Runnable() { // from class: com.kwad.components.ad.f.b.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                        b.this.eg.El();
                    }
                }, null, 500L);
            }
        });
        this.eg.e(f);
        this.eg.bi(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d) {
        CopyOnWriteArrayList<C0585b> copyOnWriteArrayList = this.md;
        int Bb = (int) (com.kwad.sdk.core.config.d.Bb() * 100.0f);
        if (!copyOnWriteArrayList.isEmpty()) {
            int i = Integer.MAX_VALUE;
            Iterator<C0585b> it = copyOnWriteArrayList.iterator();
            C0585b c0585b = null;
            C0585b c0585b2 = null;
            while (it.hasNext()) {
                C0585b next = it.next();
                WeakReference weakReference = next.mj;
                if (weakReference != null) {
                    Rect rect = new Rect();
                    if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bq.o((View) weakReference.get(), Bb)) {
                        int i2 = this.me / 2;
                        int min = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                        if (min < i) {
                            c0585b = next;
                            i = min;
                        } else if (min == i) {
                            c0585b2 = next;
                        }
                    }
                }
            }
            if (c0585b != null) {
                if (c0585b2 != null) {
                    Rect rect2 = new Rect();
                    ((View) c0585b.mj.get()).getGlobalVisibleRect(rect2);
                    Rect rect3 = new Rect();
                    ((View) c0585b2.mj.get()).getGlobalVisibleRect(rect2);
                    if (rect2.top < rect3.top) {
                        c0585b = c0585b2;
                    }
                }
                c0585b.mi.f(d);
            }
        }
    }

    public final void a(float f, View view2, c cVar) {
        if (view2 != null && view2.getContext() != null) {
            if (this.eg == null) {
                this.me = com.kwad.sdk.d.a.a.aH(view2.getContext());
                a(f, view2.getContext());
            }
            this.md.add(new C0585b(cVar, view2));
        }
    }

    public final void a(c cVar) {
        Iterator<C0585b> it = this.md.iterator();
        while (it.hasNext()) {
            C0585b next = it.next();
            if (next.mi == cVar) {
                this.md.remove(next);
            }
        }
        com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "sShakeItems size " + this.md.size());
    }
}
