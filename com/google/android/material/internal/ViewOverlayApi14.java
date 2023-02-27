package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ViewOverlayApi14 implements ViewOverlayImpl {
    public OverlayViewGroup overlayViewGroup;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    /* loaded from: classes7.dex */
    public static class OverlayViewGroup extends ViewGroup {
        public static Method invalidateChildInParentFastMethod;
        public boolean disposed;
        public ArrayList<Drawable> drawables;
        public ViewGroup hostView;
        public View requestingView;
        public ViewOverlayApi14 viewOverlay;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            try {
                invalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        private void assertNotDisposed() {
            if (!this.disposed) {
                return;
            }
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.drawables;
                if (arrayList == null || arrayList.size() == 0) {
                    this.disposed = true;
                    this.hostView.removeView(this);
                }
            }
        }

        public OverlayViewGroup(Context context, ViewGroup viewGroup, View view2, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.drawables = null;
            this.hostView = viewGroup;
            this.requestingView = view2;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.viewOverlay = viewOverlayApi14;
        }

        private void getOffset(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.hostView.getLocationOnScreen(iArr2);
            this.requestingView.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void add(Drawable drawable) {
            assertNotDisposed();
            if (this.drawables == null) {
                this.drawables = new ArrayList<>();
            }
            if (!this.drawables.contains(drawable)) {
                this.drawables.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        public void remove(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.drawables;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                disposeIfEmpty();
            }
        }

        @Override // android.view.View
        public boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            if (!super.verifyDrawable(drawable) && ((arrayList = this.drawables) == null || !arrayList.contains(drawable))) {
                return false;
            }
            return true;
        }

        public void add(View view2) {
            assertNotDisposed();
            if (view2.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != this.hostView && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.hostView.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view2, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view2, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view2);
                if (view2.getParent() != null) {
                    viewGroup.removeView(view2);
                }
            }
            super.addView(view2);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int size;
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.hostView.getLocationOnScreen(iArr);
            this.requestingView.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.drawables;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            for (int i = 0; i < size; i++) {
                this.drawables.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.hostView != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.hostView != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    getOffset(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent invalidateChildInParentFast(int i, int i2, Rect rect) {
            if (this.hostView != null && invalidateChildInParentFastMethod != null) {
                try {
                    getOffset(new int[2]);
                    invalidateChildInParentFastMethod.invoke(this.hostView, Integer.valueOf(i), Integer.valueOf(i2), rect);
                    return null;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        public void remove(View view2) {
            super.removeView(view2);
            disposeIfEmpty();
        }
    }

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view2) {
        this.overlayViewGroup = new OverlayViewGroup(context, viewGroup, view2, this);
    }

    public static ViewOverlayApi14 createFrom(View view2) {
        ViewGroup contentView = ViewUtils.getContentView(view2);
        if (contentView != null) {
            int childCount = contentView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = contentView.getChildAt(i);
                if (childAt instanceof OverlayViewGroup) {
                    return ((OverlayViewGroup) childAt).viewOverlay;
                }
            }
            return new ViewGroupOverlayApi14(contentView.getContext(), contentView, view2);
        }
        return null;
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.overlayViewGroup.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.overlayViewGroup.remove(drawable);
    }
}
