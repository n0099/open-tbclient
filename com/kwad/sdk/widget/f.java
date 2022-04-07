package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class f implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public View a;
    public GestureDetector b;
    public MotionEvent c;
    public d d;

    public f(Context context, @NonNull View view2, d dVar) {
        this.a = view2;
        view2.setOnTouchListener(this);
        this.b = new GestureDetector(context, this);
        this.d = dVar;
    }

    public f(@NonNull View view2, d dVar) {
        this.a = view2;
        view2.setOnTouchListener(this);
        this.b = new GestureDetector(view2.getContext(), this);
        this.d = dVar;
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
                    d dVar = this.d;
                    if (dVar != null) {
                        dVar.b(view2);
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
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        com.kwad.sdk.core.d.a.a("ViewGestureHelper", "onFling");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        com.kwad.sdk.core.d.a.a("ViewGestureHelper", "onSingleTapUp");
        d dVar = this.d;
        if (dVar != null) {
            dVar.a_(this.a);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        boolean onTouchEvent = this.b.onTouchEvent(motionEvent);
        com.kwad.sdk.core.d.a.a("ViewGestureHelper", "onTouch, " + motionEvent.getAction() + "， handled： " + onTouchEvent);
        if (onTouchEvent) {
            return true;
        }
        return a(view2, motionEvent);
    }
}
