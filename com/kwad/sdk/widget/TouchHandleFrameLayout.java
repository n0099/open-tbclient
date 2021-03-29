package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class TouchHandleFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public GestureDetector f36822a;

    /* renamed from: b  reason: collision with root package name */
    public GestureDetector.OnGestureListener f36823b;

    public TouchHandleFrameLayout(@NonNull Context context) {
        super(context);
        a();
    }

    public TouchHandleFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f36822a = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.sdk.widget.TouchHandleFrameLayout.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f36823b != null) {
                    return TouchHandleFrameLayout.this.f36823b.onDown(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (TouchHandleFrameLayout.this.f36823b != null) {
                    return TouchHandleFrameLayout.this.f36823b.onFling(motionEvent, motionEvent2, f2, f3);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f36823b != null) {
                    TouchHandleFrameLayout.this.f36823b.onLongPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (TouchHandleFrameLayout.this.f36823b != null) {
                    return TouchHandleFrameLayout.this.f36823b.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f36823b != null) {
                    TouchHandleFrameLayout.this.f36823b.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f36823b != null) {
                    return TouchHandleFrameLayout.this.f36823b.onSingleTapUp(motionEvent);
                }
                return false;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f36823b != null) {
            this.f36822a.onTouchEvent(motionEvent);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.f36823b = onGestureListener;
    }
}
