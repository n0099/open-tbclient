package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public final class f implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public View a;
    public GestureDetector b;
    public MotionEvent c;
    public c d;

    public f(Context context, @NonNull View view2, c cVar) {
        this.a = view2;
        view2.setOnTouchListener(this);
        this.b = new GestureDetector(context, this);
        this.d = cVar;
    }

    public f(@NonNull View view2, c cVar) {
        this.a = view2;
        view2.setOnTouchListener(this);
        this.b = new GestureDetector(view2.getContext(), this);
        this.d = cVar;
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
                MotionEvent motionEvent3 = this.c;
                if (motionEvent3 != null && a(motionEvent3, motionEvent)) {
                    c cVar = this.d;
                    if (cVar != null) {
                        cVar.b(view2);
                    }
                    z = true;
                }
                motionEvent2 = null;
            }
            return z;
        }
        motionEvent2 = MotionEvent.obtain(motionEvent);
        this.c = motionEvent2;
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
        c cVar = this.d;
        if (cVar != null) {
            cVar.a_(this.a);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view2, MotionEvent motionEvent) {
        boolean onTouchEvent = this.b.onTouchEvent(motionEvent);
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
