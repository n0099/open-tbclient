package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
/* loaded from: classes5.dex */
public class RCPVADFrameLayout extends RCPVFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final s.a f11143a = new s.a();

    public RCPVADFrameLayout(@NonNull Context context) {
        super(context);
    }

    public RCPVADFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RCPVADFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                f11143a.a(getWidth(), getHeight());
                f11143a.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                f11143a.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return f11143a;
    }
}
