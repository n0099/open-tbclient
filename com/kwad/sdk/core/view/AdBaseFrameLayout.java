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
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.service.a;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class AdBaseFrameLayout extends FrameLayout implements e {
    public static final aa.a afd = new aa.a();
    public List<View.OnTouchListener> afc;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.afc = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afc = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afc = new ArrayList();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (this.afc.contains(onTouchListener)) {
            return;
        }
        this.afc.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            b.printStackTrace(th);
            a.gatherException(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.afc.isEmpty()) {
            for (View.OnTouchListener onTouchListener : this.afc) {
                onTouchListener.onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            afd.q(getWidth(), getHeight());
            afd.e(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            afd.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public aa.a getTouchCoords() {
        return afd;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }
}
