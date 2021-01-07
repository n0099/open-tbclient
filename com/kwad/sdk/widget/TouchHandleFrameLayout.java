package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class TouchHandleFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f11148a;

    /* renamed from: b  reason: collision with root package name */
    private GestureDetector.OnGestureListener f11149b;

    public TouchHandleFrameLayout(@NonNull Context context) {
        super(context);
        a();
    }

    public TouchHandleFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f11148a = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.sdk.widget.TouchHandleFrameLayout.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f11149b != null) {
                    return TouchHandleFrameLayout.this.f11149b.onDown(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TouchHandleFrameLayout.this.f11149b != null) {
                    return TouchHandleFrameLayout.this.f11149b.onFling(motionEvent, motionEvent2, f, f2);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f11149b != null) {
                    TouchHandleFrameLayout.this.f11149b.onLongPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TouchHandleFrameLayout.this.f11149b != null) {
                    return TouchHandleFrameLayout.this.f11149b.onScroll(motionEvent, motionEvent2, f, f2);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f11149b != null) {
                    TouchHandleFrameLayout.this.f11149b.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f11149b != null) {
                    return TouchHandleFrameLayout.this.f11149b.onSingleTapUp(motionEvent);
                }
                return false;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11149b != null) {
            this.f11148a.onTouchEvent(motionEvent);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.f11149b = onGestureListener;
    }
}
