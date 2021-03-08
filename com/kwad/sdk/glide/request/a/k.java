package com.kwad.sdk.glide.request.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Deprecated
/* loaded from: classes3.dex */
public abstract class k<T extends View, Z> extends com.kwad.sdk.glide.request.a.a<Z> {
    private static boolean b;
    @Nullable
    private static Integer c;

    /* renamed from: a  reason: collision with root package name */
    protected final T f6827a;
    private final a d;
    @Nullable
    private View.OnAttachStateChangeListener e;
    private boolean f;
    private boolean g;

    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class a {
        @Nullable
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        static Integer f6828a;
        boolean b;
        private final View c;
        private final List<i> d = new ArrayList();
        @Nullable
        private ViewTreeObserver$OnPreDrawListenerC1153a e;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.kwad.sdk.glide.request.a.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC1153a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f6829a;

            ViewTreeObserver$OnPreDrawListenerC1153a(@NonNull a aVar) {
                this.f6829a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f6829a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        a(@NonNull View view) {
            this.c = view;
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.b && this.c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 <= 0) {
                if (this.c.isLayoutRequested() || i2 != -2) {
                    return 0;
                }
                if (Log.isLoggable("ViewTarget", 4)) {
                    Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return a(this.c.getContext());
            }
            return i5;
        }

        private static int a(@NonNull Context context) {
            if (f6828a == null) {
                Display defaultDisplay = ((WindowManager) com.kwad.sdk.glide.g.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6828a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6828a.intValue();
        }

        private void a(int i, int i2) {
            Iterator it = new ArrayList(this.d).iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(i, i2);
            }
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean b(int i, int i2) {
            return a(i) && a(i2);
        }

        private int c() {
            int paddingBottom = this.c.getPaddingBottom() + this.c.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            return a(this.c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        private int d() {
            int paddingRight = this.c.getPaddingRight() + this.c.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            return a(this.c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        void a() {
            if (this.d.isEmpty()) {
                return;
            }
            int d = d();
            int c = c();
            if (b(d, c)) {
                a(d, c);
                b();
            }
        }

        void a(@NonNull i iVar) {
            int d = d();
            int c = c();
            if (b(d, c)) {
                iVar.a(d, c);
                return;
            }
            if (!this.d.contains(iVar)) {
                this.d.add(iVar);
            }
            if (this.e == null) {
                ViewTreeObserver viewTreeObserver = this.c.getViewTreeObserver();
                this.e = new ViewTreeObserver$OnPreDrawListenerC1153a(this);
                viewTreeObserver.addOnPreDrawListener(this.e);
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.e);
            }
            this.e = null;
            this.d.clear();
        }

        void b(@NonNull i iVar) {
            this.d.remove(iVar);
        }
    }

    public k(@NonNull T t) {
        this.f6827a = (T) com.kwad.sdk.glide.g.j.a(t);
        this.d = new a(t);
    }

    private void a() {
        if (this.e == null || this.g) {
            return;
        }
        this.f6827a.addOnAttachStateChangeListener(this.e);
        this.g = true;
    }

    private void a(@Nullable Object obj) {
        if (c != null) {
            this.f6827a.setTag(c.intValue(), obj);
            return;
        }
        b = true;
        this.f6827a.setTag(obj);
    }

    private void f() {
        if (this.e == null || !this.g) {
            return;
        }
        this.f6827a.removeOnAttachStateChangeListener(this.e);
        this.g = false;
    }

    @Nullable
    private Object g() {
        return c == null ? this.f6827a.getTag() : this.f6827a.getTag(c.intValue());
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        this.d.b();
        if (this.f) {
            return;
        }
        f();
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@NonNull i iVar) {
        this.d.a(iVar);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void a(@Nullable com.kwad.sdk.glide.request.c cVar) {
        a((Object) cVar);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @Nullable
    public com.kwad.sdk.glide.request.c b() {
        Object g = g();
        if (g != null) {
            if (g instanceof com.kwad.sdk.glide.request.c) {
                return (com.kwad.sdk.glide.request.c) g;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        a();
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void b(@NonNull i iVar) {
        this.d.b(iVar);
    }

    public String toString() {
        return "Target for: " + this.f6827a;
    }
}
