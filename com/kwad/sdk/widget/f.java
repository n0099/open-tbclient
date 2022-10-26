package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes8.dex */
public final class f implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public MotionEvent arc;
    public c ard;
    public GestureDetector kE;
    public View mView;

    public f(Context context, View view2, c cVar) {
        this.mView = view2;
        view2.setOnTouchListener(this);
        this.kE = new GestureDetector(context, this);
        this.ard = cVar;
    }

    public f(View view2, c cVar) {
        if (view2 == null) {
            return;
        }
        this.mView = view2;
        view2.setOnTouchListener(this);
        this.kE = new GestureDetector(view2.getContext(), this);
        this.ard = cVar;
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }

    private boolean a(View view2, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action == 1) {
                MotionEvent motionEvent3 = this.arc;
                if (motionEvent3 != null && a(motionEvent3, motionEvent)) {
                    c cVar = this.ard;
                    if (cVar != null) {
                        cVar.g(view2);
                    }
                    z = true;
                }
                motionEvent2 = null;
            }
            return z;
        }
        motionEvent2 = MotionEvent.obtain(motionEvent);
        this.arc = motionEvent2;
        return z;
    }

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

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        c cVar = this.ard;
        if (cVar != null) {
            cVar.f(this.mView);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view2, MotionEvent motionEvent) {
        boolean onTouchEvent = this.kE.onTouchEvent(motionEvent);
        StringBuilder sb = new StringBuilder("onTouch, ");
        sb.append(motionEvent.getAction());
        sb.append("， handled： ");
        sb.append(onTouchEvent);
        if (onTouchEvent) {
            return true;
        }
        return a(view2, motionEvent);
    }
}
