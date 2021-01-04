package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.s;
/* loaded from: classes5.dex */
public class AdBaseFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final s.a f9807b = new s.a();

    /* renamed from: a  reason: collision with root package name */
    private View.OnTouchListener f9808a;

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
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f9808a != null) {
            this.f9808a.onTouch(this, motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                f9807b.a(getWidth(), getHeight());
                f9807b.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                f9807b.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return f9807b;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.f9808a = onTouchListener;
    }
}
