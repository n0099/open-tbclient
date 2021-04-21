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
/* loaded from: classes6.dex */
public class AdBaseFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final s.a f34607b = new s.a();

    /* renamed from: a  reason: collision with root package name */
    public View.OnTouchListener f34608a;

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
        View.OnTouchListener onTouchListener = this.f34608a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            f34607b.a(getWidth(), getHeight());
            f34607b.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f34607b.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return f34607b;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.f34608a = onTouchListener;
    }
}
