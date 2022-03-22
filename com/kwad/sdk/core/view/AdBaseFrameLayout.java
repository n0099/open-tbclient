package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.utils.z;
/* loaded from: classes7.dex */
public class AdBaseFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final z.a f39966b = new z.a();
    public View.OnTouchListener a;

    public AdBaseFrameLayout(Context context) {
        super(context);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            a.a(th);
            com.kwad.sdk.core.kwai.a.a(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            f39966b.a(getWidth(), getHeight());
            f39966b.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f39966b.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public z.a getTouchCoords() {
        return f39966b;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.a = onTouchListener;
    }
}
