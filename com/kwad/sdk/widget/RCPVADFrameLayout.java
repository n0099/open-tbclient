package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
/* loaded from: classes6.dex */
public class RCPVADFrameLayout extends RCPVFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final s.a f36815a = new s.a();

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
        int action = motionEvent.getAction();
        if (action == 0) {
            f36815a.a(getWidth(), getHeight());
            f36815a.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f36815a.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return f36815a;
    }
}
