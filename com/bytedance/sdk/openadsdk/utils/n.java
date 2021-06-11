package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes6.dex */
public class n extends TouchDelegate {

    /* renamed from: a  reason: collision with root package name */
    public View f30323a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f30324b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f30325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30326d;

    /* renamed from: e  reason: collision with root package name */
    public int f30327e;

    public n(Rect rect, View view) {
        super(rect, view);
        this.f30324b = rect;
        this.f30327e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.f30325c = rect2;
        int i2 = this.f30327e;
        rect2.inset(-i2, -i2);
        this.f30323a = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z3 = this.f30326d;
                if (z3) {
                    z = this.f30325c.contains(x, y);
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                if (action == 3) {
                    boolean z4 = this.f30326d;
                    this.f30326d = false;
                    z2 = z4;
                }
                z = true;
                z2 = false;
            }
            z = true;
        } else if (this.f30324b.contains(x, y)) {
            this.f30326d = true;
            z = true;
        } else {
            this.f30326d = false;
            z = true;
            z2 = false;
        }
        if (z2) {
            View view = this.f30323a;
            if (z) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f2 = -(this.f30327e * 2);
                motionEvent.setLocation(f2, f2);
            }
            if (view.getVisibility() == 0) {
                return view.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
