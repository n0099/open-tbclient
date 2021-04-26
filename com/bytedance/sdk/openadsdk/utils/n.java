package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes5.dex */
public class n extends TouchDelegate {

    /* renamed from: a  reason: collision with root package name */
    public View f31046a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f31047b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f31048c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31049d;

    /* renamed from: e  reason: collision with root package name */
    public int f31050e;

    public n(Rect rect, View view) {
        super(rect, view);
        this.f31047b = rect;
        this.f31050e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.f31048c = rect2;
        int i2 = this.f31050e;
        rect2.inset(-i2, -i2);
        this.f31046a = view;
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
                boolean z3 = this.f31049d;
                if (z3) {
                    z = this.f31048c.contains(x, y);
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                if (action == 3) {
                    boolean z4 = this.f31049d;
                    this.f31049d = false;
                    z2 = z4;
                }
                z = true;
                z2 = false;
            }
            z = true;
        } else if (this.f31047b.contains(x, y)) {
            this.f31049d = true;
            z = true;
        } else {
            this.f31049d = false;
            z = true;
            z2 = false;
        }
        if (z2) {
            View view = this.f31046a;
            if (z) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f2 = -(this.f31050e * 2);
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
