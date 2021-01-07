package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
/* loaded from: classes5.dex */
public class AdBaseLinearLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final s.a f9810b = new s.a();

    /* renamed from: a  reason: collision with root package name */
    private View.OnTouchListener f9811a;

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
        if (this.f9811a != null) {
            this.f9811a.onTouch(this, motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                f9810b.a(getWidth(), getHeight());
                f9810b.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                f9810b.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return f9810b;
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.f9811a = onTouchListener;
    }
}
