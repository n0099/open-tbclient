package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class TouchHandleFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f10848a;

    /* renamed from: b  reason: collision with root package name */
    private GestureDetector.OnGestureListener f10849b;

    public TouchHandleFrameLayout(@NonNull Context context) {
        super(context);
        a();
    }

    public TouchHandleFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f10848a = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.sdk.widget.TouchHandleFrameLayout.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f10849b != null) {
                    return TouchHandleFrameLayout.this.f10849b.onDown(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TouchHandleFrameLayout.this.f10849b != null) {
                    return TouchHandleFrameLayout.this.f10849b.onFling(motionEvent, motionEvent2, f, f2);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f10849b != null) {
                    TouchHandleFrameLayout.this.f10849b.onLongPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TouchHandleFrameLayout.this.f10849b != null) {
                    return TouchHandleFrameLayout.this.f10849b.onScroll(motionEvent, motionEvent2, f, f2);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f10849b != null) {
                    TouchHandleFrameLayout.this.f10849b.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.f10849b != null) {
                    return TouchHandleFrameLayout.this.f10849b.onSingleTapUp(motionEvent);
                }
                return false;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f10849b != null) {
            this.f10848a.onTouchEvent(motionEvent);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.f10849b = onGestureListener;
    }
}
