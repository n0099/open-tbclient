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
import com.bumptech.glide.request.target.ViewTarget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Deprecated
/* loaded from: classes6.dex */
public abstract class k<T extends View, Z> extends com.kwad.sdk.glide.request.a.a<Z> {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f36070b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static Integer f36071c;

    /* renamed from: a  reason: collision with root package name */
    public final T f36072a;

    /* renamed from: d  reason: collision with root package name */
    public final a f36073d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public View.OnAttachStateChangeListener f36074e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36076g;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public static Integer f36077a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36078b;

        /* renamed from: c  reason: collision with root package name */
        public final View f36079c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f36080d = new ArrayList();
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ViewTreeObserver$OnPreDrawListenerC0435a f36081e;

        /* renamed from: com.kwad.sdk.glide.request.a.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0435a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference<a> f36082a;

            public ViewTreeObserver$OnPreDrawListenerC0435a(@NonNull a aVar) {
                this.f36082a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f36082a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        public a(@NonNull View view) {
            this.f36079c = view;
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f36078b && this.f36079c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f36079c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.TAG, 4)) {
                Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f36079c.getContext());
        }

        public static int a(@NonNull Context context) {
            if (f36077a == null) {
                Display defaultDisplay = ((WindowManager) com.kwad.sdk.glide.g.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f36077a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f36077a.intValue();
        }

        private void a(int i, int i2) {
            Iterator it = new ArrayList(this.f36080d).iterator();
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
            int paddingTop = this.f36079c.getPaddingTop() + this.f36079c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f36079c.getLayoutParams();
            return a(this.f36079c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f36079c.getPaddingLeft() + this.f36079c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f36079c.getLayoutParams();
            return a(this.f36079c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public void a() {
            if (this.f36080d.isEmpty()) {
                return;
            }
            int d2 = d();
            int c2 = c();
            if (b(d2, c2)) {
                a(d2, c2);
                b();
            }
        }

        public void a(@NonNull i iVar) {
            int d2 = d();
            int c2 = c();
            if (b(d2, c2)) {
                iVar.a(d2, c2);
                return;
            }
            if (!this.f36080d.contains(iVar)) {
                this.f36080d.add(iVar);
            }
            if (this.f36081e == null) {
                ViewTreeObserver viewTreeObserver = this.f36079c.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0435a viewTreeObserver$OnPreDrawListenerC0435a = new ViewTreeObserver$OnPreDrawListenerC0435a(this);
                this.f36081e = viewTreeObserver$OnPreDrawListenerC0435a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0435a);
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f36079c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f36081e);
            }
            this.f36081e = null;
            this.f36080d.clear();
        }

        public void b(@NonNull i iVar) {
            this.f36080d.remove(iVar);
        }
    }

    public k(@NonNull T t) {
        this.f36072a = (T) com.kwad.sdk.glide.g.j.a(t);
        this.f36073d = new a(t);
    }

    private void a() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f36074e;
        if (onAttachStateChangeListener == null || this.f36076g) {
            return;
        }
        this.f36072a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f36076g = true;
    }

    private void a(@Nullable Object obj) {
        Integer num = f36071c;
        if (num != null) {
            this.f36072a.setTag(num.intValue(), obj);
            return;
        }
        f36070b = true;
        this.f36072a.setTag(obj);
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f36074e;
        if (onAttachStateChangeListener == null || !this.f36076g) {
            return;
        }
        this.f36072a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f36076g = false;
    }

    @Nullable
    private Object g() {
        Integer num = f36071c;
        return num == null ? this.f36072a.getTag() : this.f36072a.getTag(num.intValue());
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        this.f36073d.b();
        if (this.f36075f) {
            return;
        }
        f();
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@NonNull i iVar) {
        this.f36073d.a(iVar);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void a(@Nullable com.kwad.sdk.glide.request.c cVar) {
        a((Object) cVar);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @Nullable
    public com.kwad.sdk.glide.request.c b() {
        Object g2 = g();
        if (g2 != null) {
            if (g2 instanceof com.kwad.sdk.glide.request.c) {
                return (com.kwad.sdk.glide.request.c) g2;
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
        this.f36073d.b(iVar);
    }

    public String toString() {
        return "Target for: " + this.f36072a;
    }
}
