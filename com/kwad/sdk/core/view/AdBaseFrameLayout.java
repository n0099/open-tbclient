package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.q;
/* loaded from: classes6.dex */
public class AdBaseFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final q.a f33597b = new q.a();

    /* renamed from: a  reason: collision with root package name */
    public View.OnTouchListener f33598a;

    public AdBaseFrameLayout(Context context) {
        super(context);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
            com.kwad.sdk.core.a.a.a(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f33598a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            f33597b.a(getWidth(), getHeight());
            f33597b.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f33597b.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public q.a getTouchCoords() {
        return f33597b;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.f33598a = onTouchListener;
    }
}
