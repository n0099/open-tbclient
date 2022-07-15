package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.UiThread;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.service.a;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AdBaseFrameLayout extends FrameLayout implements e {
    public static final y.a b = new y.a();
    public List<View.OnTouchListener> a;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.a = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (this.a.contains(onTouchListener)) {
            return;
        }
        this.a.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            b.a(th);
            a.a(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.a.isEmpty()) {
            for (View.OnTouchListener onTouchListener : this.a) {
                onTouchListener.onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            b.a(getWidth(), getHeight());
            b.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            b.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public y.a getTouchCoords() {
        return b;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }
}
