package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public GestureDetector f56641b;

    /* renamed from: c  reason: collision with root package name */
    public MotionEvent f56642c;

    /* renamed from: d  reason: collision with root package name */
    public d f56643d;

    public f(Context context, @NonNull View view, d dVar) {
        this.a = view;
        view.setOnTouchListener(this);
        this.f56641b = new GestureDetector(context, this);
        this.f56643d = dVar;
    }

    public f(@NonNull View view, d dVar) {
        this.a = view;
        view.setOnTouchListener(this);
        this.f56641b = new GestureDetector(view.getContext(), this);
        this.f56643d = dVar;
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }

    private boolean a(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action == 1) {
                MotionEvent motionEvent3 = this.f56642c;
                if (motionEvent3 != null && a(motionEvent3, motionEvent)) {
                    d dVar = this.f56643d;
                    if (dVar != null) {
                        dVar.b(view);
                    }
                    z = true;
                }
                motionEvent2 = null;
            }
            return z;
        }
        motionEvent2 = MotionEvent.obtain(motionEvent);
        this.f56642c = motionEvent2;
        return z;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        com.kwad.sdk.core.d.a.a("ViewGestureHelper", "onFling");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        com.kwad.sdk.core.d.a.a("ViewGestureHelper", "onSingleTapUp");
        d dVar = this.f56643d;
        if (dVar != null) {
            dVar.a_(this.a);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouchEvent = this.f56641b.onTouchEvent(motionEvent);
        com.kwad.sdk.core.d.a.a("ViewGestureHelper", "onTouch, " + motionEvent.getAction() + "， handled： " + onTouchEvent);
        if (onTouchEvent) {
            return true;
        }
        return a(view, motionEvent);
    }
}
