package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
/* loaded from: classes6.dex */
public class AdBaseLinearLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final s.a f34514b = new s.a();

    /* renamed from: a  reason: collision with root package name */
    public View.OnTouchListener f34515a;

    public AdBaseLinearLayout(Context context) {
        super(context);
    }

    public AdBaseLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdBaseLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f34515a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            f34514b.a(getWidth(), getHeight());
            f34514b.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f34514b.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return f34514b;
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.f34515a = onTouchListener;
    }
}
