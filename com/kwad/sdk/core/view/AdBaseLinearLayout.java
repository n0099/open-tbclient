package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
/* loaded from: classes3.dex */
public class AdBaseLinearLayout extends LinearLayout {
    private static final s.a b = new s.a();

    /* renamed from: a  reason: collision with root package name */
    private View.OnTouchListener f6304a;

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
        if (this.f6304a != null) {
            this.f6304a.onTouch(this, motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                b.a(getWidth(), getHeight());
                b.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                b.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return b;
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.f6304a = onTouchListener;
    }
}
