package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class f implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public GestureDetector GT;
    public MotionEvent aRn;
    public c fs;
    public View mView;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    public f(Context context, @NonNull View view2, c cVar) {
        this.mView = view2;
        view2.setOnTouchListener(this);
        this.GT = new GestureDetector(context, this);
        this.fs = cVar;
    }

    public f(View view2, c cVar) {
        if (view2 == null) {
            return;
        }
        this.mView = view2;
        view2.setOnTouchListener(this);
        this.GT = new GestureDetector(view2.getContext(), this);
        this.fs = cVar;
    }

    private boolean a(View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.aRn = MotionEvent.obtain(motionEvent);
        } else if (action == 1) {
            MotionEvent motionEvent2 = this.aRn;
            if (motionEvent2 != null && a(motionEvent2, motionEvent)) {
                c cVar = this.fs;
                if (cVar != null) {
                    cVar.b(view2);
                }
                z = true;
            }
            this.aRn = null;
        }
        return z;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view2, MotionEvent motionEvent) {
        boolean onTouchEvent = this.GT.onTouchEvent(motionEvent);
        StringBuilder sb = new StringBuilder("onTouch, ");
        sb.append(motionEvent.getAction());
        sb.append("， handled： ");
        sb.append(onTouchEvent);
        if (onTouchEvent) {
            return true;
        }
        return a(view2, motionEvent);
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        boolean z;
        boolean z2;
        if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f) {
            z = true;
        } else {
            z = false;
        }
        if (Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        c cVar = this.fs;
        if (cVar != null) {
            cVar.a(this.mView);
            return true;
        }
        return false;
    }
}
