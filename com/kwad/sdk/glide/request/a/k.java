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
/* loaded from: classes7.dex */
public abstract class k<T extends View, Z> extends com.kwad.sdk.glide.request.a.a<Z> {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f36479b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static Integer f36480c;

    /* renamed from: a  reason: collision with root package name */
    public final T f36481a;

    /* renamed from: d  reason: collision with root package name */
    public final a f36482d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public View.OnAttachStateChangeListener f36483e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36485g;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class a {
        @Nullable
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public static Integer f36486a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36487b;

        /* renamed from: c  reason: collision with root package name */
        public final View f36488c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f36489d = new ArrayList();
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ViewTreeObserver$OnPreDrawListenerC0421a f36490e;

        /* renamed from: com.kwad.sdk.glide.request.a.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0421a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference<a> f36491a;

            public ViewTreeObserver$OnPreDrawListenerC0421a(@NonNull a aVar) {
                this.f36491a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f36491a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        public a(@NonNull View view) {
            this.f36488c = view;
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f36487b && this.f36488c.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f36488c.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.TAG, 4)) {
                Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f36488c.getContext());
        }

        public static int a(@NonNull Context context) {
            if (f36486a == null) {
                Display defaultDisplay = ((WindowManager) com.kwad.sdk.glide.g.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f36486a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f36486a.intValue();
        }

        private void a(int i2, int i3) {
            Iterator it = new ArrayList(this.f36489d).iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(i2, i3);
            }
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean b(int i2, int i3) {
            return a(i2) && a(i3);
        }

        private int c() {
            int paddingTop = this.f36488c.getPaddingTop() + this.f36488c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f36488c.getLayoutParams();
            return a(this.f36488c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f36488c.getPaddingLeft() + this.f36488c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f36488c.getLayoutParams();
            return a(this.f36488c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public void a() {
            if (this.f36489d.isEmpty()) {
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
            if (!this.f36489d.contains(iVar)) {
                this.f36489d.add(iVar);
            }
            if (this.f36490e == null) {
                ViewTreeObserver viewTreeObserver = this.f36488c.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0421a viewTreeObserver$OnPreDrawListenerC0421a = new ViewTreeObserver$OnPreDrawListenerC0421a(this);
                this.f36490e = viewTreeObserver$OnPreDrawListenerC0421a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0421a);
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f36488c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f36490e);
            }
            this.f36490e = null;
            this.f36489d.clear();
        }

        public void b(@NonNull i iVar) {
            this.f36489d.remove(iVar);
        }
    }

    public k(@NonNull T t) {
        this.f36481a = (T) com.kwad.sdk.glide.g.j.a(t);
        this.f36482d = new a(t);
    }

    private void a() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f36483e;
        if (onAttachStateChangeListener == null || this.f36485g) {
            return;
        }
        this.f36481a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f36485g = true;
    }

    private void a(@Nullable Object obj) {
        Integer num = f36480c;
        if (num != null) {
            this.f36481a.setTag(num.intValue(), obj);
            return;
        }
        f36479b = true;
        this.f36481a.setTag(obj);
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f36483e;
        if (onAttachStateChangeListener == null || !this.f36485g) {
            return;
        }
        this.f36481a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f36485g = false;
    }

    @Nullable
    private Object g() {
        Integer num = f36480c;
        return num == null ? this.f36481a.getTag() : this.f36481a.getTag(num.intValue());
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        this.f36482d.b();
        if (this.f36484f) {
            return;
        }
        f();
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@NonNull i iVar) {
        this.f36482d.a(iVar);
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
        this.f36482d.b(iVar);
    }

    public String toString() {
        return "Target for: " + this.f36481a;
    }
}
