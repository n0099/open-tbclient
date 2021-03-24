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
    public static boolean f35780b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static Integer f35781c;

    /* renamed from: a  reason: collision with root package name */
    public final T f35782a;

    /* renamed from: d  reason: collision with root package name */
    public final a f35783d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public View.OnAttachStateChangeListener f35784e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35785f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35786g;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public static Integer f35787a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35788b;

        /* renamed from: c  reason: collision with root package name */
        public final View f35789c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f35790d = new ArrayList();
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ViewTreeObserver$OnPreDrawListenerC0420a f35791e;

        /* renamed from: com.kwad.sdk.glide.request.a.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0420a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference<a> f35792a;

            public ViewTreeObserver$OnPreDrawListenerC0420a(@NonNull a aVar) {
                this.f35792a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f35792a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        public a(@NonNull View view) {
            this.f35789c = view;
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f35788b && this.f35789c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f35789c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.TAG, 4)) {
                Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f35789c.getContext());
        }

        public static int a(@NonNull Context context) {
            if (f35787a == null) {
                Display defaultDisplay = ((WindowManager) com.kwad.sdk.glide.g.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f35787a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f35787a.intValue();
        }

        private void a(int i, int i2) {
            Iterator it = new ArrayList(this.f35790d).iterator();
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
            int paddingTop = this.f35789c.getPaddingTop() + this.f35789c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f35789c.getLayoutParams();
            return a(this.f35789c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f35789c.getPaddingLeft() + this.f35789c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f35789c.getLayoutParams();
            return a(this.f35789c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public void a() {
            if (this.f35790d.isEmpty()) {
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
            if (!this.f35790d.contains(iVar)) {
                this.f35790d.add(iVar);
            }
            if (this.f35791e == null) {
                ViewTreeObserver viewTreeObserver = this.f35789c.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0420a viewTreeObserver$OnPreDrawListenerC0420a = new ViewTreeObserver$OnPreDrawListenerC0420a(this);
                this.f35791e = viewTreeObserver$OnPreDrawListenerC0420a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0420a);
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f35789c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f35791e);
            }
            this.f35791e = null;
            this.f35790d.clear();
        }

        public void b(@NonNull i iVar) {
            this.f35790d.remove(iVar);
        }
    }

    public k(@NonNull T t) {
        this.f35782a = (T) com.kwad.sdk.glide.g.j.a(t);
        this.f35783d = new a(t);
    }

    private void a() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f35784e;
        if (onAttachStateChangeListener == null || this.f35786g) {
            return;
        }
        this.f35782a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f35786g = true;
    }

    private void a(@Nullable Object obj) {
        Integer num = f35781c;
        if (num != null) {
            this.f35782a.setTag(num.intValue(), obj);
            return;
        }
        f35780b = true;
        this.f35782a.setTag(obj);
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f35784e;
        if (onAttachStateChangeListener == null || !this.f35786g) {
            return;
        }
        this.f35782a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f35786g = false;
    }

    @Nullable
    private Object g() {
        Integer num = f35781c;
        return num == null ? this.f35782a.getTag() : this.f35782a.getTag(num.intValue());
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        this.f35783d.b();
        if (this.f35785f) {
            return;
        }
        f();
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@NonNull i iVar) {
        this.f35783d.a(iVar);
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
        this.f35783d.b(iVar);
    }

    public String toString() {
        return "Target for: " + this.f35782a;
    }
}
